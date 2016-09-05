<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form:form action="/admin/recipe" method="post" modelAttribute="form">
		<form:errors path="*"/>
		<form:hidden path="id" />
		<table>
			<tr>
				<td><form:select path="country">
				<option value="0">Country</option>
						<c:forEach items="${countries}" var="country">
							<c:choose>
								<c:when test="${country.id eq form.country.id}">
									<option value="${country.id}" selected="selected">${country.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${country.id}">${country.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:errors path="name"/></td>
			</tr>
			<tr>
				<td><form:input path="name" placeholder="Recipe name" /></td>
			</tr>
			<tr>
				<td><form:errors path="time"/></td>
			</tr>
			<tr>
				<td><form:input path="time" placeholder="HH:MM:SS" /></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
	<table>
		<tr>
			<th>Recipe name</th>
		</tr>
		<c:forEach items="${recipes}" var="recipe">
			<tr>
				<td>${recipe.name}</td>
				<td><a href="/admin/recipe/delete/${recipe.id}">delete</a></td>
				<td><a href="/admin/recipe/update/${recipe.id}">update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>