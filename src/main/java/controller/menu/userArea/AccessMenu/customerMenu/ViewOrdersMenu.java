package main.java.controller.menu.userArea.AccessMenu.customerMenu;

import main.java.controller.menu.Menu;

import java.util.HashMap;

public class ViewOrdersMenu extends Menu {
    public ViewOrdersMenu(Menu parentMenu) {
        super("view orders", parentMenu);
        HashMap<Integer ,  Menu> subMenu = new HashMap<>( ) ;
        subMenu.put( 1 , getShowOrderMenu()) ;
        subMenu.put(2 , getRateMenu()) ;
    }

    private Menu getShowOrderMenu() {
        return  null ;
    }

    private Menu getRateMenu() {
        return null ;
    }
}
