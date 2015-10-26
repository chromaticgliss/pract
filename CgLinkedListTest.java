class CgLinkedListTest {
	public static void main(String args[]) {
		CgList<String> theList = new CgLinkedList<>();
		theList.add("hello world");
		System.out.println(theList.get(0));
		theList.add("hello venus");
		System.out.println(theList.get(1));
		theList.add("hello mars");
		System.out.println(theList.get(2));
		theList.add(1,"hello sun");
		System.out.println(theList.get(1));

		theList.delete(2);
		System.out.println(theList.get(2));
		System.out.println(theList.get(1));	
	}
}
