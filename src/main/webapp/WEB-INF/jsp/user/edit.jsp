<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form modelAttribute="user">
Username: ${user.username} <br />
Password: <form:input path="password" /> <form:errors path="password" /> <br />
Manager: <form:select path="manager" items="${users}" itemLabel="username" /> <br />
<input type="submit" name="save" value="Save" />
</form:form>
