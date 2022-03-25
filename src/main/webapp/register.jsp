<%--
  Created by IntelliJ IDEA.
  User: 22292
  Date: 2022/3/10
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="header.jsp" %>
This is my Register JSP page.<br><br>
<form method="post" action="register">
    ID:<input type="text" name="id"/><br/>
    username:<input type="text" name="username"/><br/>
    password:<input type="password" name="password"/><br/>
    Email:<input type="text" name="email"/><br/>
    Gender:<input type="radio" name="gender" value="male">Male<input type="radio" name="gender"
                                                                     value="female">Female<br/>
    Date of Birth:<input type="text" name="birthDate"><br/>
    <button type="submit">Register</button>
</form>
<%@include file="footer.jsp" %>

<%--
<html>
<head>
    <title></title>
</head>

<table width="600" border="1">
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
</table>
</html>
--%>
