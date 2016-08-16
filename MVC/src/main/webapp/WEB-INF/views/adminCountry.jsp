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
	<form:form action="/admin/country" method="post" modelAttribute="country">
		<form:input path="id" type="hidden"/>
		<table>
			<tr>
				<td><form:errors path="name"/></td>
			</tr>
			<tr>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
	<table>
		<tr>
			<th>Country name</th>
		</tr>
		<c:forEach items="${countries}" var="country">
			<tr>
				<td>${country.name}</td>
				<td>
					<a href="/admin/country/delete/${country.id}">delete</a>
				</td>
				<td>
					<a href="/admin/country/update/${country.id}">update</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>