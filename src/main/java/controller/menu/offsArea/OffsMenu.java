package controller.menu.offsArea;

import controller.menu.Menu;

import java.util.HashMap;

public class OffsMenu extends Menu {
    public OffsMenu(Menu parentMenu) {
        super("Offs Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getProductsContainsOffMenu());
        submenus.put(2, new OffSearchMenu(this));
        this.setSubmenus(submenus);
    }

    private Menu getProductsContainsOffMenu() {
        return new Menu("List of products which contains off", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter Back to return");
            }

            @Override
            public void execute() {
                core.showProductsContainOff();
                String input = scanner.nextLine();
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }
}

