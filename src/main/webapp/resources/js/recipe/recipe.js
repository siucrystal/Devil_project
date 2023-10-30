function keepdelete(idx) {
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
    console.log(idx);
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

function newRecipe() {
    $.ajax({
        url: "newRecipe",
        type: "POST",
        dataType: "json",
        success: function(data) {
            keepview();
        },
        error: function (xhr, status, error) {
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
            
            str += "<div class=\"recipe-item\">";
            str += "<button  class=\"delete-button\" onclick='keepdelete(" + items.idx + ", \"" + items.recipe_name + "\");'><i class=\"fas fa-times\"></i></button>";
            str += '<p>'+items.name+'</p>';
            str += '<p>'+items.category+'</p>';
            str += '<p>1회 제공량(g) : ' + items.amount + '</p>';
            str += "<div class=\"nutrition-info\">"
            str += '<span>열량(kcal)</span><span>탄수화물(g)</span><span>당류(g)</span><span>단백질(g)</span><span>지방(g)</span><span>나트륨(mg)</span>';
            str += "</div>"
            str += "<div class=\"nutrition-values\">"
            str += '<span>' + (items.energy * percent).toFixed(2) + '</span><span>' + (items.carb * percent).toFixed(2) + '</span><span>' + (items.sugar * percent).toFixed(2) + '</span><span>' + (items.protein * percent).toFixed(2) + '</span><span>' + (items.fat * percent).toFixed(2) + '</span><span>' + (items.sodium * percent).toFixed(2) + '</span>';
            str += "</div>"
            str += "<div class=\"button-container\">"
            if(items.gram > 0) {
                str += '<input id=\"input-gram\" class="inputgram' + items.idx + '" type="number" placeholder="g" value=\"' + items.gram + '\"/>';
            } else {
                str += '<input id=\"input-gram\" class="inputgram' + items.idx + '" type="number" placeholder="g" value=\"' + items.amount + '\"/>';
            }
            
            str += '<button class=\"save-button\" onclick="gram(' + items.idx + ');">저장</button>';
            str += "</div>";
            str += '</div>';
         }

         total_kdris += '<span>' + total_gram.toFixed(2) + '</span> | <span>' + total_energy.toFixed(2) + '</span> | <span>' + total_carb.toFixed(2) + '</span> | <span>' + total_sugar.toFixed(2) + '</span> | <span>' + total_protein.toFixed(2) + '</span> | <span>' + total_fat.toFixed(2) + '</span> | <span>' + total_sodium.toFixed(2) + '</span>';
         selectIngredeintList();
          $('.keep_data').html(str);
          $('.recipe_kdris_info').html(total_kdris);
             
      },
      error: function (xhr, status, error) {
         console.log("에러발생!");
          console.log(xhr, status, error);
      }
  })
}

function selectIngredeintList() {   
       $.ajax({
            url: "selectIngredeintList",
            type: "POST",
            dataType: "json",
            success: function(data) {
               console.log(data.kdris);
               console.log(data.keep);

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
               }
            
                total_energy = total_energy / data.kdris.energy * 100;
                total_carb = total_carb / data.kdris.carb * 100;
                total_sugar = total_sugar / data.kdris.sugar * 100;
                total_protein = total_protein / data.kdris.protein * 100;
                total_fat = total_fat / data.kdris.fat * 100;
                total_sodium += total_sodium / data.kdris.sodium * 100;

                
               
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
console.log(name);
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
    $('.user_recipe_nmae').val(name);
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
            	str += "<div class=\"recipe-list-items\">";
                str += "<p>레시피 : " + items.recipe_name + "</p>";
                str += "<div class=\"recipe-list-info\">";
                str += "<span>분량(g)</span><span>열량(kcal)</span><span>탄수화물(g)</span><span>당류(g)</span><span>단백질(g)</span><span>지방(g)</span><span>나트륨(mg)</span>";
                str += "</div>";
                str += "<div class=\"recipe-list-values\">"
                str += '<span>' + items.total_gram.toFixed(2) + '</span><span>' + items.total_energy.toFixed(2) + '</span><span>' + items.total_carb.toFixed(2) + '</span><span>' + items.total_sugar.toFixed(2) + '</span><span>' + items.total_protein.toFixed(2) + '</span><span>' + items.total_fat.toFixed(2) + '</span><span>' + items.total_sodium + '</span>' ;
                str += "</div>";
                str += "<div class=\"recipe-buttons\">";
                str += '<button class=\"recipe-update-button\" onclick=\"updateRecipe(\'' + items.recipe_name + '\')\">수정</button><button class=\"recipe-delete-button\" onclick=\"deleteRecipe(\'' + items.recipe_name + '\')\">삭제</button>';
                str += "</div>";
                str += "</div>"
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
        var recipe_name = $('.user_recipe_name').val();
        if(recipe_name == "") {
            alert("저장할 레시피의 이름을 입력해주세요.")
        } else {
            recipe_store(recipe_name);
        }
   });
   document.querySelector('.new_recipe').addEventListener('click',function() {
        var userResponse = confirm("저장하지 않은 재료들이 초기화 됩니다. 괜찮으신가요?");
        if (userResponse) {
            $('.user_recipe_nmae').val("");
            newRecipe();
        }
   })

}