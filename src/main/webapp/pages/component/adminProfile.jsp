<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<div class="admin-container m-auto d-flex">
  <div class="all-100">
    <jsp:include page="adminNav.jsp" />
    <div class="pt-3 px-6">
      <table id="view-profile-table" class="display" style="width:100%">
        <thead>
        <tr>
          <th>User ID</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Address</th>
          <th>Phone NUmber</th>
          <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${requestScope.users}">
          <tr>
            <td>${user.userId}</td>
            <td><span style="text-transform: capitalize">${fn:toLowerCase(user.firstName)}</span></td>
            <td><span style="text-transform: capitalize">${fn:toLowerCase(user.lastName)}</span></td>
            <c:choose>
              <c:when test="${user.address == null}">
                <td><i style="color: #CCCCCC;">undefined</i></td>
              </c:when>
              <c:otherwise>
                <td>${user.address}</td>
              </c:otherwise>
            </c:choose>
            <c:choose>
              <c:when test="${user.phone == null}">
                <td><i style="color: #B9B9B9;">undefined</i></td>
              </c:when>
              <c:otherwise>
                <td>${user.phone}</td>
              </c:otherwise>
            </c:choose>

            <td>
              <form action="${pageContext.request.contextPath}/admin/profile" method="post">
                <input name="userId" value="${user.userId}" hidden>
                <input name="status" value="${user.userStatus}" hidden>

                <c:choose>
                  <c:when test="${user.userStatus == 1}">
                    <button type="submit" class="change-status-button active">
                      ACTIVE
                    </button>
                  </c:when>
                  <c:when test="${user.userStatus == 2}">
                    <button type="submit" class="change-status-button suspend">
                      SUSPEND
                    </button>
                  </c:when>
                  <c:when test="${user.userStatus == 0}">
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