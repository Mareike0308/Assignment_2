package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class PolicyViewController {
    @FXML
    private javafx.scene.control.Button backBtn;
    public void returnToMain(ActionEvent actionEvent) {
            Stage stage = (Stage) backBtn.getScene().getWindow();
            stage.close();
    }
}
