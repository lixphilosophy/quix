<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="quiz-container m-auto d-flex">

	<div class="feedback-container d-flex-column">

		<h2>Feedback</h2>
		<h6 class="pb-3">Thank you for your comment!</h6>

		<div class="d-flex">
			<div class="rating-title">
				<span><strong>Rating: </strong></span>
			</div>
			<div class="rating-group pl-3">
				<input class="rating__input rating__input--none" name="rating"
					id="rating-none" value="0" type="radio"> <label
					aria-label="1 star" class="rating__label" for="rating-1"><i
					class="rating__icon rating__icon--star fa fa-star"></i></label> <input
					class="rating__input" name="rating" id="rating-1" value="1"
					type="radio"> <label aria-label="2 stars"
					class="rating__label" for="rating-2"><i
					class="rating__icon rating__icon--star fa fa-star"></i></label> <input
					class="rating__input" name="rating" id="rating-2" value="2"
					type="radio"> <label aria-label="3 stars"
					class="rating__label" for="rating-3"><i
					class="rating__icon rating__icon--star fa fa-star"></i></label> <input
					class="rating__input" name="rating" id="rating-3" value="3"
					type="radio" checked> <label aria-label="4 stars"
					class="rating__label" for="rating-4"><i
					class="rating__icon rating__icon--star fa fa-star"></i></label> <input
					class="rating__input" name="rating" id="rating-4" value="4"
					type="radio"> <label aria-label="5 stars"
					class="rating__label" for="rating-5"><i
					class="rating__icon rating__icon--star fa fa-star"></i></label> <input
					class="rating__input" name="rating" id="rating-5" value="5"
					type="radio">
			</div>
		</div>

		<div class="d-flex pt-3">
			<div class="rating-title">
				<span><strong>Title: </strong></span>
			</div>
			<input class="flex ml-3">
		</div>

		<div class="d-flex pt-3 flex">
			<div class="rating-title">
				<span><strong>Comment: </strong></span>
			</div>
			<input class="flex ml-3 flex">
		</div>
		
		<div class="d-flex pt-5 flex">
      <button id="feedback-submit" class="btn btn-primary feedback-submit">Submit</button>
    </div>

	</div>

  <script>
    $('#feedback-submit').click(function(){
    	alert('Thank you!');
    	windows.location = '${pageContext.request.contextPath}/page/feedback';
    });
  </script>

</div>