<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="quiz-container m-auto d-flex">

	<div class="feedback-container d-flex-column">
		<h2>Contact US</h2>

    <h6>Please send us an email!</h6>

		<form id="send-email">
			<div class="d-flex-column d-lg-flex pt-3">
				<span class="email-label pb-1 pb-lg-0">Your name: </span> <input
					name="from_name" class="flex email-input" required="required">
			</div>
			<div class="pt-2 d-flex-column d-lg-flex">
				<span class="email-label pb-1 pb-lg-0">Email Address: </span> <input
					name="reply_to" class="flex email-input" type="email" required>
			</div>
			<div class="pt-2 d-flex-column d-lg-flex pb-3">
				<span class="email-label pb-1 pb-lg-0">Content: </span>
				<textarea name="message_html" class="flex email-input"
					required="required"></textarea>
			</div>

			<button
				class="mt-2 border-none color-white bg-color-black font-18 cursor-pointer outline-none"
				id="email-submit" type="submit">Send to me!</button>
		</form>
	</div>

</div>