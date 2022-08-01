<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 조회</title>
</head>
<body>
	<c:if test="${! empty members }">
	<table>
		<tr>
			<th>아이디</th><th>닉네임</th>
			<th>이름</th><th>가입일</th>
		</tr>
		<c:forEach var="mem" items="${members}">
		<tr>
			<td>${mem.id }</td>
			<td>${mem.nickname }</td>
			<td>${mem.name }</td>
			<td>${mem.regdate }</td>	
		</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>