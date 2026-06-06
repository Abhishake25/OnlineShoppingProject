package com.shopping.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.ProductDao;
import com.shopping.entity.Product;
import com.shopping.exception.ShoppingException;
import com.shopping.util.DBUtil;

public class ProductDaoImpl implements ProductDao{

	@Override
	public List<Product> getProductsBCategroy(int categoryId) throws ShoppingException {
	
		List<Product> products = new ArrayList<>();
		
		Connection connection = DBUtil.getConnection();
		
		String sql = "select * from products where categoryId=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();
				
				product.setCategoryId(rs.getInt("categoryId"));
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setPrice(rs.getString("price"));
				product.setProductImageUrl(rs.getString("productImageUrl"));
				
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}

	
}
