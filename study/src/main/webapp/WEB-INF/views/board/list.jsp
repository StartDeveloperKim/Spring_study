<%--
  Created by IntelliJ IDEA.
  User: ktw55
  Date: 2022-08-12
  Time: 오후 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../includes/header.jsp"%>
<div class="container">
  <div class="row">
    <div class="col-xs-12">
      <table class="table table-striped table-bordered table-hover">
        <thead> <%--thead는 표의 제목을 정의--%>
        <tr>
          <th>#번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
          <th>수정일</th>
        </tr>
        </thead>

        <tbody> <%--tbody는 테이블의 내용을 정의--%>
        <c:forEach items="${list}" var="board">
          <tr>
            <td><c:out value="${board.bno }"/></td>
            <td><a class="move" href='/board/get?bno=${board.bno}'><c:out value="${board.title }"/></a></td>
            <td><c:out value="${board.writer }"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate }"/></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
    <div class="col-md-2"></div>
    <div class="col-md-10">

    </div>
    <div class="col-xs-12"></div>
  </div>
  <div class="row"></div>
</div>

<a href="/board/register">
  <button id="regBtn" type="button" class="ui-button">
    글 등록
  </button>
</a>


</body>
</html>
