<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>
	<h1>글 수정</h1>
	
	<div>
		<p>작성자:${authInfo.nickname }</p>
		<form:form action="updateend?id=${id}" modelAttribute="insertRequest">
			<p>제목</p>
			<p>
				<form:input path="title" value="${notice.title }"/>
			</p>
			<p>글내용</p>
			<p>
				<form:input path="content" value="${notice.content }"/>
			</p>
			<input type="submit" value="수정하기">
		</form:form>
	</div>
	<div>
		<a href="<c:url value="/notice/list" />"><input type="submit" value="취소"></a>
	</div>
</body>
</html>