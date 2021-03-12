package com.model.business.controller.admin;

import com.model.server.domain.Category;
import com.model.server.domain.Test;
import com.model.server.dto.CategoryDto;
import com.model.server.dto.PageDto;
import com.model.server.dto.ResponseDto;
import com.model.server.service.CategoryService;
import com.model.server.service.TestService;
import com.model.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class CategoryController{
    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);
    public static final String BUSINESS_NAME = "型号";
    @Resource
    private CategoryService categoryService;

    /**
     * 列表查询
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
         LOG.info("pageDto: {}", pageDto);
         ResponseDto responseDto = new ResponseDto();
         categoryService.list(pageDto);
         responseDto.setContent(pageDto);
         return responseDto;
    }
    /**
     * 保存，id有值时更新，无值时新增
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody CategoryDto categoryDto) {
        LOG.info("categoryDto: {}", categoryDto);
        // 保存校验
        ValidatorUtil.require(categoryDto.getName(), "名称");
        ValidatorUtil.require(categoryDto.getModelId(), "模型库ID");
        ValidatorUtil.length(categoryDto.getModelId(), "模型库ID", 1, 8);
        ResponseDto responseDto = new ResponseDto();
        categoryService.save(categoryDto);
        responseDto.setContent(categoryDto);
        return responseDto;
    }
    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto save(@PathVariable String id) {
        LOG.info("id: {}", id);
        ResponseDto responseDto = new ResponseDto();
        categoryService.delete(id);
        return responseDto;
    }
}
