/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-sp-el
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter3;

import com.huilong.chapter3.dto.Company;
import com.huilong.chapter3.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.util.*;


/**
 * 基础数据访问 api
 */
@Slf4j
@SuppressWarnings("ConstantConditions")
public class SpElApiAppChapter3 {

    public static void main(String[] args) throws NoSuchMethodException {

        ExpressionParser parser = new SpelExpressionParser();

        // 1、字面意思输出
        literalExpressions(parser);

        // 2、访问 bean 字段 、list 数据 、map 数据
        propertiesExpressions(parser);

        //3、构建map
        inlineMaps(parser);

        //4、构建list
        inlineLists(parser);

        //5、创建数组
        createArray(parser);

        //6、调用方法
        invokeMethod(parser);

        //7、构建对象
        constructors(parser);

        //8、获取class
        getClass(parser);

        //9、符号运算
        symbolicOperator(parser);

        //10、 逻辑运算符
        logicalOperators(parser);

        //11、数学运算符
        mathematicalOperators(parser);

        //12、 赋值操作
        setOperator(parser);

        //13、变量操作
        variablesOperator(parser);

        //14、注册函数
        registerFunction(parser);

        //15、三元运算符
        ternaryOperator(parser);

        //16、安全的链式访问
        safeNavigationOperator(parser);

        //17、 集合数据过滤
        collectionSelection(parser);

        // 18、数据投影 lanmbda 的 map
        collectionProjection(parser);
    }


    /**
     * 字面意思输出
     *
     * @param parser
     */
    private static void literalExpressions(ExpressionParser parser) {

        log.info("-----  字面意思输出  -----");

        String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();

        double avogadrosNumber = (Double) parser.parseExpression("6.0221415E+23").getValue();

        int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();

        boolean trueValue = (Boolean) parser.parseExpression("true").getValue();

        Object nullValue = parser.parseExpression("null").getValue();

        log.info("字面意思输出 {} {} {} {} {} \n", helloWorld, avogadrosNumber, maxValue, trueValue, nullValue);

    }


    /**
     * 访问 bean 字段 、list 数据 、map 数据
     *
     * @param parser
     */
    private static void propertiesExpressions(ExpressionParser parser) {

        log.info("-----  访问 bean、list 、map 的数据   -----");

        Employee employee = new Employee();
        employee.setName("张三");
        employee.setSalary(1000F);

        HashMap<String, String> map = new HashMap<>();
        map.put("name", "huilong");

        StandardEvaluationContext context = new StandardEvaluationContext(employee);
        context.setVariable("list", Arrays.asList(1, 2, 3, 4));
        context.setVariable("map", map);
        context.setVariable("emp", employee);

        Float salary = (Float) parser.parseExpression("#emp.salary + 1900").getValue(context);
        Integer listValue = parser.parseExpression("#list[0]").getValue(context, Integer.class);
        String mapValue = parser.parseExpression("#map['name']").getValue(context, String.class);

        log.info("基础取值操作：emp.salary : {};\tlistValue:{};\tmapValue : {}\n", salary, listValue, mapValue);

    }


    private static void inlineMaps(ExpressionParser parser) {

        log.info("-----  通过字符串创建map   -----");
        StandardEvaluationContext context = new StandardEvaluationContext();

        // evaluates to a Java map containing the two entries
        Map inventorInfo = (Map) parser.parseExpression("{name:'Nikola',dob:'10-July-1856'}").getValue(context);

        Map mapOfMaps = (Map) parser.parseExpression("{name:{first:'Nikola',last:'Tesla'},dob:{day:10,month:'July',year:1856}}").getValue(context);

        log.info("构建map 数据： inventorInfo : {} ,mapOfMaps : {}\n", inventorInfo, mapOfMaps);
    }


    /**
     * 通过字符串创建list
     *
     * @param parser
     */
    private static void inlineLists(ExpressionParser parser) {

        log.info("-----  通过字符串创建list   -----");

        StandardEvaluationContext context = new StandardEvaluationContext();

        List numbers = (List) parser.parseExpression("{1,2,3,4}").getValue(context);

        List listOfLists = (List) parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(context);

        log.info("构建 list 数据： numbers ：{} listOfLists:{}\n", numbers, listOfLists);
    }


    private static void createArray(ExpressionParser parser) {

        log.info("-----  创建数组   -----");

        StandardEvaluationContext context = new StandardEvaluationContext();

        int[] numbers1 = (int[]) parser.parseExpression("new int[4]").getValue(context);

        // 实例化一个数组
        int[] numbers2 = (int[]) parser.parseExpression("new int[]{1,2,3}").getValue(context);

        // 创建多维数组
        int[][] numbers3 = (int[][]) parser.parseExpression("new int[4][5]").getValue(context);

        log.info("创建数组 numbers1 {} numbers2 {} numbers3 {}\n", numbers1, numbers2, numbers3);
    }


