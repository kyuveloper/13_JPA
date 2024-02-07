package org.ohgiraffers.springjpa.menu.infra;

import org.ohgiraffers.springjpa.category.entity.Category;
import org.ohgiraffers.springjpa.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryFindImpl implements CategoryFind{

    @Autowired
    CategoryService categoryService;

    @Override
    public Integer getCategory(int code) {
        return categoryService.findByCategory(code);
    }
}
