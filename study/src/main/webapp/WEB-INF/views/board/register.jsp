<%--
  Created by IntelliJ IDEA.
  User: ktw55
  Date: 2022-08-12
  Time: 오후 2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../includes/header.jsp"%>
    <h1>글 등록</h1>
    <form role="form" action="/board/register" method="post">
        <div>
            <label>Title</label>
            <input type="text" name="title">
        </div>
        <div>
            <label>Text area</label>
            <textarea type="text" name="content" rows="3"></textarea>
        </div>
        <div>
            <label>Writer</label>
            <input type="text" name="writer">
        </div>
        <button type="submit" class="ui-button">글 등록</button>
        <button type="reset" class="ui-button">전체 초기화</button>
    </form>
</body>
</html>
