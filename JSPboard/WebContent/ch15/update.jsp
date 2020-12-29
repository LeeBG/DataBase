<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ch15.BoardBean" %>
<%
	int num =Integer.parseInt(request.getParameter("num"));
	String nowPage = request.getParameter("nowPage");
	BoardBean bean = (BoardBean)session.getAttribute("bean");
	String subject = bean.getSubject();
	String name = bean.getName();
	String content = bean.getContent();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP BOARD</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
	function check(){
		if(document.updateFrm.pass.value==""){
			alert("수정을 위해 패스워드를 입력하세요.");
			document.updateFrm.pass.focus();
			return false;
			}
		document.updateFrm.submit();
		}
</script>
</head>
<body bgcolor="#FFFFCC">
<div align="center"><br/><br/>
<table width="460" cellspacing="0" cellpaddign="3">
	<tr>
		<td bgcolor="#FF9018" height="21" align="center">수정하기</td>
	</tr>
</table>
<form name="updateFrm" method="post" action="boadUpdate">
<table width="70%" cellspacing="0" cellpadding="7">
	<tr>
		<td width="20%">성 명</td>
		<td width="80%">
		<input name="name" value="<%=name %>" size="30" maxlength="20">
		</td>
	</tr>
	<tr>
		<td>제 목</td>
		<td>
		<input name="subject" value="<%=subject %>" size="50" maxlength="50">
		</td>
	<tr>
		<td>내 용</td>
		<td>
		<textarea><input name="content" rows="10" cols="50"><%=content %></textarea>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pass" size="15" maxlength="15">
		수정시에는 비밀번호가 필요합니다</td>
	</tr>
	<tr>
		<td colspan="2" height="5"><hr/></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" value="수정완료" onclick="check()">
			<input type="reset" value="다시 수정">
			<input type="button" value="뒤로" onclick="hitory.go(-1)">
		</td>
	</tr>
</table>

</form>
</div>

</body>
</html>