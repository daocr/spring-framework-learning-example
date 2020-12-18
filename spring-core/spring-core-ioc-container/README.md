# spring 容器 



[TOC]



## 简介

## 环境配置


maven 依赖配置

```xml
<properties>
    <spring.framework.version>5.3.2</spring.framework.version>
</properties>

<dependencies>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>${spring.framework.version}</version>
    </dependency>
</dependencies>
```


## 功能点
### 1、xml 初始化容器

```java
public class Chapter1App {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter1/application.xml");

        Chapter1Service bean = applicationContext.getBean(Chapter1Service.class);

        bean.SayHello("张三");
    }
}
```

文件路径 resources/chapter1/application.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--    引入其他 配置文件-->
    <!--    <import resource="services.xml"/>-->

    <bean id="chapter1Service" class="com.huilong.chapter1.service.impl.HelloService1Impl"/>

</beans>

```

### 2、bean 实例化

```java
public class Chapter2App {

    public static void main(String[] args) {

        // 加载配置
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("chapter2/application.xml");

        // 获取 对象
        HelloService bean = classPathXmlApplicationContext.getBean("helloService3", HelloService.class);

        bean.SayHello("张三");

        // 关闭容器
        classPathXmlApplicationContext.close();

    }

}
```
文件路径 resources/chapter2/application.xml
```xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--    无参函数实例化-->
    <bean id="helloService" class="com.huilong.chapter2.service.impl.HelloService2Impl"/>
    <bean id="factoryClientService" class="com.huilong.chapter2.service.impl.FactoryServiceImpl"/>


    <!--    静态方法 实例化-->
    <bean id="helloService2" class="com.huilong.chapter2.service.impl.FactoryServiceImpl"
          factory-method="createInstance"/>

    <!--    普通方法，实例化-->

    <bean id="helloService3" factory-bean="factoryClientService" factory-method="createInstance2"></bean>

</beans>
```

### 3、依赖注入

```java
public class Chapter3App {

    public static void main(String[] args) {

        // 加载配置
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("chapter3/application.xml");

        // 获取 对象
        DependencyInjectionHelloService bean1 = classPathXmlApplicationContext.getBean("dependencyInjectionService", DependencyInjectionHelloService.class);
        bean1.SayHello("张三");

        DependencyInjectionHelloService bean2 = classPathXmlApplicationContext.getBean("dependencyInjectionService2", DependencyInjectionHelloService.class);
        bean2.SayHello("李四");


        ComplexObject bean = classPathXmlApplicationContext.getBean(ComplexObject.class);
        log.info("ComplexObject : {}",bean);

        // 关闭容器
        classPathXmlApplicationContext.close();
    }
}

```
文件路径 resources/chapter3/application.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">


    <!-- 1、   构造器注入-->
    <bean id="dependencyInjectionService" class="com.huilong.chapter3.service.impl.DependencyInjectionServiceImpl">

        <!--        这三种形式是等价的-->

        <!-- 1.1 构造器位置注入-->
        <constructor-arg index="0">
            <value>构造器注入</value>
        </constructor-arg>

        <!-- 1.2 构造器参数类型注入-->
        <!--        <constructor-arg type="java.lang.String">-->
        <!--            <value>构造器注入</value>-->
        <!--        </constructor-arg>-->

        <!-- 1.3 构造器参数名称注入-->
        <!--        <constructor-arg name="desc">-->
        <!--            <value>构造器注入</value>-->
        <!--        </constructor-arg>-->
    </bean>


    <!-- 2、setter 方法注入-->
    <bean id="dependencyInjectionService2" class="com.huilong.chapter3.service.impl.DependencyInjectionServiceImpl">
        <property name="desc">
            <value>setter 方法注入</value>
        </property>
    </bean>

    <bean id="dependencyInjectionService3" class="com.huilong.chapter3.service.impl.DependencyInjectionServiceImpl"
          p:desc="setter 方法注入">
    </bean>

    <!--    2.1 集合数据注入-->

    <bean id="complexObject" class="com.huilong.chapter3.service.impl.ComplexObject" lazy-init="true"
          destroy-method="destroy" init-method="init">
        <property name="adminEmails">
            <props>
                <prop key="administrator">administrator@example.org</prop>
                <prop key="support">support@example.org</prop>
                <prop key="development">development@example.org</prop>
            </props>
        </property>    <!-- results in a setSomeList(java.util.List) call -->
        <property name="someList">
            <list>
                <value>a list element followed by a reference</value>
            </list>
        </property>    <!-- results in a setSomeMap(java.util.Map) call -->
        <property name="someMap">
            <map>
                <entry key="an entry" value="just some string"/>
            </map>
        </property>    <!-- results in a setSomeSet(java.util.Set) call -->
        <property name="someSet">
            <set>
                <value>just some string</value>
            </set>
        </property>
    </bean>
</beans>
```

