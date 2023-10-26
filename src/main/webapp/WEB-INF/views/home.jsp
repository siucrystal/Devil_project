<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<html>
<head>
	<title>Daily Balance</title>
</head>
<body>
<h1>
	Hello world! 
</h1>
<a href="<%=contextPath %>/member/main">로그인</a>
<a href="<%=contextPath %>/food/foodlist">음식목록</a>
<a href="<%=contextPath %>/recipe/main">레시피제작</a>
</body>
</html>
