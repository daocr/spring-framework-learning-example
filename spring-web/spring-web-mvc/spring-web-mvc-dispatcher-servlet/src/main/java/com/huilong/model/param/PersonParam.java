package com.huilong.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


/**
 * @author daocr
 * @date 2021/1/10
 */
@Data
@ApiModel(description = "人员")
public class PersonParam {

    @ApiModelProperty(value = "人员 id")
    private Integer id;

    @ApiModelProperty(value = "人员名称")
    private String name;

    @Max(value = 45, message = "最大年龄不能超过 45")
    @Min(value = 18, message = "最小年龄不能低于 18")
    @ApiModelProperty(value = "年龄")
    private Integer age;

}
