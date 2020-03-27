package com.yicheng.mp.test;

import com.baomidou.mybatisplus.mapper.Condition;
import com.yicheng.mp.bean.Employee;
import com.yicheng.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestMpSelectCondition {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper mapper = context.getBean("employeeMapper", EmployeeMapper.class);

    @Test
    public void testMpSelectCondition() {
        List<Employee> employees = mapper.selectList(Condition.create().between("age",20, 30).eq("gender", 1));
        System.out.println(employees);
    }
}
