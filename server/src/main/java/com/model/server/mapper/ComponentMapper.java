package com.model.server.mapper;

import com.model.server.domain.Component;
import com.model.server.domain.ComponentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComponentMapper {
    long countByExample(ComponentExample example);

    int deleteByExample(ComponentExample example);

    int deleteByPrimaryKey(String id);

    int insert(Component record);

    int insertSelective(Component record);

    List<Component> selectByExample(ComponentExample example);

    Component selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Component record, @Param("example") ComponentExample example);

    int updateByExample(@Param("record") Component record, @Param("example") ComponentExample example);

    int updateByPrimaryKeySelective(Component record);

    int updateByPrimaryKey(Component record);
}