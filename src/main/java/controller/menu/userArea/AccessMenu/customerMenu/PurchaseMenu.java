package controller.menu.userArea.AccessMenu.customerMenu;

import controller.menu.Menu;
import model.product.Product;

public class PurchaseMenu extends Menu {
    public PurchaseMenu( Menu parentMenu) {
        super("Purchase", parentMenu);
    }

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
        //teeeeeeeeeeeeeeest
    }

}
