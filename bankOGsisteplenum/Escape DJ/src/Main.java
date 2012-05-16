package src;

public class Main {


	public static void main( String [] main ) {

        AbstractStudent s1 = new SimpleStudent("DJ Sandwich", 22, "Informatikk, bachelor", "images/henrik_sand.png");
        EscapeBinTree<String> tree1 = new EscapeBinTree<String>();
        tree1.add("Celine Dion - My Heart Will Go On");
        tree1.add("Mr. Boombay - SOS");
        tree1.add("Scooter - Desire");
        tree1.add("Amy MacDonald - This is the Life");
        tree1.add("Avicii - Derezzed");
        tree1.add("Deadmau5 - Hey baby");
        tree1.add("Queen - Bohemian Rhapsody");
        s1.setSongs(tree1);

        AbstractStudent s2 = new InternStudent("DJ MAG-LIGHTZ", 22, "Informatikk, bachelor ","images/magnus.png","DJ ansvarlig");
        EscapeBinTree<String> tree2 = new EscapeBinTree<String>();
        tree2.add("Justin Bieber - Turn to you");
        tree2.add("Double Take - Hot problems");
        tree2.add("Paradise Iselin - Chewing gum");
        tree2.add("R.E.M - Man on the moon");
        tree2.add("Elton John - Tiny Dancer");
        tree2.add("DonkeyBoy - City Boy");
        tree2.add("ToTo - Africa");
        tree2.add("Queen - Another one bites the dust");
        s2.setSongs(tree2);

        AbstractStudent s3 = new InternStudent("Henrik", 24, "Systemutvikling", "images/henrik.png","Bar ansvarlig");
        EscapeBinTree<String> tree3 = new EscapeBinTree<String>();
        tree3.add("Purified in blood - THe covenant fall");
        s3.setSongs(tree3);

        AbstractStudent s4 = new SimpleStudent("Frode", 23, "Programmering og nettverk","images/frode.png");
        EscapeBinTree<String> tree4 = new EscapeBinTree<String>();
        tree4.add("Madeon - Icarus");
        tree4.add("Nicki Minaj - Starships");
        tree4.add("Loreen - Euthoria");
        tree4.add("East Movement - Live My Life");
        tree4.add("Flo Rida - Wild Ones");
        tree4.add("Maroon 5 - Payphone");
        s4.setSongs(tree4);


        AbstractStudent s5 = new SimpleStudent("DJ Soap", 23, "Programmering og nettverk","images/per.png");
        EscapeBinTree<String> tree5 = new EscapeBinTree<String>();
        tree5.add("Cristopher - Mine, mine, mine");
        tree5.add("Swedish house mafia - Greyhound");
        tree5.add("Deadmou5 - Attention whore");
        tree5.add("Robyn - Call your girlfriend");
        tree5.add("Eric Amarillo - Om Sanningan ska fram");
        tree5.add("Medina - For Altid");
        s5.setSongs(tree5);

        SimpleLinkedList <AbstractStudent>list = new SimpleLinkedList <AbstractStudent>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);


        final DjWindow window = new DjWindow();
        Controller c = new Controller(window, list);

        window.setController(c);
        window.init();


        c.setNextStudentInGUIWindow();


		//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                window.showGUI();
            }
        });
	}
}