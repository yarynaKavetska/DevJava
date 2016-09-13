<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="collapse navbar-collapse" id="">
							<ul class="nav navbar-nav">
								<li><a href="/admin/country">Country</a></li>
								<li><a href="/admin/ingredient">Ingredient</a></li>
								<li><a href="/admin/measuringSystem">Measuring System</a></li>
								<li><a href="/admin/recipe">Recipe</a></li>
								<li class="active"><a href="/admin/ingredientAmount">Amount and ingredient</a><span
										class="sr-only">(current)</span></li>
								<li><a href="/admin/country/recipe">Recipe country</a></li>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
	<form action="/admin/ingredientAmount" method="post">
		<table>
			<tr>
				<td><input name="amount"></td>
				<td>
					<select name="msId">
						<c:forEach items="${measuringSystems}" var="measuringSystem">
							<option value="${measuringSystem.id}">${measuringSystem.name}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name="ingredientId">
						<c:forEach items="${ingredients}" var="ingredient">
							<option value="${ingredient.id}">${ingredient.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
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
				<td>
					<a href="/admin/ingredientAmount/delete/${ingredientAmount.id}">delete</a>
				</td>
				<td>
					<a href="/admin/ingredientAmount/update/${ingredientAmount.id}">update</a>
				</td>
			</tr>
		</c:forEach>
	</table>