    private static void invokeMethod(ExpressionParser parser) {

        log.info("-----  调用对象方法   -----");

        String bc = parser.parseExpression("'abc'.substring(1, 3)").getValue(String.class);

        log.info("调用 substring 方法 {}\n", bc);
    }


    private static void constructors(ExpressionParser parser) {
        log.info("-----  实例化对象   -----");
        Employee employee = parser.parseExpression(
                "new com.huilong.chapter3.dto.Employee()")
                .getValue(Employee.class);

        log.info("employee :{} \n", employee);
    }


    private static void getClass(ExpressionParser parser) {
        log.info("-----  调用静态方法或者获取class   -----");

        Class dateClass = parser.parseExpression("T(java.util.Date)").getValue(Class.class);

        Class stringClass = parser.parseExpression("T(String)").getValue(Class.class);

        boolean trueValue = parser.parseExpression(
                "T(java.math.RoundingMode).CEILING < T(java.math.RoundingMode).FLOOR")
                .getValue(Boolean.class);


        log.info("dateClass ： {} stringClass : {} trueValue :{}\n", dateClass, stringClass, trueValue);
    }


    /**
     * 运算符号
     * 支持的有下列符号
     * <pre>
     *
     * lt (<)
     * gt (>)
     * le (<=)
     * ge (>=)
     * eq (==)
     * ne (!=)
     * div (/)
     * mod (%)
     * not (!).
     * </pre>
     *
     * @param parser
     */
    private static void symbolicOperator(ExpressionParser parser) {

        log.info("----------------  数学运算符  lt (<) ，gt (>)，le (<=)，ge (>=)，eq (==)，ne (!=)，div (/)，mod (%)，not (!).  ----------------");

        // evaluates to true
        boolean trueValue = parser.parseExpression("2 == 2").getValue(Boolean.class);

        // evaluates to false
        boolean falseValue = parser.parseExpression("2 < -5.0").getValue(Boolean.class);

        // evaluates to true
        boolean trueValue2 = parser.parseExpression("'black' < 'block'").getValue(Boolean.class);

        log.info(" 符号运算符 \"2 == 2\" ：{} ,\"2 < -5.0\" ：{} , \"'black' < 'block'\"： {} \n", trueValue, falseValue, trueValue2);
    }


    private static void logicalOperators(ExpressionParser parser) {

        log.info("----------------  逻辑运算符    ----------------");

        // 结果全部为 true ，才返回true
        boolean and = parser.parseExpression("false and true ").getValue(Boolean.class);

        log.info("and \"false and true \" : {}", and);

        // 某一个结果为true ，就返回true
        boolean or = parser.parseExpression("false or true ").getValue(Boolean.class);

        log.info("or \"false or true \" : {}", or);

        // 取反
        boolean not = parser.parseExpression("!true ").getValue(Boolean.class);

        log.info("not \"!true \" ", not);

        boolean and2 = parser.parseExpression("(true and true) and true ").getValue(Boolean.class);

        log.info(" 逻辑运算符 嵌套 and : {}\n", and2);
    }


    private static void mathematicalOperators(ExpressionParser parser) {

        log.info("----------------  数学运算符    ----------------");
        int two = parser.parseExpression("1 + 1").getValue(Integer.class);  // 2

        log.info("加法运算 ：\"1 + 1\" :{}", two);
        String testString = parser.parseExpression(
                "'test' + ' ' + 'string'").getValue(String.class);  // 'test string'

        log.info("字符串拼接 :{}", testString);

        int four = parser.parseExpression("1 - -3").getValue(Integer.class);  // 4

        log.info("减法运算 \"1 - -3\" :{}", four);

        double d = parser.parseExpression("1000.00 - 1e4").getValue(Double.class);  // -9000

        // Multiplication
        int six = parser.parseExpression("-2 * -3").getValue(Integer.class);  // 6

        log.info("乘法运算 \"2.0 * 3e0 * 4\" :{}", six);

        // Division
        int minusTwo = parser.parseExpression("6 / -3").getValue(Integer.class);  // -2

        log.info("除法运算 \"2.0 * 3e0 * 4\": {}", minusTwo);

        // Modulus
        int three = parser.parseExpression("7 % 4").getValue(Integer.class);  // 3


        log.info("取模运算 \"7 % 4\" :{}", three);


        // Operator precedence
        int minusTwentyOne = parser.parseExpression("1+2-3*8").getValue(Integer.class);  // -21

        log.info("有优先级的运算 \"1+2-3*8\" :{}\n", minusTwentyOne);
    }


    /**
     * 赋值操作
     *
     * @param parser
     */

