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

@WebServlet(name = "ShopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = new Category();
        List<Category> categoryList = null;
        categoryList = category.findAllCategory(con);
        request.setAttribute("categoryList", categoryList);

        ProductDao productDao = new ProductDao();
        List<Product> productList = null;
        try {
            if (request.getParameter("categoryId") == null) {
                productList = productDao.findAll(con);
            } else {
                int categoryId = Integer.parseInt(request.getParameter("categoryId"));
                productList = productDao.findByCategoryId(categoryId, con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("productList", productList);
        String path = "/WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
