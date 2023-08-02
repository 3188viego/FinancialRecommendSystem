package com.viego.financialrecommendsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.viego.financialrecommendsystem.core.BaseEntity;
import lombok.Data;

/**
 *  讨论
 * @Auther: viego
 * @Date: 2023/8/2 15:57
 */
@Data
public class Discuss extends BaseEntity {
    /*讨论的id*/
    @TableId(type = IdType.AUTO)
    private Long discussId;
    /*讨论的标题*/
    private String title;
    /*讨论的作者*/
    private String author;
    /*讨论类型*/
    private String type;

}
