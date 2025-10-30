<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int studentid=(int)request.getAttribute("studentid");
String alertMsg=(String)request.getAttribute("alertMsg");
String errorMsg=(String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<title>削除確認画面</title>
</head>
<body>
<%if(errorMsg!=null){ %>
<%=errorMsg %>
<%} %>

<script>
"use strict";
const alertMsg="<%=alertMsg%>";
const studentid="<%=studentid%>";
if(confirm(alertMsg)){
	window.location.href="TestDeleteServlet?studentid="+studentid;
}
else{window.location.href="TestDisplayServlet";}
</script>

</body>
</html>