package main.java.controller.account.shopBasket;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import main.java.controller.Core;
import main.java.model.product.Product;

public class ShopBasketTileController {
    @FXML
    private Label nameLabel;
    @FXML
    private GridPane gride;
    @FXML
    private Button increasor;
    @FXML
    private Button countLabel;
    @FXML
    private Button decreasor;
    @FXML
    private Label priceLabel;
    Product product ;
    Core core ;
    VBox parentVbox ;

    @FXML
    private void initialize(){
        intiProductTile() ;
        initDecreasor() ;
        initIncreasor() ;
    }

    public ShopBasketTileController(Product product , VBox parentVbox , Core core ) {
        this.product = product ;
        this.core = core ;
        this.parentVbox = parentVbox ;
    }

    public void intiProductTile(){
        priceLabel.setText( String.valueOf(product.getPrice()));
        countLabel.setText("1");
        nameLabel.setText( product.getName());

    }
    private void initDecreasor() {
        decreasor.setOnMousePressed( event -> {
            int num =  Integer.valueOf(countLabel.getText()) ;
            if(  num == 0 ){
                parentVbox.getChildren().remove( gride);
            } else{
                num-- ;
                countLabel.setText( String.valueOf( num));
            }

        });
    }
    private void initIncreasor() {
        increasor.setOnMousePressed( event -> {
            int num =  Integer.valueOf(countLabel.getText()) ;
            if(  num < product.getNumberOfProduct()){
                num++ ;
                countLabel.setText( String.valueOf( num));
            }
        });
    }

}
