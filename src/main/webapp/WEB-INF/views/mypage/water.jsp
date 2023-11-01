<%@page import="com.daily.dto.WaterDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/js/water/waterScript.js"></script>
<link rel="stylesheet" href="<%=contextPath %>/resources/css/water/water.css?after">
<link rel="stylesheet" href="<%=contextPath %>/resources/css/water/button.css?after">
<link rel="stylesheet" href="<%=contextPath %>/resources/css/font/font.css?after">
<link rel="stylesheet" href="<%=contextPath %>/resources/css/main.css?after">

<link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kanit:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
<%
	request.setCharacterEncoding("UTF-8");
	String id = (String)session.getAttribute("id");
%>
<style>
.hwInputBox {
	display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}
	#form {
		display: flex;
		justify-content: center;
		align-items: center;
	}
::selection {
   background: #b2d7fc;
   color: #fff;
}
	.box1 {
	overflow: hidden;
	}
	.font {
    	font-family: 'ScoreDream';
	}
	.waterIntakeBox {
		/* height: 33.33vh; */
	    padding: 50px 0;
	    box-sizing: border-box;
		overflow: hidden !important;
	}
	/* .hwInputBox {
	    height: 33.33vh;
	    padding: 80px 0;
	    box-sizing: border-box;
	} */
	#height2,
	#weight2 {
	 	border: 3px solid #ddd;
	    outline: none;
	    background: #fbfbfb;
	    padding: 10px;
	    border-radius: 10px;
	    color: #525FE1;
	    text-align: center;
		font-weight: 500;
    	margin-left: 10px;
	}
	.hwBox {
		display: flex;
		gap: 5px;
		justify-content: center;
		font-weight: 500;
		flex-direction: column;
	}
	.hwBox > div:first-child {    
		padding-left: 30px;
    	box-sizing: border-box;
	}
	#returnHW,
	#reBtn,
	#waterBtn,
	#hwBtn {
	    font-family: 'SCoreDream';
	    font-weight: 500;
	    width: 240px;
	    border-radius: 10px;
	    border: none;
	    padding: 5px 15px;
	    cursor: pointer;
	}
	#returnHW,
	#reBtn,
	#waterBtn {margin-top: 15px;}
	
	#returnHW:hover,
	#reBtn:hover,
	#waterBtn:hover,
	#hwBtn:hover {
	    background: #525FE1;
    	color: #fff;
	}
	.guideBox {
	    padding: 5px 10px;
	    display: flex;
	    align-items: center;
	    gap: 10px;
	}
	.waterfont {
		font-size: 30px !important;
	 	color: #525FE1 !important;
	 }
	.kfont {
		font-weight: 700;
	    color: #525FE1;
	    font-size: 20px;
	    font-family: 'Kanit';
	}
	.kfont2 {
		font-weight: 500;
	    color: #525FE1;
	    font-size: 17px;
	    font-family: 'Kanit';
	}
	.waterGuide {
	    font-weight: 700;
	    color: #525FE1;
	    font-size: 30px;
	    font-family: 'Kanit';
    }
    .qu {
    	font-size: 20px;
    	font-weight: 700;
    }
    .guide{align-items: center;}
    .border {
        border-left: 2px solid #ddd;
    padding-left: 20px;
    }
    #water {
    	border: 3px solid #ddd;
	    border-radius: 10px;
	    padding: 5px 15px;
	    text-align: right;
	    background: #f9f9f9;
	    outline: none;
    }
    
    #waterAter {
    	gap: 30px;  
   	}
   	.Today {
   	    padding: 5px 0;
	    box-sizing: border-box;
	    transition-duration: 0.6s;
   	}
   	
   	/*왼쪽에서 오른쪽으로 이동하는 에니메이션*/
	.under{
		  position: relative;
		  padding: 5px 20px;
		  box-sizing: border-box;
		color: #525FE1;
		font-weight: 700;
	}
	.under:after{
	    content: "";
	    position: absolute;
	    left: 0;
	    bottom: 0px;
	    width: 0px;
	    height: 2px;
	    margin: 5px 0 0;
	    transition: all 0.2s ease-in-out;
	    transition-duration: 0.6s;
	    width: 100%;
	  	opacity: 1;
	    background-color: #525FE1;
	}
	
	
