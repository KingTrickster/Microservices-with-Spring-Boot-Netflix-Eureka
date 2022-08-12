package com.trxjster.productsservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity @Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    @Temporal(TemporalType.DATE)
    private Date createdAt;
}
