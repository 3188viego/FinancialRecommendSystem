package com.viego.financialrecommendsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.viego.financialrecommendsystem.core.BaseEntity;
import lombok.Data;

/**
 * 金融理财产品实体类
 * @author viego
 */
@Data
public class Product extends BaseEntity {
    /*产品ID*/
    @TableId(type = IdType.AUTO)
    private Long productId;
    /*产品名称*/
    private String productName;
    /*产品类型*/
    private String type;
    /*产品月收入*/
    private String monthlyIncome;
    /*照片*/
    private String img;
    /*产品风险级别*/
    private String risk;
    /*产品年利率*/
    private float rate;
    /*产品经验*/
    private String exp;
}
