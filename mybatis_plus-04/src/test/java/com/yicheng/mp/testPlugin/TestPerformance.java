package com.yicheng.mp.testPlugin;

import com.yicheng.mp.bean.Employee;
import com.yicheng.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerformance {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    EmployeeMapper mapper = context.getBean("employeeMapper", EmployeeMapper.class);

    // 性能分析插件，设置最大时间
    @Test
    public void testPerformance() {
        Employee employee = new Employee();
        employee.setLastName("lisi");
        employee.setEmail("lisi@qq.com");
        employee.setGender("0");
        employee.setAge(22);
        mapper.insert(employee);
    }
}
