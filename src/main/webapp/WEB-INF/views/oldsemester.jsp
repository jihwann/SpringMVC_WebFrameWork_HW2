<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>학기별 이수학기 학점 조회</h2>
	<h3><a href="${pageContext.request.contextPath}/">Go to Home</a></h3>
	<table  align="center" border="2">
			<tr>
				<td width="200px">년도 </td>
				<td width="200px">학기</td>
				<td width="200px">이수 학점</td>
				<td width="200px">상세보기</td>
			</tr>
			<c:forEach var="db" items="${subject}">
			<tr>
				<td><c:out value="${db.year}"></c:out></td>
				<td><c:out value="${db.semester}"></c:out></td>
				<td><c:out value="${db.point}"></c:out></td>
				<td><a href="${pageContext.request.contextPath}/detail?year=${db.year}&semester=${db.semester}">Link</a></td>
			</tr>
			
			</c:forEach>
		</table>
</body>
</html>