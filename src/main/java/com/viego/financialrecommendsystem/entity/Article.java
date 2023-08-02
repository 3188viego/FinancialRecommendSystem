package com.viego.financialrecommendsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.viego.financialrecommendsystem.core.BaseEntity;
import lombok.Data;

/**
 * 文章对应的实体类
 * @author Viego
 * @date 2023/7/28
 */
@Data
public class Article extends BaseEntity {
    /*文章id*/
    @TableId(type = IdType.AUTO)
    private Long articleId;
    /*文章标题*/
    private String title;
    /*文章内容*/
    private String content;
    /*文章类型*/
    private String type;
    /*文章作者*/
    private String author;
}
