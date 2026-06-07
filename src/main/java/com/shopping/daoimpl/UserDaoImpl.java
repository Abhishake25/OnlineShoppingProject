package com.shopping.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.shopping.dao.UserDao;
import com.shopping.entity.User;
import com.shopping.exception.ShoppingException;
import com.shopping.util.DBUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public User validateUser(String username, String password) throws ShoppingException {
		
		User user = null;
		String sql = "select * from user_table where username=? and password=?";
		
		Connection con = DBUtil.getConnection();
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("Username"+username);
		System.out.println("password"+password);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			
			 while(rs.next()) {
				 user = new User();
				
				 user.setUserId(rs.getInt("userId"));
				 user.setUsername(rs.getString("username"));
				 user.setPassword(rs.getString("password"));
				 user.setName(rs.getString("name"));
				 user.setEmail(rs.getString("email"));
				 user.setCity(rs.getString("city"));
			 }
		} catch (Exception e) {
			
			throw new ShoppingException("Error while validating user",e);
		}
		
		return user;
		
	}

	
}
