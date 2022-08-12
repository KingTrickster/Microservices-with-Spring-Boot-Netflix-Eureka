package com.trxjster.itemservice.ap1.v1;

import com.trxjster.itemservice.model.Item;
import com.trxjster.itemservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("")
    public List<Item> getAllItems(){
        return itemService.findALl();
    }

    @GetMapping("/{itemId}/quantity/{quantity}")
    public Item getItemById(@PathVariable Long itemId, @PathVariable Integer quantity){
        return itemService.findItemById(itemId, quantity);
    }
}
