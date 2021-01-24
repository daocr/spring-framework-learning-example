package com.huilong.controller.annotated;

import com.huilong.model.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 异常处理
 *
 * @author daocr
 * @date 2021/1/21
 */
@Slf4j
@Controller
@RequestMapping("/springmvc/exception")
public class ExceptionController {

    /**
     * 跳转到首页
     *
     * @return
     */
    @GetMapping("/to-index")
    public String toIndex() {
        return "annotated/exception";
    }


    /**
     * 捕获  NumberFormatException
     *
     * @return
     */
    @GetMapping("trigger-number-format-exception")
    @ResponseBody
    public String triggerNumberFormatException(NumberFormatException e) {
        throw new NumberFormatException("触发 NumberFormatException 异常");
    }


    /**
     * 捕获  NumberFormatException
     * <p>
     * 入参支持类型
     *
     * @param numberFormatException 捕捉到异常的类型 {@link NumberFormatException}
     * @param handlerMethod         抛出异常的 controller method {@link HandlerMethod}
     * @param webRequest            对 Servlet API 的封装，避免直接只是用Servlet API  {@link WebRequest}
     * @param nativeWebRequest      对 Servlet API 的封装，避免直接只是用Servlet API  {@link NativeWebRequest}
     * @param servletRequest        ServletRequest   请求  {@link ServletRequest}
     * @param servletResponse       ServletResponse  响应  {@link ServletResponse}
     * @param httpSession           会话信息 HttpSession  {@link HttpSession}
     * @param httpMethod            请求方式 例如 get，post {@link HttpMethod}
     * @param locale                地区 {@link Locale}
     * @param timeZone              时区 {@link ZoneId}
     * @param zoneId                时区 {@link ZoneId}
     * @param redirectAttributes    从定向参数信息 {@link RedirectAttributes}
     * @return
     */
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public R numberFormatException(NumberFormatException numberFormatException,
                                   HandlerMethod handlerMethod,
                                   WebRequest webRequest,
                                   NativeWebRequest nativeWebRequest,
                                   ServletRequest servletRequest,
                                   ServletResponse servletResponse,
                                   HttpSession httpSession,
                                   HttpMethod httpMethod,
                                   Locale locale,
                                   TimeZone timeZone,
                                   ZoneId zoneId,
                                   RedirectAttributes redirectAttributes) {

        log.info("捕捉到的异常,params:" + "numberFormatException:" + numberFormatException + "," + "handlerMethod:" + handlerMethod + "," + "webRequest:" + webRequest + "," + "nativeWebRequest:" + nativeWebRequest + "," + "servletRequest:" + servletRequest + "," + "servletResponse:" + servletResponse + "," + "httpSession:" + httpSession + "," + "httpMethod:" + httpMethod + "," + "locale:" + locale + "," + "timeZone:" + timeZone + "," + "zoneId:" + zoneId + "," + "redirectAttributes:" + redirectAttributes);

        return R.failure("request method : " + httpMethod, "捕捉到 NumberFormatException");
    }


}
