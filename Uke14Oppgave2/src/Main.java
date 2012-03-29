import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Main {
	JFrame frame;
	JPanel buttonPanel;
	JPanel topPanel;
	JButton addButton, subButton, divButton, mulButton, clearButton;
	JPanel inputPanel;
	JPanel resultPanel;
	JLabel resLabel;
	JLabel topLabel;
	JLabel resAnswLabel;
	JTextField text1;
	JTextField text2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		createbuttonPanel();
		createInputPanel();
		createResPanel();
		createTopLabelPanel();		
		createFrame();
	}
	
	private void createTopLabelPanel() {
		topLabel = new JLabel("Super Calculator"); 
		topPanel = new JPanel();
		topPanel.add(topLabel);		
	}

	private void createResPanel() {
		resLabel = new JLabel("Result:");
		resAnswLabel = new JLabel();
		
		resultPanel = new JPanel();
		resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
		
		resultPanel.add(resLabel);
		resultPanel.add(resAnswLabel);
	}

	private void createInputPanel() {
		text1 = new JTextField();
		text2 = new JTextField();		
		inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		inputPanel.add(text1);
		inputPanel.add(text2);
	}

	private void createbuttonPanel() {
		addButton = new JButton ("+");
		subButton = new JButton("-");
		divButton = new JButton("/");
		mulButton = new JButton("*");
		clearButton = new JButton ("clear");
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(addButton);
		buttonPanel.add(subButton);
		buttonPanel.add(divButton);
		buttonPanel.add(mulButton);
		buttonPanel.add(clearButton);
		
		setButtonListeners();
	}

	private void setButtonListeners() {
		addButton.addActionListener(new MyButtonListener());
		subButton.addActionListener(new MyButtonListener() );
		mulButton.addActionListener(new MyButtonListener());
		divButton.addActionListener(new MyButtonListener() );
		clearButton.addActionListener(new MyButtonListener() );
		
	}

	private void createFrame() {
		frame = new JFrame();		
		frame.getContentPane().add(BorderLayout.NORTH, topPanel);
		frame.getContentPane().add(BorderLayout.CENTER, inputPanel);
		frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
		frame.getContentPane().add(BorderLayout.EAST, resultPanel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	class MyButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton buttonPressed = (JButton) e.getSource();
			int a, b;
			
			try {
			 a = Integer.parseInt(text1.getText());
			}catch ( NumberFormatException n ){
				text1.setText("Must be int");
				text1.setForeground(Color.red);
				return;
			}
			try {
			 b = Integer.parseInt(text2.getText());			
			}catch(NumberFormatException n ){
				text2.setText("Must be int");
				text2.setForeground(Color.red);
				return;
			}
			
			
			if ( buttonPressed == addButton ) {
				resAnswLabel.setText((a + b) + "");
			} else if ( buttonPressed == subButton ) {
				resAnswLabel.setText((a - b) + "");
			} else if ( buttonPressed == mulButton) {
				resAnswLabel.setText((a * b) + "");
			} else if ( buttonPressed == divButton) {
				resAnswLabel.setText((a / b) + "");
			} else if ( buttonPressed == clearButton) {
				resAnswLabel.setText("");
				text1.setText("");
				text2.setText("");
			}
			
		}		
	}
}
