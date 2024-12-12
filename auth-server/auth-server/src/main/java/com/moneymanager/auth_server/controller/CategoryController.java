package com.moneymanager.auth_server.controller;


import com.moneymanager.auth_server.entity.Category;
import com.moneymanager.auth_server.repository.CategoryRepository;
import com.moneymanager.auth_server.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;



@RestController
@RequestMapping("/api/cat")
public class CategoryController {
	private CategoryRepository categoryRepository;

	public CategoryController(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}


	@GetMapping("/categories")
	Collection<Category> categories(){
		return categoryRepository.findAll();
	}

	//category/2
	@GetMapping("/category/{id}")
	ResponseEntity<?> getCategory(@PathVariable Long id){
		Optional<Category> category = categoryRepository.findById(id);
		return category.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}



	@PostMapping("/category")
	ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) throws URISyntaxException{
		Category result= categoryRepository.save(category);
		return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);

	}


	@PutMapping("/category/{id}")
	ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category){
		Category result= categoryRepository.save(category);
		return ResponseEntity.ok().body(result);
	}



	@DeleteMapping("/category/{id}")
	ResponseEntity<?> deleteCategory(@PathVariable Long id){
		categoryRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}