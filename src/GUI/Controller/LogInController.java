package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {


    public void logIn(ActionEvent actionEvent) throws IOException {


       /* FXMLLoader fxmlLoader = new FXMLLoader(LogInController.class.getResource("Admin.View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 567, 326);
        Stage stage = new Stage();
        stage.setTitle("Sign In");
        stage.setScene(scene);
        stage.show(); */
    }

    public void cancelLogin(ActionEvent actionEvent, Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CoordinatorViewController.class.getResource("CoordinatorView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 567, 326);
        stage.setTitle("Sign In");
        stage.setScene(scene);
        stage.show();
    }

    public void cancelLogin(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
