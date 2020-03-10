<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<div class="admin-container m-auto d-flex">
  <div class="all-100">
    <jsp:include page="adminNav.jsp" />
    <div class="pt-3 px-6">
      <table id="view-quiz-table" class="display" style="width:100%">
        <thead>
        <tr>
          <th>Submission ID</th>
          <th>Category</th>
          <th>User Name</th>
          <th>Correct</th>
          <th>No. of Question</th>
          <th>Quiz Date</th>
        </tr>
        </thead>
        <tbody>
          <c:forEach var="submission" items="${requestScope.submissions}">
            <tr>
              <td>
                <a href="${pageContext.request.contextPath}/admin/submission/detail?id=${submission.submissionID}">
                  ${submission.submissionID}
                </a>
              </td>
              <td>${submission.quizInfo.quizName}</td>
              <td>
                <span style="text-transform: capitalize">${fn:toLowerCase(submission.userInfo.firstName)} </span>
                <span style="text-transform: capitalize">${fn:toLowerCase(submission.userInfo.lastName)}</span>
              </td>
              <td>${submission.correctCount}</td>
              <td>${submission.totalCount}</td>
              <td>${submission.endTime}</td>
            </tr>
          </c:forEach>

        </tbody>
      </table>

    </div>

  </div>
</div>