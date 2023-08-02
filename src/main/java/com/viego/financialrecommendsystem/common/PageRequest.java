package com.viego.financialrecommendsystem.common;

import lombok.Data;

@Data
public class PageRequest<T> {
    private int currentPage;
    private int pageSize;
    T object;
}
