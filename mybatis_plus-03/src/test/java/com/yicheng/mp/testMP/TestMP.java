package com.yicheng.mp.testMP;

import com.baomidou.mybatisplus.plugins.Page;
import com.yicheng.mp.bean.Employee;
import com.yicheng.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMP {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper mapper = context.getBean("employeeMapper", EmployeeMapper.class);

    //    测试删除
    @Test
    public void testMpDelete() {
//        通过id删除
//        Integer flag1 = mapper.deleteById(9);
//        System.out.println("通过单个id删除单个结果如下：" + flag1);

//        通过Map封装条件删除
//        Map<String, Object> columnMap = new HashMap<>();
//        columnMap.put("last_name", "Test");
//        columnMap.put("gender", 1);
//        Integer flag2 = mapper.deleteByMap(columnMap);
//        System.out.println("通过Map删除多个结果如下：" + flag2);

//        通过id集合删除多条数据
        List<Integer> idList = new ArrayList<Integer>();
        idList.add(5);
        idList.add(6);
        idList.add(7);
        Integer flag3 = mapper.deleteBatchIds(idList);
        System.out.println("通过id集合删除多个结果如下：" + flag3);
    }

    //    测试查询
    @Test
    public void testMpSelect() {
//        通过id查询
        Employee employee1 = mapper.selectById(3);
        System.out.println("通过id查询的单个结果如下：" + employee1);

//        通过多个列查询
//        问题如下：如果数据库中出现多条数据满足要求，比如年纪大于30的女性，则会出现问题
//        因为查询方法为selectOne()，所以返回值是Employee类型，所以会报错
        Employee employee2 = new Employee();
        employee2.setId(6);
//        employee1.setLastName("Smith");
        employee2.setGender(1);
        Employee employee3 = mapper.selectOne(employee2);
        System.out.println("通过对象查询单个结果如下：" + employee3);

//        通过多个id进行查询，返回一个list
//        此问题如果在MyBatis下查询，需要使用动态sql，在xml中使用<foreach>标签遍历，比较复杂
//        而在此使用的是select * from tbl_employee where id in (?, ?, ?, ?)
        List<Integer> idList = new ArrayList<Integer>();
        idList.add(4);
        idList.add(5);
        idList.add(6);
        idList.add(7);
        List<Employee> employees1 = mapper.selectBatchIds(idList);
        System.out.println("通过id集合查询多个结果如下：" + employees1);

//        通过Map封装条件查询
        Map<String, Object> columnMap = new HashMap<String, Object>();
//        注意此处写的是数据库中表的列名，而不是实体的属性
        columnMap.put("last_name", "Smith");
        columnMap.put("gender", 1);
        List<Employee> employees2 = mapper.selectByMap(columnMap);
        System.out.println("通过Map查询多个结果如下：" + employees2);

//        分页查询
//        但是一般不会用这种查询，因为它的sql语句中没有limit，所以我们还是会选择一些分页插件
        List<Employee> employees3 = mapper.selectPage(new Page<Employee>(2, 2), null);
        System.out.println("分页查询结果如下：" + employees3);
    }

    //    测试更改
    @Test
    public void testMpUpdate() {
        Employee employee = new Employee();
        employee.setId(5);
        employee.setAge(30);
//        如果这个employee没有lastName和gender其他属性，则sql语句中不会有此属性，所以数据库中的内容也不会更改
//        Integer flag1 = mapper.updateById(employee);
//        System.out.println(flag1);

//        此时，如果employee没有lastName和gender其他属性，则sql诗句中也会有这些属性，所以数据库中的这些列会变成null
//        即原始数据被覆盖
        Integer flag2 = mapper.updateAllColumnById(employee);
        System.out.println(flag2);
    }

    //    测试添加
    @Test
    public void testMpInsert() {
        Employee employee = new Employee();
        employee.setLastName("Smith");
        employee.setEmail("smith@qq.com");
        employee.setGender(1);
        employee.setAge(22);
        Integer flag = mapper.insert(employee);
        System.out.println(flag);

//        如果没有lastName或者gender属性，则sql语句中也会有这些属性，只是内容为null
//        相反，insert方法的sql语句中没有这些内容
//        mapper.insertAllColumn(employee);

//        在MyBatis中还需要添加设置才能完成这个功能，但是在mp中可以直接使用
//        获取当前数据在数据库中的主键值
        Integer key = employee.getId();
        System.out.println(key);
    }

    //    测试连接
    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        System.out.println(dataSource);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
