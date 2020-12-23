package com.huilong.chapter1.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author daocr
 * @date 2020/12/19
 */
@Data
public class PersonDto {

    @NotNull
    @Max(value = 3)
    private Integer age;
}
