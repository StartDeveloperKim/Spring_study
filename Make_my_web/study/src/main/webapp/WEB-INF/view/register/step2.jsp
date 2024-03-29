<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h2>회원 정보 입력</h2>
	<form:form action="step3" modelAttribute="registerRequest">
	<p>
		<label>아이디:<br>
		<form:input path="id"/>
		<form:errors path="id"/>
		</label>
	</p>
	<p>
		<label>비밀번호:<br>
		<form:password path="password"/>
		<form:errors path="password"/>
		</label>
	</p>
	<p>
		<label>비밀번호 확인:<br>
		<form:password path="confirmPassword"/>
		<form:errors path="confirmPassword"/>
		</label>
	</p>
	<p>
		<label>이름:<br>
		<form:input path="name"/>
		<form:errors path="name"/>
		</label>
	</p>
	<p>
		<label>닉네임:<br>
		<form:input path="nickname"/>
		<form:errors path="nickname"/>
		</label>
	</p>
	<input type="submit" value="가입 완료">
	
	</form:form>
</body>
</html>