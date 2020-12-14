# spring 容器 



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

    <bean id="chapter1Service" class="com.huilong.chapter1.service.impl.HelloServiceImpl"/>

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
    <bean id="helloService" class="com.huilong.chapter2.service.impl.HelloServiceImpl"/>
    <bean id="factoryClientService" class="com.huilong.chapter2.service.impl.FactoryServiceImpl"/>


    <!--    静态方法 实例化-->
    <bean id="helloService2" class="com.huilong.chapter2.service.impl.FactoryServiceImpl"
          factory-method="createInstance"/>

    <!--    普通方法，实例化-->

    <bean id="helloService3" factory-bean="factoryClientService" factory-method="createInstance2"></bean>

</beans>
```

### 依赖注入

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

### bean 的生命周期

## 参数


