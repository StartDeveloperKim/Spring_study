<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.title"/></title>
</head>
<body>
	<form:form modelAttribute="loginRequest">
	<form:errors />
	<p>
		<label><spring:message code="id"/>:<br>
		<form:input path="id"/>
		<form:errors path="id"/>
		</label>
	</p>
	<p>
		<label><spring:message code="password"/>:<br>
		<form:password path="password"/>
		<form:errors path="password"/>
		</label>
	</p>
	<input type="submit" value="<spring:message code="login.btn" />">
	</form:form>
</body>
</html>