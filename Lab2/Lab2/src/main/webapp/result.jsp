<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 13/10/2022
  Time: 04:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result Screen</title>
</head>
<body>
<h1>Welcome ${user.name}!</h1>
<h3>Your input: ${user.initialWord}</h3>
<h3>The output permutations:
<br> ${user.permutatedWords.toString()}
</h3>
</body>
</html>
