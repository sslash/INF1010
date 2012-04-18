
public class Controller {
	private Oppgave2 view;
	private Model model;
	private Sorter sorter;
	
	
	public void setSorter( Sorter sorter ) {
		this.sorter = sorter;
	}
	

	public Controller() {}
	
	public void setView (Oppgave2 v) {
		view = v;
	}
	
	public void setModel(Model m ) {
		model = m;
	}

	
	public void sortFile(String filename) {
			String content = model.getFileContent(filename);
			if ( content == null )
				;
			else {
				
				String nums[] = content.split(",");
				char [] toArr = new char[nums.length]; int i = 0;
				for ( String s: nums ) {
					toArr[i++] = s.charAt(0);
				}
				
				long t1 = System.currentTimeMillis();
				sorter.sort(toArr);
				long res = System.currentTimeMillis() - t1;
				
				System.out.println(new String(toArr));
				view.setSortedText(new String(toArr));
				view.setTimeText("time spent: " + res + "ms,  by using " + sorter.getClass().getName());
			}		
			
	}
}
