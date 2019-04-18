package hu.webtown.webshop;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.evosoft.javasetraining.webshop.model.Basket;
import com.evosoft.javasetraining.webshop.model.Cucumber;
import com.evosoft.javasetraining.webshop.model.DiscountType;
import com.evosoft.javasetraining.webshop.model.Salami;
import com.evosoft.javasetraining.webshop.model.TireDuck;
import com.evosoft.javasetraining.webshop.service.DiscountCalculatorStrategy;
import com.evosoft.javasetraining.webshop.service.MegapackDiscountCalculatorStrategy;
import com.evosoft.javasetraining.webshop.service.ShoppingService;
import com.evosoft.javasetraining.webshop.service.ThreeForTwoPriceDiscountCalculatorStrategy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
@Ignore
public class DiscountStrategyTest {

	
	private DiscountCalculatorStrategy twoInOneStrategy = new ThreeForTwoPriceDiscountCalculatorStrategy();
	private DiscountCalculatorStrategy megapackStrategy = new MegapackDiscountCalculatorStrategy();
	
	@Autowired
	private ShoppingService shoppingService;
	
	@Test
	public void test2In1strategyCalculationWorksProperly(){
	
		Basket orders = new Basket();

		orders.addProduct(new Salami(), 10); // Should be 14.000 based on the 2IN1
		orders.addProduct(new Cucumber(), 11); // Should be 22.400 based on 2IN1, megapack is not enabled because the amount is only 11

		System.out.println(twoInOneStrategy.calculateTotalPriceOfPurchase(orders));
		System.out.println(megapackStrategy.calculateTotalPriceOfPurchase(orders));
		
		Assert.assertEquals(36400d, twoInOneStrategy.calculateTotalPriceOfPurchase(orders).getDiscountPrice(),0d);
		Assert.assertEquals(50800d, megapackStrategy.calculateTotalPriceOfPurchase(orders).getDiscountPrice(),0d);

		shoppingService.addProductToShoppingBasket(new Salami(), 10);
		shoppingService.addProductToShoppingBasket(new Cucumber(), 11);

		Assert.assertEquals(36400d,shoppingService.calculateTotalPrice().getDiscountPrice(),0d);
		Assert.assertEquals(DiscountType.THREE_FOR_TWO_PRICE,shoppingService.calculateTotalPrice().getDiscountType());
	}
	
	@Test
	public void testMegapackStrategyCalculationWorksProperly(){
	
		Basket orders = new Basket();

		orders.addProduct(new Salami(), 10); // Should be 14.000 based on the 2IN1, should be 20000 based on megpack not enabled
		orders.addProduct(new TireDuck(), 2); // Should be 6000 no discount , no 2IN1 megapack not enabled
		orders.addProduct(new Cucumber(), 25); // Should be 64000 based on megapack, should be 47600 based on 2IN1

		System.out.println(twoInOneStrategy.calculateTotalPriceOfPurchase(orders));
		System.out.println(megapackStrategy.calculateTotalPriceOfPurchase(orders));
		
		Assert.assertEquals(67600d, twoInOneStrategy.calculateTotalPriceOfPurchase(orders).getDiscountPrice(),0d);
		Assert.assertEquals(84000d, megapackStrategy.calculateTotalPriceOfPurchase(orders).getDiscountPrice(),0d);

		shoppingService.addProductToShoppingBasket(new Salami(), 10);
		shoppingService.addProductToShoppingBasket(new Cucumber(), 25);
		shoppingService.addProductToShoppingBasket(new TireDuck(), 2);

		Assert.assertEquals(67600d,shoppingService.calculateTotalPrice().getDiscountPrice(),0d);
		Assert.assertEquals(DiscountType.THREE_FOR_TWO_PRICE,shoppingService.calculateTotalPrice().getDiscountType());
	}
}
