package com.shopping.dao;

import com.shopping.entity.User;
import com.shopping.exception.ShoppingException;

public interface UserDao {

	 public User validateUser(String username,String password) throws ShoppingException;
}
