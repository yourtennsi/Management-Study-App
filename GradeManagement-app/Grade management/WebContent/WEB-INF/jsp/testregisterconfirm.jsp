<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Studentscore" %>
<%
Studentscore studentscore=(Studentscore)session.getAttribute("studentscore");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/personal.css">
<title>テスト登録前確認画面</title>
</head>
<body class="testregisterconfirm-page">
<div class="container">
<h2 style="font-size:40px; color:red;">登録確認</h2>
<p>
クラス:<%=studentscore.getClassnum() %><br>
テスト名：<%=studentscore.getTest_name() %><br>
出欠：<%if(studentscore.getAttendance()==true){%>
出席
<%} else{%>
欠席
<%} %><br>
生徒名：<%=studentscore.getStudentname() %><br>
国語：<%=studentscore.getJapanese() %>点<br>
英語：<%=studentscore.getEnglish() %>点<br>
数学：<%=studentscore.getMath() %>点<br>
理科：<%=studentscore.getScience() %>点<br>
社会：<%=studentscore.getSocialstudeies() %>点<br>
美術：<%=studentscore.getArt() %>点<br>
音楽：<%=studentscore.getMusic() %>点<br>
体育・保健<%=studentscore.getHealth() %>点<br>
技術：<%=studentscore.getIndustrialart() %>点
家庭科：<%=studentscore.getHomeeconomics() %>点<br>
情報：<%=studentscore.getInfo() %>点<br>
全科目合計点：<%=studentscore.getSumscore() %>点<br>
5教科平均点：<%=studentscore.getAvr() %>点<br>
評価/ランク：<%=studentscore.getRank() %><br>
</p>

<p>以上の項目を登録します</p>

<p style="color:red;">＊nullは成績が登録されていないことを意味します</p><br>
<p style="text-align:center; margin-bottom:3px; padding-right:50px;"><a href="TestRegisterServlet?action=done">登録</a></p><br>
<p style="text-align:center; padding-right:50px;"><a href="TestRegisterServlet">キャンセル</a></p>
</div>
</body>

</html>