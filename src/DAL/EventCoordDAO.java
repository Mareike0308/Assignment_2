package DAL;

import BE.Coordinator;
import BE.Event;
import BE.EventCoord;
import BE.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventCoordDAO {

    ConnectionManager cm;

    public EventCoordDAO() {
        try {
            cm = new ConnectionManager();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createEventCoord(List<EventCoord> list) throws SQLException {
        Connection con = cm.getConnection();

        String sql = "INSERT INTO EventCoord (EventId, CoordId) VALUES (?,?)";
        PreparedStatement statement = con.prepareStatement(sql);
        for (EventCoord ec : list) {
            statement.setInt(1, ec.getEventID());
            statement.setInt(2, ec.getCoordinatorID());
            statement.executeUpdate();
        }
        statement.close();
        con.close();

    }

    public List<EventCoord> getAllEventCoord() throws SQLException {

        ArrayList<EventCoord> eventCoord = new ArrayList<>();
        Connection con = cm.getConnection();

        String sql = "SELECT * FROM EventCoord;";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            int idEvent = rs.getInt("EventId");
            int idCoord = rs.getInt("CoordId");
            EventCoord eCoord = new EventCoord(idEvent, idCoord);
            eventCoord.add(eCoord);
        }
        rs.close();
        statement.close();
        con.close();
        return eventCoord;
    }


    public EventCoord createEventCoord(EventCoord eventCoord) throws SQLException {
        EventCoord eventCoord1 = null;
        Connection con = cm.getConnection();
        String query = "insert into EventCoord (Eventd,Coordid) values(?,?);";
        PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, eventCoord.getEventID());
        preparedStatement.setInt(2, eventCoord.getCoordinatorID());
        preparedStatement.execute();        //execute insert query
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while (resultSet.next()) {
            eventCoord1.setEventID(eventCoord.getEventID());
            eventCoord1.setCoordinatorID(eventCoord.getCoordinatorID());
            eventCoord1.setId(resultSet.getInt(1));
        }
        resultSet.close();
        preparedStatement.close();
        con.close();

        return eventCoord1;
    }

    public List<Event> getEventsFromCoordinator (Coordinator coordinator) throws SQLException {
        List<Event> eventList = new ArrayList<>();
        Connection con = cm.getConnection();
        String query = "select distinct Event.* from EventCoord \n" +
                "JOIN Event on EventCoord.EventId=Event.Id\n" +
                "where CoordId=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, coordinator.getCoordinatorId());
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


   /* public void updateEventCoord(EventCoord eventCoord) throws SQLException {
        Connection con = cm.getConnection();
        String sqlUpdateEventCoord = "UPDATE EventCoord SET CoordId=?, EventId=?, WHERE EventCoordId=?;";
        PreparedStatement psUpdateEventCoord = con.prepareStatement(sqlUpdateEventCoord, Statement.RETURN_GENERATED_KEYS);
        psUpdateEventCoord.setInt(1, EventCoord.getCoordinatorID());
        psUpdateEventCoord.setInt(2, EventCoord.getEventID());
        psUpdateEventCoord.setInt(3,EventCoord.getId());
        psUpdateEventCoord.executeUpdate();
        psUpdateEventCoord.close();
        con.close();
    }*/

    public List<Event> getAllEventsFromCoordinator( Coordinator coordinator) throws SQLException {
        return getEventsFromCoordinator(coordinator);
    }

    public List<Coordinator> getAllCoordinatorsForGivenEvent(Event event) throws SQLException {
        List<Coordinator> coordinators = new ArrayList<>();
        Connection con = cm.getConnection();
        String query = "select distinct Coordinators.* from EventCoord \n" +
                "JOIN Coordinatros on EventCoord.coordID=Coordintaor.id\n" +
                "where eventId=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, event.getEventId());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            int id = rs.getInt("id");

            coordinators.add(new Coordinator(
                    rs.getString("CoordinatorEmail"),
                    rs.getString("CoordinatorPassword"),
                    rs.getString("CoordinatorName"),
                    rs.getInt("CoordinatorId"))
                );
        }

        rs.close();
        ps.close();
        con.close();
        return coordinators;
    }

    public void addCoordinatorToEvent (Coordinator coordinator, Event event) throws SQLException {
        List<Coordinator> allCoordinatorsForGivenEvent = getAllCoordinatorsForGivenEvent(event);
        if (allCoordinatorsForGivenEvent.contains(coordinator))return;
        createEventCoord(new EventCoord(coordinator.getCoordinatorId(),event.getEventId()));
    }
    public void removeCategoryFromMovie(Coordinator coordinator, Event event) throws SQLException {
        Connection con = cm.getConnection();
        PreparedStatement ps = con.prepareStatement("delete from EventCoord where coordId=? and eventId=?");
        ps.setInt(1,coordinator.getCoordinatorId());
        ps.setInt(2,event.getEventId());
        ps.executeUpdate();
        ps.close();
        con.close();


    }
}


