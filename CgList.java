public interface CgList<T> {
	boolean  add(T t);
	boolean  add(int index, T t);
	int size();
	T get(int index);
	T delete(int index); 
	boolean contains(Object obj);
}
