package com.huilong.chapter1;

import com.huilong.chapter1.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;


/**
 * sp el 入门
 */
@Slf4j
public class SpElExpressionParserAppChapter1 {

    public static void main(String[] args) {

        ExpressionParser parser = new SpelExpressionParser();

        // 1、入门例子
        helloWorld(parser);
        //2、 拼接字符串
        concatStr(parser);
        //3、 invokes 'getBytes()'
        invokesMethod(parser);
        //4、 嵌套访问
        accessNestedProperty(parser);
        //5、构造对象
        constructorObject(parser);
        //6、实际应用
        practical(parser);

    }

    private static void practical(ExpressionParser parser) {
        //1、 构建公司对象
        Employee employee = new Employee();
        employee.setName("张三");
        employee.setSalary(1000F);

        //2、 创建表达式
        Expression exp = parser.parseExpression("name");
        //3、通过表达式访问数据对象得到结果
        String name = (String) exp.getValue(employee);

        log.info("实际应用 员工名字：{}", name);
    }

    private static void constructorObject(ExpressionParser parser) {
        Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
        String message = exp.getValue(String.class);

        log.info("创建对象访问数据 :{}", message);
    }

    private static void accessNestedProperty(ExpressionParser parser) {
        // invokes 'getBytes().length'
        Expression exp = parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) exp.getValue();

        log.info("嵌套访问 访问属性 length ：{}", length);
    }


    /**
     * 调用方法
     *
     * @param parser
     */
    private static void invokesMethod(ExpressionParser parser) {
        Expression exp = parser.parseExpression("'Hello World'.bytes");
        byte[] bytes = (byte[]) exp.getValue();
        log.info("调用 bytes方法 {}", bytes);
    }

    /**
     * 拼接字符串
     *
     * @param parser
     */
    private static void concatStr(ExpressionParser parser) {
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        String message = (String) exp.getValue();
        log.info("拼接字符串 : {}", message);
    }

    /**
     * 入门例子
     *
     * @param parser
     */
    private static void helloWorld(ExpressionParser parser) {
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        log.info("message : {}", message);
    }


}