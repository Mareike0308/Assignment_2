package GUI.Controller;

import BE.Admin;
import DAL.AdminDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class NewAdminController {
    public TextField newAdminEmail_txt;
    public TextField newAdminPass_txt;
    public TextField newAdminPassConfirmation_txt;
    public Button saveNewAdminBTN;
    public Button cancelAdminBTN;
    AdminDAO adminDAO = new AdminDAO();

    @FXML
    public void initialize() {
    }

    public NewAdminController() throws IOException {
    }

    public void saveNewAdmin(ActionEvent actionEvent) throws Exception {
            String adminEmail = newAdminEmail_txt.getText();
            String adminPassword = newAdminPass_txt.getText();

            Admin adminCreated = new Admin(adminEmail, adminPassword, 0);
            adminDAO.createAdmin(adminCreated);
            Stage stage = (Stage) saveNewAdminBTN.getScene().getWindow();
            stage.close();
        }

    public void cancelAddingAdmin(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Discard changes ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            Stage stage = (Stage) cancelAdminBTN.getScene().getWindow();
            stage.close();
        }
    }



}

