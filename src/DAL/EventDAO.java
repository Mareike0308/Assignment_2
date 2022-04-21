package DAL;

import BE.Event;
import BE.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {


    private static ConnectionManager cm;


    public EventDAO() throws IOException {
        cm = new ConnectionManager();
    }

    public Event createEvent(Event event) throws Exception {
        Event eventCreated = null;
        Connection con = cm.getConnection();
        String sqlSelectEvent = "INSERT INTO Events VALUES(?,?,?,?,?)";
        PreparedStatement psInsertEvent = con.prepareStatement(sqlSelectEvent, Statement.RETURN_GENERATED_KEYS);

        psInsertEvent.setString(1, event.getEventName());
        psInsertEvent.setString(2, event.getEventDate());
        psInsertEvent.setString(3, event.getEventPlace());
        psInsertEvent.setString(4, event.getEventStartEnding());
        psInsertEvent.setString(5, event.getEventInfo());
        psInsertEvent.addBatch();
        psInsertEvent.executeBatch();
        ResultSet rs = psInsertEvent.getGeneratedKeys();
        while (rs.next()) {

           eventCreated = new Event(
                   event.getEventName(),
                   event.getEventDate(),
                   event.getEventPlace(),
                   event.getEventStartEnding(),
                   event.getEventInfo(),
                    rs.getInt(1)
            );

        }
        return eventCreated;

    }


    public void updateEvent(Event event) throws SQLException, IOException {
        Connection con = cm.getConnection();
        String sqlUpdateEvent = "UPDATE  Events SET EventName=?, EventDate=?,EventPlace=?,EventStartEnding=?, EventInfo=? WHERE ID=?;";
        PreparedStatement psUpdateEvent = con.prepareStatement(sqlUpdateEvent, Statement.RETURN_GENERATED_KEYS);
        psUpdateEvent.setString(1, event.getEventName());
        psUpdateEvent.setString(2, event.getEventDate());
        psUpdateEvent.setString(3, event.getEventPlace());
        psUpdateEvent.setString(4, event.getEventStartEnding());
        psUpdateEvent.setString(5, event.getEventInfo());
        psUpdateEvent.executeUpdate();
        psUpdateEvent.close();
        con.close();
    }


    public void deleteEvent(Event event) throws SQLException, IOException {
        Connection con = cm.getConnection();
        String sqlDeleteEvent = "DELETE FROM Events WHERE ID=?;";
        PreparedStatement psDeleteEvent = con.prepareStatement(sqlDeleteEvent, Statement.RETURN_GENERATED_KEYS);
        psDeleteEvent.setInt(1, event.getEventId());
        psDeleteEvent.execute();
        psDeleteEvent.close();
        con.close();
    }

    public List<Event> getAllEvents() throws SQLException, IOException {
        List<Event> allEvents = new ArrayList<>();
        try (Connection con = cm.getConnection()) {
            String sqlSelectEvent= "SELECT * FROM Events";
            PreparedStatement psSelectEvent = con.prepareStatement(sqlSelectEvent);
            ResultSet rs = psSelectEvent.executeQuery();
            while (rs.next()) {
                allEvents.add(new Event(
                        rs.getString("EventName"),
                        rs.getString("EventDate"),
                        rs.getString("EventPlace"),
                        rs.getString("EventStartEnding"),
                        rs.getString("EventInfo"),
                        rs.getInt("EventId"))
                );
            }
        }
        return allEvents;
    }


}
