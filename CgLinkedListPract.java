class CgLinkedListPract {
	public class ListNode<T> {
		public ListNode next = null;
		T data;
		
		public ListNode<T>(T d) {
			this.data = d;
		}

		public void append(T d) {
			ListNode<T> end = new ListNode<T>(d);
			ListNode<T> n = this;
			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
			return;
		}
	}

	public ListNode<T> deleteNode(ListNode<T> head, int d) {
		ListNode<T> n = head;
		if (n.data == d) {
			return head.next
		}

		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}

		return head;
	}

	//runs in O(n^2) HashMap improves to O(n)
	public ListNode<T> removeDuplicates(ListNode<T> head) {
		ListNode<T> n = head;
		
		if (n = null) {
			return null;
		}


		while (n != null) {

			ListNode<T> prevRun = n;
			ListNode<T> runner = n.next;
			while (runner != null) {
				if (runner.data.equals(n.data)) {
					prevRun.next = runner.next;					
				}

				prevRun = runner;
				runner = runner.next;
			}

			n = n.next;
		}
	}

	public ListNode<T> findKthElement(ListNode<T> head, int k) {
		ListNode<T> n = head;
		
		for(int i=0; i < k-1; i++) {
			if (n == null) return null;	
			n = n.next;
		}

		ListNode<T> kNode = head;

		while (n != null) {
			n = n.next;
			kNode = kNode.next;
		}

		return kNode;
	}

	public void deleteGiven(ListNode<T> node) {
		if (node = null || node.next = null) {
			return;
		}

		node.data = node.next.data;
		node.next = node.next.next;

		return;
	} 

	public ListNode partition(ListNode<Integer> head, Integer x) {
	
		if(head = null) return;
		
		ListNode<Integer> less = null;
		ListNode<Integer> more = null;
	
		ListNode<Integer> runner = head;
		ListNode<Integer> nextRun = null;
		ListNode<Integer> newHead = null;

		while (runner != null) {
			nextRun = runner.next;

			if (runner.data.compareTo(x) < 0) {
				if (less == null) {
					less = runner;
					newHead = less;
					continue;
				}
					
				less.next = runner;
				less = runner;		
			} else {
				if (more = null) {
					more = runner;
					continue;
				}
				
				runner.next = more;
				more = runner
			}

			runner = nextRun;
		}

		less.next = more;
		if (newHead == null) newhead = more;
		return newHead
	}

	public ListNode<Integer> add(ListNode<Integer> x, ListNode<Integer> y) {
		ListNode<Integer> runx = x;
		ListNode<Integer> runy = y;		
		ListNode<Integer> sum = null;
		int carry = 0;

		while (runx != null && runy != null) {
			ListNode<Integer> digit;
			int i = runx.data + runy.data + carry;
			int carry = i / 10;
			digit.data = i % 10;
			digit.next = sum;
			sum = digit; 
			runx = runx.next;
			runy = runy.next;
		}

		while (runx != null) {
			ListNode<Integer> digit;
			digit.data = runx.data;
			digit.next = sum;
			sum = digit;
			runx = runx.next;
		}

		while (runy != null) {
			ListNode<Integer> digit;
			digit.data = runy.data;
			digit.next = sum;
			sum = digit;
			runy = runy.next;
		}


		return sum;
	}
}

