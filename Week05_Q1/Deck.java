public class Deck extends DeQLinkedList{
	
	public Deck() {
		
	}
	
	public void putBottom(int n) {
		try {
			this.insertLast(n);
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int draw() {
		if (this.isEmpty()) {
			return -1;
		}
		try {
			return this.removeFirst();
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int removeNth(int n) {
		if (n >= this.size()) {
			return -1;
		} else {
			int counter = 0;
			while (counter != n) {
				try {
					int temp = this.removeFirst();
					this.insertLast(temp);
					counter++;
				} catch (EmptyQueueException e) {
					// TODO Auto-generated catch block
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			int card = this.draw();
			while (counter != 0) {
				try {
					int temp = this.removeLast();
					this.insertFirst(temp);
					counter--;
				} catch (EmptyQueueException e) {
					// TODO Auto-generated catch block
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return card;
		}
	}
	
	public void reverseTopN(int n) {
		if (this.isEmpty()) {
			return;
		}
		if (n-1 >= this.size()) {
			n = this.size();
			DListNode currNode = theList.header.nextNode;
			DListNode prevNode = null;
			
			while (currNode != null && n != 0) {
				prevNode = currNode.previousNode;
				currNode.previousNode = currNode.nextNode;
				currNode.nextNode = prevNode;
				
				currNode = currNode.previousNode;
				n--;
			}
			
			theList.header.nextNode = prevNode.previousNode;
			
		} else {
			try {
				int loop;
				if (n <= this.size()) {
					loop = n;
				} else {
					loop = this.size();
				}
				for (int c = loop - 1; c >= 0; c--) {
					int temp = removeNth(c);
					this.insertLast(temp);
				}

				for (int i = 0; i < this.size() - n; i++) {
					int temp = this.front();
					this.removeFirst();
					this.insertLast(temp);
				}

			} catch (EmptyQueueException e) {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
