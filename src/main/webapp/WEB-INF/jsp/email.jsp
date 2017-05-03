<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email</title>
<style>
input[type="text"] {width: 100%;}
</style>
</head>
<body>

<form:form modelAttribute="message">
<table>
<tr>
  <td>From:</td>
  <td><form:input path="from" /></td> 
</tr>
<tr>
  <td>To:</td>
  <td><form:input path="to" /></td> 
</tr>
<tr>
  <td>Subject:</td>
  <td><form:input path="subject" /></td> 
</tr>
<tr>
  <td colspan="2">
    <form:textarea path="text" rows="15" cols="80"></form:textarea>
  </td>
</tr>
<tr>
  <td colspan="2"><input type="submit" name="send" value="Send" /></td>
</tr>
</table>
</form:form>

</body>
</html>
