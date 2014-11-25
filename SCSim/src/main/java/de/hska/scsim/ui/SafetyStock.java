package de.hska.scsim.ui;

import de.hska.scsim.util.Messages;
import de.hska.scsim.util.IntegerDocumentFilter;
import de.hska.scsim.xml.XmlParser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;

public class SafetyStock extends JPanel {

    private JTextField P1_Value;
    private JTextField P2_Value;
    private JTextField P3_Value;
    private JTextField E51_Value;
    private JTextField E56_Value;
    private JTextField E31_Value;
    private JTextField E50_Value;
    private JTextField E55_Value;
    private JTextField E30_Value;
    private JTextField E4_Value;
    private JTextField E5_Value;
    private JTextField E6_Value;
    private JTextField E10_Value;
    private JTextField E11_Value;
    private JTextField E12_Value;
    private JTextField E49_Value;
    private JTextField E54_Value;
    private JTextField E29_Value;
    private JTextField E7_Value;
    private JTextField E8_Value;
    private JTextField E9_Value;
    private JTextField E13_Value;
    private JTextField E14_Value;
    private JTextField E15_Value;
    private JTextField E18_Value;
    private JTextField E19_Value;
    private JTextField E20_Value;
    private JTextField E26_Value;
    private JTextField E16_Value;
    private JTextField E17_Value;

