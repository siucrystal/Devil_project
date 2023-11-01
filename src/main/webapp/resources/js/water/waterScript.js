$(function(){
		
     $('#hwBtn').click(function(){
	    var height = Number($('#height2').val());
	    var weight = Number($('#weight2').val());
        
		if(height != 0 && weight != 0) {
	        var wCount = (height + weight) / 100;
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
			swal({
				title: '<span class=\"custom_text\">Error!</span>',
				html: '<span class=\"custom_text\">키와 몸무게를 입력해주세요!</span>',
				type: 'error',
				confirmButtonColor: '#3085d6',
				confirmButtonText: '확인',
			});
		}
    })
	$("#water").on("keyup", function() {
      	$(this).val($(this).val().replace(/[^0-9]/g,""));
   	});
	
	
	
});
