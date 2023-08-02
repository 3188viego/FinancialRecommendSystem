package com.viego.financialrecommendsystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.viego.financialrecommendsystem.common.AjaxResult;
import com.viego.financialrecommendsystem.common.BaseContext;
import com.viego.financialrecommendsystem.common.MyPage;
import com.viego.financialrecommendsystem.common.PageRequest;
import com.viego.financialrecommendsystem.entity.Product;
import com.viego.financialrecommendsystem.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    IProductService iProductService;

    /**
     * 产品的分页查询
     * @param pageRequest 封装好的分页查询请求体
     * @return 封装好的 MyPage 对象
     */
    @PostMapping("/page")
    public AjaxResult page(@RequestBody PageRequest<Product> pageRequest){
        log.info("当前用户 UID = {} 正在进行查询", BaseContext.getCurrentId());
        Page page = iProductService.page(pageRequest.getCurrentPage(),
                pageRequest.getPageSize(), pageRequest.getObject());
        MyPage<Product> myPage = new MyPage<Product>(
                pageRequest.getCurrentPage(),
                pageRequest.getPageSize(),
                (int) page.getPages(),
                page.getRecords());
        return AjaxResult.success("查询成功",myPage);
    }

    /**
     * 产品的推荐方法
     * @param params 参数
     * @return 返回一个适合用户的产品
     */
    @PostMapping("/recommend")
    public AjaxResult recommend(@RequestBody Map<String,String> params){
        //1.如果用户有订单，可以根据用户的订单，的平均金额和年限来进行推荐；为用户推荐最好的年限和金额
//        iProductService.
        //2.根据用户传入的params进行产品推荐
        //3.根据用户的点击访问情况来进行推荐产品的类型
        return null;

    }

}
