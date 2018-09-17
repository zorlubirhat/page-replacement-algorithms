/**
 * @author Birhat Zorlu 21427564
 *
 */
public class BinarySearchTreeNode {
	public String data;  // data at each node
	public BinarySearchTreeNode left, right;
	public int size;
	public BinarySearchTreeNode(String d) { // construct leaf node
		data = d;
	    left = right = null;
	    size = 0;
	}
}
