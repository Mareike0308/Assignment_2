package GUI.Controller;

import GUI.Model.AdminModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminViewController {
        public Button createNewUserBTN;
        public Button adminSearchBTN;
        public TextField adminSearchBar;
        public Button addCoordinatorToEventBTN;
        public Button deleteCoordinatorBTN;
        public Button addCoordinatorBTN;
        public Button deleteEventBTN;
        public Button addEventBTN;
        public ListView coordinatorInEventList;
        public Button adminLogOutBTN;
        public TableView eventListTable;
        public TableView coordinatorListTable;
        public TableColumn eventTable;

        public void logOutBtn(ActionEvent actionEvent) throws IOException {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getClassLoader().getResource("GUI/View/MainScreenWindow.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.centerOnScreen();
                stage.show();
        }

        public void addCoordBtn(ActionEvent actionEvent) throws IOException {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getClassLoader().getResource("GUI/View/NewCoordinatorWindow.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setTitle("New Coordinator");
                stage.centerOnScreen();
                stage.show();
        }

        public void createNewUser (ActionEvent actionEvent) throws IOException {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getClassLoader().getResource("GUI/View/NewAdminWindow.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setTitle("New Admin");
                stage.centerOnScreen();
                stage.show();
        }

        public void deleteCoordinator(ActionEvent actionEvent) {
        }

        public void deleteEvent(ActionEvent actionEvent) {
        }

        public void createNewEvent(ActionEvent actionEvent) throws IOException {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getClassLoader().getResource("GUI/View/NewEventWindow.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setTitle("New Event");
                stage.centerOnScreen();
                stage.show();
        }



   /* public void deleteEvent(ActionEvent actionEvent) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete Event ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();
            AdminModel.deleteEvent(eventTable.getSelectionModel().getSelectedItem());
            eventTable.getItems().remove(eventTable.getSelectionModel().getSelectedIndex());
    } */
}

