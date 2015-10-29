class CgTreeGraphPract {
	
	public class CgTreeNode<T> {
		public CgTreeNode left;
		public CgTreeNode right;
		public T data;
		
		public CgTreeNode(T t) {
			this.data = t	
		}
	}

	// Pair of functions to determine if a tree is balanced.
	// A balanced tree has subtrees with heights differing by
	// no more than one. 
	public boolean isBalanced(CgTreeNode root) {
		if (root == null) {
			return true;
		}

		int height = checkHeight(root);

		return height != -1
	}

	public int checkHeight(CgTreeNode root) {
		if (root == null) {
			return 0;
		}

		int heightLeft = checkHeight(root.left);
		if (heightLeft == -1) {
			return -1;
		}

		int heightRight = checkHeight(root.right);
		if (heightRight == -1) {
			return -1;
		}

	

		if (Math.abs(heightLeft - heightRight) > 1) {
			return -1
		}

		return Math.max(heightLeft,heightRight) + 1;
	}

	// Given a directed graph, an algorithm to find out
	// whether there is a path between two nodes.

}
