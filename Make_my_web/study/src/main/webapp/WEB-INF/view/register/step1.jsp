<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h2><spring:message code="term"/></h2>
	<p>약관 내용</p>
	<form action="step2" method="post">
	<label>
		<input type="checkbox" name="agree" value="true"><spring:message code="term.agree"/>
	</label>
	<input type="submit" value="다음 단계">
	</form>
</body>
</html>