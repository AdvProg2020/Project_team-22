package main.java.controller.account.shopBasket;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import main.java.controller.Core;
import main.java.controller.product.ProductsTileController;
import main.java.model.databaseUtil.Database;
import main.java.model.product.Product;

import java.io.IOException;

public class ShopBasketController {
    @FXML
    private VBox vbox;
    @FXML
    private Label totalPriceLabel;
    Core core ;

    @FXML
    public void initialize(){
        addProduct() ;
    }

    public ShopBasketController(Core core) {
        this.core = core;
    }

    private void addProduct() {
        if( core.currentAccount != null) {
            for (Product product : core.currentAccount.getShopBasket()) {
                intiProductTile(product);
            }
        }
        totalPriceLabel.setText( String.valueOf( core.shopBasketTotalPrice()));
    }

    public void intiProductTile( Product product){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource( "/main/java/view/account/shopbasket/ShopProduct.fxml"));
            fxmlLoader.setController(new ShopBasketTileController( product , vbox ,core ));
            Parent root = fxmlLoader.load();
            vbox.getChildren().add( 0 , root) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
