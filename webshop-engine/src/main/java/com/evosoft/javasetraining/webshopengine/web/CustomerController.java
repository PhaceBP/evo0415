package com.evosoft.javasetraining.webshopengine.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evosoft.javasetraining.webshopengine.model.Customer;
import com.evosoft.javasetraining.webshopengine.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepo;

	@GetMapping(path = { "/customers" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Iterable<Customer> getProductsAsJSON() {

		return customerRepo.findAll();
	}

	@GetMapping(path = { "/customers" }, produces = MediaType.APPLICATION_XML_VALUE)
	public Iterable<Customer> getProductsAsXML() {

		return customerRepo.findAll();
	}
}
