package com.huilong.controller.annotated;

import com.huilong.config.MyWebMvcConfigurer;
import com.huilong.model.vo.R;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.UriComponentsBuilder;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 请求匹配相关
 */
@Slf4j
@RestController
@RequestMapping("/springmvc/request-mapping")
class RequestMappingController {


    /**
     * 入参测试
     *
     * @param pathVariable
     * @param requestParam
     * @param encoding
     * @param cookie
     * @param webRequest
     * @param nativeWebRequest
     * @param servletRequest
     * @param servletResponse
     * @param httpSession
     * @param httpMethod
     * @param locale
     * @param timeZone
     * @param zoneId
     * @param uriComponentsBuilder
     * @return
     */
    @GetMapping("/method-get/{pathQuery}")
    public R methodGet(
            @PathVariable(name = "pathQuery") String pathVariable,
            @RequestParam(name = "requestParam", required = false) String requestParam,
            @RequestHeader("Accept-Encoding") String encoding,
            @ApiParam(type = "cookie") @CookieValue(value = "JSESSIONID", required = false) String cookie,
            @ApiIgnore WebRequest webRequest,
            @ApiIgnore NativeWebRequest nativeWebRequest,
            @ApiIgnore ServletRequest servletRequest,
            @ApiIgnore ServletResponse servletResponse,
            @ApiIgnore HttpSession httpSession,
            @ApiIgnore HttpMethod httpMethod,
            @ApiIgnore Locale locale,
            @ApiIgnore TimeZone timeZone,
            @ApiIgnore ZoneId zoneId,
            @ApiIgnore UriComponentsBuilder uriComponentsBuilder) {

        log.info("get 请求,params：" +
                "\n@PathVariable pathVariable：" + pathVariable + "," +
                "\n@RequestParam requestParam：" + requestParam + "," +
                "\n@RequestHeader encoding：" + encoding + "," +
                "\n@CookieValue cookie：" + cookie + "," +
                "\nwebRequest：" + webRequest + "," +
                "\nnativeWebRequest：" + nativeWebRequest + "," +
                "\nservletRequest：" + servletRequest + "," +
                "\nservletResponse：" + servletResponse + "," +
                "\nhttpSession：" + httpSession + "," +
                "\nhttpMethod：" + httpMethod + "," +
                "\nlocale：" + locale + "," +
                "\ntimeZone：" + timeZone + "," +
                "\nzoneId：" + zoneId + "," +
                "\nuriComponentsBuilder：" + uriComponentsBuilder);

        return R.success();
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
    public R methodGetMatrixVariable(@MatrixVariable(name = "age", pathVar = "id") Integer age,
                                     @PathVariable("id") Integer id) {

        log.info("接受 MatrixVariable 的变量,params:" + "age:" + age + "," + "id:" + id);

        return R.success();
    }


}