package BLL;

import BE.Admin;
import BE.Coordinator;
import BE.Event;
import BE.User;
import DAL.AdminDAO;
import DAL.CoordinatorDAO;
import DAL.EventDAO;
import DAL.UserDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Manager implements LogicInterface {
    AdminDAO adminDAO = new AdminDAO();
    CoordinatorDAO coordinatorDAO = new CoordinatorDAO();
    EventDAO eventDAO = new EventDAO();
    UserDAO userDAO = new UserDAO();

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
        return null;
    }

    @Override
    public void deleteCoordinator(Coordinator coordinator) throws SQLException {

    }

    @Override
    public void updateCoordinator(Coordinator coordinator) throws SQLException {

    }

    @Override
    public List<Event> getAllEvents() throws SQLException {
        return null;
    }

    @Override
    public Event createEvent(Event event) throws Exception {
        return null;
    }

    @Override
    public void deleteEvent(Event event) throws SQLException {

    }

    @Override
    public void updateEvent(Event event) throws SQLException {

    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return null;
    }

    @Override
    public User createUser(User user) throws Exception {
        return null;
    }

    @Override
    public void deleteUser(User user) throws SQLException {

    }

    @Override
    public void updateUser(User user) throws SQLException {

    }

    @Override
    public List<Coordinator> getMoviesFromCategories(Event event) throws SQLException {
        return null;
    }

    @Override
    public void addCoordinatorToEvent() {

    }

    @Override
    public void removeCoordinatorFromEvent() {

    }
}
