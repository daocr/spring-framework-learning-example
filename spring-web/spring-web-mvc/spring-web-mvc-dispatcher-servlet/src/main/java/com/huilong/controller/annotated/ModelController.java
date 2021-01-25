package com.huilong.controller.annotated;

import com.huilong.model.vo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 设置数据到 model 中，一般用于页面数据渲染
 *
 * @author daocr
 * @date 2021/1/21
 */
@Controller
@RequestMapping("/springmvc/model")
public class ModelController {


    /**
     * @param id
     * @param name
     * @param model
     */
    @GetMapping("/populate-model")
    public ModelAndView populateModel(@RequestParam Integer id, @RequestParam String name) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("annotated/model");
        Person person = new Person();
        person.setId(id);
        person.setName(name);
//        model.addAttribute("person", person);
        modelAndView.addObject("person", person);
        return modelAndView;
//        return "annotated/model";
    }

}
