package com.proyecto.ecommerce.controller;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.ecommerce.model.Product;
import com.proyecto.ecommerce.model.User;
import com.proyecto.ecommerce.service.ProductService;
import com.proyecto.ecommerce.service.UploadFileService;


@Controller
@RequestMapping("/products")
public class ProductController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	@Autowired
	private UploadFileService uploadFile;
	
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("products",productService.findAll());
		return "products/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "products/create";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Product product, @RequestParam(name = "img", required = false) MultipartFile imageFile, RedirectAttributes redirectAttributes) throws IOException {
	    
	    LOGGER.info("Received product object: {}", product);
	    
	    if (product.getId()==null) {
	    	
	    	String nameImage = uploadFile.saveImage(imageFile);
		    product.setImage(nameImage); 
		    
	    }else {
	    	
	    	
	    }
	    
	    
	    User user = new User(1,"","","","","","","");
	    product.setUser(user);
	    productService.save(product);  
	    
	    return "redirect:/products";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		
		Product product = new Product();
		Optional<Product> optionalProduct = productService.get(id);
		product = optionalProduct.get();
		
		LOGGER.info("Product found: {}",product);
		model.addAttribute("product", product);
		return "products/edit";
	}
	
	@PostMapping("/update")
	public String update(Product product,  @RequestParam(name = "img", required = false) MultipartFile imageFile, RedirectAttributes redirectAttributes) throws IOException {
		
		Product p = new Product();
		p = productService.get(product.getId()).get();
		
			
		if(imageFile.isEmpty()) {
    		
			product.setImage(p.getImage());
    		
    	}else {
    		
    		if (!p.getImage().equals("defaul.jpg")) {
    			uploadFile.deleteImage(p.getImage());
    		}
    		String nameImage = uploadFile.saveImage(imageFile);
		    product.setImage(nameImage); 
    		
    	}
		product.setUser(p.getUser());
		productService.update(product);		
		return "redirect:/products";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		
		Product p = new Product();
		p = productService.get(id).get();
		
		if (!p.getImage().equals("defaul.jpg")) {
			uploadFile.deleteImage(p.getImage());
		}
		productService.delete(id);		
		return "redirect:/products";
	}

}
