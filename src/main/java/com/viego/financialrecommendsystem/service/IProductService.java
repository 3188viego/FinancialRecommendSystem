package com.viego.financialrecommendsystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.viego.financialrecommendsystem.entity.Product;

import java.util.List;

public interface IProductService {
    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSIze 每一页的大小
     * @param product 查询条件
     * @return
     */
    Page page(int currentPage, int pageSIze, Product product);

    boolean record(String userId, String productId, String type);
}
