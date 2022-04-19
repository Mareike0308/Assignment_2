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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.sql.SQLException;

import static javax.xml.xpath.XPathConstants.NODE;

public class MainScreenController {

    @FXML
    private ImageView event1Img;
    @FXML
    private Button event1Btn;
    @FXML
    private Label event1Lbl;
    @FXML
    private ImageView event2Img;
    @FXML
    private Button event2Btn;
    @FXML
    private Label event2Lbl;
    @FXML
    private ImageView event3Img;
    @FXML
    private Button event3Btn;
    @FXML
    private Label event3Lbl;
    @FXML
    private ImageView event4Img;
    @FXML
    private Button event4Btn;
    @FXML
    private Label event4Lbl;
    @FXML
    private Button btnEsbjerg;
    @FXML
    private ChoiceBox eventChoiceBox;
    private ImageObserver imageObserver;

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

    public void OverBtn1(MouseEvent mouseEvent) {
       event1Lbl.setUnderline(true);
    }

    public void ExitBtn1(MouseEvent mouseEvent) {
        event1Lbl.setUnderline(false);
    }

    public void Btn1Pressed(ActionEvent actionEvent) {
    }


    public void event2Pressed(ActionEvent actionEvent) {
    }

    public void event2Ent(MouseEvent mouseEvent) {
        event2Lbl.setUnderline(true);
    }

    public void event2Exi(MouseEvent mouseEvent) {
        event2Lbl.setUnderline(false);
    }

    public void event3Pressed(ActionEvent actionEvent) {
    }

    public void event3Ent(MouseEvent mouseEvent) {
        event3Lbl.setUnderline(true);
    }

    public void event3Exi(MouseEvent mouseEvent) {
        event3Lbl.setUnderline(false);
    }

    public void event4Pressed(ActionEvent actionEvent) {
    }

    public void event4Ent(MouseEvent mouseEvent) {
        event4Lbl.setUnderline(true);
    }

    public void event4Exi(MouseEvent mouseEvent) {
        event4Lbl.setUnderline(false);
    }
}