    private static void setOperator(ExpressionParser parser) {
        log.info("----------------  赋值操作  ----------------");

        Employee employee = new Employee();

        log.info("使用api赋值前： {}", employee);

        EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding()
                .withRootObject(employee).build();

        parser.parseExpression("name").setValue(context, employee, "Aleksandar Seovic");

        log.info("使用api赋值后： {}", employee);

        context.setVariable("newName", "尼古拉 特斯拉");

        log.info("使用表达式赋值前：employee ：{}", employee);
        parser.parseExpression("name = #newName").getValue(context, employee);
        log.info("使用表达式赋值后：employee ：{}\n", employee);
    }

    private static void variablesOperator(ExpressionParser parser) {

        log.info("----------------  变量操作.  ----------------");

        List<Integer> primes = new ArrayList<Integer>();
        primes.addAll(Arrays.asList(2, 3, 5, 7, 11, 13, 17));

        // 注册变量
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        context.setVariable("primes", primes);

        log.info("原始数据：{}", primes);
        // 选择变量元素大于10
        List<Integer> primesGreaterThanTen = (List<Integer>) parser.parseExpression(
                "#primes.?[#this>10]").getValue(context);

        log.info("过滤后数据：{} \n", primesGreaterThanTen);
    }

    /**
     * 注册函数
     *
     * @param parser
     * @throws NoSuchMethodException
     */
    private static void registerFunction(ExpressionParser parser) throws NoSuchMethodException {

        log.info("----------------  注册函数.  ----------------");

        Method maxFunction = Math.class.getDeclaredMethod("max", int.class, int.class);

        log.info("注册函数：{}", "myMax");

        StandardEvaluationContext context = new StandardEvaluationContext();
        // 注册函数方法1
        context.setVariable("myMax", maxFunction);
        // 注册函数方法2
        context.registerFunction("myMax2", maxFunction);

        //调用函数
        Integer maxValue1 = parser.parseExpression(
                "#myMax(199,883)").getValue(context, Integer.class);

        Integer maxValue2 = parser.parseExpression(
                "#myMax2(199,883)").getValue(context, Integer.class);

        log.info("调用函数 maxValue1 最大值：{} maxValue2 最大值：{}\n", maxValue1, maxValue2);
    }

    /**
     * 三元运算符
     *
     * @param parser
     */
    private static void ternaryOperator(ExpressionParser parser) {

        log.info("-----  三元运算符  -----");
        String falseString = parser.parseExpression(
                "false ? 'trueExp' : 'falseExp'").getValue(String.class);

        log.info("三元运算符：{}", falseString);
        String name = parser.parseExpression("name?:'Unknown'").getValue(new Employee(), String.class);

        log.info("三元运算符：{}\n", name);
    }


    private static void safeNavigationOperator(ExpressionParser parser) {

        log.info("-----  安全的链式访问  -----");

        Company company = new Company();
        company.setName("xxx有限责任公司");

        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding()
                .withRootObject(company).build();

        // 不会报空指针异常
        String name = parser.parseExpression("managingDirector?.name").getValue(context, String.class);

        log.info("员工名称：{}\n", name);
    }


    /**
     * 集合数据过滤
     *
     * @param parser
     */
    private static void collectionSelection(ExpressionParser parser) {

        log.info("-----  过滤集合类型的数据  -----");

        Employee employee = new Employee();
        employee.setSalary(1000);

        Employee employee2 = new Employee();
        employee2.setSalary(2000);

        Employee employee3 = new Employee();
        employee3.setSalary(3000);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee2);
        employees.add(employee3);

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("employees", employees);
        log.info("list 原始数据：{}", employees);
        // 字符串请用引号  parser.parseExpression("members.?[nationality == 'Serbian']").getValue(societyContext);
        List<Employee> resultList = (List<Employee>) parser.parseExpression("#employees.?[salary > 1000]").getValue(context);
        log.info("list 过滤后结果：{}", resultList);


        HashMap<String, Integer> cityMap = new HashMap<>();

        cityMap.put("北京", 1000);
        cityMap.put("上海", 2000);
        cityMap.put("广州", 3000);
        context.setVariable("cityMap", cityMap);
        log.info("map 原始数据：{}", cityMap);
        /**
         * 循环的类型是 {@link Map.Entry} ,所以可选参数名称只有   value 和 key
         */
        Map<String, Integer> resultMap = (Map<String, Integer>) parser.parseExpression("#cityMap.?[value > 1000]").getValue(context);
        log.info("map 过滤后结果：{} \n", resultMap);
    }


    /**
     * 数据投影 lanmbda 的 map
     *
     * @param parser
     */
    private static void collectionProjection(ExpressionParser parser) {
        log.info("-----  数据投影 lanmbda 的 map  -----");

        Employee employee = new Employee();
        employee.setSalary(1000);

        Employee employee2 = new Employee();
        employee2.setSalary(2000);

        Employee employee3 = new Employee();
        employee3.setSalary(3000);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee2);
        employees.add(employee3);

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("employees", employees);

        List<String> mapValue = (List<String>) parser.parseExpression("#employees.![salary]").getValue(context);

        log.info("投影后的数据 {}", mapValue);
    }

}