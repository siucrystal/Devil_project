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
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	
	window.onload = function(){
		// 1. 달력 세팅
		$("#datepicker").datepicker({
	      dateFormat: "yy-mm-dd",
    	  onSelect: function(dateText, inst) {
              // 날짜가 선택될 때 호출될 함수
    		  selectMyFoodList();
            }
	    });
		
		$("#calendar-button").on("click", function() {
	      $("#datepicker").datepicker("show");
	    });
		
		// 2. food 리스트 조회
		selectFoodList();
		
		// 3. my food 리스트 조회
		selectMyFoodList();
	};
	
	/*
	 * food 리스트 조회
	 */
	function selectFoodList(page) {
		
		var name = document.getElementById('name').value;
		
		var selectElement = document.getElementById('category');
		var selectedValue = selectElement.value;
		var category = selectElement.options[selectElement.selectedIndex].value;
		
		$.ajax({
	        url: "selectFoodList",
	        type: "POST",
	        data: {
	        	'category' : category,
	        	'name' : name,
	        	'page' : page
	        },
	        dataType: "json",
	        success: function(data) {

	          var list = data.list
	          var put = "";

	          for(let i=0;i<data.list.length;i++){
	        	  const idx = list[i].idx
	        	  const name = list[i].name
	        	  const amount = list[i].amount
	        	  const energy = list[i].energy
	        	  const carb = list[i].carb
	        	  const sugar = list[i].sugar
	        	  const protein = list[i].protein
	        	  const fat = list[i].fat
	        	  const sodium = list[i].sodium
	        	  const date = list[i].date
	        	  put += '<div class="menu_body"><span>' + name + '</span><span>' + amount + '</span><span>' + energy + '</span><span>' + carb + '</span><span>' + sugar + '</span><span>' + protein + '</span><span>' + fat + '</span><span>' + sodium + '</span>'
	              + '<span><button class="keep" onclick="insertBtn(' + idx + ');">담기</button></span></div>';
	          }
	          
	          $('.food_body').html(put);
	          
	          var paging = data.paging;
	          var html = "";

	          if(paging.page<=1) {
	          	html += '<span></span>';
	          } else {
	          	html += '<a href="#" onclick=selectFoodList(' + (paging.page-1) + ')>prev</a>';
	          }

	          for(var i=paging.startPage; i<=paging.endPage; i++) {
	          	if(i == paging.page) {
	          		html += '<a>' + i + '</a>';
	          	} else {
	          		html += '<a href="#" onclick=selectFoodList(' + i + ')>' +i + '</a>';
	          	}
	          }


	          if(paging.page >= paging.maxPage) {
	          	html += '<span></span>';
	          } else {
	          	html += '<a href="#" onclick=selectFoodList(' + (paging.page+1) + ')>next</a>';
	          }

	           $('.button').html(html);

	        },
	        error: function (xhr, status, error) {
	          	console.log("에러발생!");
	            console.log(xhr, status, error);
	        }
	    })
	    
	}
	
	/*
	 * my food 리스트 조회
	 */
	function selectMyFoodList() {
		var date = document.getElementById('datepicker').value.substr(2);
		
		$.ajax({
	        url: "selectMyFoodList",
	        type: "POST",
	        data: {date},
	        dataType: "json",
	        success: function(data) {
	          
	        	var list = data.list
				var put = "";
	        	
				for(let i=0;i<data.list.length;i++){
					 const idx = list[i].idx
					 const name = list[i].name
					 const amount = list[i].amount
					 const energy = list[i].energy
					 const carb = list[i].carb
					 const sugar = list[i].sugar
					 const protein = list[i].protein
					 const fat = list[i].fat
					 const sodium = list[i].sodium
					 const date = list[i].date
					 put += '<div class="menu_body"><span>' + name + '</span><span><input type="text" id="amount' + idx + '" value="' + amount + '"></span><span>' + energy + '</span><span>' + carb + '</span><span>' + sugar + '</span><span>' + protein + '</span><span>' + fat + '</span><span>' + sodium + '</span>'
					    + '<span><button class="keep" onclick="updatebtn(' + idx + ');">수정</button></span>'
					    + '<span><button class="keep" onclick="deletebtn(' + idx + ');">삭제</button></span></div>';
				}
				
				$('.myfood_body').html(put);
	        },
	        error: function (xhr, status, error) {
	           	console.log("에러발생!");
	            console.log(xhr, status, error);
	        }
	    })
		
	}
	
	/*
	 * [담기]
	 */
	function insertMyFood(idx) {
	    
		var date = document.getElementById('datepicker').value.substr(2);
		
		$.ajax({
	        url: "insertMyFood",
	        type: "POST",
	        data: {idx, date},
	        dataType: "json",
	        success: function(data) {

	          var list = data.list
	          var put = "";

	          for(let i=0;i<data.list.length;i++){
	        	  const idx = list[i].idx
	        	  const name = list[i].name
	        	  const amount = list[i].amount
	        	  const energy = list[i].energy
	        	  const carb = list[i].carb
	        	  const sugar = list[i].sugar
	        	  const protein = list[i].protein
	        	  const fat = list[i].fat
	        	  const sodium = list[i].sodium
	        	  put += '<div class="menu_body"><span>' + name + '<span><input type="text" id="amount' + idx + '" value="' + amount + '"></span>' + energy + '</span><span>' + carb + '</span><span>' + sugar + '</span><span>' + protein + '</span><span>' + fat + '</span><span>' + sodium + '</span>'
	        	  + '<span><button class="keep" onclick="updatebtn(' + idx + ');">수정</button></span>'
	        	  + '<span><button class="keep" onclick="deletebtn(' + idx + ');">삭제</button></span></div>';
	
	          }
	          
	          $('.myfood_body').html(put)
	        },
	        error: function (xhr, status, error) {
	           console.log("에러발생!");
	            console.log(xhr, status, error);
	        }
	    })
	}
	
	/*
	 * [수정]
	 */
	function updateMyFood(idx, uamount) {
	    
		$.ajax({
	        url: "updateMyFood",
	        type: "POST",
	        data: {idx, uamount},
	        dataType: "json",
	        success: function(data) {

	          var list = data.list
	          var put = "";

	          for(let i=0;i<data.list.length;i++){
	        	  const idx = list[i].idx
	        	  const name = list[i].name
	        	  const amount = list[i].amount
	        	  const energy = list[i].energy
	        	  const carb = list[i].carb
	        	  const sugar = list[i].sugar
	        	  const protein = list[i].protein
	        	  const fat = list[i].fat
	        	  const sodium = list[i].sodium
	        	  const date = list[i].date
	        	  put += '<div class="menu_body"><span>' + name + '</span><span><input type="text" id="amount' + idx + '" value="' + amount + '"></span><span>' + energy + '</span><span>' + carb + '</span><span>' + sugar + '</span><span>' + protein + '</span><span>' + fat + '</span><span>' + sodium + '</span>'
	              + '<span><button class="keep" onclick="updatebtn(' + idx + ');">수정</button></span>'
	              + '<span><button class="keep" onclick="deletebtn(' + idx + ');">삭제</button></span></div>';
	          }
	          $('.myfood_body').html(put);
	        },
	        error: function (xhr, status, error) {
	           console.log("에러발생!");
	            console.log(xhr, status, error);
	        }
	    })
	    
	}
	
	/*
	 * [삭제]
	 */
	function deleteMyFood(idx) {
	    
		$.ajax({
	        url: "deleteMyFood",
	        type: "POST",
	        data: {idx},
	        dataType: "json",
	        success: function(data) {

	          var list = data.list
	          var put = "";

	          for(let i=0;i<data.list.length;i++){
	        	  const idx = list[i].idx
	        	  const name = list[i].name
	        	  const amount = list[i].amount
	        	  const energy = list[i].energy
	        	  const carb = list[i].carb
	        	  const sugar = list[i].sugar
	        	  const protein = list[i].protein
	        	  const fat = list[i].fat
	        	  const sodium = list[i].sodium
	        	  const date = list[i].date
	        	  put += '<div class="menu_body"><span>' + name + '</span><span><input type="text" id="amount' + idx + '" value="' + amount + '"></span><span>' + energy + '</span><span>' + carb + '</span><span>' + sugar + '</span><span>' + protein + '</span><span>' + fat + '</span><span>' + sodium + '</span>'
	              + '<span><button class="keep" onclick="updatebtn(' + idx + ');">수정</button></span>'
	              + '<span><button class="keep" onclick="deletebtn(' + idx + ');">삭제</button></span></div>';
	          }
	          $('.myfood_body').html(put);
	        },
	        error: function (xhr, status, error) {
	           console.log("에러발생!");
	            console.log(xhr, status, error);
	        }
	    })
	    
	}
	
	function insertBtn(idx) {
		insertMyFood(idx);
	}
	
	function updatebtn(idx){
		var uamount = document.getElementById("amount"+idx).value;
		updateMyFood(idx, uamount)
	}
	
	function deletebtn(idx){
		deleteMyFood(idx)
	}
	
