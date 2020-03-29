package com.yicheng.mp.testLogic;

import com.yicheng.mp.bean.User;
import com.yicheng.mp.mapper.EmployeeMapper;
import com.yicheng.mp.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLogicDelete {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    EmployeeMapper employeeMapper = context.getBean("employeeMapper", EmployeeMapper.class);
    UserMapper userMapper = context.getBean("userMapper", UserMapper.class);

    // 测试逻辑删除
    @Test
    public void testLogicDelete() {
//        Integer flag = userMapper.deleteById(1);
//        System.out.println(flag);

        User user = userMapper.selectById(1);
        System.out.println(user);
    }
}
