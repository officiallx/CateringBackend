package org.obnoxious.repositories;

import org.obnoxious.entities.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    public List<Item> findByMenu_MenuId(Long menuId);
}
