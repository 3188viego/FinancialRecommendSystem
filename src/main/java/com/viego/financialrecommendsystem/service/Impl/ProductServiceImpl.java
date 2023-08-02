package com.viego.financialrecommendsystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.viego.financialrecommendsystem.entity.Product;
import com.viego.financialrecommendsystem.mapper.ProductMapper;
import com.viego.financialrecommendsystem.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements IProductService {

    @Resource
    ProductMapper productMapper;


    @Override
    public Page page(int currentPage, int pageSIze, Product product) {
        Page<Product> page = new Page<>(currentPage,pageSIze);
        LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();
        if (product.getType() != null && !product.getType().equals("")){
            queryWrapper.eq(Product::getType,product.getType());
        }
        if (product.getProductName() != null && !product.getProductName().equals("")){
            queryWrapper.like(Product::getProductName,product.getProductName());
        }
        if (product.getProductId() != null && product.getProductId() != 0){
            queryWrapper.eq(Product::getProductId,product.getProductId());
        }
        return productMapper.selectPage(page,queryWrapper);
    }

    @Override
    public boolean record(String userId, String productId, String type) {
        return productMapper.record(userId,productId,type) == 1;
    }
}
