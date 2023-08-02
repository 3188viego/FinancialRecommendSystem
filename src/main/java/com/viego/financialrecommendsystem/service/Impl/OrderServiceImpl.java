package com.viego.financialrecommendsystem.service.Impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.viego.financialrecommendsystem.entity.MyOrder;
import com.viego.financialrecommendsystem.mapper.OrderMapper;
import com.viego.financialrecommendsystem.mapper.ProductMapper;
import com.viego.financialrecommendsystem.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    OrderMapper orderMapper;

    @Resource
    ProductMapper productMapper;

    /**
     * 添加订单
     * @param order 订单对象
     * @return true 添加成功 false 添加失败
     */
    @Override
    public boolean add(MyOrder order) {
        int insert = orderMapper.insert(order);
        return insert != 0;
    }

    /**
     * 根据查询参数进行分页查询【查询条件中有一个时间段，可以根据时间段进行查询】
     * 注意时区问题
     * @param params 查询参数
     * @return page 对象
     */
    @Override
    public Page query(Map<String, Object> params) {
        //TODO 时区转换 解决时差问题
        String startStr = (String) params.get("start"); // 接收日期时间字符串
        String endStr = (String) params.get("end");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC")); // 设置时区为UTC
        Date start = null;
        Date end = null;
        try {
            start = dateFormat.parse(startStr);
            end = dateFormat.parse(endStr);
        } catch (ParseException e) {
            System.out.println("==================================ERROR:日期格式不能为空字符串====================================================");
        }
        Integer currentPage = (Integer)params.get("currentPage");
        Integer pageSize = (Integer)params.get("pageSize");
        Page<MyOrder> myOrderPage = new Page(currentPage.longValue(),pageSize.longValue());
        //下面开始封装条件构造器
        LambdaQueryWrapper<MyOrder> wrapper = new LambdaQueryWrapper<>();
        //设置查询条件，根据productId 来获取productName ====> productId
        if (!params.get("productName").equals("")){//如果产品的名称不是空字符串，就可以添加到条件构造器中
            String productName = (String) params.get("productName");
            Long productId = productMapper.getIdByName(productName);
            wrapper.eq(MyOrder::getProductId,productId);
        }
        //设置查询条件 开始时间 结束时间
        if (!params.get("end").equals("") && !params.get("start").equals("")){
            wrapper.between(MyOrder::getCreateTime,start,end);
        }else if (!params.get("start").equals("")){
            wrapper.between(MyOrder::getCreateTime,start,new Date());
        }
        //设置查询条件 userId
        wrapper.eq(MyOrder::getUserId,params.get("userId"));
        return orderMapper.selectPage(myOrderPage,wrapper);
    }


    //TODO 更无语的是，这里好像只查一个名字就可以了，别的数据貌似都可以从前端拿
    //TODO 默默的把函数返回值类型改掉了 HashMap<String,String> ===> String
    @Override
    public String getDetails(MyOrder order) {
        //产品名称
       return   productMapper.getProductNameById(order.getProductId());
    }

    /**
     * 支付方法
     * @param order 订单对象
     * @return 订单
     */
    @Override
    public boolean pay(MyOrder order) {
        //修改订单状态
        orderMapper.updateStatusById(order.getOrderId());
        return orderMapper.pay(Integer.valueOf(order.getAmount()).longValue(),order.getUserId()) == 1 ;
    }

}
