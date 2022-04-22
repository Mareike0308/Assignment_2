package BLL;

import BE.Admin;
import BE.Coordinator;
import BE.Event;
import BE.User;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface LogicInterface {

    public List<Admin> getAllAdmins() throws SQLException;

    Admin createAdmin(Admin admin) throws Exception;

    public void deleteAdmin(Admin admin) throws SQLException, IOException;

    public void updateAdmin(Admin admin) throws SQLException, IOException;

    public List<Coordinator>  getAllCoordinators() throws SQLException;

    public Coordinator createCoordinator(Coordinator coordinator) throws Exception;

    public void deleteCoordinator(Coordinator coordinator) throws SQLException, IOException;

    public void updateCoordinator(Coordinator coordinator) throws SQLException, IOException;

    public List<Event>  getAllEvents() throws SQLException;

    public Event createEvent(Event event) throws Exception;

    public void deleteEvent(Event event) throws SQLException, IOException;

    public void updateEvent(Event event) throws SQLException, IOException;

    public List<User>  getAllUsers() throws SQLException;

    public User createUser(User user) throws Exception;

    public void deleteUser(User user) throws SQLException, IOException;

    public void updateUser(User user) throws SQLException, IOException;

    public List<Event> getEventFromCoordinator(Coordinator event) throws SQLException;

    public void addCoordinatorToEvent();

    public void removeCoordinatorFromEvent();

    public Admin getAdminLogIn();

    Admin getAdminLogIn(String mail, String pass, Admin admin) throws SQLServerException, IOException;

    List<Coordinator> getCoordinatorFromEvent(Event selectedEvent);

    List<User> getUsersFromEvents(Event event) throws SQLException, IOException;
}