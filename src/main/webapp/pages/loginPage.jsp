<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="component/head.jsp"%>
<title>Quix | Login</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
</head>
<body class="d-flex-column">
	<jsp:include page="component/navbar.jsp" />

	<div class="container-fluid d-flex-column flex login-bg-img">

		<c:choose>
			<c:when test="${action == 'login'}">
				<jsp:include page="component/login.jsp" />
			</c:when>
			<c:when test="${action == 'register'}">
				<jsp:include page="component/register.jsp" />
			</c:when>
		</c:choose>

	</div>

</body>
</html>