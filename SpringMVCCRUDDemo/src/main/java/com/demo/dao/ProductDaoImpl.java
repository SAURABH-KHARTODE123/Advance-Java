package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Product> findProducts() {
		return jdbcTemplate.query("select * from product", (rs,num) -> {
			Product p = new Product();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setQty(rs.getInt(4));
			p.setPrice(rs.getDouble(3));
			return p;
		});
	}

	@Override
	public void insertProduct(Product p) {
		String query = "insert into product values(?,?,?,?)";
		jdbcTemplate.update(query,new Object[] {p.getId(),p.getName(),p.getPrice(),p.getQty()});
	}

	@Override
	public void updateById(Product p) {
		String query = "update product set name=?,price=?,qty=? where id=?";
		jdbcTemplate.update(query,new  Object[] {p.getName(),p.getPrice(),p.getQty(),p.getId()});
	}

	@Override
	public Product getById(int id) {
		String query = "select * from product where id=?";
		return jdbcTemplate.queryForObject(query,new Object[] {id},(rs,num) ->{
			return new Product(rs.getInt(1),rs.getString(2),rs.getInt(4),rs.getDouble(3));
		});
	}

	@Override
	public void deleteById(int id) {
		String query = "delete from product where id=?";
		jdbcTemplate.update(query,new Object[] {id});
	}

}
