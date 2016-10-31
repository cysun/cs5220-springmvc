<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>File Download</title>
</head>
<body>
<h2>Files</h2>
<ul>
  <c:forEach items="${names}" var="name">
  <li><a href="download.html?name=${name}">${name}</a>
  </c:forEach>
</ul>
</body>
</html>
