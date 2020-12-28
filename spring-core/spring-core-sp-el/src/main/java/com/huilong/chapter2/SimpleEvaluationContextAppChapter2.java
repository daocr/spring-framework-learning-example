package com.huilong.chapter2;

import com.huilong.chapter2.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;


/**
 *  受限制的的上下文
 */
@Slf4j
public class SimpleEvaluationContextAppChapter2 {

    public static void main(String[] args) {

        ExpressionParser parser = new SpelExpressionParser();

        //1、 配置 SimpleEvaluationContext
        configSimpleEvaluationContext(parser);

        // 2、通过el 表达修改 bean 的数据
        setValueV1(parser);


    }

    /**
     * 受限制的 el 表达式
     *
     * @see SimpleEvaluationContext#forReadWriteDataBinding() 可读可写
     * @see SimpleEvaluationContext#forReadOnlyDataBinding()  只读
     * @see SimpleEvaluationContext#forPropertyAccessors      自定义范围范围
     */
    private static void setValueV1(ExpressionParser parser) {

        SimpleEvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();

        Employee employee = new Employee();
        employee.setName("张三");
        employee.setSalary(1000F);

        log.info(" 修改前 ：{}", employee);
        // 修改对象数据
        parser.parseExpression("name").setValue(context, employee, "赵六");

        log.info(" 修改后 ：{}", employee);
    }

    /**
     * @see SimpleEvaluationContext.Builder#withRootObject(java.lang.Object) 设置根数据对象
     * @see SimpleEvaluationContext.Builder#withTypedRootObject(java.lang.Object, org.springframework.core.convert.TypeDescriptor) 设置根数据对象，并且明确类型
     * @see SimpleEvaluationContext.Builder#withConversionService(org.springframework.core.convert.ConversionService) 设置数据转换支持的 详情参看  spring-core-type-conversion 项目
     * @see SimpleEvaluationContext.Builder#withTypeConverter(org.springframework.expression.TypeConverter) 设置数据转换
     */

    private static void configSimpleEvaluationContext(ExpressionParser parser) {

        Employee employee = new Employee();
        employee.setName("张三");
        employee.setSalary(1000F);

        SimpleEvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding()
                .withRootObject(employee)
                .build();


        log.info(" 修改前 ：{}", employee);
        // 修改对象数据
        parser.parseExpression("name").setValue(context, employee, "王五");

        log.info(" 修改后 ：{}", employee);

    }

}