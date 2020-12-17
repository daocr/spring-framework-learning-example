package com.huilong.chapter7.service.impl;

import com.huilong.chapter7.service.CityService7;
import com.huilong.chapter7.service.DistrictService7;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 区域服务
 *
 * @author daocr
 * @date 2020/12/16
 */

@Primary
@Service
//@Named  //JSR 330 标准
@Slf4j
public class DistrictService7Impl implements DistrictService7 {

    private List<DistrictDto> cache;

    @Autowired(required = true)
//    @Inject  //JSR 330
    private CityService7 cityService7;


    /**
     * 初始化 模拟从外部加载数据
     */
    @PostConstruct
    public void init() {

        cache = new ArrayList<>();

        cache.add(new DistrictDto(1, 5338, "闵行"));
        cache.add(new DistrictDto(1, 5342, "浦东"));
        cache.add(new DistrictDto(1, 5364, "松江"));
        cache.add(new DistrictDto(1, 5384, "杨浦"));
        cache.add(new DistrictDto(1, 5398, "宝山"));

        log.info("初始化区域数据完成 {}", cache);
    }


    /**
     * 模拟释放一些资源
     */
    @PreDestroy
    public void destroy() {
        cache = null;
        log.info("销毁区域数据完成 ！");
    }

    @Override
    public List<String> getDistrictName(Integer cityId) {

        // 模拟从数据库查询数据
        return cache.stream().filter(districtDto -> districtDto.getCityId().equals(cityId)).map(DistrictDto::getDistrictName).collect(Collectors.toList());

    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DistrictDto {

        private Integer cityId;

        private Integer districtId;

        private String districtName;
    }
}
