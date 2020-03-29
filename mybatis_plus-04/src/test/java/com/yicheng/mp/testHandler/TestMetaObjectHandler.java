package com.yicheng.mp.testHandler;

import com.yicheng.mp.bean.User;
import com.yicheng.mp.mapper.EmployeeMapper;
import com.yicheng.mp.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMetaObjectHandler {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    EmployeeMapper employeeMapper = context.getBean("employeeMapper", EmployeeMapper.class);
    UserMapper userMapper = context.getBean("userMapper", UserMapper.class);

    // 测试公共字段填充
    @Test
    public void testMetaObjectHandler() {
        User user = new User();
        user.setLogicFlag(1);
//        userMapper.insert(user);
        user.setName("zhangsan");
        userMapper.insert(user);
//      修改同上
//      此处注意，如果只想改部分字段，使用时未设置的字段会被默认为自动填充而更改
    }
}
