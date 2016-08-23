<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<a href="/admin">Back to admin page</a>
	<h3>${recipe.name}</h3>
	<h4>Ingredients already added</h4>
	<table>
		<c:forEach items="${recipe.amountAndIngredients}" var="ingredientAmount">
			<tr>
				<td>${ingredientAmount.amount}</td>
				<td>${ingredientAmount.ingredient.name}</td>
				<td>${ingredientAmount.measuringSystem.name}</td>
				<td><a href="/admin/recipe/delete/${recipe.id}/${ingredientAmount.id}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<h4>Ingredients can by added</h4>
	<table>
		<c:forEach items="${ingredients}" var="ingredientAmount">
			<tr>
				<td>${ingredientAmount.amount}</td>
				<td>${ingredientAmount.ingredient.name}</td>
				<td>${ingredientAmount.measuringSystem.name}</td>
				<td><a href="/admin/recipe/${recipe.id}/${ingredientAmount.id}">add</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/admin/recipe">return</a>