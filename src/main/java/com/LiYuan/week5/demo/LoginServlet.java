package com.LiYuan.week5.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public void init() throws ServletException {
        super.init();
        /*ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection --> in JDBCDemoServlet " + con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sql = "select * from usertable where username=? and password=?";
        PrintWriter out = response.getWriter();

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
//            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery(sql);
            if (rs.next()) {
                /*out.println("<br> Login Success!!!");
                out.println("<br> Welcome " + user.getUsername());*/

                request.setAttribute("id", rs.getInt("id"));
                request.setAttribute("username", rs.getString("username"));
                request.setAttribute("password", rs.getString("password"));
                request.setAttribute("email", rs.getString("email"));
                request.setAttribute("gender", rs.getString("gender"));
                request.setAttribute("birthdate", rs.getDate("birthdate"));
                request.setAttribute("rsname",rs);

                request.getRequestDispatcher("userInfo.jsp").forward(request, response);
            } else {
//                out.println("<br> Username or password is Error!!!");
                request.setAttribute("message", "Username or password is Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            ps.close();
//            stmt.close();
//            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
