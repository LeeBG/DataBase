<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setHeader("Pragma", "no-cache");//브라우저에서 캐시된 문서를 사용하지 않고 새로운 문서 전송받음
	if(request.getProtocol().equals("HTTP/1.1")){
		response.setHeader("Cache-Control", "no-store");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Response Example1</H1>
http://localhost/shop/ch07/response1.jsp가
http://localhost/shop/ch07/response1_1.jsp로 변경되었습니다.
</body>
</html>