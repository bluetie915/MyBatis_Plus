package com.yicheng.mp.testMP;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.yicheng.mp.bean.Employee;
import com.yicheng.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMpDelete {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper mapper = context.getBean("employeeMapper", EmployeeMapper.class);

    // 删除名字为Test并且age为32的用户
    @Test
    public void testMpDeleteWrapper() {
        Wrapper<Employee> wrapperList = new EntityWrapper<Employee>();
        wrapperList.eq("last_name", "Test").eq("age", 32);
        Integer flag = mapper.delete(wrapperList);
        System.out.println(flag);
    }

}
