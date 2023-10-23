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
   <link rel="stylesheet" href="<%=contextPath %>/resources/css/register.css">
   <script src="<%=contextPath %>/resources/js/register.js"></script>
   
   <title>Daily Balance</title>
   <body>
      <div class="join">
         <img src="<%=contextPath %>/resources/imgs/login_image.jpg" alt="join image" class="join__img">
         <form action="register" name="join__form" class="join__form" method="POST">
            <h1 class="join__title">Join</h1>
            <div class="join__content">
               <div class="join__box">
                  <div class="join__box-input">
                     <input type="ID" name="id" required class="join__input" placeholder="">
                     <label for="" class="join__label">ID</label>
                  </div>
               </div>
            </div>
               <div class="join__content">
                  <div class="join__box">
                     <div class="join__box-input">
                        <input type="password" name="pw" required class="join__input" placeholder="">
                        <label for="" class="join__label">PW</label>
                     </div>
                  </div>
               </div>
               <div class="join__content">
                  <div class="join__box">
                     <div class="join__box-input">
                        <input type="password" name="checkpw" required class="join__input" placeholder="">
                        <label for="" class="join__label">PW CHECK</label>
                     </div>
                  </div>
               </div>
               <div class="join__content">
                  <div class="join__box">
                     <div class="join__box-input">
                        <input type="text" name="name" required class="join__input" placeholder="">
                        <label for="" class="join__label">NAME</label>
                     </div>
                  </div>
               </div>
               <div class="join__content">
                  <div class="join__box">
                     <div class="join__box-input">
                        <input type="text" name="sex" required class="join__input" placeholder="">
                        <label for="" class="join__label">GENDER</label>
                     </div>
                  </div>
               </div>
               <div class="join__content">
                  <div class="join__box">
                     <div class="join__box-input">
                        <input type="age" name="age" required class="join__input" placeholder="">
                        <label for="" class="join__label">AGE</label>
                     </div>
                  </div>
               </div>
               <button class="join__button">Join</button>
         </form>
      </div>
   </body>
</head>