<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>태우의 게시판</title>
</head>
<body>
	<h1>환영합니다~.태우의 게시판입니다.</h1>
	
	<c:if test="${empty authInfo }">
		<h2>회원가입</h2>
		<p><a href="<c:url value="/register/step1" />">[회원 가입하기]</a>
		<h2>로그인</h2>
		<p><a href="<c:url value="/login" />">[로그인]</a>
	</c:if>
	
	
	<c:if test="${!empty authInfo }">
		<p>${authInfo.nickname }님, 환영합니다.</p>
		<h2>비밀번호 변경</h2>
		<p><a href="<c:url value="/register/changePwd" />">[비밀번호 변경]</a>
		
		<h2>회원정보 변경</h2>
		<p><a href="<c:url value="/register/changeinfo" />">[회원정보 변경]</a>
		
		<h2>로그아웃</h2>
		<p><a href="<c:url value="/logout" />">[로그아웃]</a>
		
		<h2>게시판</h2>
		<p><a href="<c:url value="/notice/list" />">[게시판]</a>
		
	</c:if>
	
	

</body>
</html>