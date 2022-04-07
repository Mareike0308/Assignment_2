package DAL;

import BE.Admin;
import BE.Coordinator;

import java.io.IOException;
import java.sql.*;

public class AdminDAO {

    private static ConnectionManager cm;


    public AdminDAO() throws IOException {
        cm = new ConnectionManager();
    }

    public Admin createAdmin(Admin admin) throws Exception {
        Admin adminCreated = null;
        Connection con = cm.getConnection();
        String sqlSelectAdmin = "INSERT INTO Admins VALUES(?,?,?)";
        PreparedStatement psInsertAdmin = con.prepareStatement(sqlSelectAdmin, Statement.RETURN_GENERATED_KEYS);

        psInsertAdmin.setString(1, admin.getAdminEmail());
        psInsertAdmin.setString(2, admin.getAdminPassword());
        psInsertAdmin.addBatch();
        psInsertAdmin.executeBatch();
        ResultSet rs =  psInsertAdmin.getGeneratedKeys();
        while (rs.next()) {

            adminCreated = new Admin(
                    admin.getAdminEmail(),
                    admin.getAdminPassword(),
                    rs.getInt(1)
            );

        }
        return adminCreated;

    }


    public void updateAdmin(Admin admin) throws SQLException {
        Connection con = cm.getConnection();
        String sqlUpdateAdmin = "UPDATE Admins SET AdminEmail=?, AdminPassword=? WHERE ID=?;";
        PreparedStatement psUpdateAdmin = con.prepareStatement(sqlUpdateAdmin, Statement.RETURN_GENERATED_KEYS);
        psUpdateAdmin.setString(1, admin.getAdminEmail());
        psUpdateAdmin.setString(2, admin.getAdminPassword());
        psUpdateAdmin.executeUpdate();
        psUpdateAdmin.close();
        con.close();
    }


    public void deleteAdmin(Admin admin) throws SQLException {
        Connection con = cm.getConnection();
        String sqlDeleteAdmin = "DELETE FROM Admins WHERE ID=?;";
        PreparedStatement psDeleteAdmin = con.prepareStatement(sqlDeleteAdmin, Statement.RETURN_GENERATED_KEYS);
        psDeleteAdmin.setInt(1, admin.getAdminId());
        psDeleteAdmin.execute();
        psDeleteAdmin.close();
        con.close();
    }


    /*public void getMailAndPassword(){
        {
            try {
                String queryString = "SELECT * FROM Admins where AdminEmail=? and AdminPassword=?";
                //set this values using PreparedStatement
                ResultSet results = ps.executeQuery(queryString); //where ps is Object of PreparedStatement

                if(!results.next()) {

                    JOptionPane.showMessageDialog("Wrong Username and Password.");
                }

            } catch (SQLException sql) {

                out.println(sql);
            }finally{
                //closing ResultSet,PreparedStatement and Connection object
            }
    }*/
}