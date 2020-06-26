package main.java.controller.account.shopBasket;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.controller.Core;
import main.java.controller.product.ProductsTileController;
import main.java.model.databaseUtil.Database;
import main.java.model.databaseUtil.DatabaseInitiation;

public class Test extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        DatabaseInitiation.initializeDatabase();
        Core core = new Core() ;
        core.currentAccount = Database.getAllAccounts().get(0) ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource( "/main/java/view/account/shopbasket/ShopBasket.fxml"));
        fxmlLoader.setController(new ShopBasketController(core ));
        Parent root = fxmlLoader.load();


        primaryStage.setScene(new Scene(root, 900
                , 600));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
