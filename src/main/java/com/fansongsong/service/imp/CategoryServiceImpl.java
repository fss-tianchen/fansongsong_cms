package com.fansongsong.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fansongsong.entity.Category;
import com.fansongsong.mapper.CategoryMapper;
import com.fansongsong.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryMapper categoryMapper;

	@Override
	public List<Category> listByChannelId(Integer chnId) {
		// TODO Auto-generated method stub
		return categoryMapper.listByChannelId(chnId);
	}
}
