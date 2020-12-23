package com.huilong.chapter2;

import com.huilong.chapter2.dto.Company;
import com.huilong.chapter2.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

/**
 * 对 bean 进行包装
 */
@Slf4j
public class BeanWrapperAppChapter2 {

    public static void main(String[] args) {

        BeanWrapper company = new BeanWrapperImpl(new Company());
        //方法1、 设置公司名称
        company.setPropertyValue("name", "Some Company Inc.");
        // 方法2、设置公司名称
        PropertyValue value = new PropertyValue("name", "Some Company Inc.");
        company.setPropertyValue(value);

        // ok, let's create the director and tie it to the company:
        BeanWrapper jim = new BeanWrapperImpl(new Employee());
        jim.setPropertyValue("name", "Jim Stravinsky");
        company.setPropertyValue("managingDirector", jim.getWrappedInstance());

        // 获取员工薪水
        Float salary = (Float) company.getPropertyValue("managingDirector.salary");

        log.info("公司信息：{}", company.getWrappedInstance());
        log.info("员工信息：{}", jim.getWrappedInstance());
        log.info("获取员工薪水 {}", salary);

    }


}