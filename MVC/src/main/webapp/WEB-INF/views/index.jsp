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

<button id="asdfr">Hi</button>
<button onclick="generator()">Generate</button>
<input id="asdf" onblur="asdf(event)">

<a href="/admin">Admin panel</a>
<script>
	$(document).ready(function () {
		$('#asdfr').click(function() {
			$('#asdf').val('Hello');
		});
	});
	var trigger = true;
	function show(){
		if(trigger){
			trigger = false;
			alert("Hi");
		}
		focus();
	}
	
// 	function focus() {
// 		var input = document.getElementById("asdf");
// 		input.value = "Hello";
// 	}
	
	function asdf(event) {
		var input = event.target;
		console.log(event);
		input.value = "";
	}
	
	function myArray() {
		var a = [];
		a[0] = 'asdf';
		a[1] = true;
		a[2] = 1;
		alert(a);
		alert(a[2]=='1');
	}
	
	function generator(){
		var response = prompt("Enter element");
		var parentId = prompt("Enter parent id");
		var element = document.createElement(response);
		var id = prompt("Enter id");
		element.id=id;
		if(parentId){
			document.getElementById(parentId).appendChild(element);
		}else{
			document.body.appendChild(element);
		}
	}
	
</script>