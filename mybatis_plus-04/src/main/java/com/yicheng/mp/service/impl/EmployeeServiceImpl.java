package com.yicheng.mp.service.impl;

import com.yicheng.mp.bean.Employee;
import com.yicheng.mp.mapper.EmployeeMapper;
import com.yicheng.mp.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangyicheng
 * @since 2020-03-29
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    // 不用再进行mapper注入
    /**
     * EmployeeServiceImpl 继承了 ServiceImpl
     * 1.在ServiceImpl中已经完成了Mapper对象的注入，直接在EmployeeServiceImpl中进行使用
     * 2.在ServiceImpl中也帮我们提供了常用的CRUD方法，基本的一些CRUD方法在Serivce中不需要我们自己定义
     */
}
