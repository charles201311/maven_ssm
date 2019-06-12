package com.bawei.mapper;

import java.util.List;
import java.util.Map;

import com.bawei.entity.BlogType;

public interface BlogTypeMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(BlogType record);

    int insertSelective(BlogType record);

    BlogType selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(BlogType record);

    int updateByPrimaryKey(BlogType record);
    
    List<Map>  getTypeList();
}