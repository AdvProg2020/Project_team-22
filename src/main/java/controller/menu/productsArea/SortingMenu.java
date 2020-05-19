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
                System.out.println("Available sorts:\n1. price (Ascending\\Descending)\n2. average point  (Ascending\\Descending)\n3. name  (Ascending\\Descending)");
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
                System.out.println("select from sorts:\n1. price\n2. average point\n3. name");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                try {
                    int select = Integer.parseInt(input);
                    core.doSort(select, scanner);
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
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
                try {
                    core.disableSort();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        };
    }

    private Menu getShowCurrentSortsMenu() {
        return new Menu("current Sort", this) {
            @Override
            public void show() {
                System.out.println("current sort:");
            }

            @Override
            public void execute() {
                core.showCurrentSort();
            }
        };
    }


}