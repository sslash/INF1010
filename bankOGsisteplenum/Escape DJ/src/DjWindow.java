package src;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.border.*;
import java.awt.event.ActionListener;

public class DjWindow {

	private JFrame frame;

	/* Need this so the image can be changed */
	private JLabel imgLabel = new JLabel();

	/* Need this so the list of songs can be changed */
	private JList songsList;

	/* Need this so the description can be changed */
	private JLabel descriptionLabel = new JLabel();

	/* Need this so the name can be changed */
	private JLabel nameLabel = new JLabel();

	/* Scroll pane for the jList of songs */
	private JScrollPane listScroller;

	/* Buttons used for navigation and control */
	private JButton nextButton, prevButton, allSongsButton;

	/* Reference to controller class that handles logic */
	private Controller controller;

	/* Action listener for the buttons */
	private ActionListener listener;

	public void setController ( Controller c ) {
		this.controller = c;
	}

	/**
	 * Inits the gui components 
	 */
	public void init() {
		frame = new JFrame("DJ@ESCAPE");
		frame.add(setTopLabel(), BorderLayout.NORTH);
		frame.add(setMiddle(), BorderLayout.CENTER);
		addButtons();
		frame.add(setAllSongsButton(), BorderLayout.SOUTH);
	}

	private void addButtons() {
		// Create one actionlistener for all the buttons
		listener  = controller.new ButtonListener ();

		nextButton = new JButton();
		prevButton = new JButton();
		frame.add(setButton("images/rightButton.jpg", nextButton), BorderLayout.EAST);
		frame.add(setButton("images/leftButton.jpg", prevButton), BorderLayout.WEST);

		
	}

	public void repackGui() {
		frame.pack();
	}

	/**
	 * Creates the whole gui and sets it to display itself
	 */
	public void showGUI() {
		
		// Finally display the jFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Updates the image in the gui
	 *
	 * @image reference to the image object to display
	 */
	public void updateImage(ImageIcon image) {
		imgLabel.setIcon(image);
	}


	/**
	 * Updates the description string in the gui
	 *
	 * @desc reference to the description string
	 */
	public void updateDescription(String desc) {
		descriptionLabel.setText(desc);
	}


	/**
	 * Updates the list of songs in the gui
	 *
	 * @songList reference to a list of song names
	 */
	public void updateSongsList(Object []songList) {
		songsList.setListData(songList);
	}


	/**
	 * Updates the name string in the gui
	 *
	 *@image reference to the name string
	 */
	public void updateName (String name) {
		nameLabel.setText(name);
	}
	public JLabel createNameLabel(){
		nameLabel.setFont(new Font("Verdana", Font.BOLD, 25));
		return nameLabel;
	}

	/**
	 * Creates and returns the gui components for the middle part of the screen
	 */
	public JPanel setMiddle() {

		JPanel rightPanel = new JPanel();
		rightPanel.setLayout( new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.add(createNameLabel());
		rightPanel.add(descriptionLabel);
		rightPanel.add(setSongsList(new String []{""} ));

		JPanel midPanel = new JPanel();
		midPanel.add(imgLabel);
		midPanel.add(rightPanel);
		return midPanel;
	}

	/**
	 * Creates and returns a list of song names
	 * that has a little title on top
	 * 
	 * @songs List of song names
	 */
	public JPanel setSongsList(String [] songs) {

		// Create the list of songs
		songsList = new JList (songs);
		listScroller = new JScrollPane(songsList);

		// Add these list of songs with a border around it
		JPanel songsPanel = new JPanel();
		songsPanel.setBorder( new TitledBorder("Songs"));
		songsPanel.setLayout( new BoxLayout(songsPanel, BoxLayout.Y_AXIS));
		songsPanel.add(listScroller);

		return songsPanel;
	}

	/**
	 * Styles a button with an image and spacing.
	 * Returns a JPanel that wraps the image
	 *
	 * @name the name of the image file
	 * @return A JPanel that contains an image button
	 *
	 */
	public JPanel setButton(String name, JButton button) {
		button.setIcon( new ImageIcon(name));

		// Set the listener for the button
		button.addActionListener(listener); 
		JPanel panel = new JPanel();

		// Simple way to add some spacing 
		panel.setBorder(new EmptyBorder(150, 10, 10, 10) );

		panel.add(button);
		return panel;
	}


	/**
	 * Creates the JPanel that wraps a button
	 *
	 * @return a JPanel with a button
	 */
	public JPanel setAllSongsButton() {
		allSongsButton = new JButton("List all Songs");
		allSongsButton.addActionListener(listener);
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(allSongsButton);
		return bottomPanel;
	}

	/**
	 * Creates the top panel that just has a jPanel
	 *
	 * @return a panel with a label in it
	 */
	private JPanel setTopLabel() {
		JPanel topPanel = new JPanel();
		JLabel label = new JLabel("Escape DJ");

		// Create a neat font for the label
		Font font = new Font("Verdana", Font.BOLD, 25);
		label.setFont(font);
		topPanel.add(label);

		return topPanel;
	}

	public JButton getNextButton() {
		return nextButton;
	}
	
	public JButton getAllSongsButton(){
		return allSongsButton;
	}
}