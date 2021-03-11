package com.model.server.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.server.domain.Category;
import com.model.server.domain.CategoryExample;
import com.model.server.domain.Test;
import com.model.server.domain.TestExample;
import com.model.server.dto.CategoryDto;
import com.model.server.dto.PageDto;
import com.model.server.mapper.CategoryMapper;
import com.model.server.mapper.TestMapper;
import com.model.server.util.CopyUtil;
import com.model.server.util.UuidUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        CategoryExample categoryExample = new CategoryExample();
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);
        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        pageDto.setTotal(pageInfo.getTotal());
//        List<CategoryDto> categoryDtoList= new ArrayList<>();
//        for (int i = 0; i < categoryList.size(); i++) {
//            Category category = categoryList.get(i);
//            CategoryDto categoryDto = new CategoryDto();
//            BeanUtils.copyProperties(category,categoryDto);
//            categoryDtoList.add(categoryDto);
//        }
        List<CategoryDto> categoryDtoList = CopyUtil.copyList(categoryList, CategoryDto.class);
        pageDto.setList(categoryDtoList);
    }

    public void save(CategoryDto categoryDto) {
//        categoryDto.setId(UuidUtil.getShortUuid());
        Category category = CopyUtil.copy(categoryDto, Category.class);
        if (StringUtils.isEmpty(categoryDto.getId())) {
            this.insert(category);
        } else {
            this.update(category);
        }
    }

    private void insert(Category category) {
        category.setId(UuidUtil.getShortUuid());
        categoryMapper.insert(category);
    }

    private void update(Category category) {
        categoryMapper.updateByPrimaryKey(category);
    }
}
