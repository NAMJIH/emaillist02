<%@page import="com.jihoon.emaillist.vo.EmaillistVo"%>
<%@page import="java.util.List"%>
<%@page import="com.jihoon.emaillist.dao.EmaillistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	List<EmaillistVo> list = (List<EmaillistVo>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Emaillist</h1>
	<a href="/emaillist02/el?a=form">추가하기</a>
	
	<%
		for(int i = 0; i< list.size(); i++){
			EmaillistVo ev = list.get(i);
	%>
		<table border="1">
			<tr>
				<td>성</td>
				<td><%=ev.getFirstName() %></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%=ev.getLastName() %></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><%=ev.getEmail() %></td>
			</tr>
		</table>
		<br>
		
	<% 
		}	
	%>
</body>
</html>