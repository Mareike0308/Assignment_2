package GUI.Model;

import BE.Event;
import BLL.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EventModel {

    ObservableList<Event> getAllEvents;


    public EventModel() throws IOException {

        getAllEvents = FXCollections.observableArrayList();
    }
    Manager manager = new Manager();

    public void deleteEvent(Event selectedItem) throws SQLException {
        manager.deleteEvent(selectedItem);
    }



    public void setGetAllEvents(ObservableList<Event> getAllMovies) {
        this.getAllEvents = getAllEvents;
    }


    public List<Event> getAllEvents() throws SQLException, IOException {
        this.getAllEvents = FXCollections.observableArrayList();
        this.getAllEvents.addAll(this.manager.getAllEvents());
        return this.getAllEvents;
    }
}
