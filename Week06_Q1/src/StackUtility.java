
public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {
		if (s1.isEmpty() || s2.isEmpty()) {
			return "";
		}
		MyStack s3 = new StackLinkedList();
		s3.makeEmpty();
		//check s2 & s1 must not be empty and (s1 not equal 1 or s2 is empty)
		while ((!s2.isEmpty() && !s1.isEmpty()) && !(s1.size() == 1 && !s2.isEmpty())) {
			//condition operator
			int condition = s2.top();
			s2.pop();
			//condition > 0 indicates add
			if (condition >= 0) {
				//pop first element
				int temp = s1.top();
				s1.pop();
				//get second element and add it with first
				s3.push(temp+s1.top());
				//pop second element
				s1.pop();
			} else {
				//pop first element
				int temp = s1.top();
				s1.pop();
				//get second element and subtract it with first
				s3.push(temp-s1.top());
				//pop second element
				s1.pop();
			}
		}
		//empty string for output
		String output = "";
		//fill out the string with character
		while(!s3.isEmpty()) {
			output += alphabets.charAt(s3.top());
			s3.pop();
		}
		return output;
	}
}
