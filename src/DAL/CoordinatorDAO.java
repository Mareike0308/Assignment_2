package DAL;

import BE.Coordinator;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoordinatorDAO {

    private static ConnectionManager cm;


    public CoordinatorDAO() throws IOException {
        cm = new ConnectionManager();
    }


    public List<Coordinator> getAllCoordinators() throws Exception {
        List<Coordinator> allCoordinators = new ArrayList<>();
        try (Connection con = cm.getConnection()) {
            String sqlSelectCoordinator= "SELECT * FROM Coordinators";
            PreparedStatement psSelectCoordinator = con.prepareStatement(sqlSelectCoordinator);
            ResultSet rs = psSelectCoordinator.executeQuery();
            while (rs.next()) {
                allCoordinators.add(new Coordinator(
                        rs.getString("CoordinatorEmail"),
                        rs.getString("CoordinatorPassword"),
                        rs.getString("CoordinatorName"),
                        rs.getInt("CoordinatorId"))
                );
            }
        }
        return allCoordinators;
    }



    public Coordinator createCoordinator(Coordinator coordinator) throws Exception {
        Coordinator coordinatorCreated = null;
        Connection con = cm.getConnection();
        String sqlSelectCoordinator = "INSERT INTO Coordinators VALUES(?,?,?)";
        PreparedStatement psInsertCoordinator = con.prepareStatement(sqlSelectCoordinator, Statement.RETURN_GENERATED_KEYS);

        psInsertCoordinator.setString(1, coordinator.getCoordinatorEmail());
        psInsertCoordinator.setString(2, coordinator.getCoordinatorPassword());
        psInsertCoordinator.setString(3, coordinator.getCoordinatorName());
        psInsertCoordinator.addBatch();
        psInsertCoordinator.executeBatch();
        ResultSet rs =  psInsertCoordinator.getGeneratedKeys();
        while (rs.next()) {

            coordinatorCreated = new Coordinator(
                   coordinator.getCoordinatorEmail(),
                   coordinator.getCoordinatorPassword(),
                   coordinator.getCoordinatorName(),
                    rs.getInt(1)
            );

        }
        return coordinatorCreated;

    }


    public void updateCoordinator(Coordinator coordinator) throws SQLException, IOException {
        Connection con = cm.getConnection();
        String sqlUpdateCoordinator = "UPDATE Coordinators SET CoordinatorEmail=?, CoordinatorPassword=?,CoordinatorName=? WHERE ID=?;";
        PreparedStatement psUpdateCoordinator = con.prepareStatement(sqlUpdateCoordinator, Statement.RETURN_GENERATED_KEYS);
        psUpdateCoordinator.setString(1, coordinator.getCoordinatorEmail());
        psUpdateCoordinator.setString(2, coordinator.getCoordinatorPassword());
        psUpdateCoordinator.setString(3, coordinator.getCoordinatorName());
        psUpdateCoordinator.executeUpdate();
        psUpdateCoordinator.close();
        con.close();
    }


    public void deleteCoordinator(Coordinator coordinator) throws SQLException, IOException {
        Connection con = cm.getConnection();
        String sqlDeleteCoordinator = "DELETE FROM Coordinators WHERE ID=?;";
        PreparedStatement psDeleteCoordinator = con.prepareStatement(sqlDeleteCoordinator, Statement.RETURN_GENERATED_KEYS);
        psDeleteCoordinator.setInt(1, coordinator.getCoordinatorId());
        psDeleteCoordinator.execute();
        psDeleteCoordinator.close();
        con.close();
    }
}

