<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header
	class="navbar navbar-expand navbar-light flex-column flex-md-row quix-navbar">
	<div class="navbar-nav navbar-brand quix-brand">
		<a class="cursor-pointer" href="${pageContext.request.contextPath}/page/quiz"> <i class="fas fa-book-dead"></i><span>Quix</span>
		</a>

		<ul class="navbar-nav flex-row ml-3 ml-md-auto d-flex d-sm-none">
			<c:choose>
				<c:when test="${empty sessionScope.userID}">
					<li class="nav-item"><a href="${pageContext.request.contextPath}/login" class="btn quix-login">Login</a></li>
					<li class="nav-item"><a href="${pageContext.request.contextPath}/register" class="btn quix-register">Register</a></li>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${sessionScope.role == 2}">
							<li class="nav-item">
								<a class="btn quix-name"
									 href="${pageContext.request.contextPath}/admin">
									<c:out value="${sessionScope.firstName}" />
								</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="nav-item">
								<a class="btn quix-name"
									href="${pageContext.request.contextPath}/page/userpage">
								<c:out value="${sessionScope.firstName}" />
								</a>
							</li>
						</c:otherwise>
					</c:choose>

					<li class="nav-item"><a class="btn quix-logout"
						href="${pageContext.request.contextPath}/logout">Logout</a></li>

				</c:otherwise>
			</c:choose>
		</ul>

	</div>

	<div class="navbar-nav-scroll">
		<ul class="navbar-nav bd-navbar-nav flex-row">
			<li class="nav-item"><a
				class="nav-link cursor-pointer quix-link" href="${pageContext.request.contextPath}/page/quiz">Take
					Quiz</a></li>
			<li class="nav-item"><a
				class="nav-link cursor-pointer quix-link" href="${pageContext.request.contextPath}/page/feedback">Feedback</a></li>
			<li class="nav-item"><a
				class="nav-link cursor-pointer quix-link" href="${pageContext.request.contextPath}/page/contact">Contact
					Us</a></li>

			<c:if test = "${sessionScope.role == 2}">
				<li class="nav-item"><a
					class="nav-link cursor-pointer quix-link" href="${pageContext.request.contextPath}/admin">Admin</a></li>
			</c:if>
		</ul>
	</div>

	<ul class="navbar-nav flex-row ml-md-auto d-none d-sm-flex">

		<c:choose>
			<c:when test="${empty sessionScope.userID}">
				<li class="nav-item"><a class="btn quix-login"
					href="${pageContext.request.contextPath}/login">Login</a></li>
				<li class="nav-item"><a class="btn quix-register"
					href="${pageContext.request.contextPath}/register">Register</a></li>
			</c:when>
			<c:otherwise>

					<li class="nav-item">
						<a class="btn quix-name"
							 href="${pageContext.request.contextPath}/page/userpage">
							<c:out value="${sessionScope.firstName}" />
						</a>
					</li>

				<li class="nav-item"><a class="btn quix-logout"
					href="${pageContext.request.contextPath}/logout">Logout</a></li>
			</c:otherwise>
		</c:choose>

	</ul>

</header>