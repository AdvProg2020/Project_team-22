//package main.java.controller.menu.userArea.accessMenu.managerMenu;
//
//import javafx.application.Application;
//import javafx.geometry.HPos;
//import javafx.geometry.Insets;
//import javafx.geometry.VPos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//import main.java.Main;
//import main.java.controller.AlertBox;
//import main.java.controller.menu.Menu;
//import main.java.model.Category;
//import main.java.model.account.Account;
//import main.java.model.databaseUtil.Database;
//
//import java.awt.*;
//import java.util.HashMap;
//
//public class ManageCategories extends Application {
//    @Override
//    public void start(Stage stage) throws Exception {
//        GridPane root = new GridPane();
//        root.setGridLinesVisible(false);
//        final int numCols = 1 ;
//        final int numRows = 10 ;
//        for (int i = 0; i < numCols; i++) {
//            ColumnConstraints colConst = new ColumnConstraints();
//            colConst.setPercentWidth(100.0 / numCols);
//            root.getColumnConstraints().add(colConst);
//        }
//        for (int i = 0; i < numRows; i++) {
//            RowConstraints rowConst = new RowConstraints();
//            rowConst.setPercentHeight(100.0 / numRows);
//            root.getRowConstraints().add(rowConst);
//        }
//
//        Button addCategory = new Button("Add category");
//        addCategory.setMinWidth(220);
//        addCategory.setBorder(new Border(new BorderStroke(Color.DARKGOLDENROD, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
//        addCategory.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
//        addCategory.setTextFill(Color.DARKKHAKI);
//        //userMenuButton.setStyle("-fx-font-weight: bold;");
//        addCategory.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
//        root.getChildren().add(addCategory);
//        GridPane.setHalignment(addCategory, HPos.CENTER);
//        GridPane.setValignment(addCategory, VPos.CENTER);
//        GridPane.setColumnIndex(addCategory, 0);
//        GridPane.setRowIndex(addCategory, 2);
//
//        //score board button
//        Button editCategory = new Button("Edit category");
//        editCategory.setMinWidth(220);
//        editCategory.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
//        editCategory.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
//        editCategory.setTextFill(Color.SALMON);
//        editCategory.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
//        root.getChildren().add(editCategory);
//        GridPane.setHalignment(editCategory, HPos.CENTER);
//        GridPane.setValignment(editCategory, VPos.CENTER);
//        GridPane.setColumnIndex(editCategory, 0);
//        GridPane.setRowIndex(editCategory, 4);
//
//        Button removeCategory = new Button("Remove Category");
//        removeCategory.setMinWidth(220);
//        removeCategory.setBorder(new Border(new BorderStroke(Color.SADDLEBROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
//        removeCategory.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
//        removeCategory.setTextFill(Color.SANDYBROWN);
//        removeCategory.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
//        root.getChildren().add(removeCategory);
//        GridPane.setHalignment(removeCategory, HPos.CENTER);
//        GridPane.setValignment(removeCategory, VPos.CENTER);
//        GridPane.setColumnIndex(removeCategory, 0);
//        GridPane.setRowIndex(removeCategory, 6);
//
//        Button back = new Button("Back");
//        back.setMinWidth(220);
//        back.setBorder(new Border(new BorderStroke(Color.PURPLE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
//        back.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
//        back.setTextFill(Color.MEDIUMPURPLE);
//        back.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
//        root.getChildren().add(back);
//        GridPane.setHalignment(back, HPos.CENTER);
//        GridPane.setValignment(back, VPos.CENTER);
//        GridPane.setColumnIndex(back, 0);
//        GridPane.setRowIndex(back, 8);
//
//        back.setOnAction(e -> {
//            try {
//                new ManagerMenu().start(stage);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        });
//
//
//        editCategory.setOnAction(e -> {
//            try {
//                new Application() {
//                    @Override
//                    public void start(Stage stage) throws Exception {
//                        GridPane root = new GridPane();
//                        root.setGridLinesVisible(false);
//                        final int numCols = 1 ;
//                        final int numRows = 11 ;
//                        for (int i = 0; i < numCols; i++) {
//                            ColumnConstraints colConst = new ColumnConstraints();
//                            colConst.setPercentWidth(100.0 / numCols);
//                            root.getColumnConstraints().add(colConst);
//                        }
//                        for (int i = 0; i < numRows; i++) {
//                            RowConstraints rowConst = new RowConstraints();
//                            rowConst.setPercentHeight(100.0 / numRows);
//                            root.getRowConstraints().add(rowConst);
//                        }
//
//
//                        Text name= new Text("Category name to edit");
//                        root.getChildren().add(name);
//                        name.setFill(Color.BLACK);
//                        name.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                        GridPane.setHalignment(name, HPos.LEFT);
//                        GridPane.setValignment(name, VPos.BOTTOM);
//                        GridPane.setColumnIndex(name, 0);
//                        GridPane.setRowIndex(name, 0);
//
//                        Text newName= new Text("New name");
//                        root.getChildren().add(newName);
//                        newName.setFill(Color.BLACK);
//                        newName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                        GridPane.setHalignment(newName, HPos.LEFT);
//                        GridPane.setValignment(newName, VPos.BOTTOM);
//                        GridPane.setColumnIndex(newName, 0);
//                        GridPane.setRowIndex(newName, 2);
//
//                        TextField getName = new TextField();
//                        getName.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//                        getName.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//                        getName.setMinHeight(30);
//                        getName.setMaxWidth(200);
//                        getName.setStyle("-fx-text-inner-color: black;");
//                        getName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                        root.getChildren().add(getName);
//                        GridPane.setHalignment(getName, HPos.CENTER);
//                        GridPane.setValignment(getName, VPos.CENTER);
//                        GridPane.setColumnIndex(getName, 0);
//                        GridPane.setRowIndex(getName, 1);
//
//                        TextField getNewName = new TextField();
//                        getNewName.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//                        getNewName.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//                        getNewName.setMinHeight(30);
//                        getNewName.setMaxWidth(200);
//                        getNewName.setStyle("-fx-text-inner-color: black;");
//                        getNewName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                        root.getChildren().add(getNewName);
//                        GridPane.setHalignment(getNewName, HPos.CENTER);
//                        GridPane.setValignment(getNewName, VPos.CENTER);
//                        GridPane.setColumnIndex(getNewName, 0);
//                        GridPane.setRowIndex(getNewName, 3);
//
//                        Text property1= new Text("new category properties");
//                        root.getChildren().add(property1);
//                        property1.setFill(Color.BLACK);
//                        property1.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                        GridPane.setHalignment(property1, HPos.LEFT);
//                        GridPane.setValignment(property1, VPos.BOTTOM);
//                        GridPane.setColumnIndex(property1, 0);
//                        GridPane.setRowIndex(property1, 4);
//
//
//                        TextField[] property = new TextField[5];
//                        for(int i = 0; i<5; i++) {
//                            property[i] = new TextField();
//                            property[i].setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//                            property[i].setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//                            property[i].setMinHeight(30);
//                            property[i].setStyle("-fx-text-inner-color: black;");
//                            property[i].setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                            root.getChildren().add(property[i]);
//                            GridPane.setHalignment(property[i], HPos.CENTER);
//                            GridPane.setValignment(property[i], VPos.CENTER);
//                            GridPane.setColumnIndex(property[i], 0);
//                            GridPane.setRowIndex(property[i], 5 + i);
//                        }
//
//
//
//
//                        Button confirm = new Button("Confirm");
//                        confirm.setMinWidth(200);
//                        confirm.setMinHeight(30);
//                        confirm.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//                        confirm.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
//                        confirm.setTextFill(Color.BLACK);
//                        confirm.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                        root.getChildren().add(confirm);
//                        GridPane.setHalignment(confirm, HPos.CENTER);
//                        GridPane.setValignment(confirm, VPos.BOTTOM);
//                        GridPane.setColumnIndex(confirm, 0);
//                        GridPane.setRowIndex(confirm, 10);
//
//
//
//                        confirm.setOnAction(e -> {
//                            if(!getName.getText().trim().isEmpty() && !getNewName.getText().trim().isEmpty()) {
//                                String getNameText = getName.getText();
//                                String getNewNameText = getNewName.getText();
//                                HashMap<Integer, String> pro = new HashMap<>();
//                                for(int i=0; i<5; i++) {
//                                    pro.put(i+1, property[i].getText());
//                                }
//                                try {
//                                    if(Database.getCategoryByName(getNameText) == null) {
//                                        throw new Exception("invalid name");
//                                    }
//                                    Category old = Database.getCategoryByName(getNameText);
//                                    Database.removeCategory(old);
//                                    if(Database.getCategoryByName(getNewNameText) != null) {
//                                        Database.addCategory(old);
//                                        throw new Exception("Category already exists");
//                                    }
//                                    Database.addCategory(new Category(getNewNameText, pro));
//                                    AlertBox.display("Manage category", "category edited");
//                                    stage.close();
//                                } catch (Exception E) {
//                                    AlertBox.display("login", E.getMessage());
//                                }
//                            }
//                        });
//
//
//
//
//                        confirm.setOnMouseEntered(e -> {
//                                confirm.setBackground(new Background(new BackgroundFill(Color.rgb(204, 0, 127), new CornerRadii(5), Insets.EMPTY)));
//                                confirm.setTextFill(Color.WHITE);
//                                confirm.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 13));
//                        });
//
//                        confirm.setOnMouseExited(e -> {
//                            confirm.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
//                            confirm.setTextFill(Color.BLACK);
//                            confirm.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                        });
//
//
//                        Scene scene = new Scene(root, 300, 400);
//                        stage.setScene(scene);
//                        stage.setTitle("online market");
//                        stage.setResizable(false);
//                        stage.show();
//                    }
//                }.start(new Stage());
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        });
//
//
//        removeCategory.setOnAction(e -> {
//            try {
//                new Application() {
//                    @Override
//                    public void start(Stage stage) throws Exception {
//                        GridPane root = new GridPane();
//                        root.setGridLinesVisible(false);
//                        final int numCols = 1 ;
//                        final int numRows = 15 ;
//                        for (int i = 0; i < numCols; i++) {
//                            ColumnConstraints colConst = new ColumnConstraints();
//                            colConst.setPercentWidth(100.0 / numCols);
//                            root.getColumnConstraints().add(colConst);
//                        }
//                        for (int i = 0; i < numRows; i++) {
//                            RowConstraints rowConst = new RowConstraints();
//                            rowConst.setPercentHeight(100.0 / numRows);
//                            root.getRowConstraints().add(rowConst);
//                        }
//
//
//                        Text name= new Text("Enter category name to remove");
//                        root.getChildren().add(name);
//                        name.setFill(Color.BLACK);
//                        name.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                        GridPane.setHalignment(name, HPos.CENTER);
//                        GridPane.setValignment(name, VPos.BOTTOM);
//                        GridPane.setColumnIndex(name, 0);
//                        GridPane.setRowIndex(name, 3);
//
//                        TextField getName = new TextField();
//                        getName.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//                        getName.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//                        getName.setMinHeight(30);
//                        getName.setMaxWidth(200);
//                        getName.setStyle("-fx-text-inner-color: black;");
//                        getName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                        root.getChildren().add(getName);
//                        GridPane.setHalignment(getName, HPos.CENTER);
//                        GridPane.setValignment(getName, VPos.CENTER);
//                        GridPane.setColumnIndex(getName, 0);
//                        GridPane.setRowIndex(getName, 5);
//
//                        Button confirm = new Button("Confirm");
//                        confirm.setMinWidth(200);
//                        confirm.setMinHeight(30);
//                        confirm.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//                        confirm.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
//                        confirm.setTextFill(Color.BLACK);
//                        confirm.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                        root.getChildren().add(confirm);
//                        GridPane.setHalignment(confirm, HPos.CENTER);
//                        GridPane.setValignment(confirm, VPos.BOTTOM);
//                        GridPane.setColumnIndex(confirm, 0);
//                        GridPane.setRowIndex(confirm, 7);
//
//                        confirm.setOnMouseEntered(e -> {
//                            if (!getName.getText().trim().isEmpty()) {
//                                confirm.setBackground(new Background(new BackgroundFill(Color.rgb(204, 0, 127), new CornerRadii(5), Insets.EMPTY)));
//                                confirm.setTextFill(Color.WHITE);
//                                confirm.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 13));
//                            }
//                        });
//
//                        confirm.setOnMouseExited(e -> {
//                            confirm.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
//                            confirm.setTextFill(Color.BLACK);
//                            confirm.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                        });
//
//
//                        confirm.setOnAction(e -> {
//                            if(!getName.getText().trim().isEmpty()) {
//                                String getNameText = getName.getText();
//                                try {
//                                    if(Database.getCategoryByName(getNameText) == null) {
//                                        throw new Exception("Invalid category name");
//                                    }
//                                    Database.removeCategory(Database.getCategoryByName(getNameText));
//                                    AlertBox.display("Manage category", "category removed");
//                                    stage.close();
//                                } catch (Exception E) {
//                                    AlertBox.display("login", E.getMessage());
//                                }
//                            }
//                        });
//
//                        Scene scene = new Scene(root, 300, 400);
//                        stage.setScene(scene);
//                        stage.setTitle("online market");
//                        stage.setResizable(false);
//                        stage.show();
//                    }
//                }.start(new Stage());
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        });
//
//
//        addCategory.setOnAction(e ->{
//            try {
//                new Application() {
//                    @Override
//                    public void start(Stage stage) throws Exception {
//                        GridPane root = new GridPane();
//                        root.setGridLinesVisible(false);
//                        final int numCols = 1 ;
//                        final int numRows = 10 ;
//                        for (int i = 0; i < numCols; i++) {
//                            ColumnConstraints colConst = new ColumnConstraints();
//                            colConst.setPercentWidth(100.0 / numCols);
//                            root.getColumnConstraints().add(colConst);
//                        }
//                        for (int i = 0; i < numRows; i++) {
//                            RowConstraints rowConst = new RowConstraints();
//                            rowConst.setPercentHeight(100.0 / numRows);
//                            root.getRowConstraints().add(rowConst);
//                        }
//
//
//                        Text name= new Text("Category name");
//                        root.getChildren().add(name);
//                        name.setFill(Color.BLACK);
//                        name.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                        GridPane.setHalignment(name, HPos.LEFT);
//                        GridPane.setValignment(name, VPos.BOTTOM);
//                        GridPane.setColumnIndex(name, 0);
//                        GridPane.setRowIndex(name, 0);
//
//                        TextField getName = new TextField();
//                        getName.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//                        getName.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//                        getName.setMinHeight(30);
//                        getName.setMaxWidth(200);
//                        getName.setStyle("-fx-text-inner-color: black;");
//                        getName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                        root.getChildren().add(getName);
//                        GridPane.setHalignment(getName, HPos.CENTER);
//                        GridPane.setValignment(getName, VPos.CENTER);
//                        GridPane.setColumnIndex(getName, 0);
//                        GridPane.setRowIndex(getName, 1);
//
//                        Text property1= new Text("Category properties");
//                        root.getChildren().add(property1);
//                        property1.setFill(Color.BLACK);
//                        property1.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                        GridPane.setHalignment(property1, HPos.LEFT);
//                        GridPane.setValignment(property1, VPos.BOTTOM);
//                        GridPane.setColumnIndex(property1, 0);
//                        GridPane.setRowIndex(property1, 2);
//
//
//                        TextField[] property = new TextField[5];
//                        for(int i = 0; i<5; i++) {
//                            property[i] = new TextField();
//                            property[i].setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//                            property[i].setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//                            property[i].setMinHeight(30);
//                            property[i].setStyle("-fx-text-inner-color: black;");
//                            property[i].setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                            root.getChildren().add(property[i]);
//                            GridPane.setHalignment(property[i], HPos.CENTER);
//                            GridPane.setValignment(property[i], VPos.CENTER);
//                            GridPane.setColumnIndex(property[i], 0);
//                            GridPane.setRowIndex(property[i], 3 + i);
//                        }
//
//
//
//
//                        Button confirm = new Button("Confirm");
//                        confirm.setMinWidth(200);
//                        confirm.setMinHeight(30);
//                        confirm.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//                        confirm.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
//                        confirm.setTextFill(Color.BLACK);
//                        confirm.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                        root.getChildren().add(confirm);
//                        GridPane.setHalignment(confirm, HPos.CENTER);
//                        GridPane.setValignment(confirm, VPos.BOTTOM);
//                        GridPane.setColumnIndex(confirm, 0);
//                        GridPane.setRowIndex(confirm, 8);
//
//
//
//                        confirm.setOnAction(e -> {
//                            if(!getName.getText().trim().isEmpty()) {
//                                String getNameText = getName.getText();
//                                HashMap<Integer, String> pro = new HashMap<>();
//                                for(int i=0; i<5; i++) {
//                                    pro.put(i+1, property[i].getText());
//                                }
//                                try {
//                                    if(Database.getCategoryByName(getNameText) == null) {
//                                        Database.addCategory(new Category(getNameText, pro));
//                                    } else {
//                                        throw new Exception("Category already exists");
//                                    }
//                                    AlertBox.display("Manage category", "category created");
//                                    stage.close();
//                                } catch (Exception E) {
//                                    AlertBox.display("login", E.getMessage());
//                                }
//                            }
//                        });
//
//
//
//
//                        confirm.setOnMouseEntered(e -> {
//                            if (!getName.getText().trim().isEmpty()) {
//                                confirm.setBackground(new Background(new BackgroundFill(Color.rgb(204, 0, 127), new CornerRadii(5), Insets.EMPTY)));
//                                confirm.setTextFill(Color.WHITE);
//                                confirm.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 13));
//                            }
//                        });
//
//                        confirm.setOnMouseExited(e -> {
//                            confirm.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
//                            confirm.setTextFill(Color.BLACK);
//                            confirm.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//                        });
//
//
//                        Scene scene = new Scene(root, 300, 400);
//                        stage.setScene(scene);
//                        stage.setTitle("online market");
//                        stage.setResizable(false);
//                        stage.show();
//                    }
//                }.start(new Stage());
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        });
//
//
//
//
//
//
//        Scene scene = new Scene(root, 300, 400);
//        stage.setScene(scene);
//        stage.setTitle("online market");
//        stage.setResizable(false);
//        stage.show();
//    }
//
//
//
////    public ManageCategories(Menu parentMenu) {
////        super("manage categories", parentMenu);
////        HashMap<Integer, Menu> submenus = new HashMap<>();
////        submenus.put(1, getEditCategoryMenu());
////        submenus.put(2, getAddCategoryMenu());
////        submenus.put(3, getRemoveCategoryMenu());
////        submenus.put(4, getShowCategoriesMenu());
////        this.setSubmenus(submenus);
////
////    }
////
////    private Menu getEditCategoryMenu() {
////        return new Menu("edit category", this) {
////            @Override
////            public void show() {
////                System.out.println(this.getName() + ":\n" + "Enter category name to edit:");
////            }
////
////            @Override
////            public void execute() {
////                String name = scanner.nextLine();
////                try {
////                    core.editCategory(scanner, name);
////                } catch (Exception e) {
////                    System.out.println(e.getMessage());
////                }
////                this.parentMenu.show();
////                this.parentMenu.execute();
////            }
////        };
////    }
////
////
////    private Menu getAddCategoryMenu() {
////        return new Menu("add category", this) {
////            @Override
////            public void show() {
////                System.out.println(this.getName() + ":\n" + "Enter new category information to add:");
////                System.out.println("Enter category name:");
////            }
////            @Override
////            public void execute() {
////                try {
////                    String name = scanner.nextLine();
////                    core.createCategory(name, core.setCategoryProperties(scanner));
////                } catch (Exception e) {
////                    System.out.println(e.getMessage());
////                }
////                this.parentMenu.show();
////                this.parentMenu.execute();
////            }
////        };
////    }
////
////    private Menu getRemoveCategoryMenu() {
////        return new Menu("remove category", this) {
////            @Override
////            public void show() {
////                System.out.println(this.getName() + ":\n" + "Enter category name to remove:");
////            }
////
////            @Override
////            public void execute() {
////                String name = scanner.nextLine();
////                try {
////                    Database.removeCategory(Database.getCategoryByName(name));
////                } catch (Exception e) {
////                    System.out.println(e.getMessage());
////                }
////                this.parentMenu.show();
////                this.parentMenu.execute();
////            }
////        };
////    }
////
////    private Menu getShowCategoriesMenu() {
////        return new Menu("show categories", this) {
////            @Override
////            public void show() {
////                for (Category category : Database.getAllCategories()) {
////                    System.out.println("category name: " + category.getName() + "\nproperties:");
////                    for(Integer num : category.getProperties().keySet()) {
////                        System.out.println(num + ". " + category.getProperties().get(num));
////                    }
////                }
////            }
////
////            @Override
////            public void execute() {
////                this.parentMenu.show();
////                this.parentMenu.execute();
////            }
////        };
////    }
////
////
//
//
//}
