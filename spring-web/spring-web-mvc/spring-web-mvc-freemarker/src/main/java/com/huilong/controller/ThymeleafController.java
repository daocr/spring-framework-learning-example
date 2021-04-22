package com.huilong.controller;

import com.github.javafaker.Faker;
import com.huilong.vo.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author daocr
 * @date 2021/4/21
 */
@Controller
@RequestMapping("/freemarker")
public class ThymeleafController {


    /**
     * 跳转到首页
     *
     * @return
     */
    @RequestMapping("/to-index")
    public String toIndex(ModelMap model, @RequestParam(name = "userName") String userName) {
        model.put("userName", userName);
        model.put("list", this.list(10));
        return "index";
    }

    private List<Staff> list(int cut) {

        Faker faker = new Faker(Locale.CHINA);

        List<Staff> list = new ArrayList<>();
        for (int i = 0; i < cut; i++) {

            Staff staff = new Staff();
            staff.setBirthday(faker.date().birthday());
            staff.setName(faker.name().fullName());
            staff.setJob(faker.job().field());
            list.add(staff);
        }

        return list;
    }
}
