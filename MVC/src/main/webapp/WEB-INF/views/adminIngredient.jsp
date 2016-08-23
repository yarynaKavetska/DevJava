<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
	<form:form action="/admin/ingredient" method="post"
		modelAttribute="ingredient">
		<form:hidden path="id" />
		<table>
			<tr>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td><form:input path="name" placeholder="Ingredient name" /></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
	<form:form action="/admin/ingredient" method="get"
		modelAttribute="filter">
		<table>
			<tr>
				<td><form:input path="name"/></td>
			</tr>
			<tr><td><input type="submit" value="Filter"></td></tr>
		</table>
	</form:form>
	<table>
		<tr>
			<th>Ingredient name</th>
		</tr>
		<c:forEach items="${ingredients.content}" var="ingredient">
			<tr>
				<td>${ingredient.name}</td>
				<td><a href="/admin/ingredient/delete/${ingredient.id}">
						delete </a></td>
				<td><a href="/admin/ingredient/update/${ingredient.id}">
						update </a></td>
			</tr>
		</c:forEach>
		<tr>
			<td><c:if test="${ingredients.number ne 0}">
					<a href="/admin/ingredient?page=${ingredients.number}&size=
					${ingredients.size}&name=${param.name}">previous</a>
				</c:if></td>
			<td><c:if
					test="${ingredients.number ne ingredients.totalPages-1}">
					<a href="/admin/ingredient?page=${ingredients.number+2}&size=
					${ingredients.size}&name=${param.name}">next</a>
				</c:if></td>
		</tr>
	</table>
	<table>
		<tr>
			<td><a href="/admin/ingredient?page=1&size=1&name=${param.name}">1</a></td>
			<td><a href="/admin/ingredient?page=1&size=5&name=${param.name}">5</a></td>
			<td><a href="/admin/ingredient?page=1&size=10&name=${param.name}">10</a></td>
		</tr>
	</table>