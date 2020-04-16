package controller.menu.userArea.AccessMenu;

import controller.menu.Menu;
import model.off.Off;
import model.product.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class SalesmanMenu extends Menu {
    public SalesmanMenu (Menu parentMenu) {
        super("Salesman menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getCreateOffMenu());
        submenus.put(2, getEditOffMenu());
        submenus.put(3, gerSellProductMenu());
        this.setSubmenus(submenus);
    }

    private Menu gerSellProductMenu() {
        return new Menu("Sell product", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                Product product = null;
                core.sellProduct(product);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getEditOffMenu() {
        return new Menu("Edit menu", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                Off off = null;
                ArrayList<Product> productsList = null;
                double percent = 0;
                int maxOffAmount = 0;
                Date endDate = null;
                core.editOff(off, productsList, percent, maxOffAmount, endDate);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getCreateOffMenu() {
        return new Menu("Create off", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                ArrayList<Product> productsList = null;
                double percent = 0;
                int maxOffAmount = 0;
                Date endDate = null;
                core.createOff(productsList, percent, maxOffAmount, endDate);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }
}