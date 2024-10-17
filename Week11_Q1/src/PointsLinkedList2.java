
public class PointsLinkedList2 extends PointsLinkedList{
	// Write this method
		// Find if there is a point in a linked list with the same value as p,
		// but with different nextValue or different preValue

		public boolean pointValueExist(Point p) throws Exception {
			//tracker to check all the value in the list
			PointListNode tracker = header.nextNode;
			//loop till no more element
			while (tracker != null && tracker.data != null) {
				//check value then check to see if next value & previous value is equal
				if (tracker.data.value == p.value && (!tracker.data.equals(p))) {
					return true;
				}
				tracker = tracker.nextNode;
			}
			return false;
		}
	
	
}
