package com.huilong.controller.validator;

import com.huilong.controller.validator.group.Insert;
import com.huilong.controller.validator.group.Update;
import com.huilong.model.param.PersonParam;
import com.huilong.model.vo.Person;
import com.huilong.model.vo.R;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 数据验证
 * <pre>
 *
 * 空检查
 *          {@link javax.validation.constraints.Null} 验证对象是否为null
 *          {@link javax.validation.constraints.NotNull} 验证对象是否不为null, 无法查检长度为0的字符串
 *          {@link javax.validation.constraints.NotBlank} 检查约束字符串是不是Null还有被Trim的长度是否大于0, 只对字符串, 且会去掉前后空格.
 *          {@link javax.validation.constraints.NotEmpty} 检查约束元素是否为NULL或者是EMPTY.
 *
 * Booelan检查
 *          {@link javax.validation.constraints.AssertTrue} 验证 Boolean 对象是否为 true
 *          {@link javax.validation.constraints.AssertFalse} 验证 Boolean 对象是否为 false
 *
 * 长度检查
 *          {@link javax.validation.constraints.Size} 验证对象（Array,Collection,Map,String）长度是否在给定的范围之内
 *          {@link org.hibernate.validator.constraints.Length}验证字符串的长度是否在给定的范围之内，包含两端
 *
 * 日期检查
 *          {@link javax.validation.constraints.Past} 限制必须是一个过去的日期
 *          {@link java.util.concurrent.Future}  限制必须是一个将来的日期
 *          {@link javax.validation.constraints.PastOrPresent} 检查是过去还是现在
 *          {@link java.util.regex.Pattern} 验证 String 对象是否符合正则表达式的规则
 *
 * 数值检查：建议使用在Stirng,Integer类型，不建议使用在int类型上，因为表单值为“”时无法转换为int，但可以转换为Stirng为"",Integer为null
 *          {@link javax.validation.constraints.Min} 验证 Number 和 String 对象是否大等于指定的值
 *          {@link  javax.validation.constraints.Max} 验证 Number 和 String 对象是否小等于指定的值
 *          {@link javax.validation.constraints.DecimalMax} 被标注的值必须不大于约束中指定的最大值. 这个约束的参数是一个通过BigDecimal定义的最大值的字符串表示.小数存在精度
 *          {@link javax.validation.constraints.DecimalMin} 被标注的值必须不小于约束中指定的最小值. 这个约束的参数是一个通过BigDecimal定义的最小值的字符串表示.小数存在精度
 *          {@link javax.validation.constraints.Digits} 验证 Number 和 String 的构成是否合法, 验证字符串是否是符合指定格式的数字，interger指定整数精度，fraction指定小数精度。
 *          {@link org.hibernate.validator.constraints.Range} 指定区间
 *          {@link javax.validation.constraints.Negative } 检查是否为负数
 *          {@link javax.validation.constraints.NegativeOrZero} 检查是0还是为负数
 *          {@link javax.validation.constraints.Positive} 检查是否为正数
 *          {@link javax.validation.constraints.PositiveOrZero}检查是0还是为正数
 *
 * 集合：
 *          {@link org.hibernate.validator.constraints.UniqueElements} 集合的元素必须是唯一的
 *
 * 货币
 *          {@link org.hibernate.validator.constraints.Currency} 检查货币单位
 *
 * 信用卡验证
 *          {@link org.hibernate.validator.constraints.CreditCardNumber}
 *
 * 邮箱验证
 *          {@link javax.validation.constraints.Email}
 *
 * url 匹配
 *          {@link org.hibernate.validator.constraints.URL}
 *
 * 嵌套验证 适用复杂场景
 *          {@link javax.validation.Valid} 递归的对关联对象进行校验, 如果关联对象是个集合或者数组, 那么对其中的元素进行递归校验, 如果是一个map, 则对其中的值部分进行校验.(是否进行递归验证)
 *
 * 脚本验证 适用复杂场景
 *         {@link org.hibernate.validator.constraints.ScriptAssert}
 *
 * </pre>
 *
 * @author daocr
 * @date 2021/1/20
 */

@RestController
@RequestMapping("/springmvc/validator")
@Api(tags = "数据验证")
public class ValidatorController {


    /**
     * 验证 group  Insert.class 的参数
     *
     * @param personParam
     * @return
     */
    @Operation(summary = "验证 group  Insert.class 的参数")
    @PostMapping("/insert")
    @ResponseBody
    public R<Person> insert(@Validated(value = Insert.class) @RequestBody PersonParam personParam) {

        Person person = new Person();
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
    public R<Person> update(@Validated(value = Update.class) @RequestBody PersonParam personParam) {

        Person person = new Person();
        person.setAge(personParam.getAge());

        return R.success(person);
    }

}
