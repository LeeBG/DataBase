<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!-- 선언문 톰캣이 분석함 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 외부 접근 불가 폴더 = META-INF , WEB - INF 폴더  
	프로젝트 내부의 설정파일(중요)을 주로 이 폴더 안에 넣는다.-->
	<%
		/* 자바코드를 적을수 있는 공간입니다 = 스크립틀릿
		*  웹 브라우저는 이코드를 이해 할 수 없기때문에 톰캣에 넘긴다.
		*/
		String name = "홍길동";
	%>
	<h1><%=name%></h1>
	<!-- %= 표현식 바로 출력-->
</body>
</html>