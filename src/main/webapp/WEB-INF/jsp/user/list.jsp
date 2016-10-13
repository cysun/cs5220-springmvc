<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head><title>Users</title></head>
<body>
<p>Hello, <security:authentication property="principal.username" />!</p>
<table border="1">
<tr><th>ID</th><th>Username</th><th>Enabled</th><th>Operations</th></tr>
<c:forEach items="${users}" var="user">
<tr>
  <td>${user.id}</td>
  <td>${user.username}</td>
  <td>${user.enabled}</td>
  <td>
    <security:authorize access="hasRole('ADMIN') or principal.username == '${user.username}'">
      <a href="view.html?id=${user.id}">View 1</a> |
      <a href="${user.id}.html">View 2</a> |
      <a href="edit.html?id=${user.id}">Edit</a>
    </security:authorize>
  </td>
</tr>
</c:forEach>
</table>

<security:authorize access="hasRole('ADMIN')">
<p><a href="add.html">Add User</a></p>
</security:authorize>

<p><a href="<c:url value='/logout' />">Logout</a>
</body>
</html>
