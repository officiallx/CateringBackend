package org.obnoxious.controllers;

import org.obnoxious.Service.MenuService;
import org.obnoxious.entities.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    @GetMapping("/menu/{menuId}")
    public Optional<Menu> getMenu(@PathVariable Long menuId){
        return menuService.getMenu(menuId);
    }

    @DeleteMapping("/menu/{menuId}")
    public void deleteMenu(@PathVariable Long menuId){
        menuService.deleteMenu(menuId);
    }

    @PutMapping("/menu/{menuId}")
    public void updateMenu(@RequestBody Menu menu, @PathVariable Long menuId){
        menuService.updateMenu(menuId, menu);
    }

    @PostMapping("/menu")
    public void addMenu(@RequestBody Menu menu){
        menuService.addMenu(menu);
    }
}