<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 22292
  Date: 2022/3/30
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<h1>User List</h1>
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
        if (rs == null) {
    %>
    <tr>
        <td>No Date!!!</td>
    </tr>
    <%
        } else {
            while (rs.next()) {
                /*int ID = rs.getInt("id");
                String Username = rs.getString("username");
                String Password = rs.getString("password");
                String Email = rs.getString("email");
                String Gender = rs.getString("gender");
                Date Birthdate = rs.getDate("birthdate");*/

//                PrintWriter writer = response.getWriter();
//                writer.println(ID + "\t\t" + Username + "\t\t" + Password + "\t\t" + Email + "\t\t" + Gender + "\t\t" + Birthdate);

                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("username") + "</td>");
                out.println("<td>" + rs.getString("password") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("gender") + "</td>");
                out.println("<td>" + rs.getDate("birthdate") + "</td>");
                out.println("</tr>");
            }
        }
    %>
</table>

<%@ include file="footer.jsp" %>