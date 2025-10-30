<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/personal.css">
<title>ログイン画面</title>
</head>
<body class="login-page">
<div class="container">
<h1 style="font-size:40px; text-align:center; text-indent:40px;">ログイン</h1><br>

<div class="login-form">
<form action="LoginServlet" method="post">
<p>ユーザID：<input type="text" name="teacher_Id"></p><br>
<p>パスワード：<input type="password" name="pass"></p><br>
<p style="text-align:right;"><input type="submit" class="button"value="ログイン"></p>
</form>
</div>
<p style="font-size:30px; text-align:right;"><a href="index.jsp">戻る</a>
</div>
</body>
</html>