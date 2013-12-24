<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>teacher list</title>
<link rel="stylesheet" href="css/table.css" type="text/css"/>
</head>
<body>
<a href="teacher/add_teacher.jsp" onclick="javascript:void(0);">add teacher</a><br><a href="index.jsp">back</a>
<table class="gridtable">
	<tr>
	<th>ID</th>
	<th>name</th>
	<th>action</th>
	</tr>
	<s:iterator value="list" var="teacher" status="status">
	<tr>
	<td>${teacher.id}</td>
	<td>${teacher.name }</td>
	<td><a href="deleteTeacher.action?teacher.id=${teacher.id }" onclick="javascript:void(0);">delete</a></td>
	</tr>
	</s:iterator>
</table>
</body>
</html>