<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<div class="admin-container m-auto d-flex">
  <div class="all-100">
    <div class="row m-0 mt-4">
      <span class="col-1"></span>
      <div class="col-10 d-flex">
        <h4 class="font-bold">Admin Page</h4>
      </div>
      <span class="col-1"></span>
    </div>

    <div class="row m-0 mt-1">
      <span class="col-1"></span>
      <div class="col-10 line-bottom"></div>
      <span class="col-1"></span>
    </div>

    <div class="row m-0 my-3 font-20">
      <span class="col-1"></span>
      <div class="col-10">
        <ul class="px-0 list-style-none text-decoration-under">
          <li class="mt-4"><a class="color-black" href="${pageContext.request.contextPath}/admin/submission">View Quiz</a></li>
          <li class="mt-4"><a class="color-black" href="${pageContext.request.contextPath}/admin/profile">View Profile</a></li>
          <li class="mt-4"><a class="color-black" href="${pageContext.request.contextPath}/admin/modified">Modified Quiz</a></li>
        </ul>
      </div>
      <span class="col-1"></span>
    </div>
  </div>
</div>