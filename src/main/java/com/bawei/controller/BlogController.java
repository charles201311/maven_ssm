package com.bawei.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bawei.entity.Blog;
import com.bawei.service.BlogService;
import com.bawei.util.PageUtil;
import com.bawei.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
///远程仓库被改变
@Controller
public class BlogController {

	@Resource
	private BlogService service;

	@RequestMapping("list")
	public String list(HttpServletRequest request,Model model ,@RequestParam( defaultValue="1") Integer page,  @RequestParam(defaultValue="") String title) {
		Integer pageSize =3;
	   //分页助手
		
		 PageHelper.startPage(page, pageSize);
		 List<Map> list = service.selectList(title);
		 PageInfo info = new PageInfo<>(list);
		 
		 //调用分页工具类
	//	 PageUtils.page(model, info, "&title="+title);
		 
	  PageUtil.page(request, "/listpic?title="+title, pageSize, list, info.getTotal(), page);

		  
		 model.addAttribute("list", list);
		 
		 model.addAttribute("title", title);
		 
		 
		 
		return "list";
		
	}
	
	
	
	@RequestMapping("listpic")
	public String listpic(  HttpServletRequest request,Model model ,@RequestParam( defaultValue="1") Integer page,  @RequestParam(defaultValue="") String title) {
		Integer pageSize =3;
	   //分页助手
		 PageHelper.startPage(page, pageSize);
		 List<Map> list = service.selectList(title);
		 PageInfo info = new PageInfo<>(list);
		 
		 //调用分页工具类
		PageUtil.page(request, "/listpic?title="+title, pageSize, list, info.getTotal(), page);
		  
		 model.addAttribute("list", list);
		 
		 model.addAttribute("title", title);
		 
		 
		 
		return "listpic";
		
	}
	
	//跳转到修改
	@RequestMapping("toUpdate")
	public String toUpdate(Integer id,Model model) {
		
		Blog blog = service.selectByPrimaryKey(id);
		model.addAttribute("b", blog);
		return "update";
	}
	
	//执行修改
    @ResponseBody
	@RequestMapping("update")
	public boolean update(Blog blog) {
		return service.updateByPrimaryKeyWithBLOBs(blog)>0;
	
	}
	
	
	
	//跳转到增加
	@RequestMapping("toAdd")
	public String toAdd() {
		return "add";
	}
	
	//执行增加
	    @ResponseBody
		@RequestMapping("add")
		public boolean add( @RequestParam("file") MultipartFile  file,  Blog blog) throws IllegalStateException, IOException {
	    	String path="E:/pic/";
	    	
	    	if(!file.isEmpty()) {
	    		
	    		//1.jpg
	    		String filename = file.getOriginalFilename();
	    	String newFileName =UUID.randomUUID()+filename.substring(filename.lastIndexOf("."));
	    		File file2 = new File(path+newFileName);
	    		//把文件写入硬盘
	    		file.transferTo(file2);
	    		blog.setPic(newFileName);
	    	}
	    	
			return service.insertSelective(blog)>0;
		
		}
	    
	  //执行删除
	    @ResponseBody
		@RequestMapping("deleteById")
		public boolean deleteById(Integer id) {
			return service.deleteByPrimaryKey(id)>0;
		
		}
	
	
	
	//获取文章类型类别

	@ResponseBody
	@RequestMapping("getTypeList")
	public List<Map> getTypeList() {
		return service.getTypeList();
		
	}
}
