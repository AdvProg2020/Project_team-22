package main.java.view;

import main.java.controller.Core;
import main.java.controller.menu.MainMenu;
import main.java.controller.menu.Menu;
import main.java.model.databaseUtil.Database;

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
//        System.out.println(Database.getAllAccounts());
//        System.out.println(Database.getAllProducts());
//        System.out.println(Database.getAllCategories());
//        Menu.setScanner(this.scanner);
//        Menu.setCore(this.manager);
//        //Menu currentMenu = new MainMenu();
//        currentMenu.show();
//        currentMenu.execute();
    }
}
