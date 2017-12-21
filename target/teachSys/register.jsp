<%--
  Created by IntelliJ IDEA.
  User: eric
  Date: 2017/12/7
  Time: 下午9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
注册界面
<form action="/register" method="post">
    userName:<input type="text" name="userName"/><br/>
    password:<input type="password" name="password"><br/>
    again password:<input type="password" name="againPassword"><br/>
    <input type="submit" value="login"/>
</form>
</body>
</html>
