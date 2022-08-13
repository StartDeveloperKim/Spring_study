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

<main role="main">

  <section class="jumbotron text-center">
    <div class="container">
      <h1><strong>게시판</strong></h1>
      <p class="lead text-center font-awesome "><strong>웹 프로그래밍 기초 공부하고 만들어본 게시판</strong></p>
      <p>
        <a href="/board/register" class="btn btn-primary my-2">글 등록</a>
      </p>
    </div>
  </section>

  <div class="container">
      <div class="col-12">
        <table class="table">
          <thead class="thead-dark"> <%--thead는 표의 제목을 정의--%>
          <tr>
            <th scope="col">#번호</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">작성일</th>
            <th scope="col">수정일</th>
          </tr>
          </thead>

          <tbody> <%--tbody는 테이블의 내용을 정의--%>
          <c:forEach items="${list}" var="board">
            <tr>
              <th scope="row"><c:out value="${board.bno }"/></th>
              <td><a class="move" href='/board/get?bno=${board.bno}'><c:out value="${board.title }"/></a></td>
              <td><c:out value="${board.writer }"/></td>
              <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }"/></td>
              <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate }"/></td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
  </div>
</main>

<footer class="text-muted">
  <div class="container">
    <p class="float-right">
      <a href="#">Back to top</a>
    </p>
    <p>Album example is &copy; Bootstrap, but please download and customize it for yourself!</p>
    <p>New to Bootstrap? <a href="https://getbootstrap.com/">Visit the homepage</a> or read our <a href="/docs/4.4/getting-started/introduction/">getting started guide</a>.</p>
  </div>
</footer>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
