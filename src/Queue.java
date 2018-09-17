/**
 * 
 */

/**
 * @author Birhat Zorlu 21427564
 *
 */
public class Queue {
	
    public String[] QueueArray;
    private int capacity; // capacity
    private int front;
    private int rear;
	public int maxSize;
   
	public String[] getQueueArray() {
		return QueueArray;
	}
	
    public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public int getRear() {
		return rear;
	}

	public int setRear(int rear) {
		this.rear = rear;
		return rear;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Queue(int size){
        setCapacity(size);
        QueueArray = new String[size];
        setFront(-1);
        setRear(-1);
    }
 
    public boolean isEmpty() {
        if(getFront() == -1){
        	return true;
        }
        return false;
    }
 
    public boolean isFull() {
        if(!QueueArray[getCapacity()-1].equals("-1")){
        	return true;
        }
        return false;
    }
 
    public void enqueue(String obj){
        if(!isFull()){
        	if(getFront() == -1){
        		setFront(0);
        	}
        	setRear((getRear()+1) % getCapacity());
        	QueueArray[getRear()] = obj;
        }
    }
 
    public String dequeue() {
    	String item = String.valueOf(-1);
        if(!isEmpty()){
        	item = QueueArray[getFront()];
        	if(getFront() == getRear()){
        		setFront(-1);
        		setRear(-1);
        	}
        	else{
        		setFront(((getFront()+1) % getCapacity()));
        	}
        }
        return item; 
    }
    
    private boolean less(int i, int j) {
        return QueueArray[i].compareTo(QueueArray[j]) < 0;
    }
    
    public int findMax() {
        int max = 0;
        for (int i = 1; i < capacity; i++)
            if (less(max, i)){
            	max = i;
            }
        maxSize = max;
        
        return maxSize;
    }
}

