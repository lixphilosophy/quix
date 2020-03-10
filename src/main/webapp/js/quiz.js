$(document).ready(function() {

	$('.quiz-title').click(function() {
		$('.quiz-title').removeClass('active');
		$('.quiz-detail').removeClass('active');
		let idx = $('.quiz-title').index(this);
		$(this).addClass('active');
		$('.quiz-detail').eq(idx).addClass('active');
	});

	$('.question-selector').click(function() {
		$('.question-selector').removeClass('active');
		$('.question').removeClass('active');
		let idx = $('.question-selector').index(this);
		$(this).addClass('active');
		$('.question').eq(idx).addClass('active');
	});

	$('.question:first-child .question-prev').hide();
	$('.question:first-child .question-prev').prop('disabled', true);
	$('.question:last-child .question-next').hide();
	$('.question:last-child .question-next').prop('disabled', true);

	$('.question-next').click(function() {
		let idx = $('.question').index($(this).closest(".question"));
		$('.question-selector').removeClass('active');
		$('.question').removeClass('active');
		$('.question-selector').eq(idx + 1).addClass('active');
		$('.question').eq(idx + 1).addClass('active');
	});

	$('.question-prev').click(function() {
		let idx = $('.question').index($(this).closest(".question"));
		$('.question-selector').removeClass('active');
		$('.question').removeClass('active');
		$('.question-selector').eq(idx - 1).addClass('active');
		$('.question').eq(idx - 1).addClass('active');
	});

	$('#question-submit').click(submit);
	
	$('#question-cancel').click(function(){
		location = '/quix/page/quiz';
	});
});

function selected(btn) {
	let idx = $('.question').index($(btn).closest(".question"));
	if (!$('.question-selector').eq(idx).hasClass('checked')) {
		$('.question-selector').eq(idx).addClass('checked');
	}
}

function submit() {
//	console.log($("#start-time").val());
//	console.log($("#end-time").val());
	
	let answers = [];

	$('.question').each(function() {
		let answer = $(this).find('form').serializeArray().reduce(function(obj, item) {
			obj[item.name] = item.value;
			return obj;
		}, {});

		answers.push(answer);
		// console.log(answer);
	});
//	console.log(answers);
	
	$.ajax({
		url: '/quix/page/submission',
		data: {
			quizID: $("#quiz-id").val(),
			startTime: $("#start-time").val(),
			endTime: $("#end-time").val(),
			submitAnswer: JSON.stringify(answers)
		},
		dataType: 'json',
		type: 'post',
		success: function(res) {
			if(!res.success) {
				console.log(res.errMsg);
			} else {
				window.location = res.redirectUrl;
			}
		}
	});
}

function timeCount() {
	let testTime = 15 * 60 * 60 * 1000;
	// let testTime = 15 * 60 * 1000;
// 	var testTime = 15 * 1000;
	
	var now = new Date();
	
	$("#start-time").val(now.toString());
		
	var countDownDate = now.getTime() + testTime;

	$("#end-time").val(new Date(countDownDate).toString());

	var timer = setInterval(function() {

	  let distance = countDownDate - new Date().getTime();

	  let minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
	  let seconds = Math.floor((distance % (1000 * 60)) / 1000);
	  
	  if(minutes < 10) minutes = "0" + minutes;
	  if(seconds < 10) seconds = "0" + seconds;

	  $("#question-time").val(minutes+":"+seconds);
	    
	  if (distance < 0) {
	    clearInterval(timer); 
	    $("#question-time").val("TIME OUT");
		alert("Time Out. Sorry, we need to submit your answer.");
		submit();
	  }
	}, 500);
	
}