<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email</title>
</head>
<body>

<form method="post">
<table>
<tr>
  <td>From:</td><td><input type="text" name="from" style="width: 100%;" /></td> 
</tr>
<tr>
  <td>To:</td><td><input type="text" name="to" style="width: 100%;" /></td> 
</tr>
<tr>
  <td>Subject:</td><td><input type="text" name="subject" style="width: 100%;" /></td> 
</tr>
<tr>
  <td colspan="2">
    <textarea name="content" rows="5" cols="60"></textarea>
  </td>
</tr>
<tr>
  <td colspan="2"><input type="submit" name="send" value="Send" /></td>
</tr>
</table>
</form>

</body>
</html>
