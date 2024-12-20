public class CDLinkedList {
	DListNode header;
	int size;
	static final int HEADERVALUE = -9999999;

	public CDLinkedList() {
		header = new DListNode(HEADERVALUE);
		makeEmpty();// necessary, otherwise next/previous node will be null
	}

	public boolean isEmpty() {
		return header.nextNode == header;
	}

	public boolean isFull() {
		return false;
	}

	/** make the list empty. */
	public void makeEmpty() {
		header.nextNode = header;
		header.previousNode = header;
		size = 0;
	}

	// put in new data after the position of p.
	public void insert(int value, Iterator p) throws Exception {
		if (p == null || !(p instanceof DListIterator))
			throw new Exception();
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();

		DListIterator p3 = new DListIterator(p2.currentNode.nextNode);
		DListNode n = new DListNode(value, p3.currentNode, p2.currentNode);
		p2.currentNode.nextNode = n;
		p3.currentNode.previousNode = n;
		size++;
	}

	// return position number of value found in the list.
	// otherwise, return -1.
	public int find(int value) throws Exception {
		DListIterator itr = new DListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			int v = itr.next();
			index++;
			if (itr.currentNode == header)
				return -1;
			if (v == value)
				return index; // return the position of value.
		}
		return -1;
	}

	// return data stored at kth position.
	public int findKth(int kthPosition) throws Exception {
		if (kthPosition < 0 || kthPosition > size - 1)
			throw new Exception();// exit the method if the position is
		// beyond the first/last possible
		// position, throwing exception in the process.
		DListIterator itr = new DListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			int v = itr.next();
			index++;
			if (itr.currentNode == header)
				throw new Exception();
			if (index == kthPosition)
				return v;
		}
		throw new Exception();
	}

	// Return iterator at position before the first position that stores value.
	// If the value is not found, return null.
	public Iterator findPrevious(int value) throws Exception {
		if (isEmpty())
			return null;
		Iterator itr1 = new DListIterator(header);
		Iterator itr2 = new DListIterator(header);
		int currentData = itr2.next();
		while (currentData != value) {
			currentData = itr2.next();
			itr1.next();
			if (((DListIterator) itr2).currentNode == header)
				return null;
		}
		return itr1;
	}

	// remove content at position just after the given iterator. Skip header if
	// found.
	public void remove(Iterator p) {
		if (isEmpty())
			return;
		if (p == null || !(p instanceof DListIterator))
			return;
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			return;
		if (p2.currentNode.nextNode == header)
			p2.currentNode = header;
		if (p2.currentNode.nextNode == null)
			return;
		DListIterator p3 = new DListIterator(p2.currentNode.nextNode.nextNode);
		p2.currentNode.nextNode = p3.currentNode;
		p3.currentNode.previousNode = p2.currentNode;
		size--;
	}

	// remove the first instance of the given data.
	public void remove(int value) throws Exception {
		Iterator p = findPrevious(value);
		if (p == null)
			return;
		remove(p);
	}

	// remove data at position p.
	// if p points to header or the list is empty, do nothing.
	public void removeAt(Iterator p) throws Exception {
		if (isEmpty() || p == null || !(p instanceof DListIterator) || ((DListIterator) p).currentNode == null
				|| ((DListIterator) p).currentNode == header)
			return;

		DListIterator p2 = (DListIterator) (findPrevious(p));
		remove(p2);

	}

	// Print each contact out, one by one.
	// To be completed by students.
	public void printList() throws Exception {
		Iterator itr = new DListIterator(header);
		while (itr.hasNext()) {
			Object data = itr.next();

			System.out.println(data);

		}
	}

	public int size() throws Exception {
		return size;
	}

	// return iterator pointing to location before position.
	public Iterator findPrevious(Iterator position) throws Exception {
		if (position == null)
			return null;
		if (!(position instanceof DListIterator))
			return null;
		if (((DListIterator) position).currentNode == null)
			return null;

		DListIterator p = ((DListIterator) position);
		DListIterator p2 = new DListIterator(p.currentNode.previousNode);
		return p2;

	}

	// write the sort method below
	public void sort() throws Exception { // You must use only 'this' list. No array or any other data structures allowed!!!
		this.quickSort(new DListIterator(this.header.nextNode), new DListIterator(this.header.previousNode));
	}

	// Quicksort method
	private void quickSort(DListIterator start, DListIterator finish) throws Exception {
		if ((start.currentNode != finish.currentNode && start.currentNode != finish.currentNode.nextNode)) {
			DListIterator pivot = partition(start, finish);
			quickSort(start, new DListIterator(pivot.currentNode.previousNode)); 
			quickSort(new DListIterator(pivot.currentNode.nextNode), finish);
		}
	}

	// Partition method to rearrange nodes around pivot
	private DListIterator partition(DListIterator start, DListIterator finish) throws Exception {
		//setup : pivot is last data in the unsorted portion
		int pivotValue = finish.currentNode.data; 
		//setup : initialize i as a first element and j as the element before pivot
		DListIterator i = new DListIterator(start.currentNode);
		DListIterator j = new DListIterator(finish.currentNode.previousNode);
		
		//keep on incrementing i & decrementing j until i >= pivotValue & j <= pivotValue
		while (true) {
		    while (i.currentNode.data < pivotValue) {
		        i.next();
		    }
		    while (j.currentNode.data > pivotValue) {
		        j.previous();
		    }
		    //swap when i is to the left of j else stop
		    if (this.isLeftOf(i, j)) {
		        this.swap(i, j);
		        i.next();
		        j.previous();
		    } else {
		        break;
		    }
		}
		//swap with pivot and return new pivot
		this.swap(i, finish);
		return i;
	}

	// Swap values between two nodes
	private void swap(DListIterator x, DListIterator y) {
		int temp = x.currentNode.data;
		x.currentNode.data = y.currentNode.data;
		y.currentNode.data = temp;
	}

	// helper function to see x isLeftOf y or not
	private boolean isLeftOf(DListIterator x, DListIterator y) throws Exception {
		if (x.equals(y)) {
			return false;
		}
		int xIndex = this.find(x.currentNode.data);
		int yIndex = this.find(y.currentNode.data);
		if (xIndex < yIndex) {
			return true;
		}
		return false; 
	}

}