package com.trxjster.itemservice.service;

import com.trxjster.itemservice.model.Item;
import com.trxjster.itemservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl  implements ItemService{

    @Autowired
    private RestTemplate restClient;

    @Override
    public List<Item> findALl() {
        List<Product> products = Arrays.asList(restClient.getForObject("http://localhost:8001/api/v1/Products", Product[].class));
        return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findItemById(Long productId, Integer quantity) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("productId", productId.toString());
        Product product = restClient.getForObject("http://localhost:8001/api/v1/Products/{productId}", Product.class, pathVariables);
        return new Item(product, quantity);
    }
}
