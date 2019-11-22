package com.fansongsong.mapper;

import java.util.List;

import com.fansongsong.entity.Category;

public interface CategoryMapper {

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
