<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="quiz-container m-auto d-flex-column">
	<div class="row flex m-0">
		<div class="col-3 py-3 d-flex-column">
			<div class="flex line-right">
				<dl class="m-0 pl-md-3">
					<c:forEach var="info" items="${requestScope.quizInfos}">
						<dt class="quiz-title">${info.quizName}</dt>
					</c:forEach>
				</dl>
			</div>
		</div>
		<div class="col-9 p-0">

			<c:forEach var="info" items="${requestScope.quizInfos}">
				<div class="all-100 quiz-detail">

					<h3>${info.quizName}<span class="quiz-time">Total
							time: ${info.quizCount} min</span>
					</h3>
					<div class="line-bottom"></div>
					<img class="mt-3 quiz-detail-img" src="${info.quizImg}">
					<p class="mt-3">${info.quizDesc}</p>
					<a type="submit" class="btn btn-primary"
						href="${pageContext.request.contextPath}/page/question?id=${info.quizID}">Start Quiz!</a>
				</div>
			</c:forEach>

		</div>
		<script>
			$(".quiz-title").first().addClass("active");
			$(".quiz-detail").first().addClass("active");
		</script>
	</div>

</div>
