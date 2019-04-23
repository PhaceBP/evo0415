package com.evosoft.javasetraining.webshopengine.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evosoft.javasetraining.webshopengine.model.Product;
import com.evosoft.javasetraining.webshopengine.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository prodRepo;

	@GetMapping(path = {"/products"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Iterable<Product> getProducts() {

		return prodRepo.findAll();
	}
}
