package org.obnoxious.entities;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue
    private Long menuId;
    @Column(name = "menu_name")
    private String menuName;

    public Menu() {

    }

    public Menu(Long menuId, String menuName) {
        this.menuId = menuId;
        this.menuName = menuName;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
