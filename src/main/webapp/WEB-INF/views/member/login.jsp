<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
   <link rel="stylesheet" href="<%=contextPath %>/resources/css/member/login.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>
   <title>Daily Balance</title>
</head>
<body>
<script>
window.onload = function(){
	   document.querySelector('.login__button').addEventListener('click',function() {
	      	document.login__form.submit();
	      	<%if(rs.equals("0") && session.getAttribute("name") == null) { %>
				alert("비밀번호가 틀렸습니다.");
			<% } %>
	   });
	}
</script>
   <div class="login">
      <img lading="auto" src="https://i.pinimg.com/originals/4d/83/dc/4d83dc364753dc242d1869f3efbd0c92.gif" alt="login image" class="login__img">
      <form action="login" name="login__form" class="login__form" method="POST">
         <h1 class="login__title">Login</h1>

         <div class="login__content">
            <div class="login__box">
               <i class="ri-user-3-line login__icon"></i>

               <div class="login__box-input">
                  <input type="text" required class="login__input" name="id" placeholder="">
                  <label for="" class="login__label">ID</label>
               </div>
            </div>

            <div class="login__box">
               <i class="ri-lock-2-line login__icon"></i>

               <div class="login__box-input">
                  <input type="password" required class="login__input" name="pw" id="login-pass" placeholder="">
                  <label for="" class="login__label">Password</label>
                  <i class="ri-eye-off-line login__eye" id="login-eye"></i>
               </div>
            </div>
         </div>
         <div class="login__check">
            <a href="forgot" class="login__forgot">Forgot Password?</a>
         </div>

         <button class="login__button">Login</button>

         <p class="login__register">
            Don't have an account? <a href="register">Register</a>
         </p>
      </form>
   </div>
</body>
</html>