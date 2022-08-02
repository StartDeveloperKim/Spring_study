<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${notice.title }</title>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th><th>제목</th><th>닉네임</th>
			<th>내용</th><th>등록일</th><th>조회수</th>
		</tr>	
		<tr>
			<td>${notice.id }</td>
			<td>${notice.title }</td>
			<td>${notice.writer_id }</td>	
			<td>${notice.content }</td>	
			<td>${notice.regdate }</td>
			<td>${notice.hit }</td>
		</tr>
	</table>
	<c:if test="${notice.writer_id==authInfo.nickname }">
		<a href="<c:url value='/notice/update?id=${notice.id}' />"><input type="submit" value="수정" /></a>
	</c:if>
	<a href="<c:url value='/notice/list' />">[목록]</a>
</body>
</html>