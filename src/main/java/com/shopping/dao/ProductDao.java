package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Product;
import com.shopping.exception.ShoppingException;

public interface ProductDao {

	List<Product> getProductsBCategroy(int categoryId) throws ShoppingException;
}
