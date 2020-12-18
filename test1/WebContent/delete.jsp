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
<title>삭제하기</title>
</head>
<body>
	<%
		String sql = "DELETE FROM users WHERE username = 'ben'";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		int result = pstmt.executeUpdate();
		%>
		<%if(result>=1){ %>
		삭제완료!
		row changes = [<%=result%>] 
		<%}else{ %>
		삭제실패! 삭제할 내용이 없습니다!
		<%}
		%>
</body>
</html>