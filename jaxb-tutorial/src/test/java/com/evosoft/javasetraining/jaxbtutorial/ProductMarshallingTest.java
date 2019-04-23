package com.evosoft.javasetraining.jaxbtutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Before;
import org.junit.Test;

public class ProductMarshallingTest {

	private Product product;

	@Before
	public void setUp() {
		product = new Product();
		product.setDescription("testdesc");
		product.setPrice(new BigDecimal(1200));
		product.setProductId(Long.valueOf(100));
	}

	@Test
	public void test_serializeObjectToXML() throws JAXBException, FileNotFoundException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(product, System.out);
	}

	@Test
	public void test_deserializeXmlToObject() throws JAXBException, FileNotFoundException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("product.xml").getFile());
		JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		product = (Product) unmarshaller.unmarshal(file);
		System.out.println(product);
	}
}