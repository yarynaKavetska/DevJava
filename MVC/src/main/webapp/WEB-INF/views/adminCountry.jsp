<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form:form action="/admin/country" method="post" modelAttribute="country">
		<form:hidden path="id"/>
		<c:forEach items="${param}" var="parameter">
			<c:forEach items="${parameter.value}" var="value">
				<input type="hidden" name="${parameter.key}" value="${value}">
			</c:forEach>
		</c:forEach>
		<table>
			<tr>
				<td><form:errors path="name"/></td>
			</tr>
			<tr>
				<td><form:input path="name" placeholder="country name"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="create country"></td>
			</tr>
		</table>
	</form:form>
	<form:form action="/admin/country" method="get" modelAttribute="filter">
		<c:forEach items="${param}" var="parameter">
			<c:forEach items="${parameter.value}" var="value">
				<c:if test="${parameter.key ne 'search'}">
					<input type="hidden" name="${parameter.key}" value="${value}">
				</c:if>
			</c:forEach>
		</c:forEach>
		<table>
			<tr>
				<td><form:input path="search" placeholder="search"/><input type="submit" value="ok"></td>
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
					<a href="/admin/country/delete/${country.id}?page=${page.number+1}&size=${page.size}&sort=${param['sort']}&search=${param['search']}">delete</a>
				</td>
				<td>
					<a href="/admin/country/update/${country.id}?page=${page.number+1}&size=${page.size}&sort=${param['sort']}&search=${param['search']}">update</a>
				</td>
			</tr>
		</c:forEach>
			<tr>
				<td><a href="?page=1&size=1&sort=${param['sort']}&search=${param['search']}">1</a></td>
				<td><a href="?page=1&size=5&sort=${param['sort']}&search=${param['search']}">5</a></td>
				<td><a href="?page=1&size=10&sort=${param['sort']}&search=${param['search']}">10</a></td>
				<td><a href="?page=1&size=20&sort=${param['sort']}&search=${param['search']}">20</a></td>
			</tr>
			<tr>
				<td><a href="?page=1&size=${page.size}&sort=name&search=${param['search']}">Name asc</a></td>
				<td><a href="?page=1&size=${page.size}&sort=name,desc&search=${param['search']}">Name desc</a></td>
			</tr>
	</table>
	<div class="col-md-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
	</div>
</body>
</html>