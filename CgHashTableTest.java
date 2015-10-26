class CgHashTableTest {
	
	public static void main(String args[]) {
		CgHashTable<String,Integer> table = new CgHashTable<>(15);
		Integer emptyTbl = table.get("hey");
		System.out.println("Empty table get: " + emptyTbl);
		table.put("cat",12);
		System.out.println("First put: " + table.get("cat"));
		table.put("dog",15);
		System.out.println("Second put: " + table.get("dog"));
		table.put("frog",16);
		table.put("log",17);
		table.put("fly",18);
		table.put("flew",19);
		table.put("hello",20);
		table.put("goodbye",21);
		table.put("yo",22);
		table.put("ogle",23);
		table.put("puggle",24);
		table.put("gus",25);
		table.put("evie",26);
		table.put("fsh",27);
		table.put("fush",28);
		System.out.println("frog: " + table.get("frog"));
		System.out.println("log: " + table.get("log"));
		System.out.println("fly: " + table.get("fly"));
		System.out.println("flew: " + table.get("flew"));
		System.out.println("hello: " + table.get("hello"));
		System.out.println("goodbye: " + table.get("goodbye"));
		System.out.println("yo: " + table.get("yo"));
		System.out.println("ogle: " + table.get("ogle"));
		System.out.println("puggle: " + table.get("puggle"));
		System.out.println("gus: " + table.get("gus"));
		System.out.println("evie: " + table.get("evie"));
		System.out.println("fsh: " + table.get("fsh"));
		System.out.println("fush: " + table.get("fush"));
	}
}
