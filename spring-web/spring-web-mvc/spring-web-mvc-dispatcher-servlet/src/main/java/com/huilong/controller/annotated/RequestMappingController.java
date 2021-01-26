package com.huilong.controller.annotated;

import com.huilong.config.BeanConfig;
import com.huilong.config.MyWebMvcConfigurer;
import com.huilong.model.param.PersonParam;
import com.huilong.model.vo.Person;
import com.huilong.model.vo.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 请求匹配相关
 * <p>
 * 入参支持的变量
 * <pre>
 * 1、   webRequest
 * 2、   nativeWebRequest
 * 3、   servletRequest
 * 4、   servletResponse
 * 5、   httpSession
 * 6、   httpMethod
 * 7、   locale
 * 8、   timeZone
 * 9、   zoneId
 * 10、  uriComponentsBuilder
 * </pre>
 */
@Slf4j
@RestController
@RequestMapping("/springmvc/request-mapping")
class RequestMappingController {

    /**
     * 获取 request Param 的变量
     *
     * @param name
     * @return
     */
    @GetMapping("/method-get/requestParam")
    @Operation(summary = "获取 requestParam 的信息")
    public R<String> requestParam(@Parameter(description = "用户名称") @RequestParam(name = "name") String name) {
        return R.success("request Param :" + name);
    }

    /**
     * 获取 url path 的变量
     *
     * @param version
     * @return
     */
    @GetMapping(value = "/method-get/{version}/pathVariable", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "获取 url path 的信息")
    public R<String> pathVariable(@Parameter(description = "设置 url path 变量", in = ParameterIn.PATH) @PathVariable(name = "version") String version) {
        return R.success("pathVariable :" + version);
    }


    /**
     * 获取 请求头 信息
     *
     * @param encodin
     * @return
     */
    @GetMapping("/method-get/headerVariable")
    @Operation(summary = "获取 请求头 信息")
    public R<String> headerVariable(
            @Parameter(in = ParameterIn.HEADER, description = "设置 请求头 信息") @RequestHeader(value = "User-Agent", defaultValue = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36") String encodin) {
        return R.success("header Variable :" + encodin);
    }


    /**
     * 获取 cookie 信息
     *
     * @param jsessionid
     * @return
     */
    @GetMapping("/method-get/cookieVariable")
    @Operation(summary = "获取 cookie 信息")
    public R<String> cookieVariable(
            @Parameter(in = ParameterIn.COOKIE) @CookieValue(value = "JSESSIONID", defaultValue = "3EC442C6C1DF8B591A1D479669A07703") String jsessionid) {
        return R.success("cookie Variable   :" + jsessionid);
    }


    /**
     * 使用 MatrixVariable ，需要先配置
     * 1、java 代码配置 参考 {@link MyWebMvcConfigurer#configurePathMatch(org.springframework.web.servlet.config.annotation.PathMatchConfigurer)}
     * 2、 <mvc:annotation-driven enable-matrix-variables="true"/>
     *
     * @param age
     * @param id
     * @return
     */
    @GetMapping("/method-get/matrixVariable/{id}")
    @Operation(summary = "获取 matrixVariable 类型变量")
    public R<String> methodGetMatrixVariable(@Parameter(in = ParameterIn.PATH) @MatrixVariable(name = "age", pathVar = "id") Integer age,
                                             @PathVariable("id") Integer id) {

        log.info("接收 MatrixVariable 的变量,params:" + "age:" + age + "," + "id:" + id);

        return R.success("MatrixVariable ： " + age);
    }

    /**
     * json 类型参数获取
     *
     * @param personParam
     * @return
     */
    @PostMapping(value = "/method-post")
    @Operation(summary = "获取 post 方式提交的json 数据")
    public R<Person> post(@RequestBody PersonParam personParam) {
        Person person = new Person();
        BeanUtils.copyProperties(personParam, person);
        return R.success(person);
    }

    /**
     * 文件上传
     * <p>
     * 1、添加 commons-fileupload 依赖到 pom.xml
     * 2  配置 {@link BeanConfig.ConfigFileUpload#getCommonsMultipartResolver()} bean 到 spring 容器
     *
     * @param file
     * @return
     */
    @Operation(summary = "文件上传")
    @PostMapping("/upload")
    public R<String> upload(@RequestParam("file") MultipartFile file) {

        String contentType = file.getContentType();
        String name = file.getName();
        long size = file.getSize();

        return R.success("文件类型 ：" + contentType + "   文件名称：" + name + "  文件大小： " + size);
    }


}