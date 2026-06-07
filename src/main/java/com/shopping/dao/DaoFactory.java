package com.shopping.dao;

import com.shopping.daoimpl.CategoryDaoImpl;
import com.shopping.daoimpl.ProductDaoImpl;
import com.shopping.daoimpl.UserDaoImpl;

//This is the factory pattern
public class DaoFactory {

	public static UserDao getUserDao(){
		return new UserDaoImpl();
	}
	
	public static CategoryDao getCategoryDao(){
		return new CategoryDaoImpl();
	}
	
	public static ProductDao getProductDao(){
		return new ProductDaoImpl();
	}
}
