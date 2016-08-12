<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple form</title>
</head>
<body>
<h3>${message}</h3>
<form action="/form" method="post">
	<input name="userName" placeholder="Enter your name here">
</form>
</body>
</html>