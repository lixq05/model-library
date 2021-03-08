package com.model.business.controller.admin;

import com.model.server.domain.Category;
import com.model.server.domain.Test;
import com.model.server.dto.CategoryDto;
import com.model.server.dto.PageDto;
import com.model.server.service.CategoryService;
import com.model.server.service.TestService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @RequestMapping("/list")
    public PageDto list(@RequestBody PageDto pageDto) {
         categoryService.list(pageDto);
         return pageDto;
    }
}
