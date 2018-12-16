<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	
	<!-- helloSpringMVC (root)에  request로 offers를 보냄 -->
	<p> <a href="${pageContext.request.contextPath}/oldsemester"> 1. 학기별 이수학기 학점 조회 </a> </p>
	<p> <a href="${pageContext.request.contextPath}/createoffer"> 2. 수강신청하기 </a> </p>
	<p> <a href="${pageContext.request.contextPath}/offers"> 3. 이번학기 수강신청 된 과목 보기 </a> </p>

	<c:if test="${pageContext.request.userPrincipal.name == null}">
		<a href="javascript:document.getElementById('login').submit()">Login</a>
	</c:if>
	<form id="login" action="<c:url value="/login" />" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>
	<!-- 위 링크를 누르면 아래의 form 정보가 /logout으로, post로 날아간다. -->
	<form id="logout" action="<c:url value="/logout" />" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>


</body>

</html>

