package com.yicheng.mp.mapper;

import com.yicheng.mp.bean.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangyicheng
 * @since 2020-03-29
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    int deleteAll();
}
