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
<title>student list</title>
<link rel="stylesheet" href="css/table.css" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/control.js"></script>

</head>
<body>
<a href="student/add_student.jsp">add student</a><br>
<a href="index.jsp">back</a><br>
<a href="#" onclick="Control.getTotalScore();return false;">add score</a><br>
<a href="#" onclick="Control.getCustomizeHqlData();return false;">get customize hql data</a><br>
<table class="gridtable">
	<tr>
	<th>ID</th>
	<th>name</th>
	<th>grade</th>
	<th>score</th>
	<th>teacher</th>
	<th>action</th>
	</tr>
	<s:iterator value="list" var="student" status="status">
	<tr>
	<td>${student.id}</td>
	<td>${student.name }</td>
	<td>${student.grade }</td>
	<td>${student.score }</td>
	<td>${student.teacher.name }</td>
	<td><a href="deleteStudent.action?student.id=${student.id }">delete</a></td>
	</tr>
	</s:iterator>
</table>

</body>
</html>