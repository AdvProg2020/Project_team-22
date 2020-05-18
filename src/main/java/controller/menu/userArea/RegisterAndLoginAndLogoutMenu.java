package main.java.controller.menu.userArea;

import main.java.controller.menu.Menu;

import java.util.HashMap;

public class RegisterAndLoginAndLogoutMenu extends Menu {
    public RegisterAndLoginAndLogoutMenu(Menu parentMenu) {
        super("Register and login Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getRegisterMenu());
        submenus.put(2, getLoginMenu());
        submenus.put(3, getLogoutMenu());
        this.setSubmenus(submenus);
    }

    private Menu getLoginMenu() {
        return new Menu("Login", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter Back to return");
            }

            @Override
            public void execute() {
                System.out.println("Enter username");
                String username = scanner.nextLine();
                System.out.println("Enter password");
                String password = scanner.nextLine();
                core.loginUser(username, password);
                this.parentMenu.show();
                this.parentMenu.execute();

            }
        };
    }

    private Menu getRegisterMenu() {
        return new Menu("Register", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                System.out.println("Enter username");
                String username = scanner.nextLine();
                System.out.println("Enter password");
                String password = scanner.nextLine();
                core.registerUser(username, password, scanner);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getLogoutMenu() {
        return new Menu("Logout", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                core.logoutUser();
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }
}
