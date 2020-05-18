package main.java.controller.menu.userArea.AccessMenu.customerMenu;

import main.java.controller.menu.Menu;
import main.java.controller.menu.productsArea.ShowProductsMenu;

import java.util.HashMap;

public class viewCartMenu extends Menu {
    public viewCartMenu( Menu parentMenu) {
        super("view cart", parentMenu);
        HashMap< Integer , Menu> subMenu = new HashMap<>() ;
        subMenu.put( 1 , getShowProductsMenu()) ;
        subMenu.put(2 , new ShowProductsMenu( "View Product " , this));
        subMenu.put( 3 , getIncreaseProductMenu()) ;
        subMenu.put( 4 , getDecreaseProductMenu()) ;
        subMenu.put( 5 , getTotalPriceMenu()) ;
        subMenu.put(6 , getPurchaseMenu()) ;
        setSubmenus( subMenu);

    }


    private Menu getDecreaseProductMenu() {
        return new Menu("Decrease Product" , this) {
            @Override
            public void show() {
                System.out.print("Enter Product id");
            }

            @Override
            public void execute() {
                String productid = scanner.next() ;
                try {
                    core.decreaseProductInShopBasket( productid);
                } catch (Exception e) {
                    System.out.println( e.getMessage());
                }
            }
        } ;
    }

    private Menu getIncreaseProductMenu() {
        return new Menu("Increase Product" , this) {
            @Override
            public void show() {
                System.out.print("Enter Product id");
            }

            @Override
            public void execute() {
                String productid = scanner.next() ;
                try {
                    core.increaseProductInShopBasket( productid);
                } catch (Exception e) {
                    System.out.println( e.getMessage());
                }
            }
        } ;
    }

    private Menu getShowProductsMenu() {
        return new Menu("Show products" , this) {
            @Override
            public void show() {
                core.showShopBasket();
            }
//
//            @Override
//            public void execute() {
//                super.execute();
//            }
        } ;
    }

    private Menu getTotalPriceMenu() {
        return new Menu("Show total price" , this) {
            @Override
            public void show() {
                System.out.println( " Your Shop basket total price is : " + core.getBasketTotalPrice());
            }

//            @Override
//            public void execute() {
//                super.execute();
//            }
        } ;
    }

    private Menu getPurchaseMenu() {
        return new Menu("Purchase" , this) {
            @Override
            public void show() {
                super.show();
            }

            @Override
            public void execute() {
                super.execute();
            }
        } ;
    }


}
