package com.wanglei.service;

import com.github.pagehelper.PageInfo;
import com.wanglei.entity.User;

public interface UserService {

	/**
	 * 
	 * @Title: getPageList 
	 * @Description: 文章列表、分页
	 * @param name
	 * @param page
	 * @return
	 * @return: PageInfo<User>
	 */
	PageInfo<User> getPageList(String name, Integer page);

	/**
	 * 
	 * @Title: getUserById 
	 * @Description: 获取用户
	 * @param userId
	 * @return
	 * @return: User
	 */
	User getUserById(Integer userId);

	/**
	 * 
	 * @Title: updateStatus 
	 * @Description: TODO
	 * @param userId
	 * @param status
	 * @return
	 * @return: Integer
	 */
	Integer updateStatus(Integer userId, Integer status);

	/**
	 * 
	 * @Title: findByName 
	 * @Description: TODO
	 * @param username
	 * @return
	 * @return: Object
	 */
	User findByName(String username);

	/**
	 * 
	 * @Title: register 
	 * @Description: 注册用户
	 * @param user
	 * @return
	 * @return: Integer
	 */
	Integer register(User user);

	/**
	 * 
	 * @Title: login 
	 * @Description: 登录到用户
	 * @param user
	 * @return
	 * @return: User
	 */
	User login(User user);
	

}
