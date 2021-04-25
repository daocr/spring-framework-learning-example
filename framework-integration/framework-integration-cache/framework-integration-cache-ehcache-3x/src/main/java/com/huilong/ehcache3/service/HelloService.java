package com.huilong.ehcache3.service;


import com.huilong.ehcache3.model.bo.Staff;
import com.huilong.ehcache3.model.param.StaffParam;

import java.util.List;

/**
 * @author daocr
 * @date 2020/12/14
 * @date 2020/12/14
 */
public interface HelloService {


    /**
     * 查询员工信息
     *
     * @param staffParam
     * @return
     */
    List<Staff> findStaff(StaffParam staffParam);


}
