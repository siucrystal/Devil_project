<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="<%=contextPath %>/resources/css/forgot.css">
      
   <title>Daily Balance</title>

</head>
<body>
   <div class="pw">
      <img src="<%=contextPath %>/resources/imgs/login_image.jpg" alt="pw image" class="pw__img">
      <form action="" class="pw__form">
         <h1 class="pw__title">Update Password</h1>

         <div class="pw__content">
            <div class="pw__box">
               <div class="pw__box-input">
                  <input type="text" required class="pw__input" placeholder="">
                  <label for="" class="pw__label">ID</label>
               </div>
            </div>
            <div class="pw__box">
               <div class="pw__box-input">
                  <input type="password" required class="pw__input" placeholder="">
                  <label for="" class="pw__label">Password</label>
               </div>
            </div>
            <div class="pw__box">
               <div class="pw__box-input">
                  <input type="password" required class="pw__input" placeholder="">
                  <label for="" class="pw__label">New Password</label>
               </div>
            </div>

            <button class="pw__button">Complete</button>
      </form>
      </div>
   </body>
</html>