package de.hska.scsim.dao;

import de.hska.scsim.domain.ItemConfig;
import de.hska.scsim.util.Constants;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class ItemConfigDao {

    public ItemConfig findById(String id) throws SQLException {
        ItemConfig itemConfig = new ItemConfig();

        Statement stmt = null;
        String query = "SELECT i.id, i.name, c.c_id, c.quantity "
                + "FROM item i LEFT JOIN combination c "
                + "ON i.id = c.p_id "
                + "WHERE i.id = '" + id + "'";
        try {
            stmt = DriverManager.getConnection(Constants.JDBC_URL).createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()) {
			String itemConfigId = rs.getString("id");
			String name = rs.getString("name");
			
			Map<String, Integer> components = new HashMap<>();
			do {
				String childComponentId = rs.getString("c_id");
				int childComponentQuantity = rs.getInt("quantity");
				if(childComponentId != null && childComponentQuantity != 0) {
					components.put(childComponentId, childComponentQuantity);
				}
			} while(rs.next());
			
			return new ItemConfig(itemConfigId, name, components);
		} else {
			return null;
		}
        } catch (SQLException e) {
            e.printStackTrace();
            itemConfig = null;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        return itemConfig;
    }
}
