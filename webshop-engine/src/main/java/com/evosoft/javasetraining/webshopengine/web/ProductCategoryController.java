package com.evosoft.javasetraining.webshopengine.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evosoft.javasetraining.webshopengine.model.Product;
import com.evosoft.javasetraining.webshopengine.model.ProductCategory;
import com.evosoft.javasetraining.webshopengine.repository.ProductCategoryRepository;
import com.evosoft.javasetraining.webshopengine.repository.ProductRepository;

@RestController
public class ProductCategoryController {

	@Autowired
	private ProductCategoryRepository prodCatRepo;

	@GetMapping(path = {"/productcategories"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Iterable<ProductCategory> getProductCategoriesAsJSON() {

		return prodCatRepo.findAll();
	}
	

	@GetMapping(path = {"/productcategories"}, produces = MediaType.APPLICATION_XML_VALUE)
	public Iterable<ProductCategory> getProductCategoriesAsXML() {

		return prodCatRepo.findAll();
	}
}
