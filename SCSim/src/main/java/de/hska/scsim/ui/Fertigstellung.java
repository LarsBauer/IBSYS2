package de.hska.scsim.ui;

import de.hska.scsim.domain.output.CapacityPlanningResult;
import de.hska.scsim.domain.output.PurchasePlanningResult;
import de.hska.scsim.xml.XmlGenerator;
import de.hska.scsim.domain.output.ProductionPlanningResult;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JTextArea;

import java.awt.Insets;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Fertigstellung extends JPanel {

	private SpeichernUnterClass suc;

	/**
	 * Create the dialog.
	 */
	public Fertigstellung() {

		suc = new SpeichernUnterClass();

		this.setBackground(Color.WHITE);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 372, 372, 0 };
		gbl_panel.rowHeights = new int[] { 128, 128, 50, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		this.setLayout(gbl_panel);
		{
			JTextArea txtrHerzlichWillkommenDas = new JTextArea();
			txtrHerzlichWillkommenDas.setWrapStyleWord(true);
			txtrHerzlichWillkommenDas.setBorder(new EmptyBorder(30, 30, 0, 30));
			txtrHerzlichWillkommenDas.setLineWrap(true);
			txtrHerzlichWillkommenDas.setText(Messages.getString("Fertigstellung.1"));
			GridBagConstraints gbc_txtrHerzlichWillkommenDas = new GridBagConstraints();
			gbc_txtrHerzlichWillkommenDas.gridwidth = 2;
			gbc_txtrHerzlichWillkommenDas.fill = GridBagConstraints.BOTH;
			gbc_txtrHerzlichWillkommenDas.insets = new Insets(0, 0, 5, 0);
			gbc_txtrHerzlichWillkommenDas.gridx = 0;
			gbc_txtrHerzlichWillkommenDas.gridy = 0;
			this.add(txtrHerzlichWillkommenDas, gbc_txtrHerzlichWillkommenDas);
		}
	}

	public SpeichernUnterClass getSuc() {
		return suc;
	}

	public class SpeichernUnterClass extends JFrame {

		public SpeichernUnterClass() {

		}

		boolean saveAs(String pfad, MainGUI main, List<ProductionPlanningResult> production, List<CapacityPlanningResult> capacity, 
				List<PurchasePlanningResult> purchase, Map<String, Integer> planedSales, XmlGenerator xmlGenerator) {

			JFileChooser chooser;
			if (pfad == null)
				pfad = System.getProperty("user.home");
			File file = new File(pfad.trim());

			chooser = new JFileChooser(pfad);
			chooser.setDialogType(JFileChooser.SAVE_DIALOG);
			FileNameExtensionFilter plainFilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
			chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
			chooser.setFileFilter(plainFilter);
			chooser.setDialogTitle(Messages.getString("Fertigstellung.2"));
			chooser.setVisible(true);

			int result = chooser.showSaveDialog(this);

			if (result == JFileChooser.APPROVE_OPTION) {

				pfad = chooser.getSelectedFile().toString();
				file = new File(pfad);
				String path = chooser.getSelectedFile().getPath();
				
				if (plainFilter.accept(file)) {
                                    try {
                                        xmlGenerator.generateXml(production, capacity, purchase, planedSales, path);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Fertigstellung.class.getName()).log(Level.SEVERE, null, ex);
                                    }
					main.dispose();
					System.exit(0);
				} else {
					path = path + ".xml";
					File pdf = new File(path);
                                    try {
                                        xmlGenerator.generateXml(production, capacity, purchase, planedSales, path);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Fertigstellung.class.getName()).log(Level.SEVERE, null, ex);
                                    }
					main.dispose();
					System.exit(0);
				}
				chooser.setVisible(false);
				return true;
			}
			chooser.setVisible(false);
			return false;
		}
	}
}
