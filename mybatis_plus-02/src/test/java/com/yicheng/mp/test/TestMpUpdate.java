package com.yicheng.mp.test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.yicheng.mp.bean.Employee;
import com.yicheng.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMpUpdate {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper mapper = context.getBean("employeeMapper", EmployeeMapper.class);

    // 修改名字为Test并且年龄为35的信息
    @Test
    public void testMpUpdateWrapper() {
        Employee employee = new Employee();
        employee.setEmail("test@qq.com");
        Wrapper<Employee> wrapperList = new EntityWrapper<>();
        wrapperList.eq("last_name", "Test").eq("age", 35);
        Integer flag = mapper.update(employee, wrapperList);
        System.out.println(flag);
    }
}
