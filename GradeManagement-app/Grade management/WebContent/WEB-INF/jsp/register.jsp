<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String errorMsg=(String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/personal.css">
<title>登録画面</title>
</head>
<body class="register-page">
<div class="container">
<h2 style="font-size:35px; text-align:center;">ユーザー登録</h2>
<form action="RegisterServlet" method="post">
<label>教師ID:</label><input type="text" name="teacher_Id"><br>
<label>パスワード：</label><input type="password" name="pass"><br>
<label>メール：</label><input type="text" name="mail"><br>
<label>名前：</label><input type="text" name="name"><br>
<label>担当教科：</label><input type="text" name="subject"><br>
<input type="submit" class="button"value="登録"><br>



<%if(errorMsg!=null){ %>
<p class="caution"><%=errorMsg %></p>
<%} %>
</form>
<p style="text-align:right;"><a href="index.jsp">トップページへ</a></p>
</div>
</body>
</html>