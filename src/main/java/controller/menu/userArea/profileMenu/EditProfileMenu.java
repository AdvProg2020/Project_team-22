package controller.menu.userArea.profileMenu;

import controller.menu.Menu;

import java.util.HashMap;

public class EditProfileMenu extends Menu {
    public EditProfileMenu(Menu parentMenu) {
        super("Edit profile menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getChangeNameMenu());
        submenus.put(2, getChangeLastNameMenu());
        submenus.put(3, getChangeEmailMenu());
        submenus.put(4, getChangePhoneMenu());
        submenus.put(5, getChangePasswordMenu());
        this.setSubmenus(submenus);
    }

    private Menu getChangePasswordMenu() {
        return new Menu("", this) {
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
                core.changeAccountPassword(lastPassword, newPassword);
                this.parentMenu.show();
                this.parentMenu.execute();

            }
        };
    }

    private Menu getChangePhoneMenu() {
        return new Menu("", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                System.out.println("Enter new phone number");
                String newPhone = scanner.nextLine();
                core.changeAccountPhone(newPhone);
                this.parentMenu.show();
                this.parentMenu.execute();

            }
        };
    }

    private Menu getChangeEmailMenu() {
        return new Menu("", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                System.out.println("Enter new phone email");
                String newEmail = scanner.nextLine();
                core.changeAccountEmail(newEmail);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getChangeLastNameMenu() {
        return new Menu("", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                System.out.println("Enter new lastName");
                String newLastName = scanner.nextLine();
                core.changeAccountLastName(newLastName);
                this.parentMenu.show();
                this.parentMenu.execute();

            }
        };
    }

    private Menu getChangeNameMenu() {
        return new Menu("", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                System.out.println("Enter new phone number");
                String newName = scanner.nextLine();
                core.changeAccountName(newName);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }
}
