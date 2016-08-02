<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
	<h1>New form</h1>
	
	<form action="/form" method="post">
	<table>
		<tr>
			<td><input name="name" value="${name}"></td><td></td>
		</tr>
		<tr>
			<td><input name="age" placeholder="Your age"></td><td></td>
		</tr>
		<tr>
			<td><label for="sex">Are you man?</label></td><td><input name="sex" type="checkbox" id="sex"></td>
		</tr>
		<tr>
			<td><input name="Ok" type="submit"></td><td></td>
		</tr>
	</table>
	</form>
</body>
</html>