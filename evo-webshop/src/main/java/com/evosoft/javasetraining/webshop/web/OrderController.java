package com.evosoft.javasetraining.webshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.evosoft.javasetraining.webshop.OrderDTO;
import com.evosoft.javasetraining.webshop.model.Chestnut;
import com.evosoft.javasetraining.webshop.model.Cucumber;
import com.evosoft.javasetraining.webshop.model.Salami;
import com.evosoft.javasetraining.webshop.model.TireDuck;
import com.evosoft.javasetraining.webshop.model.Total;
import com.evosoft.javasetraining.webshop.service.ExchangeService;
import com.evosoft.javasetraining.webshop.service.ShoppingService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private ShoppingService shoppingService;
	
	@Autowired
	private ExchangeService exchangeService;

	@ModelAttribute(name = "orderForm")
	public OrderDTO getOrderForm() {
		return new OrderDTO();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getOrderPage() {

		return "orderpage";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processPurchase(@ModelAttribute("orderForm") OrderDTO orderDTO, final RedirectAttributes redirectAttributes) {

		shoppingService.addProductToShoppingBasket(new Cucumber(), orderDTO.getNumOfCucumber());
		shoppingService.addProductToShoppingBasket(new Chestnut(), orderDTO.getNumOfChestnut());
		shoppingService.addProductToShoppingBasket(new Salami(), orderDTO.getNumOfSalami());
		shoppingService.addProductToShoppingBasket(new TireDuck(), orderDTO.getNumOfTireDuck());

		Total totalPrice = shoppingService.calculateTotalPrice();
		
		double totalPriceInEUR = exchangeService.exchangeHufToEur(totalPrice.getDiscountPrice());
		
		redirectAttributes.addFlashAttribute("totalPrice", totalPrice);
		redirectAttributes.addFlashAttribute("totalPriceInEur", totalPriceInEUR);
		
		return "redirect:/order";
	}
}
