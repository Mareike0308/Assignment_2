package GUI.Controller;

import BE.Admin;
import BE.Coordinator;
import DAL.CoordinatorDAO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NewCoordinatorController {
    public TextField newCoordName_txt;
    public TextField newCoordEmail_txt;
    public Button saveNewCoordinatorBTN;
    public TextField newCoordPassword_txt;
    public TextField newCoordPassConfirmation_txt;
    public Button cancelCoordBTN;

    CoordinatorDAO coordinatorDAO = new CoordinatorDAO();

    public NewCoordinatorController() throws IOException {
    }

    public void saveNewCoordinator(ActionEvent actionEvent) throws Exception {
        String coordinatorName = newCoordName_txt.getText();
        String coordinatorEmail = newCoordEmail_txt.getText();
        String coordinatorPassword = newCoordPassword_txt.getText();

        Coordinator coordinatorCreated = new Coordinator(coordinatorName, coordinatorEmail, coordinatorPassword,0);
        coordinatorDAO.createCoordinator(coordinatorCreated);
        Stage stage = (Stage)saveNewCoordinatorBTN.getScene().getWindow();
        stage.close();

    }

    public void cancelAddingCoord(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Discard changes ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            Stage stage = (Stage) cancelCoordBTN.getScene().getWindow();
            stage.close();
        }
    }
}
