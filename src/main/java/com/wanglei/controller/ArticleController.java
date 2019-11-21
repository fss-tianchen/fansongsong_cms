package com.wanglei.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanglei.common.CmsAssert;
import com.wanglei.common.MsgResult;
import com.wanglei.entity.Article;
import com.wanglei.entity.Category;
import com.wanglei.service.ArticleService;
import com.wanglei.service.CategoryService;

@Controller
@RequestMapping("article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CategoryService catService; 
	
	@RequestMapping("showdetail")
	public String showDetail(HttpServletRequest request,Integer id) {
		
		Article article = articleService.getById(id); 
		CmsAssert.AssertTrueHtml(article!=null, "文章不存在");
		request.setAttribute("article",article);
		return "article/detail";
	}
	@RequestMapping("getCategoryByChannel")
	@ResponseBody
	public MsgResult getCategoryByChannel(int chnId) {
		List<Category> categories = catService.listByChannelId(chnId);
		return new MsgResult(1, "",  categories);
		
	}
	
}
