<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/header.css">
   <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/font/font.css">
   <title>Daily Balance</title>
</head>
<body>
   <header>
      <img class="logo" src="" alt="logo">
      <nav>
         <ul class="nav_links">
            <li><a href="<%=request.getContextPath()%>/mypage/main">My page</a></li>
            <li><a href="<%=request.getContextPath()%>/recipe/main">Recipe</a></li>
         </ul>
      </nav>
      <a class="cta" href="<%=request.getContextPath() %>/member/logout"><button class="logout">Log out</button></a>
   </header>
</body>
</html>