<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="/" method="post" modelAttribute="user">
<form:errors path="*"/>
	<input name="login" placeholder="login">
	<input name="password" type="password" placeholder="some like ******">
	<input type="submit" value="Register">
</form:form>

<c:if test="${param.fail eq true}">
	<p>Fail to authorize</p>
</c:if>

<a href="/admin">Admin panel</a>