package com.yicheng.mp.testInjector;

import com.yicheng.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMySqlInjector {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    EmployeeMapper mapper = context.getBean("employeeMapper", EmployeeMapper.class);


    @Test
    public void testMySqlInjector() {
        int flag = mapper.deleteAll();
        System.out.println(flag);
    }
}
