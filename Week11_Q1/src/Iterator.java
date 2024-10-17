public interface Iterator {

	public boolean hasNext();

	public boolean hasPrevious();

	// Move iterator to the next position,
	// then returns the value at that position.
	public Point next() throws Exception; 
	                    
	// Return the value at current position,
	// then move the iterator back one position.
	public Point previous() throws Exception;
	                        
	public void set(Point value);

}
