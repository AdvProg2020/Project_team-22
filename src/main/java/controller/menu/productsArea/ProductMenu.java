package main.java.controller.menu.productsArea;

import main.java.controller.menu.Menu;

import java.util.HashMap;

public class ProductMenu extends Menu {
    public ProductMenu(Menu parentMenu) {
        super("Products Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getCategoriesMenu());
        submenus.put(2, getProductsListMenu());
        submenus.put(3, getProductSearchMenu());
        submenus.put(4, new FilteringMenu(this));
        submenus.put(5, new SortingMenu(this));
        submenus.put(6, new ShowProductsMenu("Show products menu", this));
        this.setSubmenus(submenus);
    }

    private Menu getProductSearchMenu() {
        return new Menu("Search the product", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                String input = null;
                try {
                    core.showResultOfProductSearch(input);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        };
    }

    private Menu getProductsListMenu() {
        return new Menu("Products list", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                core.showProductsList();
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getCategoriesMenu() {
        return new Menu("Products categories", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                core.showCategories();
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }
}
