
public class TernaryHeap extends Heap{
	public TernaryHeap() {
		super();
	}
	
	protected void percolateUp() {
		int parent;
		int child = size - 1;
		int temp;
		while (child > 0) {
			parent = (child - 1) / 3;
			if (mData[parent] <= mData[child])
				break;
			temp = mData[parent];
			mData[parent] = mData[child];
			mData[child] = temp;
			child = parent;
		}
	}
	
	@Override
	protected void percolateDown(int start) {
		int parent = start;
		int child = 3 * parent + 1;
		int temp;
		while (child < size) {
			int smallestChild = child;
			if (child + 1 < size && mData[child + 1] < mData[smallestChild]) {
				smallestChild = child + 1;
			}
			if (child + 2 < size && mData[child + 2] < mData[smallestChild]) {
				smallestChild = child + 2;
			}
			if (mData[parent] <= mData[smallestChild])
				break;
			temp = mData[smallestChild];
			mData[smallestChild] = mData[parent];
			mData[parent] = temp;
			parent = smallestChild;
			child = 3 * parent + 1;
		}
	}
}
