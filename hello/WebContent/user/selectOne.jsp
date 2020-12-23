<%@page import="com.cos.hello.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<h1>User Info</h1>
 
<%
	//String result=(String)request.getAttribute("result");
	String result=(String)session.getAttribute("result");
%>
<%=result %>

<!-- <h3>${sessionScope.result}</h3>  -->
<!-- session은 적어주고 -->
<h3>${result}</h3>
<!-- request는 적어주지 말자 -->
</body>
</html>