
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
		
		selectEatList();
		
		recommendList();
		
	};
	
	var didScroll;
	// 스크롤시에 사용자가 스크롤했다는 것을 알림 
	$(window).scroll(function(event){
	    didScroll = true;
	});
	
	// hasScrolled()를 실행하고 didScroll 상태를 재설정
	setInterval(function() {
	    if (didScroll) {
	        hasScrolled();
	        didScroll = false;
	    }
	}, 250);
	
	function hasScrolled() {
	  // 동작을 구현
	}

function recommendList() {
	$.ajax({
		url: "recommendList",
		type: "POST",
		dataType: "json",
		success: function(data) {
			var list = data.list;
			var put = "";
			for (let i=0;i < data.list.length;i++){
				const idx = list[i].idx
				const name = list[i].name
				const category = list[i].category
				const amount = list[i].amount
				const energy = list[i].energy
				const carb = list[i].carb
				const sugar = list[i].sugar
				const protein = list[i].protein
				const fat = list[i].fat
				const sodium = list[i].sodium
				put += '<section class="card"><div class="card_inner">'
                put += '<div class="card_inner__content"><div class="category">'+category+'</div>'
                put += '<div class="name">'+name+'</div>'
                put += '<div class="text">'+energy+' kcal</div>'
                put += '</div><div class="card_inner__cta"><button onclick="insertBtn(' + idx + ')">담기</button></div></div></section>'
			}

			$('.containerr').html(put);

		},
		error: function(xhr, status, error) {
			console.log("에러발생!");
			console.log(xhr, status, error);
		}
	})
}
	
