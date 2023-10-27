function keepdelete(idx) {
		console.log(idx);
	    $.ajax({
        url: "deleteData",
        type: "POST",
        data: {idx},
        dataType: "json",
        success: function(data) {
           keepview();               
        },
        error: function (xhr, status, error) {
            console.log(xhr, status, error);
        }
    })
}

function keepitin(idx) {
    $.ajax({
        url: "insertData",
        type: "POST",
        data: {idx},
        dataType: "json",
        success: function(data) {
            keepview();
        },
        error: function (xhr, status, error) {
            alert('이미 담겨있는 항목입니다.');
            console.log(xhr, status, error);
        }
    })
}

function keepview() {
   $.ajax({
      url: "getData",
      type: "POST",
      dataType: "json",
      success: function(data) {
         let str="";
         let total_kdris = "";

         let total_gram = 0;
         let total_energy = 0;
         let total_carb = 0;
         let total_sugar = 0;
         let total_protein = 0;
         let total_fat = 0;
         let total_sodium = 0;
         
          for(items of data.keep) {
            let percent = items.gram / items.amount;

            total_gram += items.gram;
            total_energy += (items.energy * percent);
            total_carb += (items.carb * percent);
            total_sugar += (items.sugar * percent);
            total_protein += (items.protein * percent);
            total_fat += (items.fat * percent);
            total_sodium += (items.sodium * percent);
            
            
            str += "<button onclick='keepdelete(" + items.idx + ");'>삭제</button>";
            str += '<h4>'+items.name+'|'+ items.category + '| 1회 제공량(g) : ' + items.amount + '</h4>';
            str += '<span>열량(kcal)</span> | <span>탄수화물(g)</span> | <span>당류(g)</span> | <span>단백질(g)</span> | <span>지방(g)</span> | <span>나트륨(mg)</span> |';
            str += '<span>' + (items.energy * percent).toFixed(2) + '</span> | <span>' + (items.carb * percent).toFixed(2) + '</span> | <span>' + (items.sugar * percent).toFixed(2) + '</span> | <span>' + (items.protein * percent).toFixed(2) + '</span> | <span>' + (items.fat * percent).toFixed(2) + '</span> | <span>' + (items.sodium * percent).toFixed(2) + '</span>';
            str += '<input class="inputgram' + items.idx + '" type="number" placeholder="g" value=\"' + items.gram + '\"/><button onclick="gram(' + items.idx + ');">저장</button>';
            str += '<hr>';	

         }

         total_kdris += '<span>' + total_gram.toFixed(2) + '</span> | <span>' + total_energy.toFixed(2) + '</span> | <span>' + total_carb.toFixed(2) + '</span> | <span>' + total_sugar.toFixed(2) + '</span> | <span>' + total_protein.toFixed(2) + '</span> | <span>' + total_fat.toFixed(2) + '</span> | <span>' + total_sodium.toFixed(2) + '</span>';

          $('.keep_data').html(str);
          $('.recipe_kdris_info').html(total_kdris);
             
      },
      error: function (xhr, status, error) {
         console.log("에러발생!");
          console.log(xhr, status, error);
      }
  })
}

function gram(idx) {
   var gram = $(".inputgram" + idx).val();
      $.ajax({
      url: "updateGram",
      type: "POST",
      data: {idx,gram},
      dataType: "json",
      success: function(data) {
          keepview();
      },
      error: function(xhr, status, error) {
          console.log(xhr, status, error);
      }
  })
}

function recipe_store(name) {
    $.ajax({
        url: "recipeStore",
        type: "POST",
        data: {name},
        dataType: "json",
        success: function(data) {
            getUserRecipe();
            keepview();
        },
        error: function(xhr, status, error) {
            console.log(xhr, status, error);
        }
    })
}

function deleteRecipe(name) {
       $.ajax({
        url: "deleteRecipe",
        type: "POST",
        data: {name},
        dataType: "json",
        success: function(data) {
            getUserRecipe();
        },
        error: function(xhr, status, error) {
            console.log(xhr, status, error);
        }
    })
}

function updateRecipe(name) {
    $.ajax({
        url: "updateRecipe",
        type: "POST",
        data: {name},
        dataType: "json",
        success: function(data) {
            keepview();
        },
        error: function(xhr, status, error) {
            console.log(xhr, status, error);
        }
    })
}

function getUserRecipe() {
    $.ajax({
        url: "getUserRecipe",
        type: "POST",
        dataType: "json",
        success: function(data) {
            let str = "";
            for(items of data.userRecipe) {
                str += "<h4>레시피 이름 : " + items.recipe_name + "</h4>";
                str += "<span>분량(g) | 열량(kcal) | 탄수화물(g) | 당류(g) | 단백질(g) | 지방(g) | 나트륨(mg) </span>";
                str += '<span>' + items.total_gram.toFixed(2) + '</span> | <span>' + items.total_energy.toFixed(2) + '</span> | <span>' + items.total_carb.toFixed(2) + '</span> | <span>' + items.total_sugar.toFixed(2) + '</span> | <span>' + items.total_protein.toFixed(2) + '</span> | <span>' + items.total_fat.toFixed(2) + '</span> | <span>' + items.total_sodium + '</span>' ;
                str += '<button onclick=\"updateRecipe(\'' + items.recipe_name + '\')\">수정</button><button onclick=\"deleteRecipe(\'' + items.recipe_name + '\')\">삭제</button>';
                str += '<hr>';
            }
            $('.myrecipe_list').html(str);
        },
        error: function(xhr, status, error) {
            console.log(xhr, status, error);
        }
    })
}


function keepbtn(idx) {
   keepitin(idx);
}

window.onload = function(){
   keepitin(0);
   getUserRecipe();

   document.querySelector('.ingredient_search').addEventListener('click',function() {
      document.recipe_search_form.submit();
   });
   document.querySelector('.recipe_store').addEventListener('click',function() {
        var recipe_name = $('.user_recipe_nmae').val();
        if(recipe_name == "") {
            alert("저장할 레시피의 이름을 입력해주세요.")
        } else {
            console.log(recipe_name);
            recipe_store(recipe_name);
        }
        
   })
}