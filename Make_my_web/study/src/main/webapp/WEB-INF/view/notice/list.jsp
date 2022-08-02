<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	
	<h1>게시판</h1>
	
	<table>
		<tr>
			<th>아이디</th><th>제목</th><th>닉네임</th>
			<th>등록일</th><th>조회수</th>
		</tr>
		<c:forEach var="notice" items="${notices}">
		<tr>
			<td>${notice.id }</td>
			<td><a href="<c:url value="/notice/detail?id=${notice.id }"/>">${notice.title }</a></td>
			<td>${notice.writer_id }</td>	
			<td>${notice.regdate }</td>
			<td>${notice.hit }</td>
		</tr>
		</c:forEach>
	</table>
	
	<a href="<c:url value='/home' />">
			[home으로 돌아가기]
		</a>
</body>
</html>