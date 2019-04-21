package org.obnoxious.Service;

import org.obnoxious.entities.Item;
import org.obnoxious.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems(Long menuId){
        return itemRepository.findByMenu_MenuId(menuId);
    }

    public Optional<Item> getItem(Long itemId){
        return itemRepository.findById(itemId);
    }

    public void addItem(Item item){
        itemRepository.save(item);
    }

    public void updateItem(Item item) {
        itemRepository.save(item);
    }

    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
