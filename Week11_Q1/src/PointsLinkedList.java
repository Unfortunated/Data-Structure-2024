public class PointsLinkedList {
	PointListNode header;
	int size;

	public PointsLinkedList() {
		header = new PointListNode(null);
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
	public void insert(Point point, Iterator p) throws Exception {
		if (p == null || !(p instanceof PointListIterator))
			throw new Exception();
		PointListIterator p2 = (PointListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();

		PointListIterator p3 = new PointListIterator(p2.currentNode.nextNode);
		PointListNode n = new PointListNode(point, p3.currentNode, p2.currentNode);
		p2.currentNode.nextNode = n;
		p3.currentNode.previousNode = n;
		size++;
	}

	// return position number of value found in the list.
	// otherwise, return -1.
	public int find(Point point) throws Exception {
		PointListIterator itr = new PointListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			Point v = itr.next();
			index++;
			if (itr.currentNode == header)
				return -1;
			if (v.equals(point))
				return index; // return the position of value.
		}
		return -1;
	}

	// return data stored at kth position.
	public Point findKth(int kthPosition) throws Exception {
		if (kthPosition < 0 || kthPosition > size - 1)
			throw new Exception();// exit the method if the position is
		// beyond the first/last possible
		// position, throwing exception in the process.
		PointListIterator itr = new PointListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			Point v = itr.next();
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
	public Iterator findPrevious(Point value) throws Exception {
		if (isEmpty())
			return null;
		Iterator itr1 = new PointListIterator(header);
		Iterator itr2 = new PointListIterator(header);
		Point currentData = itr2.next();
		while (!currentData.equals(value)) {
			currentData = itr2.next();
			itr1.next();
			if (((PointListIterator) itr2).currentNode == header)
				return null;
		}
		return itr1;
	}

	// remove content at position just after the given iterator. Skip header if
	// found.
	public void remove(Iterator p) {
		if (isEmpty())
			return;
		if (p == null || !(p instanceof PointListIterator))
			return;
		PointListIterator p2 = (PointListIterator) p;
		if (p2.currentNode == null)
			return;
		if (p2.currentNode.nextNode == header)
			p2.currentNode = header;
		if (p2.currentNode.nextNode == null)
			return;
		PointListIterator p3 = new PointListIterator(p2.currentNode.nextNode.nextNode);
		p2.currentNode.nextNode = p3.currentNode;
		p3.currentNode.previousNode = p2.currentNode;
		size--;
	}

	// remove the first instance of the given data.
	public void remove(Point value) throws Exception {
		Iterator p = findPrevious(value);
		if (p == null)
			return;
		remove(p);
	}

	// remove data at position p.
	// if p points to header or the list is empty, do nothing.
	public void removeAt(Iterator p) throws Exception {
		if (isEmpty() || p == null || !(p instanceof PointListIterator) || ((PointListIterator) p).currentNode == null
				|| ((PointListIterator) p).currentNode == header)
			return;

		PointListIterator p2 = (PointListIterator) (findPrevious(p));
		remove(p2);

	}

	// Print each data out into a string, one by one.
	public String printList() throws Exception {
		String ans = "";
		PointListIterator itr = new PointListIterator(header);
		while (itr.hasNext() && itr.currentNode.nextNode != header) {
			Object data = itr.next();

			ans += data + " ";
		}
		ans = ans.trim();
		return ans;
	}

	public int size() {
		return size;
	}

	// return iterator pointing to location before position.
	public Iterator findPrevious(Iterator position) throws Exception {
		if (position == null)
			return null;
		if (!(position instanceof PointListIterator))
			return null;
		if (((PointListIterator) position).currentNode == null)
			return null;

		PointListIterator p = ((PointListIterator) position);
		PointListIterator p2 = new PointListIterator(p.currentNode.previousNode);
		return p2;

	}

}