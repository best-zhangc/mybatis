<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" border="1" cellpadding="2" cellspacing="0">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>薪水</td>
			<td>年龄</td>
			<td>部门</td>
			
		</tr>
		<c:forEach items="${emps}" var="emp">
			<tr>
				<td>${emp.empno}</td>
				<td>${emp.ename}</td>
				<td>${emp.sal}</td>
				<td>${emp.age}</td>
				<td>${emp.deptno}</td>
			</tr>
		</c:forEach>
	
	</table>
</body>
</html>
