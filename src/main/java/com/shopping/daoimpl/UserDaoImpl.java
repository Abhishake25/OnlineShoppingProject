package com.shopping.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.shopping.dao.UserDao;
import com.shopping.exception.ShoppingException;
import com.shopping.util.DBUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean validateUser(String username, String password) throws ShoppingException {
		
		String sql = "select * from user_table where username=? and password=?";
		
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			return rs.next();
		} catch (Exception e) {
			
			throw new ShoppingException("Error while validating user",e);
		}
		
	}

	
}