function selectEatList() {   
      $.ajax({
           url: "selectEatList",
           type: "POST",
           dataType: "json",
           success: function(data) {
              const energy = data.energy
              const carb = data.carb
              const sugar = data.sugar
              const protein = data.protein
              const fat = data.fat
              const sodium = data.sodium
              
              var put = "";
              
              put = '<span class="p_group"><span>칼로리</span><span class="progress_name p_energy"></span></span><div class="progress-bar"><div class="progress energy"></div></div><br>';
              put += '<span class="p_group"><span>탄수화물</span><span class="progress_name p_carb"></span></span><div class="progress-bar"><div class="progress carb"></div></div><br>'
              put += '<span class="p_group"><span>당분</span><span class="progress_name p_sugar"></span></span><div class="progress-bar"><div class="progress sugar"></div></div><br>'
              put += '<span class="p_group"><span>단백질</span><span class="progress_name p_protein"></span></span><div class="progress-bar"><div class="progress protein"></div></div><br>'
              put += '<span class="p_group"><span>지방</span><span class="progress_name p_fat"></span></span><div class="progress-bar"><div class="progress fat"></div></div><br>'
              put += '<span class="p_group"><span>나트륨</span><span class="progress_name p_sodium"></span></span><div class="progress-bar"><div class="progress sodium"></div></div><br>'
              
              // 함수 정의
				function updateProgress(element, value) {
				    if (value < 100) {
				        element.css('width', value + '%');
				        
				        if (value < 30) {
					        element.css('background', '#F3E99F');
					    } else if (value >= 30 && value <= 50) {
					        element.css('background', '#F7D060');
					    }  else if (value > 50 && value <= 99) {
					        element.css('background', '#98D8AA');
					    } 
				    } else {
				        element.css('width', '100%');
				        element.css('background', '#FF6D60');
				        
				    }
				}
				
				// energy
				setTimeout(function () {
				    updateProgress($('.energy'), energy);
				}, 1);
				
				// carb
				setTimeout(function () {
				    updateProgress($('.carb'), carb);
				}, 1);
				
				// sugar
				setTimeout(function () {
				    updateProgress($('.sugar'), sugar);
				}, 1);
				
				// protein
				setTimeout(function () {
				    updateProgress($('.protein'), protein);
				}, 1);
				
				// fat
				setTimeout(function () {
				    updateProgress($('.fat'), fat);
				}, 1);
				
				// sodium
				setTimeout(function () {
				    updateProgress($('.sodium'), sodium);
				}, 1);
				
              $('.graph').html(put);
              
              /* 영선 - food 몇퍼센트인지 입력 */
           	  $('.p_energy').html(energy+'%');
              $('.p_carb').html(carb+'%');
              $('.p_sugar').html(sugar+'%');
              $('.p_protein').html(protein+'%');
              $('.p_fat').html(fat+'%');
              $('.p_sodium').html(sodium+'%');
              
              recommendList();
           },
           error: function (xhr, status, error) {
                 console.log("에러발생!");
               console.log(xhr, status, error);
           }
       })
      
   }
   var progress = $('.progress').width();
   if(progress > 100) {
		  $('.energy').css('width','100%');
          $('.carb').css('width','100%');
          $('.sugar').css('width','100%');
          $('.protein').css('width','100%');
          $('.fat').css('width','100%');
          $('.sodium').css('width','100%');
   }
	
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
	        	  put += '<div class="menu_body food_flexStyle"><span>' + name + '</span><span>' + amount + '</span><span>' + energy + '</span><span>' + carb + '</span><span>' + sugar + '</span><span>' + protein + '</span><span>' + fat + '</span><span>' + sodium + '</span>'
	              + '<span><button class="keep" onclick="insertBtn(' + idx + ');">담기</button></span></div>';
	          }
	          
	          $('.food_body').html(put);
	          
	          var paging = data.paging;
	          var html = "";

	          if(paging.page<=1) {
	          	html += '<span></span>';
	          } else {
	          	html += '<a href="#" onclick=selectFoodList(' + (paging.page-1) + ')>이전</a>';
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
	          	html += '<a href="#" onclick=selectFoodList(' + (paging.page+1) + ')>다음</a>';
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
					 put += '<div class="menu_body myfood_flexStyle"><span>' + name + '</span><span><input type="text" id="amount' + idx + '" value="' + amount + '"></span><span>' + energy + '</span><span>' + carb + '</span><span>' + sugar + '</span><span>' + protein + '</span><span>' + fat + '</span><span>' + sodium + '</span>'
					    + '<span><button class="keep keep1" onclick="updatebtn(' + idx + ');">수정</button></span>'
					    + '<span><button class="keep keep1" onclick="deletebtn(' + idx + ');">삭제</button></span></div>';
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
	        	  put += '<div class="menu_body myfood_flexStyle"><span>' + name + '</span><span><input type="text" id="amount' + idx + '" value="' + amount + '"></span><span>' + energy + '</span><span>' + carb + '</span><span>' + sugar + '</span><span>' + protein + '</span><span>' + fat + '</span><span>' + sodium + '</span>'
	        	  + '<span><button class="keep keep2" onclick="updatebtn(' + idx + ');">수정</button></span>'
	        	  + '<span><button class="keep keep2" onclick="deletebtn(' + idx + ');">삭제</button></span></div>';
	
	          }
	          
	          $('.myfood_body').html(put)
	          selectEatList();
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
	        	  put += '<div class="menu_body myfood_flexStyle"><span>' + name + '</span><span><input type="text" id="amount' + idx + '" value="' + amount + '"></span><span>' + energy + '</span><span>' + carb + '</span><span>' + sugar + '</span><span>' + protein + '</span><span>' + fat + '</span><span>' + sodium + '</span>'
	              + '<span><button class="keep keep3" onclick="updatebtn(' + idx + ');">수정</button></span>'
	              + '<span><button class="keep keep3" onclick="deletebtn(' + idx + ');">삭제</button></span></div>';
	          }
	          $('.myfood_body').html(put);
	          selectEatList();
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
	        	  put += '<div class="menu_body myfood_flexStyle"><span>' + name + '</span><span><input type="text" id="amount' + idx + '" value="' + amount + '"></span><span>' + energy + '</span><span>' + carb + '</span><span>' + sugar + '</span><span>' + protein + '</span><span>' + fat + '</span><span>' + sodium + '</span>'
	              + '<span><button class="keep keep4" onclick="updatebtn(' + idx + ');">수정</button></span>'
	              + '<span><button class="keep keep4" onclick="deletebtn(' + idx + ');">삭제</button></span></div>';
	          }
	          $('.myfood_body').html(put);
	          selectEatList();
	          
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