<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="word-servlet" method="get">
<label>Word:
    <input name="word" type="text">
</label>
<label>Size:
    <input name="number" type="text">
</label>
<label>
    <input type="submit" value="Send">
</label>
</form>

<a href="hello-servlet">Hello Servlet</a>
</body>
</html>