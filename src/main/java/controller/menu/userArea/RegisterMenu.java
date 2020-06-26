package main.java.controller.menu.userArea;

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
import main.java.controller.AlertBox;
import main.java.model.account.Account;
import main.java.model.account.Role;


public class RegisterMenu extends Application {

    Role role1 = null;

    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();
        root.setVgap(4);
        root.setHgap(12);
        root.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.NONE, null, new BorderWidths(10))));
        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(51, 0, 102) , null, null);
        Background background = new Background(backgroundFill);
        root.setBackground(background);
        root.setGridLinesVisible(false);
        final int numCols = 3 ;
        final int numRows = 12 ;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            root.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            if(i%2==0) {
                rowConst.setMinHeight(30);
                rowConst.setMaxHeight(30);
            } else {
                rowConst.setMinHeight(30);
                rowConst.setMaxHeight(30);
            }

            root.getRowConstraints().add(rowConst);
        }


        Text firstName= new Text("First name");
        root.getChildren().add(firstName);
        firstName.setFill(Color.WHITE);
        firstName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(firstName, HPos.LEFT);
        GridPane.setValignment(firstName, VPos.BOTTOM);
        GridPane.setColumnIndex(firstName, 0);
        GridPane.setRowIndex(firstName, 0);

        Text lastName= new Text("Last name");
        root.getChildren().add(lastName);
        lastName.setFill(Color.WHITE);
        lastName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(lastName, HPos.LEFT);
        GridPane.setValignment(lastName, VPos.BOTTOM);
        GridPane.setColumnIndex(lastName, 0);
        GridPane.setRowIndex(lastName, 2);

        Text email= new Text("E-mail");
        root.getChildren().add(email);
        email.setFill(Color.WHITE);
        email.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(email, HPos.LEFT);
        GridPane.setValignment(email, VPos.BOTTOM);
        GridPane.setColumnIndex(email, 0);
        GridPane.setRowIndex(email, 4);

        Text phone= new Text("Phone");
        root.getChildren().add(phone);
        phone.setFill(Color.WHITE);
        phone.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(phone, HPos.LEFT);
        GridPane.setValignment(phone, VPos.BOTTOM);
        GridPane.setColumnIndex(phone, 0);
        GridPane.setRowIndex(phone, 6);

        Text userName= new Text("User name");
        root.getChildren().add(userName);
        userName.setFill(Color.WHITE);
        userName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(userName, HPos.LEFT);
        GridPane.setValignment(userName, VPos.BOTTOM);
        GridPane.setColumnIndex(userName, 0);
        GridPane.setRowIndex(userName, 8);

        Text password= new Text("Password");
        root.getChildren().add(password);
        password.setFill(Color.WHITE);
        password.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(password, HPos.LEFT);
        GridPane.setValignment(password, VPos.BOTTOM);
        GridPane.setColumnIndex(password, 0);
        GridPane.setRowIndex(password, 10);

        Text role= new Text("Role");
        root.getChildren().add(role);
        role.setFill(Color.WHITE);
        role.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(role, HPos.LEFT);
        GridPane.setValignment(role, VPos.BOTTOM);
        GridPane.setColumnIndex(role, 1);
        GridPane.setRowIndex(role, 0);

        Text company= new Text("Company name");
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

        TextField getFirstName = new TextField();
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

        TextField getLastName = new TextField();
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

        TextField getEmail = new TextField();
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

        TextField getPhone = new TextField();
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

        TextField getUsername = new TextField();
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

        PasswordField getPassword = new PasswordField();
        getPassword.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
        getPassword.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        getPassword.setMinHeight(30);
        getPassword.setStyle("-fx-text-inner-color: black;");
        getPassword.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 15));
        //getPassword.setPromptText("Password");
        root.getChildren().add(getPassword);
        GridPane.setHalignment(getPassword, HPos.CENTER);
        GridPane.setValignment(getPassword, VPos.CENTER);
        GridPane.setColumnIndex(getPassword, 0);
        GridPane.setRowIndex(getPassword, 11);

        Button register = new Button("Register");
        register.setMinWidth(200);
        register.setMinHeight(50);
        register.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        register.setBackground(new Background(new BackgroundFill(Color.rgb(204, 102, 0), new CornerRadii(8), Insets.EMPTY)));
        register.setTextFill(Color.WHITE);
        register.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 17));
        root.getChildren().add(register);
        GridPane.setHalignment(register, HPos.CENTER);
        GridPane.setValignment(register, VPos.BOTTOM);
        GridPane.setColumnIndex(register, 2);
        GridPane.setRowIndex(register, 11);

        Button manager = new Button("Manager");
        manager.setMinWidth(200);
        manager.setMinHeight(30);
        manager.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        manager.setBackground(new Background(new BackgroundFill(Color.rgb(153, 0, 153), new CornerRadii(8), Insets.EMPTY)));
        manager.setTextFill(Color.WHITE);
        manager.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        root.getChildren().add(manager);
        GridPane.setHalignment(manager, HPos.CENTER);
        GridPane.setValignment(manager, VPos.TOP);
        GridPane.setColumnIndex(manager, 1);
        GridPane.setRowIndex(manager, 1);

        Button customer = new Button("Customer");
        customer.setMinWidth(200);
        customer.setMinHeight(30);
        customer.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        customer.setBackground(new Background(new BackgroundFill(Color.rgb(153, 0, 153), new CornerRadii(8), Insets.EMPTY)));
        customer.setTextFill(Color.WHITE);
        customer.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        root.getChildren().add(customer);
        GridPane.setHalignment(customer, HPos.CENTER);
        GridPane.setValignment(customer, VPos.CENTER);
        GridPane.setColumnIndex(customer, 1);
        GridPane.setRowIndex(customer, 2);

        Button salesman = new Button("Salesman");
        salesman.setMinWidth(200);
        salesman.setMinHeight(30);
        salesman.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        salesman.setBackground(new Background(new BackgroundFill(Color.rgb(153, 0, 153), new CornerRadii(8), Insets.EMPTY)));
        salesman.setTextFill(Color.WHITE);
        salesman.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        root.getChildren().add(salesman);
        GridPane.setHalignment(salesman, HPos.CENTER);
        GridPane.setValignment(salesman, VPos.BOTTOM);
        GridPane.setColumnIndex(salesman, 1);
        GridPane.setRowIndex(salesman, 3);


        ImageView avatar = new ImageView(new Image("file:resources/images/avatar/download.png"));
        avatar.setFitWidth(200);
        avatar.setFitHeight(200);
        root.getChildren().add(avatar);
        GridPane.setHalignment(avatar, HPos.CENTER);
        GridPane.setValignment(avatar, VPos.CENTER);
        GridPane.setColumnIndex(avatar, 2);
        GridPane.setRowIndex(avatar, 3);


        //add another condition
        manager.setOnAction(e -> {
            if(role1 == Role.MANAGER) {
                role1 = null;
                manager.setStyle("-fx-opacity: 1");
            } else {
                role1 = Role.MANAGER;
                salesman.setStyle("-fx-opacity: 1");
                customer.setStyle("-fx-opacity: 1");
                manager.setStyle("-fx-opacity: .5");
                root.getChildren().remove(company);
                root.getChildren().remove(getCompanyName);
            }
        });

        customer.setOnAction(e -> {
            if(role1 == Role.CUSTOMER) {
                role1 = null;
                customer.setStyle("-fx-opacity: 1");
            } else {
                role1 = Role.CUSTOMER;
                manager.setStyle("-fx-opacity: 1");
                salesman.setStyle("-fx-opacity: 1");
                customer.setStyle("-fx-opacity: .5");
                root.getChildren().remove(company);
                root.getChildren().remove(getCompanyName);
            }
        });

        salesman.setOnAction(e -> {
            if(role1 == Role.SALESMAN) {
                role1 = null;
                getCompanyName.clear();
                root.getChildren().remove(company);
                root.getChildren().remove(getCompanyName);
                salesman.setStyle("-fx-opacity: 1");
            } else  {
                root.getChildren().add(company);
                root.getChildren().add(getCompanyName);
                role1 = Role.SALESMAN;
                manager.setStyle("-fx-opacity: 1");
                salesman.setStyle("-fx-opacity: .5");
                customer.setStyle("-fx-opacity: 1");
            }
        });



        register.setOnAction(e -> {
            if(!getFirstName.getText().trim().isEmpty() && !getLastName.getText().trim().isEmpty() && !getPassword.getText().trim().isEmpty() && !getPhone.getText().trim().isEmpty() && !getUsername.getText().trim().isEmpty() && !getEmail.getText().trim().isEmpty() && !(role1 == null) && isCompanySet(getCompanyName)) {
                String fName = getFirstName.getText();
                String lName = getLastName.getText();
                String uName = getUsername.getText();
                String pass = getPassword.getText();
                String pNum = getPhone.getText();
                String Email = getEmail.getText();
                Role fRole = role1;
                try {
                    if(role1 == Role.SALESMAN) {
                        Database.addAccount(new Account(uName, fName, lName, Email, pNum, pass, fRole, getCompanyName.getText()));
                    } else {
                        Database.addAccount(new Account(uName, fName, lName, Email, pNum, pass, fRole));
                    }
                    AlertBox.display("register", "successfully registered!");
                } catch (Exception E) {
                    AlertBox.display("register", E.getMessage());
                }
            }
        });

        register.setOnMouseEntered(e -> {
            if(!getFirstName.getText().trim().isEmpty() && !getLastName.getText().trim().isEmpty() && !getPassword.getText().trim().isEmpty() && !getPhone.getText().trim().isEmpty() && !getUsername.getText().trim().isEmpty() && !getEmail.getText().trim().isEmpty() && !(role1 == null) && isCompanySet(getCompanyName)) {
                register.setBorder(new Border(new BorderStroke(Color.rgb(204, 102, 0), BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
                register.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
                register.setTextFill(Color.rgb(204, 102, 0));
            }
        });

        register.setOnMouseExited(e -> {
            register.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
            register.setBackground(new Background(new BackgroundFill(Color.rgb(204, 102, 0), new CornerRadii(8), Insets.EMPTY)));
            register.setTextFill(Color.WHITE);
        });

        customer.setOnMouseEntered(e -> {
            customer.setBorder(new Border(new BorderStroke(Color.rgb(153, 0, 153), BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
            customer.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
            customer.setTextFill(Color.rgb(153, 0, 153));
        });

        customer.setOnMouseExited(e -> {
            customer.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
            customer.setBackground(new Background(new BackgroundFill(Color.rgb(153, 0, 153), new CornerRadii(8), Insets.EMPTY)));
            customer.setTextFill(Color.WHITE);
        });

        salesman.setOnMouseEntered(e -> {
            salesman.setBorder(new Border(new BorderStroke(Color.rgb(153, 0, 153), BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
            salesman.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
            salesman.setTextFill(Color.rgb(153, 0, 153));
        });

        salesman.setOnMouseExited(e -> {
            salesman.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
            salesman.setBackground(new Background(new BackgroundFill(Color.rgb(153, 0, 153), new CornerRadii(8), Insets.EMPTY)));
            salesman.setTextFill(Color.WHITE);
        });

        manager.setOnMouseEntered(e -> {
            manager.setBorder(new Border(new BorderStroke(Color.rgb(153, 0, 153), BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
            manager.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
            manager.setTextFill(Color.rgb(153, 0, 153));
        });

        manager.setOnMouseExited(e -> {
            manager.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
            manager.setBackground(new Background(new BackgroundFill(Color.rgb(153, 0, 153), new CornerRadii(8), Insets.EMPTY)));
            manager.setTextFill(Color.WHITE);
        });




        Thread checkRegisterButton = new Thread(new Runnable() {
            private boolean isCompanySet(TextField getCompanyName) {
                if(role1 != Role.SALESMAN) {
                    return true;
                }
                if(getCompanyName.getText().trim().isEmpty()) {
                    return false;
                }
                return true;
            }
            @Override
            public void run() {
                while (true) {
                    if(!getFirstName.getText().trim().isEmpty() && !getLastName.getText().trim().isEmpty() && !getPassword.getText().trim().isEmpty() && !getPhone.getText().trim().isEmpty() && !getUsername.getText().trim().isEmpty() && !getEmail.getText().trim().isEmpty() && !(role1 == null) && isCompanySet(getCompanyName)) {
                        register.setStyle("-fx-opacity: 1");
                    } else {
                        register.setStyle("-fx-opacity: .5");
                    }
                }
            }
        });
        checkRegisterButton.start();


       stage.setOnCloseRequest(e -> {
           checkRegisterButton.stop();
       });



        Scene scene = new Scene(root, 700, 430);
        stage.setScene(scene);
        stage.setTitle("online market");
        stage.setResizable(false);
        stage.show();
    }

    private boolean isCompanySet(TextField getCompanyName) {
        if(role1 != Role.SALESMAN) {
            return true;
        }
        if(getCompanyName.getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }
}
