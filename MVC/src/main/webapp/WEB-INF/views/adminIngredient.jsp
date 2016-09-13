<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row">
	<div class="col-md-12">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="collapse navbar-collapse" id="">
					<ul class="nav navbar-nav">
						<li><a href="/admin/country">Country</a></li>
						<li  class="active"><a href="/admin/ingredient">Ingredient</a><span
										class="sr-only">(current)</span></li>
						<li><a href="/admin/measuringSystem">Measuring System</a></li>
						<li><a href="/admin/recipe">Recipe</a></li>
						<li><a href="/admin/ingredientAmount">Amount and ingredient</a></li>
						<li><a href="/admin/country/recipe">Recipe country</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</div>
<div class="row-fluid">
	<div class="col-md-3">
		<form:form action="/admin/ingredient" class="form-inline" method="get" modelAttribute="filter">
				<c:forEach items="${param}" var="parameter">
					<c:forEach items="${parameter.value}" var="value">
						<c:if test="${parameter.key ne 'search'}">
							<input type="hidden" name="${parameter.key}" value="${value}">
						</c:if>
					</c:forEach>
				</c:forEach>
				<div class="form-group">
					<form:input path="search" placeholder="search" class="form-control" />
				</div>
					<button type="submit" class="btn btn-primary">Ok</button>
		</form:form>
	</div>
	<div class="col-md-7">
		<form:form action="/admin/ingredient" method="post" modelAttribute="ingredient" class="form-inline">
			<form:hidden path="id"/>
			<c:forEach items="${param}" var="parameter">
				<c:forEach items="${parameter.value}" var="value">
					<c:if test="${parameter.key ne 'name' and parameter.key ne 'id'}">
						<input type="hidden" name="${parameter.key}" value="${value}">
					</c:if>
				</c:forEach>
			</c:forEach>
			<div class="form-group">
				<label for="name"><form:errors path="name" /></label>
				<form:input path="name" id="name" placeholder="Ingredient name" class="form-control" />
				<button type="submit" class="btn btn-primary">Create ingredient</button>
			</div>
		</form:form>
		<div class="col-md-4"><h4>Ingredient name</h4></div>
		<div class="col-md-4"><h4>Delete</h4></div>
		<div class="col-md-4"><h4>Update</h4></div>
			<c:forEach items="${page.content}" var="ingredient">
				<div class="col-md-4">${ingredient.name}</div>
				<div class="col-md-4">
					<a href="/admin/ingredient/delete/${ingredient.id}?page=${page.number+1}&size=${page.size}&sort=${param['sort']}&search=${param['search']}">delete</a>
				</div>
				<div class="col-md-4">
					<a href="/admin/ingredient/update/${ingredient.id}?page=${page.number+1}&size=${page.size}&sort=${param['sort']}&search=${param['search']}">update</a>
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
					</ul>
				</div>
			</div>
			<div class="col-md-6">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
	</div>
	</div>