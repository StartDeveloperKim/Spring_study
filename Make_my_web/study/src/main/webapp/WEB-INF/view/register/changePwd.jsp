<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호변경</title>
</head>
<body>
	<h2><spring:message code="change.pwd.done"/></h2>
	<form:form action="changeend" modelAttribute="changeRequest">
	
	<p>
		<label><spring:message code="currentPassword"/>:<br>
		<form:password path="oldPwd"/>
		</label>
	</p>
	<p>
		<label><spring:message code="newPassword"/>:<br>
		<form:password path="newPwd" />
		</label>
	</p>
	<p>
		<label><spring:message code="confirmPassword"/>:<br>
		<form:password path="confirmapassword"/>
		</label>
	</p>
	<input type="submit" value="변경하기">
	
	</form:form>
</body>
</html>