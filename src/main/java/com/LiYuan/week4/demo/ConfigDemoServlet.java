package com.LiYuan.week4.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfigDemoServlet",urlPatterns = {"/config"},
initParams = {
        @WebInitParam(name = "name",value = "Li Yuan"),
        @WebInitParam(name = "studentid",value = "2020211001001422")
}
)

public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletConfig config = getServletConfig();
        String name = config.getInitParameter("name");
        String studentid = config.getInitParameter("studentid");

        System.out.println("name : " + name);
        System.out.println("studentid : " + studentid);

        PrintWriter writer = response.getWriter();
        writer.println("<br> name : " + name);
        writer.println("<br> studentid : " + studentid);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
