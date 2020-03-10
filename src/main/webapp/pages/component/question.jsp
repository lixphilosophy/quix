<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="quiz-container m-auto d-flex-column">

	<input type="text" id="quiz-id" value="${requestScope.quizId}" hidden/>

	<div class="row flex m-0">
		<div class="col-4 px-5 question-navbar d-flex-column">
			<div class="d-flex-column m-auto">

				<div class="question-time">
					<div class="pb-1">Remaining Time</div>
					<input type="text" id="question-time" value="00:00" disabled />
					<input type="text" id="start-time" disabled hidden />
					<input type="text" id="end-time" disabled hidden />
					<p id="demo"></p>
				</div>

				<div class="row mx-0 question-selectors flex-row">
					<c:forEach items="${requestScope.questions}" varStatus="loop">
						<div class="col-sm p-0">
							<div class="question-selector">${loop.index+1 < 10 ? '0' : ''}${loop.index+1}
							</div>
						</div>
					</c:forEach>
				</div>

				<span class="flex"></span>
				<button class="btn btn-block question-submit" id="question-submit">Submit</button>
				<button class="btn btn-block question-cancel mt-3"
					id="question-cancel">Cancel</button>
			</div>

		</div>
		<div class="col-8 p-0">
			<c:forEach var="question" items="${requestScope.questions}" varStatus="loop">
				<div class="question all-100">

					<div class="d-flex all-100">
						<div class="m-auto question-container d-flex-column">
							<h5>${loop.index+1}<span class="pr-1">.</span>${question.questionString}</h5>

							<form>
								<input name="questionID" value="${question.questionID}"
									hidden="true">
								<c:forEach var="choice" items="${question.choices}"
									varStatus="loop">
									<div class="question-choice pb-1">
										<input type="radio" name="userAnswer"
											value='${choice.choiceString}' onclick="selected(this)">
										<span class="pl-1">${choice.choiceString}</span>
									</div>
								</c:forEach>
							</form>

							<span class="flex"></span>
							<div class="ml-auto">
								<button class="btn question-prev">Prev</button>
								<button class="btn question-next">Next</button>
							</div>
						</div>
					</div>

				</div>
			</c:forEach>
		</div>
	</div>
	<script>
		$(".question-selector").first().addClass("active");
		$(".question").first().addClass("active");
    timeCount();
	</script>
</div>
