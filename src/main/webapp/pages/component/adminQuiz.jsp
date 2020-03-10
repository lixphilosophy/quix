<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<div class="admin-container m-auto d-flex">
  <div class="all-100">
    <div>
      <div class="row m-0 mt-4">
        <span class="col-1"></span>
        <div class="col-10 d-flex mb-2">
          <div>
            <a class="admin-add-button font-18" href="${pageContext.request.contextPath}/admin/quiz/add?id=${param.id}">Add Question</a>
          </div>
          <div class="ml-auto">
            <a class="admin-back-button font-18" href="${pageContext.request.contextPath}/admin">Back</a>
          </div>
        </div>
        <span class="col-1"></span>
      </div>
      <div class="row m-0 mt-1">
        <span class="col-1"></span>
        <div class="col-10 line-bottom"></div>
        <span class="col-1"></span>
      </div>
    </div>
    <div class="pt-3 px-6">
      <table id="view-modified-table" class="display" style="width:100%">
        <thead>
        <tr>
          <th>Question ID</th>
          <th>Question</th>
          <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="question" items="${requestScope.quiz.questions}">
          <tr>
            <td><a href="${pageContext.request.contextPath}/admin/quiz/edit?id=${question.questionID}&quizId=${param.id}">${question.questionID}</a></td>
            <td>${question.questionString}</td>

            <td>
              <form action="${pageContext.request.contextPath}/admin/quiz" method="post">
                <input name="questionID" value="${question.questionID}" hidden>
                <input name="status" value="${question.status}" hidden>
                <input name="quizID" value="${param.id}" hidden>

                <c:choose>
                  <c:when test="${question.status == 1}">
                    <button type="submit" class="change-status-button active">
                      ACTIVE
                    </button>
                  </c:when>
                  <c:when test="${question.status == 2}">
                    <button type="submit" class="change-status-button suspend">
                      SUSPEND
                    </button>
                  </c:when>
                  <c:when test="${question.status == 0}">
                    <button type="submit" class="change-status-button disable" disabled>
                      DISABLE
                    </button>
                  </c:when>
                  <c:otherwise>
                    <button type="submit" class="change-status-button error" disabled>
                      ERROR
                    </button>
                  </c:otherwise>
                </c:choose>
              </form>
            </td>

          </tr>
        </c:forEach>
        </tbody>
      </table>

    </div>


  </div>
</div>