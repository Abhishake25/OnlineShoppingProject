package com.shopping.controller;



import java.io.IOException;

import com.shopping.dao.UserDao;
import com.shopping.daoimpl.UserDaoImpl;
import com.shopping.exception.ShoppingException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserDao userDao;

    @Override
    public void init() throws ServletException {

        userDao = new UserDaoImpl();
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        try {

            boolean status =
                    userDao.validateUser(
                            username,
                            password);

            if (status) {

                response.sendRedirect("categories");

            } else {

                request.setAttribute(
                        "error",
                        "Invalid Username or Password");

                request.getRequestDispatcher("login.jsp")
                       .forward(request, response);
            }

        } catch (ShoppingException e) {

            throw new ServletException(e);
        }
    }
}