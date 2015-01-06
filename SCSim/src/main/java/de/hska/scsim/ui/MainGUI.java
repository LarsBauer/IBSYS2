package de.hska.scsim.ui;

import de.hska.scsim.util.Messages;
import de.hska.scsim.domain.output.CapacityPlanningResult;
import de.hska.scsim.domain.output.ProductionPlanningResult;
import de.hska.scsim.service.CapacityService;
import de.hska.scsim.service.ProductionService;
import de.hska.scsim.service.PurchaseService;
import de.hska.scsim.util.PlanningResultInspector;
import de.hska.scsim.xml.XmlGenerator;
import de.hska.scsim.xml.XmlParser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Andi
 */
public class MainGUI extends JFrame {

    private final ProductionService productionService;
    private final CapacityService capacityService;
    private final PurchaseService purchaseService;
    private PlanningResultInspector inspector;
    private XmlGenerator xmlGenerator;
    private final XmlParser xmlParser;

    private final JPanel contentPanel = new JPanel();
    private JButton backButton;
    private JButton nextButton;

    private JPanel[] screens;
    private JLabel[] menu;

    private int index;
    private Welcome screen1;
    private Forecast screen2;
    private SafetyStock screen3;
    private ProductionOrder screen4;
    private CapacityPlanning screen5;
    private Order screen6;
    private Prioritization screen7;
    private Completion screen8;

    private List<ProductionPlanningResult> productionPlanningResult;
    private List<CapacityPlanningResult> capacityPlanningResult;

    public static MainGUI create(ProductionService productionPlaningService, CapacityService capacityPlaning,
            PurchaseService purchasePlaning, XmlParser xmlParser,
            PlanningResultInspector planingResultInspector, XmlGenerator xmlGenerator) {
        return new MainGUI(productionPlaningService, capacityPlaning, purchasePlaning, xmlParser,
                planingResultInspector, xmlGenerator);
    }

