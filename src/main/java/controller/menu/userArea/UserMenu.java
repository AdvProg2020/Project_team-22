package main.java.controller.menu.userArea;

import main.java.controller.menu.Menu;
import main.java.controller.menu.userArea.AccessMenu.AccessMenu;
import main.java.controller.menu.userArea.profileMenu.ProfileMenu;

import java.util.HashMap;

public class UserMenu extends Menu {
    public UserMenu (Menu parentMenu) {
        super("User Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, new ProfileMenu(this));
        submenus.put(2, new AccessMenu(this));
        submenus.put(3, new RegisterAndLoginAndLogoutMenu(this));
        this.setSubmenus(submenus);
    }

}
