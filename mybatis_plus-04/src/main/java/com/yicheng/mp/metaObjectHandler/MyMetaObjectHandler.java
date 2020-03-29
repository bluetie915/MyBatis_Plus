package com.yicheng.mp.metaObjectHandler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

// 自定义公共字段填充处理器
public class MyMetaObjectHandler extends MetaObjectHandler {

    // 插入操作自动填充
    public void insertFill(MetaObject metaObject) {
        // 获取到需要被填充的字段的值
        Object fieldValue = getFieldValByName("name", metaObject);
        if (fieldValue == null) {
            System.out.println("------插入操作满足填充条件------");
            setFieldValByName("name", "nobody", metaObject);
        }
    }

    // 修改操作自动填充
    public void updateFill(MetaObject metaObject) {
        // 获取到需要被填充的字段的值
        Object fieldValue = getFieldValByName("name", metaObject);
        if (fieldValue == null) {
            System.out.println("------修改操作满足填充条件------");
            setFieldValByName("name", "nobody", metaObject);
        }
    }
}
