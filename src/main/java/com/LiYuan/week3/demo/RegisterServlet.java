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
        ServletContext context = getServletContext();
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
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String sql = "insert into usertable values(?,?,?,?,?,?)";
        String sql1 = "select * from usertable";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setString(2, "Li Yuan");
            ps.setString(3, "ly123456");
            ps.setString(4, "2229211937@qq.com");
            ps.setString(5, "male");
            ps.setDate(6, Date.valueOf("2001-08-02"));
            ps.executeUpdate();
            ps.close();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String gender = rs.getString("gender");
                Date birthdate = rs.getDate("birthdate");

                PrintWriter writer = response.getWriter();
                writer.println("<br> " + id + "  " + username + "  " + password + "  " + email + "  " + gender + "  " + birthdate);
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");
        PrintWriter writer = response.getWriter();

//        String sql1 = "select * from usertable";
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
//            ps.close();
            sql = "select * from usertable";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            writer.println("Registration information in the database!!!");
            writer.println("ID\t\tUsername\t\tPassword\t\tEmail\t\tGender\t\tBirthdate");
            while (rs.next()) {
                int ID = rs.getInt("id");
                String Username = rs.getString("username");
                String Password = rs.getString("password");
                String Email = rs.getString("email");
                String Gender = rs.getString("gender");
                Date Birthdate = rs.getDate("birthdate");

//                PrintWriter writer = response.getWriter();
                writer.println(ID + "\t\t" + Username + "\t\t" + Password + "\t\t" + Email + "\t\t" + Gender + "\t\t" + Birthdate);
            }
            ps.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        writer.println("\n\n\n");
        writer.println("Information of this registration!!!");
        writer.println("username:" + username);
        writer.println("password:" + password);
        writer.println("Email:" + email);
        writer.println("gender:" + gender);
        writer.println("birthDate:" + birthDate);
        writer.close();

    }
}
