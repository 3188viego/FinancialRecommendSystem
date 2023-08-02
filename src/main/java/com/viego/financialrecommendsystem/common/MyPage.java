package com.viego.financialrecommendsystem.common;

import lombok.Data;

import java.util.List;

@Data
public class MyPage<T> {
    List<T> pageList;
    /*当前页码*/
    private int currentPage;
    /*每一页的大小*/
    private int pageSize;
    /*总共的页数*/
    private int totalPage;

    public MyPage(int currentPage, int pageSize, int totalPage, List<T> data) {
        this.pageList = data;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
    }
}
