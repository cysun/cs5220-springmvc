<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>Users</title></head>
<body>
<table border="1">
<tr><th>ID</th><th>Username</th><th>Enabled</th><th>Operations</th></tr>
<c:forEach items="${users}" var="user">
<tr>
  <td>${user.id}</td>
  <td>${user.username}</td>
  <td>${user.enabled}</td>
  <td>
    <a href="view.html?id=${user.id}">View 1</a> |
    <a href="${user.id}.html">View 2</a> |
    <a href="edit.html?id=${user.id}">Edit</a>
  </td>
</tr>
</c:forEach>
</table>
</body>
</html>

<p><a href="add.html">Add User</a></p>
