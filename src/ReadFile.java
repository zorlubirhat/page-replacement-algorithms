import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Birhat Zorlu 21427564
 *
 */
public class ReadFile {

	public static ArrayList<String[]> readFile(String filename){
		ArrayList<String[]> allLines = new ArrayList<String[]>(); 
		try {
	            File f = new File(filename);
	            Scanner sc = new Scanner(f);

	            while(sc.hasNextLine()){
	                String line = sc.nextLine();
	                String[] details = line.split(" ");
	                allLines.add(details);
	            }

	            sc.close();
	        } catch (FileNotFoundException e) {         
	            e.printStackTrace();
	        }
		
		 return allLines; 
	}
}

