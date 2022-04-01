package com.LiYuan.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = {"/register"})

public class RegisterServlet extends HttpServlet {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Statement stmt = null;
    String sql = "";

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
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");
        PrintWriter out = response.getWriter();

        try {
            sql = "insert into usertable values(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, email);
            ps.setString(5, gender);
            ps.setDate(6, Date.valueOf(birthDate));
            ps.executeUpdate();

            /*sql = "select * from usertable";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            out.println("Registration information in the database!!!");*/
//            out.println("ID\t\tUsername\t\tPassword\t\tEmail\t\tGender\t\tBirthdate");
            /*out.println("<html><head><title></title></head><table border=1><tr>");
            out.println("<th>ID</th><th>Username</th><th>Password</th><th>Email</th><th>Gender</th><th>Birthdate</th></tr>");
            while (rs.next()) {
                *//*int ID = rs.getInt("id");
                String Username = rs.getString("username");
                String Password = rs.getString("password");
                String Email = rs.getString("email");
                String Gender = rs.getString("gender");
                Date Birthdate = rs.getDate("birthdate");*//*

//                PrintWriter writer = response.getWriter();
//                out.println(ID + "\t\t" + Username + "\t\t" + Password + "\t\t" + Email + "\t\t" + Gender + "\t\t" + Birthdate);
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("username") + "</td>");
                out.println("<td>" + rs.getString("password") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("gender") + "</td>");
                out.println("<td>" + rs.getDate("birthdate") + "</td>");
                out.println("</tr>");

            }
            out.println("</table></body></html>");*/

            /*request.setAttribute("rsname",rs);
            request.getRequestDispatcher("userList.jsp").forward(request,response);
            System.out.println("I am in Register -->doPost() --> after forward()");
            ps.close();
            stmt.close();
            con.close();*/
            response.sendRedirect("login.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*writer.println("\n\n\n");
        writer.println("Information of this registration!!!");
        writer.println("username:" + username);
        writer.println("password:" + password);
        writer.println("Email:" + email);
        writer.println("gender:" + gender);
        writer.println("birthDate:" + birthDate);
        writer.close();*/

    }
}
