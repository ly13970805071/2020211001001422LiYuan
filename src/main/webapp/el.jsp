<%--
  Created by IntelliJ IDEA.
  User: 22292
  Date: 2022/5/6
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo 1 - week 11</title>
</head>
<body>
<%
    pageContext.setAttribute("attName","att in page");
    request.setAttribute("attName","att in request");
    session.setAttribute("attName","att in session");
    application.setAttribute("attName","att in application");
%>

<h2>Get 4 scope variable - using java code</h2>
att value : <%=pageContext.getAttribute("attName",PageContext.PAGE_SCOPE)%><br>
att value : <%=pageContext.getAttribute("attName",PageContext.REQUEST_SCOPE)%><br>
att value : <%=pageContext.getAttribute("attName",PageContext.SESSION_SCOPE)%><br>
att value : <%=pageContext.getAttribute("attName",PageContext.APPLICATION_SCOPE)%><br>

Find att : <%=pageContext.findAttribute("attName")%>

<h2>Get 4 scope variable - using EL code</h2>
att value : ${attName}<!-- ==findAttribute("attName") -->

<h2>Not find - get Attribute from any one scope - using EL code</h2>
att value : ${pageScope.attName}<br>
att value : ${requestScope.attName}<br>
att value : ${sessionScope.attName}<br>
att value : ${applicationScope.attName}<br>

</body>
</html>
