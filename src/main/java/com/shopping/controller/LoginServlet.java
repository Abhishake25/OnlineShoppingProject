package com.shopping.controller;



import java.io.IOException;

import com.shopping.dao.DaoFactory;
import com.shopping.dao.UserDao;
import com.shopping.entity.User;
import com.shopping.exception.ShoppingException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserDao userDao;

    @Override
    public void init() throws ServletException {

        userDao = DaoFactory.getUserDao();
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

    	System.out.println("username:"+username);
		System.out.println("password"+password);
        try {

            User user =
                    userDao.validateUser(
                            username,
                            password);

            System.out.println("user object"+user);
            if (user!=null) {

            	HttpSession  session = request.getSession();
            	session.setAttribute("loggedUser", user);
            	
                response.sendRedirect("categories");
               

            } else {

                request.setAttribute(
                        "error",
                        "Invalid Username or Password");

                request.getRequestDispatcher("login.html")
                       .forward(request, response);
            }

        } catch (ShoppingException e) {

            throw new ServletException(e);
        }
    }
}