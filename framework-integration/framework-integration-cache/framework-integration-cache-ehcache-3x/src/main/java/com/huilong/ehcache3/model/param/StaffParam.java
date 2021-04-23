package com.huilong.ehcache3.model.param;

import lombok.Data;

import java.io.Serializable;


/**
 * @author daocr
 * @date 2021/1/10
 */
@Data

public class StaffParam implements Serializable {


    /**
     * 员工名称
     */
    private String name;

    /**
     * 部门名字
     */
    private String department;


}
