<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row-fluid">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="collapse navbar-collapse" id="">
							<ul class="nav navbar-nav">
								<li><a href="/admin/country">Country</a></li>
								<li><a href="/admin/ingredient">Ingredient</a></li>
								<li><a href="/admin/measuringSystem">Measuring System</a></li>
								<li><a href="/admin/recipe">Recipe</a></li>
								<li><a href="/admin/ingredientAmount">Amount and ingredient</a></li>
								<li  class="active"><a href="/admin/country/recipe">Recipe country</a><span
								<li><a href="/admin/region">Region</a></li>		class="sr-only">(current)</span></li>
							</ul>
						</div>
					</div>
				</nav>
			</div>
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

