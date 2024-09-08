
public class TypingDeadList extends CDLinkedList {
	int score = 0;  //not used in this exam
	DListIterator start = null; // the first position of a word to remove
	DListIterator end = null; // last position of a word to remove

	public TypingDeadList() throws Exception {
		this("");
	}

	public TypingDeadList(String s) throws Exception {
		// initialize the list
		// each data comes from each character in s
		int n = s.length();
		DListIterator d = new DListIterator(header);
		for (int i = n - 1; i >= 0; i--) {
			insert(s.charAt(i), d);
		}

	}

	public void removeWord(String w) throws Exception {
		// remove the first occurrence of w
		// if w is not in the list, do nothing
		// reset start and end to null no matter what
		findWord(w);
		if (start == null)
			return;

		int dec = w.length();
		remove(dec);

	}

	public void findWord(String w) throws Exception {
		// update start and end to mark position of the first occurrence of w
		// The word cannot cross header node
		// If w is not in the list, do nothing.
		// w is assumed never to be an empty string.


		//fill code
		//checker to find firstletter
		boolean firstLetter = false;
		//checker to validated entire word
		boolean found = false;
		//the only moving pointer
		DListNode curr = header;
		//counter to count size of word
		int i = 0;
		while (curr.nextNode != header) {
			//check for first letter
			if ((curr.data == w.charAt(0)) && firstLetter == false) {
				firstLetter = true;
				this.start = new DListIterator(curr);
				i++;
			//first letter founded then move on to the next
			} else if (curr.data == w.charAt(i)) {
				i++;
			//the current letter is wrong so find new first letter
			} else {
				i = 0;
				firstLetter = false;
			}
			//check for the size to validate the word found then break
			if (i == w.length()) {
				found = true;
				this.end = new DListIterator(curr);
				break;
			}
			//pointer moving forward
			curr = curr.nextNode;
		}
		
		//if not found reset everything to null
		if (!found) {
			this.start = null;
			this.end = null;
		}
		
	}

	public void remove(int dec) throws Exception { // this must be the last method in your code!
		// remove data from start to end, inclusive,
		// if start or end is at header, do nothing.
		// size to remove is one of the known parameter -> reduce the size parameter of
		// the list

		//fill code
		//check for null start or end
		if (this.start.equals(null) || this.end.equals(null) || this.start.currentNode.equals(header) || this.end.currentNode.equals(header)) {
			// do nothing
			return;
		} else {
			//declare pointers
			DListNode beforeStart = start.currentNode.previousNode;
			DListNode afterFinal = end.currentNode.nextNode;
			//cut the unwanted section of the list out
			start.currentNode.previousNode = null;
			beforeStart.nextNode = afterFinal;
			end.currentNode.nextNode = null;
			afterFinal.previousNode = beforeStart;
			//change the size
			this.size = this.size() - dec;
			//reset start and end to null
			this.start = null;
			this.end = null;
		}
		
	}

}
