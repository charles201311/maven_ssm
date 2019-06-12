<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改</title>

<link rel="stylesheet" href="/resource/css/mystyles.css">
<script type="text/javascript" src="/resource/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript">

//文档就绪函数.加载文章类型
$(function(){
	$.ajax({
		type:"get",
		url:"/getTypeList",
		success:function(list){
			for(var i in list){
				$("#tid").append("<option value='"+list[i].tid+"'>"+list[i].tname+"</option>")	
				
			}
			
		//获取要修改的文章类型ID
			var tid ='${b.tid}';
			//让下拉框选中 选中文章类型
		   $("#tid").val(tid)
		}
		
		
		
	})
	
	
	
})

	function update() {
    $.ajax({
    	type:"post",
    	data:$("form").serialize(),
    	url:"/update",
    	success:function(obj){
    		if(obj){
    			alert("发布成功!");
    			location.href="/list";
    		}else{
    			
    			alert("发布失败!")	
    		}
    	}
    	
    	
    	
    })
	
	
	}
	
	
</script>


</head>
<body>
	<form>
		<table>
			<tr>
				<td>标题:<input type="text" name="title" value="${b.title }">
				<!-- 要修改的文章主键 -->
				<input type="hidden" name="id" value="${b.id }">
				
				</td>
			</tr>
			<tr>
				<td>作者:<input type="text" name="author" value="${b.author }"></td>
			</tr>
			<tr>
				<td>文章内容:<textarea rows="10" cols="50" name="content"> ${b.content }   </textarea></td>
			</tr>
			<tr>
				<td>类型: <select name="tid" id ="tid">

				</select>

				</td>

			</tr>


			<tr>

				<td><button type="button" onclick="update()">修改文章</button> <a
					href="javascript:history.go(-1)">返回主页</a></td>
			</tr>




		</table>

	</form>


</body>
</html>