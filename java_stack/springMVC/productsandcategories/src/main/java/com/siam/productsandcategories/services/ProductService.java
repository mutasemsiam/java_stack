package com.siam.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siam.productsandcategories.models.Category;
import com.siam.productsandcategories.models.Product;
import com.siam.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else {
			return null;
		}
	}
	
	// Retrieves a list of all products for a particular category
	public List<Product> allProductsOfCat(Category category){
		return productRepository.findAllByCategories(category);
	}
	
	// Retrieves a list of any products that don't belong to a particular
    // category.
	public List<Product> allProductsNotBelongToThisCategory(Category category){
		return productRepository.findByCategoriesNotContains(category);
	}
	
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
}
