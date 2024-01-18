package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao pdao;
	
	@Override
	public List<Product> getAllProducts() {
		return pdao.findAll();
	}

	@Override
	public Product getById(int id) {
		Optional<Product> p = pdao.findById(id);
		if(p.isPresent()) {
			return p.get();
		}
		return null;
	}
	
	@Override
	public void addNewProduct(Product p) {
		pdao.save(p);
	}

	@Override
	public void updateProduct(Product p) {
		Optional<Product> op = pdao.findById(p.getId());
		if(op.isPresent()) {
			Product prod = op.get();
			prod.setId(p.getId());
			prod.setName(p.getName());
			prod.setQty(p.getQty());
			prod.setPrice(p.getPrice());
			pdao.save(prod);
		}
		
	}

	@Override
	public void deleteById(int id) {
		pdao.deleteById(id);
		
	}

}
