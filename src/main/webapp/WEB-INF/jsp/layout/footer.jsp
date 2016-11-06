<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<security:authorize access="authenticated">
<p><a href="<c:url value='/logout' />">Logout</a></p>
</security:authorize>

<p>Copyright &copy; 2016, Chengyu Sun. All rights reserved.</p>
