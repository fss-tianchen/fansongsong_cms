package com.fansongsong.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fansongsong.common.CmsAssert;
import com.fansongsong.common.MsgResult;
import com.fansongsong.entity.Article;
import com.fansongsong.entity.User;
import com.fansongsong.service.ArticleService;
import com.fansongsong.service.UserService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ArticleService  articleService;
	
	
	@RequestMapping("index")
	public String index() {
		return "admin/index";
	}
	
	/**
	 * 
	 * @Title: articles 
	 * @Description: 文章审核
	 * @param request
	 * @param status
	 * @param page
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles")
	public String articles(HttpServletRequest request,
			@RequestParam(defaultValue="-1") int status,
			@RequestParam(defaultValue="1") Integer page) {
		
		PageInfo<Article> articlePage =  articleService.getPageList(status,page);
		request.setAttribute("pageInfo", articlePage);
		request.setAttribute("status", status);
		
		return "admin/article/list";
	}
	
	@RequestMapping("users")
	public String users(HttpServletRequest request,
			@RequestParam(defaultValue="") String name,
			@RequestParam(defaultValue="1") Integer page) {
		
		PageInfo<User> userPage =  userService.getPageList(name,page);
		request.setAttribute("info", userPage);
		request.setAttribute("name", name);
		
		return "admin/user/list";
	}
	
	@ResponseBody
	@RequestMapping("lockuser")
	public MsgResult lock(Integer userId,int status) {
		
		if(status != 0 && status!=1) {
			return new MsgResult(2,"参数无效",null);
		}
		User user  = userService.getUserById(userId);
		if(user == null) {
			return new MsgResult(2,"该用户不存在",null);
		}
		if(user.getLocked()==status) {
			return new MsgResult(2,"无需做该操作",null);
		}
		
		int result = userService.updateStatus(userId,status);
		if(result>0) {
			return new MsgResult(1,"恭喜您，处理成功",null);
		}else{
			return new MsgResult(2,"非常抱歉，处理失败，请与管理员联系！",null);
		}
	}
	@ResponseBody
	@RequestMapping("getArticle")
	public MsgResult getArticle(int id) {
		Article article = articleService.getDetailById(id);
		CmsAssert.AssertTrue(article!=null, "文章不存在");
		return new MsgResult(1,"获取成功",article);
	}
	
	@ResponseBody
	@RequestMapping("applyArticle")
	public MsgResult applyArticle(int id,int status) {
		Article article = articleService.checkExist(id);
		CmsAssert.AssertTrue(article!=null, "该文已经不存在");
		int result = articleService.apply( id,status);
		if(result>0) {
			return new MsgResult(1,"处理成功",null);
		}else {
			return new MsgResult(2,"处理失败",null);
		}
	}
	
	/**
	 * 
	 * @Title: setArticleHot 
	 * @Description: 设置热门与否
	 * @return
	 * @return: MsgResult
	 */
	@ResponseBody
	@RequestMapping("setArticleHot")
	public MsgResult setArticleHot(int id,int status) {
		Article article = articleService.checkExist(id);
		CmsAssert.AssertTrue(article!=null, "该文已经不存在");
		int result = articleService.setHot( id,status);
		if(result>0) {
			return new MsgResult(1,"处理成功",null);
		}else {
			return new MsgResult(2,"处理失败",null);
		}
	}
}
