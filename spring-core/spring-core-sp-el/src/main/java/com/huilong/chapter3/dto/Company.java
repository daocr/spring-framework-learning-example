package com.huilong.chapter3.dto;

import lombok.Data;
import lombok.ToString;

/**
 * 公司
 */
@ToString
@Data
public class Company {

    private String name;
    private Employee managingDirector;

}