package de.hska.scsim.ui;

import de.hska.scsim.util.Messages;
import de.hska.scsim.util.IntegerDocumentFilter;
import de.hska.scsim.domain.output.ProductionPlanningResult;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.TransferHandler;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.AbstractDocument;

public class Prioritization extends JPanel {

    private JButton btnNewButton_1;
    private JList list;
    private static DefaultListModel lm1 = new DefaultListModel();
    private JTextField textField;
    private JTextField textField_1;

    private static List<ProductionPlanningResult> dataSaved = new ArrayList<>();

    private int number;
    private int value1 = 0;
    private int value2 = 0;
    private JLabel lblNewLabel;

    /**
     * Create the dialog.
     */
    public Prioritization() {

        this.setBorder(new EmptyBorder(50, 100, 15, 100));
        this.setFont(new Font("Arial", Font.PLAIN, 11)); //$NON-NLS-1$
        this.setAutoscrolls(true);
        this.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        this.setAlignmentX(Component.RIGHT_ALIGNMENT);
        this.setBackground(Color.WHITE);

        String[] columnNames = {Messages.getString("Nachplanung.1"), Messages.getString("Nachplanung.2"), Messages.getString("Nachplanung.3")}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

        this.setOpaque(true);

        lm1 = new DefaultListModel();

        list = new JList(lm1);
        list.setDragEnabled(true);
        list.setDropMode(DropMode.INSERT);
        list.setVisibleRowCount(10);
        list.setTransferHandler(new ListMoveTransferHandler());
        list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {

                    if (list.getSelectedValue() == null) {
                        return;
                    }

                    String raw = list.getSelectedValue().toString();
                    String value = raw.substring(raw.lastIndexOf(":") + 2); //$NON-NLS-1$

                    number = Integer.parseInt(value);

                    if (number % 2 != 0) {
                        if (number == 1) {
                            value1 = 1;
                        } else {
                            int n = number - 1;
                            value1 = n / 2 + 1;
                            value2 = n / 2;
                        }
                    } else {
                        value1 = number / 2;
                        value2 = number / 2;
                    }

                    textField_1.setText(String.valueOf(value1));
                    textField.setText(String.valueOf(value2));
                }
            }
        });
        setLayout(new GridLayout(0, 2, 0, 0));

        JScrollPane listScrollPane = new JScrollPane(list);
        listScrollPane.setAutoscrolls(true);
        add(listScrollPane);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(0, 50, 0, 0));
        panel.setBackground(Color.WHITE);
        add(panel);
        panel.add(new JLabel("Platzhalter"));
