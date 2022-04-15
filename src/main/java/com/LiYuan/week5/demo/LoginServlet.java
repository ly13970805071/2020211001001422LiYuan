package com.LiYuan.week5.demo;

import com.LiYuan.Dao.UserDao;
import com.LiYuan.Model.User;

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

        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();

        try {
            UserDao userDao = new UserDao();
            User user = userDao.findByUsernamePassword(con, username, password);
            if (user != null) {
                /*out.println("<br> Login Success!!!");
                out.println("<br> Welcome " + user.getUsername());*/

                Cookie c = new Cookie("sessionid", "" + user.getId());
                c.setMaxAge(10 * 60);
                response.addCookie(c);

                String rememberMe = request.getParameter("rememberMe");
                if (rememberMe != null && rememberMe.equals("1")) {
                    Cookie usernameCookie = new Cookie("cUsername", user.getUsername());
                    Cookie passwordCookie = new Cookie("cPassword", user.getPassword());
                    Cookie rememberMeCookie = new Cookie("cRememberMe", rememberMe);

                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);

                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }

                HttpSession session = request.getSession();
                System.out.println("session id -->" + session.getId());
                session.setMaxInactiveInterval(10);


                session.setAttribute("user", user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
            } else {
//                out.println("<br> Username or password is Error!!!");
                request.setAttribute("message", "Username or Password is Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }
//            ps.close();
//            stmt.close();
//            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
