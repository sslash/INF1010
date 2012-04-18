import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Oppgave2 extends JFrame{
	private JTextField inputField;
	private JButton sortButton;
	private JLabel outputField;	
	private JLabel timeField;
	private Controller controller;
	private JComboBox jComboBox;
	
	public Oppgave2 (String name) {
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(createPanel());
		this.pack();
		this.setVisible(true);
	}
	
	public void setController(Controller c ) {
		controller = c;
	}
	
	private JPanel createPanel() {
		// Create input field
		inputField = new JTextField(20);
		inputField.setText("Enter name of file");
		
		// Create button
		sortButton = new JButton("sort");
		sortButton.setPreferredSize(new Dimension(100,100));
		sortButton.addActionListener(new ButtonListener());
		
		// Create label
		outputField = new JLabel();
		outputField.setPreferredSize(new Dimension(500, 100));
		
		// create chooser
		jComboBox = new JComboBox(new String[] {"Bubble_Sorter", "Random_Sorter"});
		jComboBox.setSelectedIndex(0);
		jComboBox.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JComboBox b = (JComboBox) arg0.getSource();
				String classname = (String) b.getSelectedItem();
				Class c;
				try {
					c = Class.forName(classname);
					controller.setSorter( (Sorter) c.newInstance() );
					System.out.println("SAP: " + c.getName());
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
		});
		
		timeField = new JLabel();
		timeField.setPreferredSize(new Dimension(50, 100));
		
		JPanel topPanel = new JPanel();
		topPanel.add(inputField);
		topPanel.add(sortButton);
		topPanel.add(jComboBox);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS ) );
		mainPanel.add(topPanel);
		mainPanel.add(outputField);
		mainPanel.add(timeField);
		
		return mainPanel;		
	}
	
	public void setSortedText(String text) {
		outputField.setText(text);
	}
	
	public void setTimeText(String text) {
		timeField.setText(text);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if ( arg0.getSource() == sortButton ) {
				
				if ( errorHandle(inputField.getText() ) ) {
					Thread t = new Thread( new Runnable() {
						public void run() {
							controller.sortFile(inputField.getText());	
						}
					});
					t.start();
										
				}
				else{
					outputField.setText("Please write a filename!");
					outputField.setForeground(Color.red);
				}
			}
		}

		private boolean errorHandle(String text) {
			if ( text.equals("") )return false;
			// else if is binary
			return true;
		}
		
	}
	

}
