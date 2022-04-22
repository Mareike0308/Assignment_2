package GUI.Model;

import BE.Coordinator;
import BLL.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class CoordinatorModel {



    ObservableList<Coordinator> getAllCoordinators;

    public CoordinatorModel() throws IOException {
        getAllCoordinators = FXCollections.observableArrayList();
        setListCoordinator();
    }
    Manager manager = new Manager();


    private void setListCoordinator() {
        //  getAllCoordinators.setAll(Manager.getAllCoordinators);
    }



    public void setGetAllCoordinators(ObservableList<Coordinator> getAllCoordinators) {
        this.getAllCoordinators = getAllCoordinators;
    }

    public ObservableList<Coordinator> getGetAllCoordinators() throws SQLException {
        this.getAllCoordinators = FXCollections.observableArrayList();
        this.getAllCoordinators.addAll(this.manager.getAllCoordinators());
        return this.getAllCoordinators;
    }

    public void deleteCoordinator(Coordinator selectedItem) throws SQLException, IOException {
        manager.deleteCoordinator(selectedItem);
    }

}
