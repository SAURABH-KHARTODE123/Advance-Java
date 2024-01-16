package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao pdao;

	
	public List<Product> getAllProducts() {
		return pdao.findProducts();
	}


	@Override
	public void addNewProduct(Product p) {
		pdao.insertProduct(p);
		
	}


	@Override
	public void updateProduct(Product p) {
		pdao.updateById(p);
		
	}


	@Override
	public Product getById(int id) {
		return pdao.getById(id);
	}


	@Override
	public void deleteById(int id) {
		pdao.deleteById(id);
	}

}
