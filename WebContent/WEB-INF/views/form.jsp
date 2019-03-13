<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>추가하기</h1>
	<form action="/emaillist02/el?a=add" method="post">
		성:<input type="text" name="fn">
		<br>
		이름:<input type="text" name="ln">
		<br>
		이메일:<input type="text" name="email">
		<br>
		<input type="submit" value="등록">
	</form>
</body>
</html>