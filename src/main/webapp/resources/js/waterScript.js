$(function(){
		
     $('#hwBtn').click(function(){
	    var height = Number($('#height2').val());
	    var weight = Number($('#weight2').val());
        console.log("height : " + height);
        console.log("weight : " + weight);
        
		if(height != 0 && weight != 0) {
	        var wCount = (height + weight) / 100;
	        console.log("wCount : " + wCount);
	        $('.waterHidden').val(wCount);
	        $('#height').val(height);
	        $('#weight').val(weight);
			$('.waterGuide').text(wCount);
			$('#wGuide').val(wCount);
			$('.hwBefore').css({display: 'none'});
			$('.hwAfter').css({display: 'flex'});
			
		} else {
			$('.hwBefore').css({display: 'inline-block'});
			$('.hwAfter').css({display: 'none'});
			alert("키와 몸무게를 입력하세요!");
		}
    })
	$("#water").on("keyup", function() {
      	$(this).val($(this).val().replace(/[^0-9]/g,""));
   	});
		/*$(".waterAter").css({display: 'none'});*/
	$('#waterBtn').click(function(event){
		var water = $('#water').val();
		
		const hHidden = $('#height').val();
		const wHidden = $('#weight').val();
		
		
		console.log('오늘 먹은 물 : '+ water + " (mL)");
	})
	
	
});
