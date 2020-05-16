package main.java.controller.menu.userArea.profileMenu;

import main.java.controller.menu.Menu;

import java.util.HashMap;

public class ProfileMenu extends Menu {
    public ProfileMenu (Menu parentMenu) {
        super("Profile menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getProfileInfoMenu());
        submenus.put(2, new EditProfileMenu(this));
        this.setSubmenus(submenus);
    }

    private Menu getProfileInfoMenu() {
        return new Menu("Profile info", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                core.showProfileInfo(core.currentAccount);
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                }
            }
        };
    }
}