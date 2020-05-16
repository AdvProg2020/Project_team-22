package main.java.controller.menu.userArea.AccessMenu.managerMenu;

import main.java.controller.menu.Menu;

import java.util.HashMap;

public class ManageCategories extends Menu {
    public ManageCategories(Menu parentMenu) {
        super("manage categories", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getEditCategoryMenu());
        submenus.put(2, getAddCategoryMenu());
        submenus.put(3, getRemoveCategoryMenu());
        submenus.put(4, getShowCategoriesMenu());
        this.setSubmenus(submenus);

    }

    private Menu getEditCategoryMenu() {
        return new Menu("edit category", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":\n" + "Enter category name to edit:");
            }

            @Override
            public void execute() {
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }


    private Menu getAddCategoryMenu() {
        return new Menu("add category", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":\n" + "Enter new category information to add:");
            }

            @Override
            public void execute() {
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getRemoveCategoryMenu() {
        return new Menu("remove category", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":\n" + "Enter category name to remove:");
            }

            @Override
            public void execute() {
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getShowCategoriesMenu() {
        return new Menu("edit category", this) {
            @Override
            public void show() {
            }

            @Override
            public void execute() {
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }




}
