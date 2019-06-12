package com.bawei.service;

import java.util.List;
import java.util.Map;

import com.bawei.entity.Blog;
/**
 * 
 * @ClassName: BlogService 
 * @Description: TODO
 * @author: charles
 * @date: 2019年6月10日 下午6:51:05
 */
public interface BlogService {

     List<Map> selectList(String title);
	
	//文章类型列表
     List<Map>  getTypeList();
     
    int deleteByPrimaryKey(Integer id);
    /**
     * 
     * @Title: insertSelective 
     * @Description: TODO
     * @param record
     * @return
     * @return: int
     */
    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeyWithBLOBs(Blog record);
    
    
}
