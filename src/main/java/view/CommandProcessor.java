package view;

import controller.menu.Core;
import controller.menu.MainMenu;
import controller.menu.Menu;
import model.databaseUtil.Database;

import java.util.Scanner;

public class CommandProcessor {
    private Scanner scanner;
    private Core manager;

    public CommandProcessor(Core manager) {
        this.manager = manager;
        scanner = new Scanner(System.in);
        System.out.println("Hello!\nWelcome to marketing\n");
    }

    public void run()  {
        System.out.println(Database.getAllAccounts());
        System.out.println(Database.getAllProducts());
        System.out.println(Database.getAllCategories());
        Menu.setScanner(this.scanner);
        Menu.setCore(this.manager);
        Menu currentMenu = new MainMenu();
        currentMenu.show();
        currentMenu.execute();
    }
}
