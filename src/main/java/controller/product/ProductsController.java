package main.java.controller.product;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import main.java.model.product.Product;

import java.io.IOException;

public class ProductsController {

    @FXML
    private TilePane tilePane;

    @FXML
    public void initialize(){
        addProduct() ;
    }

    private void addProduct() {

        for(Product product : Database.getAllProducts()){
            intiProductTile( product);
        }
    }

    public void intiProductTile( Product product){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/ProductsTile.fxml"));

            fxmlLoader.setController(new ProductsTileController( product));
            Parent root = fxmlLoader.load();
            root.setOnMouseEntered(event -> {
                DropShadow ds = new DropShadow();
                ds.setSpread(0);
                ds.setOffsetY(1.0);
                ds.setOffsetX(1.0);
                ds.setColor( new Color(0.5 ,0.5 , 0.5 , 1.0));
                root.setEffect( ds);
            });
            root.setOnMouseExited( event -> {
                root.setEffect(null);
            });
            root.setOnMousePressed(event -> {
                     ////////////////////////// load a product  //////////////////////////////////////////////
            });
            tilePane.getChildren().add(root) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
