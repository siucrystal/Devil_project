function keepdelete(idx) {
	$.ajax({
		url: "deleteData",
		type: "POST",
		data: { idx },
		dataType: "json",
		success: function(data) {
			keepview();
		},
		error: function(xhr, status, error) {
			console.log(xhr, status, error);
		}
	})
}

function keepitin(idx) {
	$.ajax({
		url: "insertData",
		type: "POST",
		data: { idx },
		dataType: "json",
		success: function(data) {
			keepview();
		},
		error: function(xhr, status, error) {
			swal({
				title: '<span class=\"custom_text\">error!</span>',
				html: '<span class=\"custom_text\">이미 담겨있는 <b style="color:red;">항목</b> 입니다!</span>',
				type: 'error',
				confirmButtonColor: '#3085d6',
				confirmButtonText: '확인',
			});
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
		error: function(xhr, status, error) {
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
			let str = "";
			let total_kdris = "";

			let total_gram = 0;
			let total_energy = 0;
			let total_carb = 0;
			let total_sugar = 0;
			let total_protein = 0;
			let total_fat = 0;
			let total_sodium = 0;

			for (items of data.keep) {
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
				str += '<p>' + items.name + '</p>';
				str += '<p>' + items.category + '</p>';
				str += '<p>1회 제공량(g) : ' + items.amount + '</p>';
				str += "<div class=\"nutrition-info\">"
				str += '<span class=\"recip-info\">열량<span>(kcal)</span></span><span class=\"recip-info\">탄수화물<span>(g)</span></span><span class=\"recip-info\">당류<span>(g)</span></span><span class=\"recip-info\">단백질<span>(g)</span></span><span class=\"recip-info\">지방<span>(g)</span></span><span class=\"recip-info\">나트륨<span>(mg)</span></span>';
				str += "</div>"
				str += "<div class=\"nutrition-values\">"
				str += '<span>' + (items.energy * percent).toFixed(2) + '</span><span>' + (items.carb * percent).toFixed(2) + '</span><span>' + (items.sugar * percent).toFixed(2) + '</span><span>' + (items.protein * percent).toFixed(2) + '</span><span>' + (items.fat * percent).toFixed(2) + '</span><span>' + (items.sodium * percent).toFixed(2) + '</span>';
				str += "</div>"
				str += "<div class=\"button-container\">"
				if (items.gram > 0) {
					str += '<input id=\"input-gram\" class="inputgram' + items.idx + '" type="number" placeholder="g" value=\"' + items.gram + '\"/>';
				} else {
					str += '<input id=\"input-gram\" class="inputgram' + items.idx + '" type="number" placeholder="g" value=\"' + items.amount + '\"/>';
				}

				str += '<button class=\"save-button\" onclick="gram(' + items.idx + ');">저장</button>';
				str += "</div>";
				str += '</div>';
			}

			total_kdris += '<li>' + total_gram.toFixed(2) + '</li><li>' + total_energy.toFixed(2) + '</li><li>' + total_carb.toFixed(2) + '</li><li>' + total_sugar.toFixed(2) + '</li><li>' + total_protein.toFixed(2) + '</li><li>' + total_fat.toFixed(2) + '</li><li>' + total_sodium.toFixed(2) + '</li>';
			selectIngredeintList();
			$('.keep_data').html(str);
			$('.recipe_kdris_info').html(total_kdris);

		},
		error: function(xhr, status, error) {
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
			let total_gram = 0;
			let total_energy = 0;
			let total_carb = 0;
			let total_sugar = 0;
			let total_protein = 0;
			let total_fat = 0;
			let total_sodium = 0;

			for (items of data.keep) {
				let percent = items.gram / items.amount;
				total_gram += items.gram;
				total_energy += (items.energy * percent);
				total_carb += (items.carb * percent);
				total_sugar += (items.sugar * percent);
				total_protein += (items.protein * percent);
				total_fat += (items.fat * percent);
				total_sodium += (items.sodium * percent);
			}
			total_energy = (total_energy / data.kdris[0].energy * 100).toFixed(2);
			total_carb = (total_carb / data.kdris[0].carb * 100).toFixed(2);
			total_sugar = (total_sugar / data.kdris[0].sugar * 100).toFixed(2);
			total_protein = (total_protein / data.kdris[0].protein * 100).toFixed(2);
			total_fat = (total_fat / data.kdris[0].fat).toFixed(2);
			total_sodium = (total_sodium / data.kdris[0].sodium).toFixed(2);

			const threshold_yellow = 30;
			const threshold_orange = 50;
			const threshold_green = 100;

			let energy_color = "";
			let carb_color = "";
			let sugar_color = "";
			let protein_color = "";
			let fat_color = "";
			let sodium_color = "";

			let nutritionArray = [total_energy, total_carb, total_sugar, total_protein, total_fat, total_sodium];
			let colorArray = [energy_color, carb_color, sugar_color, protein_color, fat_color, sodium_color];
			for (let i = 0; i < nutritionArray.length; i++) {
				if ((nutritionArray[i] < threshold_yellow)) {
					colorArray[i] = "F3E99F";
				} else if ((nutritionArray[i] > threshold_yellow) && (nutritionArray[i] <= threshold_orange)) {
					colorArray[i] = "F7D060";
				} else if ((nutritionArray[i] > threshold_orange) && (nutritionArray[i] <= threshold_green)) {
					colorArray[i] = "98D8AA";
				} else if ((nutritionArray[i] >= threshold_green)) {
					colorArray[i] = "FF6D60";
				}
			}
			$('.energy').css('height', total_energy + '%');
			$('.energy').css('background-color', "#" + colorArray[0]);

			$('.carb').css('height', total_carb + '%');
			$('.carb').css('background-color', "#" + colorArray[1]);

			$('.sugar').css('height', total_sugar + '%');
			$('.sugar').css('background-color', "#" + colorArray[2]);

			$('.protein').css('height', total_protein + '%');
			$('.protein').css('background-color', "#" + colorArray[3]);

			$('.fat').css('height', total_fat + '%');
			$('.fat').css('background-color', "#" + colorArray[4]);

			$('.sodium').css('height', total_sodium + '%');
			$('.sodium').css('background-color', "#" + colorArray[5]);
		},
		error: function(xhr, status, error) {
			console.log(xhr, status, error);
		}
	})

}

function gram(idx) {
	var gram = $(".inputgram" + idx).val();
	$.ajax({
		url: "updateGram",
		type: "POST",
		data: { idx, gram },
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
		data: { name },
		dataType: "json",
		success: function(data) {
			$('.user_recipe_name').val("");
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
		data: { name },
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
	$('.user_recipe_name').val(name);
	$.ajax({
		url: "updateRecipe",
		type: "POST",
		data: { name },
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
			for (items of data.userRecipe) {
				str += "<div class=\"recipe-list-items\">";
				str += "<p>레시피 : " + items.recipe_name + "</p>";
				str += "<div class=\"recipe-list-info\">";
				str += "<span class=\"recip-info\">분량<span>(g)</span></span><span class=\"recip-info\">열량<span>(kcal)</span></span><span class=\"recip-info\">탄수화물<span>(g)</span></span><span class=\"recip-info\">당류<span>(g)</span></span><span class=\"recip-info\">단백질<span>(g)</span></span><span class=\"recip-info\">지방<span>(g)</span></span><span class=\"recip-info\">나트륨<span>(mg)</span></span>";
				str += "</div>";
				str += "<div class=\"recipe-list-values\">"
				str += '<span>' + items.total_gram.toFixed(2) + '</span><span>' + items.total_energy.toFixed(2) + '</span><span>' + items.total_carb.toFixed(2) + '</span><span>' + items.total_sugar.toFixed(2) + '</span><span>' + items.total_protein.toFixed(2) + '</span><span>' + items.total_fat.toFixed(2) + '</span><span>' + items.total_sodium + '</span>';
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

window.onload = function() {
	keepitin(0);
	getUserRecipe();

	document.querySelector('.ingredient_search').addEventListener('click', function() {
		document.recipe_search_form.submit();
	});
	document.querySelector('.recipe_store').addEventListener('click', function() {
		var recipe_name = $('.user_recipe_name').val();
		if (recipe_name == "") {
			swal({
				title: '<span class=\"custom_text\">Error!</span>',
				html: '<span class=\"custom_text\">저장할 <b style="color:red;">레시피의</b> 이름을 입력해주세요!</span>',
				type: 'error',
				confirmButtonColor: '#3085d6',
				confirmButtonText: '확인',
			});
		} else {
			recipe_store(recipe_name);
		}
	});
	document.querySelector('.new_recipe').addEventListener('click', function() {
		swal({
			title: '<span class=\"custom_text\">Error!</span>',
			html: '<span class=\"custom_text\">저장하지 않은 재료들이 <b style="color:red;">초기화</b>됩니다. 괜찮으신가요? </span>',
			type: 'error',
			showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
			confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
			cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
			confirmButtonText: '네', // confirm 버튼 텍스트 지정
			cancelButtonText: '아니오', // cancel 버튼 텍스트 지정
		}).then((isConfirm) => {
			if (isConfirm) { // 만약 모달창에서 confirm 버튼을 눌렀다면
				$('.user_recipe_name').val("");
				newRecipe();
			}
		});
	})

}