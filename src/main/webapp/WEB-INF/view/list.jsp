<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>列表</title>

<link rel="stylesheet" href="/resource/css/mystyles.css">
<script type="text/javascript" src="/resource/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript">
function query(){
	location.href="/list?title="+$("[name='title']").val();
	
}

function toAdd(){
	location.href="/toAdd";
	
}


function deleteById(id){
	var ret=confirm("确定要删除吗?")
	if(ret){
		$.ajax({
			type:"post",
			data:{id:id},
			url:"deleteById",
			success:function(obj){
				if(obj){
					alert("删除成功")
					location.href="/list";
				}else{
					alert("删除失败")
				}
				
				
				
			}
			
			
			
		})
		
		
		
	}
	
}

</script>


</head>
<body>

标题:<input type="text" name="title" value="${title }"> 
<button type="button" onclick="query()">查询</button>
<button type="button" onclick="toAdd()">增加</button>
	<table>
		<tr>
			<td>序号</td>
			<td>标题</td>
			<td>作者</td>
			<td>创建时间</td>
			<td>类型</td>
			<td>操作</td>
		</tr>

		<c:forEach items="${list }" var="b" varStatus="i">
			<tr>
				<td>${i.index+1 }</td>
				<td>${b.title }</td>
				<td>${b.author }</td>
				<td>${b.created }</td>
				<td>${b.tname }</td>
				<td><a href="toUpdate?id=${b.id }">修改</a>|<a href="javascript:deleteById(${b.id})">删除</a></td>
				
			</tr>

		</c:forEach>

		<tr>
			<td colspan="5">${page }</td>
		</tr>



	</table>




</body>
</html>