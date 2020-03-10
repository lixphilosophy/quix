<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<div class="admin-container m-auto d-flex">
  <div class="all-100">
    <div>
      <div class="row m-0 mt-4">
        <span class="col-1"></span>
        <div class="col-10 d-flex mb-2">
          <h4 class="font-bold">Edit Question</h4>
          <div class="ml-auto">
            <a class="admin-back-button font-18" href="${pageContext.request.contextPath}/admin/quiz?id=${requestScope.quizId}">Back</a>
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

    <div class="pt-4">
      <div class="row m-0">
        <span class="col-1"></span>
        <div class="col-10">
          <form method="post">
            <input name="questionID" value="${requestScope.question.questionID}" hidden>
            <div class="d-flex">
              <label for="question-string" class="font-bold" style="width: 150px;">Question:</label>
              <input name="questionString" id="question-string" value="${requestScope.question.questionString}" class="flex add-question-input">
            </div>
            <div class="pt-4 d-flex">
              <label for="question-type" class="font-bold"  style="width: 150px;">Question Type:</label>
              <input name="questionType"
                     id="question-type"
                     readonly
                     style="background-color: #e7e7e7;"
                     value="${requestScope.question.questionType}"
                     class="flex add-question-input">
            </div>
            <div class="pt-4">
              <div class="font-bold" >Choices:</div>
              <c:forEach var="choice" items="${requestScope.question.choices}">
                <div class="pt-3 d-flex align-center">
                  <input name="questionChoices"
                         class="flex mr-3 add-question-input"
                         style="margin: 0;"
                         id="choices" value="${choice.choiceString}" required>
                  <c:choose>
                    <c:when test="${choice.ifCorrect == true}">
                      <input type="checkbox" name="correct" class="correct" style="width: 20px; height: 20px;" checked>
                    </c:when>
                    <c:otherwise>
                      <input type="checkbox" style="width: 20px; height: 20px;" class="correct" name="correct">
                    </c:otherwise>
                  </c:choose>
                  <script>
                    $('.correct').click(function(){
                      $(".correct").prop("checked", false);
                      $(this).prop("checked", true);
                    })
                  </script>
                </div>
              </c:forEach>
            </div>
            <div class="pt-4">
              <button type="submit" class="btn btn-primary">Update</button>
            </div>
          </form>
        </div>
        <span class="col-1"></span>
      </div>
    </div>
  </div>
</div>