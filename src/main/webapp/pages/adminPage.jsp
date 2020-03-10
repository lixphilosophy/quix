<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <%@include file="component/head.jsp"%>
  <title>Quix | Admin</title>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/admin.js"></script>
</head>
<body class="d-flex-column">
<jsp:include page="component/navbar.jsp" />

<div class="container-fluid d-flex-column flex admin-bg">

  <c:choose>
    <c:when test="${action == 'admin'}">
      <jsp:include page="component/admin.jsp" />
    </c:when>
    <c:when test="${action == 'submission'}">
      <jsp:include page="component/adminSubmission.jsp" />
    </c:when>
    <c:when test="${action == 'profile'}">
      <jsp:include page="component/adminProfile.jsp" />
    </c:when>
    <c:when test="${action == 'modified'}">
      <jsp:include page="component/adminModified.jsp" />
    </c:when>
    <c:when test="${action == 'quiz'}">
      <jsp:include page="component/adminQuiz.jsp" />
    </c:when>
    <c:when test="${requestScope.action == 'addQuestion'}">
      <jsp:include page="component/adminAddQuestion.jsp" />
    </c:when>
    <c:when test="${requestScope.action == 'editQuestion'}">
      <jsp:include page="component/adminEditQuestion.jsp" />
    </c:when>

  </c:choose>

</div>

</body>
</html>