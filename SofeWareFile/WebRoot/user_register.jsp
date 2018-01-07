<%@taglib uri="/struts-tags" prefix="s"%><%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_register.jsp' starting page</title>
    
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
	<s:form action="user_regJsp.action" method="post">
	<div class="container">
	<div>
	
	登录名字：<input type="text" name="user_regJsp.loginName"><br>
	真实名字：<input type="text" name="user_regJsp.userName"><br>
	登录密码：<input type="text" name="user_regJsp.userPwd"><br>
	性别：<input type="text" name="user_regJsp.gender"><br>
	年级：<input type="text" name="user_regJsp.grade"><br>
	联系方式：<input type="text" name="user_regJsp.cell"><br>
	邮箱：<input type="text" name="user_regJsp.email"><br>
	角色：<input type="text" name="user_regJsp.role"><br>
	<input type="submit" value="注册"/>
	
	</div>
	</div>
	</s:form>
</body>
</html>
