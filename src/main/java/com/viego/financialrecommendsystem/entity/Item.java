package com.viego.financialrecommendsystem.entity;

import lombok.Data;

@Data
public class Item {
    private  Long id;
    private String name;

    public Item(Long articleId, String title) {
        this.id = articleId;
        this.name = title;
    }
    public Item(){}
}
