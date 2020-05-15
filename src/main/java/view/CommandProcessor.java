package view;

import controller.Core;
import controller.menu.MainMenu;
import controller.menu.Menu;
import model.account.Account;
import model.account.Role;
import model.databaseUtil.Database;

import javax.xml.crypto.Data;
import java.util.Scanner;

public class CommandProcessor {
    private Scanner scanner;
    private Core manager;

    public CommandProcessor(Core manager) {
        this.manager = manager;
        scanner = new Scanner(System.in);
        System.out.println("Hello!\nWelcome to marketing\n");
    }

    public void run() throws Exception {
        Menu.setScanner(this.scanner);
        Menu.setCore(this.manager);
        Menu currentMenu = new MainMenu();
        currentMenu.show();
        currentMenu.execute();
    }
}
