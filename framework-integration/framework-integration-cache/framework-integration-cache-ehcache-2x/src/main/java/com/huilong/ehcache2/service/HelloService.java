/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：framework-integration-cache-ehcache-2x
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.ehcache2.service;


import com.huilong.ext.model.bo.Staff;
import com.huilong.ext.model.param.StaffParam;

import java.util.List;

/**
 * @author daocr
 * @date 2020/12/14
 * @date 2020/12/14
 */
public interface HelloService {


    /**
     * 查询员工
     *
     * @param staffParam
     * @return
     */
    List<Staff> findStaff(StaffParam staffParam);


}
