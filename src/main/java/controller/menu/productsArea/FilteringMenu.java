package main.java.controller.menu.productsArea;

import main.java.controller.menu.Menu;

import java.util.HashMap;

public class FilteringMenu extends Menu {
    public FilteringMenu(Menu parentMenu) {
        super("filtering Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getShowAvailableFiltersMenu());
        submenus.put(2, getAddFilterMenu());
        submenus.put(3, getDisableFilterMenu());
        submenus.put(4, getShowCurrentFiltersMenu());
        this.setSubmenus(submenus);
    }

    private Menu getShowAvailableFiltersMenu() {
        return new Menu("show available filters", this) {
            @Override
            public void show() {
                System.out.println("Available filters:\n1. price\n2. availability\n3. category");
            }

            @Override
            public void execute() {
            }
        };
    }

    private Menu getAddFilterMenu() {
        return new Menu("enable filter", this) {
            @Override
            public void show() {
                System.out.println("select from filters:\n1. price\n2. availability\n3. category");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                try {
                    int select = Integer.parseInt(input);
                    core.enableFilter(select, scanner);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        };
    }

    private Menu getDisableFilterMenu() {
        return new Menu("disable", this) {
            @Override
            public void show() {
                System.out.println("select from filters:\n1. price\n2. availability\n3. category");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                try {
                    int select = Integer.parseInt(input);
                    core.disableFilter(select, scanner);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        };
    }

    private Menu getShowCurrentFiltersMenu() {
        return new Menu("view current filters", this) {
            @Override
            public void show() {
                System.out.println("current filters");
            }

            @Override
            public void execute() {
                core.showCurrentFilters();
            }
        };
    }

}
