package com.huilong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author daocr
 * @date 2021/1/8
 */
@Controller
@RequestMapping("/springmvc")
public class Test {
    public Test(){
        System.out.println("a----");
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