</script>

<link rel="stylesheet" href="<%=contextPath %>/resources/css/food/food.css"> 
<%@include file="../layout/header.jsp" %>

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
				<!-- <input type="submit" value="검색"> -->
				  <button onclick="selectFoodList()">검색</button>
			</span>
		</div>
	
	    <!--메뉴 헤더-->
	    <div class="menu">
		<div class="menu_head"><span>메뉴명</span><span>분량(g)</span><span>열량(kcal)</span><span>탄수화물(g)</span><span>당류(g)</span><span>단백질(g)</span><span>지방(g)</span><span>나트륨(mg)</span></div>
		
		<!--메뉴 바디-->
		<div class="food_body">
		    <%-- <c:forEach var="dto" items="${list }">
					<div class="menu_body">
						<span>${dto.name}</span>
						<span>${dto.amount}</span>
						<span>${dto.energy}</span>
						<span>${dto.carb}</span>
						<span>${dto.sugar}</span>
						<span>${dto.protein}</span>
						<span>${dto.fat}</span>
						<span>${dto.sodium}</span>
						<span><Button class="keep" onclick="insertBtn(${dto.idx});">담기</Button></span>
					</div>
			</c:forEach> --%>
		</div>
		</div>
		
	    <!--페이징-->
		<div class="button">
			<%-- <c:choose>
				<c:when test="${paging.page<=1}">
					<span></span>
				</c:when>
				<c:otherwise>
					<a href="/daily/food/foodlist?page=${paging.page-1}&category=${paging.category}&name=${paging.name}">prev</a>
				</c:otherwise>
			</c:choose>
			
			<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
				<c:choose>
				<c:when test ="${i eq paging.page}">
					<a>${i}</a>
				</c:when>
				<c:otherwise>
					<a href="/daily/food/foodlist?page=${i}&category=${paging.category}&name=${paging.name}">${i}</a>
				</c:otherwise>
				</c:choose>			
			</c:forEach>
			
			<c:choose>
				<c:when test="${paging.page >= paging.maxPage }">
				</c:when>
				<c:otherwise>
					<a href="/daily/food/foodlist?page=${paging.page+1}&category=${paging.category}&name=${paging.name}">next</a>
				</c:otherwise>
			</c:choose> --%>
		</div> 
	</div>
	
	<!-- ------------------------------------------ -->
	<div class = "myfood">
	    <!--검색 기능-->
		<div class="search">
				<%-- <span>
					<select name="date">
						<c:forEach var="dto" items="${datelist }">
							<option value="${dto.date}">${dto.date}</option>
						</c:forEach>
					</select>
				</span> --%>
			<div class="datepicker-container">
			    <input type="text" id="datepicker" class="datepicker-input" value="<%= koreanDate %>">
			    <button class="calendar-button" id="calendar-button">달력</button>
		  	</div>
		</div>
	    <!--메뉴 헤더-->
	    <div class="menu">
		<div class="menu_head"><span>메뉴명</span><span>분량(g)</span><span>열량(kcal)</span><span>탄수화물(g)</span><span>당류(g)</span><span>단백질(g)</span><span>지방(g)</span><span>나트륨(mg)</span></div>
		<!--메뉴 바디-->
		<div class=" myfood_body">
		<%-- <c:forEach var="dto" items="${mylist }">
			<div class="menu_body">
				<span>${dto.name}</span>
				<span><input type="text" value="${dto.amount}" id="amount${dto.idx }" ></span>
				<span>${dto.energy}</span>
				<span>${dto.carb}</span>
				<span>${dto.sugar}</span>
				<span>${dto.protein}</span>
				<span>${dto.fat}</span>
				<span>${dto.sodium}</span>
				<span><Button class="keep" onclick="updatebtn(${dto.idx})">수정</Button></span>
				<span><Button class="keep" onclick="deletebtn(${dto.idx})">삭제</Button></span>
			</div>
		</c:forEach> --%>
		</div>
		</div>
	</div>
</div>
</body>
</html>