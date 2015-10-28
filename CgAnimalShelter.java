class CgAnimalShelter {
	public class abstract Animal {
		private int order;
		protected String name;
		
		public Animal(String n) {
			this.name = n;
		}

		public void setOrder(int o) {
			this.order = o;
		}	

		public int getOrder() {
			return this.order;		
		} 

	}

	public class Dog extends Animal {
		public Dog(String n) {
			super(n);
		}
	}

	public class Cat extends Animal {
		public Cat(String n) {
			super(n);
		}
	}

	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	int orderStamp = 0;


	public Animal dequeueAny() {
		if (dogs.size() == 0) {
			return cats.poll();
		} else if (cats.size() == 0) {
			return dogs.poll();
		}

		Dog dog = dogs.peek();
		Cat cat = cats.peek();

		if (dog.getOrder() < cat.getOrder()) {
			return dogs.poll();
		} else {
			return cats.poll();
		}
	}

	public Dog dequeueDog() {
		return dogs.poll();
	}

	public Cat dequeueCat() {
		return cats.poll();
	}
	
	public void enqueue(Dog d) {
		d.setOrder(orderStamp);
		dogs.add(d);
		orderStamp++;
	}
	
	public void enqueue(Cat c) {
		c.setOrder(orderStamp);
		cats.add(c);
		orderStamp++;
	}
}
