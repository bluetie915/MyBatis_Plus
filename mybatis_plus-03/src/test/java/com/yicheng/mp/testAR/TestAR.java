package com.yicheng.mp.testAR;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.yicheng.mp.bean.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestAR {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testARInsert() {
        Employee employee = new Employee();
        employee.setLastName("小红");
        employee.setEmail("小红@qq.com");
        employee.setGender(1);
        employee.setAge(34);
        boolean flag = employee.insert();
        System.out.println(flag);
    }

    @Test
    public void testARUpdate() {
        Employee employee = new Employee();
        employee.setId(15);
        employee.setLastName("小红");
        employee.setEmail("小红@qq.com");
        employee.setGender(1);
        employee.setAge(20);
        boolean flag = employee.updateById();
        System.out.println(flag);
    }

    @Test
    public void testARSelect() {
        Employee employee = new Employee();
        Employee result1 = employee.selectById(15);
        System.out.println("查询单个结果result1：" + result1);

        employee.setId(15);
        Employee result2 = employee.selectById();
        System.out.println("查询单个结果result2：" + result2);

        List<Employee> employees1 = employee.selectAll();
        System.out.println("查询所有结果employees1：" + employees1);

        List<Employee> employees2 = employee.selectList(new EntityWrapper().like("last_name", "Test"));
        System.out.println("查询所有结果employees2：" + employees2);

        int result = employee.selectCount(new EntityWrapper().eq("gender", 0));
        System.out.println("gender是0的数据个数：" + result);
    }

    @Test
    public void testARDelete() {
        // 在这里即便数据库中没有该id，也会返回true，默认只要返回 result != null && result >= 0 即为true
        // 也就是说删除不存在的数据在逻辑上也是成功的
        Employee employee = new Employee();
        boolean result1 = employee.deleteById(99);
        System.out.println("删除单个结果result1：" + result1);

        employee.setId(100);
        boolean result2 = employee.deleteById();
        System.out.println("删除单个结果result2：" + result2);

        boolean result3 = employee.delete(new EntityWrapper().like("last_name", "赵"));
        System.out.println("删除单个结果result3：" + result3);
    }

    @Test
    public void testARPage() {
        Employee employee = new Employee();
        Page<Employee> page = employee.selectPage(new Page<Employee>(1, 2), new EntityWrapper<Employee>().like("last_name", "Test"));
        List<Employee> employees = page.getRecords();
        System.out.println(employees);

    }
}
