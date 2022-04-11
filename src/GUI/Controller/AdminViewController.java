package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminViewController {
        public Button addAdminBTN;
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

        public void addAdminBtn(ActionEvent actionEvent) throws IOException {
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
}

