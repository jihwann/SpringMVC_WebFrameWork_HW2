<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>2019년 수강신청 조회</h1>
	<h3><a href="${pageContext.request.contextPath}/">Go to Home</a></h3>
	<table align="center" border="1">
		<tr>
			<td width="100px">수강년도</td>
			<td width="100px">학기</td>
			<td width="100px">교과코드</td>
			<td width="250px">교과목명</td>
			<td width="100px">구분</td>
			<td width="100px">학점</td>
		</tr>
		<!-- db 명칭 : subject, 현 학기 수강 과목-->
		<c:forEach var="db" items="${subject}">
			<tr>
				<td>2019</td>
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