package main.java.controller.off;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import main.java.controller.Core;
import main.java.model.databaseUtil.Database;
import main.java.model.off.Off;
import main.java.model.product.Product;

import java.time.LocalDate;


public class OffsTileController {

    @FXML
    private VBox vbox;
    @FXML
    private Label categoryLabel;

    @FXML
    private Label infoLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Button discount;
    @FXML
    private Label remainLabel;
    @FXML
    private Label startLabel;
    @FXML
    private Label endLabel;

    Product product ;
    Core core ;
    Off off ;

    @FXML
    private void initialize(){
        initTile() ;
    }

    public OffsTileController(Product product , Off off) {
        this.product = product ;
        this.core = new Core() ;
        this.off = off ;
    }

    private void initTile() {

        infoLabel.setText( product.getName() + "  " + product.getBrand() );
        if ( product.getCategoryName() != null) {
            categoryLabel.setText( categoryLabel.getText() + product.getCategoryName());
        }
        if( product.getCategoryName() != null &&  product.getCategory() !=null){
            if( product.getCategory().getProperties() != null &&  product.getCategory().getProperties().size() >0 ){
                categoryLabel.setText( categoryLabel.getText() + " - " ) ;
                for( String key : product.getCategory().getProperties().values()){
                    categoryLabel.setText( categoryLabel.getText() + "," + key ) ;
                }
            }
        }
        if( product.getNumberOfProduct() > 0) {

            priceLabel.setText( product.getPrice() + " تومان");
            priceLabel.setStyle( "-fx-text-fill: #0a0a0a") ;
            discount.setVisible(false);
        }else{
            priceLabel.setText( "ناموجود است ");
            priceLabel.setStyle( "-fx-text-fill: #8a8888");
            discount.setVisible(false);
        }
        discount.setText(   "%"+ off.getDiscountPercent()+ "تخفیف ");
        discount.setVisible( true);
        LocalDate sTime = off.getStartTime() ;
        LocalDate eTime = off.getEndTime() ;
        startLabel.setText( startLabel.getText() + sTime.getYear() +"." + sTime.getMonthValue() + "." + sTime.getDayOfMonth());
        endLabel.setText( endLabel.getText() + eTime.getYear() +"." + eTime.getMonthValue() + "." + eTime.getDayOfMonth());
        remainLabel.setText( remainLabel.getText() + remainDay(sTime , eTime) + " روز");
    }

    public int remainDay( LocalDate sTime , LocalDate eTime){
        return (eTime.getYear() - sTime.getYear()) * 365 + ( eTime.getDayOfYear() - sTime.getDayOfYear()) ;
    }

    



}
