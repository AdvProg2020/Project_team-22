package main.java.controller.menu.userArea.AccessMenu;

import main.java.controller.menu.Menu;
import main.java.controller.menu.userArea.RegisterAndLoginAndLogoutMenu;

import java.util.HashMap;

public class CustomerMenu extends Menu {
    public CustomerMenu (Menu parentMenu) {
        super("Customer menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getConfirmShopBasketMenu());
        submenus.put(2, getShowShopBasketMenu());
        submenus.put(3, getShowDiscountCodesMenu());
        submenus.put(4, getShowCreditMenu());
        submenus.put(5, getChangeProductNumberInCartMenu());
        submenus.put(7, new RegisterAndLoginAndLogoutMenu(this));
        this.setSubmenus(submenus);
    }

    private Menu getShowCreditMenu() {
        return new Menu("Show credit", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                System.out.println("Your credit is " + core.currentAccount.getCredit() + " Toman");
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getShowShopBasketMenu() {
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

    private Menu getShowDiscountCodesMenu() {
        return new Menu("Show discount codes", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                core.showCustomerDiscount();
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getChangeProductNumberInCartMenu() {
        return new Menu("Show discount codes", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                core.showCustomerDiscount();
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }
}
