package main.java.controller.tilesController;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import main.java.model.account.Account;
import main.java.model.account.Role;
import main.java.model.databaseUtil.Database;

public class AccountTileController {


    @FXML
    private Button done;
    @FXML
    private ComboBox<Role> changeRole;
    @FXML
    private CheckBox remove;
    @FXML
    private Text username;
    @FXML
    private Text role;
    @FXML
    private Text email;
    @FXML
    private AnchorPane pane;
    @FXML
    private TextField company;

    private Account account;
    private TilePane tilePane;
    private Parent parent;

    @FXML
    public void initialize(){
        pane.getChildren().remove(company);
        pane.getChildren().remove(done);
        setProperties();
        initRole();
        initCheck();
        initRemove();
        initEffect();
    }

    public AccountTileController(Account account, TilePane tilePane) {
        this.account = account;
        this.tilePane = tilePane;
    }

    private void initCompanyName() {

    }

    private void setProperties() {
        username.setText(account.getUsername());
        role.setText(account.getRole() + "");
        email.setText(account.getEmail());
    }

    private void initRole() {
        changeRole.getItems().addAll(Role.SALESMAN, Role.CUSTOMER, Role.MANAGER);
        changeRole.valueProperty().addListener((observableValue, preValue, newValue) -> {
            if(newValue == Role.MANAGER) {
                account.setRole(Role.MANAGER);
                role.setText(account.getRole() + "");
                account.setCompanyName(null);
                pane.getChildren().remove(company);
                if(!remove.isSelected()) {
                    pane.getChildren().remove(done);
                }
            } else if(newValue == Role.SALESMAN && account.getRole() != Role.SALESMAN) {
                pane.getChildren().add(company);
                pane.getChildren().add(done);
            } else if(newValue == Role.CUSTOMER) {
                account.setRole(Role.CUSTOMER);
                role.setText(account.getRole() + "");
                account.setCompanyName(null);
                pane.getChildren().remove(company);
                if(!remove.isSelected()) {
                    pane.getChildren().remove(done);
                }
            }
            Database.addAllAccountsToDatabaseFile();
        });

    }

    private void initCheck() {
        remove.setOnAction(e -> {
            if(remove.isSelected() && !pane.getChildren().contains(done)) {
                pane.getChildren().add(done);
            } else if (!pane.getChildren().contains(company)){
                pane.getChildren().remove(done);
            }
        });
    }

    private void initRemove() {
        done.setOnAction(e -> {
            if(remove.isSelected()) {
                tilePane.getChildren().remove(parent);
                try {
                    Database.removeAccount(account);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if(!company.getText().trim().isEmpty()) {
                    account.setRole(Role.SALESMAN);
                    role.setText(account.getRole() + "");
                    account.setCompanyName(company.getText());
                    Database.addAllAccountsToDatabaseFile();
                    pane.getChildren().remove(company);
                    pane.getChildren().remove(done);
                }
            }
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
