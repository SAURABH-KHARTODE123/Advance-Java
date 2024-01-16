package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllProducts();

	boolean deleteById(int pid);

	boolean addNewProduct(Product p);

	Product getById(int pid);

	boolean updateProduct(Product p);

}
