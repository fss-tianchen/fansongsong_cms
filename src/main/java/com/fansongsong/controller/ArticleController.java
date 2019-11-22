package com.fansongsong.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fansongsong.common.CmsAssert;
import com.fansongsong.common.MsgResult;
import com.fansongsong.entity.Article;
import com.fansongsong.entity.Category;
import com.fansongsong.service.ArticleService;
import com.fansongsong.service.CategoryService;

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