### 4、bean 的生命周期



### 5、aware 接口



| Name                             | Injected Dependency                                          | Explained in…                                                |
| :------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- |
| `ApplicationContextAware`        | Declaring `ApplicationContext`.                              | [`ApplicationContextAware` and `BeanNameAware`](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-aware) |
| `ApplicationEventPublisherAware` | Event publisher of the enclosing `ApplicationContext`.       | [Additional Capabilities of the `ApplicationContext`](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#context-introduction) |
| `BeanClassLoaderAware`           | Class loader used to load the bean classes.                  | [Instantiating Beans](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-class) |
| `BeanFactoryAware`               | Declaring `BeanFactory`.                                     | [`ApplicationContextAware` and `BeanNameAware`](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-aware) |
| `BeanNameAware`                  | Name of the declaring bean.                                  | [`ApplicationContextAware` and `BeanNameAware`](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-aware) |
| `LoadTimeWeaverAware`            | Defined weaver for processing class definition at load time. | [Load-time Weaving with AspectJ in the Spring Framework](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop-aj-ltw) |
| `MessageSourceAware`             | Configured strategy for resolving messages (with support for parametrization and internationalization). | [Additional Capabilities of the `ApplicationContext`](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#context-introduction) |
| `NotificationPublisherAware`     | Spring JMX notification publisher.                           | [Notifications](https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#jmx-notifications) |
| `ResourceLoaderAware`            | Configured loader for low-level access to resources.         | [Resources](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#resources) |
| `ServletConfigAware`             | Current `ServletConfig` the container runs in. Valid only in a web-aware Spring `ApplicationContext`. | [Spring MVC](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc) |
| `ServletContextAware`            | Current `ServletContext` the container runs in. Valid only in a web-aware Spring `ApplicationContext`. | [Spring MVC](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc) |



`BeanFactory` 与 `ApplicationContext` 不同点



| Feature                                                 | `BeanFactory` | `ApplicationContext` |
| :------------------------------------------------------ | :------------ | :------------------- |
| Bean instantiation/wiring                               | Yes           | Yes                  |
| Integrated lifecycle management                         | No            | Yes                  |
| Automatic `BeanPostProcessor` registration              | No            | Yes                  |
| Automatic `BeanFactoryPostProcessor` registration       | No            | Yes                  |
| Convenient `MessageSource` access (for internalization) | No            | Yes                  |
| Built-in `ApplicationEvent` publication mechanism       | No            | Yes                  |


### 6、扩展点 processor



### 7、基于注解配置spring 容器





#### 7.1 xml 配置与 注解配置对应关系表



| XML                                                          | Annotation      |                                                              |
| ------------------------------------------------------------ | --------------- | ------------------------------------------------------------ |
|                                                              | @Autowired      |                                                              |
|                                                              | @Required       |                                                              |
| `<bean/>`                                                    | @Bean           |                                                              |
| `<beans/>`                                                   | @Configuration  |                                                              |
| `<qualifier/>`                                               | @Qualifier      | 简单条件预选                                                 |
| `<qualifier/>`                                               | @Genre          | 复杂条件预选，需要配合 `<meta/>`标签                         |
|                                                              | @Resource       | 优先通过属性名称，进行注入                                   |
|                                                              | @Value          | 从配置文件中获取值，可以使用sp el 表达式                     |
| `<util:properties location="classpath*:"/>` <br/> `<context:property-placeholder location="classpath*:"/>` | @PropertySource | 加载配置 properties 配置文件                                 |
| `<bean id="" />`                                             | @Component      | 声明bean，如果需要自定义生成bean name 请实现 `BeanNameGenerator` 接口 |
| `<bean id="" />`                                             | @Service        |                                                              |
| `<bean id="" />`                                             | @Repository     |                                                              |
| `<bean init-method=""/>`                                     | @PostConstruct  |                                                              |
| `<bean destroy-method=""/>`                                  | @PreDestroy     |                                                              |
| <context:component-scan base-package=""/>                    | @ComponentScan  | 扫描指定目录注解配置                                         |
|                                                              | `@Import`       | 引入其他配置注解配置类                                       |
| `<import resource="classpath*:" />`                          | @ImportResource | 引入其他xml 配置类                                           |
|                                                              | `@Profile`      | 1、环境变量区分 ，激活环境配置  <br/> 2、ctx.getEnvironment().setActiveProfiles("development");<br/> 3、-Dspring.profiles.active="profile1,profile2" |
|                                                              |                 |                                                              |
|                                                              |                 |                                                              |
|                                                              |                 |                                                              |
|                                                              |                 |                                                              |
|                                                              |                 |                                                              |
|                                                              |                 |                                                              |
|                                                              |                 |                                                              |
|                                                              |                 |                                                              |
|                                                              |                 |                                                              |



#### 7.2 context:component-scan 扫描过滤类型介绍



| Filter Type          | Example Expression           | Description                                                  |
| :------------------- | :--------------------------- | :----------------------------------------------------------- |
| annotation (default) | `org.example.SomeAnnotation` | An annotation to be *present* or *meta-present* at the type level in target components. |
| assignable           | `org.example.SomeClass`      | A class (or interface) that the target components are assignable to (extend or implement). |
| aspectj              | `org.example..*Service+`     | An AspectJ type expression to be matched by the target components. |
| regex                | `org\.example\.Default.*`    | A regex expression to be matched by the target components' class names. |
| custom               | `org.example.MyTypeFilter`   | A custom implementation of the `org.springframework.core.type.TypeFilter` interface. |



#### 7.3 jsr-30 与spring 注解 对应关系表



| Spring              | javax.inject.*        | javax.inject restrictions / comments                         |
| :------------------ | :-------------------- | :----------------------------------------------------------- |
| @Autowired          | @Inject               | `@Inject` has no 'required' attribute. Can be used with Java 8’s `Optional` instead. |
| @Component          | @Named / @ManagedBean | JSR-330 does not provide a composable model, only a way to identify named components. |
| @Scope("singleton") | @Singleton            | The JSR-330 default scope is like Spring’s `prototype`. However, in order to keep it consistent with Spring’s general defaults, a JSR-330 bean declared in the Spring container is a `singleton` by default. In order to use a scope other than `singleton`, you should use Spring’s `@Scope` annotation. `javax.inject` also provides a [@Scope](https://download.oracle.com/javaee/6/api/javax/inject/Scope.html) annotation. Nevertheless, this one is only intended to be used for creating your own annotations. |
| @Qualifier          | @Qualifier / @Named   | `javax.inject.Qualifier` is just a meta-annotation for building custom qualifiers. Concrete `String` qualifiers (like Spring’s `@Qualifier` with a value) can be associated through `javax.inject.Named`. |
| @Value              | -                     | no equivalent                                                |
| @Required           | -                     | no equivalent                                                |
| @Lazy               | -                     | no equivalent                                                |
| ObjectFactory       | Provider              | `javax.inject.Provider` is a direct alternative to Spring’s `ObjectFactory`, only with a shorter `get()` method name. It can also be used in combination with Spring’s `@Autowired` or with non-annotated constructors and setter methods. |



### 8、