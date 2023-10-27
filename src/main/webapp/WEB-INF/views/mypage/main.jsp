<%@page import="com.daily.dto.WaterDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Daily Balance</title>
<%@include file="../layout/header.jsp" %>
</head>
<body>
	<div class="wrap">
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