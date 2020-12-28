package com.huilong.chapter2;

import com.huilong.chapter2.dto.Employee;
import com.huilong.chapter2.service.HelloService;
import com.huilong.chapter2.service.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


/**
 * 标准的上下文
 */
@Slf4j
public class StandardEvaluationContextAppChapter2 {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.scan("com.huilong.chapter2");
        applicationContext.refresh();

        SpelParserConfiguration config = new SpelParserConfiguration(true, true);
        ExpressionParser parser = new SpelExpressionParser(config);

        Employee employee = new Employee();
        employee.setName("张三");
        employee.setSalary(1000F);


        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();

        //1、注册变量
        standardEvaluationContext.setVariable("zs", employee);

        //2、 引用 spring 容器的bean ，使用 "@" 符号作为前缀进行引用
        setBeanResolver(applicationContext, parser, standardEvaluationContext);

        // 关闭容器
        applicationContext.close();
    }

    private static void setBeanResolver(AnnotationConfigApplicationContext applicationContext, ExpressionParser parser, StandardEvaluationContext standardEvaluationContext) {
        //2、 引用 spring 容器的bean ，使用 "@" 符号作为前缀进行引用
        standardEvaluationContext.setBeanResolver(new BeanFactoryResolver(applicationContext.getBeanFactory()));
        HelloService helloService = (HelloServiceImpl) parser.parseExpression("@helloServiceImpl").getValue(standardEvaluationContext);
        helloService.SayHello("李四");
    }


}