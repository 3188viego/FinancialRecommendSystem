package com.viego.financialrecommendsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.viego.financialrecommendsystem.core.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class Menu extends BaseEntity {
    /*菜单ID*/
    @TableId(type = IdType.AUTO)
    private Long menuId;
    /*菜单名称*/
    private String menuName;
    /*菜单类型*/
    private String type;
    /*菜单的list*/
    List<Item> list;
}
