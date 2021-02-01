package com.huilong.controller.validator;

import com.huilong.model.param.PersonParam;
import com.huilong.model.vo.Person;
import com.huilong.model.vo.R;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * 数据验证
 *
 * @author daocr
 * @date 2021/1/20
 */

@RestController
@RequestMapping("/springmvc/validator")
@Api(tags = "数据验证")
public class ValidatorController {


    /**
     * 年龄必须大于 18
     *
     * @param personParam
     * @return
     */
    @Operation(summary = "获取 requestParam 的信息")
    @PostMapping("/age-greater-30")
    @ResponseBody
    public R<Person> ageGreater30(@Valid @RequestBody PersonParam personParam ) {

        Person person = new Person();
        person.setAge(personParam.getAge());

        return R.success(person);
    }

}
