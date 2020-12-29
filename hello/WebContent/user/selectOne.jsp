<%@page import="com.cos.hello.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<h1>User Info</h1>
<table border="1">
	<tr>
		<th>번호</th>
		<th>유저네임</th>
		<th>패스워드</th>
		<th>이메일</th>
	</tr>
	<tr>
		<td>${user.id}</td>
		<td>${user.username}</td>
		<td>${user.password}</td>
		<td>${user.email}</td>
	</tr>
</table>
<form action="user?gubun=deleteProc" method="post">
	<input type="hidden" name="id" value="${user.id}" />
	<button>삭제</button>
</form>

<!--  -->
<!-- <h3>${sessionScope.result}</h3>  -->
<!-- session은 적어주고 -->
<!-- request는 적어주지 말자 -->

</body>
</html>