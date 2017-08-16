<%--
  Created by IntelliJ IDEA.
  User: cjx
  Date: 2017/8/16
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功！</title>
</head>
<body>
    <h1>登录成功！</h1><hr>
    <h2>欢迎您！<%= request.getSession().getAttribute("user1")%></h2>
</body>
</html>
