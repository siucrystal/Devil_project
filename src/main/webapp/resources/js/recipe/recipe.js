window.onload = function(){
   document.querySelector('.ingredient_search').addEventListener('click',function() {
   		console.log("눌렀따!!");
      document.recipe_search_form.submit();
   });
}