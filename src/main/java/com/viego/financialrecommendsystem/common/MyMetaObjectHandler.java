package com.viego.financialrecommendsystem.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 源数据处理器
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入自动填充
     * @param metaObject 填充对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Long currentId = BaseContext.getCurrentId();
        log.info("公共字段自动填充中【insert】");
        log.info(metaObject.toString());
        log.info("已从BaseContext中获取到当前的UID，UID = {}",currentId);
        metaObject.setValue("updateTime", new Date());
        metaObject.setValue("updateBy",String.valueOf(currentId));
        metaObject.setValue("createTime",new Date());
        metaObject.setValue("createBy",String.valueOf(currentId));
    }

    /**
     * 更新自动填充
     * @param metaObject 填充对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Long currentId = BaseContext.getCurrentId();
        log.info("公共字段自动填充中【update】");
        log.info(metaObject.toString());
        log.info("已从BaseContext中获取当前的UID，UID={}",currentId);
        metaObject.setValue("updateTime",LocalDateTime.now());
        metaObject.setValue("updateBy",String.valueOf(currentId));
    }
}
