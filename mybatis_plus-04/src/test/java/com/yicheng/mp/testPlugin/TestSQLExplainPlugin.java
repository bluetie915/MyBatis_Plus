package com.yicheng.mp.testPlugin;

import com.yicheng.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSQLExplainPlugin {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    EmployeeMapper mapper = context.getBean("employeeMapper", EmployeeMapper.class);

    // 拦截删除全表
    @Test
    public void testSQLExplainPlugin() {
        mapper.delete(null);
    }
}
