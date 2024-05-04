package com.proyecto.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.ecommerce.model.DetailOrder;
import com.proyecto.ecommerce.model.Order;
import com.proyecto.ecommerce.model.Product;
import com.proyecto.ecommerce.service.ProductService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ProductService productService;
	
	//Save details of the order
	List<DetailOrder> details = new  ArrayList<DetailOrder>();
	
	//Dates of the order
	Order order = new Order();
	
	@GetMapping("")
	public String home(Model model) {
		
		model.addAttribute("products", productService.findAll());
		return "user/home";
		
	}
	
	@GetMapping("productHome/{id}")
	public String productHome(@PathVariable Integer id, Model model) {
		
		log.info("ID product sent like parameter {}",id);
		Product product = new Product();
		Optional<Product> productOptional = productService.get(id);
		product = productOptional.get();
		model.addAttribute("product", product);
		
		return "user/productHome";
		
	}
	
	@PostMapping("/cart")
	public String addCart(@RequestParam Integer id, @RequestParam Integer cuantity) {
		
		DetailOrder detailOrder = new DetailOrder();
		Product product = new Product();
		double valueTotal = 0;
		
		Optional<Product> optionalProduct = productService.get(id);
		
		log.info("Product added: {}",optionalProduct.get());
		log.info("Cuantity: {}",cuantity);
		
		return "user/shoppingCart";
	}
	
	

}
