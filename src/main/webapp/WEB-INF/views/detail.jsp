<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 학기별 학점 조회에서 링크 따라 들어갔을 때   -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Detail</h2>
	<h3><a href="${pageContext.request.contextPath}/">Go to Home</a></h3>
	<table align="center" border="1">
		<tr>
			<td width="100px">년도</td>
			<td width="100px">학기</td>
			<td width="100px">과목코드</td>
			<td width="250px">과목명</td>
			<td width="100px">구분</td>
			<td width="100px">학점</td>
		</tr>

		<c:forEach var="db" items="${subject}">
			<tr>
				<td><c:out value="${db.year}"></c:out></td>
				<td><c:out value="${db.semester}"></c:out></td>
				<td><c:out value="${db.code}"></c:out></td>
				<td><c:out value="${db.name}"></c:out></td>
				<td><c:out value="${db.classify}"></c:out></td>
				<td><c:out value="${db.point}"></c:out></td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>