package GUI.Controller;

import BE.User;
import BLL.LogicInterface;
import BLL.Manager;
import GUI.Model.EventModel;
import GUI.Model.UserModel;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Button;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ECWindowController {

    public TableView userInfoTable;
    public TableView eventTable;
    @FXML
    private Button createNewEventBTN;

    EventModel eventModel = new EventModel();
    UserModel userModel = new UserModel();
    private final static int EventSelected = 0;
    private int mode = EventSelected;

    public ECWindowController() throws IOException {
    }


    @FXML
    public void initialize() throws SQLException, IOException {

        setUpEventTable();
        setUpUserInfoTable();
        eventTable.setOnMouseClicked(event -> showUsersEventInList());

    }

    public void setUpEventTable() {
        TableColumn<Event, String> column1 = new TableColumn<>("Event List");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        eventTable.getColumns().add(column1);
        try {
            eventTable.getItems().addAll(eventModel.getAllEvents());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void clearListView() {
        userInfoTable.getItems().clear();


    }

    public void showUsersEventInList() {
        clearListView();
        mode = EventSelected;
        BE.Event selectedEvent = (BE.Event) eventTable.getSelectionModel().getSelectedItem();
        try {
            LogicInterface bll = new Manager();
            List<User> users = bll.getUsersFromEvents(selectedEvent);
            userInfoTable.getItems().addAll(users);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setUpUserInfoTable() throws SQLException {
        TableColumn<User, String> column1 = new TableColumn<>("Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("userName"));
        TableColumn<User, String> column2 = new TableColumn<>("Email");
        column2.setCellValueFactory(new PropertyValueFactory<>("userEmail"));
        TableColumn<User, String> column3 = new TableColumn<>("Phone");
        column2.setCellValueFactory(new PropertyValueFactory<>("userPhoneNumber"));
        TableColumn<User, String> column4 = new TableColumn<>("Ticket Amount");
        column2.setCellValueFactory(new PropertyValueFactory<>("userAmountOfTickets"));
        TableColumn<User, String> column5 = new TableColumn<>("Ticket Type");
        column2.setCellValueFactory(new PropertyValueFactory<>("userTicket"));
        userInfoTable.getColumns().clear();
        userInfoTable.getColumns().add(column1);
        userInfoTable.getColumns().add(column2);
        userInfoTable.getColumns().add(column3);
        userInfoTable.getColumns().add(column4);
        userInfoTable.getColumns().add(column5);
        userInfoTable.getItems().clear();
        userInfoTable.getItems().addAll(userModel.getGetAllUsers());
    }


    public void openNewEventWindow(ActionEvent actionEvent) throws IOException {

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
}
