package com.shopping.dao;

import com.shopping.exception.ShoppingException;

public interface UserDao {

	 boolean validateUser(String username,String password) throws ShoppingException;
}
