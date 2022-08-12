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
    <div class="card-body">
        <div class="form-group">
            <label>Bno</label>
            <input class="form-control" name='bno'
                   value='<c:out value="${board.bno}"/>' readonly="readonly">
        </div>
        <div class="form-group">
            <label>Title</label>
            <input class="form-control" name='title'
                   value='<c:out value="${board.title}"/>' readonly="readonly">
        </div>
        <div class="form-group">
            <label>Text area</label>
            <textarea class="form-control" rows="3" name='content'
                      readonly="readonly">
						<c:out value="${board.content }"/>
					</textarea>
        </div>
        <div class="form-group">
            <label>Writer</label>
            <input class="form-control" name='writer'
                   value='<c:out value="${board.writer}"/>' readonly="readonly">
        </div>
        <button data-oper='modify' class="btn btn-default"
                onclick="location.href='/board/modify?bno=<c:out value="${board.bno }"/>' ">Modify
        </button>
        <button data-oper='list' class="btn btn-default"
                onclick="location.href='/board/list'">List
        </button>

        <form id="operForm" action="/board/modify" method="get">
            <input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>' >
            <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>' >
            <input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>' >
        </form>

    </div>
</body>
</html>
