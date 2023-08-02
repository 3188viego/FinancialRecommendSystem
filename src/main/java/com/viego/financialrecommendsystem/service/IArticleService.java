package com.viego.financialrecommendsystem.service;

import com.viego.financialrecommendsystem.entity.Article;
import com.viego.financialrecommendsystem.entity.Menu;

import java.util.List;
import java.util.Map;

public interface IArticleService {

    Article queryById(Long id);

    List<Menu> menu();
}
