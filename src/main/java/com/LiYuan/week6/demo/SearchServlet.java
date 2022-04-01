package com.LiYuan.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String search = request.getParameter("txt");
        if (search == null) {
            response.sendRedirect("index.jsp");
        } else if (search.equals("baidu")) {
            response.sendRedirect("https://www.baidu.com/s?wd=" + search);
        } else if (search.equals("bing")) {
            response.sendRedirect("https://cn.bing.com/search?q=" + search);
        } else if (search.equals("google")) {
            response.sendRedirect("https://www.google.com/search?q=" + search);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
