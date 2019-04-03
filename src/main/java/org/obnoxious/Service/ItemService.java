package org.obnoxious.Service;

import org.obnoxious.entities.Item;
import org.obnoxious.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems(Long menuId){
        return itemRepository.findByMenu_MenuId(menuId);
    }

    public Item getItem(Long itemId){
        return itemRepository.findOne(itemId);
    }

    public void addItem(Item item){
        itemRepository.save(item);
    }

    public void updateItem(Item item) {
        itemRepository.save(item);
    }

    public void deleteItem(Long itemId) {
        itemRepository.delete(itemId);
    }
}
