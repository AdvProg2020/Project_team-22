package controller.menu.productsArea;

import controller.menu.Menu;
import model.comment.Comment;
import model.databaseUtil.Database;
import model.product.Product;

import javax.xml.crypto.Data;
import java.util.HashMap;

public class ShowProductsMenu extends Menu {
    public ShowProductsMenu(String name, Menu parentMenu) {
        super(name, parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getShowProductsInfoMenu());
        submenus.put(2, getAddToCartMenu());
        submenus.put(3, getProductAttributeMenu());
        submenus.put(4, getCompareProductsMenu());
        submenus.put(5, getProductCommentsMenu());
        submenus.put(6, getAddCommentMenu());
        this.setSubmenus(submenus);
    }

    private Menu getShowProductsInfoMenu() {
        return new Menu("Products info", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter yor product id");
            }

            @Override
            public void execute() {
                String id = scanner.nextLine();
                Product product = Database.getProductByProductId(id);
                core.showProductInfo(product);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getAddToCartMenu() {
        return new Menu("Add product to my shopBasket", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter yor product id");
            }

            @Override
            public void execute() {
                String id = scanner.nextLine();
                Product product = Database.getProductByProductId(id);
                core.addProductToShopBasket(product);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getProductAttributeMenu() {
        return new Menu("Product attribute", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter yor product id");
            }

            @Override
            public void execute() {
                String id = scanner.nextLine();
                Product product = Database.getProductByProductId(id);
                core.showProductAttribute(product);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getCompareProductsMenu() {
        return new Menu("Compare menu", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter yor first product id");
            }

            @Override
            public void execute() {
                String firstId = scanner.nextLine();
                Product firstProduct = Database.getProductByProductId(firstId);
                System.out.println("Enter yor second product id");
                String secondId = scanner.nextLine();
                Product secondProduct = Database.getProductByProductId(secondId);
                core.compareProduct(firstProduct, secondProduct);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getProductCommentsMenu() {
        return new Menu("Product comments", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter yor product id");
            }

            @Override
            public void execute() {
                String id = scanner.nextLine();
                Product product = Database.getProductByProductId(id);
                core.showComments(product);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getAddCommentMenu() {
        return new Menu("Add comment for product", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter yor product id");
            }

            @Override
            public void execute() {
                String id = scanner.nextLine();
                Product product = Database.getProductByProductId(id);
                System.out.println("Enter your comment title:");
                String title = scanner.nextLine();
                System.out.println("Enter your comment:");
                String content = scanner.nextLine();
                core.addComment(product, new Comment(title, content));
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }
}
