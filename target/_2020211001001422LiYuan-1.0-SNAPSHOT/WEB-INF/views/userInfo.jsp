<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.LiYuan.Model.User" %><%--
  Created by IntelliJ IDEA.
  User: 22292
  Date: 2022/4/1
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<h1>User Info</h1>

<%
    Cookie[] allcookie = request.getCookies();
    for (Cookie c : allcookie) {
        out.println("<br/>" + c.getName() + " --- " + c.getValue());
    }
%>
<%
    User user = (User) session.getAttribute("user");
%>

<table border=1>
    <tr>
        <td>ID:</td>
        <td><%=user.getId()%>
        </td>
    </tr>
    <tr>
        <td>Username:</td>
        <td><%=user.getUsername()%>
        </td>
    </tr>
    <tr>
        <td>Password:</td>
        <td><%=user.getPassword()%>
        </td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><%=user.getEmail()%>
        </td>
    </tr>
    <tr>
        <td>Gender:</td>
        <td><%=user.getGender()%>
        </td>
    </tr>
    <tr>
        <td>Birthdate:</td>
        <td><%=user.getBirthdate()%>
        </td>
    </tr>

    <%--<%
        out.println("<tr>");
        out.println("<td>" + user.getId() + "</td>");
        out.println("<td>" + user.getUsername() + "</td>");
        out.println("<td>" + user.getPassword() + "</td>");
        out.println("<td>" + user.getEmail() + "</td>");
        out.println("<td>" + user.getGender() + "</td>");
        out.println("<td>" + user.getBirthdate() + "</td>");
        out.println("</tr>");
    %>--%>
</table>
<%@ include file="footer.jsp" %>
