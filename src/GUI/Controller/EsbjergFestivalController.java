package GUI.Controller;


import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.util.Duration;

import javax.print.DocFlavor;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class EsbjergFestivalController<JFXButton> implements Initializable {

    @FXML
    Label EsbjergLbl;
    @FXML
    private JFXButton btn;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(20));
        transition.setNode((Node) btn);

        transition.setToX(-600);
        transition.setToX(300);

        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.play();

    }


}
