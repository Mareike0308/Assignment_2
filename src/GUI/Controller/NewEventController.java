package GUI.Controller;

import BE.Admin;
import BE.Event;
import DAL.EventDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NewEventController {
    public TextField eventName_txt;
    public Button saveEventBTN;
    public TextField eventDate_txt;
    public TextField eventStartEndingTime_txt;
    public TextField eventLocation_txt;
    public TextField eventInfo_txt;
    @FXML
    private Button btnCancelEvent;

    EventDAO eventDAO = new EventDAO();

    public NewEventController() throws IOException {
    }

    public void cancelAddingEvent(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Discard changes ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();


        if (alert.getResult() == ButtonType.YES) {
            Stage stage = (Stage) btnCancelEvent.getScene().getWindow();
            stage.close();
        }
    }

    public void saveNewEvent(ActionEvent actionEvent) throws Exception {

        String eventName = eventName_txt.getText();
        String eventDate = eventDate_txt.getText();
        String eventPlace = eventLocation_txt.getText();
        String eventStartEnding = eventStartEndingTime_txt.getText();
        String eventInfo = eventInfo_txt.getText();

        Event eventCreated = new Event(eventName, eventDate, eventPlace, eventStartEnding, eventInfo,0);
        eventDAO.createEvent(eventCreated);
        Stage stage = (Stage) saveEventBTN.getScene().getWindow();
        stage.close();

    }
}
