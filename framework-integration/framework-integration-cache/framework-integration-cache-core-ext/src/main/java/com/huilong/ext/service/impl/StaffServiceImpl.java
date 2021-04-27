/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：framework-integration-cache-ehcache-2x
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.ext.service.impl;


import com.github.javafaker.Faker;
import com.huilong.ext.model.bo.Staff;
import com.huilong.ext.model.param.StaffParam;
import com.huilong.ext.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "myCacheNames")
public class StaffServiceImpl implements StaffService {

    private ReentrantLock lock = new ReentrantLock();

    @Override
    @Cacheable(cacheNames = "myCacheNames", cacheManager = "myCacheManager", unless = "#result == null")
    public List<Staff> findStaff(StaffParam staffParam) {

        log.info("线程：{} 查询数据库成功！{}", Thread.currentThread().getName(), staffParam);
        // 模拟查询数据库
        List<Staff> db = findDb();
        return db;

    }


    /**
     * 模拟查询数据
     *
     * @return
     */
    private List<Staff> findDb() {

        List<Staff> db = new ArrayList<>();
        Faker faker = new Faker(Locale.CHINA);

        for (int i = 0; i < 1000; i++) {
            Staff staff = new Staff();
            staff.setName(faker.name().fullName());
            staff.setCountry(faker.country().name());
            db.add(staff);
        }

        return db;
    }
}
