package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.MyUser;
import com.demo.model.Product;
import com.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService pservice;
	
	@GetMapping("/getproducts")
	public ModelAndView getProducts(HttpSession session) {
		MyUser u = (MyUser)session.getAttribute("user");
		
		if(u!=null) {
			List<Product> plist = pservice.getAllProducts();
			return new ModelAndView("displayproduct","plist",plist);
		}
		return new ModelAndView("redirect:/login/");
	}
	
	@GetMapping("/insert")
	public String displayAddForm(HttpSession session) {
		MyUser user = (MyUser)session.getAttribute("user");
		if(user!=null) {
			return "addproduct";
		}
		return "redirect:/login/";
	}
	
	@PostMapping("/insertproduct")
	public ModelAndView insertProduct(@RequestParam("pid") int id,@RequestParam("pname") String name, @RequestParam int qty,@RequestParam double price) {
		Product p = new Product(id,name,qty,price);
		pservice.addNewProduct(p);
		return new ModelAndView("redirect:/product/getproducts");
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editProduct(HttpSession session,@PathVariable int id) {
		MyUser user = (MyUser)session.getAttribute("user");
		if(user != null) {
			Product p = pservice.getById(id);
			return new ModelAndView("editproduct","p",p);
		}
		return new ModelAndView("redirect:/login/");
	}
	
	@PostMapping("/updateproduct")
	public ModelAndView updateProduct(@RequestParam("pid") int id,@RequestParam("pname") String name, @RequestParam int qty,@RequestParam double price) {
		Product p = new Product(id,name,qty,price);
		pservice.updateProduct(p);
		return new ModelAndView("redirect:/product/getproducts");
	}
	
	
	@GetMapping("/delete/{id}")
	public ModelAndView deleteById(@PathVariable("id") int id,HttpSession session) {
		MyUser user = (MyUser)session.getAttribute("user");
		if(user != null) {
			pservice.deleteById(id);
			return new ModelAndView("redirect:/product/getproducts");
		}
		return new ModelAndView("redirect:/login/");
	}
	@GetMapping("/login/")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login/";
	}
}
