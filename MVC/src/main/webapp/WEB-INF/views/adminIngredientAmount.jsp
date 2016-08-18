<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form:form action="/admin/ingredientAmount" method="post"
		modelAttribute="amount">
		<form:hidden path="id" />
		<table>
			<tr>
				<td><form:input path="amount" /></td>
				<td><form:select path="ms">
						<c:forEach items="${measuringSystems}" var="measuringSystem">
							<c:choose>
								<c:when test="${amount.ms.id eq measuringSystem.id}">
									<option value="${measuringSystem.id}" selected="selected">${measuringSystem.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${measuringSystem.id}">${measuringSystem.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
				<td><form:select path="ingredient">
						<c:forEach items="${ingredients}" var="ingredient">
							<c:choose>
								<c:when test="${amount.ingredient.id eq ingredient.id}">
									<option value="${ingredient.id}" selected="selected">${ingredient.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${ingredient.id}">${ingredient.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
	<form:form action="/admin/ingredientAmount" method="get" modelAttribute="filter">
		<table>
			<c:forEach items="${ingredients}" var="ingredient">
				<tr>
					<td><form:checkbox path="ingredientId" value="${ingredient.id}"/></td>
					<td>${ingredient.name}</td>
				</tr>
			</c:forEach>
			<tr><th>Measuring system</th></tr>
			<c:forEach items="${measuringSystems}" var="measuringSystem">
				<tr>
					<td><form:checkbox path="msId" value="${measuringSystem.id}"/></td>
					<td>${measuringSystem.name}</td>
				</tr>
			</c:forEach>
			<tr><th>Amount</th></tr>
			<tr>
				<td><form:input path="min"/></td>
				<td><form:input path="max"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Filter"></td>
			</tr>
		</table>
	</form:form>
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
				<td><a
					href="/admin/ingredientAmount/delete/${ingredientAmount.id}">delete</a>
				</td>
				<td><a
					href="/admin/ingredientAmount/update/${ingredientAmount.id}">update</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>