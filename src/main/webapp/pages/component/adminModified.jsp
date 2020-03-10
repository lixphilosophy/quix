<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<div class="admin-container m-auto d-flex">
  <div class="all-100">
    <jsp:include page="adminNav.jsp" />
    <div class="pt-3 px-6">
      <table id="view-modified-table" class="display" style="width:100%">
        <thead>
        <tr>
          <th>Quiz ID</th>
          <th>Category</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="quiz" items="${requestScope.quizzes}">
          <tr>
            <td>
              <a href="${pageContext.request.contextPath}/admin/quiz?id=${quiz.quizID}">
                  ${quiz.quizID}
              </a>
            </td>
            <td>${quiz.quizName}</td>
          </tr>
        </c:forEach>

        </tbody>
      </table>

    </div>


  </div>
</div>