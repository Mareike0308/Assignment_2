package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class MainScreenController {

    @FXML
    private Button btnEsbjerg;

    @FXML
    private ChoiceBox eventChoiceBox;

    public void logIn(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("GUI/View/LogInView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Sign In");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    public void initialize() throws SQLException, IOException {
        eventChoiceBox.getItems().removeAll(eventChoiceBox.getItems());
        eventChoiceBox.getItems().addAll("Concerts", "Culture", "Humor", "Party", "Sports");



   /* public void openEsbjergFestivalWindow(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("GUI/View/EsbjergFestival.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }*/
    }
}