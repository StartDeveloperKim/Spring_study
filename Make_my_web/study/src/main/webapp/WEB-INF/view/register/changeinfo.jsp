<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호변경</title>
</head>
<body>
	<h2>비밀번호변경</h2>
	<form:form action="changeend" modelAttribute="changeRequest">
	
	<p>
		<label>현재 비밀번호:<br>
		<form:password path="oldPwd"/>
		</label>
	</p>
	<p>
		<label>새 비밀번호:<br>
		<form:password path="newPwd" />
		</label>
	</p>
	<p>
		<label>비밀번호 확인:<br>
		<form:password path="confirmapassword"/>
		</label>
	</p>
	<input type="submit" value="변경하기">
	
	</form:form>
</body>
</html>