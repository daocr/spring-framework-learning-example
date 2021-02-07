package com.huilong.utils;

import com.huilong.model.vo.Person;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author daocr
 * @date 2021/2/7
 */
public class MockUtils {

    private MockUtils() {

    }

    public static Person mockDynamic() {
        Person person = new Person();

        ThreadLocalRandom current = ThreadLocalRandom.current();
        person.setId(current.nextInt());
        person.setName(UUID.randomUUID().toString());
        person.setAge(current.nextInt());

        return person;
    }

    public static Person mockStatic() {

        Person person = new Person();
        person.setId(1);
        person.setName("张三");
        person.setAge(20);

        return person;
    }
}
