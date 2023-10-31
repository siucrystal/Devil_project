<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	session.invalidate();
%>
<script>
	location.href = '<%=contextPath %>';
</script>