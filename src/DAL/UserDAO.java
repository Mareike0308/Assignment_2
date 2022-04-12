package DAL;

import BE.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static ConnectionManager cm;


    public UserDAO() throws IOException {
        cm = new ConnectionManager();
    }

    public User createUser(User user) throws Exception {
        User userCreated = null;
        Connection con = cm.getConnection();
        String sqlSelectUser = "INSERT INTO Users VALUES(?,?,?,?,?)";
        PreparedStatement psInsertUser = con.prepareStatement(sqlSelectUser, Statement.RETURN_GENERATED_KEYS);

        psInsertUser.setString(1, user.getUserName());
        psInsertUser.setString(2, user.getUserEmail());
        psInsertUser.setInt(3, user.getUserPhoneNumber());
        psInsertUser.setInt(4, user.getUserAmountOfTickets());
        psInsertUser.setString(5, user.getUserTicket());
        psInsertUser.addBatch();
        psInsertUser.executeBatch();
        ResultSet rs = psInsertUser.getGeneratedKeys();
        while (rs.next()) {

            userCreated = new User(
                    user.getUserName(),
                    user.getUserEmail(),
                    user.getUserPhoneNumber(),
                    user.getUserAmountOfTickets(),
                    user.getUserTicket(),
                    rs.getInt(1)
            );

        }
        return userCreated;

    }



    public List<User> getAllUsers() throws SQLException {
        List<User> allUsers = new ArrayList<>();
       try (Connection con = cm.getConnection()) {
            String sqlSelectUser= "SELECT * FROM Users";
            PreparedStatement psSelectUser = con.prepareStatement(sqlSelectUser);
            ResultSet rs = psSelectUser.executeQuery();
         while (rs.next()) {
                allUsers.add(new User(
                        rs.getString("UserName"),
                        rs.getString("UserEmail"),
                        rs.getInt("UserPhoneNumber"),
                        rs.getInt("UserAmountOfTickets"),
                        rs.getString("UserTicket"),
                        rs.getInt("UserId"))
                );
            }
        }
        return allUsers;
    }


    public void updateUser(User user) throws SQLException {
        Connection con = cm.getConnection();
        String sqlUpdateUser = "UPDATE  Users SET UserName=?, UserEmail=?,UserPhoneNumber=?,UserAmountOfTickets=?, UserTicket=? WHERE ID=?;";
        PreparedStatement psUpdateUser = con.prepareStatement(sqlUpdateUser, Statement.RETURN_GENERATED_KEYS);
        psUpdateUser.setString(1, user.getUserName());
        psUpdateUser.setString(2, user.getUserEmail());
        psUpdateUser.setInt(3, user.getUserPhoneNumber());
        psUpdateUser.setInt(4, user.getUserAmountOfTickets());
        psUpdateUser.setString(5, user.getUserTicket());
        psUpdateUser.executeUpdate();
        psUpdateUser.close();
        con.close();
    }

    public void deleteUser(User user) throws SQLException {
        Connection con = cm.getConnection();
        String sqlDeleteUser = "DELETE FROM Users WHERE ID=?;";
        PreparedStatement psDeleteUser = con.prepareStatement(sqlDeleteUser, Statement.RETURN_GENERATED_KEYS);
        psDeleteUser.setInt(1, user.getUserId());
        psDeleteUser.execute();
        psDeleteUser.close();
        con.close();
    }

}

