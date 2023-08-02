package com.viego.financialrecommendsystem.entity;

import com.viego.financialrecommendsystem.core.BaseEntity;
import lombok.Data;

/**
 * 访问记录实体类
 * @author Viego
 * @date 2023/7/28
 */
@Data
public class AccessRecord extends BaseEntity {
    /*用户id*/
    private Long userId;
    /*产品id*/
    private Long productId;
    /*产品类型*/
    private String productType;
    /*访问次数*/
    private String recordCount;
}
