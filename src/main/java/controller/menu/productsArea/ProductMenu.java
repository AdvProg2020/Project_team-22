//package main.java.controller.menu.productsArea;
//
//import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.geometry.HPos;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.geometry.VPos;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Line;
//import javafx.scene.text.Font;
//import javafx.scene.text.Text;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//import main.java.model.account.Account;
//import main.java.model.account.Role;
//import main.java.model.comment.Comment;
//import main.java.model.log.Log;
//import main.java.model.product.Product;
//import main.java.model.product.StockStatus;
//
//
//public class ProductMenu extends Application {
//    private Product product;
//    private Account account;
//    private int state = 5;
//
//    public ProductMenu(Product product) {
//        this.product = product;
//    }
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        try {
//            account = new Account("mamali1", "mohammad ali", "khodabandelou", "mamali@gmail.com", "09120149635", "11111111", Role.CUSTOMER);
//            //product = new Product("phone", "samsung", "1000", "mobilephone", "this is a good phone", 10);
////            Comment comment = new Comment("hello", "this is a good phone but it is expensive");
////            comment.setAccount(account);
////            product.addComment(comment);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Pane root = new Pane();
//        root.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.NONE, null, new BorderWidths(15))));
//        root.setBackground(new Background(new BackgroundFill(Color.rgb(192, 192, 192), null, null)));
//        ImageView productImage = new ImageView(new Image("file:resources/images/products/drew-coffman-K1MxhTd6SKo-unsplash.jpg"));
//        productImage.setFitWidth(320);
//        productImage.setFitHeight(220);
//        root.getChildren().add(productImage);
//        productImage.setTranslateX(450);
//        productImage.setTranslateY(35);
//
//        Button buy = new Button("add to shop basket");
//        buy.setMinWidth(320);
//        buy.setMinHeight(45);
//        buy.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//        buy.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(8), Insets.EMPTY)));
//        buy.setTextFill(Color.WHITE);
//        buy.setFont(Font.loadFont("file:resources/fonts/Bignoodletitling-8ojz.ttf", 23));
//        root.getChildren().add(buy);
//        buy.setTranslateX(450);
//        buy.setTranslateY(400);
//
//        Button rate = new Button("Rate");
//        rate.setMinWidth(150);
//        rate.setMinHeight(40);
//        rate.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//        rate.setBackground(new Background(new BackgroundFill(Color.rgb(204, 204, 0), new CornerRadii(8), Insets.EMPTY)));
//        rate.setTextFill(Color.WHITE);
//        rate.setFont(Font.loadFont("file:resources/fonts/Bignoodletitling-8ojz.ttf", 23));
//        root.getChildren().add(rate);
//        rate.setTranslateX(450);
//        rate.setTranslateY(290);
//
//        Button comments = new Button("Comments");
//        comments.setMinWidth(150);
//        comments.setMinHeight(40);
//        comments.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//        comments.setBackground(new Background(new BackgroundFill(Color.rgb(204, 102, 0), new CornerRadii(8), Insets.EMPTY)));
//        comments.setTextFill(Color.WHITE);
//        comments.setFont(Font.loadFont("file:resources/fonts/Bignoodletitling-8ojz.ttf", 23));
//        root.getChildren().add(comments);
//        comments.setTranslateX(620);
//        comments.setTranslateY(290);
//
//        Button addComment = new Button("Add comment");
//        addComment.setMinWidth(100);
//        addComment.setMinHeight(30);
//        addComment.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//        addComment.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(8), Insets.EMPTY)));
//        addComment.setTextFill(Color.WHITE);
//        addComment.setFont(Font.loadFont("file:resources/fonts/Bignoodletitling-8ojz.ttf", 23));
//        root.getChildren().add(addComment);
//        addComment.setTranslateX(550);
//        addComment.setTranslateY(345);
//
//
//
//
//        Text categoryName= new Text("Category:     folan"/* + product.getCategoryName()*/);
//        root.getChildren().add(categoryName);
//        categoryName.setFill(Color.BLACK);
//        categoryName.setFont(Font.loadFont("file:resources/fonts/PlatNomor-WyVnn.ttf", 18));
//        categoryName.setTranslateX(15);
//        categoryName.setTranslateY(50);
////
////        String text = "hello hello hello hello hello hello hello hello hello hello hello hello hello hello hello ";
////        //max line length = 60
////        StringBuilder finalText = new StringBuilder(text);
////        if(finalText.length() > 60) {
////            int enterNums = finalText.length() / 60;
////            for(int i=0; i < enterNums; i++) {
////                finalText.insert((i+1)*60, "\n");
////            }
////        }
//
//        String text = null;
////        for (Integer integer : product.getCategory().getProperties().keySet()) {
////            text += integer + ". " + product.getCategory().getProperties().get(integer) + "\n";
////        }
//
//        Text categoryDescribe= new Text( text /*product.getCategory().getProperties()*/);
//        root.getChildren().add(categoryDescribe);
//        categoryDescribe.maxWidth(300);
//        categoryDescribe.maxHeight(200);
//        categoryDescribe.setFill(Color.BLACK);
//        categoryDescribe.setFont(Font.loadFont("file:resources/fonts/PlatNomor-WyVnn.ttf", 15));
//        categoryDescribe.setTranslateX(15);
//        categoryDescribe.setTranslateY(90);
//
//        Line line = new Line();
//        line.setStartX(10);
//        line.setStartY(200);
//        line.setEndX(410);
//        line.setEndY(200);
//        line.setStrokeWidth(5);
//        line.setStroke(Color.GOLD);
//        root.getChildren().add(line);
//
//        Text name= new Text("Name:     " + product.getName());
//        root.getChildren().add(name);
//        name.maxWidth(300);
//        name.maxHeight(200);
//        name.setFill(Color.BLACK);
//        name.setFont(Font.loadFont("file:resources/fonts/PlatNomor-WyVnn.ttf", 18));
//        name.setTranslateX(15);
//        name.setTranslateY(230);
//
//        Text brand= new Text("Brand:     " + product.getBrand());
//        root.getChildren().add(brand);
//        brand.maxWidth(300);
//        brand.maxHeight(200);
//        brand.setFill(Color.BLACK);
//        brand.setFont(Font.loadFont("file:resources/fonts/PlatNomor-WyVnn.ttf", 18));
//        brand.setTranslateX(15);
//        brand.setTranslateY(265);
//
//        Text price = new Text("Price:     " + product.getPrice() + "$");
//        root.getChildren().add(price);
//        price.maxWidth(300);
//        price.maxHeight(200);
//        price.setFill(Color.BLACK);
//        price.setFont(Font.loadFont("file:resources/fonts/PlatNomor-WyVnn.ttf", 18));
//        price.setTranslateX(15);
//        price.setTranslateY(300);
//
//        Text seller= new Text("Seller:     ");
//        root.getChildren().add(seller);
//        seller.maxWidth(300);
//        seller.maxHeight(200);
//        seller.setFill(Color.BLACK);
//        seller.setFont(Font.loadFont("file:resources/fonts/PlatNomor-WyVnn.ttf", 18));
//        seller.setTranslateX(15);
//        seller.setTranslateY(335);
//
//        Text point= new Text("Average point:     " + product.getAveragePoint());
//        root.getChildren().add(point);
//        point.maxWidth(300);
//        point.maxHeight(200);
//        point.setFill(Color.BLACK);
//        point.setFont(Font.loadFont("file:resources/fonts/PlatNomor-WyVnn.ttf", 18));
//        point.setTranslateX(15);
//        point.setTranslateY(370);
//
//        Text remain= new Text("remained:     " + product.getNumberOfProduct());
//        root.getChildren().add(remain);
//        remain.maxWidth(300);
//        remain.maxHeight(200);
//        remain.setFill(Color.BLACK);
//        remain.setFont(Font.loadFont("file:resources/fonts/PlatNomor-WyVnn.ttf", 18));
//        remain.setTranslateX(15);
//        remain.setTranslateY(405);
//
//        Text description= new Text("Description:" + "\n" + product.getDescription());
//        root.getChildren().add(description);
//        description.maxWidth(300);
//        description.maxHeight(200);
//        description.setFill(Color.BLACK);
//        description.setFont(Font.loadFont("file:resources/fonts/PlatNomor-WyVnn.ttf", 18));
//        description.setTranslateX(15);
//        description.setTranslateY(440);
//
//
//        buy.setOnAction(e -> {
//            if(product.getStockStatus().equals(StockStatus.NOT_AVAILABLE)) {
//                AlertBox.display("Add to shop basket", "this item is not available");
//            } else {
//                account.addProductToShopBasket(product, 1);
//                product.setNumberOfProduct(product.getNumberOfProduct() - 1);
//                if(product.getNumberOfProduct() == 0) {
//                    product.setProductStatus(StockStatus.NOT_AVAILABLE);
//                }
//                AlertBox.display("Add to shop basket", "item added to shop basket");
//                remain.setText("remained:     " + product.getNumberOfProduct());
//            }
//        });
//
//        comments.setOnAction(e -> {
//            showComments();
//        });
//
//        addComment.setOnAction(e -> {
//            addComment();
//        });
//
//        rate.setOnAction(e -> {
//            boolean allowed = true;
//            for (Log log : account.getLogsList()) {
//                if(log.getProductsList().contains(product)) {
//                    allowed = true;
//                    break;
//                }
//            }
//            if(allowed) {
//                rate(point);
//            } else {
//                AlertBox.display("Rate product", "You have not purchased this product");
//            }
//        });
//
//
//
//
//
//        buy.setOnMouseEntered(e -> {
//            buy.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//            buy.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
//            buy.setTextFill(Color.GREEN);
//        });
//        buy.setOnMouseExited(e -> {
//            buy.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//            buy.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(8), Insets.EMPTY)));
//            buy.setTextFill(Color.WHITE);
//        });
//
//        rate.setOnMouseEntered(e -> {
//            rate.setBorder(new Border(new BorderStroke(Color.rgb(204, 204, 0), BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//            rate.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
//            rate.setTextFill(Color.rgb(204, 204, 0));
//        });
//        rate.setOnMouseExited(e -> {
//            rate.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//            rate.setBackground(new Background(new BackgroundFill(Color.rgb(204, 204, 0), new CornerRadii(8), Insets.EMPTY)));
//            rate.setTextFill(Color.WHITE);
//        });
//
//        comments.setOnMouseEntered(e -> {
//            comments.setBorder(new Border(new BorderStroke(Color.rgb(204, 102, 0), BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//            comments.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
//            comments.setTextFill(Color.rgb(204, 102, 0));
//        });
//        comments.setOnMouseExited(e -> {
//            comments.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//            comments.setBackground(new Background(new BackgroundFill(Color.rgb(204, 102, 0), new CornerRadii(8), Insets.EMPTY)));
//            comments.setTextFill(Color.WHITE);
//        });
//
//        addComment.setOnMouseEntered(e -> {
//            addComment.setBorder(new Border(new BorderStroke(Color.LIGHTBLUE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//            addComment.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
//            addComment.setTextFill(Color.LIGHTBLUE);
//        });
//        addComment.setOnMouseExited(e -> {
//            addComment.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//            addComment.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(8), Insets.EMPTY)));
//            addComment.setTextFill(Color.WHITE);
//        });
//
//
//        Scene scene = new Scene(root, 800, 500);
//        stage.setScene(scene);
//        stage.setTitle("online market");
//        stage.setResizable(false);
//        stage.show();
//    }
//
//    public void rate(Text point) {
//        Stage stage = new Stage();
//        stage.initModality(Modality.APPLICATION_MODAL);
//        GridPane root = new GridPane();
//        root.setVgap(20);
//        root.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.NONE, null, new BorderWidths(20))));
//        String path = "ivana-cajina-asuyh-_ZX54-unsplash (1).jpg";
//        BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE , null, null);
//        Background background = new Background(backgroundFill);
//        root.setBackground(background);
//        root.setGridLinesVisible(false);
//        final int numCols = 5 ;
//        final int numRows = 2 ;
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
//        ImageView[] star = new ImageView[5];
//        ImageView[] star2 = new ImageView[5];
//        Button[] rate = new Button[5];
//        for(int i=0; i<5; i++) {
//            star2[i] = new ImageView((new Image("file:resources/images/rate/star2.png")));
//            star2[i].setFitWidth(40);
//            star2[i].setFitHeight(40);
//            star[i] = new ImageView((new Image("file:resources/images/rate/star.png")));
//            star[i].setFitWidth(40);
//            star[i].setFitHeight(40);
//            rate[i] = new Button();
//            rate[i].setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
//            rate[i].setGraphic(star[i]);
//            root.getChildren().add(rate[i]);
//            GridPane.setHalignment(rate[i], HPos.CENTER);
//            GridPane.setValignment(rate[i], VPos.CENTER);
//            GridPane.setColumnIndex(rate[i], i);
//            GridPane.setRowIndex(rate[i], 0);
//        }
//
//
//        rate[4].setOnAction(e -> {
//            if(state != 4) {
//                for(int i=0; i<5; i++) {
//                    rate[i].setGraphic(star2[i]);
//                }
//                state = 4;
//            } else {
//                for(int i=0; i<5; i++) {
//                    rate[i].setGraphic(star[i]);
//                }
//                state = 5;
//            }
//        });
//
//        rate[3].setOnAction(e -> {
//            if(state != 3) {
//                for(int i=0; i<5; i++) {
//                    if(i > 3) {
//                        rate[i].setGraphic(star[i]);
//                    } else {
//                        rate[i].setGraphic(star2[i]);
//                    }
//                }
//                state = 3;
//            } else {
//                for(int i=0; i<4; i++) {
//                    rate[i].setGraphic(star[i]);
//                }
//                state = 5;
//            }
//        });
//
//        rate[2].setOnAction(e -> {
//            if(state != 2) {
//                for(int i=0; i<5; i++) {
//                    if(i > 2) {
//                        rate[i].setGraphic(star[i]);
//                    } else {
//                        rate[i].setGraphic(star2[i]);
//                    }
//                }
//                state = 2;
//            } else {
//                for(int i=0; i<4; i++) {
//                    rate[i].setGraphic(star[i]);
//                }
//                state = 5;
//            }
//        });
//
//        rate[1].setOnAction(e -> {
//            if(state != 1) {
//                for(int i=0; i<5; i++) {
//                    if(i > 1) {
//                        rate[i].setGraphic(star[i]);
//                    } else {
//                        rate[i].setGraphic(star2[i]);
//                    }
//                }
//                state = 1;
//            } else {
//                for(int i=0; i<4; i++) {
//                    rate[i].setGraphic(star[i]);
//                }
//                state = 5;
//            }
//        });
//
//        rate[0].setOnAction(e -> {
//            if(state != 0) {
//                for(int i=0; i<5; i++) {
//                    if(i > 0) {
//                        rate[i].setGraphic(star[i]);
//                    } else {
//                        rate[i].setGraphic(star2[i]);
//                    }
//                }
//                state = 0;
//            } else {
//                for(int i=0; i<4; i++) {
//                    rate[i].setGraphic(star[i]);
//                }
//                state = 5;
//            }
//        });
//
//
//
//        Button ok = new Button("confirm");
//        ok.setMinWidth(150);
//        ok.setMaxHeight(15);
//        ok.setBorder(new Border(new BorderStroke(Color.rgb(153, 0, 0), BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//        ok.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
//        ok.setTextFill(Color.BLACK);
//        ok.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        root.getChildren().add(ok);
//        GridPane.setHalignment(ok, HPos.CENTER);
//        GridPane.setValignment(ok, VPos.CENTER);
//        GridPane.setColumnIndex(ok, 2);
//        GridPane.setRowIndex(ok, 1);
//
//        ok.setOnMouseEntered(e -> {
//            ok.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(8), Insets.EMPTY)));
//            ok.setTextFill(Color.WHITE);
//            ok.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 14));
//        });
//
//        ok.setOnMouseExited(e -> {
//            ok.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
//            ok.setTextFill(Color.BLACK);
//            ok.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        });
//
//        ok.setOnAction(e -> {
//            if(state >= 0 && state <= 4) {
//                product.addPointForProduct(account, state + 1);
//                point.setText("Average point:     " + product.getAveragePoint());
//                stage.close();
//            }
//        });
//
//
//        stage.setScene(new Scene(root, 360, 160));
//        stage.setTitle("Rate");
//        stage.setResizable(false);
//        stage.show();
//    }
//
//    private void addComment() {
//        Stage stage = new Stage();
//        stage.initModality(Modality.APPLICATION_MODAL);
//        GridPane root = new GridPane();
//        root.setVgap(4);
//        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(153, 204, 255) , null, null);
//        Background background = new Background(backgroundFill);
//        root.setBackground(background);
//        root.setGridLinesVisible(false);
//        root.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.NONE, null, new BorderWidths(50))));
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
//        Text title= new Text("Title:");
//        root.getChildren().add(title);
//        title.setFill(Color.BLACK);
//        title.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        GridPane.setHalignment(title, HPos.LEFT);
//        GridPane.setValignment(title, VPos.CENTER);
//        GridPane.setColumnIndex(title, 0);
//        GridPane.setRowIndex(title, 0);
//
//        Text comment = new Text("Comment:");
//        root.getChildren().add(comment);
//        comment.setFill(Color.BLACK);
//        comment.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        GridPane.setHalignment(comment, HPos.LEFT);
//        GridPane.setValignment(comment, VPos.CENTER);
//        GridPane.setColumnIndex(comment, 0);
//        GridPane.setRowIndex(comment, 2);
//
//        TextField getTitle = new TextField();
//        getTitle.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
//        getTitle.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//        getTitle.setMinHeight(30);
//        getTitle.setMinWidth(200);
//        getTitle.setStyle("-fx-text-inner-color: black;");
//        getTitle.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        root.getChildren().add(getTitle);
//        GridPane.setHalignment(getTitle, HPos.CENTER);
//        GridPane.setValignment(getTitle, VPos.CENTER);
//        GridPane.setColumnIndex(getTitle, 0);
//        GridPane.setRowIndex(getTitle, 1);
//
//        TextField getComment = new TextField();
//        getComment.setAlignment(Pos.TOP_LEFT);
//        getComment.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
//        getComment.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//        getComment.setMinHeight(100);
//        getComment.setMinWidth(200);
//        getComment.setStyle("-fx-text-inner-color: black;");
//        getComment.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 15));
//        root.getChildren().add(getComment);
//        GridPane.setHalignment(getComment, HPos.CENTER);
//        GridPane.setValignment(getComment, VPos.CENTER);
//        GridPane.setColumnIndex(getComment, 0);
//        GridPane.setRowIndex(getComment, 4);
//
//        Button register = new Button("add comment");
//        register.setMinWidth(200);
//        register.setMinHeight(30);
//        register.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//        register.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
//        register.setTextFill(Color.BLACK);
//        register.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        root.getChildren().add(register);
//        GridPane.setHalignment(register, HPos.CENTER);
//        GridPane.setValignment(register, VPos.TOP);
//        GridPane.setColumnIndex(register, 0);
//        GridPane.setRowIndex(register, 7);
//
//        register.setOnAction(e -> {
//            Comment comment1 = new Comment(getTitle.getText(), getComment.getText());
//            comment1.setAccount(account);
//            product.addComment(comment1);
//            stage.close();
//        });
//
//        register.setOnMouseEntered(e -> {
//            register.setBackground(new Background(new BackgroundFill(Color.rgb(204, 0, 127), new CornerRadii(5), Insets.EMPTY)));
//            register.setTextFill(Color.WHITE);
//            register.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 13));
//        });
//
//        register.setOnMouseExited(e -> {
//            register.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
//            register.setTextFill(Color.BLACK);
//            register.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
//        });
//
//
//        Scene scene = new Scene(root, 300, 400);
//        stage.setScene(scene);
//        stage.setTitle("online market");
//        stage.setResizable(false);
//        stage.show();
//    }
//
//    private void showComments() {
//        Stage stage = new Stage();
//        TableView<Comment> comments = new TableView<>();
//        stage.initModality(Modality.APPLICATION_MODAL);
//
//
//        //name column
//        TableColumn<Comment, String> name = new TableColumn<>("User name");
//        name.setMinWidth(50);
//        name.setCellValueFactory(new PropertyValueFactory<>("accountUsername"));
//
//        //comment column
//        TableColumn<Comment, String> score = new TableColumn<>("Comment");
//        score.setMinWidth(400);
//        score.setCellValueFactory(new PropertyValueFactory<>("opinionContent"));
//
//        TableColumn<Comment, String> bought = new TableColumn<>("Bought");
//        bought.setMinWidth(20);
//        bought.setCellValueFactory(new PropertyValueFactory<>("hasBought"));
//
//        comments.setItems(getAllComments());
//        comments.getColumns().addAll(name, score, bought);
//        VBox vBox = new VBox();
//        vBox.setFillWidth(true);
//        vBox.getChildren().addAll(comments);
//
//        Scene scene = new Scene(vBox);
//        stage.setScene(scene);
//        stage.setTitle("Comments");
//        stage.show();
//    }
//
//        public ObservableList<Comment> getAllComments() {
//            ObservableList<Comment> comments = FXCollections.observableArrayList();
//            comments.addAll(product.getComments());
//            return comments;
//        }
//    }
//
//
//
////    public ProductMenu(Menu parentMenu) {
////        super("Products Menu", parentMenu);
////        HashMap<Integer, Menu> submenus = new HashMap<>();
////        submenus.put(1, getCategoriesMenu());
////        submenus.put(2, getProductsListMenu());
////        submenus.put(3, getProductSearchMenu());
////        submenus.put(4, new FilteringMenu(this));
////        submenus.put(5, new SortingMenu(this));
////        submenus.put(6, new ShowProductsMenu("Show product menu", this));
////        //submenus.put(7, new RegisterAndLoginAndLogoutMenu(this));
////        this.setSubmenus(submenus);
////    }
////
////    private Menu getProductSearchMenu() {
////        return new Menu("Search the product", this) {
////            @Override
////            public void show() {
////                System.out.println(this.getName() + ":");
////            }
////
////            @Override
////            public void execute() {
////                String input = null;
////                try {
////                    core.showResultOfProductSearch(input);
////                } catch (Exception e) {
////                    System.out.println(e.getMessage());
////                }
////            }
////        };
////    }
////
////    private Menu getProductsListMenu() {
////        return new Menu("Products list", this) {
////            @Override
////            public void show() {
////                System.out.println(this.getName() + ":");
////            }
////
////            @Override
////            public void execute() {
////                core.showProductsList();
////                this.parentMenu.show();
////                this.parentMenu.execute();
////            }
////        };
////    }
////
////    private Menu getCategoriesMenu() {
////        return new Menu("Products categories", this) {
////            @Override
////            public void show() {
////                System.out.println(this.getName() + ":");
////            }
////
////            @Override
////            public void execute() {
////                core.showCategories();
////                this.parentMenu.show();
////                this.parentMenu.execute();
////            }
////        };
////    }
//
