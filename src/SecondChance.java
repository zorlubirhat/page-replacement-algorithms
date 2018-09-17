import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Birhat Zorlu 2127564
 *
 */
public class SecondChance {
	
	public void secondChancePageReplacement(ArrayList<String[]> lines, String[] pages, int fSize, String filename){
		long startSecond = System.currentTimeMillis();
		int f = fSize, num = 0, fault = 0, p = pages.length ;
		
		Queue frame = new Queue(f);
//		BinarySearchTree bst = new BinarySearchTree();
		ArrayList<Integer> clockIndex = new ArrayList<Integer>();
		ArrayList<String> clockString = new ArrayList<String>();
		ArrayList<String> birhat = new ArrayList<String>();
		int emre = -1;
		
		FileWriter fWriter = null;
		try{
			fWriter = new FileWriter(filename);
			
			fWriter.append("Memory " + lines.get(0)[1] + "\n");
			fWriter.append(lines.get(1)[1] + " Page Replacement\n");
			fWriter.append("Binary Search Tree\n");
			
			boolean flag = true;
			for(int i=0; i<f; i++)
		    {
		            frame.QueueArray[i] = String.valueOf(-1);
		    }
			for(int i=0; i<p; i++)
		    { 
				flag = true;
		        String page = pages[i];
		        
		        for(int j=0; j<f; j++)
			    {  	
			      	if(frame.QueueArray[j].equals(page))
			        {
			      		clockIndex.add(j);
			      		clockString.add(page);
			       		flag = false;
			            fWriter.append("\t\t\t");
			            break;
			        }
			    }
		        
			    if(num == f){
			    	if(!flag){
			    		num = clockIndex.get(clockIndex.size()-1) + 1;
			    		birhat.addAll(clockString);
			    		emre = i;
			    		clockIndex.clear();
			    		clockString.clear();
			    	}
			    	else{
			    		num = 0;
			    	}
			    }

			    
			    if(flag)
			    {
			      	frame.QueueArray[num] = page;
			        num++;
			        fault++;
			        fWriter.append("Page Fault\t");
			        if(!clockString.isEmpty() && clockString.get(clockString.size()-1).equals(frame.QueueArray[frame.QueueArray.length-1])){	
			    		num = 0;
			    		birhat.addAll(clockString);
			    		emre = i;
			    		clockIndex.clear();
			    		clockString.clear();
			    	}
			        
			    }
			    
			       
			    for(int k=0; k<f; k++)
			      	if(!frame.QueueArray[k].equals("-1"))
			        	fWriter.append(frame.QueueArray[k]+" ");
			    	if(emre == i-1){
			    		fWriter.append("Second Chance ");
			    		for(int k =0;k<birhat.size();k++)
			    			 fWriter.append(birhat.get(k) + " ");
			    		birhat.clear();
			    	}
			    	fWriter.append("\n");    
		    }   
			fWriter.append(String.valueOf(fault) + "\n");
			
			long endSecond = System.currentTimeMillis();
	        long outputSecond = startSecond - endSecond;
	        if(outputSecond < 0)
	        	fWriter.append("Elapsed time in ms: " + (0-outputSecond));
	        else
	        	fWriter.append("Elapsed time in ms: " + outputSecond);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	
			try {
				fWriter.flush();
				fWriter.close();
			} catch (IOException e) {
	            e.printStackTrace();
			}		
		}
		
	}

}

