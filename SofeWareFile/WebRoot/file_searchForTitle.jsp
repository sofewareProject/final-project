<%@taglib uri="/struts-tags" prefix="s"%><%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'file_searchForTitle.jsp' starting page</title>
    
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
    <table border="1" width="800">
		<tr>
			<td>序号：</td><td>文件名：</td><td>标签：</td><td>文件路径：</td><td></td>
		</tr>
		<s:iterator value="file_searchJsp" id="files">
			<tr>
			<td><s:property value="#files.id"/></td>			
			<td><s:property value="#files.fileName"/></td>
			<td><s:property value="#files.title"/></td>
			<td><s:property value="#files. filePath"/></td>
			<td><a target="_blank" href="File_down.action?fileId=<s:property value="#files.id"/>">下载</a></td>
		</tr>
		</s:iterator>
  </table>
  </body>
</html>
