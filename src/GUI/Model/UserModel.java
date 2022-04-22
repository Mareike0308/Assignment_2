package GUI.Model;

import BE.User;
import BLL.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserModel {



    ObservableList<User> getAllUsers;

    public UserModel() throws IOException {
        getAllUsers = FXCollections.observableArrayList();
        setListUser();
    }
    Manager manager = new Manager();


    private void setListUser() {
        //  getAllUsers.setAll(Manager.getAllUsers);
    }



    public void setGetAllUsers(ObservableList<User> getAllUsers) {
        this.getAllUsers = getAllUsers;
    }

    public ObservableList<User> getGetAllUsers() throws SQLException {
        this.getAllUsers = FXCollections.observableArrayList();
        this.getAllUsers.addAll(this.manager.getAllUsers());
        return this.getAllUsers;
    }

}
