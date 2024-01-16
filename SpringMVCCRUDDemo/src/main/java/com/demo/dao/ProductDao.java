package com.demo.dao;

import java.util.List;

import com.demo.model.Product;

public interface ProductDao {

	List<Product> findProducts();

	void insertProduct(Product p);

	void updateById(Product p);

	Product getById(int id);

	void deleteById(int id);

}
