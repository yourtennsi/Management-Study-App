<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/personal.css">
<title>テスト管理メイン画面</title>
</head>
<body class="testmain-page">
<div class="container">
<h2 style="font-size:40px; text-align:center;">テストの管理</h2>
<ul style="font-size:40px; text-align:center; line-height: 1.5;">
<li><a href="TestRegisterServlet">テスト結果登録</a></li>
<li><a href="TestDisplayServlet">テスト結果の閲覧</a></li>
</ul>
<p style="text-align:right;"><a href="index.jsp">トップーページへ</a></p>
</div>
</body>
</html>