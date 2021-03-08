package com.model.server.service;

import com.model.server.domain.Category;
import com.model.server.domain.CategoryExample;
import com.model.server.domain.Test;
import com.model.server.domain.TestExample;
import com.model.server.dto.CategoryDto;
import com.model.server.mapper.CategoryMapper;
import com.model.server.mapper.TestMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    public List<CategoryDto> list(){
        CategoryExample categoryExample = new CategoryExample();
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);
        List<CategoryDto> categoryDtoList= new ArrayList<>();
        for (int i = 0; i < categoryList.size(); i++) {
            Category category = categoryList.get(i);
            CategoryDto categoryDto = new CategoryDto();
            BeanUtils.copyProperties(category,categoryDto);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }
}
