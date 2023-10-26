<%@page import="com.daily.dto.WaterDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/js/waterScript.js"></script>
<link rel="stylesheet" href="<%=contextPath %>/resources/css/water.css?after">
<%
	request.setCharacterEncoding("UTF-8");
	String id = (String)session.getAttribute("id");
%>

<script>
$(function(){
	var height = "${height}";
	console.log("id : "+ "<%=id%>");
	if(typeof height == "undefined" || height == "null" || height == 0 || height == "" ) {
		console.log("height : " + height);
		$('#waterAter').css('display', 'none');
	}
	else {
		console.log("height : " + height);
		$('.hwBefore').css('display', 'none');
		$('.hwAfter').css('display', 'none');
		$('#waterAter').css('display', 'inline-block');
	}
	$('#reBtn').click(function(){
		$('.hwBefore').css('display', 'none');
		$('.hwAfter').css('display', 'flex');
		$('#waterAter').css('display', 'none');
		$('#height').val(${height});
		$('#weight').val(${weight});
		$('#wGuide').val(${waterguide});
	})
		
	
});
</script>

<div>
	<%-- <%=dto.getId()%>
	<%=dto.getWaterguide()%> --%>
	<form action="water" method="GET">
		<div class="waterIntakeBox">
			<div class="hwBefore">
				<div class="hwInputBox">
					<div class="hwBox">
						<input type="text" placeholder="키를 입력해주세요"  id="height2" class="height" value="">
						<input type="text" placeholder="몸무게를 입력해주세요" id="weight2" class="weight" value="">
					</div>
					<input type="button" value="입력" id="hwBtn">
				</div>
			</div>
			<div class="hwAfter">
				<div>컵 이미지</div>
				<div class="hwInputBox">
					<input type="hidden" value="" id="waterHidden">
					<div class="guide">하루에 드셔야 할 물 총량 <div class="waterGuide"></div> (mL)</div>
					<div class="guide">
						<div>오늘 드신 물</div>
						<input type="text" placeholder="ml"  id="water" name ="water" value=""> (mL)
						<input type="hidden" id="height" value="" name="height">
						<input type="hidden" id="weight" value="" name="weight">
						<input type="hidden" id="wGuide" value="" name="waterguide">
						<input type="hidden" id="id" name="id" value="<%=id%>">
					</div>
					<input type="submit" value="입력" id="waterBtn">
				</div>
			</div>
			<div id="waterAter">
				<h3>
					<div>${id}님의 오늘 드신 물 양은 " ${water} " 입니다</div> 
					<div>오늘 하루 드셔야 될 물 총량은 " ${waterguide} "</div>
				</h3>
				<input type="button" value="물 입력하기" id="reBtn">
			</div>
		</div>
	</form>
</div>