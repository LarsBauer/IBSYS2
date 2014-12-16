package de.hska.scsim.ui;

import de.hska.scsim.util.Messages;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Welcome extends JPanel {

    private JTextField textField;

    private OeffnenDialogClass odc;
    private File file;
    static String path = "";

    /**
     * Create the dialog.
     */
    public Welcome() {

        file = null;
        odc = new OeffnenDialogClass();

        this.setBackground(Color.WHITE);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{30, 0, 360, 360, 0};
        gbl_panel.rowHeights = new int[]{128, 128, 50, 0};
        gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        this.setLayout(gbl_panel);
        {
            JTextArea txtrHerzlichWillkommenDas = new JTextArea();
            txtrHerzlichWillkommenDas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            txtrHerzlichWillkommenDas.setEditable(false);
            txtrHerzlichWillkommenDas.setBorder(new EmptyBorder(30, 30, 0, 30));
            txtrHerzlichWillkommenDas.setLineWrap(true);
            txtrHerzlichWillkommenDas.setText(Messages.getString("Willkommen.1"));
            GridBagConstraints gbc_txtrHerzlichWillkommenDas = new GridBagConstraints();
            gbc_txtrHerzlichWillkommenDas.gridwidth = 3;
            gbc_txtrHerzlichWillkommenDas.fill = GridBagConstraints.BOTH;
            gbc_txtrHerzlichWillkommenDas.insets = new Insets(0, 0, 5, 0);
            gbc_txtrHerzlichWillkommenDas.gridx = 0;
            gbc_txtrHerzlichWillkommenDas.gridy = 0;
            this.add(txtrHerzlichWillkommenDas, gbc_txtrHerzlichWillkommenDas);
        }
        {
            textField = new JTextField();
            textField.setMinimumSize(new Dimension(330, 20));
            textField.setPreferredSize(new Dimension(300, 20));
            GridBagConstraints gbc_textField = new GridBagConstraints();
            gbc_textField.fill = GridBagConstraints.HORIZONTAL;
            gbc_textField.anchor = GridBagConstraints.EAST;
            gbc_textField.insets = new Insets(0, 0, 5, 5);
            gbc_textField.gridx = 1;
            gbc_textField.gridy = 1;
            this.add(textField, gbc_textField);
        }
        {
            JButton btnNewButton = new JButton(Messages.getString("Willkommen.2"));
            GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
            gbc_btnNewButton.anchor = GridBagConstraints.WEST;
            gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
            gbc_btnNewButton.gridx = 2;
            gbc_btnNewButton.gridy = 1;
            this.add(btnNewButton, gbc_btnNewButton);

            btnNewButton.addMouseListener(new MouseListener() {

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    file = odc.oeffnen();
                }
            });

        }

    }

    public JTextField getTextField() {
        return textField;
    }

    
    public class OeffnenDialogClass {

        private File f;

        public OeffnenDialogClass() {
        }

        public File oeffnen() {
            final JFileChooser chooser = new JFileChooser(Messages.getString("Willkommen.3"));
            chooser.setDialogType(JFileChooser.OPEN_DIALOG);
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
            chooser.setFileFilter(xmlfilter);
            chooser.setAcceptAllFileFilterUsed(false);
            final File file = new File(System.getProperty("user.dir"));  //$NON-NLS-1$

            chooser.setCurrentDirectory(file);

            chooser.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                    if (e.getPropertyName().equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
                            || e.getPropertyName().equals(JFileChooser.DIRECTORY_CHANGED_PROPERTY)) {
                        f = (File) e.getNewValue();
                        if (f != null) {
                            textField.setText(f.getAbsolutePath());
                        }
                    }
                }
            });

            chooser.setVisible(true);
            final int result = chooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File inputVerzFile = chooser.getSelectedFile();
                String inputVerzStr = inputVerzFile.getPath();
            }
            chooser.setVisible(false);
            return f;
        }
    }
}
