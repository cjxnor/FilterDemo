<%--
  Created by IntelliJ IDEA.
  User: cjx
  Date: 2017/8/15
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户登录</title>
  </head>
  <body>
      <h1>用户登录</h1><hr>
      <form name="loginform" action="servlet/LoginServlet" method="post">
      <table>
        <tr>
          <td>用户名：</td>
          <td><input type="text" name="username"></td>
        </tr>
        <tr>
          <td>密码：</td>
          <td><input type="password" name="password"></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
      </table>
      </form>

  </body>
</html>
