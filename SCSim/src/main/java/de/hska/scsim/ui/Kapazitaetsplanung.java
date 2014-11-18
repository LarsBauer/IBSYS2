package de.hska.scsim.ui;

import de.hska.scsim.domain.output.CapacityPlanningResult;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.awt.Insets;
import java.awt.Font;


import java.awt.Component;
import java.awt.GridBagLayout;


import java.awt.GridBagConstraints;

public class Kapazitaetsplanung extends JPanel {

    private Map<String, JLabel> platz1 = new HashMap<>();
    private Map<String, JLabel> platz2 = new HashMap<>();
    private Map<String, JLabel> platz3 = new HashMap<>();
    private Map<String, JLabel> platz4 = new HashMap<>();
    private Map<String, JLabel> platz5 = new HashMap<>();
    private Map<String, JLabel> platz6 = new HashMap<>();
    private Map<String, JLabel> platz7 = new HashMap<>();
    private Map<String, JLabel> platz8 = new HashMap<>();
    private Map<String, JLabel> platz9 = new HashMap<>();
    private Map<String, JLabel> platz10 = new HashMap<>();
    private Map<String, JLabel> platz11 = new HashMap<>();
    private Map<String, JLabel> platz12 = new HashMap<>();
    private Map<String, JLabel> platz13 = new HashMap<>();
    private Map<String, JLabel> platz14 = new HashMap<>();
    private Map<String, JLabel> platz15 = new HashMap<>();

    private ArrayList<Map> container = new ArrayList<>();

