

public class SelectionSort {

	public static void selectionSort(int[] a) {
		int maxindex; // index of the largest value
		for (int unsorted = a.length; unsorted > 1; unsorted--) {
			maxindex = 0;
			for (int index = 1; index < unsorted; index++) {
				if (a[maxindex] < a[index])
					maxindex = index;
			}
			if (a[maxindex] != a[unsorted - 1])
				swap(a, maxindex, unsorted - 1);
		}
	}

	private static void swap(int[] a, int pos1, int pos2) {
		int temp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = temp;
	}

	// a modified selection sort to be put here
	public static void selectionSort(int[] a, int l, int r) {
		int maxindex; // index of the largest value
		//rightmost is r leftmost is l so bound at l
	    for (int unsorted = r; unsorted > l; unsorted--) {
	    	//start index at l
	        maxindex = l;
	        //algorithm start at l+1
	        for (int index = l+1; index <= unsorted; index++) {
	            if (a[maxindex] < a[index])
	                maxindex = index;
	        }
	        // Swap the largest found with the last element of unsorted part
	        if (maxindex != unsorted)
	            swap(a, maxindex, unsorted);
	    }
	}
}