    public MainGUI(ProductionService productionPlaningService, CapacityService capacityPlaning,
            PurchaseService purchasePlaning, XmlParser xmlParser,
            PlanningResultInspector planingResultInspector, XmlGenerator xmlGenerator) {
        this.productionService = productionPlaningService;
        this.capacityService = capacityPlaning;
        this.purchaseService = purchasePlaning;
        this.xmlParser = xmlParser;
        this.inspector = planingResultInspector;
        this.xmlGenerator = xmlGenerator;

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//	      UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel" );
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        //Erstellung Array vom Datentyp Object, Hinzufügen der Optionen
        Object[] options = {"German", "English"};

        int selected = JOptionPane.showOptionDialog(contentPanel, "Please choose your language:", "",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

        if (selected == 0) {
            Locale.setDefault(Locale.GERMANY);
            createMainScreen();
        } else if (selected == 1) {
            Locale.setDefault(Locale.US);
            createMainScreen();
        } else {
            dispose();
            System.exit(0);
        }
        //Ohne Sprachauswahl
        //Locale.setDefault(Locale.GERMANY);
        //createMainScreen();

    }

    public void createMainScreen() {

        index = 0;
        BufferedImage icon;

        screen1 = new Welcome();
        screen2 = new Forecast();
        screen3 = new SafetyStock();
        screen4 = new ProductionOrder(MainGUI.this);
        screen5 = new CapacityPlanning();
        screen6 = new Order();
        screen7 = new Prioritization();
        screen8 = new Completion();

        screens = new JPanel[8];

        screens[0] = screen1;
        screens[1] = screen2;
        screens[2] = screen3;
        screens[3] = screen4;
        screens[4] = screen5;
        screens[5] = screen6;
        screens[6] = screen7;
        screens[7] = screen8;

        menu = new JLabel[8];

        setTitle(Messages.getString("main.appname"));
        setBounds(100, 100, 1200, 600);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        //Panel mit Navigation
        JPanel northPanel = new JPanel();
        northPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        northPanel.setPreferredSize(new Dimension(10, 50));
        northPanel.setBackground(Color.WHITE);
        contentPanel.add(northPanel, BorderLayout.NORTH);

        //Progress Bar mit Labels
        final JProgressBar bar = new JProgressBar(0, screens.length);
        bar.setValue(index + 1);

        northPanel.setLayout(new BorderLayout());
        northPanel.add(bar, BorderLayout.NORTH);
        JPanel innerPanel = new JPanel(new GridLayout(1, 6));

        JLabel welcomeLbl = new JLabel(Messages.getString("main.welcome")); //Willkommen
        welcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
        innerPanel.add(welcomeLbl);
        menu[0] = welcomeLbl;

        JLabel forecastLbl = new JLabel(Messages.getString("main.forecast")); //Prognose
        forecastLbl.setForeground(Color.LIGHT_GRAY);
        forecastLbl.setHorizontalAlignment(SwingConstants.CENTER);
        innerPanel.add(forecastLbl);
        menu[1] = forecastLbl;

        JLabel safetyLbl = new JLabel(Messages.getString("main.safetystock")); //Sicherheitsbestand
        safetyLbl.setForeground(Color.LIGHT_GRAY);
        safetyLbl.setHorizontalAlignment(SwingConstants.CENTER);
        innerPanel.add(safetyLbl);
        menu[2] = safetyLbl;

        JLabel productionLbl = new JLabel(Messages.getString("main.productionorder")); //Fertigungsaufträge
        productionLbl.setForeground(Color.LIGHT_GRAY);
        productionLbl.setHorizontalAlignment(SwingConstants.CENTER);
        innerPanel.add(productionLbl);
        menu[3] = productionLbl;

        JLabel capacityLbl = new JLabel(Messages.getString("main.capacityplan")); //Kapazitätsplanung
        capacityLbl.setForeground(Color.LIGHT_GRAY);
        capacityLbl.setHorizontalAlignment(SwingConstants.CENTER);
        innerPanel.add(capacityLbl);
        menu[4] = capacityLbl;

        JLabel orderLbl = new JLabel(Messages.getString("main.order")); //Bestellung
        orderLbl.setForeground(Color.LIGHT_GRAY);
        orderLbl.setHorizontalAlignment(SwingConstants.CENTER);
        innerPanel.add(orderLbl);
        menu[5] = orderLbl;

        JLabel lblFertigstellung = new JLabel(Messages.getString("main.prioritization")); //Nachplanung
        lblFertigstellung.setForeground(Color.LIGHT_GRAY);
        lblFertigstellung.setHorizontalAlignment(SwingConstants.CENTER);
        innerPanel.add(lblFertigstellung);
        menu[6] = lblFertigstellung;

        JLabel finishLbl = new JLabel(Messages.getString("main.completion")); //
        finishLbl.setForeground(Color.LIGHT_GRAY);
        finishLbl.setHorizontalAlignment(SwingConstants.CENTER);
        innerPanel.add(finishLbl);
        menu[7] = finishLbl;

        northPanel.add(innerPanel, BorderLayout.CENTER);

        final JPanel iconPanel = new JPanel();
        iconPanel.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
        iconPanel.setPreferredSize(new Dimension(200, 500));
        iconPanel.setBackground(Color.WHITE);
        iconPanel.add(loadImage());
        
        contentPanel.add(iconPanel, BorderLayout.WEST);

        //Content
        contentPanel.add(screen1, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        panel.setBackground(Color.WHITE);

        //Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        backButton = new JButton(Messages.getString("main.back"));
        backButton.setHorizontalAlignment(SwingConstants.LEFT);
        backButton.setActionCommand(Messages.getString("main.ok"));
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                nextButton.setText(Messages.getString("main.next"));

                contentPanel.remove(screens[index]);
                menu[index].setForeground(Color.LIGHT_GRAY);

                if (index == 3) {
                    screen3.setDataFromScreenAfter(screen4.getFieldsValues());
                }

                index -= 1;

                menu[index].setForeground(Color.BLACK);
                contentPanel.add(screens[index]);

                if (index == 0) {
                    backButton.setVisible(false);
                }

                iconPanel.removeAll();
                iconPanel.add(loadImage());
                bar.setValue(index + 1);
                

                contentPanel.revalidate();
                contentPanel.repaint();
            }
        });
        backButton.setVisible(false);
        buttonPanel.add(backButton);

        nextButton = new JButton(Messages.getString("main.next"));
        nextButton.setHorizontalAlignment(SwingConstants.RIGHT);
        nextButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (index == 0) {
                    File xml = new File(screen1.getTextField().getText());
                    if (!xml.exists()) {
                        JOptionPane.showOptionDialog(contentPanel, Messages
                                .getString("main.path"), Messages.getString("main.filenotfound"), //$NON-NLS-1$ //$NON-NLS-2$
                                JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null,
                                null, null);
                        return;
                    }
                    try {
                        xmlParser.checkXmlFile(xml);
                        xmlParser.parse(xml);
                    } catch (Exception ex) {
                        JOptionPane.showOptionDialog(contentPanel, Messages.getString("main.fileinvalid"), Messages.getString("main.parsingerror"), //$NON-NLS-1$ //$NON-NLS-2$
                                JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null,
                                null, null);
                        return;
                    }
                }

