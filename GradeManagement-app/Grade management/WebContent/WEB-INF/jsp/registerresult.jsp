<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.TeacherAccount" %>
<%
TeacherAccount teacheraccount=(TeacherAccount)session.getAttribute("teacheraccount");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/personal.css">
<title>登録内容確認画面</title>
</head>
<body class="registerresult-page">
<div class="container">
<h2 style="color:red;" >登録内容確認</h2>

<p>教師ID:<%=teacheraccount.getTeacher_Id()%><br>
   メール:<%=teacheraccount.getMail() %><br>
   名前：<%=teacheraccount.getName() %><br>
   担当教科名：<%=teacheraccount.getSubject() %><br>
</p>
<p style="padding-left:30px;">以上の内容で登録しますか？</p>

<a href="RegisterServlet?action=done">登録</a><br>
<a href="RegisterServlet">キャンセル</a>
</div>
</body>
</html>