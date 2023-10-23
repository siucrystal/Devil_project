<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="<%=contextPath %>/resources/css/login.css">
   <link rel="stylesheet" href="<%=contextPath %>/resources/js/login.js">
   
   
   <title>Login</title>

</head>
<body>
   <div class="login">
      <img src="<%=contextPath %>/resources/imgs/login_image.jpg" alt="login image" class="login__img">
      <form action="" class="login__form">
         <h1 class="login__title">Login</h1>

         <div class="login__content">
            <div class="login__box">

               <div class="login__box-input">
                  <input type="email" required class="login__input" name="id" placeholder="">
                  <label for="" class="login__label">Email</label>
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
            <a href="#" class="login__forgot">Forgot Password?</a>
         </div>

         <button class="login__button">Login</button>

         <p class="login__register">
            Don't have an account? <a href="#">Register</a>
         </p>
      </form>
   </div>
</body>
</html>