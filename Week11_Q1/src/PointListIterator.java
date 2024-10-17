import java.util.NoSuchElementException;

public class PointListIterator implements Iterator {
	PointListNode currentNode; // interested position

	PointListIterator(PointListNode theNode) {
		currentNode = theNode;
	}

	public boolean hasNext() { // always true for circular list.
		return currentNode.nextNode != null;
	}
	
	public boolean hasPrevious() { // always true for circular list.
		return currentNode.previousNode != null;
	}
	
	public Point next() throws Exception {
		// Throw exception if the next data
		// does not exist.
		if (!hasNext())
			throw new NoSuchElementException();
		currentNode = currentNode.nextNode;
		return currentNode.data;

	}

	public Point previous() throws Exception{
		if (!hasPrevious())
			throw new NoSuchElementException();
		Point data = currentNode.data;
		currentNode = currentNode.previousNode;
		return data;
	}

	public void set(Point value) {
		currentNode.data = value;
	}
}
