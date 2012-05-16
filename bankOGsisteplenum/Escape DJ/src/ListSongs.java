package src;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ListSongs extends JFrame {
	
	ListSongs(Object[] list){
		setVisible(true);
		setSize(500,500);
		JList songsList = new JList (list);
		JScrollPane listScroller = new JScrollPane(songsList);

		// Add these list of songs with a border around it
		JPanel songsPanel = new JPanel();
		songsPanel.setBorder( new TitledBorder("Songs"));
		songsPanel.setLayout( new BoxLayout(songsPanel, BoxLayout.Y_AXIS));
		songsPanel.add(listScroller);
		add(songsPanel);
		songsPanel.updateUI();
	}
}
