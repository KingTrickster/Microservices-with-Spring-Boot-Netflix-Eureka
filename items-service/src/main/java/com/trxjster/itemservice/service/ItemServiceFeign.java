package com.trxjster.itemservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.trxjster.itemservice.clients.ProductRestClient;
import com.trxjster.itemservice.model.Item;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService {

	@Autowired
	private ProductRestClient feignClient;

	@Override
	public List<Item> findALl() {
		return feignClient.getProducts().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findItemById(Long id, Integer quantity) {
		return new Item(feignClient.getProductById(id), quantity);
	}

}
