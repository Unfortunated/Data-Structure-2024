
public class HashIterator implements Iterator {

	OpenAddressing h; // the associated hash table
	int currentPos;   // position in the table's array that is currently marked.

	
	//Create an iterator that marks the leftmost actual data in the hash table.
	//Assume actual data are not 0 and DELETED.
	//If there are no actual data in the table, set currentPos to -1.
	public HashIterator(OpenAddressing o) {
		h = o;
		int i = 0;
		for (; i < o.array.length; i++) {
			if (o.array[i] != 0 && o.array[i] != OpenAddressing.DELETED) {
				currentPos = i;
				break;
			}
		}
		if (i >= o.array.length) {
			currentPos = -1;
		}
	}

	@Override
	public boolean hasNext() {
		//mark the next location to search so +1
		int i = this.currentPos+1;
		//use for loop to iterate through each element to find actual value
		for (; i < h.array.length; i++) {
			//return if the next actual value is found
			if (h.array[i] > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean hasPrevious() {
		//mark the next location to search so -1
		for (int i = this.currentPos -1; i >= 0; i --) {
			//return if the next actual value is found
			if (h.array[i] > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int next() throws Exception {
		if (this.hasNext()) {
			//mark the next location to search so +1
			this.currentPos += 1;
			//increment current position till the next actual value
			while (!(h.array[this.currentPos] > 0)) {
				this.currentPos++;
			}
			//return next actual value
			return h.array[this.currentPos];
		} else {
			throw new Exception("not found");
		}
		
	}

	@Override
	public int previous() throws Exception {
		if (this.hasPrevious()) {
			//mark the current position
			int storage = this.currentPos;
			//mark the next position to search so -1
			this.currentPos -= 1;
			//decrement till found new data
			while (!(h.array[this.currentPos] > 0)) {
				this.currentPos--;
			}
			//return stored data
			return h.array[storage];
		} else {
			throw new Exception();
		}
	}

	@Override
	public void set(int value) {
		// does not do anything,
		//because it will break hash table definition

	}

}
