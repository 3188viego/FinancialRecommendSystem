package com.viego.financialrecommendsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.viego.financialrecommendsystem.core.BaseEntity;
import lombok.Data;

/**
 * 用户实体类
 * @author viego
 */
@Data
public class User extends BaseEntity {
    /*用户ID*/
    @TableId(type = IdType.AUTO)
    private Long userId;
    /*用户名*/
    private String username;
    /*密码*/
    private String password;
    /*电话*/
    private String phone;
    /*头像*/
    private String img;
    /*资产*/
    private int assets;
}
