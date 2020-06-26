package main.java.controller.menu.userArea;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.Main;
import main.java.controller.AlertBox;
import main.java.model.account.Account;
import main.java.model.databaseUtil.Database;


public class LoginAndLogoutMenu extends Application {

    private RegisterMenu registerMenu = new RegisterMenu();

    @Override
    public void start(Stage stage) throws Exception {
        stage.initModality(Modality.APPLICATION_MODAL);
        GridPane root = new GridPane();
        root.setVgap(4);
        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(153, 204, 255) , null, null);
        Background background = new Background(backgroundFill);
        root.setBackground(background);
        root.setGridLinesVisible(false);
        root.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.NONE, null, new BorderWidths(50))));
        final int numCols = 1 ;
        final int numRows = 10 ;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            root.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            root.getRowConstraints().add(rowConst);
        }

        Text userName= new Text("User name:");
        root.getChildren().add(userName);
        userName.setFill(Color.BLACK);
        userName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(userName, HPos.LEFT);
        GridPane.setValignment(userName, VPos.CENTER);
        GridPane.setColumnIndex(userName, 0);
        GridPane.setRowIndex(userName, 1);

        Text password = new Text("Password:");
        root.getChildren().add(password);
        password.setFill(Color.BLACK);
        password.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(password, HPos.LEFT);
        GridPane.setValignment(password, VPos.CENTER);
        GridPane.setColumnIndex(password, 0);
        GridPane.setRowIndex(password, 3);

        TextField getUserName = new TextField();
        getUserName.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
        getUserName.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        getUserName.setMinHeight(30);
        getUserName.setMinWidth(200);
        getUserName.setStyle("-fx-text-inner-color: black;");
        getUserName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        //getUserName.setPromptText("User name");
        root.getChildren().add(getUserName);
        GridPane.setHalignment(getUserName, HPos.CENTER);
        GridPane.setValignment(getUserName, VPos.CENTER);
        GridPane.setColumnIndex(getUserName, 0);
        GridPane.setRowIndex(getUserName, 2);

        PasswordField getPassword = new PasswordField();
        getPassword.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
        getPassword.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        getPassword.setMinHeight(30);
        getPassword.setMinWidth(200);
        getPassword.setStyle("-fx-text-inner-color: black;");
        getPassword.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 15));
        //getPassword.setPromptText("Password");
        root.getChildren().add(getPassword);
        GridPane.setHalignment(getPassword, HPos.CENTER);
        GridPane.setValignment(getPassword, VPos.CENTER);
        GridPane.setColumnIndex(getPassword, 0);
        GridPane.setRowIndex(getPassword, 4);

        Button login = new Button("Login");
        login.setMinWidth(200);
        login.setMinHeight(30);
        login.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        login.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
        login.setTextFill(Color.BLACK);
        login.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        root.getChildren().add(login);
        GridPane.setHalignment(login, HPos.CENTER);
        GridPane.setValignment(login, VPos.BOTTOM);
        GridPane.setColumnIndex(login, 0);
        GridPane.setRowIndex(login, 6);

        Button register = new Button("Register now");
        register.setMinWidth(200);
        register.setMinHeight(30);
        register.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        register.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
        register.setTextFill(Color.BLACK);
        register.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        root.getChildren().add(register);
        GridPane.setHalignment(register, HPos.CENTER);
        GridPane.setValignment(register, VPos.TOP);
        GridPane.setColumnIndex(register, 0);
        GridPane.setRowIndex(register, 7);

        Button logout = new Button("Logout");
        logout.setMinWidth(200);
        logout.setMinHeight(30);
        logout.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        logout.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
        logout.setTextFill(Color.BLACK);
        logout.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        root.getChildren().add(logout);
        GridPane.setHalignment(logout, HPos.CENTER);
        GridPane.setValignment(logout, VPos.TOP);
        GridPane.setColumnIndex(logout, 0);
        GridPane.setRowIndex(logout, 9);

        login.setOnAction(e -> {
            if(!getPassword.getText().trim().isEmpty() && !getUserName.getText().trim().isEmpty()) {
                String name = getUserName.getText();
                String pass = getPassword.getText();
                try {
                    Account account = Database.getAccountByUsername(name);
                    if(account == null) {
                        throw new Exception("invalid User name");
                    } else if(!account.getPassword().equals(pass)) {
                        throw new Exception("invalid password");
                    }
                    Main.core.setCurrentAccount(account);
                    AlertBox.display("login", "logged in successfully");
                    stage.close();
                } catch (Exception E) {
                    AlertBox.display("login", E.getMessage());
                }
            }
        });

        login.setOnMouseEntered(e -> {
            if (!getPassword.getText().trim().isEmpty() && !getUserName.getText().trim().isEmpty()) {
                login.setBackground(new Background(new BackgroundFill(Color.rgb(204, 0, 127), new CornerRadii(5), Insets.EMPTY)));
                login.setTextFill(Color.WHITE);
                login.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 13));
            }
        });

        login.setOnMouseExited(e -> {
            login.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
            login.setTextFill(Color.BLACK);
            login.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        });

        register.setOnMouseEntered(e -> {
            register.setBackground(new Background(new BackgroundFill(Color.rgb(204, 0, 127), new CornerRadii(5), Insets.EMPTY)));
            register.setTextFill(Color.WHITE);
            register.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 13));
        });

        register.setOnMouseExited(e -> {
            register.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
            register.setTextFill(Color.BLACK);
            register.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        });


        register.setOnAction(e -> {
            stage.close();
            try {
                registerMenu.start(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        logout.setOnAction(e -> {
            if(Main.core.currentAccount != null) {
                Main.core.currentAccount = null;
                AlertBox.display("logout", "you logged out");
            }
        });





        Thread checkButton = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (!getPassword.getText().trim().isEmpty() && !getUserName.getText().trim().isEmpty()) {
                        login.setStyle("-fx-opacity: 1");
                    } else {
                        login.setStyle("-fx-opacity: .5");
                    }
                }
            }
        });
        checkButton.start();

        Thread check = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if(Main.core.getCurrentAccount() == null) {
                        logout.setStyle("-fx-opacity: .5");
                    } else {
                        logout.setStyle("-fx-opacity: 1");
                    }
                }
            }
        });
        check.start();




        stage.setOnCloseRequest(e -> {
            checkButton.stop();
        });

        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene);
        stage.setTitle("online market");
        stage.setResizable(false);
        stage.show();
    }
