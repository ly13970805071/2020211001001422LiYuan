<%--
  Created by IntelliJ IDEA.
  User: 22292
  Date: 2022/3/24
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1><%= "Login" %>
</h1>

<form method="post" action="login">
    username:<input type="text" name="username"/><br/>
    password:<input type="password" name="password"/><br/>
    <button type="submit">Login</button>
</form>
<%@include file="footer.jsp"%>
