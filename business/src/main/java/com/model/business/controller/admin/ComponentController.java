package com.model.business.controller.admin;

import com.model.server.domain.Component;
import com.model.server.domain.Test;
import com.model.server.dto.ComponentDto;
import com.model.server.dto.PageDto;
import com.model.server.dto.ResponseDto;
import com.model.server.service.ComponentService;
import com.model.server.service.TestService;
import com.model.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/component")
public class ComponentController{
    private static final Logger LOG = LoggerFactory.getLogger(ComponentController.class);
    public static final String BUSINESS_NAME = "组件";
    @Resource
    private ComponentService componentService;

    /**
     * 列表查询
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
         LOG.info("pageDto: {}", pageDto);
         ResponseDto responseDto = new ResponseDto();
         componentService.list(pageDto);
         responseDto.setContent(pageDto);
         return responseDto;
    }
    /**
     * 保存，id有值时更新，无值时新增
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody ComponentDto componentDto) {
        LOG.info("componentDto: {}", componentDto);
        // 保存校验

        ResponseDto responseDto = new ResponseDto();
        componentService.save(componentDto);
        responseDto.setContent(componentDto);
        return responseDto;
    }
    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto save(@PathVariable String id) {
        LOG.info("id: {}", id);
        ResponseDto responseDto = new ResponseDto();
        componentService.delete(id);
        return responseDto;
    }
}
