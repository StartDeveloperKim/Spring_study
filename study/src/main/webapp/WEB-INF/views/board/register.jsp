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

<main role="main">
    <section class="jumbotron text-center">
        <div class="container">
            <h1><strong>글 등록하기</strong></h1>
            <p class="lead text-center font-awesome "><strong>글을 등록해주세요</strong></p>
            <p>
                <a href="/board/list" class="btn btn-primary my-2">뒤로가기</a>
            </p>
        </div>
    </section>

    <form action="/board/register" method="post">
        <div class="container">
            <div class="col-12">
                <div class="card-body">
                    <div class="form-group">
                        <strong><label>제목</label></strong>
                        <input class="form-control" name='title'>
                    </div>
                    <div class="form-group">
                        <strong><label>내용</label></strong>
                        <input class="form-control" name='content'>
                    </div>
                    <div class="form-group">
                        <strong><label>작성자</label></strong>
                        <input class="form-control" name='writer'>
                    </div>
                    <button type="submit" data-oper='modify' class="btn btn-outline-primary">등록</button>
                    <button type="reset" data-oper='remove' class="btn btn-outline-danger">글 초기화</button>

                </div>
            </div>
        </div>
    </form>
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
