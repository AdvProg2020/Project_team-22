package view;

import controller.Manager;
import controller.menu.MainMenu;
import controller.menu.Menu;

import java.util.Scanner;

public class CommandProcessor {
    private Scanner scanner;
    private Manager manager;

    public CommandProcessor(Manager manager) {
        this.manager = manager;
        scanner = new Scanner(System.in);
        System.out.println("Hello!\nWelcome to marketing\n");
    }

    public void run() {
        Menu.setScanner(this.scanner);
        Menu.setManager(this.manager);
        Menu currentMenu = new MainMenu();
        currentMenu.show();
        currentMenu.execute();
    }
}
