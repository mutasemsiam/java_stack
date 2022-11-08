package com.siam.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.siam.productsandcategories.models.Category;
import com.siam.productsandcategories.models.Product;
import com.siam.productsandcategories.services.CategoryService;
import com.siam.productsandcategories.services.ProductService;

@Controller
public class MainController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("products", productService.allProducts() );
		model.addAttribute("categories", categoryService.allCategories());
		
		return "main.jsp";
	}
	
	@GetMapping("/products/new")
	public String addProduct(@ModelAttribute("product") Product product) {
		return "add_product.jsp";
	}
	
	@GetMapping("/categories/new")
	public String addCategory(@ModelAttribute("category") Category cat) {
		return "add_category.jsp";
	}
	
	@PostMapping("/products/new")
	public String addNewProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		  if (result.hasErrors()) {
	            return "add_product.jsp";
	        } else {
	            productService.createProduct(product);
	            return "redirect:/";
	        }
	}
	
	@PostMapping("/categories/new")
	public String addNewCategory(@Valid @ModelAttribute("category") Category cat, BindingResult result) {
		  if (result.hasErrors()) {
	            return "add_category.jsp";
	        } else {
	            categoryService.createCategory(cat);
	            return "redirect:/";
	        }
	}
	
	@GetMapping("products/{id}")
	public String showOneProduct(@PathVariable("id") Long id, Model model){
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("catgs", categoryService.allCategoriesOfProduct(product));
		model.addAttribute("allRemainingCatgs", categoryService.allCategoriesNotBelongToThisProduct(product));
		
		return "one_product.jsp";
	}
	
	@PostMapping("products/{productId}")
	public String addCategoryForAProduct(@PathVariable("productId") Long productId,
			@RequestParam(value="categoryId") Long catId)
			 {
		
	    Product thisProduct = productService.findProduct(productId);
		Category thisCategory = categoryService.findCategory(catId);
	  
	    // add the product to this category's list of products
	    thisCategory.getProducts().add(thisProduct);
	    
	    // Save thisCategory, since you made changes to its product list.
	    categoryService.updateCategory(thisCategory);

	    
	    return "redirect:/products/" + productId;
	}
	
	@GetMapping("categories/{id}")
	public String showOneCat(@PathVariable("id") Long id, Model model){
		Category category = categoryService.findCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("productsOfThisCat", productService.allProductsOfCat(category));
		model.addAttribute("allRemainingProducts", productService.allProductsNotBelongToThisCategory(category));
		
		return "one_category.jsp";
	}
	
	@PostMapping("categories/{catId}")
	public String addProductToCat(@PathVariable("catId") Long catId,
			@RequestParam(value="myProductId") Long ProdId) {
		Category category = categoryService.findCategory(catId);
		Product product = productService.findProduct(ProdId);
		
	    category.getProducts().add(product);
	    categoryService.updateCategory(category);
		
	    
	    //Or we can make it as this (instead of the last two lines above):
//	    product.getCategories().add(category);
//	    productService.updateProduct(product);
		
		return "redirect:/categories/" + catId;
		
		
	}
}
