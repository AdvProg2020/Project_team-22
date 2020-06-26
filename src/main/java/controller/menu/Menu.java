package controller.menu;

import controller.menu.userArea.AccessMenu.SalesmanMenu;
import controller.menu.userArea.AccessMenu.customerMenu.CustomerMenu;
import controller.menu.userArea.AccessMenu.managerMenu.ManagerMenu;
import controller.menu.userArea.UserMenu;
import model.account.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Menu {
    private String name;
    protected HashMap<Integer, Menu> submenus;
    protected Menu parentMenu;
    public static Scanner scanner;
    protected static Core core;
    protected static ArrayList<Menu> allMenus;

    static {
        allMenus = new ArrayList<>();
    }

    public static void setScanner(Scanner scanner) {
        Menu.scanner = scanner;
    }

    public static void setCore(Core core) {
        Menu.core = core;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public Menu(String name, Menu parentMenu) {
        this.name = name;
        this.parentMenu = parentMenu;
        allMenus.add(this);
    }

    public String getName() {
        return name;
    }

    public void setSubmenus(HashMap<Integer, Menu> submenus) {
        this.submenus = submenus;
    }

    public void show() {
        System.out.println(this.name + ":");
        for (Integer menuNum : submenus.keySet()) {
            System.out.println(menuNum + ". " + submenus.get(menuNum).getName());
        }
        if (this.parentMenu != null) {
            System.out.println((submenus.size() + 1) + ". Back");
        } else {
            System.out.println((submenus.size() + 1) + ". Exit");
        }
    }

    public void execute() {
        Menu nextMenu = null;
        try {
            int chosenMenu = Integer.parseInt(scanner.nextLine());
            if (chosenMenu == submenus.size() + 1) {
                if (this.parentMenu == null) {
                    System.exit(1);
                } else {
                    nextMenu = this.parentMenu;
                }
            } else {
                nextMenu = submenus.get(chosenMenu);
            }
            if(!nextMenu.equals(this.parentMenu)) {
                if(nextMenu instanceof UserMenu && core.getCurrentAccount() == null) {
                    throw new Exception("login or register first");
                } else if(nextMenu instanceof ManagerMenu && core.getCurrentAccount().getRole() != Role.MANAGER) {
                    throw new Exception("you are not a manager!");
                } else if(nextMenu instanceof SalesmanMenu && core.getCurrentAccount().getRole() != Role.SALESMAN) {
                    throw new Exception("you are not a salesman!");
                } else if(nextMenu instanceof CustomerMenu && core.getCurrentAccount().getRole() != Role.CUSTOMER) {
                    throw new Exception("you are not a customer!");
                }
            }
            nextMenu.show();
            nextMenu.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        show();
        execute();
    }
}