    /**
     * Create the dialog.
     */
    public SafetyStock() {

        this.setFont(new Font("Arial", Font.PLAIN, 11));
        this.setAutoscrolls(true);
        this.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        this.setAlignmentX(Component.RIGHT_ALIGNMENT);
        this.setBackground(Color.WHITE);
        GridBagLayout gbl_this = new GridBagLayout();
        gbl_this.columnWidths = new int[]{72, 124, 124, 124, 124, 124, 15};
        gbl_this.rowHeights = new int[]{33, 22, 22, 22, 22, 22, 22, 22, 22, 22, 33, 22, 22, 22, 0};
        gbl_this.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_this.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
            0.0, 0.0, 0.0, Double.MIN_VALUE};
        this.setLayout(gbl_this);
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 5, 5);
            gbc_label.gridx = 0;
            gbc_label.gridy = 0;
            this.add(label, gbc_label);
        }
        {
            JLabel lblProdukt = new JLabel(Messages.getString("Buffer.2"));
            lblProdukt.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblProdukt = new GridBagConstraints();
            gbc_lblProdukt.fill = GridBagConstraints.BOTH;
            gbc_lblProdukt.insets = new Insets(0, 0, 5, 5);
            gbc_lblProdukt.gridx = 1;
            gbc_lblProdukt.gridy = 0;
            this.add(lblProdukt, gbc_lblProdukt);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 5, 5);
            gbc_label.gridx = 2;
            gbc_label.gridy = 0;
            this.add(label, gbc_label);
        }
        {
            JLabel lblProdukt_1 = new JLabel(Messages.getString("Buffer.4"));
            lblProdukt_1.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblProdukt_1 = new GridBagConstraints();
            gbc_lblProdukt_1.fill = GridBagConstraints.BOTH;
            gbc_lblProdukt_1.insets = new Insets(0, 0, 5, 5);
            gbc_lblProdukt_1.gridx = 3;
            gbc_lblProdukt_1.gridy = 0;
            this.add(lblProdukt_1, gbc_lblProdukt_1);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 5, 5);
            gbc_label.gridx = 4;
            gbc_label.gridy = 0;
            this.add(label, gbc_label);
        }
        {
            JLabel lblPrdoukt = new JLabel(Messages.getString("Buffer.6"));
            lblPrdoukt.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblPrdoukt = new GridBagConstraints();
            gbc_lblPrdoukt.fill = GridBagConstraints.BOTH;
            gbc_lblPrdoukt.insets = new Insets(0, 0, 5, 0);
            gbc_lblPrdoukt.gridx = 5;
            gbc_lblPrdoukt.gridy = 0;
            this.add(lblPrdoukt, gbc_lblPrdoukt);
        }
        {
            JLabel lblNewLabel_7 = new JLabel("P1");
            lblNewLabel_7.setBorder(new EmptyBorder(0, 42, 0, 0));
            GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
            gbc_lblNewLabel_7.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_7.gridx = 0;
            gbc_lblNewLabel_7.gridy = 1;
            this.add(lblNewLabel_7, gbc_lblNewLabel_7);
        }
        {
            P1_Value = new JTextField();
            P1_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) P1_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_P1_Value = new GridBagConstraints();
            gbc_P1_Value.fill = GridBagConstraints.BOTH;
            gbc_P1_Value.insets = new Insets(0, 0, 5, 5);
            gbc_P1_Value.gridx = 1;
            gbc_P1_Value.gridy = 1;
            this.add(P1_Value, gbc_P1_Value);
            P1_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_8 = new JLabel("P2");
            lblNewLabel_8.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
            gbc_lblNewLabel_8.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_8.gridx = 2;
            gbc_lblNewLabel_8.gridy = 1;
            this.add(lblNewLabel_8, gbc_lblNewLabel_8);
        }
        {
            P2_Value = new JTextField();
            P2_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) P2_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_P2_Value = new GridBagConstraints();
            gbc_P2_Value.fill = GridBagConstraints.BOTH;
            gbc_P2_Value.insets = new Insets(0, 0, 5, 5);
            gbc_P2_Value.gridx = 3;
            gbc_P2_Value.gridy = 1;
            this.add(P2_Value, gbc_P2_Value);
            P2_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_9 = new JLabel("P3");
            lblNewLabel_9.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
            gbc_lblNewLabel_9.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_9.gridx = 4;
            gbc_lblNewLabel_9.gridy = 1;
            this.add(lblNewLabel_9, gbc_lblNewLabel_9);
        }
        {
            P3_Value = new JTextField();
            P3_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) P3_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_P3_Value = new GridBagConstraints();
            gbc_P3_Value.fill = GridBagConstraints.BOTH;
            gbc_P3_Value.insets = new Insets(0, 0, 5, 0);
            gbc_P3_Value.gridx = 5;
            gbc_P3_Value.gridy = 1;
            this.add(P3_Value, gbc_P3_Value);
            P3_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_10 = new JLabel("E51");
            lblNewLabel_10.setBorder(new EmptyBorder(0, 42, 0, 0));
            GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
            gbc_lblNewLabel_10.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_10.gridx = 0;
            gbc_lblNewLabel_10.gridy = 2;
            this.add(lblNewLabel_10, gbc_lblNewLabel_10);
        }
        {
            E51_Value = new JTextField();
            E51_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E51_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E51_Value = new GridBagConstraints();
            gbc_E51_Value.fill = GridBagConstraints.BOTH;
            gbc_E51_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E51_Value.gridx = 1;
            gbc_E51_Value.gridy = 2;
            this.add(E51_Value, gbc_E51_Value);
            E51_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_11 = new JLabel("E56");
            lblNewLabel_11.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
            gbc_lblNewLabel_11.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_11.gridx = 2;
            gbc_lblNewLabel_11.gridy = 2;
            this.add(lblNewLabel_11, gbc_lblNewLabel_11);
        }
        {
            E56_Value = new JTextField();
            E56_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E56_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E56_Value = new GridBagConstraints();
            gbc_E56_Value.fill = GridBagConstraints.BOTH;
            gbc_E56_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E56_Value.gridx = 3;
            gbc_E56_Value.gridy = 2;
            this.add(E56_Value, gbc_E56_Value);
            E56_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_13 = new JLabel("E31");
            lblNewLabel_13.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
            gbc_lblNewLabel_13.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_13.gridx = 4;
            gbc_lblNewLabel_13.gridy = 2;
            this.add(lblNewLabel_13, gbc_lblNewLabel_13);
        }
        {
            E31_Value = new JTextField();
            E31_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E31_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E31_Value = new GridBagConstraints();
            gbc_E31_Value.fill = GridBagConstraints.BOTH;
            gbc_E31_Value.insets = new Insets(0, 0, 5, 0);
            gbc_E31_Value.gridx = 5;
            gbc_E31_Value.gridy = 2;
            this.add(E31_Value, gbc_E31_Value);
            E31_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_14 = new JLabel("E50");
            lblNewLabel_14.setBorder(new EmptyBorder(0, 42, 0, 0));
            GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
            gbc_lblNewLabel_14.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_14.gridx = 0;
            gbc_lblNewLabel_14.gridy = 3;
            this.add(lblNewLabel_14, gbc_lblNewLabel_14);
        }
        {
            E50_Value = new JTextField();
            E50_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E50_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E50_Value = new GridBagConstraints();
            gbc_E50_Value.fill = GridBagConstraints.BOTH;
            gbc_E50_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E50_Value.gridx = 1;
            gbc_E50_Value.gridy = 3;
            this.add(E50_Value, gbc_E50_Value);
            E50_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_15 = new JLabel("E55");
            lblNewLabel_15.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
            gbc_lblNewLabel_15.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_15.gridx = 2;
            gbc_lblNewLabel_15.gridy = 3;
            this.add(lblNewLabel_15, gbc_lblNewLabel_15);
        }
        {
            E55_Value = new JTextField();
            E55_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E55_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E55_Value = new GridBagConstraints();
            gbc_E55_Value.fill = GridBagConstraints.BOTH;
            gbc_E55_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E55_Value.gridx = 3;
            gbc_E55_Value.gridy = 3;
            this.add(E55_Value, gbc_E55_Value);
            E55_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_16 = new JLabel("E30");
            lblNewLabel_16.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
            gbc_lblNewLabel_16.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_16.gridx = 4;
            gbc_lblNewLabel_16.gridy = 3;
            this.add(lblNewLabel_16, gbc_lblNewLabel_16);
        }
        {
            E30_Value = new JTextField();
            E30_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E30_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E30_Value = new GridBagConstraints();
            gbc_E30_Value.fill = GridBagConstraints.BOTH;
            gbc_E30_Value.insets = new Insets(0, 0, 5, 0);
            gbc_E30_Value.gridx = 5;
            gbc_E30_Value.gridy = 3;
            this.add(E30_Value, gbc_E30_Value);
            E30_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_17 = new JLabel("E4");
            lblNewLabel_17.setBorder(new EmptyBorder(0, 42, 0, 0));
            GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
            gbc_lblNewLabel_17.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_17.gridx = 0;
            gbc_lblNewLabel_17.gridy = 4;
            this.add(lblNewLabel_17, gbc_lblNewLabel_17);
        }
        {
            E4_Value = new JTextField();
            E4_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E4_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E4_Value = new GridBagConstraints();
            gbc_E4_Value.fill = GridBagConstraints.BOTH;
            gbc_E4_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E4_Value.gridx = 1;
            gbc_E4_Value.gridy = 4;
            this.add(E4_Value, gbc_E4_Value);
            E4_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_18 = new JLabel("E5");
            lblNewLabel_18.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
            gbc_lblNewLabel_18.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_18.gridx = 2;
            gbc_lblNewLabel_18.gridy = 4;
            this.add(lblNewLabel_18, gbc_lblNewLabel_18);
        }
        {
            E5_Value = new JTextField();
            E5_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E5_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E5_Value = new GridBagConstraints();
            gbc_E5_Value.fill = GridBagConstraints.BOTH;
            gbc_E5_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E5_Value.gridx = 3;
            gbc_E5_Value.gridy = 4;
            this.add(E5_Value, gbc_E5_Value);
            E5_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_19 = new JLabel("E6");
            lblNewLabel_19.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
            gbc_lblNewLabel_19.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_19.gridx = 4;
            gbc_lblNewLabel_19.gridy = 4;
            this.add(lblNewLabel_19, gbc_lblNewLabel_19);
        }
        {
            E6_Value = new JTextField();
            E6_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E6_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E6_Value = new GridBagConstraints();
            gbc_E6_Value.fill = GridBagConstraints.BOTH;
            gbc_E6_Value.insets = new Insets(0, 0, 5, 0);
            gbc_E6_Value.gridx = 5;
            gbc_E6_Value.gridy = 4;
            this.add(E6_Value, gbc_E6_Value);
            E6_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_20 = new JLabel("E10");
            lblNewLabel_20.setBorder(new EmptyBorder(0, 42, 0, 0));
            GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
            gbc_lblNewLabel_20.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_20.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_20.gridx = 0;
            gbc_lblNewLabel_20.gridy = 5;
            this.add(lblNewLabel_20, gbc_lblNewLabel_20);
        }
        {
            E10_Value = new JTextField();
            E10_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E10_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E10_Value = new GridBagConstraints();
            gbc_E10_Value.fill = GridBagConstraints.BOTH;
            gbc_E10_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E10_Value.gridx = 1;
            gbc_E10_Value.gridy = 5;
            this.add(E10_Value, gbc_E10_Value);
            E10_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_12 = new JLabel("E11");
            lblNewLabel_12.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
            gbc_lblNewLabel_12.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_12.gridx = 2;
            gbc_lblNewLabel_12.gridy = 5;
            this.add(lblNewLabel_12, gbc_lblNewLabel_12);
        }
        {
            E11_Value = new JTextField();
            E11_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E11_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E11_Value = new GridBagConstraints();
            gbc_E11_Value.fill = GridBagConstraints.BOTH;
            gbc_E11_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E11_Value.gridx = 3;
            gbc_E11_Value.gridy = 5;
            this.add(E11_Value, gbc_E11_Value);
            E11_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_21 = new JLabel("E12");
            lblNewLabel_21.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
            gbc_lblNewLabel_21.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_21.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_21.gridx = 4;
            gbc_lblNewLabel_21.gridy = 5;
            this.add(lblNewLabel_21, gbc_lblNewLabel_21);
        }
        {
            E12_Value = new JTextField();
            E12_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E12_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E12_Value = new GridBagConstraints();
            gbc_E12_Value.fill = GridBagConstraints.BOTH;
            gbc_E12_Value.insets = new Insets(0, 0, 5, 0);
            gbc_E12_Value.gridx = 5;
            gbc_E12_Value.gridy = 5;
            this.add(E12_Value, gbc_E12_Value);
            E12_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_22 = new JLabel("E49");
            lblNewLabel_22.setBorder(new EmptyBorder(0, 42, 0, 0));
            GridBagConstraints gbc_lblNewLabel_22 = new GridBagConstraints();
            gbc_lblNewLabel_22.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_22.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_22.gridx = 0;
            gbc_lblNewLabel_22.gridy = 6;
            this.add(lblNewLabel_22, gbc_lblNewLabel_22);
        }
        {
            E49_Value = new JTextField();
            E49_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E49_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E49_Value = new GridBagConstraints();
            gbc_E49_Value.fill = GridBagConstraints.BOTH;
            gbc_E49_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E49_Value.gridx = 1;
            gbc_E49_Value.gridy = 6;
            this.add(E49_Value, gbc_E49_Value);
            E49_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_23 = new JLabel("E54");
            lblNewLabel_23.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_23 = new GridBagConstraints();
            gbc_lblNewLabel_23.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_23.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_23.gridx = 2;
            gbc_lblNewLabel_23.gridy = 6;
            this.add(lblNewLabel_23, gbc_lblNewLabel_23);
        }
        {
            E54_Value = new JTextField();
            E54_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E54_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E54_Value = new GridBagConstraints();
            gbc_E54_Value.fill = GridBagConstraints.BOTH;
            gbc_E54_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E54_Value.gridx = 3;
            gbc_E54_Value.gridy = 6;
            this.add(E54_Value, gbc_E54_Value);
            E54_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_24 = new JLabel("E29");
            lblNewLabel_24.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_24 = new GridBagConstraints();
            gbc_lblNewLabel_24.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_24.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_24.gridx = 4;
            gbc_lblNewLabel_24.gridy = 6;
            this.add(lblNewLabel_24, gbc_lblNewLabel_24);
        }
        {
            E29_Value = new JTextField();
            E29_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E29_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E29_Value = new GridBagConstraints();
            gbc_E29_Value.fill = GridBagConstraints.BOTH;
            gbc_E29_Value.insets = new Insets(0, 0, 5, 0);
            gbc_E29_Value.gridx = 5;
            gbc_E29_Value.gridy = 6;
            this.add(E29_Value, gbc_E29_Value);
            E29_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_25 = new JLabel("E7");
            lblNewLabel_25.setBorder(new EmptyBorder(0, 42, 0, 0));
            GridBagConstraints gbc_lblNewLabel_25 = new GridBagConstraints();
            gbc_lblNewLabel_25.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_25.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_25.gridx = 0;
            gbc_lblNewLabel_25.gridy = 7;
            this.add(lblNewLabel_25, gbc_lblNewLabel_25);
        }
        {
            E7_Value = new JTextField();
            E7_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E7_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E7_Value = new GridBagConstraints();
            gbc_E7_Value.fill = GridBagConstraints.BOTH;
            gbc_E7_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E7_Value.gridx = 1;
            gbc_E7_Value.gridy = 7;
            this.add(E7_Value, gbc_E7_Value);
            E7_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_26 = new JLabel("E8");
            lblNewLabel_26.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_26 = new GridBagConstraints();
            gbc_lblNewLabel_26.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_26.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_26.gridx = 2;
            gbc_lblNewLabel_26.gridy = 7;
            this.add(lblNewLabel_26, gbc_lblNewLabel_26);
        }
        {
            E8_Value = new JTextField();
            E8_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E8_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E8_Value = new GridBagConstraints();
            gbc_E8_Value.fill = GridBagConstraints.BOTH;
            gbc_E8_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E8_Value.gridx = 3;
            gbc_E8_Value.gridy = 7;
            this.add(E8_Value, gbc_E8_Value);
            E8_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_27 = new JLabel("E9");
            lblNewLabel_27.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_27 = new GridBagConstraints();
            gbc_lblNewLabel_27.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_27.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_27.gridx = 4;
            gbc_lblNewLabel_27.gridy = 7;
            this.add(lblNewLabel_27, gbc_lblNewLabel_27);
        }
        {
            E9_Value = new JTextField();
            E9_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E9_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E9_Value = new GridBagConstraints();
            gbc_E9_Value.fill = GridBagConstraints.BOTH;
            gbc_E9_Value.insets = new Insets(0, 0, 5, 0);
            gbc_E9_Value.gridx = 5;
            gbc_E9_Value.gridy = 7;
            this.add(E9_Value, gbc_E9_Value);
            E9_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_28 = new JLabel("E13");
            lblNewLabel_28.setBorder(new EmptyBorder(0, 42, 0, 0));
            GridBagConstraints gbc_lblNewLabel_28 = new GridBagConstraints();
            gbc_lblNewLabel_28.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_28.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_28.gridx = 0;
            gbc_lblNewLabel_28.gridy = 8;
            this.add(lblNewLabel_28, gbc_lblNewLabel_28);
        }
        {
            E13_Value = new JTextField();
            E13_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E13_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E13_Value = new GridBagConstraints();
            gbc_E13_Value.fill = GridBagConstraints.BOTH;
            gbc_E13_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E13_Value.gridx = 1;
            gbc_E13_Value.gridy = 8;
            this.add(E13_Value, gbc_E13_Value);
            E13_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_29 = new JLabel("E14");
            lblNewLabel_29.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_29 = new GridBagConstraints();
            gbc_lblNewLabel_29.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_29.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_29.gridx = 2;
            gbc_lblNewLabel_29.gridy = 8;
            this.add(lblNewLabel_29, gbc_lblNewLabel_29);
        }
        {
            E14_Value = new JTextField();
            E14_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E14_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E14_Value = new GridBagConstraints();
            gbc_E14_Value.fill = GridBagConstraints.BOTH;
            gbc_E14_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E14_Value.gridx = 3;
            gbc_E14_Value.gridy = 8;
            this.add(E14_Value, gbc_E14_Value);
            E14_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_30 = new JLabel("E15");
            lblNewLabel_30.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_30 = new GridBagConstraints();
            gbc_lblNewLabel_30.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_30.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_30.gridx = 4;
            gbc_lblNewLabel_30.gridy = 8;
            this.add(lblNewLabel_30, gbc_lblNewLabel_30);
        }
        {
            E15_Value = new JTextField();
            E15_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E15_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E15_Value = new GridBagConstraints();
            gbc_E15_Value.fill = GridBagConstraints.BOTH;
            gbc_E15_Value.insets = new Insets(0, 0, 5, 0);
            gbc_E15_Value.gridx = 5;
            gbc_E15_Value.gridy = 8;
            this.add(E15_Value, gbc_E15_Value);
            E15_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_31 = new JLabel("E18");
            lblNewLabel_31.setBorder(new EmptyBorder(0, 42, 0, 0));
            GridBagConstraints gbc_lblNewLabel_31 = new GridBagConstraints();
            gbc_lblNewLabel_31.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_31.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_31.gridx = 0;
            gbc_lblNewLabel_31.gridy = 9;
            this.add(lblNewLabel_31, gbc_lblNewLabel_31);
        }
        {
            E18_Value = new JTextField();
            E18_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E18_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E18_Value = new GridBagConstraints();
            gbc_E18_Value.fill = GridBagConstraints.BOTH;
            gbc_E18_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E18_Value.gridx = 1;
            gbc_E18_Value.gridy = 9;
            this.add(E18_Value, gbc_E18_Value);
            E18_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_32 = new JLabel("E19");
            lblNewLabel_32.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_32 = new GridBagConstraints();
            gbc_lblNewLabel_32.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_32.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_32.gridx = 2;
            gbc_lblNewLabel_32.gridy = 9;
            this.add(lblNewLabel_32, gbc_lblNewLabel_32);
        }
        {
            E19_Value = new JTextField();
            E19_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E19_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E19_Value = new GridBagConstraints();
            gbc_E19_Value.fill = GridBagConstraints.BOTH;
            gbc_E19_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E19_Value.gridx = 3;
            gbc_E19_Value.gridy = 9;
            this.add(E19_Value, gbc_E19_Value);
            E19_Value.setColumns(10);
        }
        {
            JLabel lblNewLabel_33 = new JLabel("E20");
            lblNewLabel_33.setBorder(new EmptyBorder(0, 85, 0, 0));
            GridBagConstraints gbc_lblNewLabel_33 = new GridBagConstraints();
            gbc_lblNewLabel_33.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_33.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_33.gridx = 4;
            gbc_lblNewLabel_33.gridy = 9;
            this.add(lblNewLabel_33, gbc_lblNewLabel_33);
        }
        {
            E20_Value = new JTextField();
            E20_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E20_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E20_Value = new GridBagConstraints();
            gbc_E20_Value.fill = GridBagConstraints.BOTH;
            gbc_E20_Value.insets = new Insets(0, 0, 5, 0);
            gbc_E20_Value.gridx = 5;
            gbc_E20_Value.gridy = 9;
            this.add(E20_Value, gbc_E20_Value);
            E20_Value.setColumns(10);
        }
        {
            JLabel lblGemeinsamGenutzeKomponenten = new JLabel("");
            GridBagConstraints gbc_lblGemeinsamGenutzeKomponenten = new GridBagConstraints();
            gbc_lblGemeinsamGenutzeKomponenten.fill = GridBagConstraints.BOTH;
            gbc_lblGemeinsamGenutzeKomponenten.insets = new Insets(0, 0, 5, 5);
            gbc_lblGemeinsamGenutzeKomponenten.gridx = 0;
            gbc_lblGemeinsamGenutzeKomponenten.gridy = 10;
            this.add(lblGemeinsamGenutzeKomponenten, gbc_lblGemeinsamGenutzeKomponenten);
        }
        {
            JLabel lblFrAlleProdukte = new JLabel(Messages.getString("Buffer.35"));
            lblFrAlleProdukte.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblFrAlleProdukte = new GridBagConstraints();
            gbc_lblFrAlleProdukte.fill = GridBagConstraints.BOTH;
            gbc_lblFrAlleProdukte.insets = new Insets(0, 0, 5, 5);
            gbc_lblFrAlleProdukte.gridx = 1;
            gbc_lblFrAlleProdukte.gridy = 10;
            this.add(lblFrAlleProdukte, gbc_lblFrAlleProdukte);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 5, 5);
            gbc_label.gridx = 2;
            gbc_label.gridy = 10;
            this.add(label, gbc_label);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 5, 5);
            gbc_label.gridx = 3;
            gbc_label.gridy = 10;
            this.add(label, gbc_label);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 5, 5);
            gbc_label.gridx = 4;
            gbc_label.gridy = 10;
            this.add(label, gbc_label);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 5, 0);
            gbc_label.gridx = 5;
            gbc_label.gridy = 10;
            this.add(label, gbc_label);
        }
        {
            JLabel lblNewLabel_34 = new JLabel("E26");
            lblNewLabel_34.setBorder(new EmptyBorder(0, 42, 0, 0));
            GridBagConstraints gbc_lblNewLabel_34 = new GridBagConstraints();
            gbc_lblNewLabel_34.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_34.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_34.gridx = 0;
            gbc_lblNewLabel_34.gridy = 11;
            this.add(lblNewLabel_34, gbc_lblNewLabel_34);
        }
        {
            E26_Value = new JTextField();
            E26_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E26_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E26_Value = new GridBagConstraints();
            gbc_E26_Value.fill = GridBagConstraints.BOTH;
            gbc_E26_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E26_Value.gridx = 1;
            gbc_E26_Value.gridy = 11;
            this.add(E26_Value, gbc_E26_Value);
            E26_Value.setColumns(10);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 5, 5);
            gbc_label.gridx = 2;
            gbc_label.gridy = 11;
            this.add(label, gbc_label);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 5, 5);
            gbc_label.gridx = 3;
            gbc_label.gridy = 11;
            this.add(label, gbc_label);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 5, 5);
            gbc_label.gridx = 4;
            gbc_label.gridy = 11;
            this.add(label, gbc_label);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 5, 0);
            gbc_label.gridx = 5;
            gbc_label.gridy = 11;
            this.add(label, gbc_label);
        }
        {
            JLabel lblNewLabel_35 = new JLabel("E16");
            lblNewLabel_35.setBorder(new EmptyBorder(0, 42, 0, 0));
            GridBagConstraints gbc_lblNewLabel_35 = new GridBagConstraints();
            gbc_lblNewLabel_35.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_35.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_35.gridx = 0;
            gbc_lblNewLabel_35.gridy = 12;
            this.add(lblNewLabel_35, gbc_lblNewLabel_35);
        }
        {
            E16_Value = new JTextField();
            E16_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E16_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E16_Value = new GridBagConstraints();
            gbc_E16_Value.fill = GridBagConstraints.BOTH;
            gbc_E16_Value.insets = new Insets(0, 0, 5, 5);
            gbc_E16_Value.gridx = 1;
            gbc_E16_Value.gridy = 12;
            this.add(E16_Value, gbc_E16_Value);
            E16_Value.setColumns(10);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 5, 5);
            gbc_label.gridx = 2;
            gbc_label.gridy = 12;
            this.add(label, gbc_label);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 5, 5);
            gbc_label.gridx = 3;
            gbc_label.gridy = 12;
            this.add(label, gbc_label);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 5, 5);
            gbc_label.gridx = 4;
            gbc_label.gridy = 12;
            this.add(label, gbc_label);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 5, 0);
            gbc_label.gridx = 5;
            gbc_label.gridy = 12;
            this.add(label, gbc_label);
        }
        {
            JLabel lblNewLabel_36 = new JLabel("E17");
            lblNewLabel_36.setBorder(new EmptyBorder(0, 42, 0, 0));
            GridBagConstraints gbc_lblNewLabel_36 = new GridBagConstraints();
            gbc_lblNewLabel_36.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_36.insets = new Insets(0, 0, 0, 5);
            gbc_lblNewLabel_36.gridx = 0;
            gbc_lblNewLabel_36.gridy = 13;
            this.add(lblNewLabel_36, gbc_lblNewLabel_36);
        }
        {
            E17_Value = new JTextField();
            E17_Value.setHorizontalAlignment(SwingConstants.CENTER);
            ((AbstractDocument) E17_Value.getDocument())
                    .setDocumentFilter(new IntegerDocumentFilter());
            GridBagConstraints gbc_E17_Value = new GridBagConstraints();
            gbc_E17_Value.fill = GridBagConstraints.BOTH;
            gbc_E17_Value.insets = new Insets(0, 0, 0, 5);
            gbc_E17_Value.gridx = 1;
            gbc_E17_Value.gridy = 13;
            this.add(E17_Value, gbc_E17_Value);
            E17_Value.setColumns(10);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 0, 5);
            gbc_label.gridx = 2;
            gbc_label.gridy = 13;
            this.add(label, gbc_label);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 0, 5);
            gbc_label.gridx = 3;
            gbc_label.gridy = 13;
            this.add(label, gbc_label);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.insets = new Insets(0, 0, 0, 5);
            gbc_label.gridx = 4;
            gbc_label.gridy = 13;
            this.add(label, gbc_label);
        }
        {
            JLabel label = new JLabel("");
            GridBagConstraints gbc_label = new GridBagConstraints();
            gbc_label.fill = GridBagConstraints.BOTH;
            gbc_label.gridx = 5;
            gbc_label.gridy = 13;
            this.add(label, gbc_label);
        }
    }

    public Map<String, Integer> getSafetyStocks() {

        Map<String, Integer> result = new HashMap<>();

        try {

            result.put("P1", Integer.parseInt(P1_Value.getText()));
            result.put("P2", Integer.parseInt(P2_Value.getText()));
            result.put("P3", Integer.parseInt(P3_Value.getText()));
            result.put("E51", Integer.parseInt(E51_Value.getText()));
            result.put("E56", Integer.parseInt(E56_Value.getText()));
            result.put("E31", Integer.parseInt(E31_Value.getText()));
            result.put("E50", Integer.parseInt(E50_Value.getText()));
            result.put("E55", Integer.parseInt(E55_Value.getText()));
            result.put("E30", Integer.parseInt(E30_Value.getText()));
            result.put("E4", Integer.parseInt(E4_Value.getText()));
            result.put("E5", Integer.parseInt(E5_Value.getText()));
            result.put("E6", Integer.parseInt(E6_Value.getText()));
            result.put("E10", Integer.parseInt(E10_Value.getText()));
            result.put("E11", Integer.parseInt(E11_Value.getText()));
            result.put("E12", Integer.parseInt(E12_Value.getText()));
            result.put("E49", Integer.parseInt(E49_Value.getText()));
            result.put("E54", Integer.parseInt(E54_Value.getText()));
            result.put("E29", Integer.parseInt(E29_Value.getText()));
            result.put("E7", Integer.parseInt(E7_Value.getText()));
            result.put("E8", Integer.parseInt(E8_Value.getText()));
            result.put("E9", Integer.parseInt(E9_Value.getText()));
            result.put("E13", Integer.parseInt(E13_Value.getText()));
            result.put("E14", Integer.parseInt(E14_Value.getText()));
            result.put("E15", Integer.parseInt(E15_Value.getText()));
            result.put("E18", Integer.parseInt(E18_Value.getText()));
            result.put("E19", Integer.parseInt(E19_Value.getText()));
            result.put("E20", Integer.parseInt(E20_Value.getText()));
            result.put("E26", Integer.parseInt(E26_Value.getText()));
            result.put("E16", Integer.parseInt(E16_Value.getText()));
            result.put("E17", Integer.parseInt(E17_Value.getText()));

//			result.put("P1", 100);
//			result.put("P2", 100);
//			result.put("P3", 100);
//			result.put("E51", 100);
//			result.put("E56", 100);
//			result.put("E31", 100);
//			result.put("E50", 100);
//			result.put("E55", 100);
//			result.put("E30", 100);
//			result.put("E4", 100);
//			result.put("E5", 100);
//			result.put("E6", 100);
//			result.put("E10", 100);
//			result.put("E11", 100);
//			result.put("E12", 100);
//			result.put("E49", 100);
//			result.put("E54", 100);
//			result.put("E29", 100);
//			result.put("E7", 100);
//			result.put("E8", 100);
//			result.put("E9", 100);
//			result.put("E13", 100);
//			result.put("E14", 100);
//			result.put("E15", 100);
//			result.put("E18", 100);
//			result.put("E19", 100);
//			result.put("E20", 100);
//			result.put("E26", 100);
//			result.put("E16", 100);
//			result.put("E17", 100); 
        } catch (NumberFormatException e) {
            return null;
        }
        return result;
    }

    public void setData(XmlParser xmlParser) {

        P1_Value.setText(String.valueOf(xmlParser.getStartAmount("P1")));
        P2_Value.setText(String.valueOf(xmlParser.getStartAmount("P2")));
        P3_Value.setText(String.valueOf(xmlParser.getStartAmount("P3")));
        E51_Value.setText(String.valueOf(xmlParser.getStartAmount("E51")));
        E56_Value.setText(String.valueOf(xmlParser.getStartAmount("E56")));
        E31_Value.setText(String.valueOf(xmlParser.getStartAmount("E31")));
        E50_Value.setText(String.valueOf(xmlParser.getStartAmount("E50")));
        E55_Value.setText(String.valueOf(xmlParser.getStartAmount("E55")));
        E30_Value.setText(String.valueOf(xmlParser.getStartAmount("E30")));
        E4_Value.setText(String.valueOf(xmlParser.getStartAmount("E4")));
        E5_Value.setText(String.valueOf(xmlParser.getStartAmount("E5")));
        E6_Value.setText(String.valueOf(xmlParser.getStartAmount("E6")));
        E10_Value.setText(String.valueOf(xmlParser.getStartAmount("E10")));
        E11_Value.setText(String.valueOf(xmlParser.getStartAmount("E11")));
        E12_Value.setText(String.valueOf(xmlParser.getStartAmount("E12")));
        E49_Value.setText(String.valueOf(xmlParser.getStartAmount("E49")));
        E54_Value.setText(String.valueOf(xmlParser.getStartAmount("E54")));
        E29_Value.setText(String.valueOf(xmlParser.getStartAmount("E29")));
        E7_Value.setText(String.valueOf(xmlParser.getStartAmount("E7")));
        E8_Value.setText(String.valueOf(xmlParser.getStartAmount("E8")));
        E9_Value.setText(String.valueOf(xmlParser.getStartAmount("E9")));
        E13_Value.setText(String.valueOf(xmlParser.getStartAmount("E13")));
        E14_Value.setText(String.valueOf(xmlParser.getStartAmount("E14")));
        E15_Value.setText(String.valueOf(xmlParser.getStartAmount("E15")));
        E18_Value.setText(String.valueOf(xmlParser.getStartAmount("E18")));
        E19_Value.setText(String.valueOf(xmlParser.getStartAmount("E19")));
        E20_Value.setText(String.valueOf(xmlParser.getStartAmount("E20")));
        E26_Value.setText(String.valueOf(xmlParser.getStartAmount("E26")));
        E16_Value.setText(String.valueOf(xmlParser.getStartAmount("E16")));
        E17_Value.setText(String.valueOf(xmlParser.getStartAmount("E17")));
    }

    public void setDataFromScreenAfter(Map<String, Integer> data) {

        P1_Value.setText(String.valueOf(data.get("P1")));
        P2_Value.setText(String.valueOf(data.get("P2")));
        P3_Value.setText(String.valueOf(data.get("P3")));
        E51_Value.setText(String.valueOf(data.get("E51")));
        E56_Value.setText(String.valueOf(data.get("E56")));
        E31_Value.setText(String.valueOf(data.get("E31")));
        E50_Value.setText(String.valueOf(data.get("E50")));
        E55_Value.setText(String.valueOf(data.get("E55")));
        E30_Value.setText(String.valueOf(data.get("E30")));
        E4_Value.setText(String.valueOf(data.get("E4")));
        E5_Value.setText(String.valueOf(data.get("E5")));
        E6_Value.setText(String.valueOf(data.get("E6")));
        E10_Value.setText(String.valueOf(data.get("E10")));
        E11_Value.setText(String.valueOf(data.get("E11")));
        E12_Value.setText(String.valueOf(data.get("E12")));
        E49_Value.setText(String.valueOf(data.get("E49")));
        E54_Value.setText(String.valueOf(data.get("E54")));
        E29_Value.setText(String.valueOf(data.get("E29")));
        E7_Value.setText(String.valueOf(data.get("E7")));
        E8_Value.setText(String.valueOf(data.get("E8")));
        E9_Value.setText(String.valueOf(data.get("E9")));
        E13_Value.setText(String.valueOf(data.get("E13")));
        E14_Value.setText(String.valueOf(data.get("E14")));
        E15_Value.setText(String.valueOf(data.get("E15")));
        E18_Value.setText(String.valueOf(data.get("E18")));
        E19_Value.setText(String.valueOf(data.get("E19")));
        E20_Value.setText(String.valueOf(data.get("E20")));
        E26_Value.setText(String.valueOf(data.get("E26")));
        E16_Value.setText(String.valueOf(data.get("E16")));
        E17_Value.setText(String.valueOf(data.get("E17")));
    }
}
