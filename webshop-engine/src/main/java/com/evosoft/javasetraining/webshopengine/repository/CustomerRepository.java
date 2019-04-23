package com.evosoft.javasetraining.webshopengine.repository;

import org.springframework.data.repository.CrudRepository;

import com.evosoft.javasetraining.webshopengine.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
