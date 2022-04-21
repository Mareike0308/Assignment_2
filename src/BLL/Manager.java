package BLL;

import BE.Admin;
import BE.Coordinator;
import BE.Event;
import BE.User;
import DAL.*;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Manager implements LogicInterface {
    AdminDAO adminDAO = new AdminDAO();
    CoordinatorDAO coordinatorDAO = new CoordinatorDAO();
    EventDAO eventDAO = new EventDAO();
    UserDAO userDAO = new UserDAO();
    EventUserDAO eventUserDAO = new EventUserDAO();

    public Manager() throws IOException {

    }


    @Override
    public List<Admin> getAllAdmins() throws SQLException {
        return null;
    }

    @Override
    public Admin createAdmin(Admin admin) throws Exception {
        return this.adminDAO.createAdmin(admin);
    }

    @Override
    public void deleteAdmin(Admin admin) throws SQLException {
        this.adminDAO.deleteAdmin(admin);
    }

    @Override
    public void updateAdmin(Admin admin) throws SQLException {
        this.adminDAO.updateAdmin(admin);
    }

    @Override
    public List<Coordinator> getAllCoordinators() throws SQLException {
        return null;
    }

    @Override
    public Coordinator createCoordinator(Coordinator coordinator) throws Exception {
        return this.coordinatorDAO.createCoordinator(coordinator);
    }

    @Override
    public void deleteCoordinator(Coordinator coordinator) throws SQLException {
        this.coordinatorDAO.deleteCoordinator(coordinator);
    }

    @Override
    public void updateCoordinator(Coordinator coordinator) throws SQLException {
        this.coordinatorDAO.updateCoordinator(coordinator);
    }

    @Override
    public List<Event> getAllEvents() throws SQLException {
        return null;
    }

    @Override
    public Event createEvent(Event event) throws Exception {
        return this.eventDAO.createEvent(event);
    }

    @Override
    public void deleteEvent(Event event) throws SQLException {
        this.eventDAO.deleteEvent(event);
    }

    @Override
    public void updateEvent(Event event) throws SQLException {
        this.eventDAO.updateEvent(event);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return null;
    }

    @Override
    public User createUser(User user) throws Exception {
        return this.userDAO.createUser(user);
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        this.userDAO.deleteUser(user);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        this.userDAO.updateUser(user);
    }

    @Override
    public List<Event> getEventFromCoordinator(Coordinator event) throws SQLException {
        return null;
    }

    @Override
    public void addCoordinatorToEvent() {

    }

    @Override
    public void removeCoordinatorFromEvent() {

    }

    @Override
    public Admin getAdminLogIn() {
        return null;
    }

    @Override
    public Admin getAdminLogIn(String mail, String pass, Admin admin) throws SQLServerException {
        return this.adminDAO.displayUsers(mail, pass, admin);
    }

    @Override
    public List<Coordinator> getCoordinatorFromEvent(Event selectedEvent) {
        return null;
    }


    @Override
    public List<User> getUsersFromEvents(Event event) throws SQLException {
        return eventUserDAO.getAllUsersForGivenEvent(event);
    }



   /* public void deleteEvent(Event selectedItem) {
        eventDAO.deleteEvent(selectedItem);
    }

    */
}
