package de.hska.scsim.xml;

import de.hska.scsim.domain.input.Article;
import de.hska.scsim.domain.input.FutureInwardStockMovementOrder;
import de.hska.scsim.domain.input.OrdersInWorkWorkplace;
import de.hska.scsim.domain.input.WaitingList;
import de.hska.scsim.domain.input.WaitingListStockMissingPart;
import de.hska.scsim.domain.input.WaitingListWorkstation;
import java.io.File;
import java.io.IOException;

import java.text.NumberFormat;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XmlParser {

    private Map<String, Article> warehouseStockArticles = new HashMap<>();
    private Map<String, OrdersInWorkWorkplace> ordersInWorkWorkplaces = new HashMap<>();
    private Map<String, WaitingListWorkstation> waitingListWorkstations = new HashMap<>();
    private MultiMap<String, FutureInwardStockMovementOrder> futureInwardStockMovementOrders = new MultiValueMap<>();
    private Map<String, WaitingListStockMissingPart> waitingListStockMissingParts = new HashMap<>();
    private int period;
    
    public void parse(File file) throws IOException {

        if (!warehouseStockArticles.isEmpty() || !ordersInWorkWorkplaces.isEmpty() || !waitingListWorkstations.isEmpty()
                || !futureInwardStockMovementOrders.isEmpty() || !waitingListStockMissingParts.isEmpty()) {
            warehouseStockArticles.clear();
            ordersInWorkWorkplaces.clear();
            waitingListWorkstations.clear();
            futureInwardStockMovementOrders.clear();
            waitingListStockMissingParts.clear();
        }

        Document document;
        try {
            document = new SAXBuilder().build(file);
        } catch (JDOMException e) {
            throw new IOException("Something went wrong during parsing!");
        }

        Element root = document.getRootElement();

        Element warehouseStock = root.getChild("warehousestock");
        Element ordersInWork = root.getChild("ordersinwork");
        Element wlw = root.getChild("waitinglistworkstations");
        Element fism = root.getChild("futureinwardstockmovement");
        Element waitingListStock = root.getChild("waitingliststock");

        extractPeriod(root);
        try {
            extractWarehouseStockArticles(warehouseStock);
        } catch (ParseException ex) {
            throw new IOException("Something went wrong during parsing!");
        }
        extractFutureInwardStockMovementOrders(fism);
        extractWaitingListsOfWorkstations(wlw);
        extractMissingPartsOfWaitingListStock(waitingListStock);
        extractOrdersInWorkWorkplaces(ordersInWork);
    }

    public void checkXmlFile(File file) throws IOException {
        Document document;

        try {
            document = new SAXBuilder().build(file);
        } catch (JDOMException e) {
            throw new IOException("Die XML-Datei ist keine XMl Datei der enthält unerlaubte Elemente!");
        }
        Element root = document.getRootElement();

        if (!root.getName().equals("results")) {
            throw new IOException("Die XML-Datei entspricht nicht den SCSIM Vorgaben");
        }
    }

    private void extractPeriod(Element result) {
        period = Integer.valueOf(result.getAttributeValue("period"));
    }

    private void extractMissingPartsOfWaitingListStock(Element waitingListStock) {
        for (int i1 = 0; i1 < waitingListStock.getChildren().size(); i1++) {
            List<WaitingList> waitingLists = new ArrayList<>();
            String id = waitingListStock.getChildren().get(i1).getAttribute("id").getValue();

            if (waitingListStock.getChildren().get(i1).getChildren() != null) {
                for (int i2 = 0; i2 < waitingListStock.getChildren().get(i1).getChildren().size(); i2++) {
                    Integer amount = Integer.valueOf(waitingListStock.getChildren().get(i1).getChildren().get(i2).getAttribute("amount").getValue());
                    String itemId = waitingListStock.getChildren().get(i1).getChildren().get(i2).getAttribute("item").getValue();
                    WaitingList waitingList = new WaitingList(itemId, amount, null);
                    waitingLists.add(waitingList);
                }

            }
            WaitingListStockMissingPart missingpart = new WaitingListStockMissingPart(id, waitingLists);
            waitingListStockMissingParts.put(id, missingpart);
        }
    }

    private void extractFutureInwardStockMovementOrders(Element fism) {
        for (int i = 0; i < fism.getChildren().size(); i++) {
            String id = fism.getChildren().get(i).getAttribute("id").getValue();
            Integer orderPeriod = Integer.valueOf(fism.getChildren().get(i).getAttribute("orderperiod").getValue());
            Integer mode = Integer.valueOf(fism.getChildren().get(i).getAttribute("mode").getValue());
            String itemId = fism.getChildren().get(i).getAttribute("article").getValue();
            Integer amount = Integer.valueOf(fism.getChildren().get(i).getAttribute("amount").getValue());

            FutureInwardStockMovementOrder order = new FutureInwardStockMovementOrder(id, orderPeriod, mode, itemId, amount);
            futureInwardStockMovementOrders.put(itemId, order);
        }
    }

    private void extractWaitingListsOfWorkstations(Element wlw) {
        for (int i1 = 0; i1 < wlw.getChildren().size(); i1++) {

            List<WaitingList> waitingLists = new ArrayList<>();

            String workplaceId = wlw.getChildren().get(i1).getAttribute("id").getValue();
            Integer timeNeed = Integer.valueOf(wlw.getChildren().get(i1).getAttribute("timeneed").getValue());

            if (wlw.getChildren().get(i1).getChildren() != null) {

                for (int i2 = 0; i2 < wlw.getChildren().get(i1).getChildren().size(); i2++) {
                    String itemId = wlw.getChildren().get(i1).getChildren().get(i2).getAttribute("item").getValue();
                    Integer amount = Integer.valueOf(wlw.getChildren().get(i1).getChildren().get(i2).getAttribute("amount").getValue());
                    Integer timeNeedWaitinglist = Integer.valueOf(wlw.getChildren().get(i1).getChildren().get(i2).getAttribute("timeneed").getValue());
                    WaitingList waitingList = new WaitingList(itemId, amount, timeNeedWaitinglist);
                    waitingLists.add(waitingList);
                }
            }
            WaitingListWorkstation workstation = new WaitingListWorkstation(workplaceId, timeNeed, waitingLists);
            waitingListWorkstations.put(workplaceId, workstation);
        }
    }

    private void extractWarehouseStockArticles(Element warehouseStock) throws ParseException{
        for (int i = 0; i < warehouseStock.getChildren().size(); i++) {
            NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);

            if (warehouseStock.getChildren().get(i).getName().equals("totalstockvalue")) {
                continue;
            }

            String id = warehouseStock.getChildren().get(i).getAttribute("id").getValue();
            Integer amount = Integer.valueOf(warehouseStock.getChildren().get(i).getAttribute("amount").getValue());
            Integer startAmount = Integer.valueOf(warehouseStock.getChildren().get(i).getAttribute("startamount").getValue());
            Double pct = nf.parse(warehouseStock.getChildren().get(i).getAttribute("pct").getValue()).doubleValue();
            Double price = nf.parse(warehouseStock.getChildren().get(i).getAttribute("price").getValue()).doubleValue();
            Double stockValue = nf.parse(warehouseStock.getChildren().get(i).getAttribute("stockvalue").getValue()).doubleValue();

            Article article = new Article(Integer.valueOf(id), amount, startAmount, pct, price, stockValue);

            warehouseStockArticles.put(id, article);
        }
    }

    private void extractOrdersInWorkWorkplaces(Element ordersInWork) {
        for (int i = 0; i < ordersInWork.getChildren().size(); i++) {

            String workplaceId = ordersInWork.getChildren().get(i).getAttribute("id").getValue();
            String itemId = ordersInWork.getChildren().get(i).getAttribute("item").getValue();
            Integer amount = Integer.valueOf(ordersInWork.getChildren().get(i).getAttribute("amount").getValue());
            Integer timeNeed = Integer.valueOf(ordersInWork.getChildren().get(i).getAttribute("timeneed").getValue());

            OrdersInWorkWorkplace workplace = new OrdersInWorkWorkplace(workplaceId, itemId, amount, timeNeed);
            ordersInWorkWorkplaces.put(workplaceId, workplace);
        }
    }

    public int getCurrentPeriod() {
        return period + 1;
    }

    public int getStartAmount(String itemConfigId) {
        itemConfigId = itemConfigId.substring(1);
        if (warehouseStockArticles.get(itemConfigId) == null) {
            return 0;
        }
        return warehouseStockArticles.get(itemConfigId).getStartAmount();

    }

    public int getWarehouseStock(String itemConfigId) {
        itemConfigId = itemConfigId.substring(1);
        if (warehouseStockArticles.get(itemConfigId) == null) {
            return 0;
        }
        return warehouseStockArticles.get(itemConfigId).getAmount();
    }

    public double getPrice(String itemConfigId) {
        itemConfigId = itemConfigId.substring(1);
        if (warehouseStockArticles.get(itemConfigId) == null) {
            return 0;
        }
        return warehouseStockArticles.get(itemConfigId).getPrice();
    }

    public int getAmountOfCurrentWork(String itemConfigId, Integer workplaceId) {
        itemConfigId = itemConfigId.substring(1);
        String workplaceNumber = String.valueOf(workplaceId);
        OrdersInWorkWorkplace workplace = ordersInWorkWorkplaces.get(workplaceNumber);
        if (workplace == null) {
            return 0;
        }
        if (workplace.getItemId().equals(itemConfigId)) {
            return workplace.getAmount();
        }
        return 0;
    }

    public int getTimeNeedOfCurrentWork(String itemConfigId, Integer workplaceId) {
        itemConfigId = itemConfigId.substring(1);
        String workplaceNumber = String.valueOf(workplaceId);
        OrdersInWorkWorkplace workplace = ordersInWorkWorkplaces.get(workplaceNumber);
        if (workplace == null) {
            return 0;
        }
        if (workplace.getItemId().equals(itemConfigId)) {
            return workplace.getTimeNeed();
        }
        return 0;
    }

    public int getWorkInQueue(String itemConfigId, Integer workplaceId) {
        itemConfigId = itemConfigId.substring(1);
        String workplaceNumber = String.valueOf(workplaceId);
        Integer fullAmount = 0;
        WaitingListWorkstation waitingListWorkstation = waitingListWorkstations.get(workplaceNumber);
        if (waitingListWorkstation == null) {
            return 0;
        }
        for (WaitingList waitinglist : waitingListWorkstation.getWaitingLists()) {
            if (waitinglist.getItemId().equals(itemConfigId)) {
                fullAmount += fullAmount + waitinglist.getAmount();
            }
        }
        return fullAmount;
    }

    public int getMissingAmountOfBuyPart(String itemConfigId) {
        if (!itemConfigId.contains("K")) {
            return 0;
        }
        itemConfigId = itemConfigId.substring(1);
        WaitingListStockMissingPart missingPart = waitingListStockMissingParts.get(itemConfigId);
        if (missingPart == null) {
            return 0;
        }
        return missingPart.getWaitingLists().get(0).getAmount();
    }

    public int getWorkInQueue(String itemConfigId) {
        itemConfigId = itemConfigId.substring(1);
        Integer sumAmount = 0;
        for (WaitingListWorkstation workstation : waitingListWorkstations.values()) {
            for (WaitingList waitingList : workstation.getWaitingLists()) {
                if (itemConfigId.equals(waitingList.getItemId())) {
                    sumAmount += waitingList.getAmount();
                }
            }
        }
        return sumAmount;
    }

    public int getInwardStockMovementUntilGivenPeriod(String itemConfigId, double deliveryTime, double variance, Integer period) {
        itemConfigId = itemConfigId.substring(1);
        Collection<FutureInwardStockMovementOrder> orders = (Collection<FutureInwardStockMovementOrder>) futureInwardStockMovementOrders.get(itemConfigId);
        if (orders.isEmpty()) {
            return 0;
        }

        int sumAmount = 0;
        for (FutureInwardStockMovementOrder order : orders) {
            if ((order.getOrderPeriod() + deliveryTime + variance) <= period) {
                sumAmount += order.getAmount();
            }
        }
        return sumAmount;
    }

    public int getCurrentWork(String itemConfigId) {
        Integer sumAmount = 0;
        itemConfigId = itemConfigId.substring(1);

        for (OrdersInWorkWorkplace workplace : ordersInWorkWorkplaces.values()) {
            if (workplace.getItemId().equals(itemConfigId)) {
                sumAmount += workplace.getAmount();
            }
        }
        return sumAmount;
    }

    public int getMissingPartWithoutOrder(String itemConfigId) {
//		if(!itemConfigId.contains("K")) {
//			return 0;
//		}
        itemConfigId = itemConfigId.substring(1);
        Integer result = 0;
        Integer missingpartAmount = 0;
        Integer actualWork = 0;
        Integer WorkinWaitinglist = 0;

        for (WaitingListStockMissingPart missingpart : waitingListStockMissingParts.values()) {
            if (itemConfigId.equals(missingpart.getId())) {
                for (WaitingList waitingList : missingpart.getWaitingLists()) {
                    missingpartAmount += waitingList.getAmount();
                }
            }
        }

        for (OrdersInWorkWorkplace workplace : ordersInWorkWorkplaces.values()) {
            if (workplace.getItemId().equals(itemConfigId)) {
                actualWork += workplace.getAmount();
            }
        }

        for (WaitingListWorkstation workplace : waitingListWorkstations.values()) {
            for (WaitingList waitingList : workplace.getWaitingLists()) {
                if (waitingList.getItemId().equals(itemConfigId)) {
                    WorkinWaitinglist += waitingList.getAmount();
                }
            }
        }

        result = missingpartAmount - actualWork - WorkinWaitinglist;
        if (result < 0) {
            return 0;
        }

        return result;
    }

    public int getOrderAmountOfMissingPart(String itemConfigId) {
        itemConfigId = itemConfigId.substring(1);
        int sum = 0;
        for (WaitingListStockMissingPart missingPart : waitingListStockMissingParts.values()) {

            for (WaitingList waitingList : missingPart.getWaitingLists()) {
                if (waitingList.getItemId().equals(itemConfigId)) {
                    sum += waitingList.getAmount();
                }
            }
        }
        return sum;
    }
}
