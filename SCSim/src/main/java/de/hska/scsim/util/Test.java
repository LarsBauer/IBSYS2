package de.hska.scsim.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lars
 */
public class Test {
    
    public static void main(String[] args) {
        try {
            dbConnectionTest();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void dbConnectionTest() throws SQLException {
        String id = "P1";
        Statement stmt = null;
        String query = "SELECT * FROM item WHERE id='" + id + "'";
        try {
            stmt = DriverManager.getConnection(Constants.JDBC_URL).createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                System.out.println("id=" + rs.getString("id") + ", name=" + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    
}
