package org.obnoxious.Service;

import org.obnoxious.entities.Menu;
import org.obnoxious.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAllMenus(){
       return (List<Menu>) menuRepository.findAll();
    }

    public Optional<Menu> getMenu(Long menuId){
        return menuRepository.findById(menuId);
    }

    public void addMenu(Menu menu){
        menuRepository.save(menu);
    }

    public void updateMenu(Long menuId, Menu menu) {
        menuRepository.save(menu);
    }

    public void deleteMenu(Long menuId) {
        menuRepository.deleteById(menuId);
    }
}
