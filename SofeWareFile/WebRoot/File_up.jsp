<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'File_up.jsp' starting page</title>
    
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
    文件上传
	<form method="post" enctype="multipart/form-data" action="File_up.action">
		文件选择：<input type="file" name="File_upJsp1"  /> <br> <br /> 
		文件名字<input type="text" name="File_upJsp1Name" /> <br> <br /> 
		文件类型<input type="text" name="File_upJsp1Type" /> <br> <br /> 
		文件介绍：<input type="text" name="File_upJsp1Des" /> <br> <br /> 
		文件标签<input type="text" name="File_upJsp1Tit">
		<input type="submit" value="提交" />
	</form>
  </body>
</html>
