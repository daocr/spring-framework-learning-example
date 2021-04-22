package com.huilong.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author daocr
 * @date 2021/1/10
 */
@Data
public class Staff implements Serializable {

    private String name;

    private String job;

    private Date birthday;

}
