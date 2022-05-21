package com.LiYuan.Controller;

import com.LiYuan.Dao.ProductDao;
import com.LiYuan.Model.Category;
import com.LiYuan.Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductDetailsServlet", value = "/productDetails")
public class ProductDetailsServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
        ProductDao productDao = new ProductDao();
        if (id == 0) {
            return;
        }
        List<Category> categoryList = Category.findAllCategory(con);
        request.setAttribute("categoryList", categoryList);

        Product product = null;
        try {
            product = productDao.findById(id, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("p", product);
        String path = "/WEB-INF/views/productDetails.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
