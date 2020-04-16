package controller.menu.userArea.AccessMenu;

import controller.menu.Menu;

import java.util.HashMap;

public class AccessMenu extends Menu {
    public AccessMenu (Menu parentMenu) {
        super("Access menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, new ManagerMenu(this));
        submenus.put(2, new CustomerMenu(this));
        submenus.put(3, new SalesmanMenu(this));
        this.setSubmenus(submenus);
    }
}

