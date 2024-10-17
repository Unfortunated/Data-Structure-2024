
public class PointListNode {
	Point data;
	PointListNode nextNode, previousNode;

	PointListNode(Point data) {
		this(data, null, null);
	}

	PointListNode(Point theElement, PointListNode n, PointListNode p) {
		data = theElement;
		nextNode = n;
		previousNode = p;
	}

}
