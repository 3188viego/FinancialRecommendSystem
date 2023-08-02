package com.viego.financialrecommendsystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.viego.financialrecommendsystem.entity.MyOrder;

import java.util.List;
import java.util.Map;

public interface IOrderService {
    /**
     * 添加订单
     * @param order 订单对象
     * @return true添加成功 false添加失败
     */
    boolean add(MyOrder order);

    /**
     * 对订单进行分页查询，查询条件为 productName userId start end
     * @param params 查询参数
     * @return
     */
    Page query(Map<String, Object> params);

    String getDetails(MyOrder order);

    boolean pay(MyOrder order);
}
