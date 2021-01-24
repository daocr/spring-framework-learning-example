package com.huilong.controller.cors;

import com.huilong.config.MyWebMvcConfigurer;
import com.huilong.model.vo.Person;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * 跨域配置
 * <p>
 * 全局跨域配置 {@link MyWebMvcConfigurer#addCorsMappings(CorsRegistry)}
 *
 * @author daocr
 * @date 2021/1/11
 */
@Slf4j
@RestController
@Api(tags = "跨域 配置 学习")
@RequestMapping("/cors")
public class CorsController {

    /**
     * 允许所有的请求
     *
     * @return
     */
    @CrossOrigin
    @GetMapping("/cors-all")
    public Person corsAll() {
        Person person = new Person();
        person.setId(1);
        person.setName("李四");
        return person;
    }

    /**
     * 只允许 domain2.com 域名过来的请求
     *
     * @return
     */
    @CrossOrigin(origins = {"https://domain2.com"})
    @GetMapping("/allow-domain2")
    public Person allowDomain2() {

        Person person = new Person();
        person.setId(1);
        person.setName("李四");
        return person;

    }

}
