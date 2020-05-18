package main.java.controller.menu.userArea.AccessMenu;

import main.java.controller.menu.Menu;
import main.java.controller.menu.userArea.AccessMenu.managerMenu.ManagerMenu;
import main.java.controller.menu.userArea.RegisterAndLoginAndLogoutMenu;

import java.util.HashMap;

public class AccessMenu extends Menu {
    public AccessMenu (Menu parentMenu) {
        super("Access menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, new ManagerMenu(this));
        submenus.put(2, new CustomerMenu(this));
        submenus.put(3, new SalesmanMenu(this));
        submenus.put(4, new RegisterAndLoginAndLogoutMenu(this));
        this.setSubmenus(submenus);
    }
}

