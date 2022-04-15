package com.LiYuan.Controller;

import com.LiYuan.Dao.UserDao;
import com.LiYuan.Model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        Date birthDate = Date.valueOf(request.getParameter("birthDate"));
        PrintWriter out = response.getWriter();

        User u = new User(id,username,password,email,gender,birthDate);
        try {
            UserDao ud = new UserDao();
            int changeline = ud.updateUser(con,u);
            System.out.println("受影响的行数：" + changeline + "行");

            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10);
            session.setAttribute("user", u);
            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
