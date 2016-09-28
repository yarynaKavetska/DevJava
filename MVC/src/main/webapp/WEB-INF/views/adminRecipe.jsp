<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>
$(function() {
	$('select[name=country]').chosen();
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
								<li class="active"><a href="/admin/recipe">Recipe</a><span
										class="sr-only">(current)</span></li>
								<li><a href="/admin/ingredientAmount">Amount and ingredient</a></li>
								<li><a href="/admin/country/recipe">Recipe country</a></li>
								<li><a href="/admin/region">Region</a></li>
							</ul>
						</div>
					</div>
				</nav>
		</div>
		<div class="row-fluid">
		<div class="col-md-3">
		<form:form action="/admin/country" class="form-inline" method="get" modelAttribute="filter">
				<custom:hiddenInputs excludeParams="search"/>
				<div class="form-group">
<%-- 					<form:input path="search" placeholder="search" class="form-control" /> --%>
					<button type="submit" class="btn btn-danger">Ok</button>
				</div>
			</form:form>
		</div>
		<div class="col-md-7">
	<form:form action="/admin/recipe" method="post" modelAttribute="form" class="form-inline" enctype="multipart/form-data">
		<form:errors path="*"/>
		<form:hidden path="id" />
		<form:hidden path="path" />
		<form:hidden path="version" />
		<custom:hiddenInputs excludeParams="name, id, time, path, version, country"/>
			<div class="form-group">
			<form:select path="country" items="${countries}" itemLabel="name" itemValue="id">
				<option value="0">Country</option>
			</form:select>
			<label for="name"><form:errors path="name"/></label>
			<form:input path="name" id="name" class="form-control"  placeholder="Recipe name" />
			<label for="time"><form:errors path="time" /></label>
			<form:input path="time" id="time" class="form-control" placeholder="HH:MM:SS" />
			<label class="btn btn-default btn-file">
        		Browse <input type="file" name="file" style="display: none;">
    		</label>
			<button type="submit" class="btn btn-primary">Create Recipe</button>
			</div>
	</form:form>
	<div class="row">
		<div class="col-md-3"><h4>Image</h4></div>
		<div class="col-md-3"><h4>Recipe name</h4></div>
		<div class="col-md-3"><h4>Delete</h4></div>
		<div class="col-md-3"><h4>Update</h4></div>
	</div>
		<c:forEach items="${page.content}" var="recipe">
		<div class="row">
			<div class="col-md-3"><img class="img-thumbnail" width="100" src="/images/recipe/${recipe.id}${recipe.path}?version=${recipe.version}" /></div>
			<div class="col-md-3"><h4>${recipe.name}</h4></div>
			<div class="col-md-3"><h4><a href="/admin/recipe/delete/${recipe.id}<custom:allParams/>">delete</a></h4></div>
			<div class="col-md-3"><h4><a href="/admin/recipe/update/${recipe.id}<custom:allParams/>">update</a></h4></div>
		</div>
		</c:forEach>
		<div class="col-md-12 text-center">
				<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
		</div>
		</div>
		<div class="col-md-2">
			<div class="col-md-6">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Name asc" paramValue="name"/>
						<custom:sort innerHtml="Name desc" paramValue="name,desc"/>
						<custom:sort innerHtml="Time asc" paramValue="time"/>
						<custom:sort innerHtml="Time desc" paramValue="time,desc"/>
						<custom:sort innerHtml="Country name asc" paramValue="country.name"/>
						<custom:sort innerHtml="Country name desc" paramValue="country.name,desc"/>
					</ul>
				</div>
			</div>
			<div class="col-md-6">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" title="Page size"/>
			</div>
		</div>
	</div>