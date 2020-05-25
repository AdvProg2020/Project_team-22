package controller.menu.userArea.AccessMenu.managerMenu;

import controller.menu.Menu;
import model.Category;
import model.databaseUtil.Database;

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
                String name = scanner.nextLine();
                try {
                    core.editCategory(scanner, name);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
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
                System.out.println("Enter category name:");
            }
            @Override
            public void execute() {
                try {
                    String name = scanner.nextLine();
                    core.createCategory(name, core.setCategoryProperties(scanner));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
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
                String name = scanner.nextLine();
                try {
                    Database.removeCategory(Database.getCategoryByName(name));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getShowCategoriesMenu() {
        return new Menu("show categories", this) {
            @Override
            public void show() {
                for (Category category : Database.getAllCategories()) {
                    System.out.println("category name: " + category.getName() + "\nproperties:");
                    for(Integer num : category.getProperties().keySet()) {
                        System.out.println(num + ". " + category.getProperties().get(num));
                    }
                }
            }

            @Override
            public void execute() {
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }




}
