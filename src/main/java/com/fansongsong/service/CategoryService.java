package com.fansongsong.service;

import java.util.List;

import com.fansongsong.entity.Category;

public interface CategoryService {

	/**
	 * 
	 * @Title: listByChannelId 
	 * @Description: 获取分类
	 * @param chnId
	 * @return
	 * @return: List<Category>
	 */
	List<Category> listByChannelId(Integer chnId);

}
