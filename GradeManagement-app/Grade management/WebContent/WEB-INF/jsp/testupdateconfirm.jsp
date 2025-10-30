<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="model.Studentscore"%>
<%Studentscore studentscore=(Studentscore)session.getAttribute("studentscore") ;
String errorMsg=(String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/personal.css">
<title>編集確認画面</title>
</head>
<body class="testupdateconfirm-page">
<div class="container">
<h2 style="font-size:40px;">確認</h2>
クラス：<%=studentscore.getClassnum() %><br>
テスト名：<%=studentscore.getTest_name() %><br>
出欠：<%if(studentscore.getAttendance()==true){ %>
出席<%}else{ %>
欠席<%} %><br>
<%--nullは、""にする処理がひつようか --%>

学生氏名：<%=studentscore.getStudentname() %><br>
国語:<%=studentscore.getJapanese() %>点<br>
英語:<%=studentscore.getEnglish() %>点<br>
数学:<%=studentscore.getMath()%>点<br>
理科：<%=studentscore.getScience() %>点<br>
社会：<%=studentscore.getSocialstudeies() %>点<br>
美術：<%=studentscore.getArt() %>点<br>
音楽：<%=studentscore.getMusic() %>点<br>
保健・体育<%=studentscore.getHealth() %>点<br>
技術：<%=studentscore.getIndustrialart() %>点<br>
情報：<%=studentscore.getInfo() %>点<br>
合計点:<%=studentscore.getSumscore() %>点<br>
5教科平均点：<%=studentscore.getAvr() %>点<br>
評価：<%=studentscore.getRank() %><br>

<p style="color:red;">＊nullはテストがなかったことを意味します</p>

<p>以上で変更しますか？</p>




<form action="TestUpdateServlet" method="post">
<input type="hidden" name="action" value="done">
<input type="hidden" name="studentid" value="<%=studentscore.getId()%>">
<div class="update-button">
<p style="padding-right:80px;"><input type="submit" class="button"value="編集"></p>
</div>


<%---idの値がエラーの場合 --%>
<%if(errorMsg!=null){ %>
<p class="caution"><%=errorMsg %></p>
<%} %>
</form>
<p style="text-align:right;"><a href="TestDisplayServlet">戻る</a><br></p>
<p style="text-align:right;"><a href="index.jsp">トップページへ</a></p>
</div>
</body>
</html>