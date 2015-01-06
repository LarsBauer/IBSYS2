package de.hska.scsim;

import de.hska.scsim.service.CapacityService;
import de.hska.scsim.service.ProductionService;
import de.hska.scsim.service.PurchaseService;
import de.hska.scsim.ui.MainGUI;
import de.hska.scsim.util.PlanningResultInspector;
import de.hska.scsim.xml.XmlGenerator;
import de.hska.scsim.xml.XmlParser;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Lars
 */
public class Main {

    @Autowired
    private CapacityService capacityService;

    @Autowired
    private ProductionService productionService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private PlanningResultInspector inspector;

    @Autowired
    private XmlGenerator xmlGenerator;

    @Autowired
    private XmlParser xmlParser;

    public static void main(String[] args) {
        final ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/application-context.xml");
        final Main app = ctx.getBean(Main.class);

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MainGUI dialog = MainGUI.create(app.getProductionService(), app.getCapacityService(),
                        app.getPurchaseService(), app.getXmlParser(), app.getInspector(), app.getXmlGenerator());
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            }
        });
    }

    public CapacityService getCapacityService() {
        return capacityService;
    }

    public ProductionService getProductionService() {
        return productionService;
    }

    public PurchaseService getPurchaseService() {
        return purchaseService;
    }

    public PlanningResultInspector getInspector() {
        return inspector;
    }

    public XmlGenerator getXmlGenerator() {
        return xmlGenerator;
    }

    public XmlParser getXmlParser() {
        return xmlParser;
    }

}