</style>

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
		    	$(".c"+j).css('background', '#efefef');
		    	$(".c"+j).css('border', '3px solid #ddd');
		        $(".c"+j).find(".wave").css({display: 'none'}); 
		    }
		}
		$('.Today').html("<div>물병 하나당 "+Math.floor(waterVolume)+"(mL)씩이며 총 "+Math.floor(quo)+"개 채워집니다</div>");
		
	}
	$('#reBtn').click(function(){
		$('.hwBefore').css('display', 'none');
		$('.hwAfter').css('display', 'flex');
		$('#waterAter').css('display', 'none'); 
		$('#height').val(${height});
		$('#weight').val(${weight});
		$('#wGuide').val(${waterguide});
		$('.waterGuide').text(${waterguide});
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
	        		    	
        		}else {	        		
	        		$('.hwBefore').css('display', 'none');
	        		$('.hwAfter').css('display', 'flex');
	        		$('#waterAter').css('display', 'none');
	        		$('.waterGuide').html(r['dto'].waterguide);
	        		$('#height').val(r['dto'].height);
	        		$('#weight').val(r['dto'].weight);
	        		$('#wGuide').val(r['dto'].waterguide);
	        		$('#returnHW').css('opacity','1');
	        		
	        		$('#height2').val(r['dto'].height);
	        		$('#weight2').val(r['dto'].weight);
	        	}
	        },
	        error: function(xhr, status, error) {
	            console.log(xhr, status, error);
	        }
	    });
	};
	
	
	// returnHW 클릭 시 키 몸무게 다시입력하러 가기
	$('#returnHW').click(function(){
		$('.hwBefore').css('display', 'inline-block');
		$('.hwAfter').css('display', 'none');
		$('#waterAter').css('display', 'none');
	})
	
	 // #waterAter가 inline-block 일 때 아이디 확인을 수행
     if ($('#waterAter').css('display') === 'flex') {
    	 
     } else if ($('#waterAter').css('display') === 'none') {
         getOneIdSumbti();
     }
	
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
			 swal({
					title: '<span class=\"custom_text\">Error!</span>',
					html: '<span class=\"custom_text\">오늘 마신 <b style="color:#525FE1;">물의 양</을 입력해주세요!</span>',
					type: 'error',
					confirmButtonColor: '#3085d6',
					confirmButtonText: '확인',
				});
		}
	})
	
		
});
</script>

<div>
	<%-- <%=dto.getId()%>
	<%=dto.getWaterguide()%> --%>
	<form action="water" method="GET" id="form">
		<div class="waterIntakeBox">
			<div class="hwBefore">
				<div class="hwInputBox">
					<div class="hwBox font">
						<div>키 <input type="text" placeholder="키를 입력해주세요" id="height2" class="height kfont2" value=""> </div>
						<div>몸무게 <input type="text"placeholder="몸무게를 입력해주세요" id="weight2" class="weight kfont2" value=""></div>
					</div>
					<input type="button" value="입력" id="hwBtn">
				</div>
			</div>
			<div class="hwAfter font">
				<div class="hwInputBox">
					<input type="hidden" value="" id="waterHidden">
					<div class="guide">
						하루에 드셔야 할 물 총량 <div class="guideBox"><span class="qu">"</span><div class="waterGuide"></div>(L)<span class="qu">"</span></div>
					</div>
					<div class="guide">
						<div>오늘 드신 물</div>
						<input type="text" placeholder="ml" id="water" name="water"value="" class="kfont2"> (mL) 
						<input type="hidden" id="height" value=""name="height"> 
						<input type="hidden" id="weight" value=""name="weight"> 
						<input type="hidden" id="wGuide" value=""name="waterguide"> 
						<input type="hidden" id="id" name="id"value="<%=id%>">
					</div>
					<input type="submit" value="입력" id="waterBtn">
					<input type="button" value="키 몸무게 다시입력" id="returnHW">
				</div>
			</div>
			<div id="waterAter" class="font">
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
				<div class="font border">
					<div>
						<div><span class="under">${id}</span>님의오늘 드신 물 양은 <span class="kfont waterfont">${water}</span> (mL)</div>
						<div>오늘 하루 드셔야 될 물 총량은 " <span class="kfont">${waterguide}</span> (L) "</div>
						<div class="Today"></div>
					</div>
					
					<input type="button" value="물 입력하기" id="reBtn">
				</div>
			</div>
		</div>
	</form>
</div>