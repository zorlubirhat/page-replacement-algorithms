/**
 * @author Birhat Zorlu 21472564
 *
 */
class BinarySearchTreeNode {
	public String data;  // data at each node
	public BinarySearchTreeNode left, right;
	public int size;
	public BinarySearchTreeNode(String d) { // construct leaf node
		data = d;
	    left = right = null;
	    size = 0;
	}
}

public class BinarySearchTree {
	public BinarySearchTreeNode root; // hidden root node

	   // insert: if new entry, insert in tree
	public void insert(String d) {
		if (root == null) { // must handle case of empty tree first
			root = new BinarySearchTreeNode(d);
	        return;
	    }
		BinarySearchTreeNode loc = root; // start search downward at root
	    while (true) {
	    if (d.compareTo(loc.data) < 0) { // look left
	    	if (loc.left != null) loc = loc.left;
	        	else { loc.left = new BinarySearchTreeNode(d); break; }
	        }
	        else if (d.compareTo(loc.data) > 0) { // look right
	        	if (loc.right != null) loc = loc.right;
	            else { loc.right = new BinarySearchTreeNode(d); break; }
	        }
	        else break; // found! Don't insert
	    }
	}
	
	public boolean contains(String key) {
		if (key == null) throw new IllegalArgumentException("argument to contains() is null");
	    	return get(key) != null;
	}

	    /**
	     * Returns the value associated with the given key.
	     *
	     * @param  key the key
	     * @return the value associated with the given key if the key is in the symbol table
	     *         and {@code null} if the key is not in the symbol table
	     * @throws IllegalArgumentException if {@code key} is {@code null}
	     */
	    public String get(String key) {
	        return get(root, key);
	    }

	    private String get(BinarySearchTreeNode x, String key) {
	        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
	        if (x == null) return null;
	        int cmp = key.compareTo(x.data);
	        if      (cmp < 0) return get(x.left, key);
	        else if (cmp > 0) return get(x.right, key);
	        else              return x.data;
	    }
	    public void delete(String key) {
	        if (key == null) throw new IllegalArgumentException("calls delete() with a null key");
	        root = delete(root, key);
	    }

	    private BinarySearchTreeNode delete(BinarySearchTreeNode x, String key) {
	        if (x == null) return null;

	        int cmp = key.compareTo(x.data);
	        if      (cmp < 0) x.left  = delete(x.left,  key);
	        else if (cmp > 0) x.right = delete(x.right, key);
	        else { 
	            if (x.right == null) return x.left;
	            if (x.left  == null) return x.right;
	        } 
	        x.size = size(x.left) + size(x.right) + 1;
	        return x;
	    }
	    public int size() {
	        return size(root);
	    }

	    // return number of key-value pairs in BST rooted at x
	    private int size(BinarySearchTreeNode x) {
	        if (x == null) return 0;
	        else return x.size;
	    }
	// inorderTraversal: need because root is hidden
	public void inorderTraversal() {inorderT(root); }

	// inorderT: recursive function that does the work
	private void inorderT(BinarySearchTreeNode t) {
		if (t != null) {
			inorderT(t.left);
	        System.out.print(t.data + " ");
	        inorderT(t.right);
	    }
	}
}
