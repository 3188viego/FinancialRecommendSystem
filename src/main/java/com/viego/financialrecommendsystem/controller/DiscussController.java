package com.viego.financialrecommendsystem.controller;

import com.viego.financialrecommendsystem.common.AjaxResult;
import com.viego.financialrecommendsystem.entity.Comment;
import com.viego.financialrecommendsystem.entity.Discuss;
import com.viego.financialrecommendsystem.service.IArticleService;
import com.viego.financialrecommendsystem.service.IDiscussService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/discuss")
public class DiscussController{

    @Resource
    IDiscussService discussService;

    @GetMapping("/query")
    public AjaxResult query(@RequestParam("discussId") String  discussId){
        long discussID = Long.parseLong(discussId);
        Discuss discuss = discussService.queryById(discussID);
        return AjaxResult.success("查询成功",discuss);
    }

    @GetMapping("/comment")
    public AjaxResult query2(@RequestParam("discussId") String discussId){
        List<Comment> list =  discussService.comment(Long.parseLong(discussId));
        return AjaxResult.success("查询成功",list);
    }

}
