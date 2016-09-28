<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row-fluid">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="collapse navbar-collapse" id="">
							<ul class="nav navbar-nav">
								<li class="active"><a href="/admin/country">Country</a><span
										class="sr-only">(current)</span></li>
								<li><a href="/admin/ingredient">Ingredient</a></li>
								<li><a href="/admin/measuringSystem">Measuring System</a></li>
								<li><a href="/admin/recipe">Recipe</a></li>
								<li><a href="/admin/ingredientAmount">Amount and ingredient</a></li>
								<li><a href="/admin/country/recipe">Recipe country</a></li>
								<li><a href="/admin/region">Region</a></li>
							</ul>
						</div>
					</div>
				</nav>
		</div>
	<div class="row-fluid">
		<div class="col-md-3 col-xs-12">
		<div class="col-md-12 col-xs-12">
		<form:form action="/admin/country" class="form-inline" method="get" modelAttribute="filter">
				<custom:hiddenInputs excludeParams="search"/>
				<div class="form-group">
					<form:input path="search" placeholder="search" class="form-control" />
					<label></label>
					<button type="submit" class="btn btn-primary">Ok</button>
				</div>
			</form:form>
		</div>
		</div>
		<div class="col-md-7 col-xs-12">
		<div class="col-md-12 col-xs-12">
			<form:form action="/admin/country" method="post" class="form-inline" 
				modelAttribute="country">
				<form:hidden path="id" />
				<custom:hiddenInputs excludeParams="name, id"/>
				<div class="form-group">
					<form:input id="name" path="name" placeholder="country name" class="form-control" />
					<label for="name"><form:errors path="name" /></label>
					<button type="submit" class="btn btn-primary">Create country</button>
				</div>
			</form:form>
		</div>
			<div class="col-md-4 col-xs-4"><h4>Country name</h4></div>
			<div class="col-md-4 col-xs-4"><h4>Delete</h4></div>
			<div class="col-md-4 col-xs-4"><h4>Update</h4></div>
			<c:forEach items="${page.content}" var="country">
				<div class="col-md-4 col-xs-4">${country.name}</div>
				<div class="col-md-4 col-xs-4">
					<a href="/admin/country/delete/${country.id}<custom:allParams/>">delete</a>
				</div>
				<div class="col-md-4 col-xs-4">
					<a href="/admin/country/update/${country.id}<custom:allParams/>">update</a>
				</div>
			</c:forEach>
			<div class="col-md-12 col-xs-12 text-center">
				<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
			</div>
		</div>
		<div class="col-md-2 col-xs-12">
			<div class="col-md-6 col-xs-6 text-center">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Name asc" paramValue="name"/>
						<custom:sort innerHtml="Name desc" paramValue="name,desc"/>
					</ul>
				</div>
			</div>
			<div class="col-md-6 col-xs-6 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" title="Page size"/>
			</div>
		</div>
	</div>