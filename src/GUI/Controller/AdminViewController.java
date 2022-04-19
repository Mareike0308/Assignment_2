package GUI.Controller;

import BE.Coordinator;
import BE.Event;
import BLL.LogicInterface;
import BLL.Manager;
import GUI.Model.AdminModel;
import GUI.Model.CoordinatorModel;
import GUI.Model.EventModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminViewController {
        public Button createNewUserBTN;
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

        EventModel eventModel = new EventModel();
        CoordinatorModel coordinatorModel= new CoordinatorModel();

        private final ObservableList<Event> dataList = FXCollections.observableArrayList();
        private final ObservableList<Coordinator> dataList2 = FXCollections.observableArrayList();

        private final static int EventSelected = 0;
        private final static int CoordinatorSelected = 1;

        @FXML
        public void initialize() throws SQLException, IOException {

                filter();
                filterCoord();
                setUpEventListTable();
                setUpCoordinatorListTable();
                eventListTable.setOnMouseClicked(event -> showEventCoordinatorsInList());
                coordinatorListTable.setOnMouseClicked(event -> showCoordinatorEventsInList());
        }


        public void setUpEventListTable() {
                TableColumn<Event, String> column1 = new TableColumn<>("Name");
                column1.setCellValueFactory(new PropertyValueFactory<>("eventName"));
        }

        public void setUpCoordinatorListTable() {
                TableColumn<Coordinator, String> column1 = new TableColumn<>("Name");
                column1.setCellValueFactory(new PropertyValueFactory<>("coordinatorName"));
        }


        public AdminViewController() throws IOException {
        }

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

        public void deleteCoordinator(ActionEvent actionEvent) throws SQLException {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete Coordinator ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                alert.showAndWait();
                coordinatorModel.deleteCoordinator((Coordinator) coordinatorListTable.getSelectionModel().getSelectedItem());
                coordinatorListTable.getItems().remove(coordinatorListTable.getSelectionModel().getSelectedItem());
        }

        public void deleteEvent(ActionEvent actionEvent) throws SQLException {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete Event ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                alert.showAndWait();
                eventModel.deleteEvent((Event) eventListTable.getSelectionModel().getSelectedItem());
                eventListTable.getItems().remove(eventListTable.getSelectionModel().getSelectedItem());
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


        public void showEventCoordinatorsInList() {
                clearListView();
                Event selectedEvent = (Event) eventListTable.getSelectionModel().getSelectedItem();
                try {
                        LogicInterface bll = new Manager();
                        List<Coordinator> coordinators = bll.getCoordinatorFromEvent(selectedEvent);
                        coordinatorInEventList.getItems().addAll(coordinators);
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        private void clearListView() {
                coordinatorInEventList.getItems().clear();
        }

        public void showCoordinatorEventsInList() {
                clearListView();
                Coordinator selectedCoordinator = (Coordinator) coordinatorInEventList.getSelectionModel().getSelectedItem();  //get selected category in category table
                try {
                        LogicInterface bll = new Manager();
                        List<Event> events = bll.getEventFromCoordinator(selectedCoordinator);
                        coordinatorInEventList.getItems().addAll(events);
                } catch (IOException | SQLException e) {
                        e.printStackTrace();
                }
        }


        public void addCoordinatorToEvent(ActionEvent actionEvent) {
                System.out.println(eventListTable.getSelectionModel().getSelectedItem());
                coordinatorInEventList.getItems().add(eventListTable.getSelectionModel().getSelectedItem());
        }


       public void filter() throws SQLException, IOException {
                dataList.addAll(eventModel.getAllEvents());
                FilteredList<Event> filteredData = new FilteredList<>(dataList, b -> true);

               adminSearchBar.textProperty().addListener((observable, oldValue, newValue) -> {
                        filteredData.setPredicate(event -> {
                                if (newValue == null || newValue.isEmpty()) {
                                        return true;
                                }
                                String lowerCaseFilter = newValue.toLowerCase();

                                if (event.getEventName().toLowerCase().contains(lowerCaseFilter) )
                                        return true;
                                else
                                        return false;
                        });
                });

                SortedList<Event> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(eventListTable.comparatorProperty());
                eventListTable.setItems(sortedData);
        }

        public void filterCoord() throws SQLException, IOException {

                dataList2.addAll(coordinatorModel.getGetAllCoordinators());
                FilteredList<Coordinator> filteredData = new FilteredList<>(dataList2, b -> true);

                adminSearchBar.textProperty().addListener((observable, oldValue, newValue) -> {
                        filteredData.setPredicate(coordinator -> {
                                if (newValue == null || newValue.isEmpty()) {
                                        return true;
                                }
                                String lowerCaseFilter = newValue.toLowerCase();

                                if (coordinator.getCoordinatorName().toLowerCase().contains(lowerCaseFilter) )
                                        return true;
                                else
                                        return false;

                        });
                });

                SortedList<Coordinator> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(coordinatorListTable.comparatorProperty());
                coordinatorListTable.setItems(sortedData);
        }

   /* public void deleteEvent(ActionEvent actionEvent) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete Event ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();
            AdminModel.deleteEvent(eventTable.getSelectionModel().getSelectedItem());
            eventTable.getItems().remove(eventTable.getSelectionModel().getSelectedIndex());
    } */
}

