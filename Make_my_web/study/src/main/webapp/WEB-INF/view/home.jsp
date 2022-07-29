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
	
	<h2>회원가입</h2>
	<p><a href="<c:url value="/register/step1" />">[회원 가입하기]</a>
	
	<h2>비밀번호 바꾸기</h2>
	<p><a href="<c:url value="/register/changeinfo" />">[회원정보 변경]</a>
	
	<h2>게시판</h2>
	<p><a href="<c:url value="/notice/list" />">[게시판]</a>
	

</body>
</html>