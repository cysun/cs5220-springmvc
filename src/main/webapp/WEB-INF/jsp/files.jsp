<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Files</title>
</head>
<body>
<h2>Files</h2>

<form action="upload.html" method="post" enctype="multipart/form-data">
File: <input type="file" name="file" />
<input type="submit" name="upload" value="Upload" />
</form>

<c:if test="${fn:length(files) > 0}">
<ul>
  <c:forEach items="${files}" var="file">
  <li><a href="download.html?name=${file.name}">${file.name}</a>
  </c:forEach>
</ul>
</c:if>

</body>
</html>
