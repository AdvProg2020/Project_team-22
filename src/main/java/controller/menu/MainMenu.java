package main.java.controller.menu;

import main.java.controller.menu.offsArea.OffsMenu;
import main.java.controller.menu.productsArea.ProductMenu;
import main.java.controller.menu.userArea.RegisterAndLoginAndLogoutMenu;
import main.java.controller.menu.userArea.UserMenu;

import java.util.HashMap;

public class MainMenu extends Menu {

    public MainMenu() {
        super("Main Menu", null);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, new UserMenu(this));
        submenus.put(2, new ProductMenu(this));
        submenus.put(3, new OffsMenu(this));
        submenus.put(4, new RegisterAndLoginAndLogoutMenu(this));
        this.setSubmenus(submenus);
    }
}