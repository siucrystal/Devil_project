function join() {
	const id = document.querySelector('input[name="id"]').value;
	const pw = document.querySelector('input[name="pw"]').value;
	const checkpw = document.querySelector('input[name="checkpw"]').value;
	const name = document.querySelector('input[name="name"]').value;
	const age = document.querySelector('input[name="age"]').value;
	const sex = document.querySelector('input[name="sex"]').value;

	if (id !== "" && pw !== "" && checkpw !== "" && name !== "" && age !== "" && sex !== "") {
		if (pw === checkpw) {
			document.join__form.submit();
		} else if (pw !== checkpw) {
			swal({
				title: '<span class=\"custom_text\">error!</span>',
				html: '<span class=\"custom_text\">비밀번호가 일치하지 않습니다!</span>',
				type: 'error',
				confirmButtonColor: '#3085d6',
				confirmButtonText: '확인',
			});
			document.querySelector('input[name="pw"]').value = "";
			document.querySelector('input[name="checkpw"]').value = "";
		}
	} else {
		swal({
			title: '<span class=\"custom_text\">error!</span>',
			html: '<span class=\"custom_text\">입력하지 않은 값이 존재합니다!</span>',
			type: 'error',
			confirmButtonColor: '#3085d6',
			confirmButtonText: '확인',
		});
	}
}


