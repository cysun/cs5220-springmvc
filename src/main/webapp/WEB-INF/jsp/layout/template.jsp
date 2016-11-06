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

<tiles:insertAttribute name="header" defaultValue="header.jsp" defaultValueType="template" />

<div class="content">
  <tiles:insertAttribute name="content" />
</div>

<tiles:insertAttribute name="footer" defaultValue="footer.jsp" defaultValueType="template"/>

</body>
</html>
