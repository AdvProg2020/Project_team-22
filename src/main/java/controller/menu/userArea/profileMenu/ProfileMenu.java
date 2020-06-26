package main.java.controller.menu.userArea.profileMenu;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.java.Main;
import main.java.controller.AlertBox;
import main.java.model.account.Role;

public class ProfileMenu extends Application {
    /*public ProfileMenu (Menu parentMenu) {
        super("Profile menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getProfileInfoMenu());
        submenus.put(2, new EditProfileMenu(this));
        this.setSubmenus(submenus);
    }

    private Menu getProfileInfoMenu() {
        return new Menu("Profile info", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                core.showProfileInfo(core.currentAccount);
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                }
            }
        };
    }
}*/
    Role role1 = null;

    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();
        root.setVgap(5);
        root.setHgap(12);
        root.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.NONE, null, new BorderWidths(10))));
        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(51, 0, 102), null, null);
        Background background = new Background(backgroundFill);
        root.setBackground(background);
        root.setGridLinesVisible(false);
        final int numCols = 3;
        final int numRows = 12;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            root.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            if (i % 2 == 0) {
                rowConst.setMinHeight(30);
                rowConst.setMaxHeight(30);
            } else {
                rowConst.setMinHeight(30);
                rowConst.setMaxHeight(30);
            }

            root.getRowConstraints().add(rowConst);
        }

        Text firstName = new Text("First name");
        root.getChildren().add(firstName);
        firstName.setFill(Color.WHITE);
        firstName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(firstName, HPos.LEFT);
        GridPane.setValignment(firstName, VPos.BOTTOM);
        GridPane.setColumnIndex(firstName, 0);
        GridPane.setRowIndex(firstName, 0);

        Text lastName = new Text("Last name");
        root.getChildren().add(lastName);
        lastName.setFill(Color.WHITE);
        lastName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(lastName, HPos.LEFT);
        GridPane.setValignment(lastName, VPos.BOTTOM);
        GridPane.setColumnIndex(lastName, 0);
        GridPane.setRowIndex(lastName, 2);

        Text email = new Text("E-mail");
        root.getChildren().add(email);
        email.setFill(Color.WHITE);
        email.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(email, HPos.LEFT);
        GridPane.setValignment(email, VPos.BOTTOM);
        GridPane.setColumnIndex(email, 0);
        GridPane.setRowIndex(email, 4);

        Text phone = new Text("Phone");
        root.getChildren().add(phone);
        phone.setFill(Color.WHITE);
        phone.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(phone, HPos.LEFT);
        GridPane.setValignment(phone, VPos.BOTTOM);
        GridPane.setColumnIndex(phone, 0);
        GridPane.setRowIndex(phone, 6);

        Text userName = new Text("User name");
        root.getChildren().add(userName);
        userName.setFill(Color.WHITE);
        userName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(userName, HPos.LEFT);
        GridPane.setValignment(userName, VPos.BOTTOM);
        GridPane.setColumnIndex(userName, 0);
        GridPane.setRowIndex(userName, 8);

        Text lastPassword = new Text("LastPassword");
        root.getChildren().add(lastPassword);
        lastPassword.setFill(Color.WHITE);
        lastPassword.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(lastPassword, HPos.LEFT);
        GridPane.setValignment(lastPassword, VPos.BOTTOM);
        GridPane.setColumnIndex(lastPassword, 0);
        GridPane.setRowIndex(lastPassword, 10);

        Text newPassword = new Text("NewPassword");
        root.getChildren().add(newPassword);
        newPassword.setFill(Color.WHITE);
        newPassword.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(newPassword, HPos.LEFT);
        GridPane.setValignment(newPassword, VPos.BOTTOM);
        GridPane.setColumnIndex(newPassword, 0);
        GridPane.setRowIndex(newPassword, 12);

        Text company = new Text("Company name");
        //root.getChildren().add(company);
        company.setFill(Color.WHITE);
        company.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(company, HPos.LEFT);
        GridPane.setValignment(company, VPos.BOTTOM);
        GridPane.setColumnIndex(company, 1);
        GridPane.setRowIndex(company, 4);

        TextField getCompanyName = new TextField();
        getCompanyName.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
        getCompanyName.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        getCompanyName.setMinHeight(30);
        getCompanyName.setStyle("-fx-text-inner-color: black;");
        getCompanyName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(getCompanyName, HPos.CENTER);
        GridPane.setValignment(getCompanyName, VPos.CENTER);
        GridPane.setColumnIndex(getCompanyName, 1);
        GridPane.setRowIndex(getCompanyName, 5);

        TextField getFirstName = new TextField(Main.core.currentAccount.getFirstName());
        getFirstName.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
        getFirstName.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        getFirstName.setMinHeight(30);
        getFirstName.setStyle("-fx-text-inner-color: black;");
        getFirstName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        root.getChildren().add(getFirstName);
        GridPane.setHalignment(getFirstName, HPos.CENTER);
        GridPane.setValignment(getFirstName, VPos.CENTER);
        GridPane.setColumnIndex(getFirstName, 0);
        GridPane.setRowIndex(getFirstName, 1);

        TextField getLastName = new TextField(Main.core.currentAccount.getLastName());
        getLastName.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
        getLastName.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        getLastName.setMinHeight(30);
        getLastName.setStyle("-fx-text-inner-color: black;");
        getLastName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        //getUserName.setPromptText("User name");
        root.getChildren().add(getLastName);
        GridPane.setHalignment(getLastName, HPos.CENTER);
        GridPane.setValignment(getLastName, VPos.CENTER);
        GridPane.setColumnIndex(getLastName, 0);
        GridPane.setRowIndex(getLastName, 3);

        TextField getEmail = new TextField(Main.core.currentAccount.getEmail());
        getEmail.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
        getEmail.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        getEmail.setMinHeight(30);
        getEmail.setStyle("-fx-text-inner-color: black;");
        getEmail.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        //getUserName.setPromptText("User name");
        root.getChildren().add(getEmail);
        GridPane.setHalignment(getEmail, HPos.CENTER);
        GridPane.setValignment(getEmail, VPos.CENTER);
        GridPane.setColumnIndex(getEmail, 0);
        GridPane.setRowIndex(getEmail, 5);

        TextField getPhone = new TextField(Main.core.currentAccount.getPhone());
        getPhone.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
        getPhone.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        getPhone.setMinHeight(30);
        getPhone.setStyle("-fx-text-inner-color: black;");
        getPhone.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        //getUserName.setPromptText("User name");
        root.getChildren().add(getPhone);
        GridPane.setHalignment(getPhone, HPos.CENTER);
        GridPane.setValignment(getPhone, VPos.CENTER);
        GridPane.setColumnIndex(getPhone, 0);
        GridPane.setRowIndex(getPhone, 7);

        TextField getUsername = new TextField(Main.core.currentAccount.getUsername());
        getUsername.setDisable(true);
        getUsername.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
        getUsername.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        getUsername.setMinHeight(30);
        getUsername.setStyle("-fx-text-inner-color: black;");
        getUsername.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        //getUserName.setPromptText("User name");
        root.getChildren().add(getUsername);
        GridPane.setHalignment(getUsername, HPos.CENTER);
        GridPane.setValignment(getUsername, VPos.CENTER);
        GridPane.setColumnIndex(getUsername, 0);
        GridPane.setRowIndex(getUsername, 9);

        PasswordField getLastPassword = new PasswordField();
        getLastPassword.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
        getLastPassword.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        getLastPassword.setMinHeight(30);
        getLastPassword.setStyle("-fx-text-inner-color: black;");
        getLastPassword.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 15));
        //getPassword.setPromptText("Password");
        root.getChildren().add(getLastPassword);
        GridPane.setHalignment(getLastPassword, HPos.CENTER);
        GridPane.setValignment(getLastPassword, VPos.CENTER);
        GridPane.setColumnIndex(getLastPassword, 0);
        GridPane.setRowIndex(getLastPassword, 11);

        PasswordField getNewPassword = new PasswordField();
        getNewPassword.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
        getNewPassword.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        getNewPassword.setMinHeight(30);
        getNewPassword.setStyle("-fx-text-inner-color: black;");
        getNewPassword.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 15));
        //getPassword.setPromptText("Password");
        root.getChildren().add(getNewPassword);
        GridPane.setHalignment(getNewPassword, HPos.CENTER);
        GridPane.setValignment(getNewPassword, VPos.CENTER);
        GridPane.setColumnIndex(getNewPassword, 0);
        GridPane.setRowIndex(getNewPassword, 13);

        Button confirm = new Button("Confirm");
        confirm.setMinWidth(150);
        confirm.setMinHeight(95);
        confirm.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        confirm.setBackground(new Background(new BackgroundFill(Color.rgb(204, 102, 0), new CornerRadii(8), Insets.EMPTY)));
        confirm.setTextFill(Color.WHITE);
        confirm.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 28));
        root.getChildren().add(confirm);
        GridPane.setHalignment(confirm, HPos.CENTER);
        GridPane.setValignment(confirm, VPos.BOTTOM);
        GridPane.setColumnIndex(confirm, 2);
        GridPane.setRowIndex(confirm, 11);

        ImageView avatar = new ImageView(new Image("file:resources/images/avatar/download.png"));
        avatar.setFitWidth(150);
        avatar.setFitHeight(150);
        root.getChildren().add(avatar);
        GridPane.setHalignment(avatar, HPos.CENTER);
        GridPane.setValignment(avatar, VPos.CENTER);
        GridPane.setColumnIndex(avatar, 2);
        GridPane.setRowIndex(avatar, 3);

        confirm.setOnAction(e -> {
            if (!getFirstName.getText().trim().isEmpty() && !getLastName.getText().trim().isEmpty() && !getPhone.getText().trim().isEmpty() && !getEmail.getText().trim().isEmpty()) {
                String newFirstName = getFirstName.getText();
                String newLastName = getLastName.getText();
                String lastPasswordText = getLastPassword.getText();
                String newPasswordText = getNewPassword.getText();
                String newPhone = getPhone.getText();
                String newEmail = getEmail.getText();
                try {
                    Main.core.changeAccountFirstName(newFirstName);
                    Main.core.changeAccountLastName(newLastName);
                    Main.core.changeAccountPhone(newPhone);
                    Main.core.changeAccountEmail(newEmail);
                    if (!getLastPassword.getText().isEmpty()) {
                        if (getNewPassword.getText().isEmpty())
                            AlertBox.display("changing password", "password can not be empty!");
                        else {
                            Main.core.changeAccountPassword(lastPasswordText, newPasswordText);
                            AlertBox.display("changing profile", "profile successfully changed!");
                            Database.addAllAccountsToDatabaseFile();
                        }
                    }
                } catch (Exception E) {
                    AlertBox.display("changing profile", E.getMessage());
                }
            }
        });

        confirm.setOnMouseEntered(e -> {
            if (!getFirstName.getText().trim().isEmpty() && !getLastName.getText().trim().isEmpty() && !getNewPassword.getText().trim().isEmpty() && !getPhone.getText().trim().isEmpty() && !getUsername.getText().trim().isEmpty() && !getEmail.getText().trim().isEmpty() && !(role1 == null)) {
                confirm.setBorder(new Border(new BorderStroke(Color.rgb(204, 102, 0), BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
                confirm.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
                confirm.setTextFill(Color.rgb(204, 102, 0));
            }
        });

        confirm.setOnMouseExited(e -> {
            confirm.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
            confirm.setBackground(new Background(new BackgroundFill(Color.rgb(204, 102, 0), new CornerRadii(8), Insets.EMPTY)));
            confirm.setTextFill(Color.WHITE);
        });


        Thread checkConfirmButton = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (!getFirstName.getText().trim().isEmpty() && !getLastName.getText().trim().isEmpty() && !getPhone.getText().trim().isEmpty() && !getUsername.getText().trim().isEmpty() && !getEmail.getText().trim().isEmpty()) {
                        confirm.setStyle("-fx-opacity: 1");
                    } else {
                        confirm.setStyle("-fx-opacity: .5");
                    }
                }
            }
        });
        checkConfirmButton.start();

        stage.setOnCloseRequest(e -> {
            checkConfirmButton.stop();
        });

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Profile panel");
        stage.setResizable(false);
        stage.show();
    }
}