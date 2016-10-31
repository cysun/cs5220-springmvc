<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User</title>
</head>
<body>
<form:form modelAttribute="user">
Username: ${user.username} <br />
Password: <form:input path="password" /> <br />
Manager: <form:select path="manager" items="${users}" itemLabel="username" /> <br />
<input type="submit" name="save" value="Save" />
</form:form>
</body>
</html>
