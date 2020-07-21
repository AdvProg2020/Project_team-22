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
import javafx.stage.Stage;
import main.java.controller.loginAndRegister.RegisterController;
import main.java.controller.mainMenu.MainMenuController;
import main.java.controller.managerMenu.createManager.CreateManagerController;
import main.java.controller.tilesController.AccountTileController;
import main.java.controller.tilesController.ProductTileController;
import main.java.model.account.Account;
import main.java.model.databaseUtil.Database;
import main.java.model.product.Product;

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
    private TilePane tilePane;
    @FXML
    private Label market;
    @FXML
    private ScrollPane scrollPane;

    private Stage stage;
    private ArrayList<Parent> accountTiles = new ArrayList<>();
    private ArrayList<Parent> productTiles = new ArrayList<>();

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
        initAddManger();
    }



    public void initBack() {
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

    private void initAccounts() {
        users.setOnAction(e -> {
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
            tilePane.getChildren().removeAll(accountTiles);
            tilePane.getChildren().removeAll(productTiles);
            initAddProducts();
        });
    }

    private void initAddProducts() {
        for(Product product : Database.getAllProducts()){
            initProductTile( product);
        }
    }

    public void initProductTile( Product product){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource( "/main/java/view/tiles/product/ProductTile.fxml"));
            ProductTileController productTileController = new ProductTileController(product, tilePane);
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
