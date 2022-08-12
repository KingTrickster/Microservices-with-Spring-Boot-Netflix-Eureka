package com.trxjster.itemservice.service;

import com.trxjster.itemservice.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ItemService {
    public List<Item> findALl();
    public Item findItemById(Long id, Integer quantity);

}
