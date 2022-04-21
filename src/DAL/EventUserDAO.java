package DAL;

import BE.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventUserDAO {

    ConnectionManager cm;

    public EventUserDAO() {
        try {
            cm = new ConnectionManager();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createEventUser(List<EventUser> list) throws SQLException {
        Connection con = cm.getConnection();

        String sql = "INSERT INTO EventCoord (EventId, CoordId) VALUES (?,?)";
        PreparedStatement statement = con.prepareStatement(sql);
        for (EventUser eu : list) {
            statement.setInt(1, eu.getEventID());
            statement.setInt(2, eu.getUserID());
            statement.executeUpdate();
        }
        statement.close();
        con.close();

    }

    public List<EventUser> getAllEventUser() throws SQLException {

        ArrayList<EventUser> eventUser = new ArrayList<>();
        Connection con = cm.getConnection();

        String sql = "SELECT * FROM EventUser;";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            int idEvent = rs.getInt("EventId");
            int idUser = rs.getInt("UserId");
            EventUser eUser = new EventUser(idEvent, idUser);
            eventUser.add(eUser);
        }
        rs.close();
        statement.close();
        con.close();
        return eventUser;
    }


    public EventUser createEventUser(EventUser eventUser) throws SQLException {
        EventUser eventUser1 = null;
        Connection con = cm.getConnection();
        String query = "insert into EventUser (EventId,UserId) values(?,?);";
        PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, eventUser.getEventID());
        ps.setInt(2, eventUser.getUserID());
        ps.execute();
        ResultSet resultSet = ps.getGeneratedKeys();
        while (resultSet.next()) {
            eventUser1.setEventID(eventUser.getEventID());
            eventUser1.setUserID(eventUser.getUserID());
            eventUser1.setId(resultSet.getInt(1));
        }
        resultSet.close();
        ps.close();
        con.close();

        return eventUser1;
    }

    public List<Event> getEventsFromUser (User User) throws SQLException {
        List<Event> eventList = new ArrayList<>();
        Connection con = cm.getConnection();
        String query = "select distinct Event.* from EventUser \n" +
                "JOIN Event on EventUser.EventId=Event.Id\n" +
                "where UserId=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, User.getUserId());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            eventList.add(new Event(
                    rs.getString("EventName"),
                    rs.getString("EventDate"),
                    rs.getString("EventPlace"),
                    rs.getString("EventStartEnding"),
                    rs.getString("EventInfo"),
                    rs.getInt("EventId"))
            );

        }
        rs.close();
        ps.close();
        con.close();
        return eventList;
    }


   /* public void updateEventUser(EventUser eventUser) throws SQLException {
        Connection con = cm.getConnection();
        String sqlUpdateEventCUser = "UPDATE EventUser SET UserId=?, EventId=?, WHERE EventUserId=?;";
        PreparedStatement psUpdateEventUser = con.prepareStatement(sqlUpdateEventUser, Statement.RETURN_GENERATED_KEYS);
        psUpdateEventUser.setInt(1, EventUser.getUserID());
        psUpdateEventUser.setInt(2, EventUser.getEventID());
        psUpdateEventUser.setInt(3,EventUser.getId());
        psUpdateEventUser.executeUpdate();
        psUpdateEventUser.close();
        con.close();
    }*/

    public List<Event> getAllEventsFromUser( User User) throws SQLException {
        return getEventsFromUser(User);
    }

    public List<User> getAllUsersForGivenEvent(Event event) throws SQLException {
        List<User> User = new ArrayList<>();
        Connection con = cm.getConnection();
        String query = "select distinct Users.* from EventCoord \n" +
                "JOIN Users on EventUser.UserID=Users.id\n" +
                "where EventId=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, event.getEventId());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            int id = rs.getInt("id");

            User.add(new User(
                    rs.getString("userName"),
                    rs.getString("userEmail"),
                    rs.getInt("userPhoneNumber"),
                    rs.getInt("userAmountOfTickets"),
                    rs.getString("userTicket"),
                    rs.getInt("userId"))
            );
        }

        rs.close();
        ps.close();
        con.close();
        return User;
    }

    public void addUserToEvent (User user, Event event) throws SQLException {
        List<User> allUsersForGivenEvent = getAllUsersForGivenEvent(event);
        if (allUsersForGivenEvent.contains(user))return;
        createEventUser(new EventUser(user.getUserId(),event.getEventId()));
    }
    public void removeUserFromEvent(User user, Event event) throws SQLException {
        Connection con = cm.getConnection();
        PreparedStatement ps = con.prepareStatement("delete from EventUser where UserId=? and EventId=?");
        ps.setInt(1, user.getUserId());
        ps.setInt(2,event.getEventId());
        ps.executeUpdate();
        ps.close();
        con.close();


    }
}




