package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {

    public void logIn(ActionEvent actionEvent, Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainScreenController.class.getResource("LogInView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 567, 326);
        stage.setTitle("Sign In");
        stage.setScene(scene);
        stage.show();
    }


}
