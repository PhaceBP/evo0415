package com.evosoft.javasetraining.webshopengine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.evosoft.javasetraining.webshopengine.model.Discount;
import com.evosoft.javasetraining.webshopengine.model.MegapackDiscount;
import com.evosoft.javasetraining.webshopengine.model.Product;
import com.evosoft.javasetraining.webshopengine.model.ProductCategory;
import com.evosoft.javasetraining.webshopengine.repository.DiscountRepository;
import com.evosoft.javasetraining.webshopengine.repository.ProductCategoryRepository;

@SpringBootApplication
@ComponentScan(basePackages = { "com.evosoft.javasetraining.webshopengine" })
public class WebshopEngineApplication implements CommandLineRunner {

	@Autowired
	private ProductCategoryRepository catRepo;
	
	@Autowired
	private DiscountRepository discRepo;

	public static void main(String[] args) {
		SpringApplication.run(WebshopEngineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Discount d = new MegapackDiscount();
		
		discRepo.save(d);
		
		ProductCategory c = new ProductCategory();
		c.setCategoryName("megapack");
		c.setDiscount(d);

		Product p1 = new Product();
		p1.setName("wc paper");
		p1.setPrice(3000.0d);
		Product p2 = new Product();
		p2.setName("wc paper2");
		p2.setPrice(3100.0d);
		c.addProduct(p1);
		c.addProduct(p2);

		catRepo.save(c);

	}

}
