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
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
     登录页面：<br>
     <font color="red">${msg }</font>
     <br>
     <form action="<c:url value='/LoginServlet'/>" method="post">
     	账户：<input name="zh"/><br>
     	密码：<input name="pass"/><br>
     	用户类型：<select name="type">
     				<option value="0">普通用户</option>
     				<option value="1">管理员</option>
     			</select><br>
     			<input type="submit" value="提交"/>
     </form>
  </body>
</html>
