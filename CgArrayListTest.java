public class CgArrayListTest {
	public static void main(String[] args) {
		CgList<String> myList = new CgArrayList<String>(String.class,10);
		myList.add("A");
		myList.add("B");
		myList.add("C");
		myList.add(2,"Q");

		
		for(int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
		}
		
		System.out.println("Size: " + myList.size());
		System.out.println("Deleted: " + myList.delete(1));
		
		myList.add(0,"Tits");
		System.out.println(myList.get(0));
		
		for(int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
		}
	}
}

