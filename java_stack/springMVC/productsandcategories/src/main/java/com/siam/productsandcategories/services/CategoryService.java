package com.siam.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siam.productsandcategories.models.Category;
import com.siam.productsandcategories.models.Product;
import com.siam.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
	
	// Retrieves a list of all categories for a particular product
	public List<Category> allCategoriesOfProduct(Product product){
		return categoryRepository.findAllByProducts(product);
	}
	
	 // Retrieves a list of any categories a particular product
    // does not belong to.
	public List<Category> allCategoriesNotBelongToThisProduct(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		else {
			return null;
		}
		
	}
		
	public Category updateCategory(Category category){
		return categoryRepository.save(category);
	}
		
	
	
	
	

}
