<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cp_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <jsp:include page="top.jsp"></jsp:include>
	<form action="<c:url value='/CpAddServlet'/>" method="post">
    	类型：
    	<select name="tname">
    		<c:forEach items="${types}" var="type">
    			<option>${type.name }</option>
    		</c:forEach>
    	</select><br/>
    	菜谱名称：<input name="title"/><br/>
    	内容：<textarea name="content" rows="5" cols="80"></textarea><br/>
    	<input type="submit" value="新增菜谱"/>
    </form>

  </body>
</html>
