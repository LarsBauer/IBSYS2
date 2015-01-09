package de.hska.scsim.ui;

import de.hska.scsim.util.Messages;
import de.hska.scsim.domain.output.PurchasePlanningResult;
import de.hska.scsim.util.IntegerDocumentFilter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;


public class Order extends JPanel {

	private JPanel content;
	private List<PurchasePlanningResult> data;
	private JLabel lblNewLabel22;

	private Map<JComboBox,JTextField> LabeltoField = new HashMap<>();
	private Map<JTextField,JComboBox> FieldtoLabel = new HashMap<>();
	private ArrayList<JTextField> textFields = new ArrayList<>();
	private Map<String,JComboBox> comboBoxesHash = new HashMap<>();
	private Map<String,JTextField> textFieldsHash = new HashMap<>();
	
	/**
	 * Create the dialog.
	 */
	public Order() {

		this.setBorder(new EmptyBorder(10, 0, 10, 30));
		this.setFont(new Font("Arial", Font.PLAIN, 11));
		this.setAutoscrolls(true);
		this.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		this.setAlignmentX(Component.RIGHT_ALIGNMENT);
		this.setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));

		content = new JPanel();
		content.setBackground(Color.WHITE);
		this.add(content, BorderLayout.CENTER);
		content.setLayout(new GridLayout(15, 13, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel = new JLabel(Messages.getString("order.discount"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);

		lblNewLabel22 = new JLabel();
		lblNewLabel22.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel22);

	}

	public void setData(List<PurchasePlanningResult> data) {

		this.data = data;

		content.removeAll();

		String[] StringsWith = {
				Messages.getString("order.standard"), Messages.getString("order.fast"), "-" }; //$NON-NLS-2$
		String[] StringsWithout = {
				Messages.getString("order.standard"), Messages.getString("order.fast") }; //$NON-NLS-2$

		int sum = 0;

		for (int i = 0; i < data.size(); ++i) {
			JLabel lblNewLabel_7;
			final JTextField textField;
			final JComboBox comboBox;
			{
				lblNewLabel_7 = new JLabel(data.get(i).getItemConfigId());
				lblNewLabel_7.setBorder(new EmptyBorder(0, 28, 0, 0));
				content.add(lblNewLabel_7);
			}
			{
				textField = new JTextField();
				((AbstractDocument) textField.getDocument())
						.setDocumentFilter(new IntegerDocumentFilter());
				textField.setText(String.valueOf(data.get(i).getQuantity()));
				textField.setHorizontalAlignment(SwingConstants.CENTER);
				content.add(textField);
				textField.setColumns(10);
				textFields.add(textField);
				textFieldsHash.put(data.get(i).getItemConfigId(), textField);
				textField.addKeyListener(new KeyListener() {

					@Override
					public void keyTyped(KeyEvent arg0) {

						if (textField.getText().length() > 0) {
							if (textField.getText().charAt(0) == '0') {
								textField.setText(textField.getText().substring(1));
							}
						}
						
					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						lblNewLabel22.setText(Messages.getString("order.totalcosts") + summeBerechnen());
						if(textField.getText().equals("0")) {
							FieldtoLabel.get(textField).removeItemAt(0);
							FieldtoLabel.get(textField).removeItemAt(0);
							FieldtoLabel.get(textField).setSelectedIndex(0);

						}
						else if(!textField.getText().equals("0") && (FieldtoLabel.get(textField).getItemCount() == 1)) {
							FieldtoLabel.get(textField).removeItemAt(0);
							FieldtoLabel.get(textField).addItem(makeObj(Messages.getString("order.standard")));
							FieldtoLabel.get(textField).addItem(makeObj(Messages.getString("order.fast")));
							FieldtoLabel.get(textField).addItem(makeObj("-"));
							FieldtoLabel.get(textField).setSelectedIndex(0);					
						}
						
						if(FieldtoLabel.get(textField).getSelectedIndex() == 2 && !textField.getText().equals("0")) {
							FieldtoLabel.get(textField).setSelectedIndex(0);
						}
					}

					@Override
					public void keyPressed(KeyEvent arg0) {

					}
				});
				textField.addFocusListener(new FocusListener() {

					@Override
					public void focusLost(FocusEvent arg0) {
						if (textField.getText().equals("")) {
							textField.setText("0");
						}
					}

					@Override
					public void focusGained(FocusEvent arg0) {

					}
				});
			}
			{

				comboBox = new JComboBox(StringsWith);
				comboBoxesHash.put(data.get(i).getItemConfigId(), comboBox);
				content.add(comboBox);
				if (data.get(i).getPurchaseMode() == 5) {
					comboBox.setSelectedItem(Messages.getString("order.standard"));
				} else if (data.get(i).getPurchaseMode() == 4) {
					comboBox.setSelectedItem(Messages.getString("order.fast"));
				}
				if (data.get(i).getQuantity() == 0) {
					comboBox.setSelectedItem("-");
				}
				
				if(data.get(i).getQuantity() == 0) {
					comboBox.removeItemAt(0);
					comboBox.removeItemAt(0);
				}
				
				comboBox.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(comboBox.getSelectedIndex() == 2) {
							LabeltoField.get(comboBox).setText("0");
						}
						lblNewLabel22.setText(Messages.getString("order.totalcosts") + summeBerechnen());
					}
				});
			}
			{
				JLabel rabatt = new JLabel(Messages.getString("order.discountlabel") + data.get(i).getDiscountQuantity());
				content.add(rabatt);
			}
			LabeltoField.put(comboBox, textField);
			FieldtoLabel.put(textField, comboBox);
		}

		lblNewLabel22.setText("Gesamt-Bestellkosten: " + summeBerechnen());
	}

	public List<PurchasePlanningResult> getData() {
	
		for(int i = 0; i < data.size(); ++i) {
			data.get(i).setQuantity(Integer.parseInt(textFieldsHash.get(data.get(i).getItemConfigId()).getText()));
			
			JComboBox box = comboBoxesHash.get(data.get(i).getItemConfigId());
			
			if(box.getItemAt(box.getSelectedIndex()) == null) {
				
			}
			else if(box.getItemAt(box.getSelectedIndex()).equals("normal")) {
				data.get(i).setPurchaseMode(5);
			}
			else if(box.getItemAt(box.getSelectedIndex()).equals("schnell")) {
				data.get(i).setPurchaseMode(4);
			}
			else if(box.getItemAt(box.getSelectedIndex()).equals("-")) {
				data.get(i).setPurchaseMode(0);
			}
		}
		
		return data;
	}

        //TODO
	public Integer summeBerechnen() {

		int sum = 0;

		for(int i = 0; i < data.size(); ++i) {
                        String input = textFieldsHash.get(data.get(i).getItemConfigId()).getText();
			if(input.isEmpty()) {
                            data.get(i).setQuantity(0);
                        } else {
                            data.get(i).setQuantity(Integer.parseInt(input));
                        }
			
			JComboBox box = comboBoxesHash.get(data.get(i).getItemConfigId());
			
			if(box.getItemAt(box.getSelectedIndex()) == null) {
				
			}
			else if(box.getItemAt(box.getSelectedIndex()).equals("normal")) {
				data.get(i).setPurchaseMode(de.hska.scsim.util.Constants.STANDARD_DELIVERY_ID);
			}
			else if(box.getItemAt(box.getSelectedIndex()).equals("schnell")) {
				data.get(i).setPurchaseMode(de.hska.scsim.util.Constants.FAST_DELIVERY_ID);
			}
			else if(box.getItemAt(box.getSelectedIndex()).equals("-")) {
				data.get(i).setPurchaseMode(0);
			}
		}
		
		for(int i = 0; i < data.size(); ++i) {
			sum += data.get(i).getPositionCosts();
		}

		return sum;
	}

	private Object makeObj(final String item) {
		return new Object() {
                        @Override
			public String toString() {
				return item;
			}
		};
	}
}
