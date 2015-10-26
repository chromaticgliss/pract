import java.lang.reflect.Array;

public class CgArrayList<T> implements CgList<T> {
	
	private T[] list;
	private int current;

	@SuppressWarnings("unchecked")
	public CgArrayList(Class<T> c, int defaultSize) {
		list = (T[]) Array.newInstance(c, defaultSize);
		current = 0;
		return;
	}	
	
	public int size() {
		return current;
	}

	public boolean add(T t) {
		checkAndResizeList();
		list[current] = t;
		current++;
		return true;
	}

	public boolean add(int index, T newVal) {
		checkAndResizeList();	
		T swapVal;

		do {
			swapVal = list[index];
			list[index] = newVal; 
			index++;
			newVal = list[index]; 
			list[index] = swapVal;
			
		} while (index < current);

		current++;
		
		return true;
	}


	public T get(int index) {
		return list[index];
	}

	public T delete(int index) {
		T delItem = list[index];
		int i = index;

		while (i < current) {
			list[i] = list[i+1]; 
			i++;
		}		

		current--;

		return delItem;
	}

	public boolean contains(Object obj) {
		for(int i = 0; list[i] != null; i++) {
			if (obj.equals(list[i])) return true;
		}
		return false;
	}


	@SuppressWarnings("unchecked")
	private void checkAndResizeList() {
		if (current >= list.length) {
			T[] newList = (T[]) Array.newInstance(list.getClass().getComponentType(), list.length * 2);
			System.arraycopy(list, 0, newList, 0, list.length);
			list = newList;
		}

		return;
	}

	
}
