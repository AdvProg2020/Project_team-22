package main.java.controller.alertBox;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AlertBoxController {

    private String message;
    private Stage stage;
    @FXML
    private Button close;

    @FXML
    private Text alertMessage;

    @FXML
    public void initialize(){
        initClose();
        initSetMessage();
    }

    public AlertBoxController(String message, Stage stage) {
        this.message = message;
        this.stage = stage;
    }

    private void initClose() {
        close.setOnAction(e -> {
            stage.close();
        });
    }

    private void initSetMessage() {
        alertMessage.setText(message);
    }
}
