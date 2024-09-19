import java.util.ArrayList;
public class BankQueue { // must work for any implementation of DeQ
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	//Write this method
	public void distribute() throws Exception {
		//find needed queue length
		float nql = 0;
		for (DeQ q : counters) {
			nql += q.size();
		}
		nql = Math.round(nql/(counters.length+1));
		
		//arraylist to store excess element and moved to track movement
		ArrayList<Integer> storage = new ArrayList<Integer>();
		boolean moved = false;
		
		//to rearrange element in each queue
		for (DeQ q : counters) {
			//stop when special size is nql
			if (special.size() == nql) {
				break;
			}
			//store excess data
			while (q.size() > nql) {
				storage.add(q.removeLast());
			}
			
			//move excess data to special queue
			while (storage.size() > 0 && special.size() < nql) {
				special.insertLast(storage.get(storage.size()-1));
				storage.remove(storage.size()-1);
				moved = true;
			}
			
			//move remaining excess data back to same queue
			while (storage.size() > 0) {
				q.insertLast(storage.get(storage.size()-1));
				storage.remove(storage.size()-1);
				moved = true;
			}
		}
		//if not moved move last element of last queue to special
		if (!moved) {
			special.insertLast(counters[counters.length-1].removeLast());
		}
	}
}

