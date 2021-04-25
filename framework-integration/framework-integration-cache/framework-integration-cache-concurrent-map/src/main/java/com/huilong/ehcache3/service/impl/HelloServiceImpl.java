package com.huilong.ehcache3.service.impl;

import com.github.javafaker.Faker;
import com.huilong.ehcache3.service.HelloService;
import com.huilong.ext.model.bo.Staff;
import com.huilong.ext.model.param.StaffParam;
import lombok.extern.slf4j.Slf4j;
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
public class HelloServiceImpl implements HelloService {

    private ReentrantLock lock = new ReentrantLock();

    @Override
    @Cacheable(value = "my-cache", cacheManager = "myEhCacheCacheManager", unless = "#result == null")
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
