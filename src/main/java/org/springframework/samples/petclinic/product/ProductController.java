package org.springframework.samples.petclinic.product;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
	
	private static final String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";

	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/product/create")
	public String initCreationForm(Map<String, Object> model) {
		Product product = new Product();
		model.put("product", product);
		model.put("productTypes", productService.getAllProductTypes());
		return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/product/create")
	public String processCreationForm(@Valid Product product, BindingResult result, ModelMap modelMap) {		
		if (result.hasErrors()) {
			modelMap.addAttribute("product", product);
			modelMap.addAttribute("productTypes", productService.getAllProductTypes());
			return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
		}
		else {
			//creating product
			this.productService.save(product);
			modelMap.addAttribute("message", "Product successfully saved!");
		}
		return "welcome";
	}
    
}
