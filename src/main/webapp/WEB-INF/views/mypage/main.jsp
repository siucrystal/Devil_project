<%@page import="com.daily.dto.WaterDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Daily Balance</title>

</head>
<body>
메인화면
	<div class="wrap">
		<header>
			<a href="<%=contextPath %>/mypage/main" class="homeBtn">홈</a>
			<a href="<%=contextPath %>/member/logout">로그아웃</a>
			<a href="<%=contextPath %>/food/foodlist">음식목록</a>
			<!-- <a href="#">로그아웃</a> -->
		</header>
		<hr> <br>
		<main>
			<div class="mainBoard">
				<div class="gaugeBox">
					<div class="gInnerBox"></div>	
				</div>
				<div class="writeListBox">
					<div class="wlInnerBox">
						<jsp:include page="./water.jsp"></jsp:include> 
					</div>
				</div>
			</div>
		</main>
	
	</div>
</body>
</html>