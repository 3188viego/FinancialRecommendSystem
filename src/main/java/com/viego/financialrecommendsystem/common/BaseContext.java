package com.viego.financialrecommendsystem.common;

/**
 * 基于ThreadLocal封装的工具类，用户保存或获取当前登录用户的ID
 */
public class BaseContext {

    private static ThreadLocal<Long> threadLocal=new InheritableThreadLocal<>();

    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
