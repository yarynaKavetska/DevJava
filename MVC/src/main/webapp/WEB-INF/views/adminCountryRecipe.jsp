<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table>
	<tr>
		<th>Country</th>
		<th>Recipe</th>
	</tr>
	<c:forEach items="${countries}" var="country">
		<c:forEach items="${country.recipes}" var="recipe" varStatus="vs">
			<tr>
				<c:choose>
					<c:when test="${vs.isFirst()}">
						<td>${country.name}</td>
					</c:when>
					<c:otherwise>
						<td></td>
					</c:otherwise>
				</c:choose>
				<td>${recipe.name}</td>
			</tr>
		</c:forEach>
	</c:forEach>
</table>

