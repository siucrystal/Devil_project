window.onload = function(){
    document.querySelector('.pw__button').addEventListener('click',function() {

        const pw = document.querySelector('input[name="pw"]').value;
        const checkpw = document.querySelector('input[name="checkpw"]').value;

        if(pw === checkpw) {
            document.forgot__form.submit();
        } else {
            alert("비밀번호가 일치하지 않습니다.");
            document.querySelector('input[name="pw"]').value = null;
            document.querySelector('input[name="checkpw"]').value = null;
        }       
    });
 }