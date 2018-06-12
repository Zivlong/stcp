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
    
    <title>My JSP 'cp_my_list.jsp' starting page</title>
    
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
    <table>
   	<tr>
   		<td>标题</td>
   		<td>作者</td>
   		<td>创建时间</td>
   		<td>操作</td>
   	</tr>
   	<c:forEach items="${cps}" var="cp">
   		<tr>
	   		<td>${cp.title }</td>
	   		<td>${cp.uname }</td>
	   		<td>${cp.createtime }</td>
	   		<td>
	   			<a href="<c:url value='/CpEditServlet'/>?id=${cp.id}">编辑</a>
	   			<a href="<c:url value='/CpDelServlet'/>?id=${cp.id}">删除</a>
	   		</td>
	   	</tr>
   	</c:forEach>
   </table>
  </body>
</html>
