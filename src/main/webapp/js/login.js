$(document).ready(function(){
	var loginForm = $('form#login-form');
	loginForm.submit(function(e){
		e.preventDefault();
		
		var params = loginForm.serializeArray().reduce(function(obj, item) {
	        obj[item.name] = item.value;
	        return obj;
		}, {});
		
		$.ajax({
			url: '/quix/login',
			data: params,
			dataType: 'json',
			type: 'post',
			success: function(res) {
//				console.log(res);
				if(!res.success) {
					$('#error').text(res.errMsg);
					$('#error').show();
				} else {
//					console.log(res.redirectUrl);
					window.location = res.redirectUrl;
				}
			}
		});
	});
	
	var registerForm = $('form#register-form');
	registerForm.submit(function(e){
		e.preventDefault();
		
		var params = registerForm.serializeArray().reduce(function(obj, item) {
	        obj[item.name] = item.value;
	        return obj;
		}, {});
		
		$.ajax({
			url: '/quix/register',
			data: params,
			dataType: 'json',
			type: 'post',
			success: function(res) {
				console.log(res);
				if(!res.success) {
					console.log(res.errMsg);
					$('#error').text(res.errMsg);
					$('#error').show();
				} else {
//					console.log(res.redirectUrl);
					window.location = res.redirectUrl;
				}
			}
		});
	});
});