    /**
     * Create the dialog.
     */
    public Kapazitaetsplanung() {

        this.setBorder(new EmptyBorder(10, 15, 0, 0));
        this.setFont(new Font("Arial", Font.PLAIN, 11));
        this.setAutoscrolls(true);
        this.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        this.setAlignmentX(Component.RIGHT_ALIGNMENT);
        this.setBackground(Color.WHITE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{85, 133, 75, 46, 75, 75, 0};
        gridBagLayout.rowHeights = new int[]{18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        {
            JLabel lblNewLabel_7 = new JLabel("");
            GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
            gbc_lblNewLabel_7.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_7.gridx = 0;
            gbc_lblNewLabel_7.gridy = 0;
            this.add(lblNewLabel_7, gbc_lblNewLabel_7);
        }
        {
            JLabel lblNewLabel = new JLabel(Messages.getString("Kapazitaetsplanung.100"));
            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
            gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel.gridx = 1;
            gbc_lblNewLabel.gridy = 0;
            add(lblNewLabel, gbc_lblNewLabel);
        }
        {
            JLabel lblNewLabel_8 = new JLabel(Messages.getString("Kapazitaetsplanung.2"));
            lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
            gbc_lblNewLabel_8.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_8.gridx = 2;
            gbc_lblNewLabel_8.gridy = 0;
            this.add(lblNewLabel_8, gbc_lblNewLabel_8);
        }
        {
            JLabel lblNewLabel_9 = new JLabel(Messages.getString("Kapazitaetsplanung.3"));
            lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
            gbc_lblNewLabel_9.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_9.gridx = 3;
            gbc_lblNewLabel_9.gridy = 0;
            this.add(lblNewLabel_9, gbc_lblNewLabel_9);
        }
        {
            JLabel lblNewLabel_10 = new JLabel(Messages.getString("Kapazitaetsplanung.4"));
            lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
            gbc_lblNewLabel_10.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_10.gridx = 4;
            gbc_lblNewLabel_10.gridy = 0;
            this.add(lblNewLabel_10, gbc_lblNewLabel_10);
        }
        {
            JLabel lblEffiziens = new JLabel(Messages.getString("Kapazitaetsplanung.5"));
            lblEffiziens.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblEffiziens = new GridBagConstraints();
            gbc_lblEffiziens.fill = GridBagConstraints.BOTH;
            gbc_lblEffiziens.insets = new Insets(0, 0, 5, 0);
            gbc_lblEffiziens.gridx = 5;
            gbc_lblEffiziens.gridy = 0;
            add(lblEffiziens, gbc_lblEffiziens);
        }
        {
            JLabel lblNewLabel_11 = new JLabel(Messages.getString("Kapazitaetsplanung.6"));
            lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
            gbc_lblNewLabel_11.fill = GridBagConstraints.BOTH;
            gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_11.gridx = 0;
            gbc_lblNewLabel_11.gridy = 1;
            this.add(lblNewLabel_11, gbc_lblNewLabel_11);
        }
        {
            JLabel B_1 = new JLabel("0");
            B_1.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_B_1 = new GridBagConstraints();
            gbc_B_1.fill = GridBagConstraints.BOTH;
            gbc_B_1.insets = new Insets(0, 0, 5, 5);
            gbc_B_1.gridx = 1;
            gbc_B_1.gridy = 1;
            add(B_1, gbc_B_1);
            platz1.put("B", B_1);
        }
        {
            JLabel K_1 = new JLabel("0");
            K_1.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_K_1 = new GridBagConstraints();
            gbc_K_1.fill = GridBagConstraints.BOTH;
            gbc_K_1.insets = new Insets(0, 0, 5, 5);
            gbc_K_1.gridx = 2;
            gbc_K_1.gridy = 1;
            this.add(K_1, gbc_K_1);
            platz1.put("K", K_1);
        }
        {
            JLabel S_1 = new JLabel("0");
            S_1.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_S_1 = new GridBagConstraints();
            gbc_S_1.fill = GridBagConstraints.BOTH;
            gbc_S_1.insets = new Insets(0, 0, 5, 5);
            gbc_S_1.gridx = 3;
            gbc_S_1.gridy = 1;
            this.add(S_1, gbc_S_1);
            platz1.put("S", S_1);
        }
        {
            JLabel U_1 = new JLabel("0");
            U_1.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_U_1 = new GridBagConstraints();
            gbc_U_1.fill = GridBagConstraints.BOTH;
            gbc_U_1.insets = new Insets(0, 0, 5, 5);
            gbc_U_1.gridx = 4;
            gbc_U_1.gridy = 1;
            this.add(U_1, gbc_U_1);
            platz1.put("U", U_1);
        }
        {
            JLabel E_1 = new JLabel("0");
            E_1.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_E_1 = new GridBagConstraints();
            gbc_E_1.fill = GridBagConstraints.BOTH;
            gbc_E_1.insets = new Insets(0, 0, 5, 0);
            gbc_E_1.gridx = 5;
            gbc_E_1.gridy = 1;
            add(E_1, gbc_E_1);
            platz1.put("E", E_1);
        }
        {
            JLabel lblStation = new JLabel(Messages.getString("Kapazitaetsplanung.15"));
            lblStation.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblStation = new GridBagConstraints();
            gbc_lblStation.fill = GridBagConstraints.BOTH;
            gbc_lblStation.insets = new Insets(0, 0, 5, 5);
            gbc_lblStation.gridx = 0;
            gbc_lblStation.gridy = 2;
            this.add(lblStation, gbc_lblStation);
        }
        {
            JLabel B_2 = new JLabel("0");
            B_2.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_B_2 = new GridBagConstraints();
            gbc_B_2.fill = GridBagConstraints.BOTH;
            gbc_B_2.insets = new Insets(0, 0, 5, 5);
            gbc_B_2.gridx = 1;
            gbc_B_2.gridy = 2;
            add(B_2, gbc_B_2);
            platz2.put("B", B_2);
        }
        {
            JLabel K_2 = new JLabel("0");
            K_2.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_K_2 = new GridBagConstraints();
            gbc_K_2.fill = GridBagConstraints.BOTH;
            gbc_K_2.insets = new Insets(0, 0, 5, 5);
            gbc_K_2.gridx = 2;
            gbc_K_2.gridy = 2;
            this.add(K_2, gbc_K_2);
            platz2.put("K", K_2);
        }
        {
            JLabel S_2 = new JLabel("0");
            S_2.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_S_2 = new GridBagConstraints();
            gbc_S_2.fill = GridBagConstraints.BOTH;
            gbc_S_2.insets = new Insets(0, 0, 5, 5);
            gbc_S_2.gridx = 3;
            gbc_S_2.gridy = 2;
            this.add(S_2, gbc_S_2);
            platz2.put("S", S_2);
        }
        {
            JLabel U_2 = new JLabel("0");
            U_2.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_U_2 = new GridBagConstraints();
            gbc_U_2.fill = GridBagConstraints.BOTH;
            gbc_U_2.insets = new Insets(0, 0, 5, 5);
            gbc_U_2.gridx = 4;
            gbc_U_2.gridy = 2;
            this.add(U_2, gbc_U_2);
            platz2.put("U", U_2);
        }
        {
            JLabel E_2 = new JLabel("0");
            E_2.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_E_2 = new GridBagConstraints();
            gbc_E_2.fill = GridBagConstraints.BOTH;
            gbc_E_2.insets = new Insets(0, 0, 5, 0);
            gbc_E_2.gridx = 5;
            gbc_E_2.gridy = 2;
            add(E_2, gbc_E_2);
            platz2.put("E", E_2);
        }
        {
            JLabel lblStation_1 = new JLabel(Messages.getString("Kapazitaetsplanung.24"));
            lblStation_1.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblStation_1 = new GridBagConstraints();
            gbc_lblStation_1.fill = GridBagConstraints.BOTH;
            gbc_lblStation_1.insets = new Insets(0, 0, 5, 5);
            gbc_lblStation_1.gridx = 0;
            gbc_lblStation_1.gridy = 3;
            this.add(lblStation_1, gbc_lblStation_1);
        }
        {
            JLabel B_3 = new JLabel("0");
            B_3.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_B_3 = new GridBagConstraints();
            gbc_B_3.fill = GridBagConstraints.BOTH;
            gbc_B_3.insets = new Insets(0, 0, 5, 5);
            gbc_B_3.gridx = 1;
            gbc_B_3.gridy = 3;
            add(B_3, gbc_B_3);
            platz3.put("B", B_3);
        }
        {
            JLabel K_3 = new JLabel("0");
            K_3.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_K_3 = new GridBagConstraints();
            gbc_K_3.fill = GridBagConstraints.BOTH;
            gbc_K_3.insets = new Insets(0, 0, 5, 5);
            gbc_K_3.gridx = 2;
            gbc_K_3.gridy = 3;
            this.add(K_3, gbc_K_3);
            platz3.put("K", K_3);
        }
        {
            JLabel S_3 = new JLabel("0");
            S_3.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_S_3 = new GridBagConstraints();
            gbc_S_3.fill = GridBagConstraints.BOTH;
            gbc_S_3.insets = new Insets(0, 0, 5, 5);
            gbc_S_3.gridx = 3;
            gbc_S_3.gridy = 3;
            this.add(S_3, gbc_S_3);
            platz3.put("S", S_3);
        }
        {
            JLabel U_3 = new JLabel("0");
            U_3.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_U_3 = new GridBagConstraints();
            gbc_U_3.fill = GridBagConstraints.BOTH;
            gbc_U_3.insets = new Insets(0, 0, 5, 5);
            gbc_U_3.gridx = 4;
            gbc_U_3.gridy = 3;
            this.add(U_3, gbc_U_3);
            platz3.put("U", U_3);
        }
        {
            JLabel E_3 = new JLabel("0");
            E_3.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_E_3 = new GridBagConstraints();
            gbc_E_3.fill = GridBagConstraints.BOTH;
            gbc_E_3.insets = new Insets(0, 0, 5, 0);
            gbc_E_3.gridx = 5;
            gbc_E_3.gridy = 3;
            add(E_3, gbc_E_3);
            platz3.put("E", E_3);
        }
        {
            JLabel lblStation_2 = new JLabel(Messages.getString("Kapazitaetsplanung.33"));
            lblStation_2.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblStation_2 = new GridBagConstraints();
            gbc_lblStation_2.fill = GridBagConstraints.BOTH;
            gbc_lblStation_2.insets = new Insets(0, 0, 5, 5);
            gbc_lblStation_2.gridx = 0;
            gbc_lblStation_2.gridy = 4;
            this.add(lblStation_2, gbc_lblStation_2);
        }
        {
            JLabel B_4 = new JLabel("0");
            B_4.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_B_4 = new GridBagConstraints();
            gbc_B_4.fill = GridBagConstraints.BOTH;
            gbc_B_4.insets = new Insets(0, 0, 5, 5);
            gbc_B_4.gridx = 1;
            gbc_B_4.gridy = 4;
            add(B_4, gbc_B_4);
            platz4.put("B", B_4);
        }
        {
            JLabel K_4 = new JLabel("0");
            K_4.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_K_4 = new GridBagConstraints();
            gbc_K_4.fill = GridBagConstraints.BOTH;
            gbc_K_4.insets = new Insets(0, 0, 5, 5);
            gbc_K_4.gridx = 2;
            gbc_K_4.gridy = 4;
            this.add(K_4, gbc_K_4);
            platz4.put("K", K_4);
        }
        {
            JLabel S_4 = new JLabel("0");
            S_4.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_S_4 = new GridBagConstraints();
            gbc_S_4.fill = GridBagConstraints.BOTH;
            gbc_S_4.insets = new Insets(0, 0, 5, 5);
            gbc_S_4.gridx = 3;
            gbc_S_4.gridy = 4;
            this.add(S_4, gbc_S_4);
            platz4.put("S", S_4);
        }
        {
            JLabel U_4 = new JLabel("0");
            U_4.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_U_4 = new GridBagConstraints();
            gbc_U_4.fill = GridBagConstraints.BOTH;
            gbc_U_4.insets = new Insets(0, 0, 5, 5);
            gbc_U_4.gridx = 4;
            gbc_U_4.gridy = 4;
            this.add(U_4, gbc_U_4);
            platz4.put("U", U_4);
        }
        {
            JLabel E_4 = new JLabel("0");
            E_4.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_E_4 = new GridBagConstraints();
            gbc_E_4.fill = GridBagConstraints.BOTH;
            gbc_E_4.insets = new Insets(0, 0, 5, 0);
            gbc_E_4.gridx = 5;
            gbc_E_4.gridy = 4;
            add(E_4, gbc_E_4);
            platz4.put("E", E_4);
        }
        {
            JLabel lblStation_3 = new JLabel(Messages.getString("Kapazitaetsplanung.42"));
            lblStation_3.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblStation_3 = new GridBagConstraints();
            gbc_lblStation_3.fill = GridBagConstraints.BOTH;
            gbc_lblStation_3.insets = new Insets(0, 0, 5, 5);
            gbc_lblStation_3.gridx = 0;
            gbc_lblStation_3.gridy = 5;
            this.add(lblStation_3, gbc_lblStation_3);
        }
        {
            JLabel B_5 = new JLabel("0");
            B_5.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_B_5 = new GridBagConstraints();
            gbc_B_5.fill = GridBagConstraints.BOTH;
            gbc_B_5.insets = new Insets(0, 0, 5, 5);
            gbc_B_5.gridx = 1;
            gbc_B_5.gridy = 5;
            add(B_5, gbc_B_5);
            platz5.put("B", B_5);
        }
        {
            JLabel K_5 = new JLabel("0");
            K_5.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_K_5 = new GridBagConstraints();
            gbc_K_5.fill = GridBagConstraints.BOTH;
            gbc_K_5.insets = new Insets(0, 0, 5, 5);
            gbc_K_5.gridx = 2;
            gbc_K_5.gridy = 5;
            this.add(K_5, gbc_K_5);
            platz5.put("K", K_5);
        }
        {
            JLabel S_5 = new JLabel("0");
            S_5.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_S_5 = new GridBagConstraints();
            gbc_S_5.fill = GridBagConstraints.BOTH;
            gbc_S_5.insets = new Insets(0, 0, 5, 5);
            gbc_S_5.gridx = 3;
            gbc_S_5.gridy = 5;
            this.add(S_5, gbc_S_5);
            platz5.put("S", S_5);
        }
        {
            JLabel U_5 = new JLabel("0");
            U_5.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_U_5 = new GridBagConstraints();
            gbc_U_5.fill = GridBagConstraints.BOTH;
            gbc_U_5.insets = new Insets(0, 0, 5, 5);
            gbc_U_5.gridx = 4;
            gbc_U_5.gridy = 5;
            this.add(U_5, gbc_U_5);
            platz5.put("U", U_5);
        }
        {
            JLabel E_5 = new JLabel("0");
            E_5.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_E_5 = new GridBagConstraints();
            gbc_E_5.fill = GridBagConstraints.BOTH;
            gbc_E_5.insets = new Insets(0, 0, 5, 0);
            gbc_E_5.gridx = 5;
            gbc_E_5.gridy = 5;
            add(E_5, gbc_E_5);
            platz5.put("E", E_5);
        }
        {
            JLabel lblStation_4 = new JLabel(Messages.getString("Kapazitaetsplanung.51"));
            lblStation_4.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblStation_4 = new GridBagConstraints();
            gbc_lblStation_4.fill = GridBagConstraints.BOTH;
            gbc_lblStation_4.insets = new Insets(0, 0, 5, 5);
            gbc_lblStation_4.gridx = 0;
            gbc_lblStation_4.gridy = 6;
            this.add(lblStation_4, gbc_lblStation_4);
        }
        {
            JLabel B_6 = new JLabel("0");
            B_6.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_B_6 = new GridBagConstraints();
            gbc_B_6.fill = GridBagConstraints.BOTH;
            gbc_B_6.insets = new Insets(0, 0, 5, 5);
            gbc_B_6.gridx = 1;
            gbc_B_6.gridy = 6;
            add(B_6, gbc_B_6);
            platz6.put("B", B_6);
        }
        {
            JLabel K_6 = new JLabel("0");
            K_6.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_K_6 = new GridBagConstraints();
            gbc_K_6.fill = GridBagConstraints.BOTH;
            gbc_K_6.insets = new Insets(0, 0, 5, 5);
            gbc_K_6.gridx = 2;
            gbc_K_6.gridy = 6;
            this.add(K_6, gbc_K_6);
            platz6.put("K", K_6);
        }
        {
            JLabel S_6 = new JLabel("0");
            S_6.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_S_6 = new GridBagConstraints();
            gbc_S_6.fill = GridBagConstraints.BOTH;
            gbc_S_6.insets = new Insets(0, 0, 5, 5);
            gbc_S_6.gridx = 3;
            gbc_S_6.gridy = 6;
            this.add(S_6, gbc_S_6);
            platz6.put("S", S_6);
        }
        {
            JLabel U_6 = new JLabel("0");
            U_6.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_U_6 = new GridBagConstraints();
            gbc_U_6.fill = GridBagConstraints.BOTH;
            gbc_U_6.insets = new Insets(0, 0, 5, 5);
            gbc_U_6.gridx = 4;
            gbc_U_6.gridy = 6;
            this.add(U_6, gbc_U_6);
            platz6.put("U", U_6);
        }
        {
            JLabel E_6 = new JLabel("0");
            E_6.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_E_6 = new GridBagConstraints();
            gbc_E_6.fill = GridBagConstraints.BOTH;
            gbc_E_6.insets = new Insets(0, 0, 5, 0);
            gbc_E_6.gridx = 5;
            gbc_E_6.gridy = 6;
            add(E_6, gbc_E_6);
            platz6.put("E", E_6);
        }
        {
            JLabel lblStation_5 = new JLabel(Messages.getString("Kapazitaetsplanung.60"));
            lblStation_5.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblStation_5 = new GridBagConstraints();
            gbc_lblStation_5.fill = GridBagConstraints.BOTH;
            gbc_lblStation_5.insets = new Insets(0, 0, 5, 5);
            gbc_lblStation_5.gridx = 0;
            gbc_lblStation_5.gridy = 7;
            this.add(lblStation_5, gbc_lblStation_5);
        }
        {
            JLabel B_7 = new JLabel("0");
            B_7.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_B_7 = new GridBagConstraints();
            gbc_B_7.fill = GridBagConstraints.BOTH;
            gbc_B_7.insets = new Insets(0, 0, 5, 5);
            gbc_B_7.gridx = 1;
            gbc_B_7.gridy = 7;
            add(B_7, gbc_B_7);
            platz7.put("B", B_7);
        }
        {
            JLabel K_7 = new JLabel("0");
            K_7.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_K_7 = new GridBagConstraints();
            gbc_K_7.fill = GridBagConstraints.BOTH;
            gbc_K_7.insets = new Insets(0, 0, 5, 5);
            gbc_K_7.gridx = 2;
            gbc_K_7.gridy = 7;
            this.add(K_7, gbc_K_7);
            platz7.put("K", K_7);
        }
        {
            JLabel S_7 = new JLabel("0");
            S_7.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_S_7 = new GridBagConstraints();
            gbc_S_7.fill = GridBagConstraints.BOTH;
            gbc_S_7.insets = new Insets(0, 0, 5, 5);
            gbc_S_7.gridx = 3;
            gbc_S_7.gridy = 7;
            this.add(S_7, gbc_S_7);
            platz7.put("S", S_7);
        }
        {
            JLabel U_7 = new JLabel("0");
            U_7.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_U_7 = new GridBagConstraints();
            gbc_U_7.fill = GridBagConstraints.BOTH;
            gbc_U_7.insets = new Insets(0, 0, 5, 5);
            gbc_U_7.gridx = 4;
            gbc_U_7.gridy = 7;
            this.add(U_7, gbc_U_7);
            platz7.put("U", U_7);
        }
        {
            JLabel E_7 = new JLabel("0");
            E_7.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_E_7 = new GridBagConstraints();
            gbc_E_7.fill = GridBagConstraints.BOTH;
            gbc_E_7.insets = new Insets(0, 0, 5, 0);
            gbc_E_7.gridx = 5;
            gbc_E_7.gridy = 7;
            add(E_7, gbc_E_7);
            platz7.put("E", E_7);
        }
        {
            JLabel lblStation_6 = new JLabel(Messages.getString("Kapazitaetsplanung.69"));
            lblStation_6.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblStation_6 = new GridBagConstraints();
            gbc_lblStation_6.fill = GridBagConstraints.BOTH;
            gbc_lblStation_6.insets = new Insets(0, 0, 5, 5);
            gbc_lblStation_6.gridx = 0;
            gbc_lblStation_6.gridy = 8;
            this.add(lblStation_6, gbc_lblStation_6);
        }
        {
            JLabel B_8 = new JLabel("0");
            B_8.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_B_8 = new GridBagConstraints();
            gbc_B_8.fill = GridBagConstraints.BOTH;
            gbc_B_8.insets = new Insets(0, 0, 5, 5);
            gbc_B_8.gridx = 1;
            gbc_B_8.gridy = 8;
            add(B_8, gbc_B_8);
            platz8.put("B", B_8);
        }
        {
            JLabel K_8 = new JLabel("0");
            K_8.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_K_8 = new GridBagConstraints();
            gbc_K_8.fill = GridBagConstraints.BOTH;
            gbc_K_8.insets = new Insets(0, 0, 5, 5);
            gbc_K_8.gridx = 2;
            gbc_K_8.gridy = 8;
            this.add(K_8, gbc_K_8);
            platz8.put("K", K_8);
        }
        {
            JLabel S_8 = new JLabel("0");
            S_8.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_S_8 = new GridBagConstraints();
            gbc_S_8.fill = GridBagConstraints.BOTH;
            gbc_S_8.insets = new Insets(0, 0, 5, 5);
            gbc_S_8.gridx = 3;
            gbc_S_8.gridy = 8;
            this.add(S_8, gbc_S_8);
            platz8.put("S", S_8);
        }
        {
            JLabel U_8 = new JLabel("0");
            U_8.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_U_8 = new GridBagConstraints();
            gbc_U_8.fill = GridBagConstraints.BOTH;
            gbc_U_8.insets = new Insets(0, 0, 5, 5);
            gbc_U_8.gridx = 4;
            gbc_U_8.gridy = 8;
            this.add(U_8, gbc_U_8);
            platz8.put("U", U_8);
        }
        {
            JLabel E_8 = new JLabel("0");
            E_8.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_E_8 = new GridBagConstraints();
            gbc_E_8.fill = GridBagConstraints.BOTH;
            gbc_E_8.insets = new Insets(0, 0, 5, 0);
            gbc_E_8.gridx = 5;
            gbc_E_8.gridy = 8;
            add(E_8, gbc_E_8);
            platz8.put("E", E_8);
        }
        {
            JLabel lblStation_7 = new JLabel(Messages.getString("Kapazitaetsplanung.78"));
            lblStation_7.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblStation_7 = new GridBagConstraints();
            gbc_lblStation_7.fill = GridBagConstraints.BOTH;
            gbc_lblStation_7.insets = new Insets(0, 0, 5, 5);
            gbc_lblStation_7.gridx = 0;
            gbc_lblStation_7.gridy = 9;
            this.add(lblStation_7, gbc_lblStation_7);
        }
        {
            JLabel B_9 = new JLabel("0");
            B_9.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_B_9 = new GridBagConstraints();
            gbc_B_9.fill = GridBagConstraints.BOTH;
            gbc_B_9.insets = new Insets(0, 0, 5, 5);
            gbc_B_9.gridx = 1;
            gbc_B_9.gridy = 9;
            add(B_9, gbc_B_9);
            platz9.put("B", B_9);
        }
        {
            JLabel K_9 = new JLabel("0");
            K_9.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_K_9 = new GridBagConstraints();
            gbc_K_9.fill = GridBagConstraints.BOTH;
            gbc_K_9.insets = new Insets(0, 0, 5, 5);
            gbc_K_9.gridx = 2;
            gbc_K_9.gridy = 9;
            this.add(K_9, gbc_K_9);
            platz9.put("K", K_9);
        }
        {
            JLabel S_9 = new JLabel("0");
            S_9.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_S_9 = new GridBagConstraints();
            gbc_S_9.fill = GridBagConstraints.BOTH;
            gbc_S_9.insets = new Insets(0, 0, 5, 5);
            gbc_S_9.gridx = 3;
            gbc_S_9.gridy = 9;
            this.add(S_9, gbc_S_9);
            platz9.put("S", S_9);
        }
        {
            JLabel U_9 = new JLabel("0");
            U_9.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_U_9 = new GridBagConstraints();
            gbc_U_9.fill = GridBagConstraints.BOTH;
            gbc_U_9.insets = new Insets(0, 0, 5, 5);
            gbc_U_9.gridx = 4;
            gbc_U_9.gridy = 9;
            this.add(U_9, gbc_U_9);
            platz9.put("U", U_9);
        }
        {
            JLabel E_9 = new JLabel("0");
            E_9.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_E_9 = new GridBagConstraints();
            gbc_E_9.fill = GridBagConstraints.BOTH;
            gbc_E_9.insets = new Insets(0, 0, 5, 0);
            gbc_E_9.gridx = 5;
            gbc_E_9.gridy = 9;
            add(E_9, gbc_E_9);
            platz9.put("E", E_9);
        }
        {
            JLabel lblStation_8 = new JLabel(Messages.getString("Kapazitaetsplanung.87"));
            lblStation_8.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblStation_8 = new GridBagConstraints();
            gbc_lblStation_8.fill = GridBagConstraints.BOTH;
            gbc_lblStation_8.insets = new Insets(0, 0, 5, 5);
            gbc_lblStation_8.gridx = 0;
            gbc_lblStation_8.gridy = 10;
            this.add(lblStation_8, gbc_lblStation_8);
        }
        {
            JLabel B_10 = new JLabel("0");
            B_10.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_B_10 = new GridBagConstraints();
            gbc_B_10.fill = GridBagConstraints.BOTH;
            gbc_B_10.insets = new Insets(0, 0, 5, 5);
            gbc_B_10.gridx = 1;
            gbc_B_10.gridy = 10;
            add(B_10, gbc_B_10);
            platz10.put("B", B_10);
        }
        {
            JLabel K_10 = new JLabel("0");
            K_10.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_K_10 = new GridBagConstraints();
            gbc_K_10.fill = GridBagConstraints.BOTH;
            gbc_K_10.insets = new Insets(0, 0, 5, 5);
            gbc_K_10.gridx = 2;
            gbc_K_10.gridy = 10;
            this.add(K_10, gbc_K_10);
            platz10.put("K", K_10);
        }
        {
            JLabel S_10 = new JLabel("0");
            S_10.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_S_10 = new GridBagConstraints();
            gbc_S_10.fill = GridBagConstraints.BOTH;
            gbc_S_10.insets = new Insets(0, 0, 5, 5);
            gbc_S_10.gridx = 3;
            gbc_S_10.gridy = 10;
            this.add(S_10, gbc_S_10);
            platz10.put("S", S_10);
        }
        {
            JLabel U_10 = new JLabel("0");
            U_10.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_U_10 = new GridBagConstraints();
            gbc_U_10.fill = GridBagConstraints.BOTH;
            gbc_U_10.insets = new Insets(0, 0, 5, 5);
            gbc_U_10.gridx = 4;
            gbc_U_10.gridy = 10;
            this.add(U_10, gbc_U_10);
            platz10.put("U", U_10);
        }
        {
            JLabel E_10 = new JLabel("0");
            E_10.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_E_10 = new GridBagConstraints();
            gbc_E_10.fill = GridBagConstraints.BOTH;
            gbc_E_10.insets = new Insets(0, 0, 5, 0);
            gbc_E_10.gridx = 5;
            gbc_E_10.gridy = 10;
            add(E_10, gbc_E_10);
            platz10.put("E", E_10);
        }
        {
            JLabel lblStation_9 = new JLabel(Messages.getString("Kapazitaetsplanung.96"));
            lblStation_9.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblStation_9 = new GridBagConstraints();
            gbc_lblStation_9.fill = GridBagConstraints.BOTH;
            gbc_lblStation_9.insets = new Insets(0, 0, 5, 5);
            gbc_lblStation_9.gridx = 0;
            gbc_lblStation_9.gridy = 11;
            this.add(lblStation_9, gbc_lblStation_9);
        }
        {
            JLabel B_11 = new JLabel("0");
            B_11.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_B_11 = new GridBagConstraints();
            gbc_B_11.fill = GridBagConstraints.BOTH;
            gbc_B_11.insets = new Insets(0, 0, 5, 5);
            gbc_B_11.gridx = 1;
            gbc_B_11.gridy = 11;
            add(B_11, gbc_B_11);
            platz11.put("B", B_11);
        }
        {
            JLabel K_11 = new JLabel("0");
            K_11.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_K_11 = new GridBagConstraints();
            gbc_K_11.fill = GridBagConstraints.BOTH;
            gbc_K_11.insets = new Insets(0, 0, 5, 5);
            gbc_K_11.gridx = 2;
            gbc_K_11.gridy = 11;
            this.add(K_11, gbc_K_11);
            platz11.put("K", K_11);
        }
        {
            JLabel S_11 = new JLabel("0");
            S_11.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_S_11 = new GridBagConstraints();
            gbc_S_11.fill = GridBagConstraints.BOTH;
            gbc_S_11.insets = new Insets(0, 0, 5, 5);
            gbc_S_11.gridx = 3;
            gbc_S_11.gridy = 11;
            this.add(S_11, gbc_S_11);
            platz11.put("S", S_11);
        }
        {
            JLabel U_11 = new JLabel("0");
            U_11.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_U_11 = new GridBagConstraints();
            gbc_U_11.fill = GridBagConstraints.BOTH;
            gbc_U_11.insets = new Insets(0, 0, 5, 5);
            gbc_U_11.gridx = 4;
            gbc_U_11.gridy = 11;
            this.add(U_11, gbc_U_11);
            platz11.put("U", U_11);
        }
        {
            JLabel E_11 = new JLabel("0");
            E_11.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_E_11 = new GridBagConstraints();
            gbc_E_11.fill = GridBagConstraints.BOTH;
            gbc_E_11.insets = new Insets(0, 0, 5, 0);
            gbc_E_11.gridx = 5;
            gbc_E_11.gridy = 11;
            add(E_11, gbc_E_11);
            platz11.put("E", E_11);
        }
        {
            JLabel lblStation_10 = new JLabel(Messages.getString("Kapazitaetsplanung.105"));
            lblStation_10.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblStation_10 = new GridBagConstraints();
            gbc_lblStation_10.fill = GridBagConstraints.BOTH;
            gbc_lblStation_10.insets = new Insets(0, 0, 5, 5);
            gbc_lblStation_10.gridx = 0;
            gbc_lblStation_10.gridy = 12;
            this.add(lblStation_10, gbc_lblStation_10);
        }
        {
            JLabel B_12 = new JLabel("0");
            B_12.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_B_12 = new GridBagConstraints();
            gbc_B_12.fill = GridBagConstraints.BOTH;
            gbc_B_12.insets = new Insets(0, 0, 5, 5);
            gbc_B_12.gridx = 1;
            gbc_B_12.gridy = 12;
            add(B_12, gbc_B_12);
            platz12.put("B", B_12);
        }
        {
            JLabel K_12 = new JLabel("0");
            K_12.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_K_12 = new GridBagConstraints();
            gbc_K_12.fill = GridBagConstraints.BOTH;
            gbc_K_12.insets = new Insets(0, 0, 5, 5);
            gbc_K_12.gridx = 2;
            gbc_K_12.gridy = 12;
            this.add(K_12, gbc_K_12);
            platz12.put("K", K_12);
        }
        {
            JLabel S_12 = new JLabel("0");
            S_12.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_S_12 = new GridBagConstraints();
            gbc_S_12.fill = GridBagConstraints.BOTH;
            gbc_S_12.insets = new Insets(0, 0, 5, 5);
            gbc_S_12.gridx = 3;
            gbc_S_12.gridy = 12;
            this.add(S_12, gbc_S_12);
            platz12.put("S", S_12);
        }
        {
            JLabel U_12 = new JLabel("0");
            U_12.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_U_12 = new GridBagConstraints();
            gbc_U_12.fill = GridBagConstraints.BOTH;
            gbc_U_12.insets = new Insets(0, 0, 5, 5);
            gbc_U_12.gridx = 4;
            gbc_U_12.gridy = 12;
            this.add(U_12, gbc_U_12);
            platz12.put("U", U_12);
        }
        {
            JLabel E_12 = new JLabel("0");
            E_12.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_E_12 = new GridBagConstraints();
            gbc_E_12.fill = GridBagConstraints.BOTH;
            gbc_E_12.insets = new Insets(0, 0, 5, 0);
            gbc_E_12.gridx = 5;
            gbc_E_12.gridy = 12;
            add(E_12, gbc_E_12);
            platz12.put("E", E_12);
        }
        {
            JLabel lblStation_11 = new JLabel(Messages.getString("Kapazitaetsplanung.114"));
            lblStation_11.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblStation_11 = new GridBagConstraints();
            gbc_lblStation_11.fill = GridBagConstraints.BOTH;
            gbc_lblStation_11.insets = new Insets(0, 0, 5, 5);
            gbc_lblStation_11.gridx = 0;
            gbc_lblStation_11.gridy = 13;
            this.add(lblStation_11, gbc_lblStation_11);
        }
        {
            JLabel B_13 = new JLabel("0");
            B_13.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_B_13 = new GridBagConstraints();
            gbc_B_13.fill = GridBagConstraints.BOTH;
            gbc_B_13.insets = new Insets(0, 0, 5, 5);
            gbc_B_13.gridx = 1;
            gbc_B_13.gridy = 13;
            add(B_13, gbc_B_13);
            platz13.put("B", B_13);
        }
        {
            JLabel K_13 = new JLabel("0");
            K_13.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_K_13 = new GridBagConstraints();
            gbc_K_13.fill = GridBagConstraints.BOTH;
            gbc_K_13.insets = new Insets(0, 0, 5, 5);
            gbc_K_13.gridx = 2;
            gbc_K_13.gridy = 13;
            this.add(K_13, gbc_K_13);
            platz13.put("K", K_13);
        }
        {
            JLabel S_13 = new JLabel("0");
            S_13.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_S_13 = new GridBagConstraints();
            gbc_S_13.fill = GridBagConstraints.BOTH;
            gbc_S_13.insets = new Insets(0, 0, 5, 5);
            gbc_S_13.gridx = 3;
            gbc_S_13.gridy = 13;
            this.add(S_13, gbc_S_13);
            platz13.put("S", S_13);
        }
        {
            JLabel U_13 = new JLabel("0");
            U_13.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_U_13 = new GridBagConstraints();
            gbc_U_13.fill = GridBagConstraints.BOTH;
            gbc_U_13.insets = new Insets(0, 0, 5, 5);
            gbc_U_13.gridx = 4;
            gbc_U_13.gridy = 13;
            this.add(U_13, gbc_U_13);
            platz13.put("U", U_13);
        }
        {
            JLabel E_13 = new JLabel("0");
            E_13.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_E_13 = new GridBagConstraints();
            gbc_E_13.fill = GridBagConstraints.BOTH;
            gbc_E_13.insets = new Insets(0, 0, 5, 0);
            gbc_E_13.gridx = 5;
            gbc_E_13.gridy = 13;
            add(E_13, gbc_E_13);
            platz13.put("E", E_13);
        }
        {
            JLabel lblStation_12 = new JLabel(Messages.getString("Kapazitaetsplanung.123"));
            lblStation_12.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblStation_12 = new GridBagConstraints();
            gbc_lblStation_12.fill = GridBagConstraints.BOTH;
            gbc_lblStation_12.insets = new Insets(0, 0, 5, 5);
            gbc_lblStation_12.gridx = 0;
            gbc_lblStation_12.gridy = 14;
            this.add(lblStation_12, gbc_lblStation_12);
        }
        {
            JLabel B_14 = new JLabel("0");
            B_14.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_B_14 = new GridBagConstraints();
            gbc_B_14.fill = GridBagConstraints.BOTH;
            gbc_B_14.insets = new Insets(0, 0, 5, 5);
            gbc_B_14.gridx = 1;
            gbc_B_14.gridy = 14;
            add(B_14, gbc_B_14);
            platz14.put("B", B_14);
        }
        {
            JLabel K_14 = new JLabel("0");
            K_14.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_K_14 = new GridBagConstraints();
            gbc_K_14.fill = GridBagConstraints.BOTH;
            gbc_K_14.insets = new Insets(0, 0, 5, 5);
            gbc_K_14.gridx = 2;
            gbc_K_14.gridy = 14;
            this.add(K_14, gbc_K_14);
            platz14.put("K", K_14);
        }
        {
            JLabel S_14 = new JLabel("0");
            S_14.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_S_14 = new GridBagConstraints();
            gbc_S_14.fill = GridBagConstraints.BOTH;
            gbc_S_14.insets = new Insets(0, 0, 5, 5);
            gbc_S_14.gridx = 3;
            gbc_S_14.gridy = 14;
            this.add(S_14, gbc_S_14);
            platz14.put("S", S_14);
        }
        {
            JLabel U_14 = new JLabel("0");
            U_14.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_U_14 = new GridBagConstraints();
            gbc_U_14.fill = GridBagConstraints.BOTH;
            gbc_U_14.insets = new Insets(0, 0, 5, 5);
            gbc_U_14.gridx = 4;
            gbc_U_14.gridy = 14;
            this.add(U_14, gbc_U_14);
            platz14.put("U", U_14);
        }
        {
            JLabel E_14 = new JLabel("0");
            E_14.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_E_14 = new GridBagConstraints();
            gbc_E_14.fill = GridBagConstraints.BOTH;
            gbc_E_14.insets = new Insets(0, 0, 5, 0);
            gbc_E_14.gridx = 5;
            gbc_E_14.gridy = 14;
            add(E_14, gbc_E_14);
            platz14.put("E", E_14);
        }
        {
            JLabel lblStation_13 = new JLabel(Messages.getString("Kapazitaetsplanung.132"));
            lblStation_13.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblStation_13 = new GridBagConstraints();
            gbc_lblStation_13.fill = GridBagConstraints.BOTH;
            gbc_lblStation_13.insets = new Insets(0, 0, 0, 5);
            gbc_lblStation_13.gridx = 0;
            gbc_lblStation_13.gridy = 15;
            this.add(lblStation_13, gbc_lblStation_13);
        }
        {
            JLabel B_15 = new JLabel("0");
            B_15.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_B_15 = new GridBagConstraints();
            gbc_B_15.fill = GridBagConstraints.BOTH;
            gbc_B_15.insets = new Insets(0, 0, 0, 5);
            gbc_B_15.gridx = 1;
            gbc_B_15.gridy = 15;
            add(B_15, gbc_B_15);
            platz15.put("B", B_15);
        }
        {
            JLabel K_15 = new JLabel("0");
            K_15.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_K_15 = new GridBagConstraints();
            gbc_K_15.fill = GridBagConstraints.BOTH;
            gbc_K_15.insets = new Insets(0, 0, 0, 5);
            gbc_K_15.gridx = 2;
            gbc_K_15.gridy = 15;
            this.add(K_15, gbc_K_15);
            platz15.put("K", K_15);
        }
        {
            JLabel S_15 = new JLabel("0");
            S_15.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_S_15 = new GridBagConstraints();
            gbc_S_15.fill = GridBagConstraints.BOTH;
            gbc_S_15.insets = new Insets(0, 0, 0, 5);
            gbc_S_15.gridx = 3;
            gbc_S_15.gridy = 15;
            this.add(S_15, gbc_S_15);
            platz15.put("S", S_15);
        }
        {
            JLabel U_15 = new JLabel("0");
            U_15.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_U_15 = new GridBagConstraints();
            gbc_U_15.fill = GridBagConstraints.BOTH;
            gbc_U_15.insets = new Insets(0, 0, 0, 5);
            gbc_U_15.gridx = 4;
            gbc_U_15.gridy = 15;
            this.add(U_15, gbc_U_15);
            platz15.put("U", U_15);
        }
        {
            JLabel E_15 = new JLabel("0");
            E_15.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_E_15 = new GridBagConstraints();
            gbc_E_15.fill = GridBagConstraints.BOTH;
            gbc_E_15.gridx = 5;
            gbc_E_15.gridy = 15;
            add(E_15, gbc_E_15);
            platz15.put("E", E_15);
        }

        container.add(platz1);
        container.add(platz2);
        container.add(platz3);
        container.add(platz4);
        // container.add(platz5);
        container.add(platz6);
        container.add(platz7);
        container.add(platz8);
        container.add(platz9);
        container.add(platz10);
        container.add(platz11);
        container.add(platz12);
        container.add(platz13);
        container.add(platz14);
        container.add(platz15);
    }

    public void setData(List<CapacityPlanningResult> data) {

        for (int i = 0; i < container.size(); ++i) {
            ((JLabel) container.get(i).get("B")).setText(String.valueOf(data.get(i).getProducedItemConfigs()));
            ((JLabel) container.get(i).get("K")).setText(String.valueOf(data.get(i).getReqCapacity()));
            ((JLabel) container.get(i).get("S")).setText(String.valueOf(data.get(i).getShifts()));
            ((JLabel) container.get(i).get("U")).setText(String.valueOf(data.get(i).getOvertime()));
            ((JLabel) container.get(i).get("E")).setText(String.valueOf(data.get(i).getEfficiency()));

        }
    }
}
