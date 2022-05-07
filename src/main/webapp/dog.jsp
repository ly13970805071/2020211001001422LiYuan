<%@ page import="com.LiYuan.week11.Person" %>
<%@ page import="com.LiYuan.week11.Dog" %><%--
  Created by IntelliJ IDEA.
  User: 22292
  Date: 2022/5/6
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo 2 - week 11</title>
</head>
<body>
<%
    Person person = new Person();
    person.setName("Tom");

    Dog dog = new Dog();
    dog.setName("Tommy");

    person.setDog(dog);
    request.setAttribute("personAtt",person);

%>
<h2>Get person' dog name - using java code</h2>
<%
    Person person1 = (Person) pageContext.findAttribute("personAtt");
    Dog dog1 = person1.getDog();
    out.println(person1.getName() + "s' Dog name is " + dog1.getName());
%>

<h2>Get person' dog name - using EL code</h2>
Persons' dog name : ${personAtt.dog.name}

</body>
</html>
