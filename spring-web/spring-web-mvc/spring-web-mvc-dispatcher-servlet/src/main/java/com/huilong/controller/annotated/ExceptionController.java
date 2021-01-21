package com.huilong.controller.annotated;

import com.huilong.model.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.io.Writer;
import java.security.Principal;
import java.time.ZoneId;
import java.util.HashMap;
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
    public String toIndex() {
        return "annotated/exception";
    }


    /**
     * 捕获  NumberFormatException
     *
     * @return
     */
    @RequestMapping("trigger-number-format-exception")
    @ResponseBody
    public String triggerNumberFormatException(NumberFormatException e) {
        throw new NumberFormatException("触发 NumberFormatException 异常");
    }


    /**
     * 捕获  NumberFormatException
     * <p>
     * 入参支持类型
     * <pre>
     *     1、捕捉到异常的类型                                        {@link NumberFormatException}
     *     2、抛出异常的 controller method                           {@link HandlerMethod}
     *     3、对 Servlet API 的封装，避免直接只是用Servlet API         {@link WebRequest}
     *     4、对 Servlet API 的封装，避免直接只是用Servlet API         {@link NativeWebRequest}
     *     5、ServletRequest   请求                                 {@link ServletRequest}
     *     5、ServletResponse  响应                                 {@link ServletResponse}
     *     6、会话信息 HttpSession                                  {@link HttpSession}
     *     7、请求方式 例如 get，post                                {@link HttpMethod}
     *     8、地区                                                  {@link Locale}
     *     9、时区                                                  {@link ZoneId}
     *     10、时区                                                 {@link ZoneId}
     *     11、从定向参数信息                                        {@link RedirectAttributes}
     * </pre>
     *
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


        return R.failure("request method : " + httpMethod, "捕捉到 NumberFormatException");
    }


}
