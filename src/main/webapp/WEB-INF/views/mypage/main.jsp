<%@page import="com.daily.dto.WaterDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/main.css"> 
<head>
<meta charset="UTF-8">
<title>Daily Balance</title>
<%@include file="../layout/header.jsp" %>
</head>
<body>
    <main class="flex_main">
      <aside class="flex_aside">
         <%@include file="./eatlist.jsp" %>
      </aside>
      <div class="container">
         <div class="box box1">
            <div class="wlInnerBox">
               <jsp:include page="./water.jsp"></jsp:include> 
            </div>
         </div>
         <div class="box box2"><%@include file="./foodlist.jsp" %></div>
         <div class="box box3"><%@include file="./recommend.jsp" %></div>
      </div>
    </main>
    <footer class="flex_footer">
      Footer
    </footer>
   </div>
</body>
</html>