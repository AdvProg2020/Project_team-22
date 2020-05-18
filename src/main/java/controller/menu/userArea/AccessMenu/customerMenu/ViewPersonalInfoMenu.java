package main.java.controller.menu.userArea.AccessMenu.customerMenu;

import main.java.controller.menu.Menu;

import java.util.HashMap;

public class ViewPersonalInfoMenu extends Menu {
    public ViewPersonalInfoMenu( Menu parentMenu) {
        super("view personal info", parentMenu);
        HashMap< Integer , Menu>  subMenu = new HashMap<>() ;
        subMenu.put(1 , getEditFirstNameMenu() ) ;
        subMenu.put( 2 , getEditLastNameMenu()) ;
        subMenu.put( 3 , getEditPassword()) ;
        subMenu.put( 4 , getEditEmailMenu()) ;
        subMenu.put( 5 , getEditPhoneMenu()) ;
        setSubmenus( subMenu);
    }

//
    private Menu getEditFirstNameMenu() {
        return new Menu("Edit First Name ", this) {
            @Override
            public void show() {
                System.out.print( "Enter new First Name : ");
            }

            @Override
            public void execute() {

            String newFirstName = scanner.next() ;
                try {
                    core.changeAccountName( newFirstName);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        } ;
    }
    private Menu getEditLastNameMenu() {
        return new Menu("Edit Last Name ", this) {
            @Override
            public void show() {
                System.out.print( "Enter new Last Name : ");
            }

            @Override
            public void execute() {
                String newLastName = scanner.next() ;
                try {
                    core.changeAccountLastName( newLastName);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }

        } ;
    }

    private Menu getEditPassword() {
        return new Menu("Edit Password ", this) {
            @Override
            public void show() {
                System.out.print( "Enter Previous Password : ");
            }

            @Override
            public void execute() {
                String prevPass = scanner.next() ;
                System.out.print( "Enter new Password : ");
                String newPass = scanner.next() ;
                try {
                    core.changeAccountPassword( prevPass , newPass);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        } ;
    }
    private Menu getEditEmailMenu() {
        return new Menu("Edit Email ", this) {
            @Override
            public void show() {
                System.out.print( "Enter new Email : ");
            }
            @Override
            public void execute() {
                String newEmail = scanner.next() ;
                try {
                    core.changeAccountEmail( newEmail);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        } ;
    }
    private Menu getEditPhoneMenu() {
        return new Menu("Edit Phone ", this) {
            @Override
            public void show() {
                System.out.println( "Enter new Phone : ");
            }
            @Override
            public void execute() {
                String newPhone = scanner.next() ;
                try {
                    core.changeAccountPhone( newPhone);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } ;
    }



}
