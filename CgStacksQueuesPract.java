class CgStacksQueuesPract {
	
	public class CgNode<T> {
		public T data;
		public CgNode<T> next;

		public CgNode<T>(T data, CgNode<T> next) {
			this.data = data;
			this.next = next;
		}
	}	
	
	private class CgStack<T> {
		CgNode<T> head;
		int size;

		public CgStack<T>() {
			head = null;
			size = 0;
		}

		public void push(T item) {
			CgNode<T> t = new CgNode<T>(item,null)
			t.next = this.head;
			this.head = t;
			++this.size;
		}

		public T pop() {
			if (head == null) {
				return null
			}

			T item = this.head.data;
			this.head = this.head.next;
			--this.size;
			return head;
		}

		public T peek() {
			if (head == null) {
				return null
			}
		
			T item = this.head.data;
			return item;
		}
	}

	private class CgQueue<T> {
		CgNode<T> first = null;
		CgNode<T> last = null;
		int size = 0;

		public void enqueue(T item) {

			CgNode<T> t = new CgNode<T>(item,null);

			if(this.first == null) {
				this.first = t;
				this.last = this.first;
				return;
			}
			
			this.last.next = t;
			this.last = this.last.next;
			return;
		}

		public T dequeue() {
			if (first != null) {
				T t = this.first.data	
				this.first = this.first.next;
				return t;
			}	

			return null;
		}
	}
	
	// We will use integers for simplicity
	// 3 stacks implemented on one array....fixed width
	private class CgTripStack {
		int stackSize = 100;
		int[] pointers = {0, 0, 0};
		int[] stacks = new int[stackSize * 3];

		public void push(int stackNum, int item) {
			if( pointers[stackNum] >= stackSize) {
				throw new Exception("Stack full. Sorry.");
			}
		
			int index = stackNum * stackSize + pointer[stackNum];
			this.stacks[index] = item;
			++pointers[stackNum];
		}

		public T pop(int stackNum) {
			if (pointers[stackNum] <= 0) {
				throw new Exception ("No data to pop.");
			}
			
			--pointers[stackNum];
			int index = stackNum * stackSize + pointers[stackNum];
			return stacks[index];
		}

		public T peek(int stackNum) {
			int index = stackNum * stackSize + pointers[stackNum] - 1;
			return stacks[index];
		}

	}
	
	// Keeps track of what the minimum element is
	// Uses two stacks, one tracking sequence of mins
	public class CgMinStack<T> {
		private CgStack<T> minStack = new CgStack<T>();
		private CgStack<T> stack = new CgStack<T>();

		public void push(T item) {
			if (item <= stack.peek()) {
				minStack.push();
			}

			stack.push();			
		}

		public T pop() {
			T item = stack.pop();

			if (item == minStack.peek()) {
				minStack.pop();
			}

			return item;
		}

		public T peek() {
			return stack.peek();
		}
	}
	
	// Simulate plate stacks at a buffet.
	// As one stack fills, begin another. Remove in LIFO order still.
	// Has capability to remove from particular stack.
	public class SetOfStacks {
		ArrayList<CgStack<Integer>> stacks;
		
		public SetOfStacks() {
			stacks = new ArrayList<CgStack<Integer>>();
		}

		
	}	
}
