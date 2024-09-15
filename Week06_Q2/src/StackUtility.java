
public class StackUtility {

	public static MyStack removeRange(MyStack s, int i, int j) throws Exception {
		MyStack temp = new StackLinkedList();
		int counter = 0;
		//keep the included data in temp stack
		while (counter != i) {
			temp.push(s.top());
			s.pop();
			counter++;
		}
		//if i = j just get rid of it then get data from temp back
		if (i == j) {
			s.pop();
			while (!temp.isEmpty()) {
				s.push(temp.top());
				temp.pop();
			}
		//else just keep on removing till j element
		} else {
			while (i != j+1) {
				s.pop();
				i++;
			}
			//get data back from temp stack
			while (!temp.isEmpty()) {
				s.push(temp.top());
				temp.pop();
			}
		}
		return s;
	}
}
