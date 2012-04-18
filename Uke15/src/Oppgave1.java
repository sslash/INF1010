import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Oppgave1 extends JFrame {
	JTextField textField;
	JButton button;
	JLabel resultLabel;

	public Oppgave1( String name ) {
		super(name);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = createPanel();
		setButtonListener();
		this.add(mainPanel);
		this.pack();
		this.setVisible(true);
	}
	
	private JPanel createPanel() {
		JPanel mainPanel = new JPanel();
		
		// create field
		textField = new JTextField(20);
		
		// Create button
		button = new JButton("Convert");
		button.setPreferredSize( new Dimension(80,80));
		button.setForeground(Color.GREEN);
		
		// create label
		resultLabel = new JLabel("Result");
		resultLabel.setPreferredSize( new Dimension(100,20));
		
		mainPanel.add(textField);
		mainPanel.add(button);
		mainPanel.add(resultLabel);
		
		return mainPanel;
	}
	
	private void setButtonListener() {
		button.addActionListener(new ButtonListener());
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			// button is pressed
			Thread t = new Thread( new Runnable() {
				public void run() {
					String s = textField.getText();
					
					int val = 0;
					int c = 0;
					
					for ( int i = s.length()-1; i >= 0; i-- )
						if ( s.charAt(c++) == '1')
							val += Math.pow(2, i);
						
					
					resultLabel.setText( val + "");
				}
			});
			
			t.start();
			
		}
		
	}
}
