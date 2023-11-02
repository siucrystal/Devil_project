<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	String rs = "";
	if(request.getAttribute("rs") != null) {
		rs = request.getAttribute("rs") + "";	
	}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="<%=contextPath %>/resources/css/member/forgot.css">
   <link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/font/font.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>
   <script src="<%=contextPath %>/resources/js/member/forgot.js"></script> 
   <title>Daily Balance</title>

</head>
<script>
<% if(rs.equals("0")) {%>
swal({
	title: '<span class=\"custom_text\">error!</span>',
	html: '<span class=\"custom_text\">등록되지 않은 아이디 입니다.</span>',
	type: 'error',
	confirmButtonColor: '#3085d6',
	confirmButtonText: '확인',
});
<%}%>
</script>
<body>
	
   <div class="pw">
   <img src="<%=request.getContextPath() %>/resources/imgs/background.jpg" alt="login image" class="pw__img">
      <div class="pw__form">
      <form action="forgot" name="forgot__form" method="POST">
         <h1 class="pw__title">Forgot Password</h1>

         <div class="pw__content">
            <div class="pw__box">
               <div class="pw__box-input">
                  <input type="text" name="id" required class="pw__input" placeholder="">
                  <label for="" class="pw__label">ID</label>
               </div>
            </div>
            <div class="pw__box">
               <div class="pw__box-input">
                  <input type="password" name="pw" required class="pw__input" placeholder="">
                  <label for="" class="pw__label">New Password</label>
               </div>
            </div>
            <div class="pw__box">
               <div class="pw__box-input">
                  <input type="password" name="checkpw" required class="pw__input" placeholder="">
                  <label for="" class="pw__label">New Password Check</label>
               </div>
            </div>
          </div>
          <input type="button" class="pw__button" onclick='submitbtn()' value="Complete">
          <a href="login"><input type="button" class="pw__button" value="Login"></a>
      </form>
      
      </div>      
      </div>
   </body>
</html>