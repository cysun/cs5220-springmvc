<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>
<form:form modelAttribute="user">
Username: <form:input path="username" /> <br />
Password: <form:input path="password" /> <br />
Manager: <form:select path="manager" items="${users}" itemLabel="username" /> <br />
<input type="submit" name="add" value="Add" />
</form:form>
</body>
</html>
