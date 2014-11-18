package de.hska.scsim.ui;

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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
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
    private JButton okButton;
    private JButton cancelButton;

    private JPanel[] screens;
    private JLabel[] menu;

    private int index;
    private Willkommen screen1;
    private Prognose screen2;
    private Sicherheitsbestand screen3;
    private Fertigungsauftraege screen4;
    private Kapazitaetsplanung screen5;
    private Bestellung screen6;
    private Nachplanung screen7;
    private Fertigstellung screen8;

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
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Erstellung Array vom Datentyp Object, Hinzufügen der Optionen
        Object[] options = {"German", "English"};

        int selected = JOptionPane.showOptionDialog(contentPanel, "What language do you wish to use?", "", //$NON-NLS-1$ //$NON-NLS-2$
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

        if (selected == 0) {
            Locale de = Locale.GERMANY;
            Locale.setDefault(de);
            createMainScreen();
        } else if (selected == 1) {
            Locale eng = Locale.ENGLISH;
            Locale.setDefault(eng);
            createMainScreen();
        } else {
            dispose();
            System.exit(0);
        }
    }

    public void createMainScreen() {

        index = 0;

        screen1 = new Willkommen();
        screen2 = new Prognose();
        screen3 = new Sicherheitsbestand();
        screen4 = new Fertigungsauftraege(MainGUI.this);
        screen5 = new Kapazitaetsplanung();
        screen6 = new Bestellung();
        screen7 = new Nachplanung();
        screen8 = new Fertigstellung();

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

        setTitle("Programmname");
        setBounds(100, 100, 1000, 600);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        {
            JPanel panel = new JPanel();
            panel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
            panel.setPreferredSize(new Dimension(130, 10));
            panel.setBackground(Color.WHITE);
            contentPanel.add(panel, BorderLayout.WEST);
            panel.setLayout(new GridLayout(0, 1, 0, 0));
            {
                JLabel lblNewLabel_1 = new JLabel(Messages.getString("MainGUI.0")); //$NON-NLS-1$
                lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(lblNewLabel_1);
                menu[0] = lblNewLabel_1;
            }
            {
                JLabel lblNewLabel = new JLabel(Messages.getString("MainGUI.1")); //$NON-NLS-1$
                lblNewLabel.setForeground(Color.LIGHT_GRAY);
                lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(lblNewLabel);
                menu[1] = lblNewLabel;
            }
            {
                JLabel lblNewLabel_2 = new JLabel(Messages.getString("MainGUI.2")); //$NON-NLS-1$
                lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
                lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(lblNewLabel_2);
                menu[2] = lblNewLabel_2;
            }
            {
                JLabel lblNewLabel_3 = new JLabel(Messages.getString("MainGUI.3")); //$NON-NLS-1$
                lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
                lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(lblNewLabel_3);
                menu[3] = lblNewLabel_3;
            }
            {
                JLabel lblNewLabel_4 = new JLabel(Messages.getString("MainGUI.4")); //$NON-NLS-1$
                lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
                lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(lblNewLabel_4);
                menu[4] = lblNewLabel_4;
            }
            {
                JLabel lblNewLabel_5 = new JLabel(Messages.getString("MainGUI.5")); //$NON-NLS-1$
                lblNewLabel_5.setForeground(Color.LIGHT_GRAY);
                lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(lblNewLabel_5);
                menu[5] = lblNewLabel_5;
            }
            {
                JLabel lblFertigstellung = new JLabel(Messages.getString("MainGUI.4")); //$NON-NLS-1$
                lblFertigstellung.setForeground(Color.LIGHT_GRAY);
                lblFertigstellung.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(lblFertigstellung);
                menu[6] = lblFertigstellung;
            }
            {
                JLabel lblFertigstellung = new JLabel(Messages.getString("MainGUI.6")); //$NON-NLS-1$
                lblFertigstellung.setForeground(Color.LIGHT_GRAY);
                lblFertigstellung.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(lblFertigstellung);
                menu[7] = lblFertigstellung;
            }
        }
        contentPanel.add(screen1, BorderLayout.CENTER);
        {
            JPanel panel = new JPanel();
            panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
            panel.setBackground(Color.WHITE);
            contentPanel.add(panel, BorderLayout.NORTH);
            {
                //Header
                try {
                    InputStream stream = null;
                    try {
//                        stream = new ClassPathResource("img/header.jpg").getInputStream();
//                        BufferedImage picture = ImageIO.read(stream);
//                        JLabel lblNewLabel_6 = new JLabel(new ImageIcon(picture));
                        JLabel lblNewLabel_6 = new JLabel("Programmname", JLabel.CENTER);
                        panel.add(lblNewLabel_6);
                    } finally {
                        if (stream != null) {
                            stream.close();
                        }
                    }
                } catch (IOException e) {
                    JLabel lblNewLabel_6 = new JLabel("Programmname");
                    panel.add(lblNewLabel_6);
                }
            }
        }
        {
            JPanel buttonPane = new JPanel();
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            GridBagLayout gbl_buttonPane = new GridBagLayout();
            gbl_buttonPane.columnWidths = new int[]{442, 442, 0};
            gbl_buttonPane.rowHeights = new int[]{23, 0};
            gbl_buttonPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
            gbl_buttonPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
            buttonPane.setLayout(gbl_buttonPane);
            {
                okButton = new JButton(Messages.getString("MainGUI.8")); //$NON-NLS-1$
                okButton.setHorizontalAlignment(SwingConstants.LEFT);
                okButton.setActionCommand(Messages.getString("MainGUI.9")); //$NON-NLS-1$
                GridBagConstraints gbc_okButton = new GridBagConstraints();
                gbc_okButton.anchor = GridBagConstraints.WEST;
                gbc_okButton.insets = new Insets(0, 85, 0, 5);
                gbc_okButton.gridx = 0;
                gbc_okButton.gridy = 0;
                buttonPane.add(okButton, gbc_okButton);
                getRootPane().setDefaultButton(okButton);
                okButton.setVisible(false);
                okButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        cancelButton.setText(Messages.getString("MainGUI.10")); //$NON-NLS-1$

                        contentPanel.remove(screens[index]);
                        menu[index].setForeground(Color.LIGHT_GRAY);

                        if (index == 3) {
                            screen3.setDataFromScreenAfter(screen4.getFieldsValues());
                        }

                        index -= 1;

                        menu[index].setForeground(Color.BLACK);
                        contentPanel.add(screens[index]);

                        if (index == 0) {
                            okButton.setVisible(false);
                        }

                        contentPanel.revalidate();
                        contentPanel.repaint();
                    }
                });
            }
            {
                cancelButton = new JButton(Messages.getString("MainGUI.12")); //$NON-NLS-1$
                cancelButton.setHorizontalAlignment(SwingConstants.RIGHT);
                GridBagConstraints gbc_cancelButton = new GridBagConstraints();
                gbc_cancelButton.insets = new Insets(0, 0, 0, 0);
                gbc_cancelButton.anchor = GridBagConstraints.EAST;
                gbc_cancelButton.gridx = 1;
                gbc_cancelButton.gridy = 0;
                buttonPane.add(cancelButton, gbc_cancelButton);
                {
                    JMenuBar menuBar = new JMenuBar();
//					 getContentPane().add(menuBar, BorderLayout.NORTH);
                    {
                        JMenu mnNewMenu = new JMenu(Messages.getString("MainGUI.11")); //$NON-NLS-1$
                        menuBar.add(mnNewMenu);
                        {
                            JMenuItem mntmSprache = new JMenuItem(Messages.getString("MainGUI.20")); //$NON-NLS-1$
                            mnNewMenu.add(mntmSprache);
                            mntmSprache.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent arg0) {
                                    ResourceBundle.clearCache();
                                    Locale de = Locale.GERMANY;
                                    Locale.setDefault(de);
                                    contentPanel.revalidate();
                                    contentPanel.repaint();
                                }
                            });
                        }
                        {
                            JMenuItem mntmNewMenuItem = new JMenuItem(Messages.getString("MainGUI.21")); //$NON-NLS-1$
                            mnNewMenu.add(mntmNewMenuItem);
                            mntmNewMenuItem.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent arg0) {
                                    ResourceBundle.clearCache();
                                    Locale eng = Locale.ENGLISH;
                                    Locale.setDefault(eng);
                                    contentPanel.revalidate();
                                    contentPanel.repaint();
                                }
                            });
                        }
                    }
                }
                cancelButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (index == 0) {
                            File xml = new File(screen1.getTextField().getText());
                            if (!xml.exists()) {
                                JOptionPane.showOptionDialog(contentPanel, Messages
                                        .getString("MainGUI.17"), Messages.getString("MainGUI.18"), //$NON-NLS-1$ //$NON-NLS-2$
                                        JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null,
                                        null, null);
                                return;
                            }
                            try {
                                xmlParser.checkXmlFile(xml);
                                xmlParser.parse(xml);
                            } catch (Exception ex) {
                                JOptionPane.showOptionDialog(contentPanel, Messages.getString("MainGUI.30"), Messages.getString("MainGUI.31"), //$NON-NLS-1$ //$NON-NLS-2$
                                        JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null,
                                        null, null);
                                return;
                            }
                        }

                        if (index == 1) {
                            if (screen2.getPlanedSales() == null
                                    || screen2.getPlanedSalesAndForecasts() == null) {
                                JOptionPane.showOptionDialog(contentPanel, Messages.getString("MainGUI.13"), //$NON-NLS-1$
                                        Messages.getString("MainGUI.14"), JOptionPane.CLOSED_OPTION, //$NON-NLS-1$
                                        JOptionPane.WARNING_MESSAGE, null, null, null);
                                return;
                            }
                            screen3.setData(xmlParser);
                        }

                        if (index == 2) {
                            if (screen3.getSafetyStocks() == null) {
                                JOptionPane.showOptionDialog(contentPanel, Messages.getString("MainGUI.15"), //$NON-NLS-1$
                                        Messages.getString("MainGUI.16"), JOptionPane.CLOSED_OPTION, //$NON-NLS-1$
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
                            Object[] options = {"Ändern", "Weiter"};

                            double stockValue = inspector.checkStockValue(productionPlanningResult, screen6.getData(), screen2.getPlanedSales());

                            if (stockValue < 250000.0) {
                                JOptionPane.showOptionDialog(contentPanel, Messages.getString("MainGUI.32") + stockValue + Messages.getString("MainGUI.27"), Messages.getString("MainGUI.28"), JOptionPane.CLOSED_OPTION, //$NON-NLS-1$
                                        JOptionPane.INFORMATION_MESSAGE, null, null, null);
                            } else {
                                int selected = JOptionPane.showOptionDialog(contentPanel, Messages.getString("MainGUI.32") + stockValue + Messages.getString("MainGUI.29"), "", //$NON-NLS-1$ //$NON-NLS-2$
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

                                if (selected == 0) {
                                    return;
                                } else if (selected == 1) {

                                }
                            }
                        }

                        if (index == 7) {
                            screen8.getSuc().saveAs(null, MainGUI.this, screen7.getData(), capacityPlanningResult, screen6.getData(), screen2.getPlanedSales(), xmlGenerator);

                        } else {

                            menu[index].setForeground(Color.LIGHT_GRAY);
                            okButton.setVisible(true);
                            contentPanel.remove(screens[index]);

                            index += 1;

                            contentPanel.add(screens[index]);
                            menu[index].setForeground(Color.BLACK);
                            contentPanel.revalidate();
                            contentPanel.repaint();

                            if (index == 7) {
                                cancelButton.setText(Messages.getString("MainGUI.19")); //$NON-NLS-1$
                            }
                        }

                    }
                });
            }
        }
    }

    public void FertigungsauftraegeNeuGenerieren(Map<String, Integer> data) {

        productionPlanningResult = productionService.calculateProductionOutput(screen2.getPlanedSales(), data);
        screen4.setDataLabels(productionPlanningResult);
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}
