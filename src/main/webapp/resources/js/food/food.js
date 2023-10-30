
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
	};
	
function selectEatList() {   
   console.log("눌러따!")
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
              
              put = '<div class="progress-bar"><div class="progress energy"></div></div><br>';
              put += '<div class="progress-bar"><div class="progress carb"></div></div><br>'
              put += '<div class="progress-bar"><div class="progress sugar"></div></div><br>'
              put += '<div class="progress-bar"><div class="progress protein"></div></div><br>'
              put += '<div class="progress-bar"><div class="progress fat"></div></div><br>'
              put += '<div class="progress-bar"><div class="progress sodium"></div></div><br>'
              
              $('.graph').html(put);
              $('.energy').css('width',energy+'%');
              $('.carb').css('width',carb+'%');
              $('.sugar').css('width',sugar+'%');
              $('.protein').css('width',protein+'%');
              $('.fat').css('width',fat+'%');
              $('.sodium').css('width',sodium+'%');
              
           },
           error: function (xhr, status, error) {
                 console.log("에러발생!");
               console.log(xhr, status, error);
           }
       })
      
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