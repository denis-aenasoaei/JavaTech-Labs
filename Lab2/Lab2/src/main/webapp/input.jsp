<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Input</title>
</head>
<body>
<h1><%= "INPUT JSP FILE" %>
</h1>
<br/>
<form action="result" method="get">
  <label>Word:
    <input name="word" type="text">
  </label>
  <label>Size:
    <input name="number" type="text">
  </label>
  <label>Enter your name :):
    <input name="username" type="text">
  </label>
  <label>
    <input type="submit" value="Send">
  </label>
</form>

</body>
</html>