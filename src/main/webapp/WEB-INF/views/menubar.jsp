<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>menubar</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/menubar.css">
</head>
<body>
<div class="navbar">
    <a href="${pageContext.request.contextPath}/home" class="logo">🍔FoodTrip</a>
    <a href="${pageContext.request.contextPath}/mypage/${userId}">마이페이지</a>
    <a href="${pageContext.request.contextPath}/board/write">글쓰기</a>
    <a href="${pageContext.request.contextPath}/board/list">글 목록</a>
</div>
<div class="content">