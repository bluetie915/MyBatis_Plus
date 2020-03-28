package com.yicheng.mp.testAuto;

import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class TestAuto {

    @Test
    public void testGenerator() {
        // 1.全局配置
        GlobalConfig glConfig = new GlobalConfig();
        glConfig.setActiveRecord(true) // 是否支持AR模式
                .setAuthor("zhangyicheng") // 作者
                .setOutputDir("E:\\Code\\Behand_End\\MyBatis_Plus\\mybatis_plus-03\\src\\main\\java") // 生成路径
                .setFileOverride(true) // 文件覆盖
                .setIdType(IdType.AUTO) // 主键策略
                .setServiceName("%sService") // 设置生成的service接口的名字的首字母是否为I
                                    // IEmployeeService默认接口前面会带个I，可以去掉
                .setBaseResultMap(true)
                .setBaseColumnList(true);
        // 2.数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/mybatis_plus?serverTimezone=UTC")
                .setUsername("root")
                .setPassword("140271");
        // 3.策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) // 全局大写命名
                .setDbColumnUnderline(true) // 指定表名 字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setTablePrefix("tbl_")
                .setInclude("tbl_employee"); // 生成的表
        // 4.包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.yicheng.mp")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("bean")
                .setXml("mapper");
        // 5.整合配置
        AutoGenerator generator = new AutoGenerator();
        generator.setGlobalConfig(glConfig)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);
        // 6.执行
        generator.execute();
    }
}
