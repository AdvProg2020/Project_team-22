package main.java.controller.menu.userArea.AccessMenu;

import main.java.controller.menu.Menu;
import main.java.controller.menu.userArea.RegisterAndLoginAndLogoutMenu;
import main.java.model.product.Product;

import java.util.HashMap;

public class CustomerMenu extends Menu {
    public CustomerMenu (Menu parentMenu) {
        super("Customer menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getConfirmShopBasketMenu());
        submenus.put(2, getShopBasketMenu());
        submenus.put(3, new RegisterAndLoginAndLogoutMenu(this));
        this.setSubmenus(submenus);
    }

    private Menu getShopBasketMenu() {
        return new Menu("Shop basket", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                core.showShopBasket();
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getConfirmShopBasketMenu() {
        return new Menu("Confirm shop basket", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                core.confirmShopBasket();
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }
}
