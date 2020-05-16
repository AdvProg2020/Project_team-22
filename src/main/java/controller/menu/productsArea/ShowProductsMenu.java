package controller.menu.productsArea;

import controller.menu.Menu;
import model.product.Product;

import java.util.HashMap;

public class ShowProductsMenu extends Menu {
    public ShowProductsMenu(String name, Menu parentMenu) {
        super(name, parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getShowProductsInfoMenu());
        /*submenus.put(2, getConfirmShopBasketMenu());
        submenus.put(3, getCompareProductMenu());
        submenus.put(4, getShopBasketMenu());
        submenus.put(5, getWriteCommentMenu());
        submenus.put(6, getWritePointForProductMenu());
        this.setSubmenus(submenus);*/
    }

    private Menu getShowProductsInfoMenu() {
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
}
