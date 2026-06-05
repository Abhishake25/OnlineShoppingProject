package com.shopping.controller;



import java.io.IOException;
import java.util.List;

import com.shopping.dao.CategoryDao;
import com.shopping.daoimpl.CategoryDaoImpl;
import com.shopping.entity.Category;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private CategoryDao categoryDao;

    @Override
    public void init() {
        categoryDao = new CategoryDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {

            List<Category> categories =
                    categoryDao.getAllCategories();

            request.setAttribute("categories", categories);

            RequestDispatcher rd =
                    request.getRequestDispatcher("categories.jsp");

            rd.forward(request, response);

        } catch (Exception e) {

            throw new ServletException(e);
        }
    }
}