
public class SimulateQueue {

	CustomerInfo[][] allEvents; //events in each and every queue
 
	MyQueue[] allQueues; // queues of people, corresponding to the events

	public SimulateQueue(CustomerInfo[][] allEvents, MyQueue[] allQueues) {
		super();
		this.allEvents = allEvents;
		this.allQueues = allQueues;
	}

	public void stateBeforeTimeT(int t) throws Exception {
		//TODO: implement this method.
		//iterate over all of the queue in counter
		for (int i = 0; i < allQueues.length; i++) {
			//iterate over all event of the specific queue
			for (int j = 0; j < allEvents[i].length; j++) {
				//break if time is more than or equal to T
				if (allEvents[i][j].time >= t) {
					break;
				}
				//insert person
				if (allEvents[i][j].event == 1) {
					allQueues[i].insertLast(j);
				}
				//remove person
				if (allEvents[i][j].event == -1) {
					allQueues[i].removeFirst();
				}
			}
		}
	}
}
