#spring 容器 

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
### xml 初始化容器

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

    <bean id="chapter1Service" class="com.huilong.chapter1.service.impl.Chapter1ServiceImpl"/>

</beans>

```


###



##参数


