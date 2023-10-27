<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/recipe/recipe.css">
<script src="<%=request.getContextPath() %>/resources/js/recipe/recipe.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<%@include file="../layout/header.jsp" %>
<title>Daily Balance</title>

</head>
<body>

<div class="container">
<!-- 나만의 레시피 내역 -->
<div class="myrecipe">
	<div class="myrecipe_list">
	</div>
</div>
<!-- 메인 영역 -->
<div class="recipe_search">

<div class="recipe_name">
	<input type="text" class="user_recipe_nmae" placeholder="레시피 이름">
	<button class="recipe_store">레시피 저장</button>
	<button class="new_recipe">새로운 레시피</button>
</div>

<div class="recipe_kdris">
	<span>메뉴명분량(g) | 열량(kcal) | 탄수화물(g) | 당류(g) | 단백질(g) | 지방(g) | 나트륨(mg) </span>
		<div class="recipe_kdris_info">

		</div>
</div>

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
	<div class="recipe_search_info">
		<c:forEach var="item" items="${ingredient_list}">
			<div>
				<span>${item.idx }</span>
				<span>${item.name}</span> /
				<span>${item.category}</span> /
				<span>${item.amount}</span> /	
				<sapn>${item.energy}</sapn> /			
				<span>${item.carb}</span> /
				<span>${item.sugar}</span> /
				<span>${item.protein}</span> /
				<span>${item.fat}</span> /
				<span>${item.sodium}</span> /
				<span><Button class="keep" onclick="keepbtn(${item.idx});">담기</Button></span>
			</div>
			<hr>
		</c:forEach>
	</div>

<!-- 페이징 버튼 -->
<div class="paging_region">
	<ul class="pagingview">
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
</div>
<!-- 장바구니 영역 -->
<div class="keep_ingredient">
	<div class="keep_data">

	</div>
</div>
</div>
<script>
$(".select_category").val("${category}").prop("selected", true);
</script>
</body>
</html>
