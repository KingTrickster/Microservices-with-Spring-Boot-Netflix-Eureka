package com.trxjster.itemservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trxjster.itemservice.model.Product;

@FeignClient(name = "products-service", url = "localhost:8001")
public interface ProductRestClient {

	@GetMapping("")
	public List<Product> getProducts();

	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable Long productId);

}
