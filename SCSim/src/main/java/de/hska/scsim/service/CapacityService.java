package de.hska.scsim.service;

import de.hska.scsim.dao.ProductionStepConfigDao;
import de.hska.scsim.domain.ProductionStepConfig;
import de.hska.scsim.domain.output.CapacityPlanningResult;
import de.hska.scsim.util.Constants;
import de.hska.scsim.util.MultimapUtil;
import de.hska.scsim.xml.XmlParser;
import de.hska.scsim.domain.output.ProductionPlanningResult;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class CapacityService {

    @Autowired
    private ProductionStepConfigDao dao;
    @Autowired
    private XmlParser xmlParser;

    public List<CapacityPlanningResult> calculateCapacityRequirements(List<ProductionPlanningResult> productionPlaningResults) {
        Map<String, Integer> productionOutput = convertToMap(productionPlaningResults);
        Map<Integer, Integer> reqCapacities = new HashMap<>();

        try {
            List<Integer> workplaceIds = dao.findWorkplaceIds();

            for (Integer workplaceId : workplaceIds) {
                int capacity = 0;
                for (ProductionStepConfig productionStepConfig : dao.findByWorkplaceId(workplaceId)) {
                    int itemQuantity = productionOutput.get(productionStepConfig.getItemConfigId());
                    int productionTime = itemQuantity * productionStepConfig.getProductionTime();
                    if (productionTime > 0) {
                        capacity += productionTime + productionStepConfig.getSetupTime();
                    }
                    capacity += calculatePrePeriodCapacity(productionStepConfig);
                }
                reqCapacities.put(workplaceId, capacity);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return generateCapacityPlaningResult(reqCapacities);
    }

    protected List<CapacityPlanningResult> generateCapacityPlaningResult(Map<Integer, Integer> reqCapacities) {
        List<CapacityPlanningResult> capacityPlaningResults = new ArrayList<>();

        for (Entry<Integer, Integer> capacity : reqCapacities.entrySet()) {
            Integer workplaceId = capacity.getKey();
            int reqCapacity = capacity.getValue();
            int shifts = calculateShifts(reqCapacity);
            int overtime = calculateOvertime(reqCapacity, shifts);
            try {
                String producedItemConfigs = StringUtils.join(dao.findProducedItemConfigIds(workplaceId), ", ");

                capacityPlaningResults.add(new CapacityPlanningResult(workplaceId, reqCapacity, shifts, overtime, producedItemConfigs));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return capacityPlaningResults;
    }

    protected int calculateShifts(int reqCapacity) {
        if (reqCapacity <= 0) {
            return 0;
        }
        if (reqCapacity >= 1 && reqCapacity <= 3600) {
            return 1;
        }
        if (reqCapacity >= 3601 && reqCapacity <= 6000) {
            return 2;
        }
        if (reqCapacity >= 6001) {
            return 3;
        }

        return -1;
    }

    protected int calculateOvertime(int reqCapacity, int shifts) {
        if (shifts == 3) {
            return 0;
        }

        int overtime = reqCapacity - (shifts * Constants.WORKPLACE_CAPACITY);
        if (overtime <= 0) {
            return 0;
        }
        return overtime;
    }

    protected int calculatePrePeriodCapacity(ProductionStepConfig root) {
        String itemConfigId = root.getItemConfigId();
        Integer workplaceId = root.getWorkplaceId();

        int prePeriodCurrentWorkTime = xmlParser.getTimeNeedOfCurrentWork(itemConfigId, workplaceId);
        int prePeriodQuantity = xmlParser.getWorkInQueue(itemConfigId, workplaceId) + xmlParser.getOrderAmountOfMissingPart(itemConfigId);

        Integer preProductionStepConfigId = root.getPreProductionStepConfigId();
        if (preProductionStepConfigId != null) {
            try {
                prePeriodQuantity += calculatePreProductionStepQuantity(dao.findById(preProductionStepConfigId));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        int prePeriodCapacity = root.getProductionTime() * prePeriodQuantity;
        if (prePeriodCapacity > 0) {
            prePeriodCapacity += root.getSetupTime();
        }
        return prePeriodCapacity + prePeriodCurrentWorkTime;
    }

    protected int calculatePreProductionStepQuantity(ProductionStepConfig parent) {
        int result = 0;

        String itemConfigId = parent.getItemConfigId();
        Integer workplaceId = parent.getWorkplaceId();
        result = +xmlParser.getWorkInQueue(itemConfigId, workplaceId);
        result += xmlParser.getAmountOfCurrentWork(itemConfigId, workplaceId);

        Integer childProductionStepConfigId = parent.getPreProductionStepConfigId();
        if (childProductionStepConfigId != null) {
            try {
                result += calculatePreProductionStepQuantity(dao.findById(childProductionStepConfigId));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    private Map<String, Integer> convertToMap(List<ProductionPlanningResult> list) {
        MultiMap<String, Integer> multimap = new MultiValueMap<>();
        for (ProductionPlanningResult item : list) {
            multimap.put(item.getItemConfigId(), item.getQuantity());
        }
        return MultimapUtil.convertToMap(multimap);
    }
}