//        GridBagLayout gbl_panel = new GridBagLayout();
//        gbl_panel.columnWidths = new int[]{62, 62, 0};
//        gbl_panel.rowHeights = new int[]{78, 78, 78, 0};
//        gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
//        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
//        panel.setLayout(gbl_panel);
//
//        JButton btnNewButton = new JButton(Messages.getString("Nachplanung.5")); //$NON-NLS-1$
//        btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
//        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
//        gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
//        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
//        gbc_btnNewButton.gridx = 0;
//        gbc_btnNewButton.gridy = 0;
//        panel.add(btnNewButton, gbc_btnNewButton);
//        btnNewButton.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//
//                if (list.isSelectionEmpty()) {
//                    JOptionPane.showOptionDialog(Prioritization.this,
//                            "Wählen Sie bitte einen Auftrag aus", "Keine Auswahl", //$NON-NLS-1$ //$NON-NLS-2$
//                            JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
//                } else if ((Integer.parseInt(textField.getText()) + Integer.parseInt(textField_1.getText())) != number) {
//                    JOptionPane
//                            .showOptionDialog(Prioritization.this,
//                                    "Verändern Sie bitte die Werte so dass die Summe der Werte mit dem Original Wert �bereinstimmt", "Werte Unterschiedlich", //$NON-NLS-1$ //$NON-NLS-2$
//                                    JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
//                } else {
//
//                    int index = list.getSelectedIndex();
//                    dataSaved.get(index).setQuantity(value1);
//                    ProductionPlanningResult newProd = new ProductionPlanningResult(dataSaved.get(index)
//                            .getItemConfigId(), value2);
//                    dataSaved.add(index + 1, newProd);
//                    rebuildListFromSplit();
//                }
//
//            }
//        });
//
//        textField_1 = new JTextField();
//        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
//        textField_1.setText("0"); //$NON-NLS-1$
//        ((AbstractDocument) textField_1.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
//
//        textField = new JTextField();
//        textField.setHorizontalAlignment(SwingConstants.CENTER);
//        textField.setText("0"); //$NON-NLS-1$
//        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
//
//        btnNewButton_1 = new JButton(Messages.getString("Nachplanung.8")); //$NON-NLS-1$
//        btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
//        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
//        gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
//        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
//        gbc_btnNewButton_1.gridx = 1;
//        gbc_btnNewButton_1.gridy = 0;
//        panel.add(btnNewButton_1, gbc_btnNewButton_1);
//        btnNewButton_1.addActionListener(new ActionListener() {
//
//            @SuppressWarnings({"unchecked", "rawtypes"})
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                if (list.getSelectedValuesList().size() > 1) {
//
//                    List liste = list.getSelectedValuesList();
//
//                    String savedID = ""; //$NON-NLS-1$
//                    int sum = 0;
//
//                    for (int i = 0; i < liste.size(); ++i) {
//                        String raw = liste.get(i).toString();
//                        String ID = raw.substring(raw.indexOf("-") + 1, raw.lastIndexOf(":")); //$NON-NLS-1$ //$NON-NLS-2$
//                        ID = ID.replace(" ", ""); //$NON-NLS-1$ //$NON-NLS-2$
//                        if (i > 0 && savedID.equals(ID) == false) {
//                            JOptionPane.showOptionDialog(Prioritization.this,
//                                    Messages.getString("Nachplanung.11"), Messages.getString("Nachplanung.12"), //$NON-NLS-1$ //$NON-NLS-2$
//                                    JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
//                            return;
//                        }
//                        savedID = ID;
//                    }
//
//                    for (int i = 0; i < liste.size(); ++i) {
//                        String raw = liste.get(i).toString();
//                        int value = Integer.parseInt(raw.substring(raw.lastIndexOf(":") + 2)); //$NON-NLS-1$
//                        sum += value;
//                    }
//
//                    ArrayList<Integer> positions = new ArrayList<>();
//                    List selectedValues = list.getSelectedValuesList();
//
//                    List<ProductionPlanningResult> sortedList = new ArrayList<>();
//
//                    int start = 0;
//
//                    for (int i = 0; i < selectedValues.size(); ++i) {
//                        String raw = selectedValues.get(i).toString();
//                        String cutted = raw.substring(raw.indexOf(":") + 2, raw.lastIndexOf("-") - 1); //$NON-NLS-1$ //$NON-NLS-2$
//                        cutted = cutted.replace(" ", ""); //$NON-NLS-1$ //$NON-NLS-2$
//                        positions.add(Integer.parseInt(cutted) - 1);
//                        if (i == 0) {
//                            start += Integer.parseInt(cutted) - 1;
//                        }
//                    }
//
//                    for (int i = 0; i < positions.size(); ++i) {
//                        System.out.println("position: " + i); //$NON-NLS-1$
//                        dataSaved.remove(positions.get(i) - i);
//                    }
//
//                    ProductionPlanningResult merged = new ProductionPlanningResult(savedID, sum);
//                    dataSaved.add(start, merged);
//
//                    for (ProductionPlanningResult p : dataSaved) {
//                        System.out.println(p.getItemConfigId());
//                    }
//
//                    lm1.removeAllElements();
//
//                    for (int i = 0; i < dataSaved.size(); ++i) {
//                        lm1.addElement("Pos: " + (i + 1) + " - " + dataSaved.get(i).getItemConfigId() + " : " //$NON-NLS-1$ //$NON-NLS-3$
//                                + dataSaved.get(i).getQuantity());
//                    }
//
//                } else {
//                    JOptionPane
//                            .showOptionDialog(Prioritization.this,
//                                    Messages.getString("Nachplanung.9"), Messages.getString("Nachplanung.10"), //$NON-NLS-1$ //$NON-NLS-2$
//                                    JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
//                }
//            }
//        });
//        GridBagConstraints gbc_textField = new GridBagConstraints();
//        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
//        gbc_textField.insets = new Insets(0, 0, 5, 5);
//        gbc_textField.gridx = 0;
//        gbc_textField.gridy = 1;
//        panel.add(textField, gbc_textField);
//        textField.setColumns(10);
//
//        lblNewLabel = new JLabel(""); //$NON-NLS-1$
//        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
//        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
//        gbc_lblNewLabel.gridx = 1;
//        gbc_lblNewLabel.gridy = 1;
//        panel.add(lblNewLabel, gbc_lblNewLabel);
//        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
//        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
//        gbc_textField_1.insets = new Insets(0, 0, 0, 5);
//        gbc_textField_1.gridx = 0;
//        gbc_textField_1.gridy = 2;
//        panel.add(textField_1, gbc_textField_1);
//        textField_1.setColumns(10);

    }

    public List<ProductionPlanningResult> getData() {
        return dataSaved;
    }

    @SuppressWarnings("unchecked")
    public void setData(List<ProductionPlanningResult> data) {

        lm1.removeAllElements();

        this.dataSaved = data;

        for (int i = 0; i < data.size(); ++i) {
            lm1.addElement("Pos: " + (i + 1) + " - " + data.get(i).getItemConfigId() + " : " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    + data.get(i).getQuantity());
        }
    }

    @SuppressWarnings("unchecked")
    public static void rebuildListFromDrop() {

        List<ProductionPlanningResult> sortedList = new ArrayList<>();

        for (int i = 0; i < lm1.size(); ++i) {
            String raw = lm1.getElementAt(i).toString();
            String cutted = raw.substring(raw.indexOf("-") + 1, raw.lastIndexOf(":")); //$NON-NLS-1$ //$NON-NLS-2$
            cutted = cutted.replace(" ", ""); //$NON-NLS-1$ //$NON-NLS-2$

            sortedList.add(new ProductionPlanningResult(cutted, Integer.parseInt(raw.substring(raw
                    .lastIndexOf(":") + 2)))); //$NON-NLS-1$
        }

        dataSaved = sortedList;

        lm1.removeAllElements();

        for (int i = 0; i < dataSaved.size(); ++i) {
            lm1.addElement("Pos: " + (i + 1) + " - " + dataSaved.get(i).getItemConfigId() + " : " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    + dataSaved.get(i).getQuantity());
        }
    }

    @SuppressWarnings("unchecked")
    public void rebuildListFromSplit() {

        List<ProductionPlanningResult> sortedList = new ArrayList<>();

        for (int i = 0; i < dataSaved.size(); ++i) {
            sortedList.add(new ProductionPlanningResult(dataSaved.get(i).getItemConfigId(), dataSaved.get(i)
                    .getQuantity()));
        }

        dataSaved = sortedList;

        lm1.removeAllElements();

        for (int i = 0; i < dataSaved.size(); ++i) {
            lm1.addElement("Pos: " + (i + 1) + " - " + dataSaved.get(i).getItemConfigId() + " : " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    + dataSaved.get(i).getQuantity());
        }
    }

    /**
     * Model bound data flavor.
     *
     * @author Sebastian Haufe
     */
    static class ListMoveDataFlavor extends DataFlavor {

        private final DefaultListModel model;

        public ListMoveDataFlavor(DefaultListModel model) {
            super(ListMoveTransferData.class, "List Data"); //$NON-NLS-1$
            this.model = model;
        }

        public DefaultListModel getModel() {
            return model;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = super.hashCode();
            result = prime * result + ((model == null) ? 0 : model.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ListMoveDataFlavor other = (ListMoveDataFlavor) obj;
            return Objects.equals(this.model, other.model);
        }

        @Override
        public boolean equals(DataFlavor that) {
            if (this == that) {
                return true;
            }
            if (!super.equals(that) || getClass() != that.getClass()) {
                return false;
            }
            return match(model, that);
        }

        /**
         * Tests whether the given data flavor is a {@link ListMoveDataFlavor}
         * and matches the given model.
         *
         * @param model the model
         * @param flavor the flavor
         * @return {@code true} if matches
         */
        public static boolean match(DefaultListModel model, DataFlavor flavor) {
            return flavor instanceof ListMoveDataFlavor && ((ListMoveDataFlavor) flavor).getModel() == model;
        }
    }

    /**
     * Model bound and index based transfer data.
     *
     * @author Sebastian Haufe
     */
    private static class ListMoveTransferData {

        private final DefaultListModel model;
        private final int[] indices;

        ListMoveTransferData(DefaultListModel model, int[] indices) {
            this.model = model;
            this.indices = indices;
        }

        int[] getIndices() {
            return indices;
        }

        public DefaultListModel getModel() {
            return model;
        }
    }

    /**
     * Model bound transferable implementation.
     *
     * @author Sebastian Haufe
     */
    static class ListMoveTransferable implements Transferable {

        private final ListMoveTransferData data;

        public ListMoveTransferable(ListMoveTransferData data) {
            this.data = data;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{new ListMoveDataFlavor(data.getModel())};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return ListMoveDataFlavor.match(data.getModel(), flavor);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
            if (!isDataFlavorSupported(flavor)) {
                throw new UnsupportedFlavorException(flavor);
            }
            return data;
        }
    }

    /**
     * List transfer handler.
     *
     * @author Sebastian Haufe
     */
    static class ListMoveTransferHandler extends TransferHandler {

        /**
         * Serial version UID
         */
        private static final long serialVersionUID = 6703461043403098490L;

        @Override
        public int getSourceActions(JComponent c) {
            final JList list = (JList) c;
            return list.getModel() instanceof DefaultListModel ? MOVE : NONE;
        }

        @Override
        public boolean canImport(JComponent comp, DataFlavor[] transferFlavors) {
            if (!(comp instanceof JList) || !(((JList) comp).getModel() instanceof DefaultListModel)) {
                return false;
            }

            final DefaultListModel model = (DefaultListModel) ((JList) comp).getModel();
            for (DataFlavor f : transferFlavors) {
                if (ListMoveDataFlavor.match(model, f)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            final JList list = (JList) c;
            final int[] selectedIndices = list.getSelectedIndices();
            return new ListMoveTransferable(new ListMoveTransferData((DefaultListModel) list.getModel(),
                    selectedIndices));
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport info) {
            final Component comp = info.getComponent();
            if (!info.isDrop() || !(comp instanceof JList)) {
                return false;
            }
            final JList list = (JList) comp;
            final ListModel lm = list.getModel();
            if (!(lm instanceof DefaultListModel)) {
                return false;
            }

            final DefaultListModel listModel = (DefaultListModel) lm;
            final DataFlavor flavor = new ListMoveDataFlavor(listModel);
            if (!info.isDataFlavorSupported(flavor)) {
                return false;
            }
            final Transferable transferable = info.getTransferable();
            try {
                final ListMoveTransferData data = (ListMoveTransferData) transferable.getTransferData(flavor);

                // get the initial insertion index
                final JList.DropLocation dropLocation = list.getDropLocation();
                int insertAt = dropLocation.getIndex();

                // get the indices sorted (we use them in reverse order, below)
                final int[] indices = data.getIndices();
                Arrays.sort(indices);

                // remove old elements from model, store them on stack
                final Stack<Object> elements = new Stack<>();
                int shift = 0;
                for (int i = indices.length - 1; i >= 0; i--) {
                    final int index = indices[i];
                    if (index < insertAt) {
                        shift--;
                    }
                    elements.push(listModel.remove(index));
                }
                insertAt += shift;

                // insert stored elements from stack to model
                final ListSelectionModel sm = list.getSelectionModel();
                try {
                    sm.setValueIsAdjusting(true);
                    sm.clearSelection();
                    final int anchor = insertAt;
                    while (!elements.isEmpty()) {
                        listModel.insertElementAt(elements.pop(), insertAt);
                        sm.addSelectionInterval(insertAt, insertAt++);
                    }
                    final int lead = insertAt - 1;
                    if (!sm.isSelectionEmpty()) {
                        sm.setAnchorSelectionIndex(anchor);
                        sm.setLeadSelectionIndex(lead);
                    }
                } finally {
                    sm.setValueIsAdjusting(false);
                }
                rebuildListFromDrop();
                return true;
            } catch (UnsupportedFlavorException | IOException ex) {
                return false;
            }
        }
    }
}
