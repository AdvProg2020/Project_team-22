package main.java.controller.menu.productsArea;

import main.java.controller.menu.Menu;

import java.util.HashMap;

public class SortingMenu extends Menu {
    public SortingMenu(Menu parentMenu) {
        super("sorting menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getShowAvailableSortsMenu());
        submenus.put(2, getAddSortMenu());
        submenus.put(3, getDisableSortMenu());
        submenus.put(4, getShowCurrentSortsMenu());
        this.setSubmenus(submenus);
    }

    private Menu getShowAvailableSortsMenu() {
        return new Menu("show available Sorts", this) {
            @Override
            public void show() {
                System.out.println("Available filters:\n1. price\n2. availability\n3. category\n4. name\n");
            }

            @Override
            public void execute() {
            }
        };
    }

    private Menu getAddSortMenu() {
        return new Menu("enable Sort", this) {
            @Override
            public void show() {
            }

            @Override
            public void execute() {
            }
        };
    }

    private Menu getDisableSortMenu() {
        return new Menu("disable Sort", this) {
            @Override
            public void show() {
            }

            @Override
            public void execute() {
            }
        };
    }

    private Menu getShowCurrentSortsMenu() {
        return new Menu("current Sort", this) {
            @Override
            public void show() {
            }

            @Override
            public void execute() {
            }
        };
    }


}
