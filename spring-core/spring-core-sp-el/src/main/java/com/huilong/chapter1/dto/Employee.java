package com.huilong.chapter1.dto;

import lombok.Data;
import lombok.ToString;

/**
 * 员工
 */
@ToString
@Data
public class Employee {

    private String name;

    private float salary;

}