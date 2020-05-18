package main.java.controller.menu.userArea.AccessMenu.managerMenu;

import main.java.controller.menu.Menu;
import main.java.model.account.Account;
import main.java.model.account.Role;
import main.java.model.databaseUtil.Database;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Objects;

public class ManageUsers extends Menu {
    public ManageUsers(Menu parentMenu) {
        super("manage users", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getViewMenu());
        submenus.put(2, getDeleteUserMenu());
        submenus.put(3, getCreateManagerProfileMenu());
        submenus.put(4, getShowUsersMenu());
        this.setSubmenus(submenus);

    }

    private Menu getCreateManagerProfileMenu() {
        return new Menu("create manager profile", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":\n" + "Enter new manager information:");
            }

            @Override
            public void execute() {

                System.out.println("username:");
                String username = scanner.nextLine();
                System.out.println("first name:");
                String firstName = scanner.nextLine();
                System.out.println("last name:");
                String lastName = scanner.nextLine();
                System.out.println("E-mail:");
                String email = scanner.nextLine();
                System.out.println("phone:");
                String phone = scanner.nextLine();
                System.out.println("password:");
                String password = scanner.nextLine();
                try {
                    Database.addAccount(new Account(username, firstName, lastName, email, phone, password, Role.MANAGER));
                    System.out.println("Account successfully created!");
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getShowUsersMenu() {
        return new Menu("show all users", this) {

            @Override
            public void show() {
            }

            @Override
            public void execute() {
                core.showAllUsers();
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getDeleteUserMenu() {
        return new Menu("delete user", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":\n" + "Enter username to delete account:");
            }

            @Override
            public void execute() {
                String username = scanner.nextLine();
                if (username.equals(core.currentAccount.getUsername())) {
                    System.out.println("You can not remove yor self! :)");
                } else {
                    try {
                        Database.deleteAccount(Database.getAccountByUsername(username));
                        System.out.println("account successfully deleted");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    this.parentMenu.show();
                    this.parentMenu.execute();
                }
            }
        };
    }

    private Menu getViewMenu() {
        return new Menu("view user", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":\n" + "Enter username to view info:");
            }

            @Override
            public void execute() {
                String username = scanner.nextLine();
                try {
                    core.showProfileInfo(Database.getAccountByUsername(username));
                } catch (NullPointerException e) {
                    System.out.println("user with this username not exist!");
                }
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }
}
