package controller.menu.userArea.profileMenu;

import controller.menu.Menu;

import java.util.HashMap;

public class EditProfileMenu extends Menu {
    public EditProfileMenu(Menu parentMenu) {
        super("Edit profile menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getFirstChangeNameMenu());
        submenus.put(2, getChangeLastNameMenu());
        submenus.put(3, getChangeEmailMenu());
        submenus.put(4, getChangePhoneMenu());
        submenus.put(5, getChangePasswordMenu());
        this.setSubmenus(submenus);
    }

    private Menu getChangePasswordMenu() {
        return new Menu("change password", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                System.out.println("Enter last password");
                String lastPassword = scanner.nextLine();
                System.out.println("Enter new password");
                String newPassword = scanner.nextLine();
                try {
                    core.changeAccountPassword(lastPassword, newPassword);
                    System.out.println("password changed!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getChangePhoneMenu() {
        return new Menu("change phone number", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                System.out.println("Enter new phone number");
                String newPhone = scanner.nextLine();
                try {
                    core.changeAccountPhone(newPhone);
                    System.out.println("phone number changed!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                this.parentMenu.show();
                this.parentMenu.execute();

            }
        };
    }

    private Menu getChangeEmailMenu() {
        return new Menu("change email", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                System.out.println("Enter new email");
                String newEmail = scanner.nextLine();
                try {
                    core.changeAccountEmail(newEmail);
                    System.out.println("E-mail changed!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getChangeLastNameMenu() {
        return new Menu("change last name", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                System.out.println("Enter new lastName");
                String newLastName = scanner.nextLine();
                try {
                    core.changeAccountLastName(newLastName);
                    System.out.println("last name changed!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                this.parentMenu.show();
                this.parentMenu.execute();

            }
        };
    }

    private Menu getFirstChangeNameMenu() {
        return new Menu("change first name", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                System.out.println("Enter new first name");
                String newName = scanner.nextLine();
                try {
                    core.changeAccountName(newName);
                    System.out.println("first name changed!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }
}
