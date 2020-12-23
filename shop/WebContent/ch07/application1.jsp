<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application1</title>
</head>
<body>
<%
	String serverInfo = application.getServerInfo();//서블릿 컨테이너의 이름과 버전을 가져온다
	String mimeType = application.getMimeType("request1.html");
	
	String reqlPath = application.getRealPath("/");
	application.log("application 내부 객체 로그 테스트");
%>
<h1>Application Example1</h1>
</body>
</html>