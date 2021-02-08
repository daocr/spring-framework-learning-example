package com.huilong.controller.validator;

import com.huilong.controller.validator.group.Insert;
import com.huilong.controller.validator.group.Update;
import com.huilong.model.param.StaffParam;
import com.huilong.model.vo.Staff;
import com.huilong.model.vo.R;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;


/**
 * 数据验证 常用注解 查看 package-info.java
 *
 * <pre>
 *
 * 实现原理：
 *    {@link RequestResponseBodyMethodProcessor#resolveArgument(org.springframework.core.MethodParameter, org.springframework.web.method.support.ModelAndViewContainer, org.springframework.web.context.request.NativeWebRequest, org.springframework.web.bind.support.WebDataBinderFactory)}
 * </pre>
 *
 * @author daocr
 * @date 2021/1/20
 */

@RestController
@RequestMapping("/springmvc/validator-post")
@Api(tags = "数据验证")
public class PostValidatorController {


    /**
     * 验证 group  Insert.class 的参数
     *
     * @param personParam
     * @return
     */
    @Operation(summary = "验证 group  Insert.class 的参数")
    @PostMapping("/insert")
    @ResponseBody
    public R<Staff> insert(@Validated(value = Insert.class) @RequestBody StaffParam personParam) {
        Staff person = new Staff();
        person.setAge(personParam.getAge());

        return R.success(person);
    }


    /**
     * 验证 Update  Insert.class 的参数
     *
     * @param personParam
     * @return
     */
    @Operation(summary = "验证 Update  Insert.class 的参数")
    @PostMapping("/update")
    @ResponseBody
    public R<Staff> update(@Validated(value = Update.class) @RequestBody StaffParam personParam) {

        Staff person = new Staff();
        person.setAge(personParam.getAge());

        return R.success(person);
    }

}
