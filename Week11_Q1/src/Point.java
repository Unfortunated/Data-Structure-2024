import java.util.Objects;

public class Point {
	int value;
	int nextValue;
	int preValue;
	
	public Point(int value, int nextValue, int preValue) {
		super();
		this.value = value;
		this.nextValue = nextValue;
		this.preValue = preValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return nextValue == other.nextValue && preValue == other.preValue && value == other.value;
	}
	
	
	
	
	
	

}