//    public RegisterAndLoginAndLogoutMenu(Menu parentMenu) {
//        super("Register, login and logout Menu", parentMenu);
//        HashMap<Integer, Menu> submenus = new HashMap<>();
//        submenus.put(1, getRegisterMenu());
//        submenus.put(2, getLoginMenu());
//        submenus.put(3, getLogoutMenu());
//        this.setSubmenus(submenus);
//    }
//
//    private Menu getLoginMenu() {
//        return new Menu("Login", this) {
//            @Override
//            public void show() {
//                System.out.println(this.getName() + ":");
//                System.out.println("Enter Back to return");
//            }
//
//            @Override
//            public void execute() {
//                if (core.currentAccount == null) {
//                    System.out.println("Enter username");
//                    String username = scanner.nextLine();
//                    System.out.println("Enter password");
//                    String password = scanner.nextLine();
//                    core.loginUser(username, password);
//                } else {
//                    System.out.println("\tYou are now logged in!!");
//                }
//                this.parentMenu.show();
//                this.parentMenu.execute();
//
//            }
//        };
//    }
//
//    private Menu getRegisterMenu() {
//        return new Menu("Register", this) {
//            @Override
//            public void show() {
//                System.out.println(this.getName() + ":");
//            }
//
//            @Override
//            public void execute() {
//                if (core.currentAccount == null) {
//                    System.out.println("Enter username");
//                    String username = scanner.nextLine();
//                    System.out.println("Enter password");
//                    String password = scanner.nextLine();
//                    core.registerUser(username, password, scanner);
//                    this.parentMenu.show();
//                    this.parentMenu.execute();
//                } else {
//                    System.out.println("You are logged in. First logout to register");
//                }
//            }
//
//        };
//    }
//
//    private Menu getLogoutMenu() {
//        return new Menu("Logout", this) {
//            @Override
//            public void show() {
//                System.out.println(this.getName() + ":");
//            }
//
//            @Override
//            public void execute() {
//                core.logoutUser();
//                this.parentMenu.show();
//                this.parentMenu.execute();
//            }
//        };
//    }
}
