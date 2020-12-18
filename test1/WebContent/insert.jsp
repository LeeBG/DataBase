<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.cos.test1.config.DBConn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삽입하기</title>
</head>
<body>
	<%
		String sql = "INSERT INTO users(username,password,email) values ('ben','1234','ben@nate.com')";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int result = pstmt.executeUpdate();// flush가 내포되어있다.
		%>
		<%if(result>=1){ %>
		삽입완료!
		row changes = [<%=result%>] 
		<%}else{ %>
		삽입실패! 삽입할 내용이 없습니다!
		<%}%>	
</body>
</html>