<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보변경</title>
</head>
<body>
	<h2><spring:message code="change.info.title"/></h2>
	<form:form action="changeinfoend" modelAttribute="changeRequestInfo">
	
	<p>
		<label><spring:message code="name"/>:<br>
		<form:input path="name"/>
		</label>
	</p>
	<p>
		<label><spring:message code="nickname"/>:<br>
		<form:input path="nickname" />
		</label>
	</p>
	<input type="submit" value="변경하기">
	
	</form:form>
	<a href="<c:url value="/home" />"><input type="submit" value="취소"></a>
</body>
</html>