public class CgHashTable<K,V> {

	private class CgHashEntry<K,V> {
		private K key;
		private V value;
		private CgHashEntry<K,V> next;
		
		public CgHashEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	
		public K getKey() {
			return this.key;
		}
		
		public V getValue() {
			return this.value;
		}


		public void setNext(CgHashEntry<K,V> next) { 
			this.next = next;
		}

		public CgHashEntry<K,V> getNext() {
			return this.next;
		}
		
		public boolean hasNext() { 
			return this.next != null;
		}
	}


	private CgHashEntry<K,V>[] table;
	private int capacity;
	private int size;
	
	public CgHashTable(int tableSize) {
		table = new CgHashEntry[tableSize];
		capacity = tableSize;
		size = 0;
	}

	public int size() {
		return size;
	}
	
	public void put (K key, V value) {
		int hashVal = hash(key);
		CgHashEntry<K,V> bucket = table[hashVal];
		
		if (bucket == null) {
			table[hashVal] = new CgHashEntry<K,V>(key,value);
			size++;
			return;
		}
	
		while (bucket.hasNext()) {	
			bucket = bucket.getNext();		
		}
		
		bucket.setNext(new CgHashEntry<K,V>(key,value));
		size++;

		return;	
	}
	
	public V get(K key) {
		int hashVal = hash(key);
		CgHashEntry<K,V> bucket = table[hashVal];

		while (bucket != null) {
			if (bucket.getKey() == key) {
				return bucket.getValue();
			}

			bucket = bucket.getNext();
		}
		
		return null;
		
	}

	public V remove(K key) {
		int hashVal = hash(key);
		CgHashEntry<K,V> bucket = table[hashVal];

		if (bucket != null && bucket.getKey() == key) {
			table[hashVal] = bucket.getNext();
			size--;
			return bucket.getValue();
		}

		CgHashEntry prevBucket;
		while (bucket.hasNext()) {
			prevBucket = bucket;
			bucket = bucket.getNext();
			if (bucket.getKey() == key) {
				prevBucket.setNext(bucket.getNext());
				size--;
				return bucket.getValue();
			}

			bucket = bucket.getNext();
		}
		
		return null;
	}
	
	private int hash(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}

}
