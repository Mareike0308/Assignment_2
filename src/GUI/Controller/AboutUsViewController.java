package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.awt.*;

public class AboutUsViewController {
    @FXML
    private javafx.scene.control.Button backBtn;

    public void returnToMain(ActionEvent actionEvent) {
            Stage stage = (Stage) backBtn.getScene().getWindow();
            stage.close();
    }
}
