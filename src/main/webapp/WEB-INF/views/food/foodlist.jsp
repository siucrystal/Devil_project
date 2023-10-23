<%@page import="com.daily.dto.FoodDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	request.setCharacterEncoding("utf-8");
	
	List<FoodDTO> list = (List<FoodDTO>)request.getAttribute("list");
    %>
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
				<option value="곡류 및 서류">곡류 및 서류</option>
				<option value="과자류">과자류</option>
				<option value="구이류">구이류</option>
				<option value="국 및 탕류">국 및 탕류</option>
				<option value="기타">기타</option>
				<option value="김치류">김치류</option>
				<option value="면 및 만두류">면 및 만두류</option>
				<option value="밥류">밥류</option>
				<option value="볶음류">볶음류</option>
				<option value="빵류">빵류</option>
				<option value="생채및 무침류">생채 및 무침류</option>
				<option value="숙채류">숙채류</option>
				<option value="아이스크림류">아이스크림류</option>
				<option value="음료 및 차류">음료 및 차류</option>
				<option value="장아찌 및 절임류">장아찌 및 절임류</option>
				<option value="전.적 및 부침류">전.적 및 부침류</option>
				<option value="젓갈류">젓갈류</option>
				<option value="조림류">조림류</option>
				<option value="죽 및 스프류">죽 및 스프류</option>
				<option value="찜류">찜류</option>
				<option value="튀김류">튀김류</option>
				<option value="포류">포류</option>
				<option value="회류">회류</option>
			</select></td>
			<td><input type="text" placeholder="식품명" name="name"></td><td><input type="submit" value="검색"></td>
		</form>
	</tr>
	<tr><th>메뉴명</th><th>분량</th><th>탄수화물</th><th>당류</th><th>단백질</th><th>지방</th><th>나트륨</th></tr>
	<%for (FoodDTO dto : list) {%>
	<tr>
		<td><%=dto.getName() %></td>
		<td><%=dto.getAmount() %></td>
		<td><%=dto.getCarb() %></td>
		<td><%=dto.getSugar() %></td>
		<td><%=dto.getProtein() %></td>
		<td><%=dto.getFat() %></td>
		<td><%=dto.getSodium() %></td>
	</tr>
	<%} %>
	</table>
</body>
</html>