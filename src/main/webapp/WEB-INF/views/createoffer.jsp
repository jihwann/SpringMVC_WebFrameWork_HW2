<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">

</head>
<body>
<h3><a href="${pageContext.request.contextPath}/">Go to Home</a></h3>
<sf:form method="get" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">
<!-- offer라는 객체의 name, email, text란 필드를 가져와서 input에 넣는다는 것임. -->
	<table class="formtable">
		<tr>
				<td class="label">수강년도: </td>
				<td class="control"><input type="text" name="year"/></td>
			</tr>
			<tr>
				<td class="label">학기: </td>
				<td class="control"><input type="text" name="semester"/></td>
			</tr>
			<tr>
				<td class="label">교과코드: </td>
				<td class="control"><input type="text" name="code"/></td>
			</tr>
			<tr>
				<td class="label">교과목명: </td>
				<td class="control"><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td class="label">구분: </td>
				<td class="control"><input type="text" name="classify"/></td>
			</tr>
			<tr>
				<td class="label">학점: </td>
				<td class="control"><input type="text" name="point"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input value="create subject" type="submit" /></td>
			</tr>
	</table>
	
</sf:form>
</body>
</html>