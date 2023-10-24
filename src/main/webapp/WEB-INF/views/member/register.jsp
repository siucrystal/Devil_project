<%@page import="com.daily.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	String rs = "";
	MemberDTO dto = null;
	if(request.getAttribute("rs") != null) {
		rs = request.getAttribute("rs") + "";
	}
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="<%=contextPath %>/resources/css/member/register.css">
   <script src="<%=contextPath %>/resources/js/member/register.js"></script>
   <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
   <title>Daily Balance</title>
   <body>
      <div class="join">
         <img src="<%=contextPath %>/resources/imgs/member/login_image.jpg" alt="join image" class="join__img">
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
                        <input type="password" name="pw" value="${pw}" required class="join__input" placeholder="">
                        <label for="" class="join__label">PW</label>
                     </div>
                  </div>
               </div>
               <div class="join__content">
                  <div class="join__box">
                     <div class="join__box-input">
                        <input type="password" name="checkpw" value="${checkpw}"required class="join__input" placeholder="">
                        <label for="" class="join__label">PW CHECK</label>
                     </div>
                  </div>
               </div>
               <div class="join__content">
                  <div class="join__box">
                     <div class="join__box-input">
                        <input type="text" name="name" value="${name}"required class="join__input" placeholder="">
                        <label for="" class="join__label">NAME</label>
                     </div>
                  </div>
               </div>
               <div class="join__content">
                  <div class="join__box">
                     <div class="join__box-input">
                        <input type="age" name="age" value="${checkpw}"required class="join__input" placeholder="">
                        <label for="" class="join__label">AGE</label>
                     </div>
                  </div>
               </div>
               <div class="radio__group">
                  <label class="radio">
                     <input type="radio" value="0" name="sex" checked>
                     Male
                     <span></span>
                     </label>
                     <label class="radio">
                     <input type="radio" value="1" name="sex">
                     Female
                     <span></span>
                     </label>
               </div>
               <input type="button" class="join__button" onclick="join();" value="Join">
               <a href="login"><input type="button" class="join__button" value="Login"></a>
         	</form>
      </div>
<script>
<% if(rs.equals("0")) {%>
	alert("등록된 아이디 입니다.");
	$('input:radio[name="sex"]:input[value='+ ${sex}+']').attr('checked',true);
<%}%>
</script>
   </body>
</head>