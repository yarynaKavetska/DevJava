<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<p>Admin panel</p>
<a href="/admin/country">Country</a>
<a href="/admin/ingredient">Ingredient</a>
<a href="/admin/measuringSystem">Measuring system</a>
<a href="/admin/ingredientAmount">Ingredient and amount</a>
<a href="/admin/recipe">Recipe</a>
<form:form action="/logout" method="post">
	<input type="submit" value="Logout">
</form:form>