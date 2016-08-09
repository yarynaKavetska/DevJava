<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form action="/admin/measuringSystem" method="post">
		<table>
			<tr>
				<td><input name="name" placeholder="MeasuringSystem name"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<th>MeasuringSystem name</th>
		</tr>
		<c:forEach items="${measuringSystems}" var="measuringSystem">
			<tr>
				<td>${measuringSystem.name}</td>
				<td>
					<a href="/admin/measuringSystem/delete/${measuringSystem.id}">
						delete
					</a>
				</td>
				<td>
					<a href="/admin/measuringSystem/update/${measuringSystem.id}">
						update
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>