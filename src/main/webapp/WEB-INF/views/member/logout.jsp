<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	session.invalidate();
%>
<script>
	alert('로그아웃이 완료되었습니다.');
	location.href = '<%=contextPath %>';
</script>