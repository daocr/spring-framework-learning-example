package com.huilong.ehcache2.model.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 员工信息
 *
 * @author daocr
 * @date 2021/1/10
 */
@Data

public class Staff implements Serializable {

    private Integer id;

    private String name;

    // 国家
    private String country;

    private Integer age;

}
