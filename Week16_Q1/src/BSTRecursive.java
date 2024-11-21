import java.util.ArrayList;
import java.util.Arrays;

public class BSTRecursive {

	BSTNode root;
	int size;

	public BSTRecursive(BSTNode root, int size) {
		this.root = root;
		this.size = size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void makeEmpty() {
		root = null;
		size = 0;
	}

	public Iterator findMin() {
		return findMin(root);
	}

	public Iterator findMin(BSTNode n) {
		if (n == null)
			return null;
		if (n.left == null) {
			Iterator itr = new TreeIterator(n);
			return itr;
		}
		return findMin(n.left);
	}

	public Iterator findMax() {
		return findMax(root);
	}

	public Iterator findMax(BSTNode n) {
		if (n == null)
			return null;
		if (n.right == null) {
			Iterator itr = new TreeIterator(n);
			return itr;
		}
		return findMax(n.right);
	}

	public Iterator find(int v) {
		return find(v, root);
	}

	public Iterator find(int v, BSTNode n) {
		if (n == null)
			return null;
		if (v == n.data)
			return new TreeIterator(n);
		if (v < n.data)
			return find(v, n.left);
		else
			return find(v, n.right);
	}

	public BSTNode insert(int v) {
		return insert(v, root, null);
	}

	// return the node n after v was added into the tree
	public BSTNode insert(int v, BSTNode n, BSTNode parent) {
		if (n == null) {
			n = new BSTNode(v, null, null, parent);
			size++;
		} else if (v < n.data) {
			n.left = insert(v, n.left, n);
		} else if (v > n.data) {
			n.right = insert(v, n.right, n);
		}
		return n;
	}

	public BSTNode remove(int v) {
		return remove(v, root, null);
	}

	// return the node n after v was removed from the tree
	public BSTNode remove(int v, BSTNode n, BSTNode parent) {
		if (n == null)
			; // do nothing, there is nothing to be removed
		else if (v < n.data) {
			n.left = remove(v, n.left, n);
		} else if (v > n.data) {
			n.right = remove(v, n.right, n);
		} else {
			if (n.left == null && n.right == null) {
				n.parent = null; // disconnect from above
				n = null; // disconnect from below
				size--;
			} else if (n.left != null && n.right == null) {
				BSTNode n2 = n.left;
				n2.parent = parent;
				n.parent = null; // disconnect from above
				n.left = null; // disconnect from below
				n = n2; // change to the node below
						// to prepare for connection from parent
				size--;
			} else if (n.right != null && n.left == null) {
				BSTNode n2 = n.right;
				n2.parent = parent;
				n.parent = null; // disconnect from above
				n.right = null; // disconnect from below
				n = n2; // change to the node below
						// to prepare for connection from parent
				size--;
			} else {
				TreeIterator i = (TreeIterator) findMin(n.right);
				int minInRightSubtree = i.currentNode.data;
				n.data = minInRightSubtree;
				n.right = remove(minInRightSubtree, n.right, n);
			}
		}
		return n;
	}
	
        // Test if the whole tree is an AVL tree
	public boolean isAVLTree_Iterator() throws Exception {
		if (root == null)
			return true; // ********

		TreeIterator a = new TreeIterator(root);

		while (a.currentNode.left != null) { // go to the minimum node
			a.previous();
		}

		boolean isAVL = true;
		BSTNode current = a.currentNode;
		while (a.hasNext()) {
			current = a.currentNode;
			int hLeft = height(current.left);
			int hRight = height(current.right);
			if (Math.abs(hLeft - hRight) >= 2) {
				return false;
			} else {
				a.next();
			}
		}
		current = a.currentNode;
		int hLeft = height(current.left);
		int hRight = height(current.right);
		if (Math.abs(hLeft - hRight) >= 2) {
			return false;
		} else {
			return true;
		}

	}

        // Height of subtree that has n as its root. 
	public int height(BSTNode n) {
		if (n == null)
			return -1;
		int hLeft = height(n.left);
		int hRight = height(n.right);
		return 1 + Math.max(hLeft, hRight);
	}

	//check AVL property of a single node, n . 
	public boolean isAVL(BSTNode n) { 
		if (n == null)
			return true;
		int hLeft = height(n.left);
		int hRight = height(n.right);

		if (Math.abs(hLeft - hRight) < 2) {
			return true;
		} else {
			return false;
		}
	}
	

	/**************************************************************************************************/
	// Edit only the following method. You can add your own methods below this line too.
	/**************************************************************************************************/

       // Return how many nodes a subtree has, if n is the root of the subtree.
	public int size(BSTNode n) {
		if (n == null) {
			return 0;
		}
		int sizeLeft = size(n.left);
		int sizeRight = size(n.right);
		return 1 + sizeLeft + sizeRight;
	}



	int lastPos = -1;         // to remember a marked position in the array "temp".
	int[] temp = new int[10]; // This array will store result we get from calling nonAVLNodes(n). Assume the number of nodes do not exceed 10.
	public int[] nonAVLNodes(BSTNode n) {
		// Assume data in any node is >= 1. You don't need to write code to deal with it.
		// Assume no duplicate data are allowed. You don't need to write code to deal with it.
		// Assume the whole tree always have at least one node
		// (but n can be null since we can look at any node in the tree).

                 //For a subtree that has n as its root:
		//      This method returns the values in all nodes that do not satisfy AVL constraint.
		//      The returned array must be sorted from small to large. The array has leading zero(s).
		this.findNonAVLNodes(n);
		return temp;
	}
	
	//helper function to find NonAVLNodes and put in array (Uses reverse inorder traversal to go to each node)
	private void findNonAVLNodes(BSTNode n) {
		//base case
		if (n == null) {
			return;
		}
		//find big value first
		findNonAVLNodes(n.right);
		//if not AVL then put in array from the end side
		if (!this.isAVL(n)) {
			temp[temp.length+lastPos] = n.data;
			lastPos--;
		}
		//find small value
		findNonAVLNodes(n.left);
	}
}
