<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form action="/admin/recipe" method="post">
		<table>
			<tr>
				<td>
					<select name="countryId">
						<c:forEach items="${countries}" var="country">
							<option value="${country.id}">${country.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td><input name="name" placeholder="Recipe name"></td>
			</tr>
			<tr>
				<td><input name="time" placeholder="HH:MM:SS"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<th>Recipe name</th>
		</tr>
		<c:forEach items="${recipes}" var="recipe">
			<tr>
				<td>${recipe.name}</td>
				<td>
					<a href="/admin/recipe/delete/${recipe.id}">delete</a>
				</td>
				<td>
					<a href="/admin/recipe/update/${recipe.id}">update</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>