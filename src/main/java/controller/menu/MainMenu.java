package controller.menu;

import controller.menu.offsArea.OffsMenu;
import controller.menu.productsArea.ProductMenu;
import controller.menu.userArea.RegisterAndLoginAndLogoutMenu;
import controller.menu.userArea.UserMenu;

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