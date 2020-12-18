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
<title>갱신하기</title>
</head>
<body>
	<%
		String sql = "UPDATE users SET id = 3 WHERE username = 'ben'";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int result = pstmt.executeUpdate();
		%>
		<%if(result>=1){ %>
		갱신완료!
		row changes = [<%=result%>] 
		<%}else{ %>
		갱신실패! 갱신할 내용이 없습니다!
		<%}%>	
</body>
</html>