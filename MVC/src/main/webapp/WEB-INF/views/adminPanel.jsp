<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
<p>Admin panel</p>
<a href="/admin/country">Country</a>
<a href="/admin/ingredient">Ingredient</a>
<a href="/admin/measuringSystem">Measuring system</a>
<a href="/admin/ingredientAmount">Ingredient and amount</a>
<a href="/admin/recipe">Recipe</a>
<form:form action="/logout" method="post">
	<input type="submit" value="Logout">
</form:form>
</security:authorize>
<button id="generate">Generate</button>
<select id="country">
	<option value="0">Select country</option>
</select>
<select id="region">
	<option value="0">Select region</option>
</select>
<script>
$(function() {
	
	var data1 = [{
		id : 1,
		name : 'Lviv'
	},{
		id : 2,
		name : 'Kyiv'
	}];
	
	var data2 = [{
		id : 1,
		name : 'Uta'
	},{
		id : 2,
		name : 'Man'
	}];
	
	var lviv = 'Lviv';
	var kyiv = 'Kyiv';
	
	var uta = 'Uta';
	var man = 'Man';
	
	$('#generate').on('click', function() {
		var id = prompt("Enter id");
		var label = prompt("Enter name");
		$('#country').append('<option value="'+id+'">'+label+'</option>');
	});
	
	$('#country').on('change', function(event) {
		$('#region').children().remove();
		if(event.target.value==1){
			for(var i = 0; i < 2; i++){
				$('#region').append('<option value="'+data1[i].id+'">'+data1[i].name+'</option>');
			}
// 			$('#region').append('<option value="'+1+'">'+lviv+'</option>');
// 			$('#region').append('<option value="'+2+'">'+kyiv+'</option>');
		}else if(event.target.value==2){
			for(var i = 0; i < 2; i++){
				$('#region').append('<option value="'+data2[i].id+'">'+data2[i].name+'</option>');
			}
// 			$('#region').append('<option value="'+1+'">'+uta+'</option>');
// 			$('#region').append('<option value="'+2+'">'+man+'</option>');
		}
	});
	
});


</script>