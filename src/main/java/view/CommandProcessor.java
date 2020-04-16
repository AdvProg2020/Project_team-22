package view;

import controller.Core;
import controller.menu.MainMenu;
import controller.menu.Menu;

import java.util.Scanner;

public class CommandProcessor {
    private Scanner scanner;
    private Core manager;

    public CommandProcessor(Core manager) {
        this.manager = manager;
        scanner = new Scanner(System.in);
        System.out.println("Hello!\nWelcome to marketing\n");
    }

    public void run() {
        Menu.setScanner(this.scanner);
        Menu.setCore(this.manager);
        Menu currentMenu = new MainMenu();
        currentMenu.show();
        currentMenu.execute();
    }
}
