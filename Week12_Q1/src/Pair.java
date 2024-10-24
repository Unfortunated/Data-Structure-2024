
public class Pair {
	int value;
	int freq;
	
	public Pair(int v, int f) {
		value = v;
		freq = f;
	}
	
	//Additional method(s) can be written below.
	
	public int compare(Pair y) {
		//check frequency
		if (this.freq != y.freq) {
			//if frequency alot just put it in front
			if (this.freq > y.freq) {
				return -1;
			} else {
				return 1;
			}
		} else {
			//place small value first then big
			if (this.value < y.value) {
				return -1;
			} else {
				return 1;
			}
		}
	}
}
