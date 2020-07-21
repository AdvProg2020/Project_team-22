package main.java.controller.tilesController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.java.controller.managerMenu.createManager.CreateManagerController;
import main.java.model.databaseUtil.Database;
import main.java.model.off.OffStatus;
import main.java.model.product.ProductStatus;
import main.java.model.request.OffRequest;
import main.java.model.request.ProductRequest;
import main.java.model.request.Type;

import java.io.IOException;

public class OffRequestTileController {


    @FXML
    private AnchorPane pane;
    @FXML
    private Text percent;
    @FXML
    private Text start;
    @FXML
    private Text end;
    @FXML
    private Text status;
    @FXML
    private Text salesman;
    @FXML
    private Button accept;
    @FXML
    private Button decline;
    @FXML
    private Button view;


    private OffRequest offRequest;
    private TilePane tilePane;
    private Parent parent;

    @FXML
    public void initialize(){
        setProperties();
        initAccept();
        initEffect();
        initDecline();
        initShowProducts();
    }

    public OffRequestTileController(OffRequest offRequest, TilePane tilePane) {
        this.offRequest = offRequest;
        this.tilePane = tilePane;
    }

    private void initShowProducts() {
        view.setOnAction(e -> {
            //stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/tiles/request/ProductRequestTile.fxml"));
            Stage stage1 = new Stage();
            fxmlLoader.setController(new OffRequestTileProducts(offRequest));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            stage1.setScene(new Scene(root, 672, 400));
            stage1.setResizable(false);
            stage1.show();
        });
    }

    private void setProperties() {
        percent.setText(offRequest.getOff().getDiscountPercent() +"");
        start.setText(offRequest.getOff().getStartTime() + "");
        end.setText(offRequest.getOff().getEndTime() + "");
        status.setText(offRequest.getType() + "");
        salesman.setText(offRequest.getAccount().getUsername());
    }

    private void initDecline() {
        decline.setOnAction(e -> {
            Database.removeRequest(offRequest);
            tilePane.getChildren().remove(parent);
            Database.addAllProductsToDatabaseFile();
        });
    }

    private void initAccept() {
        accept.setOnAction(e -> {
            if(offRequest.getType() == Type.ADD) {
                try {
                    offRequest.getOff().setOffStatus(OffStatus.CONFIRMED);
                    Database.addOff(offRequest.getOff());
                    Database.removeRequest(offRequest);
                    tilePane.getChildren().remove(parent);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if(offRequest.getType() == Type.EDIT) {
                try {
                    offRequest.getOff().setOffStatus(OffStatus.CONFIRMED);
                    Database.removeRequest(offRequest);
                    tilePane.getChildren().remove(parent);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            Database.addAllRequestsToDatabaseFile();
            Database.addAllProductsToDatabaseFile();
        });
    }

    private void initEffect() {
        pane.setOnMouseEntered(event -> {
            DropShadow ds = new DropShadow();
            ds.setSpread(0);
            ds.setOffsetY(1.0);
            ds.setOffsetX(1.0);
            ds.setColor( new Color(0.5 ,0.5 , 0.5 , 1.0));
            pane.setEffect( ds);
        });
        pane.setOnMouseExited( event -> {
            pane.setEffect(null);
        });
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
