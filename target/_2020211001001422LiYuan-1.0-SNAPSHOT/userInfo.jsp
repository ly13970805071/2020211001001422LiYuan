<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 22292
  Date: 2022/4/1
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<h1>User Info</h1>
<table border=1>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Birthdate</th>
    </tr>
    <%
        ResultSet rs = (ResultSet) request.getAttribute("rsname");
        Integer id = (Integer) request.getAttribute("id");
        String username = (String) request.getAttribute("username");
        String password = (String) request.getAttribute("password");
        String email = (String) request.getAttribute("email");
        String gender = (String) request.getAttribute("gender");
        Date birthdate = (Date) request.getAttribute("birthdate");
        if (rs == null) {
    %>
    <tr>
        <td>No Date!!!</td>
    </tr>
    <%
        } else {
            out.println("<tr>");
            out.println("<td>" + id + "</td>");
            out.println("<td>" + username + "</td>");
            out.println("<td>" + password + "</td>");
            out.println("<td>" + email + "</td>");
            out.println("<td>" + gender + "</td>");
            out.println("<td>" + birthdate + "</td>");
            out.println("</tr>");
        }
    %>
</table>
<%@ include file="footer.jsp" %>
