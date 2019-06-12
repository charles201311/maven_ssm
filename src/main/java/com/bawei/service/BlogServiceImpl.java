package com.bawei.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bawei.entity.Blog;
import com.bawei.mapper.BlogMapper;
import com.bawei.mapper.BlogTypeMapper;
/**
 * 
 * @ClassName: BlogServiceImpl 
 * @Description: 类的描述
 * @author: charles
 * @date: 2019年6月10日 下午6:49:09
 */
@Service
public class BlogServiceImpl implements BlogService {
	
	@Resource
	private BlogMapper mapper;
	
	@Resource
	private BlogTypeMapper typeMapper;

	
	@Override 
	public List<Map> selectList(String title) {
		// TODO Auto-generated method stub
		return mapper.selectList(title);
	}
     
	
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(Blog record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	@Override
	public Blog selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Blog record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public List<Map> getTypeList() {
		// TODO Auto-generated method stub
		return typeMapper.getTypeList();
	}

}
