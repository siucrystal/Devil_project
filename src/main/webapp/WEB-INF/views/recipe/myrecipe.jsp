<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=contextPath %>/resources/css/recipe/recipe.css">
<script src="<%=contextPath %>/resources/js/recipe/recipe.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<title>Daily Balance</title>
</head>
<body>

<div class="recipe_search">
<form action="main" name="recipe_search_form">
	<input type="hidden" name="pageNum" value="1">
	<select name="category" class="select_category">
		<option value="">전체</option>
		<c:forEach var="item" items="${ingredient_category}">
			<option value="${item}">${item}</option>
		</c:forEach>
	</select>
	<input type="text" name="ingredient" placeholder="재료검색" value="${ingredient}">
	<input type="button" class="ingredient_search" name="ingredient_search" value="검색">
	</form>
	<div>
		<c:forEach var="item" items="${ingredient_list}">
			<div>
				<span>${item.name}</span> /
				<span>${item.category}</span> /
				<span>${item.amount}</span> /	
				<sapn>${item.energy}</sapn> /			
				<span>${item.carb}</span> /
				<span>${item.sugar}</span> /
				<span>${item.protein}</span> /
				<span>${item.fat}</span> /
				<span>${item.sodium}</span> /
			</div>
			<hr>
		</c:forEach>
	</div>
</div>
<div>
	<ul>
	<c:if test="${currentPage >= 1 }">
		<c:if test="${currentPage > 1}">
			<li><a href="main?pageNum=${currentPage-1}&category=${category}&ingredient=${ingredient}">이전</a></li>
		</c:if>
		<c:forEach var="i" begin="${start}" end="${end}">
			<li><a href="main?pageNum=${i}&category=${category}&ingredient=${ingredient}">${i}</a></li>
		</c:forEach>
		<c:if test="${currentPage < pageNum }">
			<li><a href="main?pageNum=${currentPage+1}&category=${category}&ingredient=${ingredient}">다음</a></li>
		</c:if>
	</c:if>
	</ul>
</div>

<script>
$(".select_category").val("${category}").prop("selected", true);
</script>
</body>
</html>
