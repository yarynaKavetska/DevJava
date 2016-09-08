<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="/admin/recipe" method="post" modelAttribute="recipe"
	enctype="multipart/form-data">
	<form:input path="id" type="hidden" />
	<form:hidden path="version" />
	<form:hidden path="path" />
	<div class="row">
		<form:select path="country" items="${countries}" itemLabel="name" itemValue="id">
<%-- 			<c:forEach items="${countries}" var="country"> --%>
<%-- 				<c:choose> --%>
<%-- 					<c:when test="${recipe.country.id eq country.id}"> --%>
<%-- 						<option value="${country.id}" selected="selected"> --%>
<%-- 							${country.name}</option> --%>
<%-- 					</c:when> --%>
<%-- 					<c:otherwise> --%>
<%-- 						<option value="${country.id}">${country.name}</option> --%>
<%-- 					</c:otherwise> --%>
<%-- 				</c:choose> --%>
<%-- 			</c:forEach> --%>
		</form:select>
	</div>
	<div class="row">
		<form:input path="name" placeholder="Recipe name" />
	</div>
	<div class="row">
		<form:input path="time" placeholder="HH:MM:SS" />
	</div>
	<div class="row">
		<input type="file" name="file">
	</div>
	<div class="row">
		<input type="submit">
	</div>
</form:form>
<div class="col-md-12">
	<div class="col-md-6">Recipe name</div>
	<c:forEach items="${recipes}" var="recipe">
		<div class="col-md-12">
			<div class="col-md-1">${recipe.name}</div>
			<div class="col-md-2"><img
				src="/images/recipe/${recipe.id}${recipe.path}?version=${recipe.version}"
				class="img-thumbnail" width="100" /></div>
			<div class="col-md-1"><a href="/admin/recipe/delete/${recipe.id}">delete</a></div>
			<div class="col-md-1"><a href="/admin/recipe/update/${recipe.id}">update</a></div>
			<div class="col-md-1"><a href="/admin/recipe/${recipe.id}">add ingredients</a></div>
		</div>
	</c:forEach>
</div>