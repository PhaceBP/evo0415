package com.evosoft.javasetraining.webshopengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.evosoft.javasetraining.webshopengine.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	

}
