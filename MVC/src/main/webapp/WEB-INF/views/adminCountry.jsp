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
	<form:form action="/admin/country" method="post" modelAttribute="country">
		<table>
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
		<c:forEach items="${page.content}" var="country">
			<tr>
				<td>${country.name}</td>
				<td>
					<a href="/admin/country/delete/${country.id}?page=${page.number+1}&size=${page.size}&sort=${param['sort']}"">delete</a>
				</td>
				<td>
					<a href="/admin/country/update/${country.id}">update</a>
				</td>
			</tr>
		</c:forEach>
			<tr>
				<c:if test="${!page.isFirst()}">
					<td><a href="?page=${page.number}&size=${page.size}&sort=${param['sort']}">Previous</a></td>
				</c:if>
				<c:if test="${!page.isLast()}">
					<td><a href="?page=${page.number+2}&size=${page.size}&sort=${param['sort']}">Next</a></td>
				</c:if>
			</tr>
			<tr>
				<td><a href="?page=1&size=1&sort=${param['sort']}">1</a></td>
				<td><a href="?page=1&size=5&sort=${param['sort']}">5</a></td>
				<td><a href="?page=1&size=10&sort=${param['sort']}">10</a></td>
				<td><a href="?page=1&size=20&sort=${param['sort']}">20</a></td>
			</tr>
			<tr>
				<td><a href="?page=1&size=${page.size}&sort=name">Name asc</a></td>
				<td><a href="?page=1&size=${page.size}&sort=name,desc">Name desc</a></td>
			</tr>
	</table>
</body>
</html>