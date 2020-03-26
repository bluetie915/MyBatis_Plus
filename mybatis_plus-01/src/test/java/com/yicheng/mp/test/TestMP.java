package com.yicheng.mp.test;

import com.yicheng.mp.bean.Employee;
import com.yicheng.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TestMP {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper mapper = context.getBean("employeeMapper", EmployeeMapper.class);

    @Test
    public void testMpUpdate() {
        
    }

    @Test
    public void testMpInsert() {
        Employee employee = new Employee();
        employee.setLastName("Smith");
        employee.setEmail("smith@qq.com");
        employee.setGender(1);
        employee.setAge(22);
        Integer flag = mapper.insert(employee);
        System.out.println(flag);


//        获取当前数据在数据库中的主键值
        Integer key = employee.getId();
        System.out.println(key);
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        System.out.println(dataSource);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
