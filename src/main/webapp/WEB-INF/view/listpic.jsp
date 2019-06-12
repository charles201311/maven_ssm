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


</script>


</head>
<body>

  <div>
  <c:forEach items="${list }" var="b">
    <div style="float: left">
       <div style="width: 200px;height: 200px">
       <img alt="未找到图片" src="/pic/${b.pic }">
       <br>
       ${b.title} 
       </div>
       
    </div>

  </c:forEach>
    <br>
  </div>
  <div style="clear:both">
      ${page }
  </div>


</body>
</html>