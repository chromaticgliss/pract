class TowersOfHanoi {
	private class Tower {
		private Stack<Integer> disks;
		private int index;
		
		public Tower(int i) {
			this.index = i;
		}	

		public int index() {
			return this.index;
		}

		public void add(int disk) {
			if (!disks.isEmpty() && disks.peek() <= disk) {
				System.out.println("Cannot place disk");
			} else {
				disks.push(disk);
			}
		}


		public void moveTopTo(Tower t) {
			if (!disks.isEmpty()) {
				int disk = disks.pop();
				t.add(disk);
			} else {
				System.out.println("No disks in tower");
			}
		}


		public void moveDisks(int n, Tower destination, Tower buffer) {
			if (n > 0) {
				this.moveDisks(n - 1, buffer, destination);
				this.moveTopTo(destination);
				buffer.moveDisks(n - 1, destination, this);
			}
		}
}


