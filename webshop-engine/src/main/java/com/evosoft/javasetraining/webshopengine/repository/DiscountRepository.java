package com.evosoft.javasetraining.webshopengine.repository;

import org.springframework.data.repository.CrudRepository;

import com.evosoft.javasetraining.webshopengine.model.Customer;
import com.evosoft.javasetraining.webshopengine.model.Discount;

public interface DiscountRepository extends CrudRepository<Discount, Long>{

}
