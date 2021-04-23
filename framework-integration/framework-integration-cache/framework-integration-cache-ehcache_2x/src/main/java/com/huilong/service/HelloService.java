package com.huilong.service;

import com.huilong.model.bo.Staff;
import com.huilong.model.param.StaffParam;

import java.util.List;

/**
 * @author daocr
 * @date 2020/12/14
 * @date 2020/12/14
 */
public interface HelloService {


    /**
     * 可能出现缓存穿透
     *
     * @param staffParam
     * @return
     */
    List<Staff> findStaff(StaffParam staffParam);

    /**
     * 带检测是否有其他线程，正对当前资源进行操作
     *
     * @param staffParam
     * @return
     */
    List<Staff> findStaffLock(StaffParam staffParam);

}
