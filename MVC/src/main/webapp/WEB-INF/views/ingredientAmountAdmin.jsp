<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form action="/admin/ingredientAmount" method="post">
		<table>
			<tr>
				<td><input name="amount"></td>
				<td>
					<select name="msId">
						<c:forEach items="${measuringSystems}" var="measuringSystem">
							<option value="${measuringSystem.id}">${measuringSystem.name}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name="ingredientId">
						<c:forEach items="${ingredients}" var="ingredient">
							<option value="${ingredient.id}">${ingredient.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<th>Amount</th>
			<th>Measuring system</th>
			<th>Ingredient</th>
		</tr>
		<c:forEach items="${ingredientAmounts}" var="ingredientAmount">
			<tr>
				<td>${ingredientAmount.amount}</td>
				<td>${ingredientAmount.measuringSystem.name}</td>
				<td>${ingredientAmount.ingredient.name}</td>
				<td>
					<a href="/admin/ingredientAmount/delete/${ingredientAmount.id}">delete</a>
				</td>
				<td>
					<a href="/admin/ingredientAmount/update/${ingredientAmount.id}">update</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>