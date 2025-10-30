<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Login" %>
<%Login login=(Login)session.getAttribute("login");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/personal.css">
<title>トップページ</title>
</head>
<body class="index-page">
<div class="container">
<h1 style="font-size:45px; text-align:center; text-indent:80px;">グレードマネジメント</h1>
<%if(login!=null){ %>
<p style="font-size:30px; text-align:center;">ようこそ! <%=login.getTeacher_Id() %>さん</p>
<%}else{%>
<p style="font-size:30px; text-align:center;">ようこそ! ゲストさん</p>
<%} %>

<ul style="font-size:40px; text-align:center;">
<li><a href="LoginServlet">ログインする</a></li>
<li><a href="RegisterServlet">ユーザ登録する</a></li>
<li><a href="TestMainServlet">成績を登録管理する</a></li>
</ul>

<p style="font-size:18px; text-align:right;"><a href="LogoutServlet">ログアウトする</a></p>
</div>
</body>
</html>

<%--自戒 index.jspのcss続きから、と、index.jspの個別cssの余白設定--%>
