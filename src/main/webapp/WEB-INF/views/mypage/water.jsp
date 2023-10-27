<%@page import="com.daily.dto.WaterDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript"
	src="<%=contextPath %>/resources/js/water/waterScript.js"></script>
<link rel="stylesheet"
	href="<%=contextPath %>/resources/css/water/water.css?after">
<%
	request.setCharacterEncoding("UTF-8");
	String id = (String)session.getAttribute("id");
%>

<script>
$(function(){
	var height = "${height}";
	var waterguide = "${waterguide}";
	var water = "${water}";
	if(waterguide == "") {
		waterguide = 0;
	} else {
		waterguide = waterguide * 1000;
	}
	if(water == "") {
		water = 0;
	}
	var idChecked = false; // 아이디 확인을 한 번만 수행하도록 플래그 추가
	
	$('#waterAter').css('display', 'none');
	if(typeof height == "undefined" || height == "null" || height == 0 || height == "" ) {
	}
	else {
		console.log("height : " + height);
		$('.hwBefore').css('display', 'none');
		$('.hwAfter').css('display', 'none');
		$('#waterAter').css('display', 'flex');
		
		var waterVolume = Number(waterguide / 6);
		var quo = Number(water/waterVolume);
		var remain = Number(water%waterVolume);
		var selectedNumbers = [];
		for (var i = 1; i < quo; i++) {
		    selectedNumbers.push(i);
		}

		for (var j = 1; j <= 6; j++) {
		    if (selectedNumbers.indexOf(j) === -1) {
		    	$(".c"+j).css('background', '#fff');
		        $(".c"+j).find(".wave").css({display: 'none'}); 
		    }
		}
		$('.Today').html("<div>물병 하나당 "+Math.floor(waterVolume)+"(mL)씩이며 총 "+Math.floor(quo)+"개 추가됩니다</div>");
		
	}
	$('#reBtn').click(function(){
		$('.hwBefore').css('display', 'none');
		$('.hwAfter').css('display', 'flex');
		$('#waterAter').css('display', 'none'); 
		$('#height').val(${height});
		$('#weight').val(${weight});
		$('#wGuide').val(${waterguide});
	})
	
	$('#waterBtn').click(function() {
		var water = Number($('#water').val());
		if(water != 0) {
			const hHidden = $('#height').val();
			const wHidden = $('#weight').val();
		} else {
			$('.hwBefore').css('display', 'none');
			$('.hwAfter').css('display', 'flex');
			$('#waterAter').css('display', 'none');
			event.preventDefault();
			alert("오늘 먹은 물을 입력해주세요");
		}
	})
	
	function getOneIdSumbti() {
		if (idChecked) {
	        return; // 이미 확인했으면 더 이상 수행하지 않음
	    }
	    $.ajax({
	        type: 'GET',
	        url: 'waterIdSubmit',
	        dataType: 'json',
	        success: function(r) {
	        	console.log(r);
	        	if(r['rs'] == 0) {
	        		console.log("해당 아이디가 수분섭취 등록 하지 않으셨습니다");    	
        		}else {
	        		$('.hwBefore').css('display', 'none');
	        		$('.hwAfter').css('display', 'flex');
	        		$('#waterAter').css('display', 'none');
	        		$('.waterGuide').html(r['dto'].waterguide);
	        		$('#height').val(r['dto'].height);
	        		$('#weight').val(r['dto'].weight);
	        		$('#wGuide').val(r['dto'].waterguide);
	        	}
	        },
	        error: function(xhr, status, error) {
	            console.log(xhr, status, error);
	        }
	    });
	};
	
	 // #waterAter가 inline-block 일 때 아이디 확인을 수행
     if ($('#waterAter').css('display') === 'flex') {
    	 console.log("나오지 않습니다");
     } else if ($('#waterAter').css('display') === 'none') {
         getOneIdSumbti();
     }
		
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
						<input type="text" placeholder="키를 입력해주세요" id="height2"
							class="height" value=""> <input type="text"
							placeholder="몸무게를 입력해주세요" id="weight2" class="weight" value="">
					</div>
					<input type="button" value="입력" id="hwBtn">
				</div>
			</div>
			<div class="hwAfter">
				<div>컵 이미지</div>
				<div class="hwInputBox">
					<input type="hidden" value="" id="waterHidden">
					<div class="guide">
						하루에 드셔야 할 물 총량 <div class="waterGuide"></div>(mL)
					</div>
					<div class="guide">
						<div>오늘 드신 물</div>
						<input type="text" placeholder="ml" id="water" name="water"value=""> (mL) 
						<input type="hidden" id="height" value=""name="height"> 
						<input type="hidden" id="weight" value=""name="weight"> 
						<input type="hidden" id="wGuide" value=""name="waterguide"> 
						<input type="hidden" id="id" name="id"value="<%=id%>">
					</div>
					<input type="submit" value="입력" id="waterBtn">
				</div>
			</div>
			<div id="waterAter">
				<div class="circle_box">
					<div class="cInnerBox">
						<div class="circle c1">
							<div class="wave"></div>
						</div>
						<div class="circle c2">
							<div class="wave"></div>
						</div>
						<div class="circle c3">
							<div class="wave"></div>
						</div>
					</div>
					<div class="cInnerBox">
						<div class="circle c4">
							<div class="wave"></div>
						</div>
						<div class="circle c5">
							<div class="wave"></div>
						</div>
						<div class="circle c6">
							<div class="wave"></div>
						</div>
					</div>
				</div>
				<div>
					<h3>
						<div>${id}님의오늘 드신 물 양은 " ${water} (mL)" 입니다</div>
						<div>오늘 하루 드셔야 될 물 총량은 " ${waterguide} (L) "</div>
						<div class="Today"></div>
					</h3>
					<input type="button" value="물 입력하기" id="reBtn">
				</div>
			</div>
		</div>
	</form>
</div>