package main.java.controller.menu.userArea.AccessMenu;

import main.java.controller.menu.Menu;
import main.java.model.databaseUtil.Database;
import main.java.model.product.Product;

import java.util.HashMap;

public class CustomerMenu extends Menu {
    public CustomerMenu(Menu parentMenu) {
        super("Customer menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getConfirmShopBasketMenu());
        submenus.put(2, getShowShopBasketMenu());
        submenus.put(3, getShowDiscountCodesMenu());
        submenus.put(4, getShowCreditMenu());
        submenus.put(5, getIncreaseProductNumberInCartMenu());
        submenus.put(6, getDecreaseProductNumberInCartMenu());
       // submenus.put(7, new RegisterAndLoginAndLogoutMenu(this));
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
        return new Menu("Show shop basket", this) {
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
                core.confirmShopBasket(scanner);
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

    private Menu getIncreaseProductNumberInCartMenu() {
        return new Menu("Increase the products number", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter the product id in your shop basket");
            }

            @Override
            public void execute() {
                String productId = scanner.nextLine();
                Product product = Database.getProductByProductId(productId);
                if (core.currentAccount.isTheProductInCart(product)) {
                    System.out.println("How many do you want to increase?");
                    String number = scanner.nextLine();
                    core.increaseProductNumber(Integer.parseInt(number), product);
                } else {
                    System.out.println("This product is not in yor cart");
                }
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getDecreaseProductNumberInCartMenu() {
        return new Menu("Decrease the products number", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter the product id in your shop basket");
            }

            @Override
            public void execute() {
                String productId = scanner.nextLine();
                Product product = Database.getProductByProductId(productId);
                if (core.currentAccount.isTheProductInCart(product)) {
                    System.out.println("How many do you want to decrease?");
                    String number = scanner.nextLine();
                    core.decreaseProductNumber(Integer.parseInt(number), product);
                } else {
                    System.out.println("This product is not in yor cart");
                }
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }
}