                if (index == 1) {
                    if (screen2.getPlanedSales() == null
                            || screen2.getPlanedSalesAndForecasts() == null) {
                        JOptionPane.showOptionDialog(contentPanel, Messages.getString("main.check"), //$NON-NLS-1$
                                Messages.getString("main.incomplete"), JOptionPane.CLOSED_OPTION, //$NON-NLS-1$
                                JOptionPane.WARNING_MESSAGE, null, null, null);
                        return;
                    }
                    screen3.setData(xmlParser);
                }

                if (index == 2) {
                    if (screen3.getSafetyStocks() == null) {
                        JOptionPane.showOptionDialog(contentPanel, Messages.getString("main.fields"), //$NON-NLS-1$
                                Messages.getString("main.data"), JOptionPane.CLOSED_OPTION, //$NON-NLS-1$
                                JOptionPane.WARNING_MESSAGE, null, null, null);
                        return;
                    }
                    productionPlanningResult = productionService.calculateProductionOutput(
                            screen2.getPlanedSales(), screen3.getSafetyStocks());
                    screen4.setDataLabels(productionPlanningResult);
                    screen4.setDataFields(screen3.getSafetyStocks());
                }

                if (index == 3) {
                    capacityPlanningResult = MainGUI.this.capacityService
                            .calculateCapacityRequirements(productionPlanningResult);
                    screen5.setData(capacityPlanningResult);
                }

                if (index == 4) {
                    screen6.setData(MainGUI.this.purchaseService.calculateOrders(productionPlanningResult, screen2.getForecasts()));
                }

                if (index == 5) {
                    screen7.setData(productionPlanningResult);

                    // Erstellung Array vom Datentyp Object, Hinzufügen der Optionen
                    Object[] options = {Messages.getString("main.continue"), Messages.getString("main.edit")};

                    double stockValue = inspector.checkStockValue(productionPlanningResult, screen6.getData(), screen2.getPlanedSales());

                    //Dialog Lagermenge
                    if (stockValue < 250000.0) {
                        JOptionPane.showOptionDialog(contentPanel, Messages.getString("dialog.stockvalue") + stockValue + Messages.getString("dialog.nocosts"), Messages.getString("main.stockvalue"), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

                    } else {
                        int selected = JOptionPane.showOptionDialog(contentPanel, Messages.getString("dialog.stockvalue") + stockValue + Messages.getString("dialog.additionalcosts"), Messages.getString("main.stockvalue"), JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, options, 0);

                        if (selected == 1) {
                            return;
                        }
                    }
                }

                if (index == 7) {
                    screen8.getSuc().saveAs(null, MainGUI.this, screen7.getData(), capacityPlanningResult, screen6.getData(), screen2.getPlanedSales(), xmlGenerator);

                } else {

                    menu[index].setForeground(Color.LIGHT_GRAY);
                    backButton.setVisible(true);
                    contentPanel.remove(screens[index]);

                    index += 1;

                    contentPanel.add(screens[index]);
                    menu[index].setForeground(Color.BLACK);
                    bar.setValue(index + 1);
                    iconPanel.removeAll();
                    iconPanel.add(loadImage());
                    
                    contentPanel.revalidate();
                    contentPanel.repaint();

                    if (index == 7) {
                        nextButton.setText(Messages.getString("main.finish"));
                    }
                }

            }
        });
        buttonPanel.add(nextButton);

        getRootPane().setDefaultButton(nextButton);
        nextButton.requestFocusInWindow();
    }

    public void FertigungsauftraegeNeuGenerieren(Map<String, Integer> data) {

        productionPlanningResult = productionService.calculateProductionOutput(screen2.getPlanedSales(), data);
        screen4.setDataLabels(productionPlanningResult);
    }
    
    public JLabel loadImage(){
        //Bilddatei zuweisen nach index
        String picpath = "icon/";
        switch(index){
            case 0: picpath += "1_welcome";
                break;
            case 1: picpath += "2_forecast";
                break;
            case 2: picpath += "3_safetystock";
                break;
            case 3: picpath += "4_production";
                break;
            case 4: picpath += "5_capacity";
                break;
            case 5: picpath += "6_purchase";
                break;
            case 6: picpath += "7_priorization";
                break;
            case 7: picpath += "8_finish";
                break;
            default: picpath = "";
        }
        picpath += ".png";
            
        
        try {
        	InputStream stream = this.getClass().getClassLoader().getResourceAsStream(picpath);
            BufferedImage icon = ImageIO.read(stream);
            icon = resize(icon, 150, 150);
            JLabel picLabel = new JLabel(new ImageIcon(icon));
            return picLabel;
        } catch (IOException e) {
            return new JLabel("Image not found");
        }
    }

    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    public JButton getCancelButton() {
        return nextButton;
    }

}
