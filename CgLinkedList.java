class CgLinkedList<T> implements CgList<T> {

	private class CgListNode<T> {
		private T data;
		private CgListNode<T> next;
		private CgListNode<T> prev;

		public CgListNode(T data, CgListNode<T> next, CgListNode<T> prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;	
		}

		public T getData() {
			return this.data;
		}
		
		public CgListNode<T> getPrev() {
			return this.prev;
		}

		public CgListNode<T> getNext() {
			return this.next;
		}

		public void setData(T data) {
			this.data = data;
		}

		public void setNext(CgListNode<T> next) {
			this.next = next;
		}

		public void setPrev(CgListNode<T> prev) {
			this.prev = prev;
		}
		
	}
	
	private CgListNode<T> head;
	private CgListNode<T> tail;
	private int size;
	
	public CgLinkedList() {
		this.size = 0;
	}


	public boolean add(T t) {
		if (t == null) {
			return false;
		}

		CgListNode<T> newItem = new CgListNode<T>(t, null, null);
		if (this.head == null) {
			this.head = newItem;
			this.tail = newItem;
			size++;
			return true;
		}

		this.tail.setNext(newItem);
		newItem.setPrev(this.tail);
		this.tail = newItem;
		size++;
		return true;
	}


	public boolean add(int index, T t) {
		if (t == null) {
			return false;
		}

		CgListNode<T> newItem = new CgListNode<T>(t, null, null);
		
		if (this.head == null) {
			this.head = newItem;
			size++;
			return true;
		}

		if (t == null) {
			return false;
		}
	
		CgListNode<T> current = this.head;

		for (int i = 0; i<index; i++) {
			current = current.getNext();
		}

		newItem.setPrev(current.getPrev());			
		newItem.setNext(current);

		if (current.getPrev() != null) {
			current.getPrev().setNext(newItem);
		}

		current.setPrev(newItem);	

		if (current == this.tail) {
			this.tail = newItem;
		}
		size++;
		
		return true;	
	}

	public int size() {
		return this.size;
	}


	public T get(int index) {
		if(this.head == null || index >= size || index < 0) {
			return null;
		}
		
		CgListNode<T> current = this.head;

		for (int i = 0; i<index; i++) {
			current = current.getNext();	
		}
		
		return current.getData();
	}

	public T delete(int index) {
		if(this.head == null || index >= size || index < 0) {
			return null;
		}
		
		CgListNode<T> current = this.head;

		for (int i = 0; i<index; i++) {
			current = current.getNext();	
		}

		
		if (current == this.head) {
			CgListNode<T> oldHead = this.head;
			this.head = current.getNext();	
			oldHead.setNext(null);
		} else {
			current.getPrev().setNext(current.getNext());
		}

		if (current == this.tail) {
			this.tail = current.getPrev();
			this.tail.setNext(null);
		} else {
			current.getNext().setPrev(current.getPrev());
		}
		
		current.setNext(null);
		current.setPrev(null);

		size--;
		return current.getData();
	}

	public boolean contains(Object obj) {
		if(this.head == null) {
			return false;
		}	

		CgListNode<T> current = this.head;
		
		for (int i = 0; i<size; i++) {
			if (current.equals(obj)) {
				return true;
			}
		}

		return false;

	}

}
