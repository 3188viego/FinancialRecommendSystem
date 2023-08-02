package com.viego.financialrecommendsystem;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.viego.financialrecommendsystem.entity.*;
import com.viego.financialrecommendsystem.mapper.*;
import com.viego.financialrecommendsystem.service.IArticleService;
import com.viego.financialrecommendsystem.service.Impl.ArticleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class FinancialRecommendSystemApplicationTests {

    @Resource
    MenuMapper menuMapper;

    @Resource
    UserMapper userMapper;

    @Resource
    ProductMapper productMapper;

    @Resource
    OrderMapper orderMapper;

    @Resource
    ArticleMapper articleMapper;

    @Resource
    IArticleService iArticleService;

    @Resource
    DiscussMapper discussMapper;

    @Resource
    IArticleService articleService;

    @Test
    void contextLoads() {
        Page<Product> page = new Page<>(3,4);
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        Page<Product> productPage = productMapper.selectPage(page, queryWrapper);
        System.out.println(productPage.getPages());//获取所有的页数
//        System.out.println(productPage.getRecords());
    }

    @Test
    void test(){
        MyOrder order = new MyOrder();
        order.setUserId(1L);
        order.setAmount(1000);
        order.setStatus(0);
        order.setYear(5);
        int insert = orderMapper.insert(order);
        System.out.println(insert != 0);
    }

    @Test
    void test2(){
        String productNameById = productMapper.getProductNameById(2L);
        System.out.println(productNameById);
    }


    @Test
    void test3(){
        Article article = articleMapper.selectById(1L);
        System.out.println(article);
    }

    @Test
    void test4(){
        List<Menu> list = menuMapper.selectAll();
        System.out.println(list);
    }
    @Test
    void test5(){
        List<Menu> list = iArticleService.menu();
        System.out.println(list);
    }

    @Test
    void test6(){
        Discuss discuss = discussMapper.selectById(1);
        System.out.println(discuss);
    }

    @Test
    void test7(){
        List<Menu> menu = articleService.menu();
    }


}
