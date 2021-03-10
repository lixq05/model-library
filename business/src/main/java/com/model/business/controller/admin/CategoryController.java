package com.model.business.controller.admin;

import com.model.server.domain.Category;
import com.model.server.domain.Test;
import com.model.server.dto.CategoryDto;
import com.model.server.dto.PageDto;
import com.model.server.dto.ResponseDto;
import com.model.server.service.CategoryService;
import com.model.server.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {
    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);
    @Resource
    private CategoryService categoryService;

    @RequestMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
         LOG.info("pageDto: {}", pageDto);
         ResponseDto responseDto = new ResponseDto();
         categoryService.list(pageDto);
         responseDto.setContent(pageDto);
         return responseDto;
    }
    @RequestMapping("/save")
    public ResponseDto save(@RequestBody CategoryDto categoryDto) {
        LOG.info("categoryDto: {}", categoryDto);
        ResponseDto responseDto = new ResponseDto();
        categoryService.save(categoryDto);
        responseDto.setContent(categoryDto);
        return responseDto;
    }
}
