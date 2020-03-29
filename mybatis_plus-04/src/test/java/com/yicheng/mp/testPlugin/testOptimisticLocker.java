package com.yicheng.mp.testPlugin;

import com.yicheng.mp.bean.Employee;
import com.yicheng.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testOptimisticLocker {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    EmployeeMapper mapper = context.getBean("employeeMapper", EmployeeMapper.class);

    // 乐观锁测试
    @Test
    public void testOptimisticLocker() {
        Employee employee = new Employee();
        employee.setId(103);
        employee.setLastName("lisi");
        employee.setEmail("lisi@qq.com");
        employee.setGender("1");
        employee.setAge(25);
        employee.setVersion(3);
        mapper.updateById(employee);
    }
}
