package controller.menu.productsArea;

import controller.menu.Menu;

import java.util.HashMap;

public class ProductMenu extends Menu {
    public ProductMenu(Menu parentMenu) {
        super("Products Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getCategoriesMenu());
        submenus.put(2, getProductsListMenu());
        submenus.put(3, getProductSearchMenu());
        submenus.put(4, new ShowProductsMenu("Show products menu", this));
        this.setSubmenus(submenus);
    }

    private Menu getProductSearchMenu() {
        return new Menu("Search the product", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter Back to return");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                core.showResultOfProductSearch(input);
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                }
            }
        };
    }

    private Menu getProductsListMenu() {
        return new Menu("Products list", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter Back to return");
            }

            @Override
            public void execute() {
                core.showProductsList();
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                }
            }
        };
    }

    private Menu getCategoriesMenu() {
        return new Menu("Products categories", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter Back to return");
            }

            @Override
            public void execute() {
                core.showCategories();
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                }
            }
        };
    }
}
