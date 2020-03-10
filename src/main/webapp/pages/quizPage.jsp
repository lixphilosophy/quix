<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="component/head.jsp"%>
<title>Quix | Quiz</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/quiz.js"></script>
</head>
<body class="d-flex-column">
	<jsp:include page="component/navbar.jsp" />

	<c:choose>
		<c:when test="${requestScope.action == 'admin'}">
			<div class="container-fluid d-flex-column flex admin-bg">
		</c:when>
		<c:otherwise>
			<div class="container-fluid d-flex-column flex quiz-bg-blue">
		</c:otherwise>
	</c:choose>

		<c:choose>
			<c:when test="${requestScope.action == 'quiz'}">
				<jsp:include page="component/quiz.jsp" />
			</c:when>
			<c:when test="${requestScope.action == 'question'}">
				<jsp:include page="component/question.jsp" />
			</c:when>
			<c:when test="${requestScope.action == 'submission'}">
        <jsp:include page="component/submission.jsp" />
      </c:when>
      <c:when test="${requestScope.action == 'feedback'}">
        <jsp:include page="component/feedback.jsp" />
      </c:when>
			<c:when test="${requestScope.action == 'admin'}">
				<jsp:include page="component/submission.jsp" />
			</c:when>

		</c:choose>
		
	</div>

</body>
</html>