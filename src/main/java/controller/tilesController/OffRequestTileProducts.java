package main.java.controller.tilesController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.java.model.product.Product;
import main.java.model.request.OffRequest;

public class OffRequestTileProducts {


    private OffRequest offRequest;

    @FXML
    private TableView<Product> table;
    @FXML
    private TableColumn<Product, String> name;
    @FXML
    private TableColumn<Product, String> brand;
    @FXML
    private TableColumn<Product, Integer> price;
    @FXML
    private TableColumn<Product, String> company;
    @FXML
    private TableColumn<Product, String> salesman;
    @FXML
    private TableColumn<Product, String> category;
    @FXML
    private TableColumn<Product, Double> point;

    public OffRequestTileProducts(OffRequest offRequest) {
        this.offRequest = offRequest;
    }

    @FXML
    public void initialize(){
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        company.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        salesman.setCellValueFactory(new PropertyValueFactory<>("salesmanName"));
        category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        point.setCellValueFactory(new PropertyValueFactory<>("averagePoint"));
        table.setItems(getProducts());
        table.getColumns().addAll(name, brand, price, company, salesman, category, point);
    }



    public ObservableList<Product> getProducts() {
        ObservableList<Product> players = FXCollections.observableArrayList();
        players.addAll(offRequest.getOff().getProductsList());
        return players;
    }
}
