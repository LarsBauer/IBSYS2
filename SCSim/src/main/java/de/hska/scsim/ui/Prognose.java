package de.hska.scsim.ui;

import de.hska.scsim.util.IntegerDocumentFilter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;

public class Prognose extends JPanel {

    private JTextField P3_Auftraege;
    private JTextField P1_Prognose1;
    private JTextField P2_Auftraege;
    private JTextField P2_Prognose1;
    private JTextField P3_Prognose1;
    private JTextField P1_Prognose2;
    private JTextField P2_Prognose2;
    private JTextField P3_Prognose3;
    private JTextField P1_Auftraege;
    private JTextField P3_Prognose2;
    private JTextField P1_Prognose3;
    private JTextField P2_Prognose3;

    private Map<String, Integer> planedSales;

    /**
     * Create the dialog.
     */
    public Prognose() {

        this.setBorder(new EmptyBorder(80, 80, 0, 0));
        this.setFont(new Font("Arial", Font.PLAIN, 11)); //$NON-NLS-1$
        this.setAutoscrolls(true);
        this.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        this.setAlignmentX(Component.RIGHT_ALIGNMENT);
        this.setBackground(Color.WHITE);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{136, 136, 136, 136, 136, 0};
        gbl_panel.rowHeights = new int[]{51, 30, 30, 30, 30, 51, 0};
        gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        this.setLayout(gbl_panel);
        {
            JLabel Filler = new JLabel(""); //$NON-NLS-1$
            GridBagConstraints gbc_Filler = new GridBagConstraints();
            gbc_Filler.fill = GridBagConstraints.BOTH;
            gbc_Filler.insets = new Insets(0, 0, 5, 5);
            gbc_Filler.gridx = 0;
            gbc_Filler.gridy = 0;
            this.add(Filler, gbc_Filler);
        }
        {
            JLabel lblNewLabel_8 = new JLabel(Messages.getString("Prognose.4")); //$NON-NLS-1$
            lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
            gbc_lblNewLabel_8.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_8.gridx = 1;
            gbc_lblNewLabel_8.gridy = 0;
            this.add(lblNewLabel_8, gbc_lblNewLabel_8);
        }
        {
            JLabel lblNewLabel_9 = new JLabel(Messages.getString("Prognose.3")); //$NON-NLS-1$
            lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
            gbc_lblNewLabel_9.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_9.gridx = 2;
            gbc_lblNewLabel_9.gridy = 0;
            this.add(lblNewLabel_9, gbc_lblNewLabel_9);
        }
        {
            JLabel lblNewLabel_10 = new JLabel(Messages.getString("Prognose.2")); //$NON-NLS-1$
            lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
            gbc_lblNewLabel_10.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_10.gridx = 3;
            gbc_lblNewLabel_10.gridy = 0;
            this.add(lblNewLabel_10, gbc_lblNewLabel_10);
        }
        {
            JLabel lblNewLabel_15 = new JLabel(""); //$NON-NLS-1$
            GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
            gbc_lblNewLabel_15.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 0);
            gbc_lblNewLabel_15.gridx = 4;
            gbc_lblNewLabel_15.gridy = 0;
            this.add(lblNewLabel_15, gbc_lblNewLabel_15);
        }
        {
            JLabel lblNewLabel_11 = new JLabel(Messages.getString("Prognose.6")); //$NON-NLS-1$
            lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
            gbc_lblNewLabel_11.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_11.gridx = 0;
            gbc_lblNewLabel_11.gridy = 1;
            this.add(lblNewLabel_11, gbc_lblNewLabel_11);
        }
        {
            P1_Auftraege = new JTextField();
            P1_Auftraege.setFont(new Font("Arial", Font.PLAIN, 11)); //$NON-NLS-1$
            P1_Auftraege.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) P1_Auftraege.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_P1_Auftraege = new GridBagConstraints();
            gbc_P1_Auftraege.fill = GridBagConstraints.BOTH;
            gbc_P1_Auftraege.insets = new Insets(0, 0, 5, 5);
            gbc_P1_Auftraege.gridx = 1;
            gbc_P1_Auftraege.gridy = 1;
            this.add(P1_Auftraege, gbc_P1_Auftraege);
            P1_Auftraege.setColumns(10);
        }
        {
            P2_Auftraege = new JTextField();
            P2_Auftraege.setHorizontalAlignment(SwingConstants.CENTER);
            P2_Auftraege.setFont(new Font("Arial", Font.PLAIN, 11)); //$NON-NLS-1$
            P2_Auftraege.setMargin(new Insets(2, 2, 2, 10));
            ((AbstractDocument) P2_Auftraege.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_P2_Auftraege = new GridBagConstraints();
            gbc_P2_Auftraege.fill = GridBagConstraints.BOTH;
            gbc_P2_Auftraege.insets = new Insets(0, 0, 5, 5);
            gbc_P2_Auftraege.gridx = 2;
            gbc_P2_Auftraege.gridy = 1;
            this.add(P2_Auftraege, gbc_P2_Auftraege);
            P2_Auftraege.setColumns(10);
        }
        {
            P3_Auftraege = new JTextField();
            P3_Auftraege.setHorizontalAlignment(SwingConstants.CENTER);
            P3_Auftraege.setFont(new Font("Arial", Font.PLAIN, 11)); //$NON-NLS-1$
            ((AbstractDocument) P3_Auftraege.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_P3_Auftraege = new GridBagConstraints();
            gbc_P3_Auftraege.fill = GridBagConstraints.BOTH;
            gbc_P3_Auftraege.insets = new Insets(0, 0, 5, 5);
            gbc_P3_Auftraege.gridx = 3;
            gbc_P3_Auftraege.gridy = 1;
            this.add(P3_Auftraege, gbc_P3_Auftraege);
            P3_Auftraege.setColumns(10);
        }
        {
            JLabel lblNewLabel_16 = new JLabel(""); //$NON-NLS-1$
            GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
            gbc_lblNewLabel_16.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 0);
            gbc_lblNewLabel_16.gridx = 4;
            gbc_lblNewLabel_16.gridy = 1;
            this.add(lblNewLabel_16, gbc_lblNewLabel_16);
        }
        {
            JLabel lblNewLabel_13 = new JLabel(Messages.getString("Prognose.11")); //$NON-NLS-1$
            lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
            gbc_lblNewLabel_13.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_13.gridx = 0;
            gbc_lblNewLabel_13.gridy = 2;
            this.add(lblNewLabel_13, gbc_lblNewLabel_13);
        }
        {
            P1_Prognose1 = new JTextField();
            P1_Prognose1.setHorizontalAlignment(SwingConstants.CENTER);
            P1_Prognose1.setFont(new Font("Arial", Font.PLAIN, 11)); //$NON-NLS-1$
            ((AbstractDocument) P1_Prognose1.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_P1_Prognose1 = new GridBagConstraints();
            gbc_P1_Prognose1.fill = GridBagConstraints.BOTH;
            gbc_P1_Prognose1.insets = new Insets(0, 0, 5, 5);
            gbc_P1_Prognose1.gridx = 1;
            gbc_P1_Prognose1.gridy = 2;
            this.add(P1_Prognose1, gbc_P1_Prognose1);
            P1_Prognose1.setColumns(10);
        }
        {
            P2_Prognose1 = new JTextField();
            P2_Prognose1.setHorizontalAlignment(SwingConstants.CENTER);
            P2_Prognose1.setFont(new Font("Arial", Font.PLAIN, 11)); //$NON-NLS-1$
            ((AbstractDocument) P2_Prognose1.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_P2_Prognose1 = new GridBagConstraints();
            gbc_P2_Prognose1.fill = GridBagConstraints.BOTH;
            gbc_P2_Prognose1.insets = new Insets(0, 0, 5, 5);
            gbc_P2_Prognose1.gridx = 2;
            gbc_P2_Prognose1.gridy = 2;
            this.add(P2_Prognose1, gbc_P2_Prognose1);
            P2_Prognose1.setColumns(10);
        }
        {
            P3_Prognose1 = new JTextField();
            P3_Prognose1.setHorizontalAlignment(SwingConstants.CENTER);
            P3_Prognose1.setFont(new Font("Arial", Font.PLAIN, 11)); //$NON-NLS-1$
            ((AbstractDocument) P3_Prognose1.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_P3_Prognose1 = new GridBagConstraints();
            gbc_P3_Prognose1.fill = GridBagConstraints.BOTH;
            gbc_P3_Prognose1.insets = new Insets(0, 0, 5, 5);
            gbc_P3_Prognose1.gridx = 3;
            gbc_P3_Prognose1.gridy = 2;
            this.add(P3_Prognose1, gbc_P3_Prognose1);
            P3_Prognose1.setColumns(10);
        }
        {
            JLabel lblNewLabel_17 = new JLabel(""); //$NON-NLS-1$
            GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
            gbc_lblNewLabel_17.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 0);
            gbc_lblNewLabel_17.gridx = 4;
            gbc_lblNewLabel_17.gridy = 2;
            this.add(lblNewLabel_17, gbc_lblNewLabel_17);
        }
        {
            JLabel lblNewLabel_12 = new JLabel(Messages.getString("Prognose.16")); //$NON-NLS-1$
            lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
            gbc_lblNewLabel_12.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_12.gridx = 0;
            gbc_lblNewLabel_12.gridy = 3;
            this.add(lblNewLabel_12, gbc_lblNewLabel_12);
        }
        {
            P1_Prognose2 = new JTextField();
            P1_Prognose2.setHorizontalAlignment(SwingConstants.CENTER);
            P1_Prognose2.setFont(new Font("Arial", Font.PLAIN, 11)); //$NON-NLS-1$
            ((AbstractDocument) P1_Prognose2.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_P1_Prognose2 = new GridBagConstraints();
            gbc_P1_Prognose2.fill = GridBagConstraints.BOTH;
            gbc_P1_Prognose2.insets = new Insets(0, 0, 5, 5);
            gbc_P1_Prognose2.gridx = 1;
            gbc_P1_Prognose2.gridy = 3;
            this.add(P1_Prognose2, gbc_P1_Prognose2);
            P1_Prognose2.setColumns(10);
        }
        {
            P2_Prognose2 = new JTextField();
            P2_Prognose2.setHorizontalAlignment(SwingConstants.CENTER);
            P2_Prognose2.setFont(new Font("Arial", Font.PLAIN, 11)); //$NON-NLS-1$
            ((AbstractDocument) P2_Prognose2.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_P2_Prognose2 = new GridBagConstraints();
            gbc_P2_Prognose2.fill = GridBagConstraints.BOTH;
            gbc_P2_Prognose2.insets = new Insets(0, 0, 5, 5);
            gbc_P2_Prognose2.gridx = 2;
            gbc_P2_Prognose2.gridy = 3;
            this.add(P2_Prognose2, gbc_P2_Prognose2);
            P2_Prognose2.setColumns(10);
        }
        {
            P3_Prognose2 = new JTextField();
            P3_Prognose2.setHorizontalAlignment(SwingConstants.CENTER);
            P3_Prognose2.setFont(new Font("Arial", Font.PLAIN, 11)); //$NON-NLS-1$
            ((AbstractDocument) P3_Prognose2.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_P3_Prognose2 = new GridBagConstraints();
            gbc_P3_Prognose2.fill = GridBagConstraints.BOTH;
            gbc_P3_Prognose2.insets = new Insets(0, 0, 5, 5);
            gbc_P3_Prognose2.gridx = 3;
            gbc_P3_Prognose2.gridy = 3;
            this.add(P3_Prognose2, gbc_P3_Prognose2);
            P3_Prognose2.setColumns(10);
        }
        {
            JLabel lblNewLabel_18 = new JLabel(""); //$NON-NLS-1$
            GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
            gbc_lblNewLabel_18.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 0);
            gbc_lblNewLabel_18.gridx = 4;
            gbc_lblNewLabel_18.gridy = 3;
            this.add(lblNewLabel_18, gbc_lblNewLabel_18);
        }
        {
            JLabel lblNewLabel_14 = new JLabel(Messages.getString("Prognose.21")); //$NON-NLS-1$
            lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
            gbc_lblNewLabel_14.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_14.gridx = 0;
            gbc_lblNewLabel_14.gridy = 4;
            this.add(lblNewLabel_14, gbc_lblNewLabel_14);
        }
        {
            P1_Prognose3 = new JTextField();
            P1_Prognose3.setHorizontalAlignment(SwingConstants.CENTER);
            P1_Prognose3.setFont(new Font("Arial", Font.PLAIN, 11)); //$NON-NLS-1$
            ((AbstractDocument) P1_Prognose3.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_P1_Prognose3 = new GridBagConstraints();
            gbc_P1_Prognose3.fill = GridBagConstraints.BOTH;
            gbc_P1_Prognose3.insets = new Insets(0, 0, 5, 5);
            gbc_P1_Prognose3.gridx = 1;
            gbc_P1_Prognose3.gridy = 4;
            this.add(P1_Prognose3, gbc_P1_Prognose3);
            P1_Prognose3.setColumns(10);
        }
        {
            P2_Prognose3 = new JTextField();
            P2_Prognose3.setHorizontalAlignment(SwingConstants.CENTER);
            P2_Prognose3.setFont(new Font("Arial", Font.PLAIN, 11)); //$NON-NLS-1$
            ((AbstractDocument) P2_Prognose3.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_P2_Prognose3 = new GridBagConstraints();
            gbc_P2_Prognose3.fill = GridBagConstraints.BOTH;
            gbc_P2_Prognose3.insets = new Insets(0, 0, 5, 5);
            gbc_P2_Prognose3.gridx = 2;
            gbc_P2_Prognose3.gridy = 4;
            this.add(P2_Prognose3, gbc_P2_Prognose3);
            P2_Prognose3.setColumns(10);
        }
        {
            P3_Prognose3 = new JTextField();
            P3_Prognose3.setHorizontalAlignment(SwingConstants.CENTER);
            P3_Prognose3.setFont(new Font("Arial", Font.PLAIN, 11)); //$NON-NLS-1$
            ((AbstractDocument) P3_Prognose3.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_P3_Prognose3 = new GridBagConstraints();
            gbc_P3_Prognose3.fill = GridBagConstraints.BOTH;
            gbc_P3_Prognose3.insets = new Insets(0, 0, 5, 5);
            gbc_P3_Prognose3.gridx = 3;
            gbc_P3_Prognose3.gridy = 4;
            this.add(P3_Prognose3, gbc_P3_Prognose3);
            P3_Prognose3.setColumns(10);
        }
        {
            JLabel label = new JLabel(""); //$NON-NLS-1$
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 5, 0);
            gbc_label.gridx = 4;
            gbc_label.gridy = 4;
            this.add(label, gbc_label);
        }
        {
            JLabel label = new JLabel(""); //$NON-NLS-1$
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 0, 5);
            gbc_label.gridx = 0;
            gbc_label.gridy = 5;
            this.add(label, gbc_label);
        }
        {
            JLabel label = new JLabel(""); //$NON-NLS-1$
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 0, 5);
            gbc_label.gridx = 1;
            gbc_label.gridy = 5;
            this.add(label, gbc_label);
        }
    }

    public Map<String, Integer> getPlanedSales() {

        Map<String, Integer> result = new HashMap<>();

        try {

            result.put("P1", Integer.parseInt(P1_Auftraege.getText()));
            result.put("P2", Integer.parseInt(P2_Auftraege.getText()));
            result.put("P3", Integer.parseInt(P3_Auftraege.getText()));

//			result.put("P1", 100); //$NON-NLS-1$
//			result.put("P2", 100); //$NON-NLS-1$
//			result.put("P3", 100); //$NON-NLS-1$
        } catch (NumberFormatException e) {
            return null;
        }

        return result;
    }

    public List<Map<String, Integer>> getPlanedSalesAndForecasts() {

        List<Map<String, Integer>> result = new ArrayList<>();

        Map<String, Integer> row1 = new HashMap<>();
        Map<String, Integer> row2 = new HashMap<>();
        Map<String, Integer> row3 = new HashMap<>();
        Map<String, Integer> row4 = new HashMap<>();

        try {

            row1.put("P1", Integer.parseInt(P1_Auftraege.getText()));
            row1.put("P2", Integer.parseInt(P2_Auftraege.getText()));
            row1.put("P3", Integer.parseInt(P3_Auftraege.getText()));

            row2.put("P1", Integer.parseInt(P1_Prognose1.getText()));
            row2.put("P2", Integer.parseInt(P2_Prognose1.getText()));
            row2.put("P3", Integer.parseInt(P3_Prognose1.getText()));

            row3.put("P1", Integer.parseInt(P1_Prognose2.getText()));
            row3.put("P2", Integer.parseInt(P2_Prognose2.getText()));
            row3.put("P3", Integer.parseInt(P3_Prognose2.getText()));

            row4.put("P1", Integer.parseInt(P1_Prognose3.getText()));
            row4.put("P2", Integer.parseInt(P2_Prognose3.getText()));
            row4.put("P3", Integer.parseInt(P3_Prognose3.getText()));

            result.add(row1);
            result.add(row2);
            result.add(row3);
            result.add(row4);

        } catch (NumberFormatException e) {
            return null;
        }

        return result;
    }

    public List<Map<String, Integer>> getForecasts() {

        List<Map<String, Integer>> result = new ArrayList<>();

        Map<String, Integer> row2 = new HashMap<>();
        Map<String, Integer> row3 = new HashMap<>();
        Map<String, Integer> row4 = new HashMap<>();

        try {

            row2.put("P1", Integer.parseInt(P1_Prognose1.getText()));
            row2.put("P2", Integer.parseInt(P2_Prognose1.getText()));
            row2.put("P3", Integer.parseInt(P3_Prognose1.getText()));

            row3.put("P1", Integer.parseInt(P1_Prognose2.getText()));
            row3.put("P2", Integer.parseInt(P2_Prognose2.getText()));
            row3.put("P3", Integer.parseInt(P3_Prognose2.getText()));

            row4.put("P1", Integer.parseInt(P1_Prognose3.getText()));
            row4.put("P2", Integer.parseInt(P2_Prognose3.getText()));
            row4.put("P3", Integer.parseInt(P3_Prognose3.getText()));

            result.add(row2);
            result.add(row3);
            result.add(row4);

        } catch (NumberFormatException e) {
            return null;
        }

        return result;
    }
}
