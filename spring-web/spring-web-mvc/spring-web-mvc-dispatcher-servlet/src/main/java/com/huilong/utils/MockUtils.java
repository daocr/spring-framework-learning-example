package com.huilong.utils;

import com.github.javafaker.Faker;
import com.huilong.model.bo.Staff;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author daocr
 * @date 2021/2/7
 */
public class MockUtils {

    public static Faker fakerWithCN = new Faker(Locale.CHINA);

    private MockUtils() {

    }

    public static Staff mockDynamic() {
        Staff person = new Staff();

        ThreadLocalRandom current = ThreadLocalRandom.current();
        person.setId(current.nextInt());
        person.setName(fakerWithCN.name().fullName());
        person.setAge(current.nextInt());

        return person;
    }

    public static Staff mockStatic() {

        Staff person = new Staff();
        person.setId(1);
        person.setName("张三");
        person.setAge(20);

        return person;
    }
}
