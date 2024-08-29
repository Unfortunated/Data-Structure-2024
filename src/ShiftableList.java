
public class ShiftableList extends CDLinkedList {

	public ShiftableList() throws Exception {
		this("");
	}

	public ShiftableList(String s) throws Exception {
		// initialize the list
		// each data comes from each character in s
		int n = s.length();
		DListIterator d = new DListIterator(header);
		for (int i = n - 1; i >= 0; i--) {
			insert(s.charAt(i), d);
		}

	}

	//change the nth data (counting from header) to be a new first 
	//data of the list 
	public void shift(int n) throws Exception {
//		if n == 0 then it is the same
		if (n <= 0) {
			return;
		}
		int counter = 0;
		DListNode start = header;
		while (counter != n) {
			start = start.nextNode;
			counter += 1;
		}
//		change data next to header
		DListNode oldStart = header.nextNode;
		oldStart.previousNode = header.previousNode;
		header.previousNode.nextNode = oldStart;
		header.nextNode = start;
//		Change value that will come to header
		start.previousNode = header;
	}

	// shift the list such that the data at position newStart becomes the first data
	// for list a,b,c,d,e,f
	// if newStart is pointing at c, 
	// the new list will be c,d,e,f,a,b
	public void shift(DListNode newStart) {
		if (newStart == null || newStart == header) {
			return;
		}
//		change data next to header
		DListNode oldStart = header.nextNode;
		oldStart.previousNode = header.previousNode;
		header.previousNode.nextNode = oldStart;
		header.nextNode = newStart;
		newStart.previousNode = header;
	}

}
