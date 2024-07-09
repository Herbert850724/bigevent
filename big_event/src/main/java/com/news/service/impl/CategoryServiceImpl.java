package com.news.service.impl;

import com.news.mapper.CategoryMapper;
import com.news.pojo.Category;
import com.news.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public void add(Category category) {
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        category.setCreateUser(1);
        categoryMapper.insertSelective(category);
    }

    @Override
    public List<Category> list() {
        return null;
    }
}
