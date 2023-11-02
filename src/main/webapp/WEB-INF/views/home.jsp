<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>Document</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="<%=contextPath %>/resources/css/home.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/js/home.js"></script>
</head>

<body>
    <div class="container">
    <img class="background" src="<%=contextPath %>/resources/imgs/background.jpg" alt="background">
    <div class="fooddish">
        <div class="circle"></div>

        <img class="logo" src="<%=contextPath %>/resources/imgs/logo.png" alt="logo">
        <img class="dailybalance" src="<%=contextPath %>/resources/imgs/dailybalance.png" alt="dailybalance">

        <div class="info_text">
            "Daily Balance" refers to finding a way to balance work and home life, being dedicated to your work while enjoying your family life. Maintaining a balance between work and home life can reduce stress and enhance happiness.
        </div>

        <img class="imgview1" src="<%=contextPath %>/resources/imgs//food_img_1.png" alt="food_img_1">
        <img class="imgview2 hidden" src="<%=contextPath %>/resources/imgs//food_img_2.png" alt="food_img_1">
        <img class="imgview3 hidden" src="<%=contextPath %>/resources/imgs//food_img_3.png" alt="food_img_1">
        <div class="login">
        	<a href="<%=contextPath %>/member/main">
            <Button class="login_btn">LOGIN</Button>
            </a>
        </div>
    </div>
    <div class="info">
        <div class="sidebar1">
            <div class="sidemenu1">
                <img class="food_img_1" src="<%=contextPath %>/resources/imgs//food_img_1.png" alt="food_img_1">
            </div>
            <div class="sidemenu1_side"><span>Smoked salmon salad is a delicious and healthy dish made with smoked (or cured) salmon, fresh vegetables, and various dressings mixed together.</span></div>
        </div>

        <div class="sidebar2">
            <div class="sidemenu2">
                <img class="food_img_2" src="<%=contextPath %>/resources/imgs//food_img_2.png" alt="food_img_2">
            </div>
            <div class="sidemenu2_side"><span>Strip Steak is one of the popular steaks in the world of meat dishes, typically made from the strip loin section of beef, known for its rich flavor and tender texture. It is frequently featured on the menus of steak restaurants.</span></div>
        </div>

        <div class="sidebar3">
            <div class="sidemenu3">
                <img class="food_img_3" src="<%=contextPath %>/resources/imgs//food_img_3.png" alt="food_img_3">
            </div>
            <div class="sidemenu3_side"><span>Duck salad is a delicious dish that offers a luxurious flavor and a variety of textures.</span></div>
        </div>
    </div>
    </div>
</body>

</html>