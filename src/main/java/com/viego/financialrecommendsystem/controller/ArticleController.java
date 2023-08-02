package com.viego.financialrecommendsystem.controller;

import com.viego.financialrecommendsystem.common.AjaxResult;
import com.viego.financialrecommendsystem.entity.Article;
import com.viego.financialrecommendsystem.entity.Menu;
import com.viego.financialrecommendsystem.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/article")
@RestController
public class ArticleController {

    @Resource
    IArticleService articleService;

    @GetMapping("/query")
    public AjaxResult query(@RequestParam("articleId") String  articleId){
        log.info("已进入 ArticleController ");
        Long id = Long.parseLong(articleId);
        log.info("要查询的文章的 id = {}",articleId);
        Article article = articleService.queryById(id);
        log.info("文章查询成功~~");
        return AjaxResult.success("文章查询成功",article);
    }

    @GetMapping("/menu")
    public AjaxResult menu(){
        List<Menu> menu = articleService.menu();
        return AjaxResult.success("菜单查询成功",menu);
    }
}
