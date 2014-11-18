package de.hska.scsim.dao;

import de.hska.scsim.domain.ProductionStepConfig;
import de.hska.scsim.util.Constants;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductionStepConfigDao {

    public ProductionStepConfig findById(Integer id) throws SQLException {
        ProductionStepConfig productionStepConfig = new ProductionStepConfig();

        Statement stmt = null;
        String query = "SELECT p.*, c.c_id "
                + "FROM production_step p LEFT JOIN production_step_chain c "
                + "ON p.id = c.p_id "
                + "WHERE p.id = '" + id + "'";
        try {
            stmt = DriverManager.getConnection(Constants.JDBC_URL).createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int productionStepId = rs.getInt("id");
                int workplaceId = rs.getInt("workplaceId");
                String itemConfigId = rs.getString("itemId");
                int productionTime = rs.getInt("productionTime");
                int setupTime = rs.getInt("setupTime");
                Integer preProductionStepConfigId = rs.getInt("c_id");

                if (preProductionStepConfigId == 0) {
                    return new ProductionStepConfig(productionStepId, workplaceId, itemConfigId, productionTime, setupTime);
                } else {
                    return new ProductionStepConfig(productionStepId, workplaceId, itemConfigId, productionTime, setupTime, preProductionStepConfigId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            productionStepConfig = null;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return productionStepConfig;
    }

    public List<ProductionStepConfig> findByWorkplaceId(Integer id) throws SQLException {

        List<ProductionStepConfig> productionStepConfigs = new ArrayList<>();

        Statement stmt = null;
        String query = "SELECT p.*, c.c_id "
                + "FROM production_step p LEFT JOIN production_step_chain c "
                + "ON p.id = c.p_id "
                + "WHERE p.workplaceId = '" + id + "'";
        try {
            stmt = DriverManager.getConnection(Constants.JDBC_URL).createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int productionStepId = rs.getInt("id");
                int workplaceId = rs.getInt("workplaceId");
                String itemConfigId = rs.getString("itemId");
                int productionTime = rs.getInt("productionTime");
                int setupTime = rs.getInt("setupTime");
                Integer preProductionStepConfigId = rs.getInt("c_id");

                if (preProductionStepConfigId == 0) {
                    productionStepConfigs.add(new ProductionStepConfig(productionStepId, workplaceId, itemConfigId, productionTime, setupTime));
                } else {
                    productionStepConfigs.add(new ProductionStepConfig(productionStepId, workplaceId, itemConfigId, productionTime, setupTime, preProductionStepConfigId));
                }
            }

            return productionStepConfigs;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return productionStepConfigs;
    }

    public List<Integer> findWorkplaceIds() throws SQLException {
        List<Integer> workplaceIds = new ArrayList<>();

        Statement stmt = null;
        String query = "SELECT DISTINCT p.workplaceId "
                + "FROM production_step p "
                + "ORDER BY workplaceId";

        try {
            stmt = DriverManager.getConnection(Constants.JDBC_URL).createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");

                workplaceIds.add(id);
            }

            return workplaceIds;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return workplaceIds;
    }

    public List<String> findProducedItemConfigIds(Integer id) throws SQLException {
        List<String> producedItemConfigIds = new ArrayList<>();

        Statement stmt = null;
        String query = "SELECT p.itemId "
                + "FROM production_step p "
                + "WHERE p.workplaceId = '" + id + "'";

        try {
            stmt = DriverManager.getConnection(Constants.JDBC_URL).createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String itemConfigId = rs.getString("itemId");

                producedItemConfigIds.add(itemConfigId);
            }

            return producedItemConfigIds;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return producedItemConfigIds;
    }

}
