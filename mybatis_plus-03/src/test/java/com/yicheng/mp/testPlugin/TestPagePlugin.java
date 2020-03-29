package com.yicheng.mp.testPlugin;

import com.baomidou.mybatisplus.plugins.Page;
import com.yicheng.mp.bean.Employee;
import com.yicheng.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestPagePlugin {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    EmployeeMapper mapper = context.getBean("employeeMapper", EmployeeMapper.class);

    // 分页测试
    @Test
    public void testPage() {
        Page<Employee> page = new Page<Employee>(1,2);
        List<Employee> employees = mapper.selectPage(page, null);
        System.out.println(employees);

        System.out.println("------获取分页相关的信息------");
        System.out.println("总条数：" + page.getTotal());
        System.out.println("当前页码：" + page.getCurrent());
        System.out.println("总页码：" + page.getPages());
        System.out.println("每页显示条数：" + page.getSize());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());

        // 将查询的结果直接封装到page对象中
        page.setRecords(employees);
    }
}
