package controller.menu.userArea;

import controller.menu.Menu;

import java.util.HashMap;

public class UserMenu extends Menu {
    public UserMenu (Menu parentMenu) {
        super("Offs Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        //submenus.put(1, getProductsContainOffMenu());
        //submenus.put(2, getOffSearchMenu());
        this.setSubmenus(submenus);
    }
}
