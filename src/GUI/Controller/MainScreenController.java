package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {

    public ChoiceBox boxChooseEvent;
    public ChoiceBox boxChooseCity;

    @FXML
    private Button btnEsbjerg;

    public void logIn(ActionEvent actionEvent, Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainScreenController.class.getResource("LogInView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 567, 326);
        stage.setTitle("Sign In");
        stage.setScene(scene);
        stage.show();
    }


    public void logIn(ActionEvent actionEvent) {
    }


    public void openEsbjergFestivalWindow(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("GUI/View/EsbjergFestival.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void openWineWindow(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("GUI/View/WineTasting.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void openWeightWindow(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("GUI/View/WeightWindow.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void openLoginWindow(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("GUI/View/LogInView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void initialize() {

        //adds different Categories to the comboBox that the user can choose from
        boxChooseEvent.getItems().removeAll(boxChooseEvent.getItems());
        boxChooseEvent.getItems().addAll("Esbjerg Festival","Exquisite Wine Tasting", "Ivaño on Tour", "Weightlifting Competition");
        boxChooseEvent.getSelectionModel().select("All Events");

        boxChooseCity.getItems().removeAll(boxChooseCity.getItems());
        boxChooseCity.getItems().addAll("Esbjerg","Copenhagen","Aalborg");
        boxChooseCity.getSelectionModel().select("All Cities");
    }
}