<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="quiz-container m-auto d-flex-column">

	<div class="all-100 submission-container">

		<c:choose>
			<c:when test="${requestScope.action == 'admin'}">
				<div>
					<div class="row m-0 mt-4">
						<span class="col-1"></span>
						<div class="col-10 d-flex pb-3">
							<div class="ml-auto">
								<a class="admin-back-button font-18 admin-submission-button"
									 href="${pageContext.request.contextPath}/admin/submission">
									Back to Quiz List
								</a>
							</div>
						</div>
						<span class="col-1"></span>
					</div>
					<div class="row m-0">
						<span class="col-1"></span>
						<div class="col-10 line-bottom"></div>
						<span class="col-1"></span>
					</div>
				</div>
				<div class="row m-0 mt-4">
					<span class="col-1"></span>
					<div class="col-10 d-flex">
						<h4>${requestScope.submission.userInfo.firstName} ${requestScope.submission.userInfo.lastName} Submission</h4>
						<h4 class="userSubmission-status ml-auto color-red">
							<c:out value="${status}" />
						</h4>
					</div>
					<span class="col-1"></span>
				</div>
				<div class="row m-0 mt-1">
					<span class="col-1"></span>
					<div class="col-10 line-bottom"></div>
					<span class="col-1"></span>
				</div>
			</c:when>

			<c:when test="${requestScope.action == 'submission'}">
				<div class="row m-0 mt-5">
					<span class="col-1"></span>
					<div class="col-10 d-flex">
						<h4>Submission</h4>
						<h4 class="userSubmission-status ml-auto color-red">
							<c:out value="${status}" />
						</h4>
					</div>
					<span class="col-1"></span>
				</div>
				<div class="row m-0 mt-1">
					<span class="col-2"></span>
					<div class="col-8 line-bottom"></div>
					<span class="col-2"></span>
				</div>
			</c:when>
		</c:choose>



		<div class="row m-0 my-3 font-14 px-5">
			<span class="col-1"></span>
			<div class="col-10 d-flex">
				<div>
					<strong class="pr-1">Start Time:</strong>${requestScope.submission.startTime}</div>
			</div>
			<span class="col-1"></span> <span class="col-1"></span>
			<div class="col-10 d-flex pt-2">
				<div>
					<strong class="pr-1">End Time:</strong>${requestScope.submission.endTime}</div>
			</div>
			<c:choose>
				<c:when test="${requestScope.action == 'submission'}">
					<span class="col-1"></span> <span class="col-1"></span>
					<div class="col-10 d-flex pt-2">
						<div>
							<strong class="pr-1">Name:</strong>${sessionScope.firstName}
							${sessionScope.lastName}
						</div>
					</div>
					<span class="col-1"></span>
				</c:when>
			</c:choose>
		</div>

		<c:choose>
			<c:when test="${requestScope.action == 'submission'}">
				<div class="row m-0 my-3 font-14 px-5">
					<span class="col-1"></span>
					<div class="col-10 d-flex">
						<div><a href="${pageContext.request.contextPath}/page/feedback">Take a feedback</a></div>
						<div class="ml-3"><a href="${pageContext.request.contextPath}/page/quiz">Have another quiz</a></div>
					</div>
					<span class="col-1"></span>
				</div>
			</c:when>
		</c:choose>

		<c:choose>
			<c:when test="${requestScope.action == 'admin'}">
				<div class="row m-0 mt-1">
					<span class="col-1"></span>
					<div class="col-10 line-bottom"></div>
					<span class="col-1"></span>
				</div>
			</c:when>
			<c:when test="${requestScope.action == 'submission'}">
				<div class="row m-0 mt-1">
					<span class="col-2"></span>
					<div class="col-8 line-bottom"></div>
					<span class="col-2"></span>
				</div>
			</c:when>
		</c:choose>


		<c:forEach var="userAnswer" items="${requestScope.submission.userAnswers}"
			varStatus="loop">
			<div class="row m-0 mt-3 submit-question">
				<span class="col-1"></span>
				<div class="col-10">
					<div class="d-flex">
						<span> <c:choose>
								<c:when test="${userAnswer.ifCorrect == true}">
									<i class="fas fa-check-circle color-green"></i>
								</c:when>
								<c:when test="${userAnswer.ifCorrect == false}">
									<i class="fas fa-times-circle color-red"></i>
								</c:when>
							</c:choose>
						</span> <span class="pl-2">${loop.index+1}<span class="pr-1">.</span>${userAnswer.question.questionString}</span>
					</div>
				</div>
				<span class="col-1"></span> <span class="col-1"></span>
				<div class="col-10">
					<c:forEach var="choice" items="${userAnswer.question.choices}">
						<div class="question-choice pb-2">
							<c:choose>
								<c:when test="${choice.choiceString.equals(userAnswer.answerString)}">
									<input type="radio" name="${choice.questionID}" disabled checked
												 value="${choice.choiceString}">
								</c:when>
								<c:otherwise>
									<input type="radio" name="userAnswer" disabled
												 value="${choice.choiceString}">
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${choice.ifCorrect}">
									<span class="pl-1 color-green">${choice.choiceString}</span>
								</c:when>
								<c:otherwise>
									<span class="pl-1">${choice.choiceString}</span>
								</c:otherwise>

							</c:choose>

						</div>
					</c:forEach>
				</div>
				<span class="col-1"></span>
			</div>

		</c:forEach>
	     <div class="row m-0 pt-6">
        <span class="col-1"></span>
        <div class="col-10"></div>
        <span class="col-1"></span>
      </div>
	</div>

</div>