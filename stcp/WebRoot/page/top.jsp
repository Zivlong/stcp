<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.stx.bean.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user = (User) session.getAttribute("USER");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
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
<table border="1" width="100%">
   	<tr>
   		<td width="70%">
   			类型1 类型2  类型3
   		</td>
   		<td width="30%" align="right">
   			<%
   				if(user==null){
   					%>
   						<a href="<%=basePath%>page/register.jsp">注册</a>
   						<a href="<%=basePath%>page/login.jsp">登录</a>
   					<%
   				}else{
   					if("1".equals(user.getType())){
   						%>
   							<%=user.getRealname() %>，欢迎你！
				   			<a href="<c:url value='/TypeServlet'/>">查看类型</a>
				   			<a href="<%=basePath%>page/type_add.jsp">新增类型</a>
				   			<a href="<c:url value='/LogoutServlet'/>">退出登录</a>
   						<%
   					}else{
   						%>
   							<%=user.getRealname() %>，欢迎你！
				   			<a href="<c:url value='/CpSelByUserServlet'/>">我的菜谱</a>
				   			<a href="<c:url value='/CpTypeSelServlet'/>">新增菜谱</a>
				   			<a href="<c:url value='/LogoutServlet'/>">退出登录</a>
   						<%
   					}
   				}
   							
   			 %>      			
   		</td>
   	</tr>
</table>
  </body>
</html>
