<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="/resources/css/ingredientAmount.css">
<script>
$(function() {
	$('select[name=system]').chosen();
	$('select[name=ingredient]').chosen();
});
</script>
	<div class="row-fluid">
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
								<li><a href="/admin/region">Region</a></li>
							</ul>
						</div>
					</div>
				</nav>
		</div>
<div class="row-fluid">
	<div class="col-md-3 col-xs-12">
			<form:form action="/admin/ingredientAmount" class="form-inline" method="get" modelAttribute="filter">
				<custom:hiddenInputs excludeParams="min, max, msIds, ingredientIds, _ingredientIds, _msIds"/>
				<div class="form-group">
					<form:input path="min" placeholder="min" class="form-control"/>
					<form:input path="max" placeholder="max" class="form-control"/>
				</div>
				<div class="form-group">
					<h4>Measuring system</h4>
				</div>
				<div class="form-group">
					<form:checkboxes items="${measuringSystems}" path="msIds" itemLabel="name" itemValue="id" />
				</div>
				<div class="form-group">
					<h4>Ingredients</h4>
				</div>
				<div class="form-group">
					<form:checkboxes items="${ingredients}" path="ingredientIds" itemLabel="name" itemValue="id"/>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Ok</button>
				</div>
			</form:form>
		</div>
	<div class="col-md-7 col-xs-12">
	<form:form class="form-inline" action="/admin/ingredientAmount" method="post" modelAttribute="form">
		<form:hidden path="id" />
		<custom:hiddenInputs excludeParams="amount, system, ingredient, id"/>
					<div class="form-group">
						<label for="amount"><form:errors path="amount" /></label>
						<form:input path="amount" class="form-control" />
						<form:select path="system" items="${measuringSystems}" itemLabel="name" itemValue="id">
						</form:select>
						<form:select path="ingredient" items="${ingredients}" itemLabel="name" itemValue="id">
						</form:select>
						<button type="submit" class="btn btn-primary">Create</button>
					</div>
	</form:form>
	<div class="row">
		<div class="col-md-2">Amount</div>
		<div class="col-md-2">Measuring system</div>
		<div class="col-md-4">Ingredient</div>
		<div class="col-md-2"><h4>Delete</h4></div>
		<div class="col-md-2"><h4>Update</h4></div>
	</div>
		<c:forEach items="${page.content}" var="ingredientAmount">
			<div class="row">
				<div class="col-md-2">${ingredientAmount.amount}</div>
				<div class="col-md-2">${ingredientAmount.measuringSystem.name}</div>
				<div class="col-md-4">${ingredientAmount.ingredient.name}</div>
				<div class="col-md-2"><a href="/admin/ingredientAmount/delete/${ingredientAmount.id}<custom:allParams/>">delete</a></div>
				<div class="col-md-2"><a href="/admin/ingredientAmount/update/${ingredientAmount.id}<custom:allParams/>">update</a></div>
			</div>
		</c:forEach>
		<div class="col-md-12 text-center">
			<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
		</div>
	</div>
	<div class="col-md-2 col-xs-12">
			<div class="col-md-6">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Amount asc" paramValue="amount"/>
						<custom:sort innerHtml="Amount desc" paramValue="amount,desc"/>
						<custom:sort innerHtml="Ingredient name asc" paramValue="ingredient.name"/>
						<custom:sort innerHtml="Ingredient name desc" paramValue="ingredient.name,desc"/>
						<custom:sort innerHtml="Ms name asc" paramValue="measuringSystem.name"/>
						<custom:sort innerHtml="Ms name desc" paramValue="measuringSystem.name,desc"/>
					</ul>
				</div>
			</div>
			<div class="col-md-6">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" title="Розмір сторінки"/>
			</div>
		</div>
</div>