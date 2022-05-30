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
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

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

        User user = new User(id,username,password,email,gender,birthDate);
        UserDao userDao = new UserDao();
        try {
            int n = userDao.updateUser(con,user);
            User updatedUser = userDao.findById(con,id);
            System.out.println("受影响的行数：" + n + "行");

            HttpSession session = request.getSession();
            session.removeAttribute("user");
            session.setAttribute("user", updatedUser);
            request.getRequestDispatcher("accountDetails").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
