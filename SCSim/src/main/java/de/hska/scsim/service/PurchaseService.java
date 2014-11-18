package de.hska.scsim.service;

import de.hska.scsim.dao.ItemConfigDao;
import de.hska.scsim.dao.TermsOfSaleConfigDao;
import de.hska.scsim.domain.ItemConfig;
import de.hska.scsim.domain.TermsOfSaleConfig;
import de.hska.scsim.domain.output.PurchasePlanningResult;
import de.hska.scsim.util.Constants;
import de.hska.scsim.util.MultimapUtil;
import de.hska.scsim.xml.XmlParser;
import de.hska.scsim.domain.output.ProductionPlanningResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.sql.SQLException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.springframework.beans.factory.annotation.Autowired;

public class PurchaseService {

    @Autowired
    private TermsOfSaleConfigDao tosDao;

    @Autowired
    private ItemConfigDao itemDao;

    @Autowired
    private XmlParser xmlParser;

    public List<PurchasePlanningResult> calculateOrders(List<ProductionPlanningResult> productionPlanningResults, List<Map<String, Integer>> forecasts) {
        List<Map<String, Integer>> purchasePartReqs = calculatePurchasePartRequirements(productionPlanningResults, forecasts);

        List<PurchasePlanningResult> result = new ArrayList<>();
        try {
            for (TermsOfSaleConfig tosConfig : tosDao.findAll()) {
                String itemConfigId = tosConfig.getItemConfigId();
                double deliveryTime = tosConfig.getDeliveryTime();
                double variance = tosConfig.getVariance();
                int discountQuantity = tosConfig.getDiscountQuantity();
                int orderingCosts = tosConfig.getDeliveryCosts();
                double price = xmlParser.getPrice(itemConfigId);

                double stockRange = calculateStockRange(purchasePartReqs, tosConfig);
                double maxDeliveryTime = Math.round((deliveryTime + variance) * 10.0) / 10.0;

                if ((maxDeliveryTime + 1d) > stockRange) {
                    double avgRequirement = calculateAvgRequirement(purchasePartReqs, itemConfigId);
                    double maxRequirement = calculateMaxRequirement(purchasePartReqs, itemConfigId);
                    int orderQuantity = (int) Math.round(((avgRequirement * maxDeliveryTime) + (maxRequirement * maxDeliveryTime)) / 2);

                    int purchaseMode;
                    if (maxDeliveryTime > stockRange) {
                        purchaseMode = Constants.FAST_DELIVERY_ID;
                    } else {
                        purchaseMode = Constants.STANDARD_DELIVERY_ID;
                    }

                    result.add(calculatedOrDiscountQuantity(itemConfigId, orderQuantity, purchaseMode, orderingCosts,
                            price, discountQuantity, deliveryTime, variance));
                } else {
                    result.add(new PurchasePlanningResult(itemConfigId, 0, 0, orderingCosts, price, discountQuantity, deliveryTime, variance));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    protected PurchasePlanningResult calculatedOrDiscountQuantity(String itemConfigId, int orderQuantity, int purchaseMode, int orderingCosts,
            double price, int discountQuantity, double deliveryTime, double variance) {

        PurchasePlanningResult resultCalcQuantity = new PurchasePlanningResult(itemConfigId, orderQuantity, purchaseMode, orderingCosts,
                price, discountQuantity, deliveryTime, variance);
        if (discountQuantity <= orderQuantity) {
            return resultCalcQuantity;
        }

        PurchasePlanningResult resultDiscountQuantity = new PurchasePlanningResult(itemConfigId, discountQuantity, purchaseMode, orderingCosts,
                price, discountQuantity, deliveryTime, variance);

        if (resultCalcQuantity.getPositionCosts() < resultDiscountQuantity.getPositionCosts()) {
            return resultCalcQuantity;
        } else {
            return resultDiscountQuantity;
        }
    }

    protected double calculateAvgRequirement(List<Map<String, Integer>> purchasePartReqs, String itemConfigId) {
        double sum = 0.0;
        for (Map<String, Integer> item : purchasePartReqs) {
            sum += item.get(itemConfigId);
        }
        return Math.round((sum / 4) * 100.0) / 100.0;
    }

    protected double calculateMaxRequirement(List<Map<String, Integer>> purchasePartReqs, String itemConfigId) {
        int max = 0;
        for (Map<String, Integer> item : purchasePartReqs) {
            Integer req = item.get(itemConfigId);
            if (max < req) {
                max = req;
            }
        }
        return Math.round(max * 100.0) / 100.0;
    }

    protected double calculateStockRange(List<Map<String, Integer>> purchasePartReqs, TermsOfSaleConfig termsOfSaleConfig) {
        for (int i = 0; i < purchasePartReqs.size(); i++) {
            String itemConfigId = termsOfSaleConfig.getItemConfigId();
            double deliveryTime = termsOfSaleConfig.getDeliveryTime();
            double variance = termsOfSaleConfig.getVariance();

            Integer purchasePartReq = 0;
            for (int j = 0; j <= i; j++) {
                purchasePartReq += purchasePartReqs.get(j).get(itemConfigId);
            }
            Integer stock = xmlParser.getWarehouseStock(itemConfigId)
                    + xmlParser.getInwardStockMovementUntilGivenPeriod(itemConfigId, deliveryTime, variance, i + xmlParser.getCurrentPeriod());

            double stockRange = Math.round(((double) stock) / ((double) purchasePartReq) * 100.0) / 100.0;
            if (stockRange < 1d) {
                return i + stockRange;
            }
        }
        return 4d;
    }

    protected List<Map<String, Integer>> calculatePurchasePartRequirements(List<ProductionPlanningResult> productionPlaningResults, List<Map<String, Integer>> forecasts) {
        List<Map<String, Integer>> purchasePartReqs = new ArrayList<>();

        MultiMap<String, Integer> purchasePartReqProduction = new MultiValueMap<>();
        for (ProductionPlanningResult productionPlaningResult : productionPlaningResults) {

            String itemConfigId = productionPlaningResult.getItemConfigId();
            if (itemConfigId.equals("P1") || itemConfigId.equals("P2") || itemConfigId.equals("P3")) {

                ItemConfig itemConfig;
                try {
                    itemConfig = itemDao.findById(itemConfigId);
                    int quantity = productionPlaningResult.getQuantity()
                            + xmlParser.getWorkInQueue(itemConfigId)
                            + xmlParser.getOrderAmountOfMissingPart(itemConfigId);

                    purchasePartReqProduction.putAll(processComponents(itemConfig, quantity, 1));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        purchasePartReqs.add(MultimapUtil.convertToMap(purchasePartReqProduction));

        for (Map<String, Integer> forecast : forecasts) {

            MultiMap<String, Integer> purchasePartReqForecast = new MultiValueMap<>();
            for (Entry<String, Integer> forecastEntry : forecast.entrySet()) {
                ItemConfig itemConfig;
                try {
                    itemConfig = itemDao.findById(forecastEntry.getKey());
                    purchasePartReqForecast.putAll(processComponents(itemConfig, forecastEntry.getValue(), 1));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            purchasePartReqs.add(MultimapUtil.convertToMap(purchasePartReqForecast));
        }
        return purchasePartReqs;
    }

    protected MultiMap<String, Integer> processComponents(ItemConfig parentItemConfig, int rootQuantity, int usage) {
        MultiMap<String, Integer> purchasePartReq = new MultiValueMap<>();
        String parentItemConfigId = parentItemConfig.getId();
        if (parentItemConfigId.startsWith("K")) {
            purchasePartReq.put(parentItemConfigId, rootQuantity * usage);
        }

        for (Entry<String, Integer> childComponent : parentItemConfig.getComponents().entrySet()) {
            try {
                ItemConfig childItemConfig = itemDao.findById(childComponent.getKey());
                purchasePartReq.putAll(processComponents(childItemConfig, rootQuantity, childComponent.getValue()));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return purchasePartReq;
    }
}
