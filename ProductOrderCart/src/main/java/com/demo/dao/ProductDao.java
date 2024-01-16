package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> getAllProducts();

	boolean deleteProduct(int pid);

	boolean insertproduct(Product p);

	Product getById(int pid);

	boolean updateProduct(Product p);

}
