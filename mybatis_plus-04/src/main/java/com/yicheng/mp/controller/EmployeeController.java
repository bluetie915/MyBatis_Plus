package com.yicheng.mp.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yicheng.mp.bean.Employee;
import com.yicheng.mp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangyicheng
 * @since 2020-03-29
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public String select() {
        List<Employee> employees = service.selectList(new EntityWrapper<Employee>().eq("last_name", "zhangsan").eq("gender", "2"));
        System.out.println(employees);
        return "查询成功";
    }
}

