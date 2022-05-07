<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 22292
  Date: 2022/5/6
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo 3 - week 11</title>
</head>
<body>
<%
    //Array
    String[] first = {"Bill","Scott","Larry"};
    //List
    List<String> lastName = new ArrayList<String>();
    lastName.add("Ellison");
    lastName.add("Gates");
    lastName.add("McNealy");
    //Map
    Map<String,String> companyName = new HashMap<String,String>();
    companyName.put("Ellison","Sun");
    companyName.put("Gates","Oracle");
    companyName.put("McNealy","Microsoft");

    //set in any one scope
    request.setAttribute("first",first);
    request.setAttribute("last",lastName);
    request.setAttribute("company",companyName);
%>

<h2>Get date from Array -->List -->Map - using EL code</h2>
<ul>
    <li>${first[0]} --> ${last[0]} --> ${company["Ellison"]}</li>
    <li>${first[1]} --> ${last[1]} --> ${company["Gates"]}</li>
    <li>${first[2]} --> ${last[2]} --> ${company["McNealy"]}</li>
</ul>
</body>
</html>
