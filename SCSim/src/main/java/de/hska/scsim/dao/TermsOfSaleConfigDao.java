package de.hska.scsim.dao;

import de.hska.scsim.domain.TermsOfSaleConfig;
import de.hska.scsim.util.Constants;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TermsOfSaleConfigDao {

    public List<TermsOfSaleConfig> findAll() throws SQLException {
        List<TermsOfSaleConfig> tosConfigs = new ArrayList<>();

        Statement stmt = null;
        String query = "SELECT * FROM terms_of_sale";
        try {
            stmt = DriverManager.getConnection(Constants.JDBC_URL).createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                tosConfigs.add(new TermsOfSaleConfig(rs.getString("itemId"),
                        rs.getDouble("deliveryTime"),
                        rs.getDouble("variance"),
                        rs.getInt("orderingCosts"),
                        rs.getInt("discountQuantity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return tosConfigs;
    }
}
