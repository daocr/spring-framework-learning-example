package com.huilong.chapter4.dto;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * 员工
 */
@Slf4j
@ToString
@Data
public class Employee {

    private String name;

    private float salary;

    private Date birthday;

    public Employee setBirthday(Date birthday) {
        log.info("设置生日成功 {}", birthday);
        this.birthday = birthday;
        return this;
    }
}