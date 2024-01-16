package com.demo.service;

import java.util.List;

import com.demo.model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	void addNewProduct(Product p);

	void updateProduct(Product p);

	Product getById(int id);

	void deleteById(int id);

}
