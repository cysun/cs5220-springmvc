<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form modelAttribute="user">
Username: <form:input path="username" /> <form:errors path="username" /> <br />
Password: <form:input path="password" /> <form:errors path="password" /> <br />
Manager: <form:select path="manager" items="${users}" itemLabel="username" /> <br />
<input type="submit" name="add" value="Add" />
</form:form>
