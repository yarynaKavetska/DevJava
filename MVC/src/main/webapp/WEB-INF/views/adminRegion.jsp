<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
$(function() {

	findAll();
	
	function findAll() {
		$.ajax({
			url : "/admin/region.json",
			method : 'get',
			success: function(data){
				$('#content').children().remove();
				for(var i = 0; i < data.length; i++){
					$('#content').append('<li id="'+data[i].id+'">'+data[i].name+'</li>');
				}
			}
		});
	}
	
	function showForm() {
		$('div.container').prepend('<br id="br">');
		$('div.container').prepend('<button id="submit">Done</button>');
		$('div.container').prepend('<input name="name">');
		$('#submit').on('click', function() {
			var name = $('input[name=name]').val();
			$('input[name=name]').val('');
			$.ajax({
				url : "/admin/region.json",
				method : 'PUT',
				contentType: "application/json",
				data : JSON.stringify({
					id : 0,
					name : name
				}),
				success: findAll
			});
		});
	}
	
	$('#show').on('click', showForm);
	
	$('#hide').on('click', function() {
		$('input[name=name]').remove();
		$('#submit').remove();
		$('#br').remove();
	})
	
	$('#content').on('click', function(event) {
		var name = prompt("Previous name "+event.target.innerText);
		$.ajax({
			url : "/admin/region.json",
			method : 'POST',
			contentType: "application/json",
			data : JSON.stringify({
				id : event.target.id,
				name : name
			}),
			success: findAll
		});
	});
});

</script>
<input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
<button id="show">Show form</button>
<button id="hide">Hide form</button>
<ul id="content">
</ul>