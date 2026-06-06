package com.shopping.controller;

import java.io.IOException;
import java.util.List;

import com.shopping.dao.ProductDao;
import com.shopping.daoimpl.ProductDaoImpl;
import com.shopping.entity.Product;
import com.shopping.exception.ShoppingException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/products")
public class ProductServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		try {
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			System.out.println(categoryId);
			ProductDao productDao = new ProductDaoImpl();
			
			List<Product> products =  productDao.getProductsBCategroy(categoryId);
			
			request.setAttribute("products", products);
			
			request.getRequestDispatcher("products.jsp")
			.forward(request, response);
		} catch(ShoppingException e) {
			throw new ServletException(e);
		}
	}

}
