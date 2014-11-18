package de.hska.scsim.service;

import de.hska.scsim.dao.ItemConfigDao;
import de.hska.scsim.domain.ItemConfig;
import de.hska.scsim.util.MultimapUtil;
import de.hska.scsim.xml.XmlParser;
import de.hska.scsim.domain.output.ProductionPlanningResult;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductionService {

    private static final List<String> DEFAULT_ORDER = Arrays.asList("E13", "E18", "E7", "E4", "E10", "E14",
            "E19", "E8", "E5", "E11", "E15", "E20",
            "E9", "E6", "E12", "E49", "E54", "E29",
            "E16", "E17", "E50", "E55", "E30", "E51",
            "E26", "E56", "E31", "P1", "P2", "P3");

    @Autowired
    private ItemConfigDao dao;

    @Autowired
    private XmlParser xmlParser;

    public List<ProductionPlanningResult> calculateProductionOutput(Map<String, Integer> plannedSales, Map<String, Integer> safetyStocks) {
        MultiMap<String, Integer> productionOutput = new MultiValueMap<>();
        try {
            for (Entry<String, Integer> planedSale : plannedSales.entrySet()) {
                ItemConfig itemConfig = dao.findById(planedSale.getKey());
                productionOutput.putAll(processComponents(itemConfig, planedSale.getValue(), safetyStocks));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return sortProductionPlanningResult(productionOutput);
    }

    protected List<ProductionPlanningResult> sortProductionPlanningResult(MultiMap<String, Integer> productionOutput) {
        List<ProductionPlanningResult> productionPlaningResults = new ArrayList<>();
        for (Entry<String, Integer> productionOutputEntry : MultimapUtil.convertToMap(productionOutput).entrySet()) {
            productionPlaningResults.add(new ProductionPlanningResult(productionOutputEntry.getKey(), productionOutputEntry.getValue()));
        }

        Collections.sort(productionPlaningResults, new Comparator<ProductionPlanningResult>() {
            @Override
            public int compare(ProductionPlanningResult o1, ProductionPlanningResult o2) {
                return DEFAULT_ORDER.indexOf(o1.getItemConfigId()) - DEFAULT_ORDER.indexOf(o2.getItemConfigId());
            }
        });
        return productionPlaningResults;
    }

    protected MultiMap<String, Integer> processComponents(ItemConfig parentItemConfig, int parentQuantity, Map<String, Integer> safetyStocks) {
        MultiMap<String, Integer> productionOutput = new MultiValueMap<>();
        String parentItemConfigId = parentItemConfig.getId();
        if (parentItemConfigId.startsWith("K")) {
            return productionOutput;
        }

        int quantity = calculateOutput(parentItemConfigId, parentQuantity, safetyStocks);
        int childQuantity = quantity + xmlParser.getWorkInQueue(parentItemConfigId) + xmlParser.getOrderAmountOfMissingPart(parentItemConfigId);
        productionOutput.put(parentItemConfigId, quantity);

        for (Entry<String, Integer> childComponent : parentItemConfig.getComponents().entrySet()) {
            try {
                ItemConfig childItemConfig = dao.findById(childComponent.getKey());
                productionOutput.putAll(processComponents(childItemConfig, childQuantity, safetyStocks));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return productionOutput;
    }

    protected int calculateOutput(String itemConfigId, int parentQuantity, Map<String, Integer> safetyStocks) {
        int stock = xmlParser.getWarehouseStock(itemConfigId);
        int safetyStock = ObjectUtils.firstNonNull(safetyStocks.get(itemConfigId), 0);
        int workInQueue = xmlParser.getWorkInQueue(itemConfigId);
        int currentWork = xmlParser.getCurrentWork(itemConfigId);
        int missingPart = xmlParser.getMissingPartWithoutOrder(itemConfigId);
        int outputOfMissingPart = xmlParser.getOrderAmountOfMissingPart(itemConfigId);

        if (itemConfigId.equals("E16") || itemConfigId.equals("E17") || itemConfigId.equals("E26")) {
            stock = (int) Math.round(stock / 3);
            safetyStock = (int) Math.round(safetyStock / 3);
            workInQueue = (int) Math.round(workInQueue / 3);
            currentWork = (int) Math.round(currentWork / 3);
            missingPart = (int) Math.round(missingPart / 3);
            outputOfMissingPart = (int) Math.round(outputOfMissingPart / 3);
        }

        int output = parentQuantity + safetyStock + missingPart - stock - workInQueue - currentWork - outputOfMissingPart;
        if (output < 0) {
            return 0;
        }
        return output;
    }
}
