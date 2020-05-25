package controller.menu.userArea.AccessMenu.managerMenu;

import controller.menu.Menu;
import controller.menu.userArea.RegisterAndLoginAndLogoutMenu;
import model.Discount;
import model.product.Product;
import model.product.ProductStatus;
import model.product.StockStatus;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

public class ManagerMenu extends Menu {
    public ManagerMenu (Menu parentMenu) {
        super("Manager Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, new ManageDiscounts(this));
        submenus.put(2, new ManageCategories(this));
        submenus.put(3, new ManageRequests(this));
        submenus.put(4, new ManageAllProducts(this));
        submenus.put(5, new ManageUsers(this));
        submenus.put(6, new RegisterAndLoginAndLogoutMenu(this));
        this.setSubmenus(submenus);
    }

}
