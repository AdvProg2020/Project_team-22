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
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.Main;
import main.java.controller.alertBox.AlertBoxController;
import main.java.controller.salesmanMenu.EditOffController;
import main.java.controller.salesmanMenu.EditProductController;
import main.java.model.databaseUtil.Database;
import main.java.model.off.Off;
import main.java.model.off.OffStatus;
import main.java.model.request.OffRequest;
import main.java.model.request.Type;

import java.io.IOException;

public class OffRequestTileController {


    @FXML
    private AnchorPane pane;
    @FXML
    private Text percent;
    @FXML
    private Text type;
    @FXML
    private Text start;
    @FXML
    private Text end;
    @FXML
    private Text status;
    @FXML
    private Text salesman;
    @FXML
    private Text st;
    @FXML
    private Text sa;
    @FXML
    private Button accept;
    @FXML
    private Button decline;
    @FXML
    private Button view;


    private OffRequest offRequest;
    private TilePane tilePane;
    private Parent parent;
    private Off change;

    @FXML
    public void initialize() {
        if (change != null) {
            accept.setText("Edit");
            decline.setText("Remove");
            pane.getChildren().remove(status);
            pane.getChildren().remove(salesman);
            pane.getChildren().remove(st);
            pane.getChildren().remove(sa);
        }
        setProperties();
        initAccept();
        initEffect();
        initDecline();
        initShowProducts();
    }

    public OffRequestTileController(OffRequest offRequest, TilePane tilePane, Off change) {
        this.offRequest = offRequest;
        this.tilePane = tilePane;
        this.change = change;
    }

    private void initShowProducts() {
        view.setOnAction(e -> {
            //stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/tiles/request/ViewOffProducts.fxml"));
            Stage stage1 = new Stage();
            if (change == null) {
                fxmlLoader.setController(new TileProducts(offRequest.getOff().getProductsList()));
            } else {
                fxmlLoader.setController(new TileProducts(change.getProductsList()));
            }
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
        if (change == null) {
            type.setText("Off request");
            percent.setText(offRequest.getOff().getDiscountPercent() + "");
            start.setText(offRequest.getOff().getStartTime() + "");
            end.setText(offRequest.getOff().getEndTime() + "");
            status.setText(offRequest.getType() + "");
            salesman.setText(offRequest.getAccount().getUsername());
        } else {
            type.setText("Off");
            percent.setText(change.getDiscountPercent() + "");
            start.setText(change.getStartTime() + "");
            end.setText(change.getEndTime() + "");
        }
    }

    private void initDecline() {
        decline.setOnAction(e -> {
            if (change == null) {
                Database.removeOffRequest(offRequest);
            } else {
                Database.removeOff(change);
            }
            tilePane.getChildren().remove(parent);
            Database.addAllProductsToDatabaseFile();
        });
    }

    private void initAccept() {
        accept.setOnAction(e -> {
            if (change == null) {
                if (offRequest.getType() == Type.ADD) {
                    try {
                        offRequest.getOff().setOffStatus(OffStatus.CONFIRMED);
                        Database.addOff(offRequest.getOff());
                        Database.removeOffRequest(offRequest);
                        tilePane.getChildren().remove(parent);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (offRequest.getType() == Type.EDIT) {
                    try {
                        offRequest.getOff().setOffStatus(OffStatus.CONFIRMED);
                        Database.removeOffRequest(offRequest);
                        tilePane.getChildren().remove(parent);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
                //redirect to edit off controller
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/editOff/EditOff.fxml"));
                EditOffController editOffController = new EditOffController(stage);
                editOffController.setProducts(change.getProductsList());
                editOffController.setOff(change);
                fxmlLoader.setController(editOffController);
                Parent root = null;
                try {
                    root = fxmlLoader.load();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                stage.setScene(new Scene(root, 757, 378));
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                stage.show();
            }
            Database.addAllOffRequestsToDatabaseFile();
            Database.addAllProductsToDatabaseFile();
        });
    }

    private void initEffect() {
        pane.setOnMouseEntered(event -> {
            DropShadow ds = new DropShadow();
            ds.setSpread(0);
            ds.setOffsetY(1.0);
            ds.setOffsetX(1.0);
            ds.setColor(new Color(0.5, 0.5, 0.5, 1.0));
            pane.setEffect(ds);
        });
        pane.setOnMouseExited(event -> {
            pane.setEffect(null);
        });
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    private void display(String message, Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/alertBox/AlertBox.fxml"));
        fxmlLoader.setController(new AlertBoxController(message, stage));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(new Scene(root, 384, 185));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }
}
