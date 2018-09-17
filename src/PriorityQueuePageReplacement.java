import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PriorityQueuePageReplacement {
	
	public void pqPage(ArrayList<String[]> lines, String[] pages, int fSize, String filename){
		long startPriority = System.currentTimeMillis();
		int f = fSize, front = 0, fault = 0, p = pages.length ;
		
		Queue frame = new Queue(f);
//		BinarySearchTree bst = new BinarySearchTree();
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
			       		flag = false;
			            fWriter.append("\t\t\t");
			            break;
			        }
			    }
			    if(front == f)
			       	front = frame.findMax();
			           
			    if(flag)
			    {
			    	if(frame.isFull())
			    		frame.QueueArray[frame.findMax()] = page;
			    	else
			    		frame.QueueArray[front] = page;
			        	front++;
			        fault++;
			        fWriter.append("Page Fault\t");
			    } 
		        
			    for(int k=0; k<f; k++)
			      	if(!frame.QueueArray[k].equals("-1"))
			        	fWriter.append(frame.QueueArray[k]+" ");
			        fWriter.append("\n"); 
	 
		    }   
			fWriter.append(String.valueOf(fault) + "\n");
			
			long endPriority = System.currentTimeMillis();
	        long outputPriority = startPriority - endPriority;
	        if(outputPriority < 0)
	        	fWriter.append("Elapsed time in ms: " + (0-outputPriority));
	        else
	        	fWriter.append("Elapsed time in ms: " + outputPriority);
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
