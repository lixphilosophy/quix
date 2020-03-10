$(document).ready(function(){
	var emailForm = $("form#send-email");
	  emailForm.submit(function(e) {
		e.preventDefault();
	
		var params = emailForm.serializeArray().reduce(
				function(obj, item) {
					obj[item.name] = item.value;
					return obj;
				}, {});
	
		var service_id = "perosnal-01";
		var template_id = "template_bMmRQdbi";
	
		emailForm.find("button").text("Sending to me...");
	
		emailjs.send(service_id, template_id, params).then(
				function() {
					alert("We have received your E-mail. Thank you!");
					emailForm.find("button").text("Send to me!");
				},
				function(err) {
					alert("Sorry, send email failed!\r\n Response:\n "
							+ JSON.stringify(err));
					emailForm.find("button").text("Send to me!");
				});
	
		return false;
	});
});