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


@Controller
@RequestMapping("/products")
public class ProductController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
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
	public String save(@ModelAttribute Product product, @RequestParam(name = "image", required = false) MultipartFile imageFile, RedirectAttributes redirectAttributes) {
	    
	    LOGGER.info("Received product object: {}", product);
	    
	    if (imageFile != null && !imageFile.isEmpty()) {
	        try {
	            
	            String contentType = imageFile.getContentType();
	            if (contentType != null && (contentType.equals("image/jpeg") || contentType.equals("image/png"))) {
	                byte[] bytes = imageFile.getBytes();
	                
	                product.setImage(bytes);
	            } else {
	                redirectAttributes.addFlashAttribute("error", "Por favor, sube una imagen JPEG o PNG.");
	                return "redirect:/products";
	            }
	        } catch (IOException e) {
	            LOGGER.error("Error handling image file", e);
	            redirectAttributes.addFlashAttribute("error", "Error al procesar la imagen.");
	            return "redirect:/products";
	        }
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
	public String update(Product product) {		
		productService.update(product);		
		return "redirect:/products";
	}

}
