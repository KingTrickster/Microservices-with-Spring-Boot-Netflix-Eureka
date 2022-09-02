package com.trxjster.itemservice.service;

import com.trxjster.itemservice.model.Item;

import java.util.List;

public interface ItemService {
    public List<Item> findALl();
    public Item findItemById(Long id, Integer quantity);

}
