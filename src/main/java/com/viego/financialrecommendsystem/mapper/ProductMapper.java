package com.viego.financialrecommendsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.viego.financialrecommendsystem.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {


    //TODO 做到这里我算是明白了，早知道建表的时候就给Order加一个 Product_name 字段了裂开了，心态炸裂~~~
    /**
     * 根据产品的名称获取Id
     * @param productName 产品名称
     * @return
     */
    Long getIdByName(String productName);


    //TODO 写到这里我自己都笑了
    /**
     * 根据产品的id来获取产品的名称
     * @param productId 产品id
     * @return 产品名称
     */
    String getProductNameById(Long productId);

    int record(String userId, String productId, String type);
}
