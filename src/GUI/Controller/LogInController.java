package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {


    public Button btnCancel;

    public void logIn(ActionEvent actionEvent) {

        /*
        FXMLLoader fxmlLoader = new FXMLLoader(MainScreenController.class.getResource("LogInView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 567, 326);
        stage.setTitle("Sign In");
        stage.setScene(scene);
        stage.show();*/
    }


    public void cancelLogIn(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Cancel Logging in?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        // when closeWindow button is clicked, confirmation window pops up -> user has to confirm if window should be closed

        if (alert.getResult() == ButtonType.YES) {

            Stage stage = (Stage) btnCancel.getScene().getWindow();
            stage.close();
        }
    }
}
