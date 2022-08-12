package com.trxjster.productsservice.service;

import com.trxjster.productsservice.model.Product;
import com.trxjster.productsservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Transactional(readOnly = true)
    public Product getProductById(Long id){
        return productRepo.findById(id).orElseThrow(() -> new IllegalStateException("Product with id "+ id + " not found"));
    }

    @Transactional(readOnly = true)
    public List<Product> findAllProducts(){
        return productRepo.findAll();
    }
}
