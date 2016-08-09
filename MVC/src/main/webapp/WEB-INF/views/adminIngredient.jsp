<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form action="/admin/ingredient" method="post">
		<table>
			<tr>
				<td><input name="name" placeholder="Ingredient name"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<th>Ingredient name</th>
		</tr>
		<c:forEach items="${ingredients}" var="ingredient">
			<tr>
				<td>${ingredient.name}</td>
				<td>
					<a href="/admin/ingredient/delete/${ingredient.id}">
						delete
					</a>
				</td>
				<td>
					<a href="/admin/ingredient/update/${ingredient.id}">
						update
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>