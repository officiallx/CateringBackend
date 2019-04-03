package org.obnoxious.controllers;

import org.obnoxious.Service.ItemService;
import org.obnoxious.entities.Item;
import org.obnoxious.entities.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/menu/{menuId}/items")
    public List<Item> getAllItems(@PathVariable Long menuId){
        return itemService.getAllItems(menuId);
    }

    @GetMapping("/menu/{menuId}/item/{itemId}")
    public Item getItem(@PathVariable Long itemId){
        return itemService.getItem(itemId);
    }

    @DeleteMapping("/menu/{menuId}/item/{itemId}")
    public void deleteItem(@PathVariable Long itemId){
        itemService.deleteItem(itemId);
    }

    @PutMapping("/menu/{menuId}/item/{itemId}")
    public void updateItem(@RequestBody Item item, @PathVariable Long itemId, @PathVariable Long menuId){
        item.setMenu(new Menu(menuId,""));
        itemService.updateItem(item);
    }

    @PostMapping("/menu/{menuId}/item")
    public void addItem(@RequestBody Item item,@PathVariable Long menuId){
        item.setMenu(new Menu(menuId,""));
        itemService.addItem(item);
    }
}