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
   <script src="<%=contextPath %>/resources/js/member/forgot.js"></script> 
   <title>Daily Balance</title>

</head>
<script>
<% if(rs.equals("0")) {%>
	alert("등록되지 않은 아이디 입니다.");
<%}%>
</script>
<body>
   <div class="pw">
      <img src="<%=contextPath %>/resources/imgs/member/login_image.jpg" alt="pw image" class="pw__img">
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