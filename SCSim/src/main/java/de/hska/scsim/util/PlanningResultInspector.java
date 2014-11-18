package de.hska.scsim.util;

import de.hska.scsim.dao.ItemConfigDao;
import de.hska.scsim.domain.ItemConfig;
import de.hska.scsim.domain.output.PurchasePlanningResult;
import de.hska.scsim.xml.XmlParser;
import de.hska.scsim.domain.output.ProductionPlanningResult;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.springframework.beans.factory.annotation.Autowired;

public class PlanningResultInspector {

    @Autowired
    private ItemConfigDao dao;

    @Autowired
    private XmlParser xmlParser;

    public double checkStockValue(List<ProductionPlanningResult> productionPlaningResults, List<PurchasePlanningResult> purchasePlaningResults, Map<String, Integer> planedSales) {
        Map<String, Integer> sales = calculateSales(planedSales);

        double stockValue = 0d;
        for (ProductionPlanningResult productionPlaningResult : productionPlaningResults) {
            String itemConfigId = productionPlaningResult.getItemConfigId();
            int stock = xmlParser.getWarehouseStock(itemConfigId) + productionPlaningResult.getQuantity() - sales.get(itemConfigId);

            stockValue += stock * xmlParser.getPrice(itemConfigId);
        }

        for (PurchasePlanningResult purchasePlaningResult : purchasePlaningResults) {
            String itemConfigId = purchasePlaningResult.getItemConfigId();
            double deliveryTime = purchasePlaningResult.getDeliveryTime();
            double variance = purchasePlaningResult.getVariance();
            Integer currentPeriod = xmlParser.getCurrentPeriod();
            int stock = xmlParser.getWarehouseStock(itemConfigId)
                    + xmlParser.getInwardStockMovementUntilGivenPeriod(itemConfigId, deliveryTime, variance, currentPeriod)
                    - sales.get(itemConfigId);
            if (purchasePlaningResult.isDeliveryInCurrentPeriod()) {
                stock += purchasePlaningResult.getQuantity();
            }

            stockValue += stock * xmlParser.getPrice(itemConfigId);
        }

        return Math.round(stockValue * 100.0) / 100.0;
    }

    protected Map<String, Integer> calculateSales(Map<String, Integer> planedSales) {
        MultiMap<String, Integer> sales = new MultiValueMap<>();
        try {
            for (Entry<String, Integer> sale : planedSales.entrySet()) {
                ItemConfig itemConfig = dao.findById(sale.getKey());
                sales.putAll(processComponents(itemConfig, sale.getValue(), 1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return MultimapUtil.convertToMap(sales);
    }

    protected MultiMap<String, Integer> processComponents(ItemConfig parentItemConfig, int rootQuantity, int usage) {
        MultiMap<String, Integer> sales = new MultiValueMap<>();
        sales.put(parentItemConfig.getId(), rootQuantity * usage);
        try {
            for (Entry<String, Integer> childComponent : parentItemConfig.getComponents().entrySet()) {
                ItemConfig childItemConfig = dao.findById(childComponent.getKey());
                sales.putAll(processComponents(childItemConfig, rootQuantity, childComponent.getValue()));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sales;
    }
}
