import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	private Hatch prevHatch = null;
	private Hatch currHatch = null;
	private JFrame frame = null;
	boolean canPress = false;
	int width = 4;
	int tries = 0;
	int hatchesLeft = (width*width)/2;
	JLabel label = null;

	public Main() {
		initFrame();
	}
	
	private void initFrame() {
		createFrame();
		createPanels();
		createWinLabel();		
		
		// Let's roll
		frame.setVisible(true);		
	}
	
	
	private void createFrame(){
		frame = new JFrame();
		frame.setBackground(Color.darkGray);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(900,700);
		
		// For removing hatches
		frame.getContentPane().addMouseListener(new MyMouseListener());		
	}
	
	private void createPanels() {
		JPanel panels[] = new JPanel[width];		
		Integer values [] = shuffleArr();

		for (int i = 0; i < width; i++) {

			// Create panel
			panels[i] = new JPanel();
			panels[i].setLayout(new BoxLayout (panels[i], BoxLayout.X_AXIS));

			// Add buttons to the panel
			for (int y = 0; y < width; y++) {
				Font bigFont = new Font("serif", Font.BOLD, 28);
				
				Hatch b = new Hatch(values[i * width + y]);
				
				b.setFont(bigFont);

				b.setBackground(Color.GREEN);
				b.setMargin(new Insets(50, 50, 50, 50));
				panels[i].add(b);

				// set action listener
				b.addActionListener(new ButtonListener());

			}
			frame.getContentPane().add(panels[i]);
		}
		
	}
	
	private void createWinLabel() {
		label = new JLabel();
		Font bigFont = new Font("serif", Font.BOLD, 40);
		label.setFont(bigFont);
		label.setForeground(Color.red);		
	}
	
	private Integer []shuffleArr() {
		Integer arr [] = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8};
		List<Integer> l = Arrays.asList(arr);		
		Collections.shuffle(l);		
		return (Integer[]) l.toArray();
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			// If the click is not a remove-hatches click
			if (canPress != true) {
				tries ++;
				
				Hatch h = (Hatch) e.getSource();
				h.setText(h.value + "");

				// If first isn't set
				if (prevHatch == null) {
					prevHatch = h;

				// If it's the second click
				} else {
					currHatch = h;

					// Wrong choice, remove it on next click
					if (prevHatch.value != currHatch.value) {
						canPress = true;
						
					// Correct choice, set to false
					} else {
						prevHatch.setEnabled(false);
						currHatch.setEnabled(false);
						prevHatch = null;
						currHatch = null;
						
						hatchesLeft --;
						
						// done
						if ( hatchesLeft == 0 ){
							JFrame winFrame = new JFrame();
							label.setText("DONE!! You used: " + tries + " tries...");
							winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							
							winFrame.getContentPane().add(label);
							winFrame.pack();
							winFrame.setVisible(true);
							frame.dispose();
						}
					}
				}
			}
			
			else {
				tryRemoveHatch();
			}
		}
	}
	
	public void tryRemoveHatch() {
		if (canPress == true) {
			prevHatch.setText("");
			currHatch.setText("");

			prevHatch = null;
			currHatch = null;
			canPress = false;			
		}
	}


	class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			tryRemoveHatch();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new Main();
	}


}
