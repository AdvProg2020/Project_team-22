package controller.menu.userArea.AccessMenu.managerMenu;

import controller.menu.Menu;
import model.databaseUtil.Database;

import java.util.HashMap;

public class ManageRequests extends Menu {
    public ManageRequests(Menu parentMenu) {
        super("manage requests", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getShowRequestsMenu());
        submenus.put(2, getRequestDetailsMenu());
        submenus.put(3, getAcceptRequestMenu());
        submenus.put(4, getRejectRequestMenu());
        this.setSubmenus(submenus);

    }

    private Menu getShowRequestsMenu() {
        return new Menu("show requests", this) {
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

    private Menu getRequestDetailsMenu() {
        return new Menu("get Request Details", this) {
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

    private Menu getAcceptRequestMenu() {
        return new Menu("accept request", this) {
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

    private Menu getRejectRequestMenu() {
        return new Menu("reject request", this) {
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
