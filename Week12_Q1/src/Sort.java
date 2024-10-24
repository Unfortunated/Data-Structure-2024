public class Sort {
	//Hint: You can create other methods and then use sortFrequency to call them.

	public static int[] sortFrequency(int[] x) {
		//use helper function to create PairArray
		Pair [] pairArray = createPairArray(x);
		//use helper function to sort
		pairArray = mergeSort(pairArray,0,pairArray.length-1);
		//get rid of element with zero frequency
		int countNonZeroes = 0;
		for (int i = 0; i<pairArray.length; i++) {
			if (pairArray[i].freq > 0) {
				countNonZeroes += 1;
			}
		}
		//prepare element
		int [] result = new int[countNonZeroes];
		for (int i = 0; i<result.length; i++) {
			result[i] = pairArray[i].value;
		}
		return result;
	}
	
	public static Pair [] createPairArray(int[] x) {
		Pair [] pairArray = new Pair [10];
		//initialize array
		for (int i = 0; i<pairArray.length; i++) {
			pairArray[i] = new Pair(i+1,0);
		}
		//increment each frequency when found
		for (int i = 0; i<x.length; i++) {
			if (x[i] == 1) {
				pairArray[0].freq += 1;
			}
			if (x[i] == 2) {
				pairArray[1].freq += 1;
			}
			if (x[i] == 3) {
				pairArray[2].freq += 1;
			}
			if (x[i] == 4) {
				pairArray[3].freq += 1;
			}
			if (x[i] == 5) {
				pairArray[4].freq += 1;
			}
			if (x[i] == 6) {
				pairArray[5].freq += 1;
			}
			if (x[i] == 7) {
				pairArray[6].freq += 1;
			}
			if (x[i] == 8) {
				pairArray[7].freq += 1;
			}
			if (x[i] == 9) {
				pairArray[8].freq += 1;
			}
			if (x[i] == 10) {
				pairArray[9].freq += 1;
			}
		}
		return pairArray;
	}
	
	public static Pair[] mergeSort(Pair[] a, int left, int right) {
		if (left == right) {
			Pair[] x = new Pair[1];
			x[0] = a[left];
			return x;
		} else if (left < right) {
			int center = (left+right)/2;
			Pair[] result1 = mergeSort(a,left,center);
			Pair[] result2 = mergeSort(a,center+1,right);
			return merge(result1,result2);
		}
		return a;
	}
	
	public static Pair[] merge(Pair[] a, Pair[] b) {
		int aIndex = 0; int bIndex = 0; int cIndex = 0;
		int aLength = a.length;
		int bLength = b.length;
		int cLength = aLength + bLength;
		Pair[] c = new Pair[cLength];
		
		while((aIndex < aLength) && (bIndex < bLength)) {
			//modify this to sort the array
			//put on left
			if (a[aIndex].compare(b[bIndex]) == -1) {
				c[cIndex++] = a[aIndex++];
			} else {
				c[cIndex++] = b[bIndex++];
			}
		}
		
		if (aIndex == aLength) {
			while (bIndex<bLength) {
				c[cIndex++] = b[bIndex++];
			}
		} else {
			while (aIndex<aLength) {
				c[cIndex++] = a[aIndex++];
			}
		}
		return c;
	}
}
