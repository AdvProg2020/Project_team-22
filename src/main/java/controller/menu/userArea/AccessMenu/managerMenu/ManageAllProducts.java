package main.java.controller.menu.userArea.AccessMenu.managerMenu;

import main.java.controller.menu.Menu;
import main.java.model.product.Product;

import java.util.HashMap;

public class ManageAllProducts extends Menu {
    public ManageAllProducts(Menu parentMenu) {
        super("manage all products", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getRemoveProductMenu());
        submenus.put(2, getShowAllProductsMenu());
        this.setSubmenus(submenus);
    }

    private Menu getShowAllProductsMenu() {
        return new Menu("view all products", this) {
            @Override
            public void show() {
                for (Product product : Database.getAllProducts()) {
                    System.out.println("pdo" + product.getName());
                }
            }

            @Override
            public void execute() {
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getRemoveProductMenu() {
        return new Menu("remove product", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":\n" + "Enter product id to remove");
            }

            @Override
            public void execute() {
                String productId = scanner.nextLine();
                try {
                    Database.removeProduct(Database.getProductByProductId(productId));
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }








}
