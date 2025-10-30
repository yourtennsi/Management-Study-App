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
<title>テスト結果検索</title>
</head>
<body class="testdisplay-page">
<div class="container">
<h2 style="text-align:center;">生徒名検索</h2>
<h2 style="text-align:center; font-size:18px;">生徒名を入力してください</h2>
<div class="serch-box">
<form  action="TestDisplayServlet" method="post">
<input type="text" name="studentname"><br>

<div class="search-button">
<p><input type="submit"class="button" value="検索"></p>
</div>
</form>
</div>

<p style="text-align:right; padding-right:80px;"><a href="TestMainServlet">戻る</a></p><br>
<p style="text-align:right;"><a href="index.jsp">トップページへ</a></p>
<%if(errorMsg!=null){ %>
<p style ="color:red; text-align:center;">エラー：<%=errorMsg%></p>
<%} %>
</div>
</body>
</html>

