<%--
  Created by IntelliJ IDEA.
  User: 22292
  Date: 2022/3/24
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<h1>Login</h1>
<%
    String message = (String) request.getAttribute("message");
    if (message != null) {
        out.println("<h3" + message + "</h3>");
    }
%>
<%
    Cookie[] allCookies = request.getCookies();
    String username = "", password = "", rememberMevalue = "";
    if (allCookies != null) {
        for (Cookie c : allCookies) {
            if (c.getName().equals("cUsername")) {
                username = c.getValue();
            }
            if (c.getName().equals("cPassword")) {
                password = c.getValue();
            }
            if (c.getName().equals("cRememberMe")) {
                rememberMevalue = c.getValue();
            }
        }
    }
%>
<form method="post" action="login">
    username:<input type="text" name="username" value="<%=username%>"/><br/>
    password:<input type="password" name="password" value="<%=password%>"/><br/>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMevalue.equals("1") ? "checked":""%>checked/>Remember
    Me<br/>
    <button type="submit">Login</button>
</form>
<%@include file="footer.jsp" %>
