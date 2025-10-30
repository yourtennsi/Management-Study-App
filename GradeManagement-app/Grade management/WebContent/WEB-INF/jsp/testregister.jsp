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
<title>テスト登録画面</title>
</head>
<body class="testregister-page">
<div class="container">
<h2 style="font-size:45px; text-align:center;">テスト登録</h2>
<p style="color:red; text-align:center;">＊数字は半角記入</p>
<form  class="form-group"action="TestRegisterServlet" method="post">
<label>クラス:</label>
<input type="text" name="classnum"><br>
<label>テスト名：</label>
<input type="text" name="test_name"><br>
<label>生徒名：</label>
<input type="text" name="studentname"><br>
<label>国語 :</label>
<input type="text" name="japanese"><br>
<label>英語 :</label>
<input type="text" name="english"><br>
<label>数学：</label>
<input type="text" name="math"><br>
<label>理科：</label>
<input type="text" name="science"><br>
<label>社会：</label>
<input type="text" name="socialstudies"><br>
<label>美術：</label>
<input type="text" name="art"><br>
<label>音楽：</label>
<input type="text" name="music"><br>
<label>保険体育：</label>
<input type="text" name="health"><br>
<label>技術:</label>
<input type="text" name="industrialart"><br>
<label>家庭科：</label>
<input type="text" name="homeeconomics"><br>
<label>情報：</label>
<input type="text" name="info"><br>
出欠：
<select name="attendance">
<option value="true">出席</option>
<option value="false">欠席</otption>
</select>
<input type="submit"class="button" value="確認">
</form>
<p style="text-align:right; margin-bottom:3px; padding-right:80px;"><a href="TestMainServlet">戻る</a></p><br>
<p style="text-align:right;"><a href="index.jsp">トップページへ</a></p>

<%if(errorMsg!=null){ %>
<p class="caution"><%=errorMsg %></p>
<%} %>
</div>
</body>
</html>