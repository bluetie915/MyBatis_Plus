package com.yicheng.mp.test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.yicheng.mp.bean.Employee;
import com.yicheng.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestMpSelectWrapper {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper mapper = context.getBean("employeeMapper", EmployeeMapper.class);

    // 条件构造器：查询年龄20-40，名字中有Test的男性，并分页查询显示第2页
    @Test
    public void testSelectWrapper() {
        Wrapper<Employee> wrapperList = new EntityWrapper<>();
        wrapperList.between("age", 20, 40)
                .eq("gender", 1)
                .eq("last_name", "Test");
        List<Employee> employees = mapper.selectPage(new Page<>(2, 2), wrapperList);
        System.out.println(employees);
    }

    // 查询名字中带有“老师”或者邮箱中带有“a”的女用户
    // .or() => gender = ? and last_name like ? or email like ?
    // .orNew() => (gender = ? and last_name like ?) or (email like ?)
    @Test
    public void testSelectList() {
        Wrapper<Employee> wrapperList = new EntityWrapper<>();
        wrapperList.eq("gender", 0)
                .like("last_name", "老师")
                .or()
                .like("email", "a");
        List<Employee> employees = mapper.selectList(wrapperList);
        System.out.println(employees);
    }

    // 查询性别为女的，根据age进行排序（asc/desc），简单分页
    // orderBy()默认是正序，倒序可以用orderByDesc()
    // 也可以用last()在sql语句最后面加上desc  注意有sql注入风险
    @Test
    public void testSelectPage() {
        Wrapper<Employee> wrapperList = new EntityWrapper<>();
        wrapperList.eq("gender", 0).orderBy("age").last("desc");
        List<Employee> employees = mapper.selectList(wrapperList);
        System.out.println(employees);
    }
}
