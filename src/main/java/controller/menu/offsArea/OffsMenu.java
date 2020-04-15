package controller.menu.offsArea;

import controller.menu.Menu;

import java.util.HashMap;

public class OffsMenu extends Menu {
    public OffsMenu(Menu parentMenu) {
        super("Offs Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getProductsContainOffMenu());
        submenus.put(2, getOffSearchMenu());
        this.setSubmenus(submenus);
    }

    private Menu getProductsContainOffMenu() {
        return new Menu("List of products which contain off", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter Back to return");
            }

            @Override
            public void execute() {
                manager.showProductsContainOff();
            }
        };
    }

    private Menu getOffSearchMenu() {
        Menu OffSearchMenu = new OffSearchMenu(this);
        return OffSearchMenu;
    }
}

