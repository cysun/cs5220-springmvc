<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <title><tiles:insertAttribute name="title" defaultValue="Users" defaultValueType="string" /></title>
  <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
  <style>
    .content {
        margin: 2em;
    }
  </style>
</head>
<body>

<h2>User Management</h2>

<div class="content">
  <tiles:insertAttribute name="content" />
</div>

<security:authorize access="authenticated">
<p><a href="<c:url value='/logout' />">Logout</a></p>
</security:authorize>

<p>Copyright &copy; 2016, Chengyu Sun. All rights reserved.</p>

</body>
</html>
