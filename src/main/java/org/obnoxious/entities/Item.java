package org.obnoxious.entities;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "item_name")
    private String itemName;
    @Column (name = "item_description")
    private String itemDescription;

    @JoinColumn
    @ManyToOne
    private Menu menu;

    public Item(){

    }

    public Item(String itemName, String itemDescription, Long menuId) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.menu = new Menu(menuId, "");
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
