package com.viego.financialrecommendsystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.viego.financialrecommendsystem.entity.Article;
import com.viego.financialrecommendsystem.entity.Discuss;
import com.viego.financialrecommendsystem.entity.Item;
import com.viego.financialrecommendsystem.entity.Menu;
import com.viego.financialrecommendsystem.mapper.ArticleMapper;
import com.viego.financialrecommendsystem.mapper.DiscussMapper;
import com.viego.financialrecommendsystem.mapper.MenuMapper;
import com.viego.financialrecommendsystem.service.IArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Resource
    ArticleMapper articleMapper;

    @Resource
    MenuMapper menuMapper;

    @Resource
    DiscussMapper discussMapper;

    @Override
    public Article queryById(Long id) {
        return  articleMapper.selectById(id);
    }

    @Override
    public List<Menu> menu() {
        /*菜单列表*/
        List<Menu> menus = menuMapper.selectAll();
        /*文章列表*/
        List<Article> articles = articleMapper.selectList(new QueryWrapper<>());
        /*讨论列表*/
        List<Discuss> discusses = discussMapper.selectList(new QueryWrapper<>());
        menus.forEach(menu -> {
            if (menu.getType().equals("article")){
                //这是用来封装article类的
                for (Article article : articles){
                    if (article.getType().equals(menu.getMenuName())){
                        if (menu.getList() == null){
                            List<Item> items = new ArrayList<>();
                            items.add(new Item(article.getArticleId(),article.getTitle()));
                            menu.setList(items);
                        }else{
                            menu.getList().add(new Item(article.getArticleId(),article.getTitle()));
                        }
                    }
                }
            }else if (menu.getType().equals("discuss")){
                //TODO 封装 discuss 类
                for (Discuss discuss : discusses) {
                    if (discuss.getType().equals(menu.getMenuName())){
                        if (menu.getList() == null){
                            List<Item> items = new ArrayList<>();
                            items.add(new Item(discuss.getDiscussId(),discuss.getTitle()));
                            menu.setList(items);
                        }else{
                            menu.getList().add(new Item(discuss.getDiscussId(),discuss.getTitle()));
                        }
                    }
                }
            }
        });
        return menus;
    }
}
