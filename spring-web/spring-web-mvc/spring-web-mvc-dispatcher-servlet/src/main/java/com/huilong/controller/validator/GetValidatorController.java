package com.huilong.controller.validator;

import com.huilong.config.BeanConfig;
import com.huilong.model.vo.Staff;
import com.huilong.model.vo.R;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;


/**
 * 数据验证 常用注解 查看 package-info.java
 * <p>
 * 通过 aop 实现参数拦截 {@link BeanConfig.Validator#methodValidationPostProcessor()}
 *
 * @author daocr
 * @date 2021/1/20
 */

@RestController
@RequestMapping("/springmvc/validator-get")
@Api(tags = "数据验证")
@Validated
public class GetValidatorController {

    /**
     * @param id
     * @return
     */
    @Operation(summary = "获取数据 ", description = "通过 aop 拦截实现")
    @GetMapping("/get")
    @ResponseBody
    public R<Staff> get(@Validated @Positive @RequestParam Integer id) {
        Staff person = new Staff();
        person.setId(id);
        return R.success(person);
    }

}
