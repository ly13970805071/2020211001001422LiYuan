package com.LiYuan.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private int category;
    private String categoryName;
    private String description;
    private boolean active;

    public Category() {
    }

    public Category(int category, String categoryName, String description, boolean active) {
        this.category = category;
        this.categoryName = categoryName;
        this.description = description;
        this.active = active;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category=" + category +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }

    public static List<Category> findAllCategory(Connection con) throws SQLException {
        String sql = "select * from Category";
        List<Category> list = new ArrayList<Category>();
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Category c = new Category();
            c.setCategory(rs.getInt("categoryId"));
            c.setCategoryName(rs.getString("categoryName"));
            c.setDescription(rs.getString("description"));
            list.add(c);
        }
        return list;
    }

    public static String findByCategoryId(Connection con,int categoryId) throws SQLException {
        String sql = "select * from Category where categoryId=?";
        String categoryName = null;
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1,categoryId);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            categoryName = rs.getString("categoryName");
        }
        return categoryName;
    }
}
