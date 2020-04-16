package controller.menu.userArea.AccessMenu;

import controller.menu.Menu;
import model.product.Product;

import java.util.HashMap;

public class CustomerMenu extends Menu{
    public CustomerMenu (Menu parentMenu) {
        super("Customer menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getAddProductToShopBasketMenu());
        submenus.put(2, getConfirmShopBasketMenu());
        submenus.put(3, getCompareProductMenu());
        submenus.put(4, getShopBasketMenu());
        submenus.put(5, getWriteCommentMenu());
        submenus.put(6, getWritePointForProductMenu());
        this.setSubmenus(submenus);
    }

    private Menu getWritePointForProductMenu() {
        return new Menu("Write point for product", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                int point = 0;
                Product product = null;
                core.writePointForProduct(point, product);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
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

    private Menu getCompareProductMenu() {
        return new Menu("Compare product", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                Product firstProduct = null;
                Product secondProduct = null;
                core.compareProduct(firstProduct, secondProduct);
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

    private Menu getAddProductToShopBasketMenu() {
        return new Menu("Add product to shop basket", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                Product product = null;
                core.addProductToShopBasket(product);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getWriteCommentMenu() {
        return new Menu("Write comment", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                String comment = null;
                Product product = null;
                core.writeComment(comment, product);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }


}
