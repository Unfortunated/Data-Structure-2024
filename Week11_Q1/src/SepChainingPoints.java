
public class SepChainingPoints {
	private static int DEFAULT_SIZE = 101;
	private static int MAXLOAD = 10;
	private PointsLinkedList2[] lists;
	private int currentSize = 0;

	public SepChainingPoints() {
		this(DEFAULT_SIZE);
	}

	public SepChainingPoints(int size) {
		int nextPrimeSize = nextPrime(size);
		lists = new PointsLinkedList2[nextPrimeSize];
		for (int i = 0; i < lists.length; i++)
			lists[i] = new PointsLinkedList2();
	}

	private static boolean isPrime(int n) {
		if (n == 2 || n == 3)
			return true;
		if (n == 1 || n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}

	private static int nextPrime(int n) {
		if (n % 2 == 0)
			n++;
		for (; !isPrime(n); n += 2) {
		}
		return n;
	}

	public int hash(Point data) {
		int hashValue = data.value;
		int abs = Math.abs(hashValue);
		return abs % lists.length;
	}

	// Position of that exact data in that list
	public int find(Point data) throws Exception {
		int pos = hash(data);
		PointsLinkedList2 theList = lists[pos];
		return theList.find(data);
	}

	// Find out if a hashed list contains data with the same main value (but
	// different
	// nextValue or preValue).
	public boolean pointValueExist(Point data) throws Exception {
		int pos = hash(data);
		PointsLinkedList2 theList = lists[pos];
		return theList.pointValueExist(data);
	}

	public void add(Point data) throws Exception {
		int pos = hash(data);
		PointsLinkedList2 theList = lists[pos];
		if (theList.find(data) == -1) { // not found
			PointListIterator itr = new PointListIterator(lists[pos].header);
			lists[pos].insert(data, itr);
			currentSize++;
		}
		if (currentSize / lists.length >= MAXLOAD) {
			rehash();
		}
	}

	public void rehash() throws Exception {
		PointsLinkedList2[] oldLists = lists;
		int newLength = nextPrime(2 * lists.length);
		lists = new PointsLinkedList2[newLength];
		for (int i = 0; i < lists.length; i++) {
			lists[i] = new PointsLinkedList2();
		}
		for (int i = 0; i < oldLists.length; i++) {
			PointListIterator itr;
			itr = new PointListIterator(oldLists[i].header);
			while (itr.currentNode.nextNode != oldLists[i].header) {
				add(itr.next());
			}
		}
	}

	

}
