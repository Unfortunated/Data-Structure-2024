import java.util.Arrays;
public class Heap {
	int[] mData;
	int size = 0;

	public Heap() {
		final int DEFAULT_CAPACITY = 11;
		mData = new int[DEFAULT_CAPACITY];
	} // default constructor

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(int element) {
		if (++size == mData.length) {
			int[] newHeap = new int[2 * mData.length];
			System.arraycopy(mData, 0, newHeap, 0, size);
			mData = newHeap;
		}
		mData[size - 1] = element;
		percolateUp();
		
		// modified part is to be written below
		int maxIndex = findMax();
		//if last data is not max
		if (this.mData[size-1] != this.mData[maxIndex]) {
			//swap data
			int temp = mData[size-1];
			mData[size-1] = mData[maxIndex];
			mData[maxIndex] = temp;
			//reduce size to percolate up exclude last element
			this.size--;
			percolateUp();
			//change size back to normal
			this.size++;
		}
		percolateUp();
	}
	
	//helper function
	public int findMax() {
		int maxIndex = 0;
		for (int i = 0; i<this.size; i++) {
			if (this.mData[i] > this.mData[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	protected void percolateUp() {
		int parent;
		int child = size - 1;
		int temp;
		while (child > 0) {
			parent = (child - 1) / 2;
			if (mData[parent] <= mData[child])
				break;
			temp = mData[parent];
			mData[parent] = mData[child];
			mData[child] = temp;
			child = parent;
		}
	}

	public int top() throws Exception {
		if (size == 0)
			throw new Exception("Empty");
		return mData[0];
	}

	// never get called in our program
	public int pop() throws Exception {
		if (size == 0)
			throw new Exception("Priority queue empty.");
		int minElem = mData[0];
		mData[0] = mData[size - 1];
		size--;
		percolateDown(0);
		return minElem;
	}

	protected void percolateDown(int start) {
		int parent = start;
		int child = 2 * parent + 1;
		int temp;
		while (child < size) {
			if (child < size - 1 && mData[child] > mData[child + 1])
				child++;
			if (mData[parent] <= mData[child])
				break;
			temp = mData[child];
			mData[child] = mData[parent];
			mData[parent] = temp;
			parent = child;
			child = 2 * parent + 1;
		}
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}


}
