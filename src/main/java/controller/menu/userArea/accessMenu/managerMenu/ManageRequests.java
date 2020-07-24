//package main.java.controller.menu.userArea.accessMenu.managerMenu;
//
//import main.java.controller.menu.Menu;
//import main.java.model.databaseUtil.Database;
//import main.java.model.request.Request;
//
//import java.util.HashMap;
//
//public class ManageRequests extends Menu {
//    public ManageRequests(Menu parentMenu) {
//        super("manage requests", parentMenu);
//        HashMap<Integer, Menu> submenus = new HashMap<>();
//        submenus.put(1, getShowRequestsMenu());
//        submenus.put(2, getRequestDetailsMenu());
//        submenus.put(3, getAcceptRequestMenu());
//        submenus.put(4, getRejectRequestMenu());
//        this.setSubmenus(submenus);
//
//    }
//
//    private Menu getShowRequestsMenu() {
//        return new Menu("show requests", this) {
//            @Override
//            public void show() {
//                System.out.println("all requests:");
//                for (Request request : Database.getAllRequests()) {
//                    System.out.println(request);
//                }
//            }
//
//            @Override
//            public void execute() {
//                this.parentMenu.show();
//                this.parentMenu.execute();
//            }
//        };
//    }
//
//    private Menu getRequestDetailsMenu() {
//        return new Menu("get Request Details", this) {
//            @Override
//            public void show() {
//                System.out.println("enter request id to show details");
//            }
//
//            @Override
//            public void execute() {
//                String requestId = scanner.nextLine();
//                try {
//                    core.showRequest(requestId);
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//                this.parentMenu.show();
//                this.parentMenu.execute();
//            }
//        };
//    }
//
//    private Menu getAcceptRequestMenu() {
//        return new Menu("accept request", this) {
//            @Override
//            public void show() {
//                System.out.println("enter request id to accept");
//            }
//
//            @Override
//            public void execute() {
//                String requestId = scanner.nextLine();
//                try {
//                    core.acceptRequestById(requestId);
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//                this.parentMenu.show();
//                this.parentMenu.execute();
//            }
//        };
//    }
//
//    private Menu getRejectRequestMenu() {
//        return new Menu("reject request", this) {
//            @Override
//            public void show() {
//                System.out.println("enter request id to reject");
//            }
//
//            @Override
//            public void execute() {
//                String requestId = scanner.nextLine();
//                try {
//                    core.rejectRequestById(requestId);
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//                this.parentMenu.show();
//                this.parentMenu.execute();
//            }
//        };
//    }
//}