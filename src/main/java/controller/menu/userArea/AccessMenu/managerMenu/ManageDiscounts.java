package controller.menu.userArea.AccessMenu.managerMenu;

import controller.menu.Menu;
import model.Discount;
import model.databaseUtil.Database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ManageDiscounts extends Menu {
    public ManageDiscounts(Menu parentMenu) {
        super("manage discounts", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getCreateDiscountMenu());
        submenus.put(2, getViewDiscountMenu());
        submenus.put(3, getEditDiscountMenu());
        submenus.put(4, getRemoveDiscountMenu());
        this.setSubmenus(submenus);

    }


    private Menu getEditDiscountMenu() {
        return new Menu("edit discount", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":\n" + "Enter discount code to edit:");
            }

            @Override
            public void execute() {
                String code = scanner.nextLine();
                Discount discount = Database.getDiscountByDiscountCode(code);
                try {
                    core.editDiscount(scanner, code);
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                    Database.addDiscount(discount);
                }
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getCreateDiscountMenu() {
        return new Menu("create discount", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":\n" + "Enter new discount code information:");
            }
            @Override
            public void execute() {
                try {
                    core.createDiscount(scanner);
                }
                catch (Exception e) {
                    System.out.println("invalid input " + e.getMessage());
                }
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }




    //////////////////////////////////
    private Menu getRemoveDiscountMenu() {
        return new Menu("remove discount", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":\n" + "Enter discount code to remove discount:");
            }

            @Override
            public void execute() {
                String code = scanner.nextLine();
                try {
                    Database.removeDiscount(Database.getDiscountByDiscountCode(code));
                    System.out.println("discount successfully removed");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }




    private Menu getViewDiscountMenu() {
        return new Menu("view discount", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":\n" + "Enter discount code to view discount:");
            }

            @Override
            public void execute() {
                String code = scanner.nextLine();
                try {
                    core.showDiscount(Database.getDiscountByDiscountCode(code));
                } catch (Exception e) {
                    System.out.println("discount with this code does not exists!");
                }
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }
}
