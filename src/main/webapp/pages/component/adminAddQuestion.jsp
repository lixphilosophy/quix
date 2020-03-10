<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<div class="admin-container m-auto d-flex">
  <div class="all-100">
    <div>
      <div class="row m-0 mt-4">
        <span class="col-1"></span>
        <div class="col-10 d-flex mb-2">
          <h4 class="font-bold">Add Question</h4>
          <div class="ml-auto">
            <a class="admin-back-button font-18" href="${pageContext.request.contextPath}/admin/quiz?id=${requestScope.quiz.quizID}">Back</a>
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
          <form action="${pageContext.request.contextPath}/admin/quiz/add" method="post">
            <input name="quizID" value="${requestScope.quiz.quizID}" hidden>
            <div>
              <label for="question-string" style="width: 150px;">Question:</label>
              <input name="questionString" id="question-string" class="add-question-input">
            </div>
            <div class="pt-1">
              <label for="question-type" style="width: 150px;">Question Type:</label>
              <input name="questionType"
                     id="question-type"
                     value="mc"
                     readonly
                     style="background-color: #e7e7e7;"
                     class="add-question-input">
            </div>
            <div class="pt-1">
              <label for="choices" style="width: 150px;">Choices:</label>
              <input name="questionChoices" id="choices" required class="add-question-input">
            </div>
            <div class="pt-1">
              <label for="correctChoice" style="width: 150px;">Correct Choice:</label>
              <input name="correctChoice" id="correctChoice" required class="add-question-input">
            </div>
            <div class="pt-1">
              <button type="submit" class="btn btn-primary">Submit</button>
            </div>
          </form>
        </div>
        <span class="col-1"></span>
      </div>
    </div>
  </div>
</div>