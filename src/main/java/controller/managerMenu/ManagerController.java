package main.java.controller.managerMenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.controller.loginAndRegister.LoginController;
import main.java.controller.mainMenu.MainMenuController;
import main.java.controller.managerMenu.createManager.CreateManagerController;
import main.java.controller.tilesController.*;
import main.java.model.Category;
import main.java.model.account.Account;
import main.java.model.databaseUtil.Database;
import main.java.model.product.Product;
import main.java.model.product.ProductStatus;
import main.java.model.request.OffRequest;
import main.java.model.request.ProductRequest;
import main.java.model.request.Request;

import java.io.IOException;
import java.util.ArrayList;

public class ManagerController {

    @FXML
    private Button users;
    @FXML
    private Button products;
    @FXML
    private Button requests;
    @FXML
    private Button categories;
    @FXML
    private Button discounts;
    @FXML
    private Button addManager;
    @FXML
    private Button advertisements;
    @FXML
    private Button edit;
    @FXML
    private Button addCategory;
    @FXML
    private TilePane tilePane;
    @FXML
    private Label market;
    @FXML
    private ScrollPane scrollPane;

    private Stage stage;
    private ArrayList<Parent> accountTiles = new ArrayList<>();
    private ArrayList<Parent> productTiles = new ArrayList<>();
    private ArrayList<Parent> requestTiles = new ArrayList<>();
    private ArrayList<Parent> categoryTiles = new ArrayList<>();

    public ManagerController(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize(){
        scrollPane.setPadding(new Insets(7, 7, 7, 7));
        tilePane.setVgap(13);
        tilePane.setHgap(13);
        initBack();
        initAccounts();
        initProducts();
        initRequests();
        initCategories();
        initAddManger();
        initAddCategory();
    }


    private void initAddCategory() {
        addCategory.setOnAction(e -> {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/addCategory/AddCategory.fxml"));
            fxmlLoader.setController(new AddCategoryController(stage));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            stage.setScene(new Scene(root, 224, 331));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.show();
        });
    }


    private void initBack() {
        market.setOnMouseClicked(e -> {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/mainMenu/MainMenu.fxml"));
                fxmlLoader.setController(new MainMenuController(stage));
                Parent root = null;
                try {
                    root = fxmlLoader.load();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                stage.setScene(new Scene(root, 947, 537));
                stage.setResizable(false);
                stage.show();
        });
    }



    private void initCategories() {
        categories.setOnAction(e -> {
            tilePane.getChildren().removeAll(categoryTiles);
            tilePane.getChildren().removeAll(requestTiles);
            tilePane.getChildren().removeAll(accountTiles);
            tilePane.getChildren().removeAll(productTiles);
            initAddCategories();
        });
    }

    private void initAddCategories() {
        for(Category category : Database.getAllCategories()){
            initCategoryTile(category);
        }
    }

    public void initCategoryTile(Category category){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource( "/main/java/view/tiles/category/CategoryTile.fxml"));
            CategoryTileController categoryTileController = new CategoryTileController(category, tilePane, false);
            fxmlLoader.setController(categoryTileController);
            Parent root = fxmlLoader.load();
            categoryTileController.setParent(root);
            tilePane.getChildren().add(root) ;
            categoryTiles.add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void initRequests() {
        requests.setOnAction(e -> {
            tilePane.getChildren().removeAll(categoryTiles);
            tilePane.getChildren().removeAll(requestTiles);
            tilePane.getChildren().removeAll(accountTiles);
            tilePane.getChildren().removeAll(productTiles);
            initAddRequests();
        });
    }

    private void initAddRequests() {

        for (ProductRequest productRequest : Database.getAllProductRequests()) {
            initRequestTile((productRequest));
        }
        for (OffRequest offRequest : Database.getAllOffRequests()) {
            initRequestTile(offRequest);
        }
    }

    public void initRequestTile(Request request){
        try {
            Parent root = null;
            FXMLLoader fxmlLoader;
            if(request instanceof ProductRequest) {
                fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/tiles/request/ProductRequestTile.fxml"));
                ProductRequestTileController productRequestTileController = new ProductRequestTileController((ProductRequest) request, tilePane);
                fxmlLoader.setController(productRequestTileController);
                root = fxmlLoader.load();
                productRequestTileController.setParent(root);
            } else if(request instanceof OffRequest) {
                fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/tiles/request/OffRequestTile.fxml"));
                OffRequestTileController offRequestTileController = new OffRequestTileController((OffRequest) request, tilePane, null);
                fxmlLoader.setController(offRequestTileController);
                root = fxmlLoader.load();
                offRequestTileController.setParent(root);
            }
            tilePane.getChildren().add(root) ;
            requestTiles.add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    private void initAccounts() {
        users.setOnAction(e -> {
            tilePane.getChildren().removeAll(categoryTiles);
            tilePane.getChildren().removeAll(requestTiles);
            tilePane.getChildren().removeAll(accountTiles);
            tilePane.getChildren().removeAll(productTiles);
            initAddAccounts();
        });
    }

    private void initAddAccounts() {
        for(Account account : Database.getAllAccounts()){
            initAccountTile( account);
        }
    }

    public void initAccountTile( Account account){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource( "/main/java/view/tiles/account/AccountTile.fxml"));
            AccountTileController accountTileController = new AccountTileController(account, tilePane);
            fxmlLoader.setController(accountTileController);
            Parent root = fxmlLoader.load();
            accountTileController.setParent(root);
            tilePane.getChildren().add(root) ;
            accountTiles.add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initProducts() {
        products.setOnAction(e -> {
            tilePane.getChildren().removeAll(categoryTiles);
            tilePane.getChildren().removeAll(requestTiles);
            tilePane.getChildren().removeAll(accountTiles);
            tilePane.getChildren().removeAll(productTiles);
            initAddProducts();
        });
    }

    private void initAddProducts() {
        for(Product product : Database.getAllProducts()){
            if(product.getProductStatus() == ProductStatus.CONFIRMED) {
                initProductTile( product);
            }
        }
    }

    public void initProductTile( Product product){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource( "/main/java/view/tiles/product/ProductTile.fxml"));
            ProductTileController productTileController = new ProductTileController(product, tilePane, true, true);
            fxmlLoader.setController(productTileController);
            Parent root = fxmlLoader.load();
            productTileController.setParent(root);
            tilePane.getChildren().add(root) ;
            productTiles.add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initAddManger() {
        addManager.setOnAction(e -> {
            //stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/managerMenu/createManager/CreateManager.fxml"));
            Stage stage1 = new Stage();
            fxmlLoader.setController(new CreateManagerController(stage1));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            stage1.setScene(new Scene(root, 823, 462));
            stage1.setResizable(false);
            stage1.show();
        });
    }
}
