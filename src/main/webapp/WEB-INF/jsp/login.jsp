<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Login</title>
</head>
<body>
<form action="<c:url value='/login' />" method="post">
Username: <input type="text" name="username" /> <br />
Password: <input type="password" name="password" /> <br />
<input type="submit" name="login" value="Login" />
</form>

<c:if test="${param.error != null}">
<p>Please try again.</p>
</c:if>
</body>
</html>
