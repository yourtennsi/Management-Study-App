<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Login"%>
<%
String errorMsg=(String)request.getAttribute("errorMsg");
Login login=(Login)session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<title>ログイン結果</title>
</head>
<body>
<%if(login!=null){ %>
<p>ログイン成功です</p>
<p>ようこそ !<%=login.getTeacher_Id()%>さん</p>
<a href="index.jsp">トップページへ</a>

<%}else{%>
<p>ログインに失敗しました<br>考えられる原因：<%=errorMsg %></p><br>
<a href="LoginServlet">ログインページへ</a>
<%} %>

</body>
</html>