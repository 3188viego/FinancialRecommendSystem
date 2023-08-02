package com.viego.financialrecommendsystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.viego.financialrecommendsystem.common.AjaxResult;
import com.viego.financialrecommendsystem.common.MyPage;
import com.viego.financialrecommendsystem.entity.MyOrder;
import com.viego.financialrecommendsystem.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    IOrderService orderService;

    /**
     * 添加订单
     * @param order 订单对象
     * @return 添加是否成功信息
     */
    @PostMapping("/render")
    public AjaxResult tender(@RequestBody MyOrder order){
        log.info("正在尝试添加订单.....");
        boolean flag = orderService.add(order);
        if (flag){
            log.info("添加成功");
            return AjaxResult.success("添加成功");
        }else{
            log.info("添加失败");
            return AjaxResult.success("添加失败");
        }
    }

    /**
     * 订单的条件分页查询方法
     * @param params 在前端封装好的分页查询参数
     * @return 分页查询 MyPage 对象
     */
    @PostMapping("/query")
    public AjaxResult query(@RequestBody Map<String,Object> params){
        Page page = orderService.query(params);
        MyPage<MyOrder> myPage = new MyPage<MyOrder>(
                (int)params.get("currentPage"),
                (int)params.get("pageSize"),
                (int)page.getPages(),
                page.getRecords());
        return AjaxResult.success("查询成功",myPage);
    }

    /***
     * 查找产品细节
     * @param order 产品对象
     * @return 产品的细节 【目前的产品细节只有产品的名称，所以只查询的产品的名称】
     */
    @PostMapping("/detail")
    public AjaxResult detail(@RequestBody MyOrder order){
       String productName = orderService.getDetails(order);
        return AjaxResult.success("查询成功",productName);
    }

    /**
     * 支付方法
     * @param order 订单对象
     * @return 返回是否支付成功
     */
    @PostMapping("/pay")
    public AjaxResult pay( @RequestBody MyOrder order){
        boolean flag = orderService.pay(order);
        if (flag){
            return AjaxResult.success("支付成功");
        }else{
            return AjaxResult.error("支付失败");
        }
    }

}
