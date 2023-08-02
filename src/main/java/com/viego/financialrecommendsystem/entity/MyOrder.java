package com.viego.financialrecommendsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.viego.financialrecommendsystem.core.BaseEntity;
import lombok.Data;

@Data
public class MyOrder extends BaseEntity {
    /*订单号*/
    @TableId(type = IdType.AUTO)
    private Long orderId;
    /*用户ID*/
    private Long userId;
    /*产品id*/
    private Long productId;
    /*年限*/
    private int year;
    /*投标金额*/
    private int amount;
    /*年利率*/
    private float rate;
    /*状态0未支付1支付1*/
    private int status;
}
