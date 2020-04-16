package controller.menu.offsArea;

import controller.menu.Menu;

import java.util.HashMap;

public class OffSearchMenu extends Menu {
    public OffSearchMenu(Menu parentMenu) {
        super("Off search menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getSortByGeneralPropertiesMenu());
        submenus.put(2, getSortByCustomPropertiesMenu());
        this.setSubmenus(submenus);
    }

    private Menu getSortByCustomPropertiesMenu() {
        return new Menu("sort by custom property", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter the property");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    core.sortByCustomProperty(input);
                }
            }
        };
    }

    private Menu getSortByGeneralPropertiesMenu() {
        return new Menu("sort by general property", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter the property");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    core.sortByGeneralProperty(input);
                }
            }
        };
    }
}
