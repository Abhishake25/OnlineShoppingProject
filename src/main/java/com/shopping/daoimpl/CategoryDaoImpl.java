package com.shopping.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.CategoryDao;
import com.shopping.entity.Category;
import com.shopping.exception.ShoppingException;
import com.shopping.util.DBUtil;

public class CategoryDaoImpl implements CategoryDao {

	
	@Override
	public List<Category> getAllCategories() {
		
		List<Category> categories = new ArrayList<>();
		
		try {
			Connection connection = DBUtil.getConnection();
			String sql = "Select * from category";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Category category = new Category();
				
				category.setCategoryId(rs.getInt("categoryId"));
				category.setCategoryName(rs.getString("categoryName"));
				category.setCategoryDescription(rs.getString("categoryDescription"));
				category.setCategoryImageUrl(rs.getString("categoryImageUrl"));
				
				categories.add(category);
			}
			
		} catch (ShoppingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}

}
