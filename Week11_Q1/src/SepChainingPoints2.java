
public class SepChainingPoints2 extends SepChainingPoints {
	//Implement this method. 
		public boolean isCrossRoad(Point p) throws Exception {
			//store value into hash table
			this.add(p);
			//use method pointValueExist
			return pointValueExist(p);
		}
}
