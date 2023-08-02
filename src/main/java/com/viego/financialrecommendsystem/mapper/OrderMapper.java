package com.viego.financialrecommendsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.viego.financialrecommendsystem.entity.MyOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<MyOrder> {

    /**
     * 支付函数
     * @param amount 支付的金额
     * @return 是否支付成功
     */
    int pay(Long amount, Long userId);


    void updateStatusById(Long orderId);
}
