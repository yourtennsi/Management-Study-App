<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Studentscore" %>
<%
Studentscore studentscore=(Studentscore)session.getAttribute("studentscore");
String errorMsg=(String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/personal.css">
<title>テスト編集画面</title>
</head>
<body class="testupdate-page">
<div class="container">
<h2 style="font-size:40px; text-align:center;">編集</h2>
<div class="update-form">
<form  action="TestUpdateServlet" method="post">
クラス名：<input type="text" name="classnum" value="<%=studentscore.getClassnum() %>"><br>
テスト名:<input type="text" name="test_name" value="<%=studentscore.getTest_name() %>"><br>
生徒氏名:<input type ="text" name="studentname" value="<%=studentscore.getStudentname() %>"><br>
国語：<input type="text" name="japanese" value="<%=studentscore.getJapanese() %>"><br>
英語:<input type="text" name="english" value="<%=studentscore.getEnglish() %>"><br>
数学:<input type="text" name="math" value="<%=studentscore.getMath() %>"><br>
理科:<input type="text" name="science" value="<%=studentscore.getScience() %>"><br>
社会:<input type="text" name="socialstudies" value="<%=studentscore.getSocialstudeies() %>"><br>
美術:<input type="text" name="art" value="<%=studentscore.getArt() == null ? "" : studentscore.getArt() %>"><br>
音楽：<input type="text" name="music" value="<%=studentscore.getMusic()==null?"":studentscore.getMusic() %>"><br>
保健・体育<input type="text" name="health" value="<%=studentscore.getHealth()==null?"":studentscore.getHealth() %>"><br>
技術：<input type="text" name="industrialart" value="<%=studentscore.getIndustrialart()==null?"":studentscore.getIndustrialart() %>"><br>
家庭科：<input type="text" name="homeeconomics" value="<%=studentscore.getHomeeconomics()==null?"":studentscore.getHomeeconomics() %>" ><br>
情報：<input type="text" name="info" value="<%=studentscore.getInfo()==null?"" :studentscore.getInfo()%>"><br>
合計点:<input type="text" name="sumscore" value="<%=studentscore.getSumscore() %>"><br>
平均点：<input type="text" name="avr" value="<%=studentscore.getAvr() %>"><br>
評価：<input type="text" name="rank" value="<%=studentscore.getRank() %>"><br>
出欠：<input type="text" name="attendance" value="<%=studentscore.getAttendance() %>"><br>
<input type="hidden" name="action" value="confirm">
<div class="update-button">
<p style="padding-right:80px;"><input type="submit" class="button" value="編集"></p><br>
</div>
</form>
</div>
<p style="margin-bottom:5px; text-align:right;"><a href="index.jsp">トップヘ</a></p><br>
<p style="text-align:right;"><a href="TestDisplayServlet">表示画面へ</a></p><br>

<%--エラーがあれば表示 --%>
<%if(errorMsg!=null){ %>
<p class="caution"><%=errorMsg %></p>
<%} %>
</div>
</body>
</html>