package com.news.service;

import com.news.pojo.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);

    List<Category> list();
}
