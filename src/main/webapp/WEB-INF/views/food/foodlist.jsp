<%@page import="com.daily.dto.PageDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.daily.dto.FoodDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<tr>
		<form action="foodlist" method="post" >
			<td><select name="category">
				<c:forEach var="dto" items="${category }">
					<option value="${dto.category}">${dto.category}</option>
				</c:forEach>
			</select></td>
			<td><input type="text" placeholder="식품명" name="name"></td><td><input type="submit" value="검색"></td>
		</form>
	</tr>
	<tr><th>메뉴명</th><th>분량(g)</th><th>열량(kcal)</th><th>탄수화물(g)</th><th>당류(g)</th><th>단백질(g)</th><th>지방(g)</th><th>나트륨(mg)</th></tr>
	<c:forEach var="dto" items="${list }">
	<tr><td>${dto.name}</td><td>${dto.amount}</td><td>${dto.energy}</td><td>${dto.carb}</td><td>${dto.sugar}</td><td>${dto.protein}</td><td>${dto.fat}</td><td>${dto.sodium}</td></tr>
	</c:forEach>
	</table>
	
	<div class="button">
		<c:choose>
			<c:when test="${paging.page<=1}">
				<span></span>
			</c:when>
			<c:otherwise>
				<a href="/daily/food/foodlist?page=${paging.page-1}">prev</a>
			</c:otherwise>
		</c:choose>
		
		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
			<c:choose>
			<c:when test ="${i eq paging.page}">
				<a>${i}</a>
			</c:when>
			<c:otherwise>
				<a href="/daily/food/foodlist?page=${i}">${i}</a>
			</c:otherwise>
			</c:choose>			
		</c:forEach>
		
		<c:choose>
			<c:when test="${paging.page >= paging.maxPage }">
			</c:when>
			<c:otherwise>
				<a href="/daily/food/foodlist?page=${paging.page+1}">next</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>