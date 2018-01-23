package wangxiz.control;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SidePanelContentController {
    @FXML
    public void initialize() {}

    @FXML
    private void changeColor(ActionEvent event) {
        JFXButton btn = (JFXButton) event.getSource();
        System.out.println(btn.getText());
        FXMLDocumentController.rootP.setStyle("-fx-background-color:" + btn.getText());
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
