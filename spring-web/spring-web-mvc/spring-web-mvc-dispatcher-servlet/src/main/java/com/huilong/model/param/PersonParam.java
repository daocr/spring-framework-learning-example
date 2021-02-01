package com.huilong.model.param;

import com.huilong.controller.validator.group.Insert;
import com.huilong.controller.validator.group.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


/**
 * @author daocr
 * @date 2021/1/10
 */
@Data
@ApiModel(description = "人员")
public class PersonParam {


    @ApiModelProperty(value = "人员 id")
    @NotNull(groups = Update.class)
    @Null(groups = Insert.class)
    private Integer id;

    @ApiModelProperty(value = "人员名称")
    @Length(min = 2, max = 5, groups = Insert.class)
    private String name;

    @Max(value = 45, message = "最大年龄不能超过 45", groups = Insert.class)
    @Min(value = 18, message = "最小年龄不能低于 18", groups = Insert.class)
    @ApiModelProperty(value = "年龄")
    private Integer age;

}
