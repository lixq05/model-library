package com.model.server.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.server.domain.Component;
import com.model.server.domain.ComponentExample;
import com.model.server.domain.Test;
import com.model.server.domain.TestExample;
import com.model.server.dto.ComponentDto;
import com.model.server.dto.PageDto;
import com.model.server.mapper.ComponentMapper;
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
public class ComponentService {
    @Resource
    private ComponentMapper componentMapper;

    /**
     * 列表查询
     */
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        ComponentExample componentExample = new ComponentExample();
        List<Component> componentList = componentMapper.selectByExample(componentExample);
        PageInfo<Component> pageInfo = new PageInfo<>(componentList);
        pageDto.setTotal(pageInfo.getTotal());
        List<ComponentDto> componentDtoList = CopyUtil.copyList(componentList, ComponentDto.class);
        pageDto.setList(componentDtoList);
    }
    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(ComponentDto componentDto) {
        Component component = CopyUtil.copy(componentDto, Component.class);
        if (StringUtils.isEmpty(componentDto.getId())) {
            this.insert(component);
        } else {
            this.update(component);
        }
    }
    /**
     * 删除
     */
    public void delete(String id) {
        componentMapper.deleteByPrimaryKey(id);
    }

    /**
     * 新增
     */
    private void insert(Component component) {
        component.setId(UuidUtil.getShortUuid());
        componentMapper.insert(component);
    }
    /**
     * 更新
     */
    private void update(Component component) {
        componentMapper.updateByPrimaryKey(component);
    }

}
