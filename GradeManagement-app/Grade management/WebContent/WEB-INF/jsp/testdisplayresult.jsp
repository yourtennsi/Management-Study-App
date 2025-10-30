<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList,java.util.List" %>
<%@page import="model.Studentscore" %>
<% List<Studentscore> studentscoreList=(List<Studentscore>)request.getAttribute("studentscoreList");%>
<%String errorMsg=(String)request.getAttribute("errorMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/personal.css">
<title>テスト結果閲覧画面</title>
</head>
<body>
<div class="container">
<h2 style="font-size:40px;">成績結果一覧</h2>

<%if(studentscoreList!=null && !studentscoreList.isEmpty()){

	for(Studentscore studentscore:studentscoreList){%>
	<div class="student-score">
	<p>Id:<%=studentscore.getId() %>:クラス名:<%=studentscore.getClassnum()%> テスト名:<%=studentscore.getTest_name() %> 出欠:<%if(studentscore.getAttendance()==true){%>出席<%}else{ %>欠席<%} %><br>生徒名:<%=studentscore.getStudentname() %><br>
	国語:<%=studentscore.getJapanese()%>点 英語<%=studentscore.getEnglish() %>点 数学:<%=studentscore.getMath() %>点 理科:<%=studentscore.getScience() %>点 社会:<%=studentscore.getSocialstudeies() %>点<br>
	美術：<%=studentscore.getArt() %>点 音楽:<%=studentscore.getMusic() %>点 保健・体育:<%=studentscore.getHealth() %>点 技術<%=studentscore.getIndustrialart()%>点 家庭科<%=studentscore.getHomeeconomics() %>点<br>
	情報:<%=studentscore.getInfo() %>点<br><strong>全科目合計点</strong>:<%=studentscore.getSumscore() %>点 <strong>5教科平均点</strong><%=studentscore.getAvr()%>点 <strong>ランク</strong>:<%=studentscore.getRank() %>
	</p><br>
	</div>
	<form action="TestDeleteServlet" method="post">
	<input type="hidden" name="studentid" value="<%=studentscore.getId()%>">

	<div class="delete-button">
	<input type="submit" class="button"value="削除">
	</div>
	</form>
	<form action="TestUpdateServlet"method="post">
	<input type="hidden" name="studentid" value="<%=studentscore.getId()%>">
	<div class="update-button">
	<input type="submit" class="button" value="更新">
	</div>
	</form>

	<%} }else{%>
	<p>データが存在しません</p>
	<%} %>

<p style="color:red;">*nullはテストがなかったことを意味します</p>
<p style="margin-bottom:3px; text-align:right;"><a href="TestDisplayServlet">戻る</a></p><br>
<p style="text-align:right;"><a href="index.jsp">トップページへ</a><br></p>

<%if(errorMsg!=null){ %>
<p style="color:red;"><%= errorMsg %></p>
<%} %>
</div>
</body>
</html>