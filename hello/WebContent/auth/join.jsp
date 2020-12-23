<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<h1>Join Page</h1>
<!-- 예전버전은 D:\workspace\jspwork\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\hello\user -->
<!-- 9버전부터는 다시 저장하면 다시 만들어 줌 -->
<hr/>
<form action = "/hello/user?gubun=joinProc" method="post">
	<input type="text" name="username" placeholder="username" /> 
	<input type="password" name="password" placeholder="password" /> 
	<input type="text" name="email" placeholder="email" />
	<button>회원가입</button>
</form>


</body>
</html>