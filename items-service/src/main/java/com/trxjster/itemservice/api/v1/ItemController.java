package com.trxjster.itemservice.api.v1;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trxjster.itemservice.model.Item;
import com.trxjster.itemservice.model.Product;
import com.trxjster.itemservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Items")
public class ItemController {

	@Autowired
	@Qualifier("serviceFeign")
	private ItemService itemService;

	@GetMapping("")
	public List<Item> getAllItems() {
		return itemService.findALl();
	}

	@HystrixCommand(fallbackMethod = "alternativeMethod")
	@GetMapping("/{itemId}/quantity/{quantity}")
	public Item getItemById(@PathVariable Long itemId, @PathVariable Integer quantity) {
		return itemService.findItemById(itemId, quantity);
	}

	public Item alternativeMethod(Long itemId, Integer quantity) {
		Item item = new Item();
		Product product = new Product();

		item.setQuantity(quantity);
		product.setId(itemId);
		product.setName("Product");
		product.setPrice(500.00);
		item.setProduct(product);
		return item;
	}
}
