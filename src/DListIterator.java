import java.util.NoSuchElementException;

public class DListIterator implements Iterator {
	DListNode currentNode; // interested position

	DListIterator(DListNode theNode) {
		currentNode = theNode;
	}

	public boolean hasNext() { // always true for circular list.
		return currentNode.nextNode != null;
	}
	
	public boolean hasPrevious() { // always true for circular list.
		return currentNode.previousNode != null;
	}
	
	public char next() throws Exception {
		// Throw exception if the next data
		// does not exist.
		if (!hasNext())
			throw new NoSuchElementException();
		currentNode = currentNode.nextNode;
		return currentNode.data;

	}

	public char previous() throws Exception{
		if (!hasPrevious())
			throw new NoSuchElementException();
		char data = currentNode.data;
		currentNode = currentNode.previousNode;
		return data;
	}

	public void set(char value) {
		currentNode.data = value;
	}
}
