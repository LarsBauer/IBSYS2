package de.hska.scsim.xml;

import de.hska.scsim.domain.output.CapacityPlanningResult;
import de.hska.scsim.domain.output.PurchasePlanningResult;
import de.hska.scsim.domain.output.ProductionPlanningResult;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XmlGenerator {

    public void generateXml(List<ProductionPlanningResult> production, List<CapacityPlanningResult> capacity,
            List<PurchasePlanningResult> purchase, Map<String, Integer> planedSales, String outputPath) throws IOException {

        Document doc = new Document();
        Element input = new Element("input");
        doc.setRootElement(input);

        // Qualitycontrol
        Element qualityControl = new Element("qualitycontrol");
        qualityControl.setAttribute("type", "no");
        qualityControl.setAttribute("losequantity", "0");
        qualityControl.setAttribute("delay", "0");
        input.addContent(qualityControl);

        // Sellwish
        Element sellWish = new Element("sellwish");
        List<String> planedSalesKeys = new ArrayList<>(planedSales.keySet());
        Collections.sort(planedSalesKeys, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                Integer i = Integer.valueOf(o1.substring((o1.length() - 1), o1.length()));
                Integer j = Integer.valueOf(o2.substring((o2.length() - 1), o2.length()));

                return i.compareTo(j);
            }
        });

        for (String articleId : planedSalesKeys) {
            Element item = new Element("item");
           
            switch (articleId) {
                case "P1":
                    Integer amountP1 = planedSales.get(articleId);
                    item.setAttribute("article", articleId.substring(1));
                    item.setAttribute("quantity", String.valueOf(amountP1));
                    break;
                case "P2":
                    Integer amountP2 = planedSales.get(articleId);
                    item.setAttribute("article", articleId.substring(1));
                    item.setAttribute("quantity", String.valueOf(amountP2));
                    break;
                case "P3":
                    Integer amountP3 = planedSales.get(articleId);
                    item.setAttribute("article", articleId.substring(1));
                    item.setAttribute("quantity", String.valueOf(amountP3));
                    break;
            }
            sellWish.addContent(item);
        }
        input.addContent(sellWish);

        // Selldirect
        Element sellDirect = new Element("selldirect");
        
        for (int i = 1; i <= 3; i++) {
            Element item = new Element("item");
            item.setAttribute("article", String.valueOf(i));
            item.setAttribute("quantity", "0");
            item.setAttribute("price", "0.0");
            item.setAttribute("penalty", "0.0");
            
            sellDirect.addContent(item);
        }
        input.addContent(sellDirect);

        // Orderlist
        Element orderList = new Element("orderlist");
        for (PurchasePlanningResult result : purchase) {

            if (Integer.valueOf(result.getQuantity()).equals(0)) {
                continue;
            }
            Element order = new Element("order");
            order.setAttribute("article", result.getItemConfigId().substring(1));
            order.setAttribute("quantity", String.valueOf(result.getQuantity()));
            order.setAttribute("modus", String.valueOf(result.getPurchaseMode()));
            
            orderList.addContent(order);
        }
        input.addContent(orderList);

        // Productionlist
        Element productionList = new Element("productionlist");

        for (ProductionPlanningResult result : production) {
            if (Integer.valueOf(result.getQuantity()).equals(0)) {
                continue;
            }
            Element productionElement = new Element("production");
            productionElement.setAttribute("article", result.getItemConfigId().substring(1));
            productionElement.setAttribute("quantity", String.valueOf(result.getQuantity()));
            
            productionList.addContent(productionElement);
        }
        input.addContent(productionList);

        // Workingtimelist
        Element wtl = new Element("workingtimelist");
        for (CapacityPlanningResult result : capacity) {
            double overtime = ((double) result.getOvertime() / 5);
            int roundedOvertime = (int) Math.ceil(overtime);
            Element workingTime = new Element("workingtime");
            workingTime.setAttribute("station", String.valueOf(result.getWorkplaceId()));
            workingTime.setAttribute("shift", String.valueOf(result.getShifts()));
            workingTime.setAttribute("overtime", String.valueOf(roundedOvertime));
            
            wtl.addContent(workingTime);
        }
        input.addContent(wtl);

        XMLOutputter xmlOutput = new XMLOutputter();
        //display nice nice
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(doc, new FileWriter(outputPath));
    }

}
