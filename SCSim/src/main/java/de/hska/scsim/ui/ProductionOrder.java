package de.hska.scsim.ui;

import de.hska.scsim.util.Messages;
import de.hska.scsim.util.IntegerDocumentFilter;
import de.hska.scsim.domain.output.ProductionPlanningResult;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument;

public class ProductionOrder extends JPanel {

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
	
	private JButton btnFertigungsauftrgeNeuBerechnen;

	private List<ProductionPlanningResult> data;

	private Map<String, JTextField> containerFields = new HashMap<>();
	private Map<String, JLabel> containerLabel = new HashMap<>();
	private MainGUI main;

	public ProductionOrder(MainGUI main) {
		setBorder(null);

		this.main = main;
		
		this.setFont(new Font("Arial", Font.PLAIN, 11)); //$NON-NLS-1$
		this.setAutoscrolls(true);
		this.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		this.setAlignmentX(Component.RIGHT_ALIGNMENT);
		this.setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 78, 78, 78, 78, 78, 78, 0 };
		gridBagLayout.rowHeights = new int[] { 70, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 0 };
		//gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		//gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
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
			JLabel lblProdukt = new JLabel(Messages.getString("product.1")); //$NON-NLS-1$
			lblProdukt.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblProdukt = new GridBagConstraints();
			gbc_lblProdukt.fill = GridBagConstraints.BOTH;
			gbc_lblProdukt.insets = new Insets(0, 0, 5, 5);
			gbc_lblProdukt.gridx = 1;
			gbc_lblProdukt.gridy = 0;
			this.add(lblProdukt, gbc_lblProdukt);
		}
		{
			JLabel lblSichBestand = new JLabel(Messages.getString("Buffer.7"));
			lblSichBestand.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblSichBestand = new GridBagConstraints();
			gbc_lblSichBestand.fill = GridBagConstraints.BOTH;
			gbc_lblSichBestand.insets = new Insets(0, 0, 5, 5);
			gbc_lblSichBestand.gridx = 2;
			gbc_lblSichBestand.gridy = 0;
			this.add(lblSichBestand, gbc_lblSichBestand);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 3;
			gbc_lblNewLabel_2.gridy = 0;
			add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			JLabel lblProdukt_1 = new JLabel(Messages.getString("product.2")); //$NON-NLS-1$
			lblProdukt_1.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblProdukt_1 = new GridBagConstraints();
			gbc_lblProdukt_1.fill = GridBagConstraints.BOTH;
			gbc_lblProdukt_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblProdukt_1.gridx = 4;
			gbc_lblProdukt_1.gridy = 0;
			this.add(lblProdukt_1, gbc_lblProdukt_1);
		}
		{
			JLabel lblSichBestand_1 = new JLabel(Messages.getString("Buffer.7"));
			lblSichBestand_1.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblSichBestand_1 = new GridBagConstraints();
			gbc_lblSichBestand_1.fill = GridBagConstraints.BOTH;
			gbc_lblSichBestand_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblSichBestand_1.gridx = 5;
			gbc_lblSichBestand_1.gridy = 0;
			this.add(lblSichBestand_1, gbc_lblSichBestand_1);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 6;
			gbc_lblNewLabel_3.gridy = 0;
			add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			JLabel lblPrdoukt = new JLabel(Messages.getString("product.3")); //$NON-NLS-1$
			lblPrdoukt.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblPrdoukt = new GridBagConstraints();
			gbc_lblPrdoukt.fill = GridBagConstraints.BOTH;
			gbc_lblPrdoukt.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrdoukt.gridx = 7;
			gbc_lblPrdoukt.gridy = 0;
			this.add(lblPrdoukt, gbc_lblPrdoukt);
		}
		{
			JLabel lblNewLabel_1 = new JLabel(Messages.getString("Buffer.7"));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_1.gridx = 8;
			gbc_lblNewLabel_1.gridy = 0;
			add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("P1"); //$NON-NLS-1$
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_7.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
			gbc_lblNewLabel_7.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_7.gridx = 0;
			gbc_lblNewLabel_7.gridy = 1;
			this.add(lblNewLabel_7, gbc_lblNewLabel_7);
		}
		{
			JLabel S_P1 = new JLabel("100");
			S_P1.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_P1 = new GridBagConstraints();
			gbc_S_P1.fill = GridBagConstraints.BOTH;
			gbc_S_P1.insets = new Insets(0, 0, 5, 5);
			gbc_S_P1.gridx = 1;
			gbc_S_P1.gridy = 1;
			add(S_P1, gbc_S_P1);
			containerLabel.put("P1", S_P1);
		}
		{
			P1_Value = new JTextField();
			P1_Value.setHorizontalAlignment(SwingConstants.CENTER);
			((AbstractDocument) P1_Value.getDocument())
					.setDocumentFilter(new IntegerDocumentFilter());
			GridBagConstraints gbc_P1_Value = new GridBagConstraints();
			gbc_P1_Value.fill = GridBagConstraints.BOTH;
			gbc_P1_Value.insets = new Insets(0, 0, 5, 5);
			gbc_P1_Value.gridx = 2;
			gbc_P1_Value.gridy = 1;
			this.add(P1_Value, gbc_P1_Value);
			P1_Value.setColumns(10);
		}

		containerFields.put("P1", P1_Value);
		{
			JLabel lblNewLabel_8 = new JLabel("P2"); //$NON-NLS-1$
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_8.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
			gbc_lblNewLabel_8.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_8.gridx = 3;
			gbc_lblNewLabel_8.gridy = 1;
			this.add(lblNewLabel_8, gbc_lblNewLabel_8);
		}
		P2_Value = new JTextField();
		P2_Value.setHorizontalAlignment(SwingConstants.CENTER);
		((AbstractDocument) P2_Value.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
		{
			JLabel S_P2 = new JLabel("100");
			S_P2.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_P2 = new GridBagConstraints();
			gbc_S_P2.fill = GridBagConstraints.BOTH;
			gbc_S_P2.insets = new Insets(0, 0, 5, 5);
			gbc_S_P2.gridx = 4;
			gbc_S_P2.gridy = 1;
			add(S_P2, gbc_S_P2);
			containerLabel.put("P2", S_P2);
		}
		GridBagConstraints gbc_P2_Value = new GridBagConstraints();
		gbc_P2_Value.fill = GridBagConstraints.BOTH;
		gbc_P2_Value.insets = new Insets(0, 0, 5, 5);
		gbc_P2_Value.gridx = 5;
		gbc_P2_Value.gridy = 1;
		this.add(P2_Value, gbc_P2_Value);
		P2_Value.setColumns(10);
		containerFields.put("P2", P2_Value);
		{
			JLabel S_P3 = new JLabel("P3"); //$NON-NLS-1$
			S_P3.setHorizontalAlignment(SwingConstants.RIGHT);
			S_P3.setBorder(null);
			GridBagConstraints gbc_S_P3 = new GridBagConstraints();
			gbc_S_P3.fill = GridBagConstraints.BOTH;
			gbc_S_P3.insets = new Insets(0, 0, 5, 5);
			gbc_S_P3.gridx = 6;
			gbc_S_P3.gridy = 1;
			this.add(S_P3, gbc_S_P3);
		}
		E55_Value = new JTextField();
		E55_Value.setHorizontalAlignment(SwingConstants.CENTER);
		((AbstractDocument) E55_Value.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
		P3_Value = new JTextField();
		P3_Value.setHorizontalAlignment(SwingConstants.CENTER);
		((AbstractDocument) P3_Value.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
		{
			JLabel S_P3 = new JLabel("100");
			S_P3.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_P3 = new GridBagConstraints();
			gbc_S_P3.fill = GridBagConstraints.BOTH;
			gbc_S_P3.insets = new Insets(0, 0, 5, 5);
			gbc_S_P3.gridx = 7;
			gbc_S_P3.gridy = 1;
			add(S_P3, gbc_S_P3);
			containerLabel.put("P3", S_P3);
		}
		GridBagConstraints gbc_P3_Value = new GridBagConstraints();
		gbc_P3_Value.fill = GridBagConstraints.BOTH;
		gbc_P3_Value.insets = new Insets(0, 0, 5, 0);
		gbc_P3_Value.gridx = 8;
		gbc_P3_Value.gridy = 1;
		this.add(P3_Value, gbc_P3_Value);
		P3_Value.setColumns(10);
		containerFields.put("P3", P3_Value);
		{
			JLabel lblNewLabel_10 = new JLabel("E51"); //$NON-NLS-1$
			lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_10.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
			gbc_lblNewLabel_10.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_10.gridx = 0;
			gbc_lblNewLabel_10.gridy = 2;
			this.add(lblNewLabel_10, gbc_lblNewLabel_10);
		}
		{
			JLabel S_E51 = new JLabel("100");
			S_E51.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E51 = new GridBagConstraints();
			gbc_S_E51.fill = GridBagConstraints.BOTH;
			gbc_S_E51.insets = new Insets(0, 0, 5, 5);
			gbc_S_E51.gridx = 1;
			gbc_S_E51.gridy = 2;
			add(S_E51, gbc_S_E51);
			containerLabel.put("E51", S_E51);
		}
		{
			E51_Value = new JTextField();
			E51_Value.setHorizontalAlignment(SwingConstants.CENTER);
			((AbstractDocument) E51_Value.getDocument())
					.setDocumentFilter(new IntegerDocumentFilter());
			GridBagConstraints gbc_E51_Value = new GridBagConstraints();
			gbc_E51_Value.fill = GridBagConstraints.BOTH;
			gbc_E51_Value.insets = new Insets(0, 0, 5, 5);
			gbc_E51_Value.gridx = 2;
			gbc_E51_Value.gridy = 2;
			this.add(E51_Value, gbc_E51_Value);
			E51_Value.setColumns(10);
		}
		containerFields.put("E51", E51_Value);
		{
			JLabel lblNewLabel_11 = new JLabel("E56"); //$NON-NLS-1$
			lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_11.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
			gbc_lblNewLabel_11.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_11.gridx = 3;
			gbc_lblNewLabel_11.gridy = 2;
			this.add(lblNewLabel_11, gbc_lblNewLabel_11);
		}
		E56_Value = new JTextField();
		E56_Value.setHorizontalAlignment(SwingConstants.CENTER);
		((AbstractDocument) E56_Value.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
		{
			JLabel S_E56 = new JLabel("100");
			S_E56.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E56 = new GridBagConstraints();
			gbc_S_E56.fill = GridBagConstraints.BOTH;
			gbc_S_E56.insets = new Insets(0, 0, 5, 5);
			gbc_S_E56.gridx = 4;
			gbc_S_E56.gridy = 2;
			add(S_E56, gbc_S_E56);
			containerLabel.put("E56", S_E56);
		}
		GridBagConstraints gbc_E56_Value = new GridBagConstraints();
		gbc_E56_Value.fill = GridBagConstraints.BOTH;
		gbc_E56_Value.insets = new Insets(0, 0, 5, 5);
		gbc_E56_Value.gridx = 5;
		gbc_E56_Value.gridy = 2;
		this.add(E56_Value, gbc_E56_Value);
		E56_Value.setColumns(10);
		containerFields.put("E56", E56_Value);
		{
			JLabel lblNewLabel_13 = new JLabel("E31"); //$NON-NLS-1$
			lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_13.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
			gbc_lblNewLabel_13.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_13.gridx = 6;
			gbc_lblNewLabel_13.gridy = 2;
			this.add(lblNewLabel_13, gbc_lblNewLabel_13);
		}
		E31_Value = new JTextField();
		E31_Value.setHorizontalAlignment(SwingConstants.CENTER);
		((AbstractDocument) E31_Value.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
		{
			JLabel S_E31 = new JLabel("100");
			S_E31.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E31 = new GridBagConstraints();
			gbc_S_E31.fill = GridBagConstraints.BOTH;
			gbc_S_E31.insets = new Insets(0, 0, 5, 5);
			gbc_S_E31.gridx = 7;
			gbc_S_E31.gridy = 2;
			add(S_E31, gbc_S_E31);
			containerLabel.put("E31", S_E31);
		}
		GridBagConstraints gbc_E31_Value = new GridBagConstraints();
		gbc_E31_Value.fill = GridBagConstraints.BOTH;
		gbc_E31_Value.insets = new Insets(0, 0, 5, 0);
		gbc_E31_Value.gridx = 8;
		gbc_E31_Value.gridy = 2;
		this.add(E31_Value, gbc_E31_Value);
		E31_Value.setColumns(10);
		containerFields.put("E31", E31_Value);
		{
			JLabel lblNewLabel_14 = new JLabel("E50"); //$NON-NLS-1$
			lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_14.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
			gbc_lblNewLabel_14.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_14.gridx = 0;
			gbc_lblNewLabel_14.gridy = 3;
			this.add(lblNewLabel_14, gbc_lblNewLabel_14);
		}
		{
			JLabel S_E50 = new JLabel("100");
			S_E50.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E50 = new GridBagConstraints();
			gbc_S_E50.fill = GridBagConstraints.BOTH;
			gbc_S_E50.insets = new Insets(0, 0, 5, 5);
			gbc_S_E50.gridx = 1;
			gbc_S_E50.gridy = 3;
			add(S_E50, gbc_S_E50);
			containerLabel.put("E50", S_E50);
		}
		{
			E50_Value = new JTextField();
			E50_Value.setHorizontalAlignment(SwingConstants.CENTER);
			((AbstractDocument) E50_Value.getDocument())
					.setDocumentFilter(new IntegerDocumentFilter());
			GridBagConstraints gbc_E50_Value = new GridBagConstraints();
			gbc_E50_Value.fill = GridBagConstraints.BOTH;
			gbc_E50_Value.insets = new Insets(0, 0, 5, 5);
			gbc_E50_Value.gridx = 2;
			gbc_E50_Value.gridy = 3;
			this.add(E50_Value, gbc_E50_Value);
			E50_Value.setColumns(10);
		}
		containerFields.put("E50", E50_Value);
		{
			JLabel lblNewLabel_15 = new JLabel("E55"); //$NON-NLS-1$
			lblNewLabel_15.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_15.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
			gbc_lblNewLabel_15.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_15.gridx = 3;
			gbc_lblNewLabel_15.gridy = 3;
			this.add(lblNewLabel_15, gbc_lblNewLabel_15);
		}
		{
			JLabel S_E55 = new JLabel("100");
			S_E55.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E55 = new GridBagConstraints();
			gbc_S_E55.fill = GridBagConstraints.BOTH;
			gbc_S_E55.insets = new Insets(0, 0, 5, 5);
			gbc_S_E55.gridx = 4;
			gbc_S_E55.gridy = 3;
			add(S_E55, gbc_S_E55);
			containerLabel.put("E55", S_E55);
		}
		GridBagConstraints gbc_E55_Value = new GridBagConstraints();
		gbc_E55_Value.fill = GridBagConstraints.BOTH;
		gbc_E55_Value.insets = new Insets(0, 0, 5, 5);
		gbc_E55_Value.gridx = 5;
		gbc_E55_Value.gridy = 3;
		this.add(E55_Value, gbc_E55_Value);
		E55_Value.setColumns(10);
		containerFields.put("E55", E55_Value);
		E6_Value = new JTextField();
		E6_Value.setHorizontalAlignment(SwingConstants.CENTER);
		((AbstractDocument) E6_Value.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
		E5_Value = new JTextField();
		E5_Value.setHorizontalAlignment(SwingConstants.CENTER);
		((AbstractDocument) E5_Value.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
		E4_Value = new JTextField();
		E4_Value.setHorizontalAlignment(SwingConstants.CENTER);
		((AbstractDocument) E4_Value.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
		E30_Value = new JTextField();
		E30_Value.setHorizontalAlignment(SwingConstants.CENTER);
		((AbstractDocument) E30_Value.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
		{
			JLabel lblNewLabel_16 = new JLabel("E30"); //$NON-NLS-1$
			lblNewLabel_16.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_16.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
			gbc_lblNewLabel_16.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_16.gridx = 6;
			gbc_lblNewLabel_16.gridy = 3;
			this.add(lblNewLabel_16, gbc_lblNewLabel_16);
		}
		{
			JLabel S_E30 = new JLabel("100");
			S_E30.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E30 = new GridBagConstraints();
			gbc_S_E30.fill = GridBagConstraints.BOTH;
			gbc_S_E30.insets = new Insets(0, 0, 5, 5);
			gbc_S_E30.gridx = 7;
			gbc_S_E30.gridy = 3;
			add(S_E30, gbc_S_E30);
			containerLabel.put("E30", S_E30);
		}
		GridBagConstraints gbc_E30_Value = new GridBagConstraints();
		gbc_E30_Value.fill = GridBagConstraints.BOTH;
		gbc_E30_Value.insets = new Insets(0, 0, 5, 0);
		gbc_E30_Value.gridx = 8;
		gbc_E30_Value.gridy = 3;
		this.add(E30_Value, gbc_E30_Value);
		E30_Value.setColumns(10);
		containerFields.put("E30", E30_Value);
		{
			JLabel lblNewLabel_17 = new JLabel("E4"); //$NON-NLS-1$
			lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_17.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
			gbc_lblNewLabel_17.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_17.gridx = 0;
			gbc_lblNewLabel_17.gridy = 4;
			this.add(lblNewLabel_17, gbc_lblNewLabel_17);
		}
		{
			JLabel S_E4 = new JLabel("100");
			S_E4.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E4 = new GridBagConstraints();
			gbc_S_E4.fill = GridBagConstraints.BOTH;
			gbc_S_E4.insets = new Insets(0, 0, 5, 5);
			gbc_S_E4.gridx = 1;
			gbc_S_E4.gridy = 4;
			add(S_E4, gbc_S_E4);
			containerLabel.put("E4", S_E4);
		}
		GridBagConstraints gbc_E4_Value = new GridBagConstraints();
		gbc_E4_Value.fill = GridBagConstraints.BOTH;
		gbc_E4_Value.insets = new Insets(0, 0, 5, 5);
		gbc_E4_Value.gridx = 2;
		gbc_E4_Value.gridy = 4;
		this.add(E4_Value, gbc_E4_Value);
		E4_Value.setColumns(10);
		containerFields.put("E4", E4_Value);
		{
			JLabel lblNewLabel_18 = new JLabel("E5"); //$NON-NLS-1$
			lblNewLabel_18.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_18.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
			gbc_lblNewLabel_18.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_18.gridx = 3;
			gbc_lblNewLabel_18.gridy = 4;
			this.add(lblNewLabel_18, gbc_lblNewLabel_18);
		}
		{
			JLabel S_E5 = new JLabel("100");
			S_E5.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E5 = new GridBagConstraints();
			gbc_S_E5.fill = GridBagConstraints.BOTH;
			gbc_S_E5.insets = new Insets(0, 0, 5, 5);
			gbc_S_E5.gridx = 4;
			gbc_S_E5.gridy = 4;
			add(S_E5, gbc_S_E5);
			containerLabel.put("E5", S_E5);
		}
		GridBagConstraints gbc_E5_Value = new GridBagConstraints();
		gbc_E5_Value.fill = GridBagConstraints.BOTH;
		gbc_E5_Value.insets = new Insets(0, 0, 5, 5);
		gbc_E5_Value.gridx = 5;
		gbc_E5_Value.gridy = 4;
		this.add(E5_Value, gbc_E5_Value);
		E5_Value.setColumns(10);
		containerFields.put("E5", E5_Value);
		{
			JLabel lblNewLabel_19 = new JLabel("E6"); //$NON-NLS-1$
			lblNewLabel_19.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_19.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
			gbc_lblNewLabel_19.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_19.gridx = 6;
			gbc_lblNewLabel_19.gridy = 4;
			this.add(lblNewLabel_19, gbc_lblNewLabel_19);
		}
		{
			JLabel S_E6 = new JLabel("100");
			S_E6.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E6 = new GridBagConstraints();
			gbc_S_E6.fill = GridBagConstraints.BOTH;
			gbc_S_E6.insets = new Insets(0, 0, 5, 5);
			gbc_S_E6.gridx = 7;
			gbc_S_E6.gridy = 4;
			add(S_E6, gbc_S_E6);
			containerLabel.put("E6", S_E6);
		}
		GridBagConstraints gbc_E6_Value = new GridBagConstraints();
		gbc_E6_Value.fill = GridBagConstraints.BOTH;
		gbc_E6_Value.insets = new Insets(0, 0, 5, 0);
		gbc_E6_Value.gridx = 8;
		gbc_E6_Value.gridy = 4;
		this.add(E6_Value, gbc_E6_Value);
		E6_Value.setColumns(10);
		containerFields.put("E6", E6_Value);
		{
			JLabel lblNewLabel_20 = new JLabel("E10"); //$NON-NLS-1$
			lblNewLabel_20.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_20.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
			gbc_lblNewLabel_20.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_20.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_20.gridx = 0;
			gbc_lblNewLabel_20.gridy = 5;
			this.add(lblNewLabel_20, gbc_lblNewLabel_20);
		}
		{
			JLabel S_E10 = new JLabel("100");
			S_E10.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E10 = new GridBagConstraints();
			gbc_S_E10.fill = GridBagConstraints.BOTH;
			gbc_S_E10.insets = new Insets(0, 0, 5, 5);
			gbc_S_E10.gridx = 1;
			gbc_S_E10.gridy = 5;
			add(S_E10, gbc_S_E10);
			containerLabel.put("E10", S_E10);
		}
		{
			E10_Value = new JTextField();
			E10_Value.setHorizontalAlignment(SwingConstants.CENTER);
			((AbstractDocument) E10_Value.getDocument())
					.setDocumentFilter(new IntegerDocumentFilter());
			GridBagConstraints gbc_E10_Value = new GridBagConstraints();
			gbc_E10_Value.fill = GridBagConstraints.BOTH;
			gbc_E10_Value.insets = new Insets(0, 0, 5, 5);
			gbc_E10_Value.gridx = 2;
			gbc_E10_Value.gridy = 5;
			this.add(E10_Value, gbc_E10_Value);
			E10_Value.setColumns(10);
		}
		containerFields.put("E10", E10_Value);
		{
			JLabel lblNewLabel_12 = new JLabel("E11"); //$NON-NLS-1$
			lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_12.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
			gbc_lblNewLabel_12.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_12.gridx = 3;
			gbc_lblNewLabel_12.gridy = 5;
			this.add(lblNewLabel_12, gbc_lblNewLabel_12);
		}
		{
			JLabel S_E11 = new JLabel("100");
			S_E11.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E11 = new GridBagConstraints();
			gbc_S_E11.fill = GridBagConstraints.BOTH;
			gbc_S_E11.insets = new Insets(0, 0, 5, 5);
			gbc_S_E11.gridx = 4;
			gbc_S_E11.gridy = 5;
			add(S_E11, gbc_S_E11);
			containerLabel.put("E11", S_E11);
		}
		{
			E11_Value = new JTextField();
			E11_Value.setHorizontalAlignment(SwingConstants.CENTER);
			((AbstractDocument) E11_Value.getDocument())
					.setDocumentFilter(new IntegerDocumentFilter());
			GridBagConstraints gbc_E11_Value = new GridBagConstraints();
			gbc_E11_Value.fill = GridBagConstraints.BOTH;
			gbc_E11_Value.insets = new Insets(0, 0, 5, 5);
			gbc_E11_Value.gridx = 5;
			gbc_E11_Value.gridy = 5;
			this.add(E11_Value, gbc_E11_Value);
			E11_Value.setColumns(10);
		}
		containerFields.put("E11", E11_Value);
		{
			JLabel lblNewLabel_21 = new JLabel("E12"); //$NON-NLS-1$
			lblNewLabel_21.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_21.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
			gbc_lblNewLabel_21.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_21.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_21.gridx = 6;
			gbc_lblNewLabel_21.gridy = 5;
			this.add(lblNewLabel_21, gbc_lblNewLabel_21);
		}
		{
			JLabel S_E12 = new JLabel("100");
			S_E12.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E12 = new GridBagConstraints();
			gbc_S_E12.fill = GridBagConstraints.BOTH;
			gbc_S_E12.insets = new Insets(0, 0, 5, 5);
			gbc_S_E12.gridx = 7;
			gbc_S_E12.gridy = 5;
			add(S_E12, gbc_S_E12);
			containerLabel.put("E12", S_E12);
		}
		E49_Value = new JTextField();
		E49_Value.setHorizontalAlignment(SwingConstants.CENTER);
		((AbstractDocument) E49_Value.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
		{
			E12_Value = new JTextField();
			E12_Value.setHorizontalAlignment(SwingConstants.CENTER);
			((AbstractDocument) E12_Value.getDocument())
					.setDocumentFilter(new IntegerDocumentFilter());
			GridBagConstraints gbc_E12_Value = new GridBagConstraints();
			gbc_E12_Value.fill = GridBagConstraints.BOTH;
			gbc_E12_Value.insets = new Insets(0, 0, 5, 0);
			gbc_E12_Value.gridx = 8;
			gbc_E12_Value.gridy = 5;
			this.add(E12_Value, gbc_E12_Value);
			E12_Value.setColumns(10);
		}
		containerFields.put("E12", E12_Value);
		{
			JLabel lblNewLabel_22 = new JLabel("E49"); //$NON-NLS-1$
			lblNewLabel_22.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_22.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_22 = new GridBagConstraints();
			gbc_lblNewLabel_22.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_22.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_22.gridx = 0;
			gbc_lblNewLabel_22.gridy = 6;
			this.add(lblNewLabel_22, gbc_lblNewLabel_22);
		}
		{
			JLabel S_E49 = new JLabel("100");
			S_E49.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E49 = new GridBagConstraints();
			gbc_S_E49.fill = GridBagConstraints.BOTH;
			gbc_S_E49.insets = new Insets(0, 0, 5, 5);
			gbc_S_E49.gridx = 1;
			gbc_S_E49.gridy = 6;
			add(S_E49, gbc_S_E49);
			containerLabel.put("E49", S_E49);
		}
		GridBagConstraints gbc_E49_Value = new GridBagConstraints();
		gbc_E49_Value.fill = GridBagConstraints.BOTH;
		gbc_E49_Value.insets = new Insets(0, 0, 5, 5);
		gbc_E49_Value.gridx = 2;
		gbc_E49_Value.gridy = 6;
		this.add(E49_Value, gbc_E49_Value);
		E49_Value.setColumns(10);
		containerFields.put("E49", E49_Value);
		{
			JLabel lblNewLabel_23 = new JLabel("E54"); //$NON-NLS-1$
			lblNewLabel_23.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_23.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_23 = new GridBagConstraints();
			gbc_lblNewLabel_23.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_23.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_23.gridx = 3;
			gbc_lblNewLabel_23.gridy = 6;
			this.add(lblNewLabel_23, gbc_lblNewLabel_23);
		}
		{
			JLabel S_E54 = new JLabel("100");
			S_E54.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E54 = new GridBagConstraints();
			gbc_S_E54.fill = GridBagConstraints.BOTH;
			gbc_S_E54.insets = new Insets(0, 0, 5, 5);
			gbc_S_E54.gridx = 4;
			gbc_S_E54.gridy = 6;
			add(S_E54, gbc_S_E54);
			containerLabel.put("E54", S_E54);
		}
		{
			E54_Value = new JTextField();
			E54_Value.setHorizontalAlignment(SwingConstants.CENTER);
			((AbstractDocument) E54_Value.getDocument())
					.setDocumentFilter(new IntegerDocumentFilter());
			GridBagConstraints gbc_E54_Value = new GridBagConstraints();
			gbc_E54_Value.fill = GridBagConstraints.BOTH;
			gbc_E54_Value.insets = new Insets(0, 0, 5, 5);
			gbc_E54_Value.gridx = 5;
			gbc_E54_Value.gridy = 6;
			this.add(E54_Value, gbc_E54_Value);
			E54_Value.setColumns(10);
		}
		containerFields.put("E54", E54_Value);
		{
			JLabel lblNewLabel_24 = new JLabel("E29"); //$NON-NLS-1$
			lblNewLabel_24.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_24.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_24 = new GridBagConstraints();
			gbc_lblNewLabel_24.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_24.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_24.gridx = 6;
			gbc_lblNewLabel_24.gridy = 6;
			this.add(lblNewLabel_24, gbc_lblNewLabel_24);
		}
		{
			JLabel S_E29 = new JLabel("100");
			S_E29.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E29 = new GridBagConstraints();
			gbc_S_E29.fill = GridBagConstraints.BOTH;
			gbc_S_E29.insets = new Insets(0, 0, 5, 5);
			gbc_S_E29.gridx = 7;
			gbc_S_E29.gridy = 6;
			add(S_E29, gbc_S_E29);
			containerLabel.put("E29", S_E29);
		}
		{
			E29_Value = new JTextField();
			E29_Value.setHorizontalAlignment(SwingConstants.CENTER);
			((AbstractDocument) E29_Value.getDocument())
					.setDocumentFilter(new IntegerDocumentFilter());
			GridBagConstraints gbc_E29_Value = new GridBagConstraints();
			gbc_E29_Value.fill = GridBagConstraints.BOTH;
			gbc_E29_Value.insets = new Insets(0, 0, 5, 0);
			gbc_E29_Value.gridx = 8;
			gbc_E29_Value.gridy = 6;
			this.add(E29_Value, gbc_E29_Value);
			E29_Value.setColumns(10);
		}
		containerFields.put("E29", E29_Value);
		{
			JLabel lblNewLabel_25 = new JLabel("E7"); //$NON-NLS-1$
			lblNewLabel_25.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_25.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_25 = new GridBagConstraints();
			gbc_lblNewLabel_25.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_25.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_25.gridx = 0;
			gbc_lblNewLabel_25.gridy = 7;
			this.add(lblNewLabel_25, gbc_lblNewLabel_25);
		}
		E7_Value = new JTextField();
		E7_Value.setHorizontalAlignment(SwingConstants.CENTER);
		((AbstractDocument) E7_Value.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
		{
			JLabel S_E7 = new JLabel("100");
			S_E7.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E7 = new GridBagConstraints();
			gbc_S_E7.fill = GridBagConstraints.BOTH;
			gbc_S_E7.insets = new Insets(0, 0, 5, 5);
			gbc_S_E7.gridx = 1;
			gbc_S_E7.gridy = 7;
			add(S_E7, gbc_S_E7);
			containerLabel.put("E7", S_E7);
		}
		GridBagConstraints gbc_E7_Value = new GridBagConstraints();
		gbc_E7_Value.fill = GridBagConstraints.BOTH;
		gbc_E7_Value.insets = new Insets(0, 0, 5, 5);
		gbc_E7_Value.gridx = 2;
		gbc_E7_Value.gridy = 7;
		this.add(E7_Value, gbc_E7_Value);
		E7_Value.setColumns(10);
		containerFields.put("E7", E7_Value);
		{
			JLabel lblNewLabel_26 = new JLabel("E8"); //$NON-NLS-1$
			lblNewLabel_26.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_26.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_26 = new GridBagConstraints();
			gbc_lblNewLabel_26.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_26.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_26.gridx = 3;
			gbc_lblNewLabel_26.gridy = 7;
			this.add(lblNewLabel_26, gbc_lblNewLabel_26);
		}
		E8_Value = new JTextField();
		E8_Value.setHorizontalAlignment(SwingConstants.CENTER);
		((AbstractDocument) E8_Value.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
		{
			JLabel S_E8 = new JLabel("100");
			S_E8.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E8 = new GridBagConstraints();
			gbc_S_E8.fill = GridBagConstraints.BOTH;
			gbc_S_E8.insets = new Insets(0, 0, 5, 5);
			gbc_S_E8.gridx = 4;
			gbc_S_E8.gridy = 7;
			add(S_E8, gbc_S_E8);
			containerLabel.put("E8", S_E8);
		}
		GridBagConstraints gbc_E8_Value = new GridBagConstraints();
		gbc_E8_Value.fill = GridBagConstraints.BOTH;
		gbc_E8_Value.insets = new Insets(0, 0, 5, 5);
		gbc_E8_Value.gridx = 5;
		gbc_E8_Value.gridy = 7;
		this.add(E8_Value, gbc_E8_Value);
		E8_Value.setColumns(10);
		containerFields.put("E8", E8_Value);
		{
			JLabel lblNewLabel_27 = new JLabel("E9"); //$NON-NLS-1$
			lblNewLabel_27.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_27.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_27 = new GridBagConstraints();
			gbc_lblNewLabel_27.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_27.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_27.gridx = 6;
			gbc_lblNewLabel_27.gridy = 7;
			this.add(lblNewLabel_27, gbc_lblNewLabel_27);
		}
		E9_Value = new JTextField();
		E9_Value.setHorizontalAlignment(SwingConstants.CENTER);
		((AbstractDocument) E9_Value.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
		{
			JLabel S_E9 = new JLabel("100");
			S_E9.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E9 = new GridBagConstraints();
			gbc_S_E9.fill = GridBagConstraints.BOTH;
			gbc_S_E9.insets = new Insets(0, 0, 5, 5);
			gbc_S_E9.gridx = 7;
			gbc_S_E9.gridy = 7;
			add(S_E9, gbc_S_E9);
			containerLabel.put("E9", S_E9);
		}
		GridBagConstraints gbc_E9_Value = new GridBagConstraints();
		gbc_E9_Value.fill = GridBagConstraints.BOTH;
		gbc_E9_Value.insets = new Insets(0, 0, 5, 0);
		gbc_E9_Value.gridx = 8;
		gbc_E9_Value.gridy = 7;
		this.add(E9_Value, gbc_E9_Value);
		E9_Value.setColumns(10);
		containerFields.put("E9", E9_Value);
		{
			JLabel lblNewLabel_28 = new JLabel("E13"); //$NON-NLS-1$
			lblNewLabel_28.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_28.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_28 = new GridBagConstraints();
			gbc_lblNewLabel_28.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_28.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_28.gridx = 0;
			gbc_lblNewLabel_28.gridy = 8;
			this.add(lblNewLabel_28, gbc_lblNewLabel_28);
		}
		E14_Value = new JTextField();
		E14_Value.setHorizontalAlignment(SwingConstants.CENTER);
		((AbstractDocument) E14_Value.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
		{
			JLabel S_E13 = new JLabel("100");
			S_E13.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E13 = new GridBagConstraints();
			gbc_S_E13.fill = GridBagConstraints.BOTH;
			gbc_S_E13.insets = new Insets(0, 0, 5, 5);
			gbc_S_E13.gridx = 1;
			gbc_S_E13.gridy = 8;
			add(S_E13, gbc_S_E13);
			containerLabel.put("E13", S_E13);
		}
		{
			E13_Value = new JTextField();
			E13_Value.setHorizontalAlignment(SwingConstants.CENTER);
			((AbstractDocument) E13_Value.getDocument())
					.setDocumentFilter(new IntegerDocumentFilter());
			GridBagConstraints gbc_E13_Value = new GridBagConstraints();
			gbc_E13_Value.fill = GridBagConstraints.BOTH;
			gbc_E13_Value.insets = new Insets(0, 0, 5, 5);
			gbc_E13_Value.gridx = 2;
			gbc_E13_Value.gridy = 8;
			this.add(E13_Value, gbc_E13_Value);
			E13_Value.setColumns(10);
		}
		containerFields.put("E13", E13_Value);
		{
			JLabel lblNewLabel_29 = new JLabel("E14"); //$NON-NLS-1$
			lblNewLabel_29.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_29.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_29 = new GridBagConstraints();
			gbc_lblNewLabel_29.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_29.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_29.gridx = 3;
			gbc_lblNewLabel_29.gridy = 8;
			this.add(lblNewLabel_29, gbc_lblNewLabel_29);
		}
		{
			JLabel S_E14 = new JLabel("100");
			S_E14.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E14 = new GridBagConstraints();
			gbc_S_E14.fill = GridBagConstraints.BOTH;
			gbc_S_E14.insets = new Insets(0, 0, 5, 5);
			gbc_S_E14.gridx = 4;
			gbc_S_E14.gridy = 8;
			add(S_E14, gbc_S_E14);
			containerLabel.put("E14", S_E14);
		}
		GridBagConstraints gbc_E14_Value = new GridBagConstraints();
		gbc_E14_Value.fill = GridBagConstraints.BOTH;
		gbc_E14_Value.insets = new Insets(0, 0, 5, 5);
		gbc_E14_Value.gridx = 5;
		gbc_E14_Value.gridy = 8;
		this.add(E14_Value, gbc_E14_Value);
		E14_Value.setColumns(10);
		containerFields.put("E14", E14_Value);
		{
			JLabel lblNewLabel_30 = new JLabel("E15"); //$NON-NLS-1$
			lblNewLabel_30.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_30.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_30 = new GridBagConstraints();
			gbc_lblNewLabel_30.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_30.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_30.gridx = 6;
			gbc_lblNewLabel_30.gridy = 8;
			this.add(lblNewLabel_30, gbc_lblNewLabel_30);
		}
		E15_Value = new JTextField();
		E15_Value.setHorizontalAlignment(SwingConstants.CENTER);
		((AbstractDocument) E15_Value.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
		{
			JLabel S_E15 = new JLabel("100");
			S_E15.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E15 = new GridBagConstraints();
			gbc_S_E15.fill = GridBagConstraints.BOTH;
			gbc_S_E15.insets = new Insets(0, 0, 5, 5);
			gbc_S_E15.gridx = 7;
			gbc_S_E15.gridy = 8;
			add(S_E15, gbc_S_E15);
			containerLabel.put("E15", S_E15);
		}
		GridBagConstraints gbc_E15_Value = new GridBagConstraints();
		gbc_E15_Value.fill = GridBagConstraints.BOTH;
		gbc_E15_Value.insets = new Insets(0, 0, 5, 0);
		gbc_E15_Value.gridx = 8;
		gbc_E15_Value.gridy = 8;
		this.add(E15_Value, gbc_E15_Value);
		E15_Value.setColumns(10);
		containerFields.put("E15", E15_Value);
		{
			JLabel lblNewLabel_31 = new JLabel("E18"); //$NON-NLS-1$
			lblNewLabel_31.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_31.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_31 = new GridBagConstraints();
			gbc_lblNewLabel_31.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_31.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_31.gridx = 0;
			gbc_lblNewLabel_31.gridy = 9;
			this.add(lblNewLabel_31, gbc_lblNewLabel_31);
		}
		{
			JLabel S_E18 = new JLabel("100");
			S_E18.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E18 = new GridBagConstraints();
			gbc_S_E18.fill = GridBagConstraints.BOTH;
			gbc_S_E18.insets = new Insets(0, 0, 5, 5);
			gbc_S_E18.gridx = 1;
			gbc_S_E18.gridy = 9;
			add(S_E18, gbc_S_E18);
			containerLabel.put("E18", S_E18);
		}
		{
			E18_Value = new JTextField();
			E18_Value.setHorizontalAlignment(SwingConstants.CENTER);
			((AbstractDocument) E18_Value.getDocument())
					.setDocumentFilter(new IntegerDocumentFilter());
			GridBagConstraints gbc_E18_Value = new GridBagConstraints();
			gbc_E18_Value.fill = GridBagConstraints.BOTH;
			gbc_E18_Value.insets = new Insets(0, 0, 5, 5);
			gbc_E18_Value.gridx = 2;
			gbc_E18_Value.gridy = 9;
			this.add(E18_Value, gbc_E18_Value);
			E18_Value.setColumns(10);
		}
		containerFields.put("E18", E18_Value);
		{
			JLabel lblNewLabel_32 = new JLabel("E19"); //$NON-NLS-1$
			lblNewLabel_32.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_32.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_32 = new GridBagConstraints();
			gbc_lblNewLabel_32.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_32.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_32.gridx = 3;
			gbc_lblNewLabel_32.gridy = 9;
			this.add(lblNewLabel_32, gbc_lblNewLabel_32);
		}
		E19_Value = new JTextField();
		E19_Value.setHorizontalAlignment(SwingConstants.CENTER);
		((AbstractDocument) E19_Value.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
		{
			JLabel S_E19 = new JLabel("100");
			S_E19.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E19 = new GridBagConstraints();
			gbc_S_E19.fill = GridBagConstraints.BOTH;
			gbc_S_E19.insets = new Insets(0, 0, 5, 5);
			gbc_S_E19.gridx = 4;
			gbc_S_E19.gridy = 9;
			add(S_E19, gbc_S_E19);
			containerLabel.put("E19", S_E19);
		}
		GridBagConstraints gbc_E19_Value = new GridBagConstraints();
		gbc_E19_Value.fill = GridBagConstraints.BOTH;
		gbc_E19_Value.insets = new Insets(0, 0, 5, 5);
		gbc_E19_Value.gridx = 5;
		gbc_E19_Value.gridy = 9;
		this.add(E19_Value, gbc_E19_Value);
		E19_Value.setColumns(10);
		containerFields.put("E19", E19_Value);
		{
			JLabel lblNewLabel_33 = new JLabel("E20"); //$NON-NLS-1$
			lblNewLabel_33.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_33.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_33 = new GridBagConstraints();
			gbc_lblNewLabel_33.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_33.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_33.gridx = 6;
			gbc_lblNewLabel_33.gridy = 9;
			this.add(lblNewLabel_33, gbc_lblNewLabel_33);
		}
		{
			JLabel S_E20 = new JLabel("100");
			S_E20.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_S_E20 = new GridBagConstraints();
			gbc_S_E20.fill = GridBagConstraints.BOTH;
			gbc_S_E20.insets = new Insets(0, 0, 5, 5);
			gbc_S_E20.gridx = 7;
			gbc_S_E20.gridy = 9;
			add(S_E20, gbc_S_E20);
			containerLabel.put("E20", S_E20);
		}
		{
			E20_Value = new JTextField();
			E20_Value.setHorizontalAlignment(SwingConstants.CENTER);
			((AbstractDocument) E20_Value.getDocument())
					.setDocumentFilter(new IntegerDocumentFilter());
			GridBagConstraints gbc_E20_Value = new GridBagConstraints();
			gbc_E20_Value.fill = GridBagConstraints.BOTH;
			gbc_E20_Value.insets = new Insets(0, 0, 5, 0);
			gbc_E20_Value.gridx = 8;
			gbc_E20_Value.gridy = 9;
			this.add(E20_Value, gbc_E20_Value);
			E20_Value.setColumns(10);
		}
		containerFields.put("E20", E20_Value);
		{
			JLabel lblFrAlleProdukte = new JLabel(Messages.getString("product.all")); //$NON-NLS-1$
			lblFrAlleProdukte.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblFrAlleProdukte = new GridBagConstraints();
			gbc_lblFrAlleProdukte.gridwidth = 2;
			gbc_lblFrAlleProdukte.fill = GridBagConstraints.BOTH;
			gbc_lblFrAlleProdukte.insets = new Insets(0, 0, 5, 5);
			gbc_lblFrAlleProdukte.gridx = 0;
			gbc_lblFrAlleProdukte.gridy = 10;
			this.add(lblFrAlleProdukte, gbc_lblFrAlleProdukte);
		}
		{
			JLabel lblSichBestand_2 = new JLabel(Messages.getString("Buffer.7"));
			lblSichBestand_2.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblSichBestand_2 = new GridBagConstraints();
			gbc_lblSichBestand_2.fill = GridBagConstraints.BOTH;
			gbc_lblSichBestand_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblSichBestand_2.gridx = 2;
			gbc_lblSichBestand_2.gridy = 10;
			this.add(lblSichBestand_2, gbc_lblSichBestand_2);
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
			JLabel lblNewLabel_5 = new JLabel("");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 7;
			gbc_lblNewLabel_5.gridy = 10;
			add(lblNewLabel_5, gbc_lblNewLabel_5);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("");
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_6.gridx = 8;
			gbc_lblNewLabel_6.gridy = 10;
			add(lblNewLabel_6, gbc_lblNewLabel_6);
		}
		{
			JLabel lblNewLabel_34 = new JLabel("E26"); //$NON-NLS-1$
			lblNewLabel_34.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_34.setBorder(null);
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
			{
				JLabel S_E26 = new JLabel("100");
				S_E26.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_S_E26 = new GridBagConstraints();
				gbc_S_E26.fill = GridBagConstraints.BOTH;
				gbc_S_E26.insets = new Insets(0, 0, 5, 5);
				gbc_S_E26.gridx = 1;
				gbc_S_E26.gridy = 11;
				this.add(S_E26, gbc_S_E26);
				containerLabel.put("E26", S_E26);
			}
			GridBagConstraints gbc_E26_Value = new GridBagConstraints();
			gbc_E26_Value.fill = GridBagConstraints.BOTH;
			gbc_E26_Value.insets = new Insets(0, 0, 5, 5);
			gbc_E26_Value.gridx = 2;
			gbc_E26_Value.gridy = 11;
			this.add(E26_Value, gbc_E26_Value);
			E26_Value.setColumns(10);
		}
		containerFields.put("E26", E26_Value);
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
			gbc_label.gridx = 8;
			gbc_label.gridy = 11;
			this.add(label, gbc_label);
		}
		{
			JLabel lblNewLabel_35 = new JLabel("E16"); //$NON-NLS-1$
			lblNewLabel_35.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_35.setBorder(null);
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
			{
				JLabel S_E16 = new JLabel("100");
				S_E16.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_S_E16 = new GridBagConstraints();
				gbc_S_E16.fill = GridBagConstraints.BOTH;
				gbc_S_E16.insets = new Insets(0, 0, 5, 5);
				gbc_S_E16.gridx = 1;
				gbc_S_E16.gridy = 12;
				this.add(S_E16, gbc_S_E16);
				containerLabel.put("E16", S_E16);
			}
			GridBagConstraints gbc_E16_Value = new GridBagConstraints();
			gbc_E16_Value.fill = GridBagConstraints.BOTH;
			gbc_E16_Value.insets = new Insets(0, 0, 5, 5);
			gbc_E16_Value.gridx = 2;
			gbc_E16_Value.gridy = 12;
			this.add(E16_Value, gbc_E16_Value);
			E16_Value.setColumns(10);
		}
		containerFields.put("E16", E16_Value);
		{
			btnFertigungsauftrgeNeuBerechnen = new JButton(
					Messages.getString("Buffer.8"));
			btnFertigungsauftrgeNeuBerechnen.setEnabled(false);
			GridBagConstraints gbc_btnFertigungsauftrgeNeuBerechnen = new GridBagConstraints();
			gbc_btnFertigungsauftrgeNeuBerechnen.gridwidth = 3;
			gbc_btnFertigungsauftrgeNeuBerechnen.insets = new Insets(0, 0, 5, 5);
			gbc_btnFertigungsauftrgeNeuBerechnen.gridx = 5;
			gbc_btnFertigungsauftrgeNeuBerechnen.gridy = 12;
			add(btnFertigungsauftrgeNeuBerechnen, gbc_btnFertigungsauftrgeNeuBerechnen);
			btnFertigungsauftrgeNeuBerechnen.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ProductionOrder.this.main.FertigungsauftraegeNeuGenerieren(getFieldsValues());
					ProductionOrder.this.main.getCancelButton().setEnabled(true);
					ProductionOrder.this.main.getCancelButton().requestFocus();
					btnFertigungsauftrgeNeuBerechnen.setEnabled(false);
					
				}
			});
		}
		{
			JLabel lblNewLabel_36 = new JLabel("E17"); //$NON-NLS-1$
			lblNewLabel_36.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_36.setBorder(null);
			GridBagConstraints gbc_lblNewLabel_36 = new GridBagConstraints();
			gbc_lblNewLabel_36.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_36.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_36.gridx = 0;
			gbc_lblNewLabel_36.gridy = 13;
			this.add(lblNewLabel_36, gbc_lblNewLabel_36);
		}
		{
			E17_Value = new JTextField();
			E17_Value.setHorizontalAlignment(SwingConstants.CENTER);
			((AbstractDocument) E17_Value.getDocument())
					.setDocumentFilter(new IntegerDocumentFilter());
			{
				JLabel S_E17 = new JLabel("100");
				S_E17.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_S_E17 = new GridBagConstraints();
				gbc_S_E17.fill = GridBagConstraints.BOTH;
				gbc_S_E17.insets = new Insets(0, 0, 5, 5);
				gbc_S_E17.gridx = 1;
				gbc_S_E17.gridy = 13;
				add(S_E17, gbc_S_E17);
				containerLabel.put("E17", S_E17);
			}
			GridBagConstraints gbc_E17_Value = new GridBagConstraints();
			gbc_E17_Value.fill = GridBagConstraints.BOTH;
			gbc_E17_Value.insets = new Insets(0, 0, 5, 5);
			gbc_E17_Value.gridx = 2;
			gbc_E17_Value.gridy = 13;
			this.add(E17_Value, gbc_E17_Value);
			E17_Value.setColumns(10);
		}
		containerFields.put("E17", E17_Value);
		{
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.fill = GridBagConstraints.BOTH;
			gbc_label.insets = new Insets(0, 0, 0, 5);
			gbc_label.gridx = 0;
			gbc_label.gridy = 14;
			this.add(label, gbc_label);
		}
		{
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.fill = GridBagConstraints.BOTH;
			gbc_label.insets = new Insets(0, 0, 0, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 14;
			this.add(label, gbc_label);
		}
		{
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.fill = GridBagConstraints.BOTH;
			gbc_label.insets = new Insets(0, 0, 0, 5);
			gbc_label.gridx = 2;
			gbc_label.gridy = 14;
			this.add(label, gbc_label);
		}
		{
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.fill = GridBagConstraints.BOTH;
			gbc_label.insets = new Insets(0, 0, 0, 5);
			gbc_label.gridx = 5;
			gbc_label.gridy = 14;
			this.add(label, gbc_label);
		}
		{
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.fill = GridBagConstraints.BOTH;
			gbc_label.insets = new Insets(0, 0, 0, 5);
			gbc_label.gridx = 6;
			gbc_label.gridy = 14;
			this.add(label, gbc_label);
		}
		{
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.fill = GridBagConstraints.BOTH;
			gbc_label.insets = new Insets(0, 0, 0, 5);
			gbc_label.gridx = 7;
			gbc_label.gridy = 14;
			this.add(label, gbc_label);
		}
		{
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.fill = GridBagConstraints.BOTH;
			gbc_label.gridx = 8;
			gbc_label.gridy = 14;
			this.add(label, gbc_label);
		}
		{
		}
		{
		}
		{
		}
		{
		}
		{
		}
		{
		}
		{
		}
		{
		}
		{
		}
		{
		}
		{
		}
		{
		}
		{
		}
		{
		}
		{
		}
		{
		}

		for (Map.Entry<String, JTextField> entry : containerFields.entrySet()) {
			final JTextField bar = entry.getValue();
			bar.addFocusListener(new FocusListener() {

				String text = "";
				
				@Override
				public void focusLost(FocusEvent e) {
					if(bar.getText().equals(text)){
						ProductionOrder.this.main.getCancelButton().setEnabled(true);
						btnFertigungsauftrgeNeuBerechnen.setEnabled(false);
					}
				}

				@Override
				public void focusGained(FocusEvent e) {
					text = bar.getText();
					ProductionOrder.this.main.getCancelButton().setEnabled(false);
					btnFertigungsauftrgeNeuBerechnen.setEnabled(true);
				}
			});
		}
	}

	public List<ProductionPlanningResult> getChangedProductionPlaning() {

		for (ProductionPlanningResult p : data) {
			p.setQuantity(Integer.parseInt(containerLabel.get(p.getItemConfigId()).getText()));
		}

		return data;
	}

	public void setDataLabels(List<ProductionPlanningResult> data) {

		this.data = data;

		for (ProductionPlanningResult p : data) {
			containerLabel.get(p.getItemConfigId()).setText(String.valueOf(p.getQuantity()));
		}
	}

	public void setDataFields(Map<String, Integer> data) {

		containerFields.get("P1").setText(String.valueOf(data.get("P1"))); //$NON-NLS-1$
		containerFields.get("P2").setText(String.valueOf(data.get("P2"))); //$NON-NLS-1$
		containerFields.get("P3").setText(String.valueOf(data.get("P3"))); //$NON-NLS-1$
		containerFields.get("E51").setText(String.valueOf(data.get("E51"))); //$NON-NLS-1$
		containerFields.get("E56").setText(String.valueOf(data.get("E56"))); //$NON-NLS-1$
		containerFields.get("E31").setText(String.valueOf(data.get("E31"))); //$NON-NLS-1$
		containerFields.get("E50").setText(String.valueOf(data.get("E50"))); //$NON-NLS-1$
		containerFields.get("E55").setText(String.valueOf(data.get("E55"))); //$NON-NLS-1$
		containerFields.get("E30").setText(String.valueOf(data.get("E30"))); //$NON-NLS-1$
		containerFields.get("E4").setText(String.valueOf(data.get("E4"))); //$NON-NLS-1$
		containerFields.get("E5").setText(String.valueOf(data.get("E5"))); //$NON-NLS-1$
		containerFields.get("E6").setText(String.valueOf(data.get("E6"))); //$NON-NLS-1$
		containerFields.get("E10").setText(String.valueOf(data.get("E10"))); //$NON-NLS-1$
		containerFields.get("E11").setText(String.valueOf(data.get("E11"))); //$NON-NLS-1$
		containerFields.get("E12").setText(String.valueOf(data.get("E12"))); //$NON-NLS-1$
		containerFields.get("E49").setText(String.valueOf(data.get("E49"))); //$NON-NLS-1$
		containerFields.get("E54").setText(String.valueOf(data.get("E54"))); //$NON-NLS-1$
		containerFields.get("E29").setText(String.valueOf(data.get("E29"))); //$NON-NLS-1$
		containerFields.get("E7").setText(String.valueOf(data.get("E7"))); //$NON-NLS-1$
		containerFields.get("E8").setText(String.valueOf(data.get("E8"))); //$NON-NLS-1$
		containerFields.get("E9").setText(String.valueOf(data.get("E9"))); //$NON-NLS-1$
		containerFields.get("E13").setText(String.valueOf(data.get("E13"))); //$NON-NLS-1$
		containerFields.get("E14").setText(String.valueOf(data.get("E14"))); //$NON-NLS-1$
		containerFields.get("E15").setText(String.valueOf(data.get("E15"))); //$NON-NLS-1$
		containerFields.get("E18").setText(String.valueOf(data.get("E18"))); //$NON-NLS-1$
		containerFields.get("E19").setText(String.valueOf(data.get("E19"))); //$NON-NLS-1$
		containerFields.get("E20").setText(String.valueOf(data.get("E20"))); //$NON-NLS-1$
		containerFields.get("E26").setText(String.valueOf(data.get("E26"))); //$NON-NLS-1$
		containerFields.get("E16").setText(String.valueOf(data.get("E16"))); //$NON-NLS-1$
		containerFields.get("E17").setText(String.valueOf(data.get("E17"))); //$NON-NLS-1$}
	}
	
	public Map<String, Integer> getFieldsValues() {
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
		} catch(Exception e) {
			
		}
		
		return result;
	}
}
