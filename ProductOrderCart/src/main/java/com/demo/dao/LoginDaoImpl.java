package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUser;

public class LoginDaoImpl implements LoginDao{

	static Connection con;
	static PreparedStatement seluser;
	static {
		con = DBUtil.getMyConnection();
		try {
			seluser = con.prepareStatement("select user_name,password,roles from my_user where user_name=? and password=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public MyUser checkUser(String user_name, String password) {
		try {
			seluser.setString(1, user_name);
			seluser.setString(2, password);
			ResultSet rs = seluser.executeQuery();
			if(rs.next()) {
				return new MyUser(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
