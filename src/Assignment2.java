import java.util.ArrayList;

/**
 * @author Birhat Zorlu 21427564
 *
 */
public class Assignment2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FIFO first = new FIFO();
		SecondChance sc = new SecondChance();
		PriorityQueuePageReplacement pqPage = new PriorityQueuePageReplacement();
		
		ArrayList<String[]> lines = ReadFile.readFile(args[0]);
		
		int pSize = lines.size()-3;
		String[] pages = new String[pSize];
		for(int i=0;i<pages.length;i++){
			pages[i] = lines.get(i+3)[1];			
		}
	
        
		if(lines.get(1)[1].equals("FIFO")){		
			int fSize = Integer.valueOf(lines.get(0)[1]);
			String outputFile = "out.txt";
			first.fifo(lines, pages, fSize, outputFile);			
		}
		
        
		else if(lines.get(1)[1].equals("SecondChance")){
			int fSize = Integer.valueOf(lines.get(0)[1]);
			String outputFile = "out.txt";
			sc.secondChancePageReplacement(lines, pages, fSize, outputFile);
		}
		
		else if(lines.get(1)[1].equals("PriorityQueue")){		
			int fSize = Integer.valueOf(lines.get(0)[1]);
			String outputFile = "out.txt";
			pqPage.pqPage(lines, pages, fSize, outputFile);
		}
	}
}
