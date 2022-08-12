package com.trxjster.itemservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Product {

    private Long id;
    private String name;
    private Double price;
    private Date createdAt;

}
