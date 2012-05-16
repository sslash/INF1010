package src;

import java.util.ArrayList;
import java.util.Iterator;	
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Controller class in the MVC pattern.
 * Gets request from the gui window, updates/reads from the model,
 * sends data back to the gui.
 */
public class Controller {

	private EscapeCollection <AbstractStudent> students;
	private Iterator <AbstractStudent> studentIterator;
	private DjWindow window;
	private Monitor<String> currentMonitor;

	public Controller(DjWindow window, EscapeCollection <AbstractStudent> students) {
		this.window = window;
		this.students = students;

		// Set the iterator that is used to view students in the gui
		studentIterator = students.iterator();
	}


	/**
	 * called by the gui window to display a new student
	 */
	public void setNextStudentInGUIWindow() {
		if (studentIterator.hasNext() ) {
			AbstractStudent currentStudent = studentIterator.next();
			
			updateImage(currentStudent);
			updateDescription(currentStudent);
			updateName(currentStudent);
			updateSongsList(currentStudent);
			window.repackGui();
		}
	}

	private void updateSongsList(AbstractStudent currentStudent) {
		ArrayList<String> arrList = currentStudent.getSongs();
		window.updateSongsList(arrList.toArray());
	}

	private void updateImage(AbstractStudent currentStudent) {
		
		try {
			BufferedImage image = ImageIO.read(new File(currentStudent.getImgPath()));
			ImageIcon imgIcon = new ImageIcon(image);
			
			window.updateImage(imgIcon);

		} catch(FileNotFoundException f) {
			System.err.println(f.getMessage());
		} catch (IOException i ){
		    System.err.println(i.getMessage());
		}

		// Failed to open image
		//return null;
	}

	private void updateDescription(AbstractStudent currentStudent) {
		window.updateDescription(currentStudent.createDescriptionString());
	}

	private void updateName(AbstractStudent currentStudent) {
		window.updateName(currentStudent.getName());
	}

	public class ButtonListener implements ActionListener {
		

		public void actionPerformed( ActionEvent e ){
			
			if( e.getSource() == window.getAllSongsButton()){
				
				
				new Thread(){
					public void run(){
						currentMonitor = new Monitor<String>();
						Iterator <AbstractStudent> it = students.iterator();
						ArrayList<SongThread> list = new ArrayList<SongThread>();
						while(it.hasNext()){
							AbstractStudent stud = it.next();
							SongThread s = new SongThread(stud, currentMonitor);
							s.start();
							list.add(s);
						}
						
						for(SongThread s : list){
							try {
								s.join();
							} catch (InterruptedException e) {}
						}
						ArrayList<String> a = currentMonitor.getList();
						JFrame frame = new ListSongs(a.toArray());
					}
				}.start();
				
			}
			if ( e.getSource() == window.getNextButton() ) {
				setNextStudentInGUIWindow();
			}
		}

	}
}