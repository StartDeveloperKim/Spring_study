<%--
  Created by IntelliJ IDEA.
  User: ktw55
  Date: 2022-08-14
  Time: 오후 3:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.101.0">
  <title>회원가입</title>

  <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/checkout/">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <meta name="theme-color" content="#712cf9">


  <style>
    .bd-placeholder-img {
      font-size: 1.125rem;
      text-anchor: middle;
      -webkit-user-select: none;
      -moz-user-select: none;
      user-select: none;
    }

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }

    .b-example-divider {
      height: 3rem;
      background-color: rgba(0, 0, 0, .1);
      border: solid rgba(0, 0, 0, .15);
      border-width: 1px 0;
      box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
    }

    .b-example-vr {
      flex-shrink: 0;
      width: 1.5rem;
      height: 100vh;
    }

    .bi {
      vertical-align: -.125em;
      fill: currentColor;
    }

    .nav-scroller {
      position: relative;
      z-index: 2;
      height: 2.75rem;
      overflow-y: hidden;
    }

    .nav-scroller .nav {
      display: flex;
      flex-wrap: nowrap;
      padding-bottom: 1rem;
      margin-top: -1px;
      overflow-x: auto;
      text-align: center;
      white-space: nowrap;
      -webkit-overflow-scrolling: touch;
    }
  </style>


</head>
<body class="bg-light">
<div class="container">
  <main>
    <div class="py-5 text-center">
      <h1>태우 게시판 회원가입</h1>
      <p class="lead"><strong>안녕하세요~ 회원가입 페이지입니다.</strong></p>
      <button type="button" class="btn btn-outline-primary" onclick="location.href='/welcome'">홈으로</button>
    </div>


    <div class="row justify-content-md-center">
      <div class="col-md-8">
<%--
        <form action="/member/register" method="post" class="needs-validation" novalidate>
--%>
        <form:form action="/member/register" modelAttribute="registerDTO">
          <div>
            <label for="id" class="form-label">아이디</label>
<%--
            <input type="text" class="form-control" id="id" placeholder="ID" value="" required name="id">
--%>
            <form:input path="id" cssClass="form-control"/>
            <form:errors path="id"/>
            <div class="invalid-feedback">
              Valid first name is required.
            </div>
          </div>

          <div>
            <label for="password" class="form-label">비밀번호</label>
<%--
            <input type="password" class="form-control" id="password" placeholder="Password" value="" required name="password">
--%>
            <form:input path="password"/>
            <form:errors path="password"/>
            <div class="invalid-feedback">
              Valid last name is required.
            </div>
          </div>

          <div>
            <label for="confirmPassword" class="form-label">비밀번호확인</label>
<%--
            <input type="password" class="form-control" id="confirmPassword" placeholder="confirmPassword" value="" required name="confirmPassword">
--%>
            <form:input path="confirmPassword"/>
            <form:errors path="confirmPassword"/>
            <div class="invalid-feedback">
              Valid last name is required.
            </div>
          </div>

          <div>
            <label for="username" class="form-label">이름</label>
            <div class="input-group has-validation">
<%--
              <input type="text" class="form-control" id="username" placeholder="Username" required name="name">
--%>
              <form:input path="name"/>
              <form:errors path="name"/>
              <div class="invalid-feedback">
                Your username is required.
              </div>
            </div>
          </div>

          <div>
            <label for="nickname" class="form-label">닉네임</label>
            <div class="input-group has-validation">
<%--
              <input type="text" class="form-control" id="nickname" placeholder="nickname" required name="nickname">
--%>
              <form:input path="nickname" />
              <form:errors path="nickname"/>
              <div class="invalid-feedback">
                Your username is required.
              </div>
            </div>
          </div>

          <%--약관 동의에 대한 Modal과 값을 넘겨서 동의할때만 등록할 수 있도록 수정하자--%>
          <div class="form-check">
            <input type="checkbox" class="form-check-input" id="same-address">
            <label class="form-check-label" for="same-address">약관을 동의하십니까?</label>
          </div>

          <button class="btn btn-outline-primary btn-lg btn-block" type="submit">회원가입</button>
<%--
        </form>
--%>
        </form:form>
      </div>
    </div>
  </main>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2017–2022 Company Name</p>
    <ul class="list-inline">
      <li class="list-inline-item"><a href="#">Privacy</a></li>
      <li class="list-inline-item"><a href="#">Terms</a></li>
      <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
  </footer>
</div>




<script src="form-validation.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>

