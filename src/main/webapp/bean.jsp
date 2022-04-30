<%@ page import="com.LiYuan.week10.StringBean" %><%--
  Created by IntelliJ IDEA.
  User: 22292
  Date: 2022/4/30
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo#2 week 10</title>
</head>
<body>
<h1>use java code to access String bean class</h1>
<jsp:useBean id="bean" class="com.LiYuan.week10.StringBean"/>
<%
//    StringBean bean = new StringBean();
//    bean.setMessage("Hello Mr.bean");
%>
<jsp:setProperty name="bean" property="message" value='<%=request.getParameter("message")%>'/>
Message(using java code) : <%=bean.getMessage()%>

<h1>Use usebean to access StringBean class in jsp</h1>
Message(using getProperty) : <jsp:getProperty name="bean" property="message"/>
</body>
</html>
