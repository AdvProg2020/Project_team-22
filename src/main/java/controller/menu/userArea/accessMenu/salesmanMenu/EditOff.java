//package main.java.controller.menu.userArea.accessMenu.salesmanMenu;
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
//import main.java.model.account.Role;
//import main.java.model.databaseUtil.Database;
//import main.java.model.off.Off;
//import main.java.model.product.Product;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//public class EditOff extends Application {
//    Role role1 = null;
//    Off off;
//
//    public EditOff(Off off) {
//        this.off = off;
//    }
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        GridPane root = new GridPane();
//        root.setVgap(4);
//        root.setHgap(12);
//        root.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.NONE, null, new BorderWidths(10))));
//        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(51, 0, 102), null, null);
//        Background background = new Background(backgroundFill);
//        root.setBackground(background);
//        root.setGridLinesVisible(false);
//        final int numCols = 3;
//        final int numRows = 12;
//        for (int i = 0; i < numCols; i++) {
//            ColumnConstraints colConst = new ColumnConstraints();
//            colConst.setPercentWidth(100.0 / numCols);
//            root.getColumnConstraints().add(colConst);
//        }
//        for (int i = 0; i < numRows; i++) {
//            RowConstraints rowConst = new RowConstraints();
//            if (i % 2 == 0) {
//                rowConst.setMinHeight(30);
//                rowConst.setMaxHeight(30);
//            } else {
//                rowConst.setMinHeight(30);
//                rowConst.setMaxHeight(30);
//            }
//
//            root.getRowConstraints().add(rowConst);
//        }
//
//
//        Text startTimeYear = new Text("Start time: year");
//        root.getChildren().add(startTimeYear);
//        startTimeYear.setFill(Color.WHITE);
//        startTimeYear.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        GridPane.setHalignment(startTimeYear, HPos.LEFT);
//        GridPane.setValignment(startTimeYear, VPos.BOTTOM);
//        GridPane.setColumnIndex(startTimeYear, 0);
//        GridPane.setRowIndex(startTimeYear, 0);
//
//        Text startTimeMonth = new Text("Start time: month");
//        root.getChildren().add(startTimeMonth);
//        startTimeMonth.setFill(Color.WHITE);
//        startTimeMonth.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        GridPane.setHalignment(startTimeMonth, HPos.LEFT);
//        GridPane.setValignment(startTimeMonth, VPos.BOTTOM);
//        GridPane.setColumnIndex(startTimeMonth, 0);
//        GridPane.setRowIndex(startTimeMonth, 2);
//
//        Text startTimeDay = new Text("Start time: day");
//        root.getChildren().add(startTimeDay);
//        startTimeDay.setFill(Color.WHITE);
//        startTimeDay.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        GridPane.setHalignment(startTimeDay, HPos.LEFT);
//        GridPane.setValignment(startTimeDay, VPos.BOTTOM);
//        GridPane.setColumnIndex(startTimeDay, 0);
//        GridPane.setRowIndex(startTimeDay, 4);
//
//        Text endTimeYear = new Text("End time: year");
//        root.getChildren().add(endTimeYear);
//        endTimeYear.setFill(Color.WHITE);
//        endTimeYear.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        GridPane.setHalignment(endTimeYear, HPos.LEFT);
//        GridPane.setValignment(endTimeYear, VPos.BOTTOM);
//        GridPane.setColumnIndex(endTimeYear, 0);
//        GridPane.setRowIndex(endTimeYear, 6);
//
//        Text endTimeMonth = new Text("End time: month");
//        root.getChildren().add(endTimeMonth);
//        endTimeMonth.setFill(Color.WHITE);
//        endTimeMonth.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        GridPane.setHalignment(endTimeMonth, HPos.LEFT);
//        GridPane.setValignment(endTimeMonth, VPos.BOTTOM);
//        GridPane.setColumnIndex(endTimeMonth, 0);
//        GridPane.setRowIndex(endTimeMonth, 8);
//
//        Text endTimeDay = new Text("End time: day");
//        root.getChildren().add(endTimeDay);
//        endTimeDay.setFill(Color.WHITE);
//        endTimeDay.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        GridPane.setHalignment(endTimeDay, HPos.LEFT);
//        GridPane.setValignment(endTimeDay, VPos.BOTTOM);
//        GridPane.setColumnIndex(endTimeDay, 0);
//        GridPane.setRowIndex(endTimeDay, 10);
//
//        Text OffPercent = new Text("Off Percent");
//        root.getChildren().add(OffPercent);
//        OffPercent.setFill(Color.WHITE);
//        OffPercent.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        GridPane.setHalignment(OffPercent, HPos.LEFT);
//        GridPane.setValignment(OffPercent, VPos.BOTTOM);
//        GridPane.setColumnIndex(OffPercent, 0);
//        GridPane.setRowIndex(OffPercent, 12);
//
//        Text productId1 = new Text("Product ID_1");
//        root.getChildren().add(productId1);
//        productId1.setFill(Color.WHITE);
//        productId1.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        GridPane.setHalignment(productId1, HPos.LEFT);
//        GridPane.setValignment(productId1, VPos.BOTTOM);
//        GridPane.setColumnIndex(productId1, 1);
//        GridPane.setRowIndex(productId1, 0);
//
//        Text productId2 = new Text("Product ID_2");
//        root.getChildren().add(productId2);
//        productId2.setFill(Color.WHITE);
//        productId2.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        GridPane.setHalignment(productId2, HPos.LEFT);
//        GridPane.setValignment(productId2, VPos.BOTTOM);
//        GridPane.setColumnIndex(productId2, 1);
//        GridPane.setRowIndex(productId2, 2);
//
//        Text productId3 = new Text("Product ID_3");
//        root.getChildren().add(productId3);
//        productId3.setFill(Color.WHITE);
//        productId3.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        GridPane.setHalignment(productId3, HPos.LEFT);
//        GridPane.setValignment(productId3, VPos.BOTTOM);
//        GridPane.setColumnIndex(productId3, 1);
//        GridPane.setRowIndex(productId3, 4);
//
//        Text productId4 = new Text("Product ID_4");
//        root.getChildren().add(productId4);
//        productId4.setFill(Color.WHITE);
//        productId4.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        GridPane.setHalignment(productId4, HPos.LEFT);
//        GridPane.setValignment(productId4, VPos.BOTTOM);
//        GridPane.setColumnIndex(productId4, 1);
//        GridPane.setRowIndex(productId4, 6);
//
//        Text productId5 = new Text("Product ID_5");
//        root.getChildren().add(productId5);
//        productId5.setFill(Color.WHITE);
//        productId5.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        GridPane.setHalignment(productId5, HPos.LEFT);
//        GridPane.setValignment(productId5, VPos.BOTTOM);
//        GridPane.setColumnIndex(productId5, 1);
//        GridPane.setRowIndex(productId5, 8);
//
//        Text productId6 = new Text("Product ID_6");
//        root.getChildren().add(productId6);
//        productId6.setFill(Color.WHITE);
//        productId6.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        GridPane.setHalignment(productId6, HPos.LEFT);
//        GridPane.setValignment(productId6, VPos.BOTTOM);
//        GridPane.setColumnIndex(productId6, 1);
//        GridPane.setRowIndex(productId6, 10);
//
//        TextField startYear = new TextField("" + off.getStartTime().getYear());
//        startYear.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//        startYear.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//        startYear.setMinHeight(30);
//        startYear.setStyle("-fx-text-inner-color: black;");
//        startYear.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        root.getChildren().add(startYear);
//        GridPane.setHalignment(startYear, HPos.CENTER);
//        GridPane.setValignment(startYear, VPos.CENTER);
//        GridPane.setColumnIndex(startYear, 0);
//        GridPane.setRowIndex(startYear, 1);
//
//        TextField startMonth = new TextField("" + off.getStartTime().getMonthValue());
//        startMonth.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//        startMonth.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//        startMonth.setMinHeight(30);
//        startMonth.setStyle("-fx-text-inner-color: black;");
//        startMonth.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        root.getChildren().add(startMonth);
//        GridPane.setHalignment(startMonth, HPos.CENTER);
//        GridPane.setValignment(startMonth, VPos.CENTER);
//        GridPane.setColumnIndex(startMonth, 0);
//        GridPane.setRowIndex(startMonth, 3);
//
//        TextField startDay = new TextField("" + off.getStartTime().getDayOfMonth());
//        startDay.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//        startDay.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//        startDay.setMinHeight(30);
//        startDay.setStyle("-fx-text-inner-color: black;");
//        startDay.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        root.getChildren().add(startDay);
//        GridPane.setHalignment(startDay, HPos.CENTER);
//        GridPane.setValignment(startDay, VPos.CENTER);
//        GridPane.setColumnIndex(startDay, 0);
//        GridPane.setRowIndex(startDay, 5);
//
//        TextField endYear = new TextField("" + off.getEndTime().getYear());
//        endYear.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//        endYear.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//        endYear.setMinHeight(30);
//        endYear.setStyle("-fx-text-inner-color: black;");
//        endYear.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        root.getChildren().add(endYear);
//        GridPane.setHalignment(endYear, HPos.CENTER);
//        GridPane.setValignment(endYear, VPos.CENTER);
//        GridPane.setColumnIndex(endYear, 0);
//        GridPane.setRowIndex(endYear, 7);
//
//        TextField endMonth = new TextField("" + off.getEndTime().getMonthValue());
//        endMonth.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//        endMonth.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//        endMonth.setMinHeight(30);
//        endMonth.setStyle("-fx-text-inner-color: black;");
//        endMonth.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        root.getChildren().add(endMonth);
//        GridPane.setHalignment(endMonth, HPos.CENTER);
//        GridPane.setValignment(endMonth, VPos.CENTER);
//        GridPane.setColumnIndex(endMonth, 0);
//        GridPane.setRowIndex(endMonth, 9);
//
//        TextField endDay = new TextField("" + off.getEndTime().getDayOfMonth());
//        endDay.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//        endDay.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//        endDay.setMinHeight(30);
//        endDay.setStyle("-fx-text-inner-color: black;");
//        endDay.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        root.getChildren().add(endDay);
//        GridPane.setHalignment(endDay, HPos.CENTER);
//        GridPane.setValignment(endDay, VPos.CENTER);
//        GridPane.setColumnIndex(endDay, 0);
//        GridPane.setRowIndex(endDay, 11);
//
//        TextField offPercent = new TextField("" + off.getDiscountPercent());
//        offPercent.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//        offPercent.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//        offPercent.setMinHeight(30);
//        offPercent.setStyle("-fx-text-inner-color: black;");
//        offPercent.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        root.getChildren().add(offPercent);
//        GridPane.setHalignment(offPercent, HPos.CENTER);
//        GridPane.setValignment(offPercent, VPos.CENTER);
//        GridPane.setColumnIndex(offPercent, 0);
//        GridPane.setRowIndex(offPercent, 13);
//
//        TextField productInOffId1 = new TextField(off.getProductsList().size() > 0 ? off.getProductsList().get(0).getProductId() : "");
//        productInOffId1.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//        productInOffId1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//        productInOffId1.setMinHeight(30);
//        productInOffId1.setStyle("-fx-text-inner-color: black;");
//        productInOffId1.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        root.getChildren().add(productInOffId1);
//        GridPane.setHalignment(productInOffId1, HPos.CENTER);
//        GridPane.setValignment(productInOffId1, VPos.CENTER);
//        GridPane.setColumnIndex(productInOffId1, 1);
//        GridPane.setRowIndex(productInOffId1, 1);
//
//        TextField productInOffId2 = new TextField(off.getProductsList().size() > 1 ? off.getProductsList().get(1).getProductId() : "");
//        productInOffId2.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//        productInOffId2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//        productInOffId2.setMinHeight(30);
//        productInOffId2.setStyle("-fx-text-inner-color: black;");
//        productInOffId2.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        root.getChildren().add(productInOffId2);
//        GridPane.setHalignment(productInOffId2, HPos.CENTER);
//        GridPane.setValignment(productInOffId2, VPos.CENTER);
//        GridPane.setColumnIndex(productInOffId2, 1);
//        GridPane.setRowIndex(productInOffId2, 3);
//
//        TextField productInOffId3 = new TextField(off.getProductsList().size() > 2 ? off.getProductsList().get(2).getProductId() : "");
//        productInOffId3.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//        productInOffId3.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//        productInOffId3.setMinHeight(30);
//        productInOffId3.setStyle("-fx-text-inner-color: black;");
//        productInOffId3.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        root.getChildren().add(productInOffId3);
//        GridPane.setHalignment(productInOffId3, HPos.CENTER);
//        GridPane.setValignment(productInOffId3, VPos.CENTER);
//        GridPane.setColumnIndex(productInOffId3, 1);
//        GridPane.setRowIndex(productInOffId3, 5);
//
//        TextField productInOffId4 = new TextField(off.getProductsList().size() > 3 ? off.getProductsList().get(3).getProductId() : "");
//        productInOffId4.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//        productInOffId4.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//        productInOffId4.setMinHeight(30);
//        productInOffId4.setStyle("-fx-text-inner-color: black;");
//        productInOffId4.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        root.getChildren().add(productInOffId4);
//        GridPane.setHalignment(productInOffId4, HPos.CENTER);
//        GridPane.setValignment(productInOffId4, VPos.CENTER);
//        GridPane.setColumnIndex(productInOffId4, 1);
//        GridPane.setRowIndex(productInOffId4, 7);
//
//        TextField productInOffId5 = new TextField(off.getProductsList().size() > 4 ? off.getProductsList().get(4).getProductId() : "");
//        productInOffId5.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//        productInOffId5.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//        productInOffId5.setMinHeight(30);
//        productInOffId5.setStyle("-fx-text-inner-color: black;");
//        productInOffId5.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        root.getChildren().add(productInOffId5);
//        GridPane.setHalignment(productInOffId5, HPos.CENTER);
//        GridPane.setValignment(productInOffId5, VPos.CENTER);
//        GridPane.setColumnIndex(productInOffId5, 1);
//        GridPane.setRowIndex(productInOffId5, 9);
//
//        TextField productInOffId6 = new TextField(off.getProductsList().size() > 5 ? off.getProductsList().get(5).getProductId() : "");
//        productInOffId6.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
//        productInOffId6.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
//        productInOffId6.setMinHeight(30);
//        productInOffId6.setStyle("-fx-text-inner-color: black;");
//        productInOffId6.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        root.getChildren().add(productInOffId6);
//        GridPane.setHalignment(productInOffId6, HPos.CENTER);
//        GridPane.setValignment(productInOffId6, VPos.CENTER);
//        GridPane.setColumnIndex(productInOffId6, 1);
//        GridPane.setRowIndex(productInOffId6, 11);
//
//
//        Button modifyButton = new Button("Modify");
//        modifyButton.setMinWidth(100);
//        modifyButton.setMinHeight(25);
//        modifyButton.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//        modifyButton.setBackground(new Background(new BackgroundFill(Color.rgb(204, 102, 0), new CornerRadii(8), Insets.EMPTY)));
//        modifyButton.setTextFill(Color.WHITE);
//        modifyButton.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 17));
//        root.getChildren().add(modifyButton);
//        GridPane.setHalignment(modifyButton, HPos.CENTER);
//        GridPane.setValignment(modifyButton, VPos.BOTTOM);
//        GridPane.setColumnIndex(modifyButton, 1);
//        GridPane.setRowIndex(modifyButton, 13);
//
//        modifyButton.setOnAction(e -> {
//            try {
//                if (!startYear.getText().trim().isEmpty() && !startMonth.getText().trim().isEmpty() && !startDay.getText().trim().isEmpty() && !endYear.getText().trim().isEmpty() && !endMonth.getText().trim().isEmpty() && !endDay.getText().trim().isEmpty() && !offPercent.getText().trim().isEmpty() && !startDay.getText().trim().isEmpty()) {
//                    ArrayList<Product> productsList = new ArrayList<>();
//                    if (!productInOffId1.getText().isEmpty()) {
//                        productsList.add(Database.getProductByProductId(productInOffId1.getText()));
//                    }
//                    if (!productInOffId2.getText().isEmpty()) {
//                        productsList.add(Database.getProductByProductId(productInOffId2.getText()));
//                    }
//                    if (!productInOffId3.getText().isEmpty()) {
//                        productsList.add(Database.getProductByProductId(productInOffId3.getText()));
//                    }
//                    if (!productInOffId4.getText().isEmpty()) {
//                        productsList.add(Database.getProductByProductId(productInOffId4.getText()));
//                    }
//                    if (!productInOffId5.getText().isEmpty()) {
//                        productsList.add(Database.getProductByProductId(productInOffId5.getText()));
//                    }
//                    if (!productInOffId6.getText().isEmpty()) {
//                        productsList.add(Database.getProductByProductId(productInOffId6.getText()));
//                    }
//                    off.setProductsList(productsList);
//                    off.setStartTime(LocalDate.of(Integer.parseInt(startYear.getText()), Integer.parseInt(startMonth.getText()), Integer.parseInt(startDay.getText())));
//                    off.setEndTime(LocalDate.of(Integer.parseInt(endYear.getText()), Integer.parseInt(endMonth.getText()), Integer.parseInt(endDay.getText())));
//                    AlertBox.display("Edit off", "off edited successfully");
//                }
//            } catch (NullPointerException ignored) {
//            } catch (Exception exc) {
//                AlertBox.display("Error", exc.getMessage());
//            }
//        });
//
//        modifyButton.setOnMouseEntered(e ->
//
//        {
//            if (!startYear.getText().trim().isEmpty() && !startMonth.getText().trim().isEmpty() && !endYear.getText().trim().isEmpty() && !startDay.getText().trim().isEmpty()) {
//                modifyButton.setBorder(new Border(new BorderStroke(Color.rgb(204, 102, 0), BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//                modifyButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
//                modifyButton.setTextFill(Color.rgb(204, 102, 0));
//            }
//        });
//
//        modifyButton.setOnMouseExited(e ->
//
//        {
//            modifyButton.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//            modifyButton.setBackground(new Background(new BackgroundFill(Color.rgb(204, 102, 0), new CornerRadii(8), Insets.EMPTY)));
//            modifyButton.setTextFill(Color.WHITE);
//        });
//
//
//        Thread checkSellButton = new Thread(new Runnable() {
//            private boolean isCompanySet(TextField getCompanyName) {
//                if (role1 != Role.SALESMAN) {
//                    return true;
//                }
//                if (getCompanyName.getText().trim().isEmpty()) {
//                    return false;
//                }
//                return true;
//            }
//
//            @Override
//            public void run() {
//                while (true) {
//                    if (!startYear.getText().trim().isEmpty() && !startMonth.getText().trim().isEmpty() && !startDay.getText().trim().isEmpty() && !endYear.getText().trim().isEmpty()
//                            && !endMonth.getText().trim().isEmpty() && !endDay.getText().trim().isEmpty() && !offPercent.getText().trim().isEmpty()) {
//                        modifyButton.setStyle("-fx-opacity: 1");
//                    } else {
//                        modifyButton.setStyle("-fx-opacity: .5");
//                    }
//                }
//            }
//        });
//        checkSellButton.start();
//
//
//        stage.setOnCloseRequest(e ->
//
//        {
//            checkSellButton.stop();
//        });
//
//
//        Scene scene = new Scene(root, 500, 600);
//        stage.setScene(scene);
//        stage.setTitle("Create Off");
//        stage.setResizable(false);
//        stage.show();
//    }
//}
//
