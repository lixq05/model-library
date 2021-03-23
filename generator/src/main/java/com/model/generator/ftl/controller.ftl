package com.model.business.controller.admin;

import com.model.server.domain.${Domain};
import com.model.server.domain.Test;
import com.model.server.dto.${Domain}Dto;
import com.model.server.dto.PageDto;
import com.model.server.dto.ResponseDto;
import com.model.server.service.${Domain}Service;
import com.model.server.service.TestService;
import com.model.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/${domain}")
public class ${Domain}Controller{
    private static final Logger LOG = LoggerFactory.getLogger(${Domain}Controller.class);
    public static final String BUSINESS_NAME = "${tableNameCn}";
    @Resource
    private ${Domain}Service ${domain}Service;

    /**
     * 列表查询
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
         LOG.info("pageDto: {}", pageDto);
         ResponseDto responseDto = new ResponseDto();
         ${domain}Service.list(pageDto);
         responseDto.setContent(pageDto);
         return responseDto;
    }
    /**
     * 保存，id有值时更新，无值时新增
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody ${Domain}Dto ${domain}Dto) {
        LOG.info("${domain}Dto: {}", ${domain}Dto);
        // 保存校验

        ResponseDto responseDto = new ResponseDto();
        ${domain}Service.save(${domain}Dto);
        responseDto.setContent(${domain}Dto);
        return responseDto;
    }
    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto save(@PathVariable String id) {
        LOG.info("id: {}", id);
        ResponseDto responseDto = new ResponseDto();
        ${domain}Service.delete(id);
        return responseDto;
    }
}
