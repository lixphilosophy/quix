<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <%@include file="component/head.jsp" %>
  <title>Quix | User Page</title>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/userpage.js"></script>
  <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/emailjs-com@2.3.2/dist/email.min.js"></script>
  <script type="text/javascript">
    (function () {
      emailjs.init("user_OuamvFJLf2475ceQq4OsW");
    })();
  </script>
</head>
<body class="d-flex-column">
<jsp:include page="component/navbar.jsp"/>

<div class="container-fluid d-flex-column flex quiz-bg-white">


  <c:choose>
    <c:when test="${action == 'contact'}">
      <jsp:include page="component/contact.jsp"/>
    </c:when>
  </c:choose>

</div>

</body>
</html>