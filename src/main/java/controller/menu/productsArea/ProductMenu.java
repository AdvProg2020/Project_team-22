package controller.menu.productsArea;

import controller.menu.Menu;

import java.util.HashMap;

public class ProductMenu extends Menu {
    public ProductMenu(Menu parentMenu) {
        super("Offs Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        //submenus.put(1, getProductsContainOffMenu());
        //submenus.put(2, getOffSearchMenu());
        this.setSubmenus(submenus);
    }
}
