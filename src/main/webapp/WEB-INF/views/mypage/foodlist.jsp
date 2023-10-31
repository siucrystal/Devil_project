<%@page import="com.mysql.cj.Session"%>
<%@page import="com.daily.dto.PageDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.daily.dto.FoodDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String contextPath = request.getContextPath();
	java.util.Date today = new java.util.Date();
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
    String koreanDate = dateFormat.format(today);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<script src="<%=contextPath %>/resources/js/food/food.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="<%=contextPath %>/resources/css/food/food.css"> 

<title>Insert title here</title>
</head>
<body>
<div class = "food">
	<div class = "foodlist">
	    <!--검색 기능-->
		<div class="search">
			<span>
				<select id="category">
					<option value="">전체</option>
					<c:forEach var="dto" items="${category }">
						<option value="${dto.category}">${dto.category}</option>
					</c:forEach>
				</select>
			</span>
			<span>
				<input type="text" placeholder="식품명" id="name">
			</span>
			<span>
				  <button onclick="selectFoodList()" class="cateBtn">검색</button>
			</span>
		</div>
	
	    <!--메뉴 헤더-->
	    <div class="menu">
		<div class="menu_head food_head">
			<span>메뉴명</span>
			<span class="menu_flexStyle">분량<span>(g)</span></span>
			<span class="menu_flexStyle">열량<span>(kcal)</span></span>
			<span class="menu_flexStyle">탄수화물<span>(g)</span></span>
			<span class="menu_flexStyle">당류<span>(g)</span></span>
			<span class="menu_flexStyle">단백질<span>(g)</span></span>
			<span class="menu_flexStyle">지방<span>(g)</span></span>
			<span class="menu_flexStyle">나트륨<span>(mg)</span></span>
		</div>
		
		<!--메뉴 바디-->
		<div class="food_body">
		</div>
		</div>
		
	    <!--페이징-->
		<div class="button">
		</div> 
	</div>
	
	<!-- ------------------------------------------ -->
	<div class = "myfood">
	    <!--검색 기능-->
		<div class="search">
			<div class="datepicker-container">
			    <input type="text" id="datepicker" class="datepicker-input" value="<%= koreanDate %>">
			    <button class="calendar-button" id="calendar-button">달력</button>
		  	</div>
		</div>
	    <!--메뉴 헤더-->
	    <div class="menu">
		<div class="menu_head myfood_head">
			<span>메뉴명</span>
			<span class="menu_flexStyle">분량<span>(g)</span></span>
			<span class="menu_flexStyle">열량<span>(kcal)</span></span>
			<span class="menu_flexStyle">탄수화물<span>(g)</span></span>
			<span class="menu_flexStyle">당류<span>(g)</span></span>
			<span class="menu_flexStyle">단백질<span>(g)</span></span>
			<span class="menu_flexStyle">지방<span>(g)</span></span>
			<span class="menu_flexStyle">나트륨<span>(mg)</span></span>
		</div>
		<!--메뉴 바디-->
		<div class=" myfood_body ">
		</div>
		</div>
	</div>
</div>
</body>
</html>