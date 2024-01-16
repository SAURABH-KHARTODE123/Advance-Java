package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {

	static Connection con;
	static PreparedStatement selprod,delprod,insprod,selById,upById;
	static {
		con = DBUtil.getMyConnection();
		try {
			selprod = con.prepareStatement("select * from product");
			delprod = con.prepareStatement("delete from product where id=?");
			insprod = con.prepareStatement("insert into product values(?,?,?,?)");
			selById = con.prepareStatement("select * from product where id = ?");
			upById = con.prepareStatement("update product set name=?,price=?,qty=? where id=?");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> plist = new ArrayList<>();
		try {
			ResultSet rs = selprod.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				int qty = rs.getInt(4);
				
				Product p = new Product(id,name,qty,price);
				plist.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plist;
	}

	@Override
	public boolean deleteProduct(int pid) {
		try {
			delprod.setInt(1, pid);
			int n = delprod.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertproduct(Product p) {
		try {
			insprod.setInt(1, p.getId());
			insprod.setString(2, p.getName());
			insprod.setDouble(3, p.getPrice());
			insprod.setInt(4,p.getQty());
			
			int n = insprod.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public Product getById(int pid) {
		try {
			selById.setInt(1, pid);
			
			ResultSet rs = selById.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1),rs.getString(2),rs.getInt(4),rs.getDouble(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateProduct(Product p) {
		try {
			upById.setString(1, p.getName());
			upById.setDouble(2, p.getPrice());
			upById.setInt(3, p.getQty());
			upById.setInt(4, p.getId());
			
			int n = upById.executeUpdate();
			if(n>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
