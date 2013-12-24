<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<%@ page language="java"
	import="org.springframework.web.context.WebApplicationContext"
	import="com.project.constant.PearDataForJsp" 
	import="java.util.List"
	import= "com.project.po.Teacher"
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	WebApplicationContext wac = (WebApplicationContext) config
			.getServletContext()
			.getAttribute(
					WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	PearDataForJsp pearDataForJsp = (PearDataForJsp) wac.getBean("PearDataForJsp");
	List<Teacher> teacherList = pearDataForJsp.getTeachers();
	request.setAttribute("map",teacherList);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>teacher list</title>
<link rel="stylesheet" href="css/table.css" type="text/css"/>
</head>
<body>
<form action="addStudent.action" method="post">
name:<input type="text" name="student.name" value=""/>
score:<input type="text" name="student.score" value=""/>
grade:<input type="text" name="student.grade" value=""/>
teacher:<s:select list="#request.map" listKey="id" listValue="name" name="student.teacher.id"/>
<input type="submit" value="submit">
</form>
</body>
</html>