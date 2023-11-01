<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/recipe/recipelayout.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/recipe/recipegraph.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/recipe/recipe.js"></script>


<%@include file="../layout/header.jsp"%>
<title>Daily Balance</title>


</head>
<body>
	<div class="container">
		<!-- 나만의 레시피 내역 -->
		<div class="myrecipe">
			<div class="myrecipe_list"></div>
		</div>
		<!-- 메인 영역 -->
		<div class="recipe_search">
			<div class="recipe_kdris">
				<div class="recipe_name">
					<input type="text" class="user_recipe_name" placeholder="레시피 이름">
					<button id="recipe_button" class="recipe_store">레시피 저장</button>
					<button id="recipe_button" class="new_recipe">새로운 레시피</button>
				</div>
				<ul class="recipe_kdris_list">
					<li>재료총량(g)</li>
					<li>열량(kcal)</li>
					<li>탄수화물(g)</li>
					<li>당류(g)</li>
					<li>단백질(g)</li>
					<li>지방(g)</li>
					<li>나트륨(mg)</li>
				</ul>
				<ul class="recipe_kdris_info">

				</ul>
				<div class="progress-region">
					<div class="progress-bar">
						<div class="progress energy"></div>
					</div>
					<div class="progress-bar">
						<div class="progress carb"></div>
					</div>
					<div class="progress-bar">
						<div class="progress sugar"></div>
					</div>
					<div class="progress-bar">
						<div class="progress protein"></div>
					</div>
					<div class="progress-bar">
						<div class="progress fat"></div>
					</div>
					<div class="progress-bar">
						<div class="progress sodium"></div>
					</div>
				</div>
			</div>

			<form action="main" name="recipe_search_form">
				<input type="hidden" name="pageNum" value="1"> <select
					name="category" class="select_category">
					<option value="">전체</option>
					<c:forEach var="item" items="${ingredient_category}">
						<option value="${item}">${item}</option>
					</c:forEach>
				</select> <input type="text" class="input_recipe_search" name="ingredient"
					placeholder="재료검색" value="${ingredient}"> <input
					type="button" class="ingredient_search" name="ingredient_search"
					value="검색">
			</form>
			<div class="recipe_search_info">
				<c:forEach var="item" items="${ingredient_list}">
					<div>
						<span>${item.idx }</span> <span>${item.name}</span> <span>${item.category}</span>
						<span>${item.amount}</span> <span>${item.energy}</span> <span>${item.carb}</span>
						<span>${item.sugar}</span> <span>${item.protein}</span> <span>${item.fat}</span>
						<span>${item.sodium}</span> <span><Button class="keep"
								onclick="keepbtn(${item.idx});">담기</Button></span>
					</div>
					<hr>
				</c:forEach>
			</div>

			<!-- 페이징 버튼 -->
			<div class="paging_region">
				<ul class="pagingview">
					<c:if test="${currentPage >= 1 }">
						<c:if test="${currentPage > 1}">
							<li><a
								href="main?pageNum=${currentPage-1}&category=${category}&ingredient=${ingredient}">이전</a></li>
						</c:if>
						<c:forEach var="i" begin="${start}" end="${end}">
							<li><a class="pagingbtn"
								href="main?pageNum=${i}&category=${category}&ingredient=${ingredient}">${i}</a></li>
						</c:forEach>
						<c:if test="${currentPage < pageNum }">
							<li><a
								href="main?pageNum=${currentPage+1}&category=${category}&ingredient=${ingredient}">다음</a></li>
						</c:if>
					</c:if>
				</ul>
			</div>
		</div>
		<!-- 장바구니 영역 -->
		<div class="keep_ingredient">
			<div class="keep_data"></div>
		</div>
	</div>
	<footer class="flex_footer">
		&copy; 2023 Daily Balance<br>
	</footer>
	<%
	String pageNum = request.getParameter("pageNum");
	if (pageNum == null) {
		pageNum = "1";
	}
	%>

	<script>
var jsPageNum = '<%=pageNum%>';
console.log(jsPageNum);	
var pagingButtons = document.querySelectorAll('.pagingbtn');
var thirdPagingBtn = pagingButtons[jsPageNum -1];

thirdPagingBtn.style.backgroundColor = '#525FE1';
thirdPagingBtn.style.color = '#ffffff';

$(".select_category").val("${category}").prop("selected", true);
</script>
</body>
</html>
