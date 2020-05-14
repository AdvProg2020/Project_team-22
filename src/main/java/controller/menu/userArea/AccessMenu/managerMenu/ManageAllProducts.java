package controller.menu.userArea.AccessMenu.managerMenu;

import controller.menu.Menu;
import model.databaseUtil.Database;

import java.util.HashMap;

public class ManageAllProducts extends Menu {
    public ManageAllProducts(Menu parentMenu) {
        super("manage all products", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getRemoveProductMenu());
        this.setSubmenus(submenus);